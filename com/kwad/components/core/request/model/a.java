package com.kwad.components.core.request.model;

import android.text.TextUtils;
import com.kwad.components.core.request.j;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public final ImpInfo Tk;
    public final com.kwad.components.core.request.c YO;
    public j YP;
    public List<String> YQ;
    public boolean YR;
    public boolean YS;
    public c YT;
    private String YU;

    /* synthetic */ a(C0487a c0487a, byte b) {
        this(c0487a);
    }

    public static void a(a aVar, AdResultData adResultData, boolean z) {
        d.a(aVar.Tk.adScene, aVar.sJ(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.YO.a(e.bCy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.bCy.msg : adResultData.testErrorMsg, z);
        } else {
            aVar.YO.a(adResultData, z);
        }
    }

    public static void a(a aVar, int i, String str, boolean z) {
        aVar.YO.a(i, str, z);
        d.a(aVar.getAdStyle(), i, str, aVar.sJ());
    }

    private a(C0487a c0487a) {
        this.Tk = c0487a.Tk;
        this.YO = c0487a.YO;
        this.YR = c0487a.YR;
        this.YS = c0487a.YS;
        this.YP = c0487a.YV;
    }

    public final long getPosId() {
        if (this.Tk.adScene != null) {
            return this.Tk.adScene.getPosId();
        }
        return -1L;
    }

    public final int getAdNum() {
        if (this.Tk.adScene != null) {
            return this.Tk.adScene.getAdNum();
        }
        return 1;
    }

    public final j sI() {
        return this.YP;
    }

    public final int getAdStyle() {
        if (this.Tk.adScene != null) {
            return this.Tk.adScene.adStyle;
        }
        return 0;
    }

    public final String sJ() {
        return !TextUtils.isEmpty(this.YU) ? this.YU : "network_only";
    }

    public final void aJ(String str) {
        this.YU = str;
    }

    /* renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    public static class C0487a {
        public ImpInfo Tk;
        public com.kwad.components.core.request.c YO;
        public boolean YR;
        public boolean YS;
        public j YV;

        public final C0487a e(ImpInfo impInfo) {
            this.Tk = impInfo;
            return this;
        }

        public final C0487a aM(boolean z) {
            this.YR = true;
            return this;
        }

        public final C0487a aN(boolean z) {
            this.YS = z;
            return this;
        }

        public final C0487a a(com.kwad.components.core.request.c cVar) {
            this.YO = cVar;
            return this;
        }

        public final C0487a a(j jVar) {
            this.YV = jVar;
            return this;
        }

        public final a sK() {
            if (com.kwad.components.ad.f.a.qr.booleanValue() && (this.Tk == null || this.YO == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }
}
