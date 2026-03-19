package com.bytedance.sdk.component.widget.recycler.d.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {

    public interface d<T> {
        T d();

        boolean d(T t);
    }

    public static class hc<T> implements d<T> {
        private final Object[] d;
        private int hc;

        public hc(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.d = new Object[i];
        }

        @Override // com.bytedance.sdk.component.widget.recycler.d.hc.c.d
        public T d() {
            int i = this.hc;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.d;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.hc = i - 1;
            return t;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.d.hc.c.d
        public boolean d(T t) {
            if (hc(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.hc;
            Object[] objArr = this.d;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.hc = i + 1;
            return true;
        }

        private boolean hc(T t) {
            for (int i = 0; i < this.hc; i++) {
                if (this.d[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
