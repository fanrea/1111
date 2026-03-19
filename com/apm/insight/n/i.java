package com.apm.insight.n;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.apm.insight.Npth;
import com.apm.insight.runtime.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class i {
    private static final ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> a = new ConcurrentHashMap<>();
    private static final HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> b = new HashMap<>();
    private static volatile i c;
    private volatile boolean e = false;
    private Runnable f = new Runnable() { // from class: com.apm.insight.n.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (Npth.isStopUpload()) {
                return;
            }
            if (!i.b.isEmpty() && com.apm.insight.runtime.p.e()) {
                i.f();
            }
            i.this.c();
            i.this.d.a(i.this.f, 30000L);
        }
    };
    private final v d = com.apm.insight.runtime.q.b();

    private i() {
    }

    public static i a() {
        if (c == null) {
            synchronized (i.class) {
                if (c == null) {
                    c = new i();
                }
            }
        }
        return c;
    }

    public static void a(com.apm.insight.entity.c cVar) throws JSONException {
        a(com.apm.insight.f.a(), cVar);
    }

    public static void a(final Object obj, final com.apm.insight.entity.c cVar) throws JSONException {
        Handler handlerA = com.apm.insight.runtime.q.b().a();
        if (handlerA == null || handlerA.getLooper() != Looper.myLooper()) {
            com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.n.i.2
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    i.a(obj, cVar);
                }
            });
            return;
        }
        if (obj == null) {
            obj = com.apm.insight.f.a();
        }
        if (!com.apm.insight.runtime.p.e()) {
            com.apm.insight.o.q.a("EventUploadQueue", "enqueue before init.");
            c(obj, cVar);
            return;
        }
        if (!com.apm.insight.runtime.a.a(obj)) {
            a.b();
        }
        try {
            o.a(obj);
        } catch (Throwable unused) {
        }
        if (q.a(obj)) {
            com.apm.insight.o.q.b("[reportException]upload limit all.");
            return;
        }
        if (q.a(obj, cVar.h().optString("stack"))) {
            com.apm.insight.o.q.b("[reportException]upload limit stack.");
            return;
        }
        f();
        String string = null;
        try {
            string = cVar.h().getString("log_type");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(string) || !com.apm.insight.runtime.a.a(obj, string)) {
            com.apm.insight.o.q.a("EventUploadQueue", "logType " + string + " not sampled");
        } else {
            com.apm.insight.o.q.a("EventUploadQueue", "logType " + string + " enqueued");
            b(obj, cVar);
        }
    }

    private static void b(Object obj, com.apm.insight.entity.c cVar) {
        ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> concurrentHashMap;
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        synchronized (obj) {
            concurrentHashMap = a;
            concurrentLinkedQueue = concurrentHashMap.get(obj);
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                concurrentHashMap.put(obj, concurrentLinkedQueue);
            }
        }
        concurrentLinkedQueue.add(cVar);
        int size = concurrentHashMap.size();
        boolean z = size >= 30;
        com.apm.insight.o.q.b("[enqueue] size=" + size);
        if (z) {
            g();
        }
    }

    private static void c(Object obj, com.apm.insight.entity.c cVar) throws JSONException {
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        try {
            String string = cVar.h().getString("log_type");
            HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> map = b;
            synchronized (map) {
                HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>> map2 = map.get(string);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(obj, map2);
                }
                concurrentLinkedQueue = map2.get(string);
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                    map2.put(string, concurrentLinkedQueue);
                }
            }
            concurrentLinkedQueue.add(cVar);
            if (concurrentLinkedQueue.size() > 100) {
                concurrentLinkedQueue.poll();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        HashMap map;
        HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> map2 = b;
        synchronized (map2) {
            map = new HashMap(map2);
            map2.clear();
        }
        if (!com.apm.insight.runtime.a.b()) {
            com.apm.insight.o.q.a("EventUploadQueue", "ApmConfig not inited, clear cache.");
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                String str = (String) entry2.getKey();
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) entry2.getValue();
                if (concurrentLinkedQueue == null || (com.apm.insight.runtime.a.b() && !com.apm.insight.runtime.a.a(entry.getKey(), str))) {
                    com.apm.insight.o.q.a("EventUploadQueue", "logType " + str + " not sampled");
                } else {
                    while (!concurrentLinkedQueue.isEmpty()) {
                        try {
                            com.apm.insight.entity.c cVar = (com.apm.insight.entity.c) concurrentLinkedQueue.poll();
                            if (cVar != null) {
                                b(entry.getKey(), cVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    private static void g() {
        if (!com.apm.insight.runtime.p.e() || Npth.isStopUpload()) {
            return;
        }
        try {
            com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.n.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.a().c();
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void b() {
        if (a.isEmpty()) {
            this.d.a(this.f, 30000L);
        } else {
            this.d.a(this.f);
        }
    }

    public void c() {
        synchronized (this.d) {
            if (this.e) {
                return;
            }
            this.e = true;
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> entry : a.entrySet()) {
                ConcurrentLinkedQueue<com.apm.insight.entity.c> value = entry.getValue();
                Object key = entry.getKey();
                while (!value.isEmpty()) {
                    for (int i = 0; i < 30; i++) {
                        try {
                            if (value.isEmpty()) {
                                break;
                            }
                            linkedList.add(value.poll());
                        } catch (Throwable th) {
                            com.apm.insight.o.q.b(th);
                        }
                    }
                    if (linkedList.isEmpty()) {
                        break;
                    }
                    com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(linkedList, com.apm.insight.entity.b.a(key));
                    if (aVarA != null) {
                        com.apm.insight.o.q.a((Object) "upload events");
                        e.a().a(aVarA.h());
                    }
                    linkedList.clear();
                }
            }
            this.e = false;
        }
    }
}
