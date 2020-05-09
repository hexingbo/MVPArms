package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperStateRecyclerViewAdapter;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.utils.LayoutManagerUtil;
import me.jessyan.mvparms.demo.di.component.DaggerMainComponent;
import me.jessyan.mvparms.demo.mvp.contract.MainContract;
import me.jessyan.mvparms.demo.mvp.presenter.MainPresenter;
import me.jessyan.mvparms.demo.mvp.ui.adapter.ChatSessionAdapter;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.toolbar_back)
    RelativeLayout mToolbarBack;
    @BindView(R.id.recyclerView)
    XRecyclerView mRecyclerView;

    @Inject
    Dialog mDialog;
    @Inject
    RecyclerView.LayoutManager mLayoutManager;
    @Inject
    ChatSessionAdapter mAdapter;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initView();
        initData();
    }

    private void initData() {
        mAdapter.clear();
        mAdapter.setState(HelperStateRecyclerViewAdapter.STATE_LOADING);
        mPresenter.getChatSessionList(true);
    }

    /**
     * 初始化RecyclerView
     */
    private void initView() {
        setTitle(R.string.str_contact);
        mToolbarBack.setVisibility(View.INVISIBLE);
        LayoutManagerUtil.initXRecyclerView(mRecyclerView, mLayoutManager, new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getChatSessionList(true);
            }

            @Override
            public void onLoadMore() {
                mPresenter.getChatSessionList(false);
            }
        }).setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {

            }
        });
    }


    @Override
    public void showLoading() {
        if (!mRecyclerView.isRefresh() || !mRecyclerView.isLoadingMore()) {
            mDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        mDialog.dismiss();
        if (mRecyclerView.isRefresh()) {
            mRecyclerView.refreshComplete();
        }
        mRecyclerView.setPullRefreshEnabled(true);
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public Context getActivity() {
        return this;
    }

    @Override
    public XRecyclerView getRecyclerView() {
        return mRecyclerView;
    }


}
