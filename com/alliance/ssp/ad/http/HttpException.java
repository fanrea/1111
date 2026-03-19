package com.alliance.ssp.ad.http;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class HttpException extends Exception {
    public static final int BAD_GATEWAY = 502;
    public static final int NET_ERROR = 501;
    public static final int NOT_FOUND = 404;
    public static final int NO_NET = 500;
    public static final int REQUEST_CANCELED = 801;
    public static final int REQUEST_FAIL = 100;
    public static final int REQUEST_REQUEST_ERROR = 8899;
    public static final int REQUEST_TIME_OUT = 408;
    private int errorCode;
    private String errorUrl;
    private int httpErrorCode;

    public HttpException(int i) {
        super(getMessage(i, null));
        this.errorUrl = null;
        this.httpErrorCode = -1;
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorUrl() {
        return this.errorUrl;
    }

    public int getHttpErrorCode() {
        return this.httpErrorCode;
    }

    public static String getMessage(int i, Throwable th) {
        return th != null ? th.toString() : i != 100 ? i != 408 ? i != 500 ? i != 801 ? "网络请求报错" : "网络请求被取消了" : "无网络" : "网络请求超时" : "网络请求失败";
    }

    public HttpException(String str, int i, int i2) {
        super(getMessage(i, null));
        this.errorUrl = str;
        this.httpErrorCode = i2;
        this.errorCode = i;
    }

    public HttpException(int i, Throwable th) {
        this(getMessage(i, th), th);
    }

    private HttpException(String str) {
        super(str);
        this.errorUrl = null;
        this.httpErrorCode = -1;
    }

    private HttpException(String str, Throwable th) {
        super(str, th);
        this.errorUrl = null;
        this.httpErrorCode = -1;
    }
}
