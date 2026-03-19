package com.bytedance.sdk.djx.core.init;

import com.bytedance.sdk.djx.IDJXRecSwitchCallback;
import com.bytedance.sdk.djx.IDJXUpdate;
import com.bytedance.sdk.djx.net.token.TokenHelper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXUpdateImpl implements IDJXUpdate {
    public static DJXUpdateImpl getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DJXUpdateImpl instance = new DJXUpdateImpl();

        private InnerHolder() {
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXUpdate
    public void setPersonalRec(boolean z, IDJXRecSwitchCallback iDJXRecSwitchCallback) {
        TokenHelper.getInstance().setRecommendSwitch(z, iDJXRecSwitchCallback);
    }

    @Override // com.bytedance.sdk.djx.IDJXUpdate
    public boolean getPersonRec() {
        return TokenHelper.getInstance().getRecommendSwitch();
    }

    @Override // com.bytedance.sdk.djx.IDJXUpdate
    public String getToken() {
        return TokenHelper.getInstance().getToken();
    }
}
