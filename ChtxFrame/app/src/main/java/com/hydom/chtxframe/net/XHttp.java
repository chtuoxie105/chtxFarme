package com.hydom.chtxframe.net;

import com.hydom.chtxframe.callBack.BaseCallback;
import com.hydom.chtxframe.utils.L;

import org.xutils.HttpManager;
import org.xutils.common.Callback;
import org.xutils.common.util.KeyValue;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class XHttp {
    public static HttpManager manager;
    static {
        manager = x.http();
    }

    public static Callback.Cancelable get(RequestParams params, BaseCallback callback) {
        logRequest(params);
        return manager.get(params, callback);
    }
    public static Callback.Cancelable post(RequestParams params, BaseCallback callback) {
        logRequest(params);

        return manager.post(params, callback);
    }

    private static void logRequest(RequestParams params){
        String url =params.getUri();
        L.w("-----URL----"+url);
        List<KeyValue>  list= params.getStringParams();
        int num =list.size();
        for(int i=0;i<num;i++){
            KeyValue keyValue =list.get(i);
            L.w(keyValue.key+"="+keyValue.value);
        }
        L.w("------------------------------------------");
    }
}
