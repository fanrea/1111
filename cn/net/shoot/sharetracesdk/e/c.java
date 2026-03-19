package cn.net.shoot.sharetracesdk.e;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ f c;

    public c(String str, Map map, f fVar) {
        this.a = str;
        this.b = map;
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.a;
        Map map = this.b;
        f fVar = this.c;
        String str2 = "postByNetType:cl";
        ConnectivityManager connectivityManager = (ConnectivityManager) cn.net.shoot.sharetracesdk.f.a.c().a.getSystemService("connectivity");
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Handler handler = new Handler(Looper.getMainLooper());
        d dVar = new d("cl", atomicBoolean, str, map, connectivityManager, fVar, false);
        connectivityManager.requestNetwork(networkRequestBuild, dVar);
        handler.postDelayed(new e(atomicBoolean, connectivityManager, dVar, fVar, false), 1000L);
    }
}
