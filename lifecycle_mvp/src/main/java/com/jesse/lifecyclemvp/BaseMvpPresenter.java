package com.jesse.lifecyclemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * BaseMvpPresenter 是MVP 结构 Presenter基类
 *
 * @author wuzhao
 * @Date 2018/1/18
 * @mail： wuzhao@in66.com
 */
public class BaseMvpPresenter<V extends BaseMvpView> {

    public static final String TAG = "BaseMvpPresenter";

    /**
     * V层view
     */
    private V mView;

    /**
     * Presenter被创建后调用
     *
     * @param savedState 被意外销毁后重建后的Bundle
     */
    public void onCreatePersenter(@Nullable Bundle savedState) {
        Log.e(TAG, "P onCreatePersenter");
    }


    /**
     * 绑定View
     */
    public void onAttachMvpView(V mvpView) {
        mView = mvpView;
        Log.e(TAG, "P onScreenViewCreated");
    }

    /**
     * 解除绑定View
     */
    public void onDetachMvpView() {
        mView = null;
        Log.e(TAG, "P onDetachMvpView");
    }

    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPersenter() {
        Log.e(TAG, "P onDestroy");
    }

    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     *
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState) {
        Log.e(TAG, "P onSaveInstanceState");
    }

    /**
     * 获取V层接口View
     *
     * @return 返回当前MvpView
     */
    public V getMvpView() {
        return mView;
    }
}
