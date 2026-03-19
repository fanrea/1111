package com.bytedance.sdk.djx.empty;

import com.bytedance.sdk.djx.IDJXRecSwitchCallback;
import com.bytedance.sdk.djx.IDJXUpdate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EmptyDJXUpdate implements IDJXUpdate {
    @Override // com.bytedance.sdk.djx.IDJXUpdate
    public boolean getPersonRec() {
        return true;
    }

    @Override // com.bytedance.sdk.djx.IDJXUpdate
    public String getToken() {
        return "";
    }

    @Override // com.bytedance.sdk.djx.IDJXUpdate
    public void setPersonalRec(boolean z, IDJXRecSwitchCallback iDJXRecSwitchCallback) {
    }

    public static EmptyDJXUpdate getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final EmptyDJXUpdate instance = new EmptyDJXUpdate();

        private InnerHolder() {
        }
    }
}
