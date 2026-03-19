package com.kwad.components.ct.wallpaper.d;

import android.app.Activity;
import android.app.Service;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.sdk.api.proxy.BaseProxyWallpaperService;
import com.kwad.sdk.api.proxy.IWallpaperServiceProxy;
import com.kwad.sdk.api.proxy.VideoWallpaperService;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.d;
import com.kwad.sdk.core.video.a.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a implements IWallpaperServiceProxy {
    private WallpaperService.Engine aZP;
    private String aZQ;
    private long aZR = 0;
    private c abH;

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void onCreate(Service service) {
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void onDestroy(Service service) {
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void onEngineCreate(SurfaceHolder surfaceHolder) {
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void onRebind(Service service, Intent intent) {
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void setEngine(WallpaperService.Engine engine) {
        this.aZP = engine;
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void onEngineSurfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            c cVar = this.abH;
            if (cVar != null) {
                if (cVar.isPlaying()) {
                    return;
                }
            }
            Context context = null;
            try {
                context = ServiceProvider.getContext();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            if (context == null) {
                return;
            }
            String strDM = ag.dM(context);
            if (TextUtils.isEmpty(strDM)) {
                return;
            }
            this.abH = k(context, strDM);
            a(surfaceHolder.getSurface());
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void onEngineVisibilityChanged(boolean z) throws IOException {
        Context context;
        if (z) {
            if (this.abH == null && (context = ServiceProvider.getContext()) != null) {
                String strDM = ag.dM(context);
                if (TextUtils.isEmpty(strDM) || !ck(strDM)) {
                    try {
                        WallpaperManager.getInstance(context).clear();
                        Lo();
                        return;
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.e("VideoWallpaperServiceProxy", "WallpaperManager clear error", e);
                        return;
                    }
                }
                j(context, strDM);
                return;
            }
            return;
        }
        try {
            if (this.abH != null) {
                this.aZR = (int) r3.getCurrentPosition();
                Lo();
            }
        } catch (Exception unused) {
            this.abH = null;
        }
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public void onEngineSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        Lo();
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        Context context = ServiceProvider.getContext();
        if (context == null) {
            if (service instanceof BaseProxyWallpaperService) {
                return ((BaseProxyWallpaperService) service).superOnStartCommand(intent, i, i2);
            }
            throw new RuntimeException(service + " must be BaseProxyWallpaperService");
        }
        String stringExtra = intent == null ? null : intent.getStringExtra("wall_paper_path");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = ag.dM(context);
        }
        j(context, stringExtra);
        return 1;
    }

    @Override // com.kwad.sdk.api.proxy.IWallpaperServiceProxy
    public boolean onUnbind(Service service, Intent intent) {
        if (service instanceof BaseProxyWallpaperService) {
            return ((BaseProxyWallpaperService) service).superOnUnbind(intent);
        }
        throw new RuntimeException(service + " must be AbstractServiceProxy");
    }

    private void j(Context context, String str) {
        if (TextUtils.equals(str, this.aZQ) || TextUtils.isEmpty(str) || !ck(str)) {
            return;
        }
        try {
            Lo();
            this.abH = k(context, str);
            a(this.aZP.getSurfaceHolder().getSurface());
            ag.aq(context, str);
            this.aZQ = str;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("VideoWallpaperServiceProxy", "VideoWallpaperServiceProxy set MediaPlayer error", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static c k(Context context, String str) {
        com.kwad.sdk.core.video.a.b bVar;
        try {
            if (e.Wo() && com.kwad.sdk.core.config.e.TN() && e.acI()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(0);
                dVar.cB(false);
                bVar = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                bVar = new com.kwad.sdk.core.video.a.b();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            bVar = new com.kwad.sdk.core.video.a.b();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                bVar.setDataSource(str);
            } else {
                com.kwad.sdk.core.d.c.e("VideoWallpaperServiceProxy", "videoUrl is null");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        return bVar;
    }

    private void a(Surface surface) {
        c cVar = this.abH;
        if (cVar == null) {
            return;
        }
        cVar.b(new c.e() { // from class: com.kwad.components.ct.wallpaper.d.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar2) {
                try {
                    if (a.this.abH != null) {
                        a.this.abH.seekTo(a.this.aZR);
                        a.this.abH.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        this.abH.setSurface(surface);
        this.abH.setLooping(true);
        this.abH.setVolume(0.0f, 0.0f);
        this.abH.prepareAsync();
    }

    private void Lo() {
        this.aZQ = "";
        try {
            c cVar = this.abH;
            if (cVar != null) {
                cVar.stop();
                this.abH.release();
                this.abH = null;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("VideoWallpaperServiceProxy", "destroyMediaPlayer error", e);
        }
    }

    public static void a(Activity activity, String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            ComponentName componentName = new ComponentName("com.kwai.kwad.wallpaper", "com.kwai.kwad.wallpaper.MainActivity");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("wall_paper_path", str);
            bundle.putString("wall_paper_photo_id", str2);
            intent.putExtras(bundle);
            intent.setComponent(componentName);
            activity.startActivity(intent);
            if (l(activity, "com.kwai.kwad.wallpaper.service.KwaiWallPaperService")) {
                ac.ae(activity, "设置成功");
                return;
            }
            return;
        }
        m(activity, str);
        if (!l(activity, VideoWallpaperService.class.getName())) {
            ag.aq(activity, str);
            Intent intent2 = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
            intent2.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(activity, (Class<?>) VideoWallpaperService.class));
            activity.startActivity(intent2);
            return;
        }
        Intent intent3 = new Intent(activity, (Class<?>) VideoWallpaperService.class);
        intent3.putExtra("wall_paper_path", str);
        intent3.putExtra("wall_paper_photo_id", str2);
        activity.startService(intent3);
    }

    private static boolean l(Context context, String str) {
        WallpaperInfo wallpaperInfoAL = aL(context);
        return wallpaperInfoAL != null && TextUtils.equals(wallpaperInfoAL.getServiceName(), str);
    }

    private static WallpaperInfo aL(Context context) {
        try {
            return WallpaperManager.getInstance(context).getWallpaperInfo();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("VideoWallpaperServiceProxy", "getWallpaperInfo error", e);
            return null;
        }
    }

    private static boolean ck(String str) {
        return new File(str).exists();
    }

    private static void m(Context context, String str) {
        String strDM = ag.dM(context);
        String strDM2 = ag.dM(context);
        File parentFile = new File(str).getParentFile();
        if (parentFile == null || !parentFile.isDirectory()) {
            com.kwad.sdk.core.d.c.e("VideoWallpaperServiceProxy", "video file parent should be dir");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strDM);
        arrayList.add(strDM2);
        arrayList.add(str);
        ArrayList arrayList2 = new ArrayList();
        w.a(parentFile, arrayList, arrayList2);
        if (arrayList2.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.c.e("VideoWallpaperServiceProxy", "delete other files failed " + arrayList2);
    }
}
