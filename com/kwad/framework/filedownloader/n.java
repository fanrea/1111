package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n implements u {
    private final u bdP;

    /* synthetic */ n(byte b) {
        this();
    }

    static final class a {
        private static final n bdQ = new n(0);
    }

    public static n MW() {
        return a.bdQ;
    }

    public static e.a MX() {
        if (MW().bdP instanceof o) {
            return (e.a) MW().bdP;
        }
        return null;
    }

    private n() {
        u pVar;
        if (com.kwad.framework.filedownloader.f.e.OX().bhn) {
            pVar = new o();
        } else {
            pVar = new p(FileDownloadService.SeparateProcessService.class);
        }
        this.bdP = pVar;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        return this.bdP.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean df(int i) {
        return this.bdP.df(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte dg(int i) {
        return this.bdP.dg(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.bdP.isConnected();
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aR(Context context) {
        this.bdP.aR(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean dh(int i) {
        return this.bdP.dh(i);
    }
}
