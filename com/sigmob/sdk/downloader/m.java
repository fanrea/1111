package com.sigmob.sdk.downloader;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m {
    final List<Integer> b = new ArrayList();
    final c c = new c() { // from class: com.sigmob.sdk.downloader.m.1
        @Override // com.sigmob.sdk.downloader.c
        public void a(f task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(task, blockIndex, responseCode, responseHeaderFields);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f task, int blockIndex, long contentLength) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(task, blockIndex, contentLength);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f task, int responseCode, Map<String, List<String>> responseHeaderFields) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(task, responseCode, responseHeaderFields);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(task, info);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, com.sigmob.sdk.downloader.core.cause.b cause) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(task, info, cause);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(task, cause, realCause);
                }
            }
            if (m.this.b.contains(Integer.valueOf(task.c()))) {
                m.this.a(task.c());
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f task, Map<String, List<String>> requestHeaderFields) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(task, requestHeaderFields);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a_(f task) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a_(task);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(f task, int blockIndex, long increaseBytes) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.b(task, blockIndex, increaseBytes);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(f task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.b(task, blockIndex, requestHeaderFields);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void c(f task, int blockIndex, long contentLength) {
            c[] cVarArrB = m.b(task, m.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.c(task, blockIndex, contentLength);
                }
            }
        }
    };
    final SparseArray<ArrayList<c>> a = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static c[] b(f task, SparseArray<ArrayList<c>> realListenerMap) {
        ArrayList<c> arrayList = realListenerMap.get(task.c());
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        c[] cVarArr = new c[arrayList.size()];
        arrayList.toArray(cVarArr);
        return cVarArr;
    }

    public c a() {
        return this.c;
    }

    public synchronized void a(int id) {
        this.a.remove(id);
    }

    public synchronized void a(c listener) {
        int size = this.a.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            ArrayList<c> arrayListValueAt = this.a.valueAt(i);
            if (arrayListValueAt != null) {
                arrayListValueAt.remove(listener);
                if (arrayListValueAt.isEmpty()) {
                    arrayList.add(Integer.valueOf(this.a.keyAt(i)));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.a.remove(((Integer) it.next()).intValue());
        }
    }

    boolean a(f task) {
        return l.a(task);
    }

    public synchronized boolean a(f task, c listener) {
        int iC = task.c();
        ArrayList<c> arrayList = this.a.get(iC);
        if (arrayList == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(listener);
        if (arrayList.isEmpty()) {
            this.a.remove(iC);
        }
        return zRemove;
    }

    public synchronized void b(int id) {
        if (this.b.contains(Integer.valueOf(id))) {
            return;
        }
        this.b.add(Integer.valueOf(id));
    }

    public synchronized void b(f task, c listener) {
        int iC = task.c();
        ArrayList<c> arrayList = this.a.get(iC);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(iC, arrayList);
        }
        if (!arrayList.contains(listener)) {
            arrayList.add(listener);
            if (listener instanceof com.sigmob.sdk.downloader.core.listener.assist.d) {
                ((com.sigmob.sdk.downloader.core.listener.assist.d) listener).b(true);
            }
        }
    }

    public synchronized void c(int id) {
        this.b.remove(Integer.valueOf(id));
    }

    public synchronized void c(f task, c listener) {
        b(task, listener);
        if (!a(task)) {
            task.b(this.c);
        }
    }

    public synchronized void d(f task, c listener) {
        b(task, listener);
        task.b(this.c);
    }

    public synchronized void e(f task, c listener) {
        b(task, listener);
        task.c(this.c);
    }
}
