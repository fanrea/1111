package com.tencent.turingfd.sdk.ams.au;

import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Norma implements LocationListener {
    public static final Coconut<Norma> c = new Cdo();
    public final Cif[] a = new Cif[3];
    public volatile int b = 0;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Norma$do, reason: invalid class name */
    public class Cdo extends Coconut<Norma> {
        @Override // com.tencent.turingfd.sdk.ams.au.Coconut
        public Norma a() {
            return new Norma();
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Norma$if, reason: invalid class name */
    public static class Cif {
        public long a;
        public String b;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.a) {
            int length = this.b;
            do {
                Cif cif = this.a[this.b];
                if (cif == null) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(cif.a);
                sb.append(":");
                sb.append(cif.b);
                length = (length + 1) % this.a.length;
            } while (length != this.b);
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (Build.VERSION.SDK_INT >= 18 && location != null && location.isFromMockProvider()) {
            synchronized (this.a) {
                Cif cif = this.a[this.b];
                if (cif == null) {
                    cif = new Cif();
                    this.a[this.b] = cif;
                }
                this.b = (this.b + 1) % this.a.length;
                cif.a = System.currentTimeMillis();
                cif.b = location.getProvider();
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
