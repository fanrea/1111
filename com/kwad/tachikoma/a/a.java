package com.kwad.tachikoma.a;

import android.app.Activity;
import android.os.Bundle;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILifeCycleListener;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private int Bs;
    private AtomicInteger Bt;
    private Map<Integer, g> Bu;
    private List<ILifeCycleListener> Bv;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Bt = new AtomicInteger(0);
        this.Bu = new HashMap();
        this.Bv = new ArrayList();
        this.Bs = OfflineHostProvider.getApi().lifeCycle().registerLifeCycleListener(new ILifeCycleListener() { // from class: com.kwad.tachikoma.a.a.1
            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                Iterator it = a.this.Bv.iterator();
                while (it.hasNext()) {
                    ((ILifeCycleListener) it.next()).onActivityCreated(activity, bundle);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityResumed(Activity activity) {
                Iterator it = a.this.Bv.iterator();
                while (it.hasNext()) {
                    ((ILifeCycleListener) it.next()).onActivityResumed(activity);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityPaused(Activity activity) {
                Iterator it = a.this.Bv.iterator();
                while (it.hasNext()) {
                    ((ILifeCycleListener) it.next()).onActivityPaused(activity);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityDestroyed(Activity activity) {
                Iterator it = a.this.Bv.iterator();
                while (it.hasNext()) {
                    ((ILifeCycleListener) it.next()).onActivityDestroyed(activity);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onBackToForeground() {
                Iterator it = a.this.Bu.entrySet().iterator();
                while (it.hasNext()) {
                    ((g) ((Map.Entry) it.next()).getValue()).call(null, 1);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onBackToBackground() {
                Iterator it = a.this.Bu.entrySet().iterator();
                while (it.hasNext()) {
                    ((g) ((Map.Entry) it.next()).getValue()).call(null, 2);
                }
            }
        });
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        OfflineHostProvider.getApi().lifeCycle().unregisterLifeCycleListener(this.Bs);
    }

    public final void a(ILifeCycleListener iLifeCycleListener) {
        this.Bv.add(iLifeCycleListener);
    }

    public final int e(V8Function v8Function) {
        g gVar = new g(v8Function, pO());
        int iIncrementAndGet = this.Bt.incrementAndGet();
        this.Bu.put(Integer.valueOf(iIncrementAndGet), gVar);
        return iIncrementAndGet;
    }

    public final void bP(int i) {
        this.Bu.remove(Integer.valueOf(i));
    }

    public final Object hY() {
        com.tk.core.bridge.b bVarPO;
        Activity currentActivity = OfflineHostProvider.getApi().lifeCycle().getCurrentActivity();
        if (currentActivity == null || (bVarPO = pO()) == null) {
            return null;
        }
        return e.a(currentActivity, bVarPO);
    }

    public static int hZ() {
        return OfflineHostProvider.getApi().lifeCycle().isAppOnForeground() ? 1 : 2;
    }
}
