package com.yxcorp.livestream.longconnection.exception;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ServerInfo {
    public final int mCode;
    public final String mMessage;

    public ServerInfo(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
    }

    public String toString() {
        return " Code: " + this.mCode + " , Message: " + this.mMessage;
    }
}
