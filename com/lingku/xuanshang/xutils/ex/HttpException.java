package com.lingku.xuanshang.xutils.ex;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HttpException extends BaseException {
    public int a;
    public String b;
    public String c;
    public String d;

    public HttpException(int i, String str) {
        super(str);
        this.a = i;
    }

    public int getCode() {
        return this.a;
    }

    public String getErrorCode() {
        String str = this.b;
        return str == null ? String.valueOf(this.a) : str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return !TextUtils.isEmpty(this.c) ? this.c : super.getMessage();
    }

    public String getResult() {
        return this.d;
    }

    public void setCode(int i) {
        this.a = i;
    }

    public void setErrorCode(String str) {
        this.b = str;
    }

    public void setMessage(String str) {
        this.c = str;
    }

    public void setResult(String str) {
        this.d = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "errorCode: " + getErrorCode() + ", msg: " + getMessage() + ", result: " + this.d;
    }
}
