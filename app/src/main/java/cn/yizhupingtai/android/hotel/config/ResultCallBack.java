package cn.yizhupingtai.android.hotel.config;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

import cn.yizhupingtai.android.hotel.bean.base.ResultBean;
import cn.yizhupingtai.android.hotel.utils.StringHintUtisl;

/**
 * Created by Administrator on 2017-2-25.
 */
public abstract class ResultCallBack extends Callback<ResultBean> {
    @Override
    public ResultBean parseNetworkResponse(Response response) throws IOException {
        return new Gson().fromJson(response.body().string(),ResultBean.class);
    }
    @Override
    public void onError(Request request, Exception e) {
        onError(StringHintUtisl.getHttpErrorHint());
    }
    public abstract void onError(String error);
}
