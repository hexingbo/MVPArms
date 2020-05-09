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
package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DeviceUtils;
import com.jess.arms.utils.LogUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;
import com.zhouyou.recyclerview.adapter.HelperStateRecyclerViewAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.common.ChatMsgType;
import me.jessyan.mvparms.demo.app.utils.TimeConverterUtil;
import me.jessyan.mvparms.demo.mvp.model.entity.ChatSessionBean;

/**
 * ================================================
 * 展示 {@link DefaultAdapter} 的用法
 * <p>
 * Created by JessYan on 09/04/2016 12:57
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class ChatSessionAdapter extends HelperStateRecyclerViewAdapter<ChatSessionBean> {

    private AppComponent mAppComponent;
    /**
     * 用于加载图片的管理类, 默认使用 Glide, 使用策略模式, 可替换框架
     */
    private ImageLoader mImageLoader;

    private ImageView mImgHead;
    private TextView mTvTime;
    private TextView mTvNice;
    private TextView mTvContent;

    public ChatSessionAdapter(List<ChatSessionBean> list, Context context) {
        super(list, context, R.layout.item_chatsession_list);
        //可以在任何可以拿到 Context 的地方, 拿到 AppComponent, 从而得到用 Dagger 管理的单例对象
        mAppComponent = ArmsUtils.obtainAppComponentFromContext(context);
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, ChatSessionBean data) {
        initView(viewHolder.itemView);
        mTvNice.setText(data.getTitle());
        if (ArmsUtils.isEmpty(data.getLastMessage()))
            mTvContent.setText("");
        else {
            mTvContent.setText(ChatMsgType.getMsgContent(data.getLastMessage().getMsgType(), data.getLastMessage().getMsg()));
        }

        //设置最后一条消息的时间
        String strtime = data.getLastMsgTime();
        String str = strtime.contains("T") ? "q             " : " ";
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
                mTvTime.setText(local.substring(11, local.length()));
            } else if (gapCount <= 3) {
                mTvTime.setText(gapCount + "天前");
            } else {
                mTvTime.setText(strDate);
            }

        }
        String url = ArmsUtils.isEmpty(data.getGroupinfo()) ? data.getHead() : data.getGroupinfo().getHead();
        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
        LogUtils.debugInfo("headUrl：" + url);
        mImageLoader.loadImage(mImgHead.getContext(),
                ImageConfigImpl
                        .builder()
                        .url(url)
                        .isCircle(true)
                        .imageView(mImgHead)
                        .build());

    }

    @Override
    public View getEmptyView(ViewGroup parent) {
        return mLInflater.inflate(R.layout.view_custom_data_empty, parent, false);
    }

    @Override
    public View getErrorView(ViewGroup parent) {
        if (DeviceUtils.hasInternet(mAppComponent.application())) {
            return mLInflater.inflate(R.layout.view_custom_data_error, parent, false);
        }
        return mLInflater.inflate(R.layout.view_custom_network_error, parent, false);
    }

    @Override
    public View getLoadingView(ViewGroup parent) {
        return mLInflater.inflate(R.layout.view_custom_data_loading, parent, false);
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

    private void initView(View view) {
        mImgHead = (ImageView) view.findViewById(R.id.img_head);
        mTvTime = (TextView) view.findViewById(R.id.tv_time);
        mTvNice = (TextView) view.findViewById(R.id.tv_nice);
        mTvContent = (TextView) view.findViewById(R.id.tv_content);
    }

}