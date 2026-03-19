package android.support.v4.content;

import android.support.v4.d.d;
import com.alipay.sdk.m.u.i;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b<D> {

    /* renamed from: K, reason: collision with root package name */
    a<D> f705K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    int mId;
    boolean mStarted;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface a<D> {
    }

    public final void a(a<D> aVar) {
        a<D> aVar2 = this.f705K;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f705K = null;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.M = false;
        this.L = false;
    }

    public final void stopLoading() {
        this.mStarted = false;
    }

    public final void abandon() {
        this.L = true;
    }

    public final void reset() {
        this.M = true;
        this.mStarted = false;
        this.L = false;
        this.N = false;
        this.O = false;
    }

    public static String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        d.a(d, sb);
        sb.append(i.d);
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        d.a(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append(i.d);
        return sb.toString();
    }
}
