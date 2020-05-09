package me.jessyan.mvparms.demo.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;
import com.zhouyou.recyclerview.adapter.HelperStateRecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.mvparms.demo.mvp.contract.MainContract;
import me.jessyan.mvparms.demo.mvp.model.entity.BaseResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.ChatSessionBean;
import me.jessyan.mvparms.demo.mvp.ui.adapter.ChatSessionAdapter;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


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
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    List<ChatSessionBean> mList;
    @Inject
    ChatSessionAdapter mAdapter;

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mAdapter = null;
        this.mList = null;
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mApplication = null;
    }

    public void getChatSessionList(boolean pullToRefresh) {
        mModel.getChatSessionList(2)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(1, 1))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
//                        mRootView.showLoading();//显示下拉刷新的进度条
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                        mRootView.hideLoading();//隐藏下拉刷新的进度条
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<BaseResponse<List<ChatSessionBean>>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<List<ChatSessionBean>> result) {
                        if (result.isSuccess()) {
                            if (pullToRefresh) {
                                mAdapter.setListAll(result.getData());//不需要设置任何东西setListAll有数据了会自动到内容页面
                                if (ArmsUtils.isEmpty(result.getData())){
                                    mAdapter.setState(HelperStateRecyclerViewAdapter.STATE_EMPTY);
                                }
                            } else {
                                mAdapter.addItemsToLast(result.getData());
                            }
                        }else {
                            mRootView.showMessage(result.getMsg());
                            mAdapter.setState(HelperStateRecyclerViewAdapter.STATE_ERROR);
                        }
                        mRootView.getRecyclerView().setLoadingMoreEnabled(false);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        mRootView.showMessage(t.getMessage());
                        if (pullToRefresh) {
                            mAdapter.setState(HelperStateRecyclerViewAdapter.STATE_ERROR);
                        }
                    }
                });
    }
}
