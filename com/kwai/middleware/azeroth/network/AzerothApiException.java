package com.kwai.middleware.azeroth.network;

import java.io.IOException;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AzerothApiException extends IOException {
    private static final long serialVersionUID = 872097787742783465L;
    public final int mHttpCode;
    public final URL mUrl;

    public AzerothApiException(Throwable th, URL url, int i) {
        super("httpCode: " + i + " , request: " + url, th);
        this.mUrl = url;
        this.mHttpCode = i;
    }
}
