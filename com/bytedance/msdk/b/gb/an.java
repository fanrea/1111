package com.bytedance.msdk.b.gb;

import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.gb.j;
import com.kuaishou.android.live.network.ApiStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    public static boolean b(int i) {
        return i == -100;
    }

    public static boolean d(int i) {
        return i >= -299 && i < -100;
    }

    public static boolean hc(int i) {
        return i == 0;
    }

    public static boolean d(int i, List<Integer> list) {
        if (j.d(list) || i >= list.size() || list.get(i).intValue() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2).intValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static int d(com.bytedance.msdk.core.tc.hc hcVar, tc tcVar) {
        if (hcVar == null || tcVar == null) {
            return ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
        }
        if (hcVar.mk() && tcVar.mt()) {
            return tcVar.yi();
        }
        return tcVar.np();
    }

    public static int d(com.bytedance.msdk.core.tc.hc hcVar, com.bytedance.msdk.hc.b bVar) {
        if (hcVar == null || bVar == null) {
            return ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
        }
        if (hcVar.mk() && bVar.p()) {
            return bVar.gu();
        }
        return bVar.ho();
    }

    public static Map<Integer, List<tc>> d(List<tc> list, boolean z) {
        int iNp;
        HashMap map = new HashMap();
        if (j.d(list)) {
            return map;
        }
        for (int i = 0; i < list.size(); i++) {
            tc tcVar = list.get(i);
            if (tcVar != null) {
                if (z && tcVar.mt()) {
                    iNp = tcVar.yi();
                } else {
                    iNp = tcVar.np();
                }
                List arrayList = (List) map.get(Integer.valueOf(iNp));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(tcVar);
                map.put(Integer.valueOf(iNp), arrayList);
            }
        }
        return map;
    }

    public static List<tc> d(List<tc> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tc tcVar : list) {
            if (tcVar != null && tcVar.rf() == 100) {
                arrayList.add(tcVar);
            }
        }
        return arrayList;
    }

    public static List<tc> hc(List<tc> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tc tcVar : list) {
            if (tcVar != null && tcVar.rf() == 0) {
                arrayList.add(tcVar);
            }
        }
        return arrayList;
    }

    public static List<tc> b(List<tc> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tc tcVar : list) {
            if (tcVar != null && (tcVar.rf() == 1 || tcVar.rf() == 3)) {
                arrayList.add(tcVar);
            }
        }
        return arrayList;
    }
}
