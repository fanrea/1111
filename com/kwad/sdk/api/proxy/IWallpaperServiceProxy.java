package com.kwad.sdk.api.proxy;

import android.app.Service;
import android.content.Intent;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IWallpaperServiceProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    void onCreate(Service service);

    @KsAdSdkDynamicApi
    void onDestroy(Service service);

    @KsAdSdkDynamicApi
    void onEngineCreate(SurfaceHolder surfaceHolder);

    @KsAdSdkDynamicApi
    void onEngineSurfaceCreated(SurfaceHolder surfaceHolder);

    @KsAdSdkDynamicApi
    void onEngineSurfaceDestroyed(SurfaceHolder surfaceHolder);

    @KsAdSdkDynamicApi
    void onEngineVisibilityChanged(boolean z);

    @KsAdSdkDynamicApi
    void onRebind(Service service, Intent intent);

    @KsAdSdkDynamicApi
    int onStartCommand(Service service, Intent intent, int i, int i2);

    boolean onUnbind(Service service, Intent intent);

    @KsAdSdkDynamicApi
    void setEngine(WallpaperService.Engine engine);
}
