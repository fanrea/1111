package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m {
    private static final Map<String, String> a = new HashMap();
    private final Map<String, a> b = new HashMap();
    private final Map<String, a> c = new HashMap();
    private final Context d;

    public interface a {
        void valueChange(JSONObject object);
    }

    m(Context context) {
        this.d = context;
    }

    public String a(int type, String key) {
        if (type == 1) {
            return (String) k.b(this.d, key, "");
        }
        Map<String, String> map = a;
        return map.get(key) == null ? "" : map.get(key);
    }

    public void a(int type) throws JSONException {
        if (type == 1) {
            Map<String, ?> mapA = k.a(this.d);
            if (mapA != null && !mapA.isEmpty()) {
                for (Map.Entry<String, ?> entry : mapA.entrySet()) {
                    a aVar = this.b.get(entry.getKey());
                    if (aVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("key", entry.getKey());
                            jSONObject.put("newValue", "");
                            jSONObject.put("oldValue", entry.getValue());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        aVar.valueChange(jSONObject);
                    }
                }
            }
            k.b(this.d);
            return;
        }
        Map<String, String> map = a;
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            a aVar2 = this.c.get(entry2.getKey());
            if (aVar2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("key", entry2.getKey());
                    jSONObject2.put("newValue", "");
                    jSONObject2.put("oldValue", entry2.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                aVar2.valueChange(jSONObject2);
            }
        }
        a.clear();
    }

    public void a(int type, String key, a listener) {
        (type == 1 ? this.b : this.c).put(key, listener);
    }

    public void a(int type, String key, String value) throws JSONException {
        a aVar;
        a aVar2;
        if (type == 1) {
            String str = (String) k.b(this.d, key, "");
            if (str != null && !str.equals(value) && (aVar2 = this.b.get(key)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", key);
                    jSONObject.put("newValue", value);
                    jSONObject.put("oldValue", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar2.valueChange(jSONObject);
            }
            k.a(this.d, key, value);
            return;
        }
        Map<String, String> map = a;
        String str2 = map.get(key) != null ? map.get(key) : "";
        if (str2 != null && !str2.equals(value) && (aVar = this.c.get(key)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", key);
                jSONObject2.put("newValue", value);
                jSONObject2.put("oldValue", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.valueChange(jSONObject2);
        }
        a.put(key, value);
    }

    public int b(int type) {
        if (type != 1) {
            return a.size();
        }
        Map<String, ?> mapA = k.a(this.d);
        if (mapA == null) {
            return 0;
        }
        return mapA.size();
    }

    public void b(int type, String key) throws JSONException {
        a aVar;
        a aVar2;
        if (type == 1) {
            String str = (String) k.b(this.d, key, "");
            if (!TextUtils.isEmpty(str) && (aVar2 = this.b.get(key)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", key);
                    jSONObject.put("newValue", "");
                    jSONObject.put("oldValue", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar2.valueChange(jSONObject);
            }
            k.b(this.d, key);
            return;
        }
        String str2 = a.get(key);
        if (!TextUtils.isEmpty(str2) && (aVar = this.c.get(key)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", key);
                jSONObject2.put("newValue", "");
                jSONObject2.put("oldValue", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.valueChange(jSONObject2);
        }
        a.remove(key);
    }
}
