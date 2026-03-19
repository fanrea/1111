package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    final SparseArray<com.kwad.framework.filedownloader.d.c> bem = new SparseArray<>();
    final SparseArray<List<com.kwad.framework.filedownloader.d.a>> ben = new SparseArray<>();

    @Override // com.kwad.framework.filedownloader.b.a
    public final void C(int i, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void dl(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void dq(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void f(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void h(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c dm(int i) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.bem) {
            cVar = this.bem.get(i);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> dn(int i) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.ben) {
                list = this.ben.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    /* renamed from: do */
    public final void mo454do(int i) {
        try {
            synchronized (this.ben) {
                this.ben.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> arrayList;
        try {
            int id = aVar.getId();
            synchronized (this.ben) {
                arrayList = this.ben.get(id);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.ben.put(id, arrayList);
                }
            }
            arrayList.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.ben) {
            list = this.ben.get(i);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i2) {
                aVar.av(j);
                return;
            }
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.bem) {
            this.bem.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (dm(cVar.getId()) != null) {
            synchronized (this.bem) {
                this.bem.remove(cVar.getId());
                this.bem.put(cVar.getId(), cVar);
            }
            return;
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean dp(int i) {
        synchronized (this.bem) {
            this.bem.remove(i);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.bem) {
            this.bem.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void g(int i, long j) {
        dp(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0552a Np() {
        return new a();
    }

    class a implements a.InterfaceC0552a {
        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0552a
        public final void Nq() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0552a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0552a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        a() {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return b.this.new C0553b();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.b.b$b, reason: collision with other inner class name */
    class C0553b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }

        C0553b() {
        }
    }
}
