package com.component.lottie.a.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class a<K, A> {
    protected com.component.lottie.h.j<A> c;
    private final c<K> e;
    final List<InterfaceC0322a> a = new ArrayList(1);
    private boolean d = false;
    protected float b = 0.0f;
    private A f = null;
    private float g = -1.0f;
    private float h = -1.0f;

    /* renamed from: com.component.lottie.a.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0322a {
        void a();
    }

    private interface c<T> {
        boolean a();

        boolean a(float f);

        com.component.lottie.h.a<T> b();

        boolean b(float f);

        float c();

        float d();
    }

    abstract A a(com.component.lottie.h.a<K> aVar, float f);

    a(List<? extends com.component.lottie.h.a<K>> list) {
        this.e = a(list);
    }

    public void a() {
        this.d = true;
    }

    public void a(InterfaceC0322a interfaceC0322a) {
        this.a.add(interfaceC0322a);
    }

    public void a(float f) {
        if (this.e.a()) {
            return;
        }
        if (f < i()) {
            f = i();
        } else if (f > f()) {
            f = f();
        }
        if (f == this.b) {
            return;
        }
        this.b = f;
        if (this.e.a(f)) {
            b();
        }
    }

    public void b() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    protected com.component.lottie.h.a<K> c() {
        com.component.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.component.lottie.h.a<K> aVarB = this.e.b();
        com.component.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarB;
    }

    float d() {
        if (this.d) {
            return 0.0f;
        }
        com.component.lottie.h.a<K> aVarC = c();
        if (aVarC.e()) {
            return 0.0f;
        }
        return (this.b - aVarC.c()) / (aVarC.d() - aVarC.c());
    }

    protected float e() {
        com.component.lottie.h.a<K> aVarC = c();
        if (aVarC.e()) {
            return 0.0f;
        }
        return aVarC.c.getInterpolation(d());
    }

    private float i() {
        if (this.g == -1.0f) {
            this.g = this.e.c();
        }
        return this.g;
    }

    float f() {
        if (this.h == -1.0f) {
            this.h = this.e.d();
        }
        return this.h;
    }

    public A g() {
        A a;
        float fD = d();
        if (this.c == null && this.e.b(fD)) {
            return this.f;
        }
        com.component.lottie.h.a<K> aVarC = c();
        if (aVarC.d != null && aVarC.e != null) {
            a = a(aVarC, fD, aVarC.d.getInterpolation(fD), aVarC.e.getInterpolation(fD));
        } else {
            a = a(aVarC, e());
        }
        this.f = a;
        return a;
    }

    protected A a(com.component.lottie.h.a<K> aVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public float h() {
        return this.b;
    }

    public void a(com.component.lottie.h.j<A> jVar) {
        if (this.c != null) {
            this.c.a((a<?, ?>) null);
        }
        this.c = jVar;
        if (jVar != null) {
            jVar.a((a<?, ?>) this);
        }
    }

    private static <T> c<T> a(List<? extends com.component.lottie.h.a<T>> list) {
        if (list.isEmpty()) {
            return new b();
        }
        if (list.size() == 1) {
            return new e(list);
        }
        return new d(list);
    }

    private static final class b<T> implements c<T> {
        private b() {
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean a() {
            return true;
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean a(float f) {
            return false;
        }

        @Override // com.component.lottie.a.b.a.c
        public com.component.lottie.h.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.component.lottie.a.b.a.c
        public float c() {
            return 0.0f;
        }

        @Override // com.component.lottie.a.b.a.c
        public float d() {
            return 1.0f;
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean b(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    private static final class e<T> implements c<T> {
        private final com.component.lottie.h.a<T> a;
        private float b = -1.0f;

        e(List<? extends com.component.lottie.h.a<T>> list) {
            this.a = list.get(0);
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean a() {
            return false;
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean a(float f) {
            return !this.a.e();
        }

        @Override // com.component.lottie.a.b.a.c
        public com.component.lottie.h.a<T> b() {
            return this.a;
        }

        @Override // com.component.lottie.a.b.a.c
        public float c() {
            return this.a.c();
        }

        @Override // com.component.lottie.a.b.a.c
        public float d() {
            return this.a.d();
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean b(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }
    }

    private static final class d<T> implements c<T> {
        private final List<? extends com.component.lottie.h.a<T>> a;
        private com.component.lottie.h.a<T> c = null;
        private float d = -1.0f;
        private com.component.lottie.h.a<T> b = c(0.0f);

        d(List<? extends com.component.lottie.h.a<T>> list) {
            this.a = list;
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean a() {
            return false;
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean a(float f) {
            if (this.b.a(f)) {
                return !this.b.e();
            }
            this.b = c(f);
            return true;
        }

        private com.component.lottie.h.a<T> c(float f) {
            com.component.lottie.h.a<T> aVar = this.a.get(this.a.size() - 1);
            if (f >= aVar.c()) {
                return aVar;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                com.component.lottie.h.a<T> aVar2 = this.a.get(size);
                if (this.b != aVar2 && aVar2.a(f)) {
                    return aVar2;
                }
            }
            return this.a.get(0);
        }

        @Override // com.component.lottie.a.b.a.c
        public com.component.lottie.h.a<T> b() {
            return this.b;
        }

        @Override // com.component.lottie.a.b.a.c
        public float c() {
            return this.a.get(0).c();
        }

        @Override // com.component.lottie.a.b.a.c
        public float d() {
            return this.a.get(this.a.size() - 1).d();
        }

        @Override // com.component.lottie.a.b.a.c
        public boolean b(float f) {
            if (this.c == this.b && this.d == f) {
                return true;
            }
            this.c = this.b;
            this.d = f;
            return false;
        }
    }
}
