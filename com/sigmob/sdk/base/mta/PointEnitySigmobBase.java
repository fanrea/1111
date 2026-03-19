package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityBase;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.e;
import com.sigmob.windad.WindAds;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PointEnitySigmobBase extends PointEntityBase {
    private String a;
    private String b;
    private String c;

    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public DeviceContext getDeviceContext() {
        return b.b();
    }

    public String getIs_custom_android_id() {
        return this.b;
    }

    public String getIs_custom_imei() {
        return this.a;
    }

    public String getIs_custom_oaid() {
        return this.c;
    }

    public String getSdkversion() {
        return n.k;
    }

    public boolean isAcTypeBlock() {
        if (!i.a().i()) {
            return true;
        }
        List<Integer> listO = o.a().O();
        if (e.a(listO)) {
            return false;
        }
        Iterator<Integer> it = listO.iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }

    public void setIs_custom_android_id(String is_custom_android_id) {
        this.b = is_custom_android_id;
    }

    public void setIs_custom_imei(String is_custom_imei) {
        this.a = is_custom_imei;
    }

    public void setIs_custom_oaid(String is_custom_oaid) {
        this.c = is_custom_oaid;
    }
}
