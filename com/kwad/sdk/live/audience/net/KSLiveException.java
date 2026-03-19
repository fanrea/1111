package com.kwad.sdk.live.audience.net;

import com.kwad.sdk.live.audience.api.KSLiveResponse;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveException extends Exception {
    public final int mErrorCode;
    public final String mErrorMessage;
    public final transient KSLiveResponse<?> mResponse;

    public KSLiveException(KSLiveResponse<?> kSLiveResponse) {
        this.mResponse = kSLiveResponse;
        this.mErrorCode = kSLiveResponse.resultCode();
        this.mErrorMessage = kSLiveResponse.errorMsg();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mErrorMessage;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
