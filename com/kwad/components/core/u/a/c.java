package com.kwad.components.core.u.a;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    static final Object abf = new Object();
    d abg;

    public c(Activity activity) {
        this.abg = g(activity);
    }

    private d g(Activity activity) {
        d dVarH = h(activity);
        if (!(dVarH == null)) {
            return dVarH;
        }
        d dVar = new d();
        FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction().add(dVar, "RxPermissions").commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return dVar;
    }

    private static d h(Activity activity) {
        return (d) activity.getFragmentManager().findFragmentByTag("RxPermissions");
    }

    public final void a(String str, b bVar) {
        if (aQ(str)) {
            bVar.a(new a(str, true));
            return;
        }
        if (aR(str)) {
            bVar.a(new a(str, false));
            com.kwad.sdk.core.d.c.d("RxPermissions", "requestSinglePermission permission is isRevoked ");
        } else {
            this.abg.b(str, bVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            b((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
    }

    private void b(String[] strArr) {
        com.kwad.sdk.core.d.c.d("RxPermissions", "requestPermissionsFromFragment permission is  " + strArr.toString());
        this.abg.aS("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.abg.c(strArr);
    }

    private boolean aQ(String str) {
        return !tJ() || this.abg.aQ(str);
    }

    private boolean aR(String str) {
        return tJ() && this.abg.aR(str);
    }

    private static boolean tJ() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
