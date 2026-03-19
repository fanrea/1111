package com.kwai.middleware.azeroth.network;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AzerothResponseException extends IOException {
    private static final long serialVersionUID = 2327299233749210969L;
    public final int mErrorCode;
    public final String mErrorMessage;
    public final transient Response<?> mResponse;

    public AzerothResponseException(Response<?> response) {
        super(response.errorMessage());
        this.mResponse = response;
        this.mErrorCode = response.errorCode();
        this.mErrorMessage = response.errorMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mErrorMessage;
    }
}
