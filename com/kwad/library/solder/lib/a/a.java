package com.kwad.library.solder.lib.a;

import android.content.Context;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a {
    protected File bir;
    protected String bis;
    protected String bit;
    private final String biw;
    protected com.kwad.library.solder.lib.c.b bix;
    protected String mVersion;
    private final byte[] biv = new byte[0];
    private boolean biu = false;
    protected com.kwad.library.solder.lib.ext.c bhV = i.Po().Pi();

    protected abstract void o(Context context, String str);

    public a(String str) {
        this.biw = str;
        this.bis = str;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.biw + "'}";
    }

    public final a a(com.kwad.library.solder.lib.c.b bVar) {
        this.bix = bVar;
        return this;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final void cU(String str) {
        this.mVersion = str;
    }

    public final boolean isLoaded() {
        boolean z;
        if (this.biu) {
            return true;
        }
        synchronized (this.biv) {
            z = this.biu;
        }
        return z;
    }

    public final String getId() {
        return this.bit;
    }

    public final void cV(String str) {
        this.bit = str;
    }

    private void Ps() {
        if (this.biu) {
            return;
        }
        synchronized (this.biv) {
            this.biu = true;
        }
    }

    public final String Pt() {
        return this.biw;
    }

    public final void cW(String str) {
        this.bis = str;
    }

    public final String Pu() {
        com.kwad.library.solder.lib.c.b bVar = this.bix;
        if (bVar != null) {
            return bVar.bjg;
        }
        return null;
    }

    public final void t(Context context, String str) {
        o(context, str);
        Ps();
    }
}
