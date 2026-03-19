package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class o {
    public static MenuItem a(Context context, android.support.v4.a.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new j(context, bVar);
        }
        return new i(context, bVar);
    }

    public static SubMenu a(Context context, android.support.v4.a.a.c cVar) {
        return new t(context, cVar);
    }
}
