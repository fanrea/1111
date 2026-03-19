package com.bytedance.sdk.djx.core.util;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.api.AntiFraudApi;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.AppLogManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AntiFraudManager {
    private boolean isBlock = false;
    private boolean hasLoad = false;

    public static AntiFraudManager getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final AntiFraudManager instance = new AntiFraudManager();

        private InnerHolder() {
        }
    }

    public void init() {
        if (this.hasLoad || TextUtils.isEmpty(AppLogManager.getAppLogInstance().getDid())) {
            return;
        }
        AntiFraudApi.loadAntiFraud(new IApiCallback<Boolean>() { // from class: com.bytedance.sdk.djx.core.util.AntiFraudManager.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, Boolean bool) {
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(Boolean bool) {
                AntiFraudManager.this.hasLoad = true;
                AntiFraudManager.this.isBlock = bool.booleanValue();
            }
        });
    }

    public boolean isBlock() {
        return this.isBlock;
    }
}
