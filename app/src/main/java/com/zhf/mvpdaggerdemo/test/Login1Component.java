package com.zhf.mvpdaggerdemo.test;

import com.zhf.mvpdaggerdemo.Login1Activity;

import dagger.Component;

@Component(modules = Login1Module.class)
public interface Login1Component {
    void inject(Login1Activity login1Activity);
}

