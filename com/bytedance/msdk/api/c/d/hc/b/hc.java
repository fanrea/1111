package com.bytedance.msdk.api.c.d.hc.b;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.w.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private final String an;
    private final String b;
    private final String c;
    private final String d;
    private final String gb;
    private final String h;
    private final String hc;
    private final String mk;
    private final String mq;
    private final String tc;
    private final String tt;
    private final String u;

    public hc() {
        this.b = "";
        this.d = "";
        this.hc = "";
        this.c = "";
        this.u = "";
        this.an = "";
        this.h = "";
        this.gb = "";
        this.tt = "";
        this.tc = "";
        this.mk = "";
        this.mq = "";
    }

    public hc(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.b = str;
        this.d = str2;
        this.hc = str3;
        this.c = str4;
        this.u = str5;
        this.an = str6;
        this.h = str7;
        this.gb = str8;
        this.tt = str9;
        this.tc = str10;
        this.mk = str11;
        this.mq = str12;
    }

    public SparseArray<Object> d() {
        c cVarD = c.d();
        cVarD.d(8003, this.b);
        cVarD.d(8534, this.d);
        cVarD.d(8535, this.hc);
        cVarD.d(8536, this.c);
        cVarD.d(8537, this.u);
        cVarD.d(8538, this.an);
        cVarD.d(8539, this.h);
        cVarD.d(8540, this.gb);
        cVarD.d(8541, this.tt);
        cVarD.d(8542, this.tc);
        cVarD.d(8543, this.mk);
        cVarD.d(8544, this.mq);
        return cVarD.hc();
    }

    public String hc() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public d d(int i, int i2) {
        switch (i) {
            case 1:
                return new d(this.u, com.bytedance.msdk.api.c.d.hc.d.d.class);
            case 2:
                return new d(this.an, com.bytedance.msdk.api.c.d.hc.h.d.class);
            case 3:
                return new d(this.tt, com.bytedance.msdk.api.c.d.hc.tc.d.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new d(this.tc, com.bytedance.msdk.api.c.d.hc.gb.d.class);
                }
                if (i2 == 5) {
                    return new d(this.mk, com.bytedance.msdk.api.c.d.hc.c.d.class);
                }
                if (i2 == 3) {
                    return new d(this.u, com.bytedance.msdk.api.c.d.hc.d.d.class);
                }
                return new d(this.tc, com.bytedance.msdk.api.c.d.hc.gb.d.class);
            case 7:
                if (i2 == 6) {
                    return new d(this.h, com.bytedance.msdk.api.c.d.hc.tt.d.class);
                }
                if (i2 == 7) {
                    return new d(this.gb, com.bytedance.msdk.api.c.d.hc.u.d.class);
                }
                return new d(this.h, com.bytedance.msdk.api.c.d.hc.tt.d.class);
            case 8:
                return new d(this.gb, com.bytedance.msdk.api.c.d.hc.u.d.class);
            case 9:
                break;
            case 10:
                if (i2 == 1) {
                    return new d(this.an, com.bytedance.msdk.api.c.d.hc.h.d.class);
                }
                if (i2 == 2) {
                    return new d(this.gb, com.bytedance.msdk.api.c.d.hc.u.d.class);
                }
                break;
        }
        return new d(this.mk, com.bytedance.msdk.api.c.d.hc.c.d.class);
    }

    public boolean c() {
        return TextUtils.equals(this.mq, "1");
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.d + "', mAppKey='" + this.hc + "', mADNName='" + this.b + "', mAdnInitClassName='" + this.c + "', mBannerClassName='" + this.u + "', mInterstitialClassName='" + this.an + "', mRewardClassName='" + this.h + "', mFullVideoClassName='" + this.gb + "', mSplashClassName='" + this.tt + "', mDrawClassName='" + this.mk + "', mFeedClassName='" + this.tc + "'}";
    }
}
