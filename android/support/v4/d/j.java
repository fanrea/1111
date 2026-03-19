package android.support.v4.d;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class j {

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public interface a<T> {
        T G();

        boolean j(T t);
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class b<T> implements a<T> {
        private final Object[] bW;
        private int bX;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.bW = new Object[i];
        }

        @Override // android.support.v4.d.j.a
        public final T G() {
            int i = this.bX;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.bW;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.bX = i - 1;
            return t;
        }

        @Override // android.support.v4.d.j.a
        public final boolean j(T t) {
            if (k(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.bX;
            Object[] objArr = this.bW;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.bX = i + 1;
            return true;
        }

        private boolean k(T t) {
            for (int i = 0; i < this.bX; i++) {
                if (this.bW[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static int l(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }
}
