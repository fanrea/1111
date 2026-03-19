package android.support.v4.e;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class r {
    private WeakReference<View> cI;

    public final void cancel() {
        View view = this.cI.get();
        if (view != null) {
            view.animate().cancel();
        }
    }
}
