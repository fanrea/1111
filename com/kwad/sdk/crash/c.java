package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static final String TAG = "c";
    public final String NJ;
    public final double bMG;
    public final boolean bML;
    public final boolean bMM;
    public final com.kwad.sdk.crash.model.c bMP;
    public final com.kwad.sdk.crash.model.a bMQ;
    public final h bMR;
    public final String[] bMS;
    public final String[] bMT;
    public final boolean bMU;
    public final f bMV;
    public final String bMW;
    public final String bMX;
    public final String bMY;
    public final String bMZ;
    public final String bNa;
    public final String bNb;
    public final String bNc;
    public final String bNd;
    public final String bNe;
    public final List<com.kwad.sdk.crash.a> bNf;
    public final boolean bqM;
    public final String channel;
    public final Context dR;
    public final String platform;
    public final String sdkVersion;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        com.kwad.sdk.crash.model.c cVar = new com.kwad.sdk.crash.model.c();
        this.bMP = cVar;
        com.kwad.sdk.crash.model.a aVar2 = new com.kwad.sdk.crash.model.a();
        this.bMQ = aVar2;
        ArrayList arrayList = new ArrayList();
        this.bNf = arrayList;
        this.bMU = aVar.bMU;
        this.bML = aVar.bML;
        this.bMM = aVar.bMM;
        this.bqM = aVar.bqM;
        this.bNb = aVar.bNb;
        this.bNc = aVar.bNc;
        this.bNd = aVar.bNd;
        this.bNe = aVar.bNe;
        this.dR = aVar.dR;
        this.bMV = aVar.bMV;
        this.platform = aVar.platform;
        this.bMW = aVar.bMW;
        this.bMX = aVar.bMX;
        this.bMY = aVar.bMY;
        this.sdkVersion = aVar.sdkVersion;
        this.NJ = aVar.NJ;
        this.channel = aVar.channel;
        this.bMZ = aVar.bMZ;
        this.bNa = aVar.bNa;
        aVar2.mAppId = aVar.appId;
        aVar2.mAppName = aVar.appName;
        aVar2.bNM = aVar.appVersion;
        aVar2.bNL = aVar.appPackageName;
        cVar.bNW = aVar.sdkApiVersion;
        cVar.bNX = aVar.sdkApiVersionCode;
        cVar.mSdkVersion = aVar.sdkVersion;
        cVar.bNV = aVar.bFO;
        cVar.bNU = aVar.bNg;
        cVar.bNY = aVar.sdkType;
        this.bMR = aVar.bNh;
        this.bMS = aVar.bNi;
        this.bMT = aVar.bNj;
        arrayList.addAll(aVar.bNf);
        this.bMG = aVar.bMG;
    }

    public final f aeb() {
        return this.bMV;
    }

    public final boolean aec() {
        return this.bMU;
    }

    public static class a {
        private String NJ;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private int bFO;
        private f bMV;
        private String bMW;
        private String bMX;
        private String bMY;
        private String bMZ;
        private String bNa;
        private String bNg;
        private h bNh;
        private String[] bNi;
        public String[] bNj;
        private String channel;
        private Context dR;
        private String platform;
        private String sdkApiVersion;
        private int sdkApiVersionCode;
        public int sdkType;
        private String sdkVersion;
        private boolean bMU = false;
        private boolean bML = false;
        private boolean bMM = false;
        private boolean bqM = false;
        private String bNb = "";
        private String bNc = "";
        private String bNd = "";
        private String bNe = "";
        private List<com.kwad.sdk.crash.a> bNf = new ArrayList();
        private double bMG = 1.0d;

        public final a cL(boolean z) {
            this.bML = z;
            return this;
        }

        public final a cM(boolean z) {
            this.bMM = z;
            return this;
        }

        public final a cN(boolean z) {
            this.bqM = z;
            return this;
        }

        public final a gA(String str) {
            this.bNb = str;
            return this;
        }

        public final a gB(String str) {
            this.bNc = str;
            return this;
        }

        public final a cr(Context context) {
            this.dR = context;
            return this;
        }

        public final a a(f fVar) {
            this.bMV = fVar;
            return this;
        }

        public final a gC(String str) {
            this.platform = str;
            return this;
        }

        public final a gD(String str) {
            this.bMW = str;
            return this;
        }

        public final a gE(String str) {
            this.NJ = str;
            return this;
        }

        public final a gF(String str) {
            this.channel = str;
            return this;
        }

        public final a gG(String str) {
            this.bNa = str;
            return this;
        }

        public final a gH(String str) {
            this.bNg = str;
            return this;
        }

        public final a gI(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a fP(int i) {
            this.bFO = i;
            return this;
        }

        public final a gJ(String str) {
            this.sdkApiVersion = str;
            return this;
        }

        public final a fQ(int i) {
            this.sdkApiVersionCode = i;
            return this;
        }

        public final a fR(int i) {
            this.sdkType = 2;
            return this;
        }

        public final a gK(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a gL(String str) {
            this.appId = str;
            return this;
        }

        public final a gM(String str) {
            this.appName = str;
            return this;
        }

        public final a gN(String str) {
            this.appVersion = str;
            return this;
        }

        public final a gO(String str) {
            this.bMX = str;
            return this;
        }

        public final a gP(String str) {
            this.bMY = str;
            return this;
        }

        public final a a(h hVar) {
            this.bNh = hVar;
            return this;
        }

        public final a f(String[] strArr) {
            this.bNi = strArr;
            return this;
        }

        public final a g(String[] strArr) {
            this.bNj = strArr;
            return this;
        }

        public final a ar(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.bNf.add(aVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.w(c.TAG, Log.getStackTraceString(e));
                    }
                }
            }
            return this;
        }

        public final a p(double d) {
            this.bMG = d;
            return this;
        }

        public final a gQ(String str) {
            this.bNd = str;
            return this;
        }

        public final a gR(String str) {
            this.bNe = str;
            return this;
        }

        public final c aee() {
            return new c(this, (byte) 0);
        }
    }
}
