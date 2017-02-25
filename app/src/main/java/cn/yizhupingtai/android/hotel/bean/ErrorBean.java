package cn.yizhupingtai.android.hotel.bean;

/**
 * Created by Administrator on 2017-2-18.
 */
public class ErrorBean {
    private String errorCode ;
    private String errorMsg ;
    private String executeType;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getExecuteType() {
        return executeType;
    }

    public void setExecuteType(String executeType) {
        this.executeType = executeType;
    }
}
