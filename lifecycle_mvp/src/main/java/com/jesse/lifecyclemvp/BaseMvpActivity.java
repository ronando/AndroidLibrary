package com.jesse.lifecyclemvp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * $desc$
 *
 * @author wuzhao
 * @Date 2018/6/12
 * @mail： wuzhao@in66.com
 */
public abstract class BaseMvpActivity<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends AppCompatActivity {
    protected BaseMvpProxy<V, P> mProxy = new BaseMvpProxy(PresenterMvpFactory.<V, P>createFactory(this.getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProxy.onCreated((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxy.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mProxy.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mProxy.onRestoreInstanceState(savedInstanceState);
    }
}
