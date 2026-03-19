package com.kwad.components.core.p.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i implements INetworkManager {
    private List<INetworkChangeListener> TB = new CopyOnWriteArrayList();
    private NetworkMonitor.a TC;

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return ao.dX(context);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            ay(context);
            this.TB.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.TB.remove(iNetworkChangeListener);
    }

    private void ay(final Context context) {
        if (this.TC != null) {
            return;
        }
        this.TC = new NetworkMonitor.a() { // from class: com.kwad.components.core.p.b.a.i.1
            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.p.b.a.i.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int networkType = i.this.getNetworkType(context);
                        Iterator it = i.this.TB.iterator();
                        while (it.hasNext()) {
                            ((INetworkChangeListener) it.next()).networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().a(context, this.TC);
    }
}
