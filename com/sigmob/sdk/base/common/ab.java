package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ab extends PointEntityCommon {
    private String a;
    private String b;
    private String c;

    public String a() {
        return this.a;
    }

    public void a(String is_custom_imei) {
        this.a = is_custom_imei;
    }

    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public String b() {
        return this.b;
    }

    public void b(String is_custom_android_id) {
        this.b = is_custom_android_id;
    }

    public String c() {
        return this.c;
    }

    public void c(String is_custom_oaid) {
        this.c = is_custom_oaid;
    }

    public DeviceContext getDeviceContext() {
        return com.sigmob.sdk.b.b();
    }

    public String getSdkversion() {
        return com.sigmob.sdk.base.n.k;
    }

    public boolean isAcTypeBlock() {
        if (!com.sigmob.sdk.base.i.a().i()) {
            return true;
        }
        Iterator<Integer> it = com.sigmob.sdk.base.o.a().O().iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }
}
