package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f extends IOException {
    private final com.sigmob.sdk.downloader.core.cause.b a;

    public f(com.sigmob.sdk.downloader.core.cause.b cause) {
        super("Resume failed because of " + cause);
        this.a = cause;
    }

    public com.sigmob.sdk.downloader.core.cause.b a() {
        return this.a;
    }
}
