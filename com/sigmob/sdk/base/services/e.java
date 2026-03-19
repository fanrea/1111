package com.sigmob.sdk.base.services;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.services.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e implements f.a {
    private static volatile LocationManager b;
    private g d = g.STOP;
    private static final LocationListener a = new LocationListener() { // from class: com.sigmob.sdk.base.services.e.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (ClientMetadata.getInstance() == null) {
                return;
            }
            ClientMetadata.getInstance().setLocation(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String s) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String s) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }
    };
    private static String c = PointCategory.NETWORK;

    e() {
        LocationManager locationManagerA;
        if (ClientMetadata.getInstance() == null || (locationManagerA = a()) == null) {
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        c = locationManagerA.getBestProvider(criteria, false);
    }

    static LocationManager a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = ClientMetadata.getInstance().getLocationManager();
                }
            }
        }
        return b;
    }

    private void b() {
        try {
            if (b != null) {
                b.removeUpdates(a);
            }
            b = null;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private void c() {
        String str;
        try {
            LocationManager locationManagerA = a();
            if (locationManagerA == null || (str = c) == null || !locationManagerA.isProviderEnabled(str)) {
                return;
            }
            SigmobLog.d("private :use_location ");
            locationManagerA.requestLocationUpdates(c, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 10.0f, a);
            this.d = g.RUNNING;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public boolean e() {
        if (this.d == g.RUNNING) {
            return false;
        }
        c();
        return true;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public g f() {
        return this.d;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public void g() {
        if (this.d == g.RUNNING) {
            b();
            this.d = g.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public Error h() {
        return null;
    }
}
