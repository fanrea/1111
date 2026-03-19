package com.kwai.kanas.a;

import com.kwai.kanas.a.a;
import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface b {

    public static final class c implements JsonAdapter<c>, Serializable {
        private static final String l = "identity_package";
        private static final String m = "app_package";
        private static final String n = "device_package";
        private static final String o = "network_package";
        private static final String p = "location_package";
        private static final String q = "sdk_version";
        private static final String r = "service_name";
        private static final String s = "sub_biz";
        private static final String t = "additional_seq_id_package";
        private static final String u = "need_encrypt";
        private static final String v = "global_attr";
        public a.b a;
        public C0648b b;
        public a.C0645a c;
        public a.d d;
        public a.c e;
        public String f;
        public String g;
        public String h;
        public a i;
        public boolean j;
        public String k;

        public c() {
            a();
        }

        public final c a() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = null;
            this.j = false;
            this.k = "";
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c cVar = new c();
                cVar.a = (a.b) JsonUtils.fromJson(jSONObject, l, a.b.class);
                cVar.b = (C0648b) JsonUtils.fromJson(jSONObject, m, C0648b.class);
                cVar.c = (a.C0645a) JsonUtils.fromJson(jSONObject, n, a.C0645a.class);
                cVar.d = (a.d) JsonUtils.fromJson(jSONObject, o, a.d.class);
                cVar.e = (a.c) JsonUtils.fromJson(jSONObject, p, a.c.class);
                cVar.i = (a) JsonUtils.fromJson(jSONObject, t, a.class);
                cVar.f = jSONObject.optString("sdk_version", "");
                cVar.g = jSONObject.optString(r, "");
                cVar.h = jSONObject.optString(s, "");
                cVar.j = jSONObject.optBoolean(u, false);
                cVar.k = jSONObject.optString(v, "");
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
                jSONObject.putOpt(l, JsonUtils.toJson(this.a));
                jSONObject.putOpt(m, JsonUtils.toJson(this.b));
                jSONObject.putOpt(n, JsonUtils.toJson(this.c));
                jSONObject.putOpt(o, JsonUtils.toJson(this.d));
                jSONObject.putOpt(p, JsonUtils.toJson(this.e));
                jSONObject.putOpt(t, JsonUtils.toJson(this.i));
                jSONObject.putOpt("sdk_version", this.f);
                jSONObject.putOpt(r, this.g);
                jSONObject.putOpt(s, this.h);
                jSONObject.putOpt(u, Boolean.valueOf(this.j));
                jSONObject.putOpt(v, this.k);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static final class a implements JsonAdapter<a>, Serializable {
        private static final String e = "channel";
        private static final String f = "channel_seq_id";
        private static final String g = "custom_type";
        private static final String h = "custom_seq_id";
        public int a;
        public long b;
        public String c;
        public long d;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.kwai.kanas.a.b$a$a, reason: collision with other inner class name */
        public @interface InterfaceC0647a {
            public static final int a = 0;
            public static final int b = 1;
            public static final int c = 2;
            public static final int d = 3;
        }

        public a() {
            a();
        }

        public final a a() {
            this.a = 0;
            this.b = 0L;
            this.c = "";
            this.d = 0L;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                aVar.a = jSONObject.optInt(e, 0);
                aVar.b = jSONObject.optLong(f, 0L);
                aVar.c = jSONObject.optString(g, "");
                aVar.d = jSONObject.optLong(h, 0L);
                return aVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(e, Integer.valueOf(this.a));
                jSONObject.putOpt(f, Long.valueOf(this.b));
                jSONObject.putOpt(g, this.c);
                jSONObject.putOpt(h, Long.valueOf(this.d));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: com.kwai.kanas.a.b$b, reason: collision with other inner class name */
    public static final class C0648b implements JsonAdapter<C0648b>, Serializable {
        private static final String i = "platform";
        private static final String j = "language";
        private static final String k = "channel";
        private static final String l = "version_name";
        private static final String m = "version_code";
        private static final String n = "package_name";
        private static final String o = "product_name";
        private static final String p = "container";
        public int a;
        public String b;
        public String c;
        public String d;
        public int e;
        public String f;
        public String g;
        public String h;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.kwai.kanas.a.b$b$a */
        public @interface a {
            public static final int a = 0;
            public static final int b = 1;
            public static final int c = 2;
            public static final int d = 3;
            public static final int e = 4;
            public static final int f = 5;
            public static final int g = 6;
            public static final int h = 7;
            public static final int i = 8;
            public static final int j = 9;
            public static final int k = 10;
        }

        public C0648b() {
            a();
        }

        public final C0648b a() {
            this.a = 0;
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = 0;
            this.f = "";
            this.g = "";
            this.h = "";
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C0648b fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C0648b c0648b = new C0648b();
                c0648b.a = jSONObject.optInt(i, 0);
                c0648b.b = jSONObject.optString("language", "");
                c0648b.c = jSONObject.optString(k, "");
                c0648b.d = jSONObject.optString("version_name", "");
                c0648b.e = jSONObject.optInt(m, 0);
                c0648b.f = jSONObject.optString("package_name", "");
                c0648b.g = jSONObject.optString(o, "");
                c0648b.h = jSONObject.optString(p, "");
                return c0648b;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(i, Integer.valueOf(this.a));
                jSONObject.putOpt("language", this.b);
                jSONObject.putOpt(k, this.c);
                jSONObject.putOpt("version_name", this.d);
                jSONObject.putOpt(m, Integer.valueOf(this.e));
                jSONObject.putOpt("package_name", this.f);
                jSONObject.putOpt(o, this.g);
                jSONObject.putOpt(p, this.h);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
