package com.kwad.tachikoma;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e {
    private ITkOfflineCompoInitConfig AY;

    static class a {
        private static final e AZ = new e(0);
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
    }

    public static e hP() {
        return a.AZ;
    }

    public final ITkOfflineCompoInitConfig hQ() {
        return this.AY;
    }

    final void a(ITkOfflineCompoInitConfig iTkOfflineCompoInitConfig) {
        this.AY = iTkOfflineCompoInitConfig;
    }

    public static IOfflineCompoLogcat log() {
        return OfflineHostProvider.getApi().log();
    }

    public static boolean isDebug() {
        return OfflineHostProvider.getApi().env().isDebug();
    }
}
