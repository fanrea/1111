package android.support.v4.d;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class i {

    public interface a<T> {
        T V();

        boolean release(T t);
    }

    public static class b<T> implements a<T> {

        /* renamed from: ca, reason: collision with root package name */
        private final Object[] f706ca;
        private int cb;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f706ca = new Object[i];
        }

        @Override // android.support.v4.d.i.a
        public final T V() {
            int i = this.cb;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.f706ca;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.cb = i - 1;
            return t;
        }

        @Override // android.support.v4.d.i.a
        public final boolean release(T t) {
            if (k(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.cb;
            Object[] objArr = this.f706ca;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.cb = i + 1;
            return true;
        }

        private boolean k(T t) {
            for (int i = 0; i < this.cb; i++) {
                if (this.f706ca[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
