package com.zhf.mvpdaggerdemo.base.v;

import androidx.appcompat.app.AppCompatActivity;

import com.zhf.mvpdaggerdemo.base.p.BasePresenter;

import javax.inject.Inject;

/**
 * View 层通常指的是 Activity 、Fragment、View、ViewGroup 等。
 *
 * 主要职责：
 * 提供 UI 交互
 * 在 Presenter 的控制下修改 UI。
 * 将业务事件交由 Presenter 处理
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P mPresenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        this.mPresenter = null;
    }
}