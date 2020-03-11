package com.zhf.mvpdaggerdemo.test;

import dagger.Module;
import dagger.Provides;

@Module
public class Login1Module {

    private Login1Contract.ILoginView mILoginView;

    public Login1Module(Login1Contract.ILoginView ILoginView) {
        mILoginView = ILoginView;
    }

    @Provides
    Login1Contract.ILoginView getView() {
        return mILoginView;
    }

    @Provides
    Login1Contract.ILoginModel getModel(Login1Model model) {
        return model;
    }
}

