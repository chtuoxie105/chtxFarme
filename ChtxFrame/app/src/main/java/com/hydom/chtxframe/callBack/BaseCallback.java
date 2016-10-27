package com.hydom.chtxframe.callBack;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2016/10/21.
 */
public abstract class BaseCallback<K> implements Callback.CommonCallback<K> {


    @Override
    public void onSuccess(K result) {

        onSuccesed(result);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        ex.printStackTrace();
        onFailed();
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {
        onFinally();
    }

    protected abstract void onSuccesed(K data);
    protected abstract void onFailed();
    protected abstract void onFinally();
}
