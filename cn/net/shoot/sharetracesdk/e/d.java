package cn.net.shoot.sharetracesdk.e;

import aegon.chrome.net.NetError;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ String a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ ConnectivityManager e;
    public final /* synthetic */ f f;
    public final /* synthetic */ boolean g;

    public d(String str, AtomicBoolean atomicBoolean, String str2, Map map, ConnectivityManager connectivityManager, f fVar, boolean z) {
        this.a = str;
        this.b = atomicBoolean;
        this.c = str2;
        this.d = map;
        this.e = connectivityManager;
        this.f = fVar;
        this.g = z;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        try {
            String str = "request network success : " + this.a;
            this.b.set(true);
            URL url = new URL(this.c);
            HashMap map = new HashMap(this.d);
            map.remove("lis");
            cn.net.shoot.sharetracesdk.c.c cVarA = cn.net.shoot.sharetracesdk.a.a.a(map, (HttpURLConnection) network.openConnection(url), this.a);
            String str2 = this.a + " http post result = " + cVarA.toString();
            this.e.unregisterNetworkCallback(this);
            this.f.a(cVarA);
        } catch (Exception e) {
            e.printStackTrace();
            cn.net.shoot.sharetracesdk.a.a.a(this.f, this.g ? NetError.ERR_CONNECTION_REFUSED : -103, e.getMessage());
            Log.e("ShareTrace", this.a + " http post error. error msg=" + e.getMessage());
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        this.e.unregisterNetworkCallback(this);
        cn.net.shoot.sharetracesdk.a.a.a(this.f, this.g ? -108 : -107, "request error.");
        Log.e("ShareTrace", this.a + " network unavailable.");
    }
}
