package com.fendasz.moku.exception;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class NotInitException extends Exception {
    private static final String EXCEPTION_MSG = "mogu deviceid not init,please init first";

    public NotInitException() {
        super(EXCEPTION_MSG);
    }

    public NotInitException(Throwable th) {
        super(EXCEPTION_MSG, th);
    }
}
