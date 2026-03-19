package lkxssdk.w;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class e implements lkxssdk.y.b {
    public List<lkxssdk.y.b> a = new ArrayList();
    public Handler b = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public a(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.i(this.b);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;
        public final /* synthetic */ lkxssdk.y.a c;

        public b(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar, lkxssdk.y.a aVar2) {
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
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;
        public final /* synthetic */ String c;

        public c(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar, String str) {
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
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public d(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.j(this.b);
        }
    }

    /* renamed from: lkxssdk.w.e$e, reason: collision with other inner class name */
    public class RunnableC0850e implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public RunnableC0850e(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public f(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public g(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.k(this.b);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public h(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f(this.b);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public i(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c(this.b);
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public j(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.h(this.b);
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public k(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g(this.b);
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public l(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar, long j, long j2) {
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
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public m(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.m(this.b);
        }
    }

    public class n implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public n(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l(this.b);
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public o(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.e(this.b);
        }
    }

    public class p implements Runnable {
        public final /* synthetic */ lkxssdk.y.b a;
        public final /* synthetic */ lkxssdk.z.a b;

        public p(e eVar, lkxssdk.y.b bVar, lkxssdk.z.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(this.b);
        }
    }

    @Override // lkxssdk.y.b
    public void a(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new f(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void a(lkxssdk.z.a aVar, long j2, long j3) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new l(this, it.next(), aVar, j2, j3));
        }
    }

    @Override // lkxssdk.y.b
    public void a(lkxssdk.z.a aVar, String str) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new c(this, it.next(), aVar, str));
        }
    }

    @Override // lkxssdk.y.b
    public void a(lkxssdk.z.a aVar, lkxssdk.y.a aVar2) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new b(this, it.next(), aVar, aVar2));
        }
    }

    @Override // lkxssdk.y.b
    public void b(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new RunnableC0850e(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void c(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new i(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void d(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new p(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void e(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new o(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void f(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new h(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void g(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new k(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void h(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new j(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void i(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new a(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void j(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new d(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void k(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new g(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void l(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new n(this, it.next(), aVar));
        }
    }

    @Override // lkxssdk.y.b
    public void m(lkxssdk.z.a aVar) {
        Iterator<lkxssdk.y.b> it = this.a.iterator();
        while (it.hasNext()) {
            this.b.post(new m(this, it.next(), aVar));
        }
    }
}
