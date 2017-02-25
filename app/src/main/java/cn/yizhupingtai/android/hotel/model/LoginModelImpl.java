package cn.yizhupingtai.android.hotel.model;

import com.zhy.http.okhttp.OkHttpUtils;

import cn.yizhupingtai.android.hotel.bean.UserBean;
import cn.yizhupingtai.android.hotel.bean.base.ResultBean;
import cn.yizhupingtai.android.hotel.config.ResultCallBack;
import cn.yizhupingtai.android.hotel.contract.LoginContract;
import cn.yizhupingtai.android.hotel.info.ApiUrl;
import cn.yizhupingtai.android.hotel.utils.DataUtils;
import cn.yizhupingtai.android.hotel.utils.ResultIsSuccessUtils;


/**
* Created by Administrator on 2017/02/18
*/

public class LoginModelImpl implements LoginContract.Model{

    @Override
    public void login(String name, String password, final LoginContract.OnLoginListener listener) {
        OkHttpUtils.post().url(ApiUrl.login)
                .addParams("V_ACCOUNT",name)
                .addParams("V_PWD",password)
                .build()
                .execute(new ResultCallBack() {

                    @Override
                    public void onError(String error) {
                        listener.loginFailed(error);
                    }

                    @Override
                    public void onResponse(ResultBean response) {
                        if (ResultIsSuccessUtils.isSuccess(response.getIsSuccess())){
                            UserBean userBean  = DataUtils.getListOfOnlyData(response.getResult(),UserBean.class);
                            listener.loginSuccess(userBean);
                        }else {
                            onError(response.getErrorMsg());
                        }
                    }
                });
    }
}