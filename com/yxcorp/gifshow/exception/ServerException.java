package com.yxcorp.gifshow.exception;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ServerException extends Exception {
    public final int errorCode;
    public final String errorMessage;
    public final int subCode;

    public ServerException(int i, int i2, String str) {
        this.errorCode = i;
        this.subCode = i2;
        this.errorMessage = str;
    }
}
