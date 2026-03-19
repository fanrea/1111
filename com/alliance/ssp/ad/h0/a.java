package com.alliance.ssp.ad.h0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alliance.ssp.ad.k0.c;
import com.alliance.ssp.ad.oaidgithub.ykrank.androidlifecycle.event.InitSate;

/* compiled from: AndroidLifeCycle.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static volatile a b;
    public b a = new b();

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public static com.alliance.ssp.ad.k0.a a(Context context) {
        com.alliance.ssp.ad.l0.a.a();
        if (context != null) {
            if (context instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                b bVar = a().a;
                int i = com.alliance.ssp.ad.j0.a.a;
                InitSate initSate = InitSate.NONE;
                bVar.getClass();
                try {
                    if (a((Activity) fragmentActivity)) {
                        return null;
                    }
                    com.alliance.ssp.ad.l0.a.a();
                    b.a(fragmentActivity);
                    FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                    c cVar = (c) supportFragmentManager.findFragmentByTag("me.ykrank.androidlifecycle.manager");
                    if (cVar == null) {
                        cVar = new c();
                        supportFragmentManager.beginTransaction().add(cVar, "me.ykrank.androidlifecycle.manager").commitNowAllowingStateLoss();
                    }
                    if (cVar.a == null) {
                        cVar.c = initSate;
                        com.alliance.ssp.ad.k0.a aVar = new com.alliance.ssp.ad.k0.a();
                        cVar.a = aVar;
                        cVar.b = aVar.a;
                    }
                    com.alliance.ssp.ad.k0.a aVar2 = cVar.a;
                    if (aVar2 != null) {
                        return aVar2;
                    }
                    throw new NullPointerException("Argument must not be null");
                } catch (Exception unused) {
                    return null;
                }
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                b bVar2 = a().a;
                int i2 = com.alliance.ssp.ad.j0.a.a;
                InitSate initSate2 = InitSate.NONE;
                bVar2.getClass();
                try {
                    if (a(activity)) {
                        return null;
                    }
                    com.alliance.ssp.ad.l0.a.a();
                    b.a(activity);
                    com.alliance.ssp.ad.k0.b bVarA = bVar2.a(activity.getFragmentManager(), null);
                    if (bVarA.a == null) {
                        bVarA.c = initSate2;
                        com.alliance.ssp.ad.k0.a aVar3 = new com.alliance.ssp.ad.k0.a();
                        bVarA.a = aVar3;
                        bVarA.b = aVar3.a;
                    }
                    com.alliance.ssp.ad.k0.a aVar4 = bVarA.a;
                    if (aVar4 != null) {
                        return aVar4;
                    }
                    throw new NullPointerException("Argument must not be null");
                } catch (Exception unused2) {
                    return null;
                }
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
            throw new IllegalArgumentException(com.alliance.ssp.ad.a.b.a("Illegal type of context:").append(context.toString()).toString());
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public static boolean a(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 17 && activity.isDestroyed();
    }
}
