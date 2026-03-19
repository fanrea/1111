package com.kwad.sdk.glide.load.c;

import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m<A, B> {
    private final com.kwad.sdk.glide.e.g<a<A>, B> bWy;

    public m() {
        this(250L);
    }

    public m(long j) {
        this.bWy = new com.kwad.sdk.glide.e.g<a<A>, B>(j) { // from class: com.kwad.sdk.glide.load.c.m.1
            @Override // com.kwad.sdk.glide.e.g
            public final /* synthetic */ void b(Object obj, Object obj2) {
                a((a) obj);
            }

            private static void a(a<A> aVar) {
                aVar.release();
            }
        };
    }

    public final B a(A a2, int i, int i2) {
        a<A> aVarB = a.b(a2, 0, 0);
        B b = this.bWy.get(aVarB);
        aVarB.release();
        return b;
    }

    public final void a(A a2, int i, int i2, B b) {
        this.bWy.put(a.b(a2, 0, 0), b);
    }

    static final class a<A> {
        private static final Queue<a<?>> bWA = com.kwad.sdk.glide.e.j.gt(0);
        private A bQj;
        private int height;
        private int width;

        static <A> a<A> b(A a, int i, int i2) {
            a<A> aVar;
            Queue<a<?>> queue = bWA;
            synchronized (queue) {
                aVar = (a) queue.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.c(a, i, i2);
            return aVar;
        }

        private a() {
        }

        private void c(A a, int i, int i2) {
            this.bQj = a;
            this.width = i;
            this.height = i2;
        }

        public final void release() {
            Queue<a<?>> queue = bWA;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.width == aVar.width && this.height == aVar.height && this.bQj.equals(aVar.bQj)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.bQj.hashCode();
        }
    }
}
