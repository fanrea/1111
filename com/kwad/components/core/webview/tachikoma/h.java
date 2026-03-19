package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> ahd = new ConcurrentHashMap();
    private Map<String, Integer> ahe = new ConcurrentSkipListMap();
    private int ahf = 0;

    static class a {
        private static final h ahg = new h();
    }

    public static h vu() {
        return a.ahg;
    }

    public final void b(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2) || com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzM) == 0) {
            return;
        }
        if (this.ahd.containsKey(str)) {
            HashMap<Integer, String> map = this.ahd.get(str);
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return;
            } else {
                this.ahd.remove(str);
            }
        }
        bo(bi(str2));
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(Integer.valueOf(i), str2);
        this.ahd.put(str, map2);
        r(str, str2);
    }

    public final String n(String str, int i) {
        HashMap<Integer, String> map;
        return (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzM) != 0 && this.ahd.containsKey(str) && (map = this.ahd.get(str)) != null && map.containsKey(Integer.valueOf(i))) ? map.get(Integer.valueOf(i)) : "";
    }

    private static int bi(String str) {
        return ((((str.length() * 2) + 12) + 16) + 16) / 1024;
    }

    private void r(String str, String str2) {
        int iBi = bi(str2);
        this.ahf += iBi;
        this.ahe.put(str, Integer.valueOf(iBi));
    }

    private void bo(int i) {
        if (this.ahf + i > com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzM)) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = this.ahe.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                arrayList.add(next.getKey());
                this.ahf -= next.getValue().intValue();
                it.remove();
                if (this.ahf <= com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzM) - i) {
                    break;
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.ahd.remove((String) it2.next());
            }
        }
    }
}
