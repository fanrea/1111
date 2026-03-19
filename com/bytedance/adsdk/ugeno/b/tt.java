package com.bytedance.adsdk.ugeno.b;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    private JSONObject an;
    private String b;
    private JSONObject c;
    private JSONObject d;
    private float gb;
    private boolean h;
    private JSONObject hc;
    private float tt;
    private String u;

    public tt(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public tt(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.d = jSONObject.optJSONObject("body");
            } else {
                this.d = jSONObject.optJSONObject("main_template");
            }
            this.hc = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has("meta")) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.h = true;
                    String strOptString = jSONObjectOptJSONObject.optString(Config.INPUT_DEF_VERSION);
                    this.b = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.b = "3.0";
                    }
                } else {
                    this.b = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.u = jSONObjectOptJSONObject.optString("adType");
                }
            } else if (jSONObject.has("body")) {
                this.b = "3.0";
                this.h = true;
            }
            this.c = jSONObject2;
            this.an = jSONObject3;
        }
    }

    public d d() {
        return u();
    }

    public void d(float f, float f2) {
        this.gb = f;
        this.tt = f2;
    }

    private d u() throws JSONException {
        if (!c()) {
            return d(this.d, (d) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            float f = this.gb;
            if (f > 0.0f) {
                jSONObject.put("width", f);
            }
            float f2 = this.tt;
            if (f2 > 0.0f) {
                jSONObject.put("height", f2);
            }
            String strOptString = this.c.optString("xSize");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (jSONObject2.optInt("width") > 0) {
                    jSONObject.put("width", jSONObject2.optInt("width"));
                }
                if (jSONObject2.optInt("height") > 0) {
                    jSONObject.put("height", jSONObject2.optInt("height"));
                }
            }
        } catch (JSONException unused) {
        }
        d dVar = new d();
        dVar.hc = "View";
        dVar.d = "virtualNode";
        dVar.b = jSONObject;
        dVar.an = null;
        dVar.h = this.b;
        dVar.gb = this.u;
        dVar.d(d(this.d, dVar));
        return dVar;
    }

    public String hc() {
        return this.b;
    }

    public List<d> b() throws JSONException {
        if (this.hc == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.hc.keys();
        while (itKeys.hasNext()) {
            d dVarD = d(this.hc.optJSONObject(itKeys.next()), (d) null);
            if (dVarD != null) {
                arrayList.add(dVarD);
            }
        }
        return arrayList;
    }

    private d d(JSONObject jSONObject, d dVar) throws JSONException {
        String strOptString;
        String strOptString2;
        d dVarD;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString("name");
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            }
        }
        d dVar2 = new d();
        dVar2.d = strOptString3;
        if (!this.h || !TextUtils.equals("Video", strOptString)) {
            dVar2.hc = strOptString;
        } else {
            dVar2.hc = strOptString + "V3";
        }
        dVar2.b = jSONObject2;
        dVar2.an = dVar;
        dVar2.h = this.b;
        dVar2.gb = this.u;
        if (jSONObject2.has("i18n")) {
            dVar2.c = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            d(jSONObject, dVar2.b);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString("name");
                }
                String strD = com.bytedance.adsdk.ugeno.c.hc.d(jSONObjectOptJSONObject.optString("id"), this.c);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.hc;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strD);
                        dVarD = d(jSONObjectOptJSONObject, dVar2);
                    } else {
                        dVarD = null;
                    }
                } else {
                    dVarD = d(jSONObjectOptJSONObject, dVar2);
                }
                if (dVarD != null) {
                    dVarD.hc(hc(dVarD));
                    dVarD.d(d(dVarD));
                }
                if (b(dVarD)) {
                    i++;
                    dVar2.hc(dVarD);
                } else if (dVarD != null) {
                    dVar2.d(i2 - i, dVarD);
                }
            }
        }
        return dVar2;
    }

    public boolean d(d dVar) {
        JSONObject jSONObjectC;
        if (dVar == null || (jSONObjectC = dVar.c()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectC.optString("width"), "match_parent");
    }

    public boolean hc(d dVar) {
        JSONObject jSONObjectC;
        if (dVar == null || (jSONObjectC = dVar.c()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectC.optString("height"), "match_parent");
    }

    public boolean b(d dVar) {
        JSONObject jSONObjectC;
        if (dVar == null || (jSONObjectC = dVar.c()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectC.optString("position"), "absolute");
    }

    public boolean c() {
        return this.h;
    }

    private void d(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (this.an == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.an.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (objOpt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.an.hc.d(jSONObject3.optJSONArray("events"), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    public static boolean c(d dVar) {
        return (dVar == null || dVar.b == null) ? false : true;
    }

    public static class d {
        private d an;
        private JSONObject b;
        private JSONObject c;
        private String d;
        private String gb;
        private String h;
        private String hc;
        private boolean tc;
        private boolean tt;
        private LinkedList<d> u;

        public String d() {
            return this.d;
        }

        public String hc() {
            return this.h;
        }

        public String b() {
            return this.hc;
        }

        public void d(String str) {
            this.hc = str;
        }

        public void d(boolean z) {
            this.tt = z;
        }

        public void hc(boolean z) {
            this.tc = z;
        }

        public JSONObject c() {
            return this.b;
        }

        public List<d> u() {
            return this.u;
        }

        public void d(d dVar) {
            if (this.u == null) {
                this.u = new LinkedList<>();
            }
            this.u.add(dVar);
        }

        public void hc(d dVar) {
            if (this.u == null) {
                this.u = new LinkedList<>();
            }
            this.u.addLast(dVar);
        }

        public void d(int i, d dVar) {
            if (this.u == null) {
                this.u = new LinkedList<>();
            }
            this.u.add(i, dVar);
        }

        public JSONObject an() {
            return this.c;
        }

        public String toString() {
            return "UGNode{id='" + this.d + "', name='" + this.hc + "'}";
        }
    }
}
