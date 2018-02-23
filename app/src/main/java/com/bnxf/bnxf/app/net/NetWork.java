package com.bnxf.bnxf.app.net;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * Created by leiel on 2018/2/23 0023.
 */

public class NetWork {
    public static void doPost(String url, HashMap<String, String> map, final NetCallBack callBack) {
        OkGo.<String>post(url).params(map).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                callBack.call(response.body());
            }

            @Override
            public void onError(Response<String> response) {

            }
        });
    }

    public interface NetCallBack {
        public void call(String str);
    }
}
