package com.sigmob.sdk.videocache;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    public final File a;
    public final com.sigmob.sdk.videocache.file.c b;
    public final com.sigmob.sdk.videocache.file.a c;
    public final com.sigmob.sdk.videocache.sourcestorage.c d;
    public final com.sigmob.sdk.videocache.headers.b e;

    e(File cacheRoot, com.sigmob.sdk.videocache.file.c fileNameGenerator, com.sigmob.sdk.videocache.file.a diskUsage, com.sigmob.sdk.videocache.sourcestorage.c sourceInfoStorage, com.sigmob.sdk.videocache.headers.b headerInjector) {
        this.a = cacheRoot;
        this.b = fileNameGenerator;
        this.c = diskUsage;
        this.d = sourceInfoStorage;
        this.e = headerInjector;
    }

    File a(String url) {
        return new File(this.a, this.b.a(url));
    }
}
