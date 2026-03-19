package com.kwad.sdk.api.proxy;

import android.content.Context;
import android.content.Intent;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BaseProxyWallpaperService extends WallpaperService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private IWallpaperServiceProxy mDelegate;

    protected abstract IWallpaperServiceProxy getDelegate(Context context);

    @Override // android.service.wallpaper.WallpaperService
    public WallpaperService.Engine onCreateEngine() {
        VideoEngine videoEngine = new VideoEngine();
        this.mDelegate.setEngine(videoEngine);
        return videoEngine;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(Wrapper.wrapContextIfNeed(context));
        this.mDelegate = getDelegate(context);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.mDelegate.onUnbind(this, intent);
    }

    public boolean superOnUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDelegate.onCreate(this);
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDelegate.onDestroy(this);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        this.mDelegate.onRebind(this, intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null && intent != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        return this.mDelegate.onStartCommand(this, intent, i, i2);
    }

    public int superOnStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public class VideoEngine extends WallpaperService.Engine {
        public VideoEngine() {
            super(BaseProxyWallpaperService.this);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            BaseProxyWallpaperService.this.mDelegate.onEngineCreate(surfaceHolder);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
            BaseProxyWallpaperService.this.mDelegate.onEngineSurfaceCreated(surfaceHolder);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onVisibilityChanged(boolean z) {
            BaseProxyWallpaperService.this.mDelegate.onEngineVisibilityChanged(z);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            super.onSurfaceDestroyed(surfaceHolder);
            BaseProxyWallpaperService.this.mDelegate.onEngineSurfaceDestroyed(surfaceHolder);
        }
    }
}
