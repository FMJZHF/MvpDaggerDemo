package com.zhf.mvpdaggerdemo.test;

import android.os.Handler;

import com.zhf.mvpdaggerdemo.UserInfoModel;
import com.zhf.mvpdaggerdemo.base.p.BasePresenter;

import javax.inject.Inject;

/**
 * Presenter 层主要是连接 View 层和 Model 层的桥梁：
 */
public class Login1Presenter extends BasePresenter<Login1Contract.ILoginModel, Login1Contract.ILoginView> {

    @Inject
    public Login1Presenter(Login1Contract.ILoginModel model, Login1Contract.ILoginView view) {
        super(model, view);
    }

    private Handler mHandler = new Handler();

    /**
     * 模拟登陆
     */
    public void login() {
        mView.showLoading();
        mModel.login(mView.getUserName(), mView.getPassword(), new Login1Contract.OnLoginListener() {
            @Override
            public void loginSuccess(final UserInfoModel userInfoModel) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.toMainActivity(userInfoModel);
                        mView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showFailedError();
                        mView.hideLoading();
                    }
                });
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // TODO: 2018/1/25 销毁持有的引用
    }

    /**
     * 清除账户名和密码
     */
    public void clear() {
        mView.clearUserName();
        mView.clearPassword();
    }
}
