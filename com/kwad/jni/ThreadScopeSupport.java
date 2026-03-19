package com.kwad.jni;

import com.kwad.tachikoma.TkOfflineCompoImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class ThreadScopeSupport {
    private static native void runStdFunctionImpl(long j);

    static {
        System.loadLibrary(TkOfflineCompoImpl.SO_FB);
    }

    private static void runStdFunction(long j) {
        runStdFunctionImpl(j);
    }
}
