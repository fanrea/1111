package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends IOException {
    private final long a;
    private final long b;

    public e(long requireSpace, long freeSpace) {
        super("There is Free space less than Require space: " + freeSpace + " < " + requireSpace);
        this.a = requireSpace;
        this.b = freeSpace;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
