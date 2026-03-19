package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ce {
    private static boolean coo = false;
    private static final List<a> cop = new CopyOnWriteArrayList();

    public static List<a> r(Context context, int i) {
        WifiManager wifiManager;
        if (bd.useNetworkStateDisable()) {
            return new ArrayList();
        }
        if (!coo && ServiceProvider.getSDKConfig().canReadNearbyWifiList()) {
            List<a> list = cop;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(32L)) {
                    return list;
                }
                try {
                } catch (Exception e) {
                    coo = true;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
                if (eX(context) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(com.baidu.mobads.container.util.e.a.a)) == null) {
                    return list;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        a aVar = new a();
                        aVar.coq = scanResult.SSID;
                        aVar.cor = scanResult.BSSID;
                        aVar.level = scanResult.level;
                        if (connectionInfo.getBSSID() != null && scanResult.BSSID != null && TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) && connectionInfo.getSSID() != null && scanResult.SSID != null && TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            cop.add(0, aVar);
                        } else {
                            cop.add(aVar);
                        }
                        List<a> list2 = cop;
                        if (list2.size() >= i) {
                            return list2;
                        }
                    }
                }
                return cop;
            }
        }
        return cop;
    }

    public static boolean eX(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == -1 : ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1;
    }

    public static class a implements com.kwad.sdk.core.b {
        public String coq;
        public String cor;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "level", this.level);
            aa.putValue(jSONObject, "ssid", this.coq);
            aa.putValue(jSONObject, "bssid", this.cor);
            return jSONObject;
        }
    }
}
