package com.bytedance.msdk.gb;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static long d = 1800000;
    private static Handler hc = new Handler(Looper.getMainLooper());

    public static u d(Context context) {
        if (!com.bytedance.msdk.core.d.mk().j().d()) {
            return null;
        }
        Context context2 = context == null ? com.bytedance.msdk.core.hc.getContext() : context.getApplicationContext();
        if (context2 == null) {
            return null;
        }
        u uVarB = b(context2);
        if (!hc(context2)) {
            return uVarB;
        }
        int iD = com.bytedance.msdk.core.mq.b.d(context2, "android.permission.ACCESS_FINE_LOCATION");
        int iD2 = com.bytedance.msdk.core.mq.b.d(context2, g.h);
        if (iD == 0 || iD2 == 0) {
            return c(context2);
        }
        return null;
    }

    private static boolean hc(Context context) {
        long jHc = zw.d((String) null, context).hc("lbstime", -1L);
        return jHc == -1 || System.currentTimeMillis() - jHc > d;
    }

    private static u b(Context context) {
        zw zwVarD = zw.d((String) null, context);
        float fHc = zwVarD.hc("latitude", -1.0f);
        float fHc2 = zwVarD.hc("longitude", -1.0f);
        if (fHc == -1.0f || fHc2 == -1.0f) {
            return null;
        }
        return new u(fHc, fHc2);
    }

    private static u c(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        u uVar = null;
        if (locationManager != null) {
            try {
                Location locationD = d(locationManager);
                if (locationD != null && hc(locationD)) {
                    hc(context, locationD);
                    uVar = new u((float) locationD.getLatitude(), (float) locationD.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.msdk.gb.an.1
                        @Override // java.lang.Runnable
                        public void run() {
                            an.hc(context, locationManager);
                        }
                    });
                } else {
                    hc(context, locationManager);
                }
            } catch (Throwable th) {
                if (com.bytedance.msdk.d.u.b.hc()) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            }
        }
        return uVar;
    }

    private static Location d(LocationManager locationManager) {
        Location locationD = d(locationManager, "gps");
        if (locationD == null) {
            locationD = d(locationManager, PointCategory.NETWORK);
        }
        return locationD == null ? d(locationManager, "passive") : locationD;
    }

    private static Location d(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new d(locationManager, str));
            com.bytedance.msdk.d.u.an.c(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            com.bytedance.msdk.d.u.b.d("AdLocationUtils", "location:".concat(String.valueOf(location)));
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class d implements Callable<Location> {
        private LocationManager d;
        private String hc;

        public d(LocationManager locationManager, String str) {
            this.d = locationManager;
            this.hc = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.d.getLastKnownLocation(this.hc);
            com.bytedance.msdk.d.u.b.d("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return lastKnownLocation;
        }
    }

    private static String hc(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled(PointCategory.NETWORK)) {
            return PointCategory.NETWORK;
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(final Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.msdk.gb.an.2
            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null && an.hc(location)) {
                    an.hc(context, location);
                }
                an.hc(locationManager, this);
            }
        };
        try {
            String strHc = hc(locationManager);
            if (TextUtils.isEmpty(strHc)) {
                return;
            }
            locationManager.requestSingleUpdate(strHc, locationListener, Looper.getMainLooper());
            hc.postDelayed(new Runnable() { // from class: com.bytedance.msdk.gb.an.3
                @Override // java.lang.Runnable
                public void run() {
                    an.hc(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable th) {
            if (com.bytedance.msdk.d.u.b.hc()) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
            hc(locationManager, locationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.msdk.d.u.b.hc()) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(Context context, Location location) {
        if (hc(location)) {
            zw zwVarD = zw.d((String) null, context);
            zwVarD.d("latitude", (float) location.getLatitude());
            zwVarD.d("longitude", (float) location.getLongitude());
            zwVarD.d("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hc(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
