package com.bytedance.sdk.djx.core;

import com.bytedance.sdk.djx.IEMBaseService;
import com.bytedance.sdk.djx.core.impl.EMBSImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EMBaseInternal {
    public static IEMBaseService service() {
        return EMBSImpl.getInstance();
    }
}
