package com.bykv.vk.openvk.component.video.d.hc;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.d.hc.hc;
import com.bykv.vk.openvk.component.video.d.hc.tt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static volatile c u;
    private volatile com.bykv.vk.openvk.component.video.d.hc.hc.b an;
    private final hc<Runnable> b;
    private final ExecutorService c;
    private volatile int d = 163840;
    private volatile com.bykv.vk.openvk.component.video.d.hc.d.hc gb;
    private volatile com.bykv.vk.openvk.component.video.d.hc.d.b h;
    private final SparseArray<Map<String, com.bykv.vk.openvk.component.video.d.hc.hc>> hc;
    private volatile boolean k;
    private volatile b mk;
    private volatile b mq;
    private final hc.InterfaceC0164hc tc;
    private final HashSet<d> tt;
    private volatile String uo;

    void d(com.bykv.vk.openvk.component.video.d.hc.d.b bVar) {
        this.h = bVar;
    }

    void d(com.bykv.vk.openvk.component.video.d.hc.hc.b bVar) {
        this.an = bVar;
    }

    public void d(int i) {
        if (i > 0) {
            this.d = i;
        }
        if (u.b) {
            com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_Preloader", "MaxPreloadSize: ".concat(String.valueOf(i)));
        }
    }

    private c() {
        SparseArray<Map<String, com.bykv.vk.openvk.component.video.d.hc.hc>> sparseArray = new SparseArray<>(2);
        this.hc = sparseArray;
        this.tt = new HashSet<>();
        this.tc = new hc.InterfaceC0164hc() { // from class: com.bykv.vk.openvk.component.video.d.hc.c.1
            @Override // com.bykv.vk.openvk.component.video.d.hc.hc.InterfaceC0164hc
            public void d(com.bykv.vk.openvk.component.video.d.hc.hc hcVar) {
                int iAn = hcVar.an();
                synchronized (c.this.hc) {
                    Map map = (Map) c.this.hc.get(iAn);
                    if (map != null) {
                        map.remove(hcVar.gb);
                    }
                }
                if (u.b) {
                    String str = hcVar.gb;
                }
            }
        };
        hc<Runnable> hcVar = new hc<>();
        this.b = hcVar;
        ExecutorService executorServiceD = d(hcVar);
        this.c = executorServiceD;
        hcVar.d((ThreadPoolExecutor) executorServiceD);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    b d() {
        return this.mk;
    }

    b hc() {
        return this.mq;
    }

    public static c b() {
        if (u == null) {
            synchronized (c.class) {
                if (u == null) {
                    u = new c();
                }
            }
        }
        return u;
    }

    void d(boolean z, String str) {
        com.bykv.vk.openvk.component.video.d.hc.hc hcVarRemove;
        this.uo = str;
        this.k = z;
        if (u.b) {
            com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_Preloader", "setCurrentPlayKey, ".concat(String.valueOf(str)));
        }
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        if (str == null) {
            synchronized (this.tt) {
                if (!this.tt.isEmpty()) {
                    hashSet2 = new HashSet(this.tt);
                    this.tt.clear();
                }
            }
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    d(dVar.d, dVar.hc, dVar.b, dVar.c, dVar.u, dVar.an);
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + dVar.c);
                    }
                }
                return;
            }
            return;
        }
        int i = u.gb;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.hc) {
                    Map<String, com.bykv.vk.openvk.component.video.d.hc.hc> map = this.hc.get(com.bykv.vk.openvk.component.video.d.hc.hc.hc.d(z));
                    hcVarRemove = map != null ? map.remove(str) : null;
                }
                if (hcVarRemove != null) {
                    hcVarRemove.d();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.hc) {
            int size = this.hc.size();
            for (int i2 = 0; i2 < size; i2++) {
                SparseArray<Map<String, com.bykv.vk.openvk.component.video.d.hc.hc>> sparseArray = this.hc;
                Map<String, com.bykv.vk.openvk.component.video.d.hc.hc> map2 = sparseArray.get(sparseArray.keyAt(i2));
                if (map2 != null) {
                    Collection<com.bykv.vk.openvk.component.video.d.hc.hc> collectionValues = map2.values();
                    if (collectionValues != null && !collectionValues.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(collectionValues);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            com.bykv.vk.openvk.component.video.d.hc.hc hcVar = (com.bykv.vk.openvk.component.video.d.hc.hc) it2.next();
            hcVar.d();
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + hcVar.h);
            }
        }
        if (i == 3) {
            synchronized (this.tt) {
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    d dVar2 = (d) ((com.bykv.vk.openvk.component.video.d.hc.hc) it3.next()).k;
                    if (dVar2 != null) {
                        this.tt.add(dVar2);
                    }
                }
            }
        }
    }

    public void d(boolean z, boolean z2, int i, String str, String... strArr) {
        d(z, z2, i, str, null, strArr);
    }

    public void d(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        boolean z3 = u.b;
        com.bykv.vk.openvk.component.video.d.hc.d.d dVar = z ? this.gb : this.h;
        com.bykv.vk.openvk.component.video.d.hc.hc.b bVar = this.an;
        if (dVar == null || bVar == null) {
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = i <= 0 ? this.d : i;
        String strD = z2 ? str : com.bykv.vk.openvk.component.video.api.an.hc.d(str);
        File fileC = dVar.c(strD);
        if (fileC != null && fileC.length() >= i2) {
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_Preloader", "no need preload, file size: " + fileC.length() + ", need preload size: " + i2);
                return;
            }
            return;
        }
        if (an.d().d(com.bykv.vk.openvk.component.video.d.hc.hc.hc.d(z), strD)) {
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.hc("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: ".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        synchronized (this.hc) {
            Map<String, com.bykv.vk.openvk.component.video.d.hc.hc> map2 = this.hc.get(z ? 1 : 0);
            if (map2.containsKey(strD)) {
                return;
            }
            int i3 = i2;
            d dVar2 = new d(z, z2, i2, str, map, strArr);
            String str2 = this.uo;
            if (str2 != null) {
                int i4 = u.gb;
                if (i4 == 3) {
                    synchronized (this.tt) {
                        this.tt.add(dVar2);
                    }
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.hc("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                    }
                    return;
                }
                if (i4 == 2) {
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.hc("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                    }
                    return;
                } else if (i4 == 1 && this.k == z && str2.equals(strD)) {
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.hc("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                    }
                    return;
                }
            }
            ArrayList arrayList = null;
            List<tt.hc> listD = com.bykv.vk.openvk.component.video.d.b.d.d(com.bykv.vk.openvk.component.video.d.b.d.d(map));
            if (listD != null) {
                arrayList = new ArrayList(listD.size());
                int size = listD.size();
                for (int i5 = 0; i5 < size; i5++) {
                    tt.hc hcVar = listD.get(i5);
                    if (hcVar != null) {
                        arrayList.add(new tt.hc(hcVar.d, hcVar.hc));
                    }
                }
            }
            com.bykv.vk.openvk.component.video.d.hc.hc hcVarD = new hc.d().d(dVar).d(bVar).d(str).hc(strD).d(new mq(com.bykv.vk.openvk.component.video.d.b.d.d(strArr))).d((List<tt.hc>) arrayList).d(i3).d(this.tc).d(dVar2).d();
            map2.put(strD, hcVarD);
            this.c.execute(hcVarD);
        }
    }

    public void d(String str) {
        d(false, false, str);
    }

    public void d(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.component.video.d.b.d.d(new com.bytedance.sdk.component.tc.tt("cancel b b S") { // from class: com.bykv.vk.openvk.component.video.d.hc.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.d.hc.hc hcVar;
                synchronized (c.this.hc) {
                    Map map = (Map) c.this.hc.get(com.bykv.vk.openvk.component.video.d.hc.hc.hc.d(z));
                    if (map != null) {
                        hcVar = (com.bykv.vk.openvk.component.video.d.hc.hc) map.remove(z2 ? str : com.bykv.vk.openvk.component.video.api.an.hc.d(str));
                    } else {
                        hcVar = null;
                    }
                }
                if (hcVar != null) {
                    hcVar.d();
                }
            }
        });
    }

    public void c() {
        com.bykv.vk.openvk.component.video.d.b.d.d(new com.bytedance.sdk.component.tc.tt("cancelAll") { // from class: com.bykv.vk.openvk.component.video.d.hc.c.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.component.video.d.hc.hc> arrayList = new ArrayList();
                synchronized (c.this.hc) {
                    int size = c.this.hc.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) c.this.hc.get(c.this.hc.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    c.this.b.clear();
                }
                for (com.bykv.vk.openvk.component.video.d.hc.hc hcVar : arrayList) {
                    hcVar.d();
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.hc("TAG_PROXY_Preloader", "PreloadTask: " + hcVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    private static final class d {
        final String[] an;
        final int b;
        final String c;
        final boolean d;
        final boolean hc;
        final Map<String, String> u;

        d(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.d = z;
            this.hc = z2;
            this.b = i;
            this.c = str;
            this.u = map;
            this.an = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.d == dVar.d && this.hc == dVar.hc && this.b == dVar.b) {
                return this.c.equals(dVar.c);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.d ? 1 : 0) * 31) + (this.hc ? 1 : 0)) * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    private static final class hc<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor d;

        private hc() {
        }

        public void d(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.d != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.d = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.d.getPoolSize();
                int activeCount = this.d.getActiveCount();
                int maximumPoolSize = this.d.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private static ExecutorService d(final hc<Runnable> hcVar) {
        int i;
        int iD = com.bykv.vk.openvk.component.video.d.b.d.d();
        if (iD > 0) {
            if (iD > 4) {
                i = 4;
            }
            return new com.bytedance.sdk.component.tc.c.c(0, i, 60L, TimeUnit.SECONDS, hcVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.d.hc.c.4
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(runnable) { // from class: com.bykv.vk.openvk.component.video.d.hc.c.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Process.setThreadPriority(10);
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.mq.d(th);
                            }
                            super.run();
                        }
                    };
                    bVar.setName("csj_video_preload_" + bVar.getId());
                    bVar.setDaemon(true);
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_Preloader", "new preload thead: " + bVar.getName());
                    }
                    return bVar;
                }
            }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.d.hc.c.5
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    try {
                        hcVar.offerFirst(runnable);
                        if (u.b) {
                            com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                }
            });
        }
        iD = 1;
        i = iD;
        return new com.bytedance.sdk.component.tc.c.c(0, i, 60L, TimeUnit.SECONDS, hcVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.d.hc.c.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(runnable) { // from class: com.bykv.vk.openvk.component.video.d.hc.c.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.mq.d(th);
                        }
                        super.run();
                    }
                };
                bVar.setName("csj_video_preload_" + bVar.getId());
                bVar.setDaemon(true);
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_Preloader", "new preload thead: " + bVar.getName());
                }
                return bVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.d.hc.c.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    hcVar.offerFirst(runnable);
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            }
        });
    }
}
