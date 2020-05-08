/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.mvparms.demo.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.utils.TimeConverterUtil;
import me.jessyan.mvparms.demo.mvp.model.entity.ChatSessionBean;

/**
 * ================================================
 * 展示 {@link BaseHolder} 的用法
 * <p>
 * Created by JessYan on 9/4/16 12:56
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class ChatSessionItemHolder extends BaseHolder<ChatSessionBean> {

    @BindView(R.id.img_head)
    ImageView mHead;
    @BindView(R.id.tv_time)
    TextView mTime;
    @BindView(R.id.tv_nice)
    TextView mNice;
    @BindView(R.id.tv_content)
    TextView mContent;

    private AppComponent mAppComponent;
    /**
     * 用于加载图片的管理类, 默认使用 Glide, 使用策略模式, 可替换框架
     */
    private ImageLoader mImageLoader;

    public ChatSessionItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到 Context 的地方, 拿到 AppComponent, 从而得到用 Dagger 管理的单例对象
        mAppComponent = ArmsUtils.obtainAppComponentFromContext(itemView.getContext());
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(@NonNull ChatSessionBean data, int position) {
        mNice.setText(data.getTitle());
        if (!ArmsUtils.isEmpty(data.getLastMessage()))
            mContent.setText(data.getLastMessage().getMsg());

        //设置最后一条消息的时间
        String strtime = data.getLastMsgTime();
        String str=strtime.contains("T")?"q             ":" ";
        if (strtime.contains(str)) {
            String strDate = strtime.substring(5, strtime.indexOf(str));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            Date date_start = null;
            try {
                date_start = sdf.parse(strtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int gapCount = getGapCount(date_start);
            if (gapCount == 0) {
                String local = TimeConverterUtil.utc2Local(strtime, "yyyy-MM-dd HH:mm");
                mTime.setText(local.substring(11, local.length()));
            } else if (gapCount <= 3) {
                mTime.setText(gapCount + "天前");
            } else {
                mTime.setText(strDate);
            }

        }
        
        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
        mImageLoader.loadImage(itemView.getContext(),
                ImageConfigImpl
                        .builder()
                        .url(data.getHead())
                        .imageView(mHead)
                        .build());
    }

    /**
     * 在 Activity 的 onDestroy 中使用 {@link DefaultAdapter#releaseAllHolder(RecyclerView)} 方法 (super.onDestroy() 之前)
     * {@link BaseHolder#onRelease()} 才会被调用, 可以在此方法中释放一些资源
     */
    @Override
    protected void onRelease() {
        //只要传入的 Context 为 Activity, Glide 就会自己做好生命周期的管理, 其实在上面的代码中传入的 Context 就是 Activity
        //所以在 onRelease 方法中不做 clear 也是可以的, 但是在这里想展示一下 clear 的用法
        mImageLoader.clear(mAppComponent.application(), ImageConfigImpl.builder()
                .imageViews(mHead)
                .build());
        this.mHead = null;
        this.mNice = null;
        this.mTime = null;
        this.mContent = null;
        this.mAppComponent = null;
        this.mImageLoader = null;
    }

    /**
     * 获取两个日期之间的间隔天数
     *
     * @return
     */
    public static int getGapCount(Date startDate) {
        Date endDate = new Date(System.currentTimeMillis());
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }
}
