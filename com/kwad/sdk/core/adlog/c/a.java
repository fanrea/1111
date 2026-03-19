package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public long AM;
    public String QX;
    public a.C0576a QY;
    public long Rz;
    public int Vc;
    public AdTemplate adTemplate;
    public int adnMaterialType;
    public String adnMaterialUrl;
    public String adnName;
    public int adnType;
    public int buM;
    public JSONObject bvW;
    public int bvX;
    public int bvY;
    public int bvZ;
    public int bwB;
    public int bwC;
    public String bwE;
    public int bwG;
    public int bwH;
    public int bwI;
    public int bwJ;
    public String bwL;
    public int bwa;
    public String bwb;
    public String bwf;
    public String bwg;
    public String bwh;
    public int bwi;
    public int bwj;
    public int bwl;
    public String bwm;
    public int bwn;
    public int bwo;
    public String bwq;
    public int bwr;
    public int bws;
    public String bwt;
    public String bwu;
    public int bwv;
    public int bww;
    public long bwx;
    public long bwy;
    public int downloadSource;
    public aj.a oB;
    public double oC;
    public int oz;
    public long bwc = -1;
    public int bwd = -1;
    public long bwe = -1;
    public int bwk = -1;
    public int QZ = 0;
    public String bwp = "";
    public int bwz = -1;
    public int bwA = -1;
    public int downloadStatus = 0;
    public int bwD = -1;
    public int QW = -1;
    public int bwF = -1;
    public int adxResult = -1;
    public int Ra = -1;
    public int bwK = 0;

    public static a Xs() {
        return new a();
    }

    public final void eI(int i) {
        if (i == 0) {
            this.bwH = 1;
        } else if (i == 1) {
            this.bwH = 2;
        } else {
            if (i != 2) {
                return;
            }
            this.bwH = 3;
        }
    }

    public final void a(h hVar) {
        if (hVar != null) {
            this.bwL = hVar.abl();
        }
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0576a c0576a = this.QY;
        if (c0576a == null) {
            a.C0576a c0576a2 = new a.C0576a();
            this.QY = c0576a2;
            c0576a2.a(adTemplate, null, null, null);
        } else if (c0576a.bvy == null) {
            this.QY.a(adTemplate, null, null, null);
        }
    }

    public final a eJ(int i) {
        this.oz = i;
        return this;
    }

    public final a eG(String str) {
        this.QX = str;
        return this;
    }

    public final a e(aj.a aVar) {
        this.oB = aVar;
        return this;
    }

    public final a eK(int i) {
        this.QZ = i;
        return this;
    }

    public final a eL(int i) {
        this.Ra = i;
        return this;
    }

    public final a eM(int i) {
        this.QW = i;
        return this;
    }

    public final a a(a.C0576a c0576a) {
        this.QY = c0576a;
        return this;
    }

    public final a aT(long j) {
        this.AM = j;
        return this;
    }

    public final a aU(long j) {
        this.Rz = j;
        return this;
    }

    public final a eN(int i) {
        this.Vc = i;
        return this;
    }

    public final a eO(int i) {
        this.bwr = i;
        return this;
    }

    public final a.C0576a Xt() {
        return this.QY;
    }
}
