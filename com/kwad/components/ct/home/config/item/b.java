package com.kwad.components.ct.home.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.components.ct.response.model.home.ReportInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.core.config.item.b<List<ReportInfo>> {
    public b() {
        super("reportItems", Gb());
    }

    private static ArrayList<ReportInfo> Gb() {
        ArrayList<ReportInfo> arrayList = new ArrayList<>();
        arrayList.add(new ReportInfo(1, "违法违规"));
        arrayList.add(new ReportInfo(2, "色情低俗"));
        arrayList.add(new ReportInfo(3, "作者举报"));
        arrayList.add(new ReportInfo(4, "封面党"));
        arrayList.add(new ReportInfo(5, "不适合未成年"));
        return arrayList;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("reportItems")) != null && jSONArrayOptJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    ReportInfo reportInfo = new ReportInfo();
                    reportInfo.parseJson(jSONObjectOptJSONObject);
                    arrayList.add(reportInfo);
                }
            }
            if (arrayList.size() > 0) {
                setValue(arrayList);
                return;
            }
        }
        setValue(Zh());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        List<ReportInfo> value = getValue();
        if (ap.aM(value)) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ReportInfo> it = value.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            editor.putString("reportItems", jSONArray.toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        try {
            String string = sharedPreferences.getString("reportItems", "");
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        ReportInfo reportInfo = new ReportInfo();
                        reportInfo.parseJson(jSONObjectOptJSONObject);
                        arrayList.add(reportInfo);
                    }
                    if (arrayList.size() > 0) {
                        setValue(arrayList);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        setValue(Zh());
    }
}
