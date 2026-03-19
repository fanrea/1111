package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.aj;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private final a bwM = new a();

    public final a Xu() {
        return this.bwM;
    }

    public final b b(a.C0576a c0576a) {
        this.bwM.QY = c0576a;
        return this;
    }

    public final b G(int i, int i2) {
        this.bwM.bwb = i + "," + i2;
        return this;
    }

    public final b eP(int i) {
        this.bwM.oz = i;
        return this;
    }

    public final b eQ(int i) {
        this.bwM.bvZ = i;
        return this;
    }

    public final b eR(int i) {
        this.bwM.bwa = i;
        return this;
    }

    public final b f(aj.a aVar) {
        this.bwM.oB = aVar;
        return this;
    }

    public final b eH(String str) {
        this.bwM.QX = str;
        return this;
    }

    public final b eS(int i) {
        this.bwM.downloadSource = i;
        return this;
    }

    public final b eT(int i) {
        this.bwM.bws = i;
        return this;
    }

    public final b eI(String str) {
        this.bwM.bwt = str;
        return this;
    }

    public final b eJ(String str) {
        this.bwM.bwu = str;
        return this;
    }

    public final b eU(int i) {
        this.bwM.bwv = i;
        return this;
    }

    public final b eV(int i) {
        this.bwM.bww = i;
        return this;
    }

    public final b eW(int i) {
        this.bwM.bwk = i;
        return this;
    }

    public final b aV(long j) {
        this.bwM.AM = j;
        return this;
    }

    public final b eX(int i) {
        this.bwM.bwC = i;
        return this;
    }

    public final b o(double d) {
        this.bwM.oC = d;
        return this;
    }

    public final b eK(String str) {
        this.bwM.bwE = str;
        return this;
    }

    public final b eY(int i) {
        this.bwM.bwG = i;
        return this;
    }

    public final b eZ(int i) {
        this.bwM.eI(i);
        return this;
    }

    public final b fa(int i) {
        this.bwM.bwI = i;
        return this;
    }

    public final b fb(int i) {
        this.bwM.Ra = i;
        return this;
    }

    public final b fc(int i) {
        this.bwM.bwK = i;
        return this;
    }

    public final b fd(int i) {
        this.bwM.QZ = i;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        if (this.bwM.QY == null) {
            this.bwM.QY = new a.C0576a();
        }
        this.bwM.QY.a(adTemplate, str, str2, aVar);
        return this;
    }
}
