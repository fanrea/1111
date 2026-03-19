package com.kwad.tachikoma.network;

import android.content.Context;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends TKBaseNativeModule {
    private AtomicInteger Bt;
    private Map<Integer, g> Ek;
    private INetworkChangeListener El;

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Ek = new HashMap();
        this.Bt = new AtomicInteger(0);
    }

    public final int iM() {
        return OfflineHostProvider.getApi().networkManager().getNetworkType(iN());
    }

    public final int u(V8Function v8Function) {
        if (v8Function == null) {
            return 0;
        }
        int iIncrementAndGet = this.Bt.incrementAndGet();
        this.Ek.put(Integer.valueOf(iIncrementAndGet), new g(v8Function, pO()));
        if (this.El == null) {
            this.El = new INetworkChangeListener() { // from class: com.kwad.tachikoma.network.e.1
                @Override // com.kwad.components.offline.api.core.network.INetworkChangeListener
                public final void networkChange(int i) {
                    Iterator it = e.this.Ek.entrySet().iterator();
                    while (it.hasNext()) {
                        ((g) ((Map.Entry) it.next()).getValue()).call(null, Integer.valueOf(i));
                    }
                }
            };
            OfflineHostProvider.getApi().networkManager().addNetworkChangeListener(iN(), this.El);
        }
        return iIncrementAndGet;
    }

    public final void cf(int i) {
        this.Ek.remove(Integer.valueOf(i));
    }

    private Context iN() {
        return com.kwad.tachikoma.e.hP().hQ().wrapper().unwrapContextIfNeed(getContext());
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        OfflineHostProvider.getApi().networkManager().removeNetworkChangeListener(iN(), this.El);
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        Iterator<Map.Entry<Integer, g>> it = this.Ek.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().destroy();
        }
        this.Ek.clear();
    }
}
