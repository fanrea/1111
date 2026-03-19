package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class l {
    public static int bsA;

    public static void a(a.C0569a c0569a) {
        bsA++;
        a(1, c0569a, 0L, 0, "");
    }

    public static void a(a.C0569a c0569a, long j) {
        a(2, c0569a, j, 0, "");
    }

    public static void a(a.C0569a c0569a, long j, String str) {
        a(3, c0569a, j, 0, str);
    }

    public static void a(a.C0569a c0569a, int i, String str) {
        a(4, c0569a, 0L, i, str);
    }

    public static void b(a.C0569a c0569a) {
        a(5, c0569a, 0L, 0, "");
    }

    public static void b(a.C0569a c0569a, long j) {
        a(6, c0569a, j, 0, "");
    }

    public static void b(a.C0569a c0569a, int i, String str) {
        a(7, c0569a, 0L, i, str);
    }

    private static void a(int i, a.C0569a c0569a, long j, int i2, String str) {
        if (c0569a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).ec(i).ed(bsA).dJ(c0569a.sdkVersion).dK(c0569a.brR).aO(j).ee(i2).dL(str).toJson();
            new StringBuilder("status:").append(i).append("--jo:").append(json);
            com.kwad.sdk.api.b.g("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }

    static class a {
        private int bsB;
        private int bsC;
        private String bsD;
        private String bsE;
        private long bsF;
        private int bsG;
        private String bsH;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ec(int i) {
            this.bsB = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ed(int i) {
            this.bsC = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dJ(String str) {
            this.bsD = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dK(String str) {
            this.bsE = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aO(long j) {
            this.bsF = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ee(int i) {
            this.bsG = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dL(String str) {
            this.bsH = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.bsB));
                jSONObject.putOpt("update_count", Integer.valueOf(this.bsC));
                jSONObject.putOpt("dynamic_version", this.bsD);
                jSONObject.putOpt("download_url", this.bsE);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.bsF));
                jSONObject.putOpt("error_code", Integer.valueOf(this.bsG));
                jSONObject.putOpt("error_msg", this.bsH);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.bsB + ", update_count=" + this.bsC + ", dynamic_version='" + this.bsD + "', download_url='" + this.bsE + "', duration_ms=" + this.bsF + ", error_code=" + this.bsG + ", error_msg='" + this.bsH + "'}";
        }
    }
}
