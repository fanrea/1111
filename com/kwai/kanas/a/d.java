package com.kwai.kanas.a;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import com.kwai.middleware.azeroth.utils.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface d {

    public static final class c implements JsonAdapter<c>, Serializable {
        private static final String c = "custom_stat_event";
        private static final String d = "custom_proto_event";
        public b a;
        public a b;

        public c() {
            a();
        }

        public final c a() {
            this.a = null;
            this.b = null;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c cVar = new c();
                cVar.a = (b) JsonUtils.fromJson(jSONObject, c, b.class);
                cVar.b = (a) JsonUtils.fromJson(jSONObject, d, a.class);
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
                if (this.a != null) {
                    jSONObject.putOpt(c, JsonUtils.toJson(this.a));
                }
                if (this.b != null) {
                    jSONObject.putOpt(d, JsonUtils.toJson(this.b));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static final class b implements JsonAdapter<b>, Serializable {
        private static final String c = "key";
        private static final String d = "value";
        public String a;
        public String b;

        public b() {
            a();
        }

        public final b a() {
            this.a = "";
            this.b = "";
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b fromJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.a = jSONObject.optString(c, "");
                bVar.b = jSONObject.optString("value");
                return bVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(c, this.a);
                jSONObject.putOpt("value", this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static final class a implements JsonAdapter<a>, Serializable {
        private static final String c = "type";
        private static final String d = "payload";
        public String a;
        public String b;

        public a() {
            a();
        }

        public final a a() {
            this.a = "";
            this.b = null;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a fromJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                aVar.a = jSONObject.optString("type", "");
                aVar.b = jSONObject.optString(d, "");
                return aVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", this.a);
                jSONObject.putOpt(d, this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
