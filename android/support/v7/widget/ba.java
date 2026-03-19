package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ba extends Resources {
    private static boolean wE = false;
    private final WeakReference<Context> vm;

    public static boolean fD() {
        return fE() && Build.VERSION.SDK_INT <= 20;
    }

    public ba(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.vm = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i) {
        Context context = this.vm.get();
        if (context != null) {
            return h.cH().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable bm(int i) {
        return super.getDrawable(i);
    }

    private static boolean fE() {
        return wE;
    }
}
