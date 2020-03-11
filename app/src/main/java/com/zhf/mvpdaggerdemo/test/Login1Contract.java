package com.zhf.mvpdaggerdemo.test;

import com.zhf.mvpdaggerdemo.UserInfoModel;
import com.zhf.mvpdaggerdemo.base.m.BaseModel;
import com.zhf.mvpdaggerdemo.base.v.BaseView;

/**
 * 创建契约来规定 Model 和 View
 *定义 View 和 Model 层规则
 */
public interface Login1Contract {

    interface ILoginModel extends BaseModel {
        void login(String username, String password, OnLoginListener loginListener);
    }

    interface ILoginView extends BaseView {

        String getUserName();

        String getPassword();

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity(UserInfoModel userInfoModel);

        void showFailedError();
    }

    interface OnLoginListener{
        void loginSuccess(UserInfoModel userInfoModel);

        void loginFailed();
    }

}
