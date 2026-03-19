package com.kwad.sdk.api.loader;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DexLoadError {
    public static final int CODE_SUCCESS = 1;
    public static final int ERROR_CODE_CLASSLOADER_NOT_FOUND = -1;
    public static final int ERROR_CODE_CLASSLOADER_OTHER = -2;
    public static final int ERROR_CODE_CP_ASSETS_IO = -3;
    public static final int ERROR_CODE_MD5_CHECK_ERROR = -4;
    private int errorCode;
    private String errorMsg;
    private String loadResult;

    public boolean success() {
        return this.errorCode == 1;
    }

    public DexLoadError() {
        this.errorCode = 1;
    }

    public DexLoadError(int i, String str) {
        this.errorCode = i;
        this.errorMsg = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getLoadResult() {
        return this.loadResult;
    }

    public void setLoadResult(String str) {
        this.loadResult = str;
    }

    public String toString() {
        return "DexLoadError{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', loadResult='" + this.loadResult + "'}";
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.errorCode == 1 ? "success" : "fail";
            this.loadResult = str;
            jSONObject.putOpt("load_result", str);
            jSONObject.putOpt("error_code", Integer.valueOf(this.errorCode));
            jSONObject.putOpt("error_msg", this.errorMsg);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
