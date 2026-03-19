package com.ss.android.downloadlib.addownload.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.downloadlib.h.uo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private final ConcurrentHashMap<Long, com.ss.android.d.d.b.hc> b;
    private final ConcurrentHashMap<Long, com.ss.android.d.d.b.d> c;
    private volatile boolean d;
    private final ConcurrentHashMap<Long, com.ss.android.d.d.b.b> hc;
    private final ConcurrentHashMap<Long, com.ss.android.hc.d.hc.hc> u;

    private static class d {
        private static an d = new an();
    }

    public static an d() {
        return d.d;
    }

    private an() {
        this.d = false;
        this.hc = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.u = new ConcurrentHashMap<>();
    }

    public void hc() {
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hc.an.1
            @Override // java.lang.Runnable
            public void run() {
                if (an.this.d) {
                    return;
                }
                synchronized (an.class) {
                    if (!an.this.d) {
                        an.this.u.putAll(tt.d().hc());
                        an.this.d = true;
                    }
                }
            }
        }, true);
    }

    public void d(com.ss.android.d.d.b.b bVar) {
        if (bVar != null) {
            this.hc.put(Long.valueOf(bVar.c()), bVar);
            if (bVar.zw() != null) {
                bVar.zw().d(bVar.c());
                bVar.zw().c(bVar.he());
            }
        }
    }

    public void d(long j, com.ss.android.d.d.b.hc hcVar) {
        if (hcVar != null) {
            this.b.put(Long.valueOf(j), hcVar);
        }
    }

    public void d(long j, com.ss.android.d.d.b.d dVar) {
        if (dVar != null) {
            this.c.put(Long.valueOf(j), dVar);
        }
    }

    public synchronized void d(com.ss.android.hc.d.hc.hc hcVar) {
        if (hcVar == null) {
            return;
        }
        this.u.put(Long.valueOf(hcVar.hc()), hcVar);
        tt.d().d(hcVar);
    }

    public com.ss.android.d.d.b.b d(long j) {
        return this.hc.get(Long.valueOf(j));
    }

    public com.ss.android.d.d.b.hc hc(long j) {
        return this.b.get(Long.valueOf(j));
    }

    public com.ss.android.d.d.b.d b(long j) {
        return this.c.get(Long.valueOf(j));
    }

    public com.ss.android.hc.d.hc.hc c(long j) {
        return this.u.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.ss.android.hc.d.hc.hc> b() {
        return this.u;
    }

    public com.ss.android.hc.d.hc.hc d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.hc.d.hc.hc hcVar : this.u.values()) {
            if (hcVar != null && str.equals(hcVar.u())) {
                return hcVar;
            }
        }
        return null;
    }

    public com.ss.android.hc.d.hc.hc hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.hc.d.hc.hc hcVar : this.u.values()) {
            if (hcVar != null && str.equals(hcVar.d())) {
                return hcVar;
            }
        }
        return null;
    }

    public com.ss.android.hc.d.hc.hc d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return null;
        }
        for (com.ss.android.hc.d.hc.hc hcVar : this.u.values()) {
            if (hcVar != null && hcVar.rf() == bVar.h()) {
                return hcVar;
            }
        }
        if (!TextUtils.isEmpty(bVar.s())) {
            try {
                long jD = uo.d(new JSONObject(bVar.s()), "extra");
                if (jD != 0) {
                    for (com.ss.android.hc.d.hc.hc hcVar2 : this.u.values()) {
                        if (hcVar2 != null && hcVar2.hc() == jD) {
                            return hcVar2;
                        }
                    }
                    com.ss.android.downloadlib.u.b.d().d("getNativeModelByInfo");
                }
            } catch (Exception e) {
                mq.d(e);
            }
        }
        for (com.ss.android.hc.d.hc.hc hcVar3 : this.u.values()) {
            if (hcVar3 != null && TextUtils.equals(hcVar3.d(), bVar.tc())) {
                return hcVar3;
            }
        }
        return null;
    }

    public com.ss.android.hc.d.hc.hc d(int i) {
        for (com.ss.android.hc.d.hc.hc hcVar : this.u.values()) {
            if (hcVar != null && hcVar.rf() == i) {
                return hcVar;
            }
        }
        return null;
    }

    public u u(long j) {
        u uVar = new u();
        uVar.d = j;
        uVar.hc = d(j);
        uVar.b = hc(j);
        if (uVar.b == null) {
            uVar.b = new com.ss.android.d.d.b.h();
        }
        uVar.c = b(j);
        if (uVar.c == null) {
            uVar.c = new com.ss.android.d.d.b.an();
        }
        return uVar;
    }

    public void an(long j) {
        this.hc.remove(Long.valueOf(j));
        this.b.remove(Long.valueOf(j));
        this.c.remove(Long.valueOf(j));
    }

    public Map<Long, com.ss.android.hc.d.hc.hc> d(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.hc.d.hc.hc hcVar : this.u.values()) {
                if (hcVar != null && TextUtils.equals(hcVar.d(), str)) {
                    hcVar.hc(str2);
                    map.put(Long.valueOf(hcVar.hc()), hcVar);
                }
            }
        }
        return map;
    }

    public void hc(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (com.ss.android.d.d.b.b bVar : this.hc.values()) {
            if ((bVar instanceof com.ss.android.hc.d.d.b) && TextUtils.equals(bVar.d(), str)) {
                ((com.ss.android.hc.d.d.b) bVar).gb(str2);
            }
        }
    }

    public synchronized void d(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.u.remove(Long.valueOf(jLongValue));
        }
        tt.d().d((List<String>) arrayList);
    }
}
