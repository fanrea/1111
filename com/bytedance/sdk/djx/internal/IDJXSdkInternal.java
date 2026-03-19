package com.bytedance.sdk.djx.internal;

import android.content.Context;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IBaseStartListener;
import com.bytedance.sdk.djx.IDJXCave;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.IDJXUpdate;
import com.bytedance.sdk.djx.IDJXWidgetFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXSdkInternal {
    IDJXCave cave();

    IDJXWidgetFactory factory();

    void initialize(Context context, String str, DJXSdkConfig dJXSdkConfig, IBaseStartListener iBaseStartListener);

    IDJXService service();

    IDJXUpdate update();
}
