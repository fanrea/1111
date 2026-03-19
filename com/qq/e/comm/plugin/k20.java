package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k20 {
    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length == 2) {
                return (Integer.parseInt(strArrSplit[0]) * 60) + Integer.parseInt(strArrSplit[1]);
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static int b() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    public static List<iv> a(String str) {
        String[] strArrSplit;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("-");
                if (strArrSplit2.length == 2) {
                    try {
                        iv ivVarA = iv.a(Integer.valueOf(b(strArrSplit2[0])), Integer.valueOf(b(strArrSplit2[1])));
                        qm$h$$ExternalSyntheticBackport0.m(ivVarA);
                        arrayList.add(ivVarA);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean a(List<iv> list) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        int i = (calendar.get(11) * 60) + calendar.get(12);
        Iterator<iv> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public static long a(int i) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, i);
        return calendar.getTimeInMillis();
    }

    public static int a() {
        return Calendar.getInstance(Locale.CHINA).get(11);
    }
}
