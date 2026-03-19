package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i extends IOException {
    private final int a;

    public i(int responseCode, long currentOffset) {
        super("Response code can't handled on internal " + responseCode + " with current offset " + currentOffset);
        this.a = responseCode;
    }

    public int a() {
        return this.a;
    }
}
