package com.bytedance.adsdk.lottie.d.hc;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d<K, A> {
    protected com.bytedance.adsdk.lottie.an.b<A> b;
    private final b<K> u;
    final List<InterfaceC0167d> d = new ArrayList(1);
    private boolean c = false;
    protected float hc = 0.0f;
    private A an = null;
    private float h = -1.0f;
    private float gb = -1.0f;

    private interface b<T> {
        float b();

        float c();

        boolean d();

        boolean d(float f);

        com.bytedance.adsdk.lottie.an.d<T> hc();

        boolean hc(float f);
    }

    /* renamed from: com.bytedance.adsdk.lottie.d.hc.d$d, reason: collision with other inner class name */
    public interface InterfaceC0167d {
        void d();
    }

    abstract A d(com.bytedance.adsdk.lottie.an.d<K> dVar, float f);

    d(List<? extends com.bytedance.adsdk.lottie.an.d<K>> list) {
        this.u = d(list);
    }

    public void d() {
        this.c = true;
    }

    public void d(InterfaceC0167d interfaceC0167d) {
        this.d.add(interfaceC0167d);
    }

    public void d(float f) {
        if (this.u.d()) {
            return;
        }
        if (f < tt()) {
            f = tt();
        } else if (f > an()) {
            f = an();
        }
        if (f == this.hc) {
            return;
        }
        this.hc = f;
        if (this.u.d(f)) {
            hc();
        }
    }

    public void hc() {
        for (int i = 0; i < this.d.size(); i++) {
            this.d.get(i).d();
        }
    }

    protected com.bytedance.adsdk.lottie.an.d<K> b() {
        com.bytedance.adsdk.lottie.u.d("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.lottie.an.d<K> dVarHc = this.u.hc();
        com.bytedance.adsdk.lottie.u.hc("BaseKeyframeAnimation#getCurrentKeyframe");
        return dVarHc;
    }

    float c() {
        if (this.c) {
            return 0.0f;
        }
        com.bytedance.adsdk.lottie.an.d<K> dVarB = b();
        if (dVarB.u()) {
            return 0.0f;
        }
        return (this.hc - dVarB.b()) / (dVarB.c() - dVarB.b());
    }

    protected float u() {
        com.bytedance.adsdk.lottie.an.d<K> dVarB = b();
        if (dVarB == null || dVarB.u()) {
            return 0.0f;
        }
        return dVarB.b.getInterpolation(c());
    }

    private float tt() {
        if (this.h == -1.0f) {
            this.h = this.u.b();
        }
        return this.h;
    }

    float an() {
        if (this.gb == -1.0f) {
            this.gb = this.u.c();
        }
        return this.gb;
    }

    public A h() {
        A aD;
        float fC = c();
        if (this.b == null && this.u.hc(fC)) {
            return this.an;
        }
        com.bytedance.adsdk.lottie.an.d<K> dVarB = b();
        if (dVarB.c != null && dVarB.u != null) {
            aD = d(dVarB, fC, dVarB.c.getInterpolation(fC), dVarB.u.getInterpolation(fC));
        } else {
            aD = d(dVarB, u());
        }
        this.an = aD;
        return aD;
    }

    public float gb() {
        return this.hc;
    }

    protected A d(com.bytedance.adsdk.lottie.an.d<K> dVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> b<T> d(List<? extends com.bytedance.adsdk.lottie.an.d<T>> list) {
        if (list.isEmpty()) {
            return new hc();
        }
        if (list.size() == 1) {
            return new u(list);
        }
        return new c(list);
    }

    private static final class hc<T> implements b<T> {
        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public float b() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public float c() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean d() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean d(float f) {
            return false;
        }

        private hc() {
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public com.bytedance.adsdk.lottie.an.d<T> hc() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean hc(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    private static final class u<T> implements b<T> {
        private final com.bytedance.adsdk.lottie.an.d<T> d;
        private float hc = -1.0f;

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean d() {
            return false;
        }

        u(List<? extends com.bytedance.adsdk.lottie.an.d<T>> list) {
            this.d = list.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean d(float f) {
            return !this.d.u();
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public com.bytedance.adsdk.lottie.an.d<T> hc() {
            return this.d;
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public float b() {
            return this.d.b();
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public float c() {
            return this.d.c();
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean hc(float f) {
            if (this.hc == f) {
                return true;
            }
            this.hc = f;
            return false;
        }
    }

    private static final class c<T> implements b<T> {
        private final List<? extends com.bytedance.adsdk.lottie.an.d<T>> d;
        private com.bytedance.adsdk.lottie.an.d<T> b = null;
        private float c = -1.0f;
        private com.bytedance.adsdk.lottie.an.d<T> hc = b(0.0f);

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean d() {
            return false;
        }

        c(List<? extends com.bytedance.adsdk.lottie.an.d<T>> list) {
            this.d = list;
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean d(float f) {
            if (this.hc.d(f)) {
                return !this.hc.u();
            }
            this.hc = b(f);
            return true;
        }

        private com.bytedance.adsdk.lottie.an.d<T> b(float f) {
            com.bytedance.adsdk.lottie.an.d<T> dVar = this.d.get(r0.size() - 1);
            if (f >= dVar.b()) {
                return dVar;
            }
            for (int size = this.d.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.lottie.an.d<T> dVar2 = this.d.get(size);
                if (this.hc != dVar2 && dVar2.d(f)) {
                    return dVar2;
                }
            }
            return this.d.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public com.bytedance.adsdk.lottie.an.d<T> hc() {
            return this.hc;
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public float b() {
            return this.d.get(0).b();
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public float c() {
            return this.d.get(r0.size() - 1).c();
        }

        @Override // com.bytedance.adsdk.lottie.d.hc.d.b
        public boolean hc(float f) {
            com.bytedance.adsdk.lottie.an.d<T> dVar = this.b;
            com.bytedance.adsdk.lottie.an.d<T> dVar2 = this.hc;
            if (dVar == dVar2 && this.c == f) {
                return true;
            }
            this.b = dVar2;
            this.c = f;
            return false;
        }
    }
}
