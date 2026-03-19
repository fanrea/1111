package com.qq.e.comm.plugin;

import com.baidu.mobads.sdk.api.SplashAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qy {
    private int a;
    private String b;
    private String c;
    private int d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private JSONArray j;

    public qy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("ret", -1);
        this.b = jSONObject.optString("msg");
        this.c = jSONObject.optString("payload");
        this.d = jSONObject.optInt(SplashAd.KEY_BIDFAIL_ECPM);
        this.e = jSONObject.optString(PointParamKey.PLACEMENT_ID);
        this.f = jSONObject.optInt("adnet_id");
        this.g = jSONObject.optString("nurl");
        this.h = jSONObject.optString("lurl");
        this.i = jSONObject.optString("request_id");
        this.j = jSONObject.optJSONArray("details");
    }

    public int g() {
        return this.a;
    }

    public String f() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int a() {
        return this.f;
    }

    public String h() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public JSONArray b() {
        return this.j;
    }

    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = this.j;
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < this.j.length(); i++) {
                arrayList.add(this.j.optJSONObject(i).optString("lurl"));
            }
        }
        return arrayList;
    }
}
