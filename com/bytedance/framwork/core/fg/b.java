package com.bytedance.framwork.core.fg;

import android.text.TextUtils;
import com.bytedance.framwork.core.apm.SDKMonitor;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: CacheData.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private final LinkedList<k> a = new LinkedList<>();
    private final LinkedList<c> b = new LinkedList<>();
    private final LinkedList<a> c = new LinkedList<>();
    private int d = 200;
    private boolean e;

    public void a(k kVar) {
        if (kVar == null) {
            return;
        }
        synchronized (this.a) {
            if (this.a.size() > this.d) {
                this.a.poll();
            }
            this.a.add(kVar);
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (this.b) {
            if (this.b.size() > this.d) {
                this.b.poll();
            }
            this.b.add(cVar);
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.c) {
            if (this.c.size() > this.d) {
                this.c.poll();
            }
            this.c.add(aVar);
        }
    }

    public void a(final SDKMonitor sDKMonitor) {
        if (this.e) {
            return;
        }
        this.e = true;
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.fg.b.1
            @Override // java.lang.Runnable
            public void run() {
                LinkedList linkedList;
                LinkedList linkedList2;
                LinkedList linkedList3;
                try {
                    synchronized (b.this.a) {
                        linkedList = new LinkedList(b.this.a);
                        b.this.a.clear();
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        b.this.a(sDKMonitor, (k) it.next());
                    }
                    synchronized (b.this.b) {
                        linkedList2 = new LinkedList(b.this.b);
                        b.this.b.clear();
                    }
                    Iterator it2 = linkedList2.iterator();
                    while (it2.hasNext()) {
                        b.this.a(sDKMonitor, (c) it2.next());
                    }
                    synchronized (b.this.c) {
                        linkedList3 = new LinkedList(b.this.c);
                        b.this.c.clear();
                    }
                    Iterator it3 = linkedList3.iterator();
                    while (it3.hasNext()) {
                        b.this.a(sDKMonitor, (a) it3.next());
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SDKMonitor sDKMonitor, k kVar) {
        if (kVar == null || TextUtils.isEmpty(kVar.a)) {
            return;
        }
        sDKMonitor.monitorService(kVar.a, kVar.b, kVar.c, kVar.d, kVar.e, kVar.f, kVar.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SDKMonitor sDKMonitor, c cVar) {
        if (cVar == null) {
            return;
        }
        sDKMonitor.monitorCommonLogInternal(cVar.a, cVar.b, cVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SDKMonitor sDKMonitor, a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a)) {
            return;
        }
        if (aVar.a.equals("api_error")) {
            sDKMonitor.monitorApiError(aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h);
        } else if (aVar.a.equals("api_all")) {
            sDKMonitor.monitorSLA(aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h);
        }
    }
}
