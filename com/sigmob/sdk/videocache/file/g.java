package com.sigmob.sdk.videocache.file;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g extends e {
    private final int a;

    public g(int maxCount) {
        if (maxCount <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.a = maxCount;
    }

    @Override // com.sigmob.sdk.videocache.file.e
    protected boolean a(File file, long totalSize, int totalCount) {
        return totalCount <= this.a;
    }
}
