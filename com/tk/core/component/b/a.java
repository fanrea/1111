package com.tk.core.component.b;

import android.R;
import android.content.res.ColorStateList;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.container.n.f;
import com.tk.core.o.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public static int h(HashMap map) {
        Integer numValueOf;
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                String string = entry.getKey().toString();
                Object value = entry.getValue();
                if (value instanceof String) {
                    String str = (String) value;
                    if (f.T.equals(string) && (numValueOf = Integer.valueOf(r.parseColor(str))) != null) {
                        return numValueOf.intValue();
                    }
                }
            }
        }
        return -1;
    }

    public static ColorStateList i(HashMap map) {
        int i;
        if (map == null || map.size() <= 0) {
            return null;
        }
        Iterator it = map.entrySet().iterator();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String string = entry.getKey().toString();
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                int iJ = j((HashMap) value);
                if ("disabled".equals(string)) {
                    arrayList.add(new int[]{-16842910});
                    arrayList2.add(Integer.valueOf(iJ));
                } else if ("pressed".equals(string)) {
                    arrayList.add(new int[]{R.attr.state_pressed});
                    arrayList2.add(Integer.valueOf(iJ));
                } else if ("normal".equals(string)) {
                    arrayList.add(new int[0]);
                    arrayList2.add(Integer.valueOf(iJ));
                }
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int[][] iArr = new int[arrayList.size()][];
        int[] iArr2 = new int[arrayList2.size()];
        int size = arrayList.size() - 1;
        while (size >= 0) {
            iArr[i] = (int[]) arrayList.get(size);
            iArr2[i] = ((Integer) arrayList2.get(size)).intValue();
            size--;
            i++;
        }
        return new ColorStateList(iArr, iArr2);
    }

    private static int j(HashMap map) {
        Integer numValueOf;
        for (Map.Entry entry : map.entrySet()) {
            String string = entry.getKey().toString();
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (TypedValues.Custom.S_COLOR.equals(string) && (numValueOf = Integer.valueOf(r.parseColor(str))) != null) {
                    return numValueOf.intValue();
                }
            }
        }
        return -16777216;
    }
}
