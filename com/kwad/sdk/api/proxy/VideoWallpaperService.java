package com.kwad.sdk.api.proxy;

import android.content.Context;
import com.kwad.sdk.api.loader.Loader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoWallpaperService extends BaseProxyWallpaperService {
    @Override // com.kwad.sdk.api.proxy.BaseProxyWallpaperService
    protected IWallpaperServiceProxy getDelegate(Context context) {
        return (IWallpaperServiceProxy) Loader.get().newComponentProxy(context, VideoWallpaperService.class, this);
    }
}
