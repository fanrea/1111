package com.kwai.kanas.vader.e;

import com.alipay.sdk.m.u.i;
import com.kwai.kanas.vader.e.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class a {
    private a() {
    }

    static <V> h<V> a(V v) {
        v.getClass();
        return new b(v);
    }

    static <V> h<V> a(Exception exc) {
        exc.getClass();
        return new C0654a(exc);
    }

    static abstract class c<V> extends h<V> {
        private c() {
        }

        @Override // com.kwai.kanas.vader.e.h
        public V c() {
            throw new UnsupportedOperationException(a().toString());
        }

        @Override // com.kwai.kanas.vader.e.h
        public Exception b() {
            throw new UnsupportedOperationException(a().toString());
        }
    }

    static final class b<V> extends c<V> {
        private final V a;

        b(V v) {
            super();
            this.a = v;
        }

        @Override // com.kwai.kanas.vader.e.h
        public final h.a a() {
            return h.a.VALUE;
        }

        @Override // com.kwai.kanas.vader.e.a.c, com.kwai.kanas.vader.e.h
        public final V c() {
            return this.a;
        }

        public final String toString() {
            return "ValueOrException{value=" + this.a + i.d;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                if (a() == hVar.a() && this.a.equals(hVar.c())) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }

    /* renamed from: com.kwai.kanas.vader.e.a$a, reason: collision with other inner class name */
    static final class C0654a<V> extends c<V> {
        private final Exception a;

        C0654a(Exception exc) {
            super();
            this.a = exc;
        }

        @Override // com.kwai.kanas.vader.e.h
        public final h.a a() {
            return h.a.EXCEPTION;
        }

        @Override // com.kwai.kanas.vader.e.a.c, com.kwai.kanas.vader.e.h
        public final Exception b() {
            return this.a;
        }

        public final String toString() {
            return "ValueOrException{exception=" + this.a + i.d;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                if (a() == hVar.a() && this.a.equals(hVar.b())) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }
}
