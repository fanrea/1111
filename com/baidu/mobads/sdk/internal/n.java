package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class n {
    private int a;
    private String b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    n nVarA = a(jSONArray.getJSONObject(i));
                    if (nVarA != null) {
                        arrayList.add(new CpuChannelResponse(nVarA));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static n a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("id", -1);
        String strOptString = jSONObject.optString("name", "");
        if (iOptInt == -1 || TextUtils.isEmpty(strOptString)) {
            return null;
        }
        n nVar = new n();
        nVar.a = iOptInt;
        nVar.b = strOptString;
        return nVar;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
