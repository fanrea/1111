package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private final Set<Integer> ajN = new HashSet();
    private final ConcurrentHashMap<Integer, Set<f>> ajO = new ConcurrentHashMap<>();

    static class a {
        private static final b ajP = new b();
    }

    public static b wo() {
        return a.ajP;
    }

    public final boolean bu(int i) {
        if (this.ajN.contains(Integer.valueOf(i))) {
            return false;
        }
        this.ajN.add(Integer.valueOf(i));
        return true;
    }

    public final void a(int i, f fVar) {
        Set<f> set = this.ajO.get(Integer.valueOf(i));
        if (set != null) {
            set.add(fVar);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(fVar);
        this.ajO.put(Integer.valueOf(i), hashSet);
    }

    private void b(int i, String str, String str2) {
        Set<f> set;
        this.ajN.remove(Integer.valueOf(i));
        if (this.ajO.isEmpty() || this.ajO.get(Integer.valueOf(i)) == null || (set = this.ajO.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        this.ajO.remove(Integer.valueOf(i));
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().vY();
        }
    }

    private void bv(int i) {
        Set<f> set;
        this.ajN.remove(Integer.valueOf(i));
        if (this.ajO.isEmpty() || this.ajO.get(Integer.valueOf(i)) == null || (set = this.ajO.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().vZ();
        }
        this.ajO.remove(Integer.valueOf(i));
    }

    public final void c(int i, String str, String str2) {
        b(i, str, str2);
    }

    public final void bw(int i) {
        bv(i);
    }
}
