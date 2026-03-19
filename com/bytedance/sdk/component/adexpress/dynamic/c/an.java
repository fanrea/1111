package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.c.u;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static HashMap<String, String> h;
    private com.bytedance.sdk.component.adexpress.dynamic.b.c an;
    private com.bytedance.sdk.component.adexpress.dynamic.b.b b;
    private d c;
    private JSONObject d;
    private JSONObject hc;
    private b u;

    static {
        HashMap<String, String> map = new HashMap<>();
        h = map;
        map.put("subtitle", "description");
        h.put(n.l, "source|app.app_name");
        h.put("screenshot", "dynamic_creative.screenshot");
    }

    public an(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.d = jSONObject;
        this.hc = jSONObject2;
        this.b = new com.bytedance.sdk.component.adexpress.dynamic.b.b(jSONObject2);
        this.c = d.d(jSONObject3);
        this.an = com.bytedance.sdk.component.adexpress.dynamic.b.c.d(jSONObject4);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.b.gb d(double d2, int i, double d3, String str, uo uoVar) throws JSONException {
        JSONObject jSONObject;
        this.b.d();
        try {
            jSONObject = new JSONObject(this.an.hc);
        } catch (JSONException e) {
            mq.d(e);
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVarD = d(c.d(this.d, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.b.gb) null);
        d(gbVarD);
        u uVar = new u(d2, i, d3, str, uoVar);
        u.d dVar = new u.d();
        dVar.d = this.c.d;
        dVar.hc = this.c.hc;
        dVar.b = 0.0f;
        uVar.d(dVar);
        uVar.d(gbVarD, 0.0f, 0.0f);
        uVar.d();
        if (uVar.d.c == 65536.0f) {
            return null;
        }
        return uVar.d.an;
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        int iD;
        if (gbVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.d.d.d.d().b() != null) {
            iD = com.bytedance.sdk.component.adexpress.d.d.d.d().b().e();
        } else {
            iD = com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext());
        }
        float fMin = this.c.b ? this.c.d : Math.min(this.c.d, com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), iD));
        if (this.c.hc == 0.0f) {
            gbVar.u(fMin);
            gbVar.tc().u().tc("auto");
            gbVar.an(0.0f);
        } else {
            gbVar.u(fMin);
            gbVar.an(this.c.b ? this.c.hc : Math.min(this.c.hc, com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), com.bytedance.sdk.component.adexpress.c.gb.b(com.bytedance.sdk.component.adexpress.c.getContext()))));
            gbVar.tc().u().tc("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.b.gb d(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) throws JSONException {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.an != null) {
                b bVar = new b();
                this.u = bVar;
                JSONObject jSONObjectD = bVar.d(this.an.d, iOptInt, jSONObject);
                if (jSONObjectD != null) {
                    jSONObject = jSONObjectD;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVarD = d(jSONObject);
        gbVarD.d(gbVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            gbVarD.d((List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>) null);
            return gbVarD;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = gbVarD.tc().u().ar();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVarD2 = d(jSONArrayOptJSONArray2.optJSONObject(i2), gbVarD);
                    if (com.bytedance.sdk.component.adexpress.c.d() && "skip-with-time".equals(gbVarD.tc().getType()) && !"transparent".equals(gbVarD.v()) && !TextUtils.isEmpty(gbVarD.v())) {
                        gbVarD2.b(gbVarD.v());
                    }
                    arrayList.add(gbVarD2);
                    arrayList3.add(gbVarD2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            gbVarD.d(arrayList);
        }
        if (arrayList2.size() > 0) {
            gbVarD.hc(arrayList2);
        }
        return gbVarD;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.b.gb d(JSONObject jSONObject) throws JSONException {
        String strD;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        tt.d(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectD = tt.d(strOptString, tt.d(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar = new com.bytedance.sdk.component.adexpress.dynamic.b.gb();
        if (TextUtils.isEmpty(strOptString2)) {
            gbVar.hc(String.valueOf(gbVar.hashCode()));
        } else {
            gbVar.hc(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            hc(gbVar);
            gbVar.b((float) jSONObjectOptJSONObject.optDouble("x"));
            gbVar.c((float) jSONObjectOptJSONObject.optDouble("y"));
            gbVar.u((float) jSONObjectOptJSONObject.optDouble("width"));
            gbVar.an((float) jSONObjectOptJSONObject.optDouble("height"));
            gbVar.h(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.b.u uVar = new com.bytedance.sdk.component.adexpress.dynamic.b.u();
            uVar.d(strOptString);
            uVar.hc(jSONObjectOptJSONObject.optString("data"));
            uVar.b(jSONObjectOptJSONObject.optString("filterData"));
            uVar.c(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.b.an anVarD = com.bytedance.sdk.component.adexpress.dynamic.b.an.d(jSONObjectOptJSONObject);
            uVar.d(anVarD);
            com.bytedance.sdk.component.adexpress.dynamic.b.an anVarD2 = com.bytedance.sdk.component.adexpress.dynamic.b.an.d(jSONObjectD);
            if (anVarD2 == null) {
                uVar.hc(anVarD);
            } else {
                uVar.hc(anVarD2);
            }
            d(anVarD);
            d(anVarD2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.hc) != null) {
                d(uVar, jSONObject2.optInt("image_mode"));
            }
            String type = uVar.getType();
            com.bytedance.sdk.component.adexpress.dynamic.b.an anVarU = uVar.u();
            if (h.containsKey(type) && !anVarU.xp()) {
                anVarU.jh(h.get(type));
            }
            if (anVarU.xp()) {
                strD = uVar.hc();
            } else {
                strD = d(uVar.hc());
            }
            if (com.bytedance.sdk.component.adexpress.c.d()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    strD = d("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    strD = d("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && anVarD.ic()) {
                    strD = d("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(d()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                uVar.hc(strD + "adx:" + d());
            } else {
                uVar.hc(strD);
            }
            uVar.b(d(uVar.b()));
            gbVar.d(uVar);
        }
        return gbVar;
    }

    private void hc(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        com.bytedance.sdk.component.adexpress.dynamic.b.b bVar;
        Object objD;
        Object objD2;
        Object objD3;
        Object objD4;
        if (gbVar == null || (bVar = this.b) == null || (objD = bVar.d("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objD);
        if (TextUtils.isEmpty(strValueOf) || (objD2 = this.b.d("title")) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objD2);
        if (TextUtils.isEmpty(strValueOf2) || (objD3 = this.b.d("description")) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objD3);
        if (TextUtils.isEmpty(strValueOf3) || (objD4 = this.b.d("icon")) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objD4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objD5 = this.b.d("app.app_name");
        Object objD6 = this.b.d(n.l);
        if (objD5 == null && objD6 == null) {
            return;
        }
        if (objD5 == null) {
            objD5 = objD6;
        }
        String strValueOf5 = String.valueOf(objD5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        gbVar.d("imageUrl", strValueOf);
        gbVar.d("title", strValueOf2);
        gbVar.d("description", strValueOf3);
        gbVar.d("icon", strValueOf4);
        gbVar.d("app_name", strValueOf5);
        gbVar.d(true);
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.b.u uVar, int i) throws JSONException {
        int iLastIndexOf;
        if (i == 5 || i == 15 || i == 50 || i == 154) {
            uVar.d("video");
            String strD = tt.d("video");
            uVar.u().jh(strD);
            String strD2 = tt.d("video", "clickArea");
            if (!TextUtils.isEmpty(strD2)) {
                uVar.u().e(strD2);
                uVar.h().e(strD2);
            }
            uVar.h().jh(strD);
            uVar.hc(strD);
            uVar.u().om();
            return;
        }
        uVar.d("image");
        String strD3 = tt.d("image");
        com.bytedance.sdk.component.adexpress.dynamic.b.an anVarU = uVar.u();
        anVarU.jh(strD3);
        uVar.h().jh(strD3);
        String strD4 = tt.d("image", "clickArea");
        if (!TextUtils.isEmpty(strD4)) {
            anVarU.e(strD4);
            uVar.h().e(strD4);
        }
        JSONObject jSONObjectEl = anVarU.el();
        if (jSONObjectEl != null) {
            anVarU.v(jSONObjectEl.optString("imageLottieTosPath"));
            anVarU.mq(jSONObjectEl.optBoolean("animationsLoop"));
            anVarU.he(jSONObjectEl.optInt("lottieAppNameMaxLength"));
            anVarU.zw(jSONObjectEl.optInt("lottieAdDescMaxLength"));
            anVarU.vv(jSONObjectEl.optInt("lottieAdTitleMaxLength"));
        }
        uVar.hc(strD3);
        if (strD3 != null && (iLastIndexOf = strD3.lastIndexOf(".")) > 0) {
            String strSubstring = strD3.substring(0, iLastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", d(strSubstring + ".width"));
                jSONObject.put("height", d(strSubstring + ".height"));
            } catch (JSONException e) {
                mq.d(e);
            }
            uVar.c(jSONObject.toString());
        }
        anVarU.eu();
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.b.hc(str2)) {
                String strValueOf = String.valueOf(this.b.d(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String d() {
        com.bytedance.sdk.component.adexpress.dynamic.b.b bVar = this.b;
        return bVar == null ? "" : String.valueOf(bVar.d("adx_name"));
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.b.an anVar) {
        if (anVar == null) {
            return;
        }
        String strJ = anVar.j();
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            String strC = com.bytedance.sdk.component.adexpress.c.gb.c(com.bytedance.sdk.component.adexpress.c.getContext());
            if ("zh".equals(strC)) {
                strC = "cn";
            }
            if (!TextUtils.isEmpty(strC) && anVar.an() != null) {
                String strOptString = anVar.an().optString(strC);
                if (!TextUtils.isEmpty(strOptString)) {
                    strJ = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strJ)) {
            return;
        }
        int iIndexOf = strJ.indexOf("{{");
        int iIndexOf2 = strJ.indexOf("}}");
        if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf2 < iIndexOf) {
            anVar.mq(strJ);
            return;
        }
        String strD = d(strJ.substring(iIndexOf + 2, iIndexOf2));
        StringBuilder sb = new StringBuilder(strJ.substring(0, iIndexOf));
        if (!TextUtils.isEmpty(strD)) {
            sb.append(strD);
        }
        sb.append(strJ.substring(iIndexOf2 + 2));
        anVar.mq(sb.toString());
    }

    static class d {
        boolean b;
        float d;
        float hc;

        public static d d(JSONObject jSONObject) {
            d dVar = new d();
            if (jSONObject != null) {
                dVar.d = (float) jSONObject.optDouble("width");
                dVar.hc = (float) jSONObject.optDouble("height");
                dVar.b = jSONObject.optBoolean("isLandscape");
            }
            return dVar;
        }
    }
}
