package me.jessyan.mvparms.demo.mvp.contract;

import android.content.Context;

import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.List;

import io.reactivex.Observable;
import me.jessyan.mvparms.demo.mvp.model.entity.BaseResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.ChatSessionBean;
import retrofit2.http.Query;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 05/08/2020 17:01
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public interface MainContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        Context getActivity();

        XRecyclerView getRecyclerView();

    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        Observable<BaseResponse<List<ChatSessionBean>>> getChatSessionList(int session_typee);

    }
}
