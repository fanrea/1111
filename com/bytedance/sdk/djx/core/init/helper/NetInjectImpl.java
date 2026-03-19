package com.bytedance.sdk.djx.core.init.helper;

import com.bytedance.sdk.djx.core.util.DidDegradeUtil;
import com.bytedance.sdk.djx.net.INetInitInject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NetInjectImpl implements INetInitInject {
    @Override // com.bytedance.sdk.djx.net.INetInitInject
    public String getPlayerVersion() {
        return PLTHelper.getInstance().getVodVersion();
    }

    @Override // com.bytedance.sdk.djx.net.INetInitInject
    public boolean isDidDegrade() {
        return DidDegradeUtil.isDegrade();
    }

    @Override // com.bytedance.sdk.djx.net.INetInitInject
    public void setErrCode11() {
        DidDegradeUtil.setErrCode11(true);
    }
}
