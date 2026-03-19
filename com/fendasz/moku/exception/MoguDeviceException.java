package com.fendasz.moku.exception;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MoguDeviceException extends Exception {
    private static final String EXCEPTION_MSG = "get device id error,device is null";

    public MoguDeviceException() {
        super(EXCEPTION_MSG);
    }

    public MoguDeviceException(Throwable th) {
        super(EXCEPTION_MSG, th);
    }
}
