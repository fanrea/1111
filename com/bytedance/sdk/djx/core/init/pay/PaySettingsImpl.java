package com.bytedance.sdk.djx.core.init.pay;

import com.pangrowth.empay.IEMPaySetting;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PaySettingsImpl implements IEMPaySetting {
    public int checkOrderCount() {
        return 3;
    }

    public long checkOrderTimeInterval() {
        return 500L;
    }
}
