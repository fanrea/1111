package com.bytedance.sdk.djx.core;

import android.content.Context;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IBaseStartListener;
import com.bytedance.sdk.djx.IDJXCave;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.IDJXUpdate;
import com.bytedance.sdk.djx.IDJXWidgetFactory;
import com.bytedance.sdk.djx.core.init.DJXCaveImpl;
import com.bytedance.sdk.djx.core.init.DJXUpdateImpl;
import com.bytedance.sdk.djx.internal.IDJXSdkInternal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DJXSdkImpl2 implements IDJXSdkInternal {
    private static final String TAG = "DJXSdkImpl2";

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public void initialize(Context context, String str, DJXSdkConfig dJXSdkConfig, IBaseStartListener iBaseStartListener) {
    }

    DJXSdkImpl2() {
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXWidgetFactory factory() {
        return DJXWidgetFactoryProxy.getInstance();
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXService service() {
        return new DJXServiceProxy();
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXCave cave() {
        return DJXCaveImpl.getInstance();
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXUpdate update() {
        return DJXUpdateImpl.getInstance();
    }

    public static DJXSdkImpl2 getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DJXSdkImpl2 instance = new DJXSdkImpl2();

        private InnerHolder() {
        }
    }
}
