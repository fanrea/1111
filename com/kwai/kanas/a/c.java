package com.kwai.kanas.a;

import com.kwai.kanas.a.b;
import com.kwai.kanas.a.d;
import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface c {

    public static final class b implements JsonAdapter<b>, Serializable {
        private static final String h = "client_timestamp";
        private static final String i = "client_increment_id";
        private static final String j = "session_id";
        private static final String k = "time_zone";
        private static final String l = "common_package";
        private static final String m = "stat_package";
        private static final String n = "event_id";
        public long a;
        public long b;
        public String c;
        public String d;
        public b.c e;
        public d.c f;
        public String g;

        public b() {
            a();
        }

        public final b a() {
            this.a = 0L;
            this.b = 0L;
            this.c = "";
            this.d = "";
            this.e = null;
            this.f = null;
            this.g = "";
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.a = jSONObject.optLong(h, 0L);
                bVar.b = jSONObject.optLong(i, 0L);
                bVar.c = jSONObject.optString(j, "");
                bVar.d = jSONObject.optString(k, "");
                bVar.e = (b.c) JsonUtils.fromJson(jSONObject, l, b.c.class);
                bVar.f = (d.c) JsonUtils.fromJson(jSONObject, m, d.c.class);
                bVar.g = jSONObject.optString(n, "");
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
                jSONObject.putOpt(h, Long.valueOf(this.a));
                jSONObject.putOpt(i, Long.valueOf(this.b));
                jSONObject.putOpt(j, this.c);
                jSONObject.putOpt(k, this.d);
                jSONObject.putOpt(l, JsonUtils.toJson(this.e));
                jSONObject.putOpt(m, JsonUtils.toJson(this.f));
                jSONObject.putOpt(n, this.g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static final class a implements JsonAdapter<a>, Serializable {
        private static final String b = "event";
        public b[] a;

        public a() {
            a();
        }

        public final a a() {
            this.a = new b[0];
            return this;
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a fromJson(String str) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("event");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    a aVar = new a();
                    aVar.a = new b[jSONArrayOptJSONArray.length()];
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        aVar.a[i] = (b) JsonUtils.fromJson(jSONArrayOptJSONArray.optJSONObject(i).toString(), b.class);
                    }
                    return aVar;
                }
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.a != null && this.a.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.a.length; i++) {
                    jSONArray.put(JsonUtils.toJson(this.a[i]));
                }
                jSONObject.putOpt("event", jSONArray);
                return jSONObject;
            }
            return jSONObject;
        }
    }
}
