package com.tk.core.component.text;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tk.core.o.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e {
    public static Map<String, List<a>> aeX;
    public static Map<String, List<a>> aeY;

    public interface a {
        void a(Typeface typeface, boolean z, int i);
    }

    public static void a(String str, a aVar) {
        Map<String, List<a>> map;
        List<a> list;
        List<a> list2;
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        boolean zRemove = false;
        Map<String, List<a>> map2 = aeX;
        if (map2 != null && (list2 = map2.get(str)) != null) {
            zRemove = list2.remove(aVar);
        }
        if (zRemove || (map = aeY) == null || (list = map.get(str)) == null) {
            return;
        }
        list.remove(aVar);
    }

    public static void a(String str, Context context, String str2, String str3, int i, int i2, a aVar) {
        if (d.g(context, str3)) {
            a(str3, str, i, i2, aVar);
        } else {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            b(str, context, str2, str3, i, i2, aVar);
        }
    }

    private static void a(final String str, final String str2, final int i, final int i2, a aVar) {
        if (aeY == null) {
            aeY = new HashMap();
        }
        List<a> arrayList = aeY.get(str);
        if (arrayList != null && !arrayList.isEmpty()) {
            arrayList.add(aVar);
            return;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            aeY.put(str, arrayList);
        }
        arrayList.add(aVar);
        com.tk.core.o.p.execute(new Runnable() { // from class: com.tk.core.component.text.e.1
            @Override // java.lang.Runnable
            public final void run() {
                final Typeface typefaceB = f.rh().b(str, 0, str2, i);
                ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.text.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        List<a> list = e.aeY.get(str);
                        if (list == null || list.isEmpty()) {
                            return;
                        }
                        for (a aVar2 : list) {
                            if (aVar2 != null) {
                                aVar2.a(typefaceB, false, i2);
                            }
                        }
                        list.clear();
                    }
                });
            }
        });
    }

    private static void b(final String str, Context context, final String str2, final String str3, final int i, final int i2, a aVar) {
        if (aeX == null) {
            aeX = new HashMap();
        }
        List<a> arrayList = aeX.get(str3);
        if (arrayList != null && !arrayList.isEmpty()) {
            arrayList.add(aVar);
            return;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            aeX.put(str3, arrayList);
        }
        arrayList.add(aVar);
        d.a(context, str2, str3, new com.tk.core.a.f() { // from class: com.tk.core.component.text.e.2
        });
    }
}
