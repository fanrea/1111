package com.kwad.sdk.glide.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.utils.ax;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k implements Handler.Callback {
    private static final a bYP = new a() { // from class: com.kwad.sdk.glide.a.k.1
        @Override // com.kwad.sdk.glide.a.k.a
        public final com.kwad.sdk.glide.g a(com.kwad.sdk.glide.c cVar, h hVar, l lVar, Context context) {
            return new com.kwad.sdk.glide.g(cVar, hVar, lVar, context);
        }
    };
    private volatile com.kwad.sdk.glide.g bYI;
    private final a bYL;
    private final Handler handler;
    final Map<FragmentManager, Object> bYJ = new HashMap();
    final Map<KsFragmentManager, n> bYK = new HashMap();
    private final ArrayMap<View, KsFragment> bYM = new ArrayMap<>();
    private final ArrayMap<View, Fragment> bYN = new ArrayMap<>();
    private final Bundle bYO = new Bundle();

    public interface a {
        com.kwad.sdk.glide.g a(com.kwad.sdk.glide.c cVar, h hVar, l lVar, Context context);
    }

    public k(a aVar) {
        this.bYL = aVar == null ? bYP : aVar;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    private com.kwad.sdk.glide.g cB(Context context) {
        if (this.bYI == null) {
            synchronized (this) {
                if (this.bYI == null) {
                    this.bYI = this.bYL.a(com.kwad.sdk.glide.c.cv(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.bYI;
    }

    public final com.kwad.sdk.glide.g cC(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        return cB(context);
    }

    public final com.kwad.sdk.glide.g i(KsFragment ksFragment) {
        ax.f(ksFragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.kwad.sdk.glide.e.j.ajE()) {
            return cB(ksFragment.getActivity().getApplicationContext());
        }
        return a(ksFragment.getActivity(), ksFragment.getChildFragmentManager(), ksFragment, ksFragment.isVisible());
    }

    final n a(KsFragmentManager ksFragmentManager, Activity activity) {
        return a(ksFragmentManager, null, w(activity));
    }

    private static boolean w(Activity activity) {
        return !activity.isFinishing();
    }

    private n a(KsFragmentManager ksFragmentManager, KsFragment ksFragment, boolean z) {
        n nVar = (n) ksFragmentManager.findFragmentByTag("com.kwad.sdk.glide.manager");
        if (nVar == null && (nVar = this.bYK.get(ksFragmentManager)) == null) {
            nVar = new n();
            nVar.j(ksFragment);
            if (z) {
                nVar.air().onStart();
            }
            this.bYK.put(ksFragmentManager, nVar);
            ksFragmentManager.beginTransaction().add(nVar, "com.kwad.sdk.glide.manager").commitAllowingStateLoss();
            this.handler.obtainMessage(2, ksFragmentManager).sendToTarget();
        }
        return nVar;
    }

    private com.kwad.sdk.glide.g a(Context context, KsFragmentManager ksFragmentManager, KsFragment ksFragment, boolean z) {
        n nVarA = a(ksFragmentManager, ksFragment, z);
        com.kwad.sdk.glide.g gVarAis = nVarA.ais();
        if (gVarAis != null) {
            return gVarAis;
        }
        com.kwad.sdk.glide.g gVarA = this.bYL.a(com.kwad.sdk.glide.c.cv(context), nVarA.air(), nVarA.ait(), context);
        nVarA.c(gVarA);
        return gVarA;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        int i = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            objRemove = this.bYJ.remove(obj);
        } else if (i == 2) {
            obj = (KsFragmentManager) message.obj;
            objRemove = this.bYK.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = objRemove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }
}
