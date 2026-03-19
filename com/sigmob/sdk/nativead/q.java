package com.sigmob.sdk.nativead;

import android.content.Context;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.natives.WindNativeAdData;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class q extends k {
    aa g;

    public q(Context context) {
        super(context);
    }

    public void a(aa listener) {
        this.g = listener;
    }

    @Override // com.sigmob.sdk.nativead.k
    public void c() {
        super.c();
        this.g = null;
    }

    public void e() {
    }

    public d getAdConfig() {
        aa aaVar = this.g;
        if (aaVar == null) {
            return null;
        }
        return aaVar.x();
    }

    public BaseAdUnit getAdUnit() {
        aa aaVar = this.g;
        if (aaVar == null) {
            return null;
        }
        return aaVar.k();
    }

    public l getAppInfoView() {
        aa aaVar = this.g;
        if (aaVar == null) {
            return null;
        }
        return aaVar.m();
    }

    public WindNativeAdData getNativeAdUnit() {
        aa aaVar = this.g;
        if (aaVar == null) {
            return null;
        }
        return aaVar.l();
    }

    public double getVideoDuration() {
        return 0.0d;
    }

    public double getVideoProgress() {
        return 0.0d;
    }

    public void i() {
    }

    public void j() {
    }

    public void setUIStyle(h style) {
        this.d = style;
    }
}
