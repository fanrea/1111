package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface q {
    String getAESKey(Context context);

    void holdSdkConfig(SdkConfig sdkConfig);

    void onInit(Context context);

    void reportDexLoadError(Context context, DexLoadError dexLoadError);
}
