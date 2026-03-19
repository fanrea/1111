package com.sigmob.sdk.videocache;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class t {
    public static u a(u source) {
        m mVar;
        if (com.sigmob.sdk.base.o.a().ac()) {
            try {
                mVar = new m(source);
            } catch (Throwable unused) {
            }
        } else {
            mVar = null;
        }
        return mVar == null ? new j(source) : mVar;
    }

    public static u a(String url) {
        m mVar;
        if (com.sigmob.sdk.base.o.a().ac()) {
            try {
                mVar = new m(url);
            } catch (Throwable unused) {
            }
        } else {
            mVar = null;
        }
        return mVar == null ? new j(url) : mVar;
    }

    public static u a(String url, com.sigmob.sdk.videocache.sourcestorage.c sourceInfoStorage, com.sigmob.sdk.videocache.headers.b headerInjector) {
        m mVar;
        if (com.sigmob.sdk.base.o.a().ac()) {
            try {
                mVar = new m(url, sourceInfoStorage, headerInjector);
            } catch (Throwable unused) {
            }
        } else {
            mVar = null;
        }
        return mVar == null ? new j(url, sourceInfoStorage, headerInjector) : mVar;
    }
}
