package com.kwai.kanas.a;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.Charsets;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface a {
    public static final byte[] a = new byte[0];

    public static final class c implements JsonAdapter<c>, Serializable {
        private static final String h = "country";
        private static final String i = "province";
        private static final String j = "city";
        private static final String k = "county";
        private static final String l = "street";
        private static final String m = "latitude";
        private static final String n = "longitude";
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public double f;
        public double g;

        public c() {
            a();
        }

        public final c a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = 0.0d;
            this.g = 0.0d;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c cVar = new c();
                cVar.a = jSONObject.optString(h, "");
                cVar.b = jSONObject.optString(i, "");
                cVar.c = jSONObject.optString(j, "");
                cVar.d = jSONObject.optString(k, "");
                cVar.e = jSONObject.optString(l, "");
                cVar.f = jSONObject.optDouble(m, 0.0d);
                cVar.g = jSONObject.optDouble(n, 0.0d);
                return cVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(h, this.a);
                jSONObject.putOpt(i, this.b);
                jSONObject.putOpt(j, this.c);
                jSONObject.putOpt(k, this.d);
                jSONObject.putOpt(l, this.e);
                jSONObject.putOpt(m, Double.valueOf(this.f));
                jSONObject.putOpt(n, Double.valueOf(this.g));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static final class b implements JsonAdapter<b>, Serializable {
        private static final String d = "device_id";
        private static final String e = "global_id";
        private static final String f = "user_id";
        public String a;
        public String b;
        public String c;

        public b() {
            a();
        }

        public final b a() {
            this.a = "";
            this.c = "";
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.a = jSONObject.optString("device_id", "");
                bVar.b = jSONObject.optString(e, "");
                bVar.c = jSONObject.optString(f, "");
                return bVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("device_id", this.a);
                jSONObject.putOpt(e, this.b);
                jSONObject.putOpt(f, this.c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: com.kwai.kanas.a.a$a, reason: collision with other inner class name */
    public static final class C0645a implements JsonAdapter<C0645a>, Serializable {
        private static final String d = "os_version";
        private static final String e = "model";
        private static final String f = "ua";
        public String a;
        public String b;
        public String c;

        public C0645a() {
            a();
        }

        public final C0645a a() {
            this.a = "";
            this.b = "";
            this.c = "";
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C0645a fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C0645a c0645a = new C0645a();
                c0645a.a = jSONObject.optString(d, "");
                c0645a.b = jSONObject.optString("model", "");
                c0645a.c = jSONObject.optString(f, "");
                return c0645a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(d, this.a);
                jSONObject.putOpt("model", this.b);
                jSONObject.putOpt(f, this.c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static final class d implements JsonAdapter<d>, Serializable {
        private static final String e = "type";
        private static final String f = "isp";
        private static final String g = "ip";
        private static final String h = "ipv6";
        public int a;
        public String b;
        public String c;
        public byte[] d;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.kwai.kanas.a.a$d$a, reason: collision with other inner class name */
        public @interface InterfaceC0646a {
            public static final int a = 0;
            public static final int b = 1;
            public static final int c = 2;
            public static final int d = 3;
            public static final int e = 4;
            public static final int f = 5;
            public static final int g = 6;
            public static final int h = 7;
        }

        public d() {
            a();
        }

        public final d a() {
            this.a = 0;
            this.b = "";
            this.c = "";
            this.d = a.a;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                d dVar = new d();
                dVar.a = jSONObject.optInt("type", 0);
                dVar.b = jSONObject.optString(f, "");
                dVar.c = jSONObject.optString(g, "");
                dVar.d = jSONObject.optString(h, "").getBytes(Charsets.UTF_8);
                return dVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", Integer.valueOf(this.a));
                jSONObject.putOpt(f, this.b);
                jSONObject.putOpt(g, this.c);
                jSONObject.putOpt(h, new String(this.d, Charsets.UTF_8));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }
}
