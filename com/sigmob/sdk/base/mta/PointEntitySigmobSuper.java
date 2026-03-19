package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PointEntitySigmobSuper extends PointEntitySuper {
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public DeviceContext getDeviceContext() {
        return b.b();
    }

    public String getSdkversion() {
        return n.k;
    }

    public boolean isAcTypeBlock() {
        if (!i.a().i()) {
            return true;
        }
        Iterator<Integer> it = o.a().O().iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }
}
