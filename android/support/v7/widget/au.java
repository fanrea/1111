package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class au extends al {
    private final WeakReference<Context> vm;

    public au(Context context, Resources resources) {
        super(resources);
        this.vm = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.al, android.content.res.Resources
    public final Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.vm.get();
        if (drawable != null && context != null) {
            h.cH();
            h.a(context, i, drawable);
        }
        return drawable;
    }
}
