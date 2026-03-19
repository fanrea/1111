package com.netease.htprotect.result;

import aegon.chrome.net.NetError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AntiCheatResult {
    public static final int ERROR_BUSINESSID_INVALID = 203;
    public static final String ERROR_BUSINESSID_INVALID_STR = "businessId invalid";
    public static final int ERROR_GEN_TOKEN = 204;
    public static final String ERROR_GEN_TOKEN_STR = "gen token error";
    public static final int ERROR_NOT_INIT = 201;
    public static final String ERROR_NOT_INIT_STR = "error. not init";
    public static final int ERROR_ON_MAIN = 202;
    public static final String ERROR_ON_MAIN_STR = "error. run on main thread";
    public static final int ERROR_PRODUCTID_INVALID = 199;
    public static final String ERROR_PRODUCTID_INVALID_STR = "productId invalid";
    public static final int ERROR_TOKEN_TIMEOUT = 205;
    public static final String ERROR_TOKEN_TIMEOUT_STR = "gen token timeout";
    public static final int OK = 200;
    public static final String OK_STR = "success";
    public String businessId;
    public int code;
    public String codeStr;
    public String token;

    public AntiCheatResult(String str, int i) {
        new AntiCheatResult(str, i, "", "");
    }

    public AntiCheatResult(String str, int i, String str2, String str3) {
        this.token = str;
        this.code = i;
        this.codeStr = str2;
        this.businessId = str3;
    }

    public static int getCode(int i) {
        switch (i) {
            case NetError.ERR_CERT_NO_REVOCATION_MECHANISM /* -204 */:
                break;
            case NetError.ERR_CERT_CONTAINS_ERRORS /* -203 */:
                break;
            case -202:
                break;
            case -201:
                break;
            case -200:
                break;
            default:
                switch (i) {
                }
        }
        return 204;
    }

    public static String getCodeStr(int i) {
        switch (i) {
            case 199:
                return ERROR_PRODUCTID_INVALID_STR;
            case 200:
                return "success";
            case 201:
                return ERROR_NOT_INIT_STR;
            case 202:
                return ERROR_ON_MAIN_STR;
            case 203:
                return ERROR_BUSINESSID_INVALID_STR;
            case 204:
                return ERROR_GEN_TOKEN_STR;
            default:
                return "";
        }
    }
}
