package me.jessyan.mvparms.demo.app.utils;

import android.content.Context;

import com.zhouyou.recyclerview.XRecyclerView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import me.jessyan.mvparms.demo.mvp.ui.weight.CustomMoreFooter;
import me.jessyan.mvparms.demo.mvp.ui.weight.CustomRefreshHeader2;

/**
 * @Author :hexingbo
 * @Date :2019/4/10
 * @FileName： LayoutManagerUtil
 * @Describe :
 */
public class LayoutManagerUtil {
    public static LinearLayoutManager getLinearLayoutManager_VERTICAL(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }

    public static LinearLayoutManager getLinearLayoutManager_HORIZONTAL(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }

    public static GridLayoutManager getGridLayoutManager(Context context, int spanCount) {
        return new GridLayoutManager(context, spanCount);
    }

    public static StaggeredGridLayoutManager getStaggeredGridLayoutManager(int spanCount) {
        return new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
    }

    public static XRecyclerView initXRecyclerView(@Nullable XRecyclerView mRecyclerView,
                                                  @Nullable RecyclerView.LayoutManager layout,
                                                  XRecyclerView.LoadingListener listener) {
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setRefreshHeader(new CustomRefreshHeader2(mRecyclerView.getContext()));
        mRecyclerView.setLoadingMoreFooter(new CustomMoreFooter(mRecyclerView.getContext()));
        mRecyclerView.setLoadingMoreEnabled(false);
        if (listener != null)
            mRecyclerView.setLoadingListener(listener);

        return mRecyclerView;
    }
}
