package cn.net.shoot.sharetracesdk.e;

import android.net.ConnectivityManager;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements Runnable {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ ConnectivityManager b;
    public final /* synthetic */ ConnectivityManager.NetworkCallback c;
    public final /* synthetic */ f d;
    public final /* synthetic */ boolean e;

    public e(AtomicBoolean atomicBoolean, ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback, f fVar, boolean z) {
        this.a = atomicBoolean;
        this.b = connectivityManager;
        this.c = networkCallback;
        this.d = fVar;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.get()) {
            return;
        }
        this.b.unregisterNetworkCallback(this.c);
        cn.net.shoot.sharetracesdk.a.a.a(this.d, this.e ? -108 : -107, "request error.");
        Log.e("ShareTrace", "request network timeout, cellular network unavailable.");
    }
}
