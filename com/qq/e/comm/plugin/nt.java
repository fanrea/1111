package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nt {
    public static List<String> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object objOpt = jSONArray.opt(i);
                if (objOpt instanceof String) {
                    arrayList.add((String) objOpt);
                }
            }
        }
        return arrayList;
    }

    public static List<Integer> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object objOpt = jSONArray.opt(i);
                if (objOpt instanceof Integer) {
                    arrayList.add((Integer) objOpt);
                }
            }
        }
        return arrayList;
    }
}
