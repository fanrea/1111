package com.alliance.ssp.ad.h0;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AndroidLifeCycleImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements Handler.Callback {
    public final Map<FragmentManager, com.alliance.ssp.ad.k0.b> a = new HashMap();
    public final Handler b = new Handler(Looper.getMainLooper(), this);

    public com.alliance.ssp.ad.k0.b a(FragmentManager fragmentManager, Fragment fragment) {
        com.alliance.ssp.ad.k0.b bVar = (com.alliance.ssp.ad.k0.b) fragmentManager.findFragmentByTag("me.ykrank.androidlifecycle.manager");
        if (bVar != null) {
            return bVar;
        }
        com.alliance.ssp.ad.k0.b bVar2 = this.a.get(fragmentManager);
        if (bVar2 != null) {
            return bVar2;
        }
        com.alliance.ssp.ad.k0.b bVar3 = new com.alliance.ssp.ad.k0.b();
        this.a.put(fragmentManager, bVar3);
        fragmentManager.beginTransaction().add(bVar3, "me.ykrank.androidlifecycle.manager").commitAllowingStateLoss();
        this.b.obtainMessage(1, fragmentManager).sendToTarget();
        return bVar3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        FragmentManager fragmentManager;
        com.alliance.ssp.ad.k0.b bVarRemove = null;
        boolean z = true;
        if (message.what != 1) {
            z = false;
            fragmentManager = null;
        } else {
            FragmentManager fragmentManager2 = (FragmentManager) message.obj;
            bVarRemove = this.a.remove(fragmentManager2);
            fragmentManager = fragmentManager2;
        }
        if (z && bVarRemove == null && Log.isLoggable("AndroidLifeCycle", 5)) {
            Log.w("AndroidLifeCycle", "Failed to remove expected request manager fragment, manager: " + fragmentManager);
        }
        return z;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }
}
