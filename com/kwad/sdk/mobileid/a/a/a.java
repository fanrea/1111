package com.kwad.sdk.mobileid.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private ConnectivityManager.NetworkCallback cge;
    private volatile boolean cgf = false;
    private ConnectivityManager mConnectivityManager;

    /* renamed from: com.kwad.sdk.mobileid.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0627a {
        void alQ();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.cgf = true;
        return true;
    }

    public final void a(Context context, final InterfaceC0627a interfaceC0627a) {
        synchronized (this) {
            this.mConnectivityManager = cI(context);
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                    if (this.cge == null) {
                        this.cge = new ConnectivityManager.NetworkCallback() { // from class: com.kwad.sdk.mobileid.a.a.a.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onAvailable(Network network) {
                                a.this.mConnectivityManager.bindProcessToNetwork(network);
                                if (interfaceC0627a != null && !a.this.cgf) {
                                    interfaceC0627a.alQ();
                                }
                                a.a(a.this, true);
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onUnavailable() {
                                a.this.mConnectivityManager.bindProcessToNetwork(null);
                                c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onUnavailable unbindNetwork");
                                a.this.alL();
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onLost(Network network) {
                                a.this.mConnectivityManager.bindProcessToNetwork(null);
                                c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onLost unbindNetwork");
                                a.this.alL();
                            }
                        };
                    }
                    if (!this.cgf) {
                        this.mConnectivityManager.requestNetwork(networkRequestBuild, this.cge);
                    } else {
                        c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "isRequestUaidToken is true unbindNetwork");
                        alL();
                    }
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    public final void alL() {
        ConnectivityManager connectivityManager;
        synchronized (this) {
            if (this.cge == null) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21 && (connectivityManager = this.mConnectivityManager) != null) {
                    connectivityManager.unregisterNetworkCallback(this.cge);
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                this.mConnectivityManager.bindProcessToNetwork(null);
            }
            this.cge = null;
        }
    }

    private static ConnectivityManager cI(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }
}
