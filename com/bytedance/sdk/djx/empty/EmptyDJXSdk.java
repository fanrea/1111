package com.bytedance.sdk.djx.empty;

import android.content.Context;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IBaseStartListener;
import com.bytedance.sdk.djx.IDJXCave;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.IDJXUpdate;
import com.bytedance.sdk.djx.IDJXWidgetFactory;
import com.bytedance.sdk.djx.internal.IDJXSdkInternal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EmptyDJXSdk implements IDJXSdkInternal {
    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXCave cave() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXWidgetFactory factory() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public void initialize(Context context, String str, DJXSdkConfig dJXSdkConfig, IBaseStartListener iBaseStartListener) {
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXService service() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXUpdate update() {
        return null;
    }

    public static EmptyDJXSdk getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final EmptyDJXSdk instance = new EmptyDJXSdk();

        private InnerHolder() {
        }
    }
}
