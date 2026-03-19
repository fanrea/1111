package com.tencent.turingfd.sdk.ams.au;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class UrsaMinor {
    public static final List<String> a = new ArrayList();

    public static synchronized List<String> a(ITuringPkgProvider iTuringPkgProvider) {
        List<String> list;
        List<String> listA;
        list = a;
        ArrayList arrayList = (ArrayList) list;
        if (arrayList.isEmpty() && iTuringPkgProvider != null && (listA = iTuringPkgProvider.a()) != null && !listA.isEmpty()) {
            arrayList.addAll(listA);
        }
        return list;
    }

    public static String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        try {
            for (String str : set) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(str);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
