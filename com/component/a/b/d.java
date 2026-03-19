package com.component.a.b;

import android.text.TextUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends o {
    private final String a = "equal";

    public static d a(List<String> list, List<String> list2) {
        d dVar = new d();
        for (int i = 0; i < list.size() && i < list2.size(); i++) {
            dVar.b(list.get(i), list2.get(i));
        }
        return dVar;
    }

    public boolean a(String str, Object obj) {
        try {
            if (!TextUtils.isEmpty(str) && obj != null) {
                if (obj instanceof String) {
                    return TextUtils.equals((String) obj, a(str, ""));
                }
                return obj instanceof Number ? ((Number) obj).doubleValue() == a(str, -1.0d) : (obj instanceof Boolean) && ((Boolean) obj).booleanValue() == a(str, false);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean a(l lVar) {
        for (String str : a()) {
            if (!a(str, lVar.b(str))) {
                return false;
            }
        }
        return true;
    }
}
