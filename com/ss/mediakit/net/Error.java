package com.ss.mediakit.net;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Error {
    int code;
    public String errStr;
    public String host;
    public String id;

    public Error(int i, String str, String str2) {
        this.code = i;
        this.host = str;
        this.id = str2;
        this.errStr = null;
    }

    public Error(int i, String str, String str2, String str3) {
        this.code = i;
        this.host = str;
        this.id = str2;
        this.errStr = str3;
    }
}
