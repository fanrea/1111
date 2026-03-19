package com.bytedance.msdk.gb;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class us {
    public static <T> void d(List<T> list, Comparator<T> comparator) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list, comparator);
        } catch (Throwable unused) {
            List listAsList = Arrays.asList(list.toArray());
            Collections.sort(listAsList, comparator);
            list.clear();
            list.addAll(listAsList);
        }
    }

    public static <T extends Comparable<? super T>> void d(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list);
        } catch (Throwable unused) {
            List listAsList = Arrays.asList(list.toArray());
            Collections.sort(listAsList);
            list.clear();
            list.addAll(listAsList);
        }
    }
}
