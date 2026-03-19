package com.bytedance.msdk.b.b.hc.d.hc;

import android.content.Context;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.z;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc extends com.bytedance.msdk.b.b.hc.d.hc {
    public hc(com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
    }

    public z d(Context context) {
        z csjLoader = DispatchAdSdkInitializerHolder.getCsjLoader(context);
        if (csjLoader == null) {
            d(new com.bytedance.msdk.api.d("ClassCastException：load ad fail loader is null"));
        }
        return csjLoader;
    }

    @Override // com.bytedance.msdk.b.d.d
    public String d(String str) {
        try {
            return com.bytedance.sdk.gromore.init.d.b();
        } catch (Exception unused) {
            return cm.d;
        }
    }
}
