package com.fc.tjcpl.sdk.c;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e implements com.fc.tjcpl.sdk.e.b {
    public List<com.fc.tjcpl.sdk.e.b> a = new ArrayList();
    public Handler b = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public a(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.k(this.b);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;
        public final /* synthetic */ com.fc.tjcpl.sdk.e.a c;

        public b(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar, com.fc.tjcpl.sdk.e.a aVar2) {
            this.a = bVar;
            this.b = aVar;
            this.c = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;
        public final /* synthetic */ String c;

        public c(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar, String str) {
            this.a = bVar;
            this.b = aVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public d(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.h(this.b);
        }
    }

    /* renamed from: com.fc.tjcpl.sdk.c.e$e, reason: collision with other inner class name */
    public class RunnableC0360e implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public RunnableC0360e(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l(this.b);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public f(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f(this.b);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public g(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public h(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c(this.b);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public i(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public j(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g(this.b);
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public k(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(this.b);
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public l(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar, long j, long j2) {
            this.a = bVar;
            this.b = aVar;
            this.c = j;
            this.d = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c, this.d);
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public m(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.i(this.b);
        }
    }

    public class n implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public n(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.e(this.b);
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ com.fc.tjcpl.sdk.e.b a;
        public final /* synthetic */ com.fc.tjcpl.sdk.f.a b;

        public o(e eVar, com.fc.tjcpl.sdk.e.b bVar, com.fc.tjcpl.sdk.f.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.j(this.b);
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void a(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new g(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void a(com.fc.tjcpl.sdk.f.a aVar, long j2, long j3) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new l(this, it.next(), aVar, j2, j3));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void a(com.fc.tjcpl.sdk.f.a aVar, com.fc.tjcpl.sdk.e.a aVar2) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new b(this, it.next(), aVar, aVar2));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void a(com.fc.tjcpl.sdk.f.a aVar, String str) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new c(this, it.next(), aVar, str));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void b(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new i(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void c(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new h(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void d(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new k(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void e(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new n(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void f(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new f(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void g(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new j(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void h(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new d(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void i(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new m(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void j(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new o(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void k(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new a(this, it.next(), aVar));
        }
    }

    @Override // com.fc.tjcpl.sdk.e.b
    public void l(com.fc.tjcpl.sdk.f.a aVar) {
        Iterator<com.fc.tjcpl.sdk.e.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new RunnableC0360e(this, it.next(), aVar));
        }
    }
}
