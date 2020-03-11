package com.zhf.base.presenter;

import com.zhf.base.model.BaseModel;
import com.zhf.base.view.BaseView;

/**
 * Presenter 层主要是连接 View 层和 Model 层的桥梁，负责把 View 层需要数据从 Model 层拿到，返回给 View 层；
 *
 * 所以我们在 P（Presenter） 层要持有 View 和 Model 层的引用。如下所示：
 * @param <M>
 * @param <V>
 */
public class BasePresenter<M extends BaseModel, V extends BaseView> implements IPresenter {


    protected M mModel;

    protected V mView;

    public BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }

    public BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void onDestroy() {
        if (mModel != null) {
            mModel.onDestroy();
        }
        this.mModel = null;
        this.mView = null;
    }
}
