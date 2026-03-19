package com.bytedance.sdk.djx.net.api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ErrCode {
    public static final int ERR_CLIENT_INIT_ERR = -1;
    public static final int ERR_CLIENT_NEED_PARAMS = -7;
    public static final int ERR_CLIENT_NET_NOT_AVAILABLE = -4;
    public static final int ERR_CLIENT_NOT_LOGIN = -5;
    public static final int ERR_CLIENT_NULL_ERR = -3;
    public static final int ERR_CLIENT_PARSE_ERR = -2;
    public static final int ERR_CLIENT_PAY_MODULE = -6;
    public static final int ERR_DRAMA_NOT_EXIST = -8;
    public static final int ERR_SERVER_DID_DEGRADE = 11;
    public static final int ERR_SERVER_DOWN = 3;
    public static final int ERR_SERVER_ENCRYPT = 2;
    public static final int ERR_SERVER_PARAMS = 4;
    public static final int ERR_SERVER_PLAY_PERMISSION = 10;
    public static final int ERR_SERVER_SIGN = 1;
    public static final int ERR_SERVER_TEST = 6;
    public static final int ERR_SERVER_TOKEN = 5;
    public static final int ERR_SERVER_TOKEN_OUID = 7;
    public static final int ERR_SERVER_UNKNOWN = 9999;
    public static final int OK = 0;

    public static String msg(int i) {
        if (i == 10) {
            return "没有播放权限";
        }
        if (i == 9999) {
            return "服务器错误";
        }
        switch (i) {
            case -8:
                return "短剧不存在";
            case -7:
                return "参数不合法";
            case -6:
                return "支付模块未引入";
            case -5:
                return "未登录";
            case -4:
                return "网络不可用";
            case -3:
                return "数据返回为空";
            case -2:
                return "数据解析异常";
            case -1:
                return "网络异常";
            case 0:
                return "成功";
            case 1:
                return "签名错误";
            case 2:
                return "加密错误";
            case 3:
                return "下游错误";
            case 4:
                return "参数错误";
            case 5:
                return "access_token验证失败";
            case 6:
                return "测试应用请求次数超过限制5000";
            case 7:
                return "登录参数OUID异常";
            default:
                return "未知错误";
        }
    }
}
