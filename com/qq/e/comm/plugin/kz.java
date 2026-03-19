package com.qq.e.comm.plugin;

import android.graphics.Point;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class kz {
    private String a;
    private List<Integer> b;
    private List<Point> c;
    private List<String> d;

    public String a() {
        return this.a;
    }

    public List<Integer> b() {
        return this.b;
    }

    public void c(List<String> list) {
        this.d = list;
    }

    public static kz a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        kz kzVar = new kz();
        kzVar.a(jSONObject.optString("date"));
        kzVar.b(nt.a(jSONObject.optJSONArray("index")));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("effectivetime");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    Point point = new Point();
                    point.x = jSONObjectOptJSONObject.optInt("start");
                    point.y = jSONObjectOptJSONObject.optInt(PointCategory.END);
                    arrayList.add(point);
                }
            }
        }
        kzVar.a(arrayList);
        kzVar.c(nt.b(jSONObject.optJSONArray("server_data")));
        return kzVar;
    }

    public void b(List<Integer> list) {
        this.b = list;
    }

    public static List<kz> a(JSONArray jSONArray) {
        kz kzVarA;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object objOpt = jSONArray.opt(i);
                if ((objOpt instanceof JSONObject) && (kzVarA = a((JSONObject) objOpt)) != null) {
                    arrayList.add(kzVarA);
                }
            }
        }
        return arrayList;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(List<Point> list) {
        this.c = list;
    }
}
