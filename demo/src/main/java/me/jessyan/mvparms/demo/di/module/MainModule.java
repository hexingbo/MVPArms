package me.jessyan.mvparms.demo.di.module;

import android.app.Dialog;

import com.jess.arms.di.scope.ActivityScope;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.MainContract;
import me.jessyan.mvparms.demo.mvp.model.MainModel;
import me.jessyan.mvparms.demo.mvp.model.entity.ChatSessionBean;
import me.jessyan.mvparms.demo.mvp.ui.adapter.ChatSessionAdapter;
import me.jessyan.mvparms.demo.mvp.ui.weight.ProgresDialog;


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
@Module
public abstract class MainModule {

    @ActivityScope
    @Provides
    static Dialog provideDialog(MainContract.View view) {
        return new ProgresDialog(view.getActivity());
    }

    @ActivityScope
    @Provides
    static RecyclerView.LayoutManager provideLayoutManager(MainContract.View view) {
        return new LinearLayoutManager(view.getActivity(),LinearLayoutManager.VERTICAL, false);
    }

    @ActivityScope
    @Provides
    static List<ChatSessionBean> provideList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    static RecyclerView.Adapter provideAdapter(List<ChatSessionBean> list) {
        return new ChatSessionAdapter(list);
    }

    @Binds
    abstract MainContract.Model bindMainModel(MainModel model);

}