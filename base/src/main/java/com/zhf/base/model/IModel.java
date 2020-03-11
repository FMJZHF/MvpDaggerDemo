package com.zhf.mvpdaggerdemo.base.m;

/**
 * Model 层主要的职责有：
 * 从网络，数据库，文件，传感器，第三方等数据源读写数据。
 * 对外部的数据类型进行解析转换为APP内部数据交由上层处理。
 * 对数据的临时存储,管理，协调上层数据请求。
 *
 *
 * M 层主要是负责对数据进行操作的，我们难免会持有网络请求等其他的对象的引用，
 * 为了防止内存泄漏，我们需要在 Model 销毁的时候，通过 onDestroy（）方法中释放持有的引用。
 *
 */
public interface IModel {
    void onDestroy();
}
