package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class uh extends ob {
    private final List<wh> b;

    @Override // com.qq.e.comm.plugin.cm
    public cm a() {
        return this;
    }

    uh(String str) {
        super(str);
        this.b = a(str);
    }

    private Object b(JSONObject jSONObject) {
        Object objA;
        int i = 0;
        Object obj = jSONObject;
        while (true) {
            int i2 = i + 1;
            objA = this.b.get(i).a(obj);
            if (i2 >= this.b.size() || objA == null) {
                break;
            }
            i = i2;
            obj = objA;
        }
        return objA;
    }

    @Override // com.qq.e.comm.plugin.ob
    public Object a(mj mjVar) {
        return mjVar.a(this);
    }

    @Override // com.qq.e.comm.plugin.ob
    Object a(JSONObject jSONObject) {
        List<wh> list;
        if (jSONObject == null || jSONObject.length() <= 0 || (list = this.b) == null || list.size() <= 0) {
            return null;
        }
        Object objB = b(jSONObject);
        return objB == null ? u30.a(jSONObject, this.b) : objB;
    }

    private List<wh> a(String str) {
        String[] strArrSplit = str.split("\\.|\\[");
        if (strArrSplit == null || strArrSplit.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.endsWith("]")) {
                try {
                    arrayList.add(new wh(Integer.parseInt(str2.substring(0, str2.length() - 1))));
                } catch (NumberFormatException unused) {
                    return null;
                }
            } else {
                arrayList.add(new wh(str2));
            }
        }
        return arrayList;
    }
}
