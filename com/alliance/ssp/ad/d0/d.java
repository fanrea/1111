package com.alliance.ssp.ad.d0;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: ClickCacheManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static List<Long> a(Context context, String str) {
        Set<String> stringSet = context.getSharedPreferences("click_cache_pref", 0).getStringSet("click_cache_times" + str, new HashSet());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong(it.next())));
        }
        return arrayList;
    }
}
