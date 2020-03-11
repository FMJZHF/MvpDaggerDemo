package com.zhf.mvpdaggerdemo.base.p;

/**
 * 为了防止内存泄漏，我们定义了一个 Ipresenter 接口
 */
public interface IPresenter {
    // 在 onDestroy() 方法中释放 View 层和 Model 层的引用
    void onDestroy();
}
