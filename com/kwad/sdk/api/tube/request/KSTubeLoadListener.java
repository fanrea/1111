package com.kwad.sdk.api.tube.request;

import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KSTubeLoadListener {
    void onError(int i, String str);

    void onSuccess(KSTubeResult kSTubeResult);
}
