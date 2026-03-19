package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static final Map<Class<?>, Class<?>> ckM = new HashMap(128);
    private static final Map<Class<?>, Class<?>> ckN = new HashMap();
    private static boolean ckO = false;
    private static boolean ckP = false;

    public static void init() {
        anp();
        anr();
    }

    private static synchronized void anp() {
        if (ckO) {
            return;
        }
        anq();
        ckO = true;
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void anq() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        com.kwad.components.core.page.d.register();
        com.kwad.components.core.t.a.a.register();
        com.kwad.components.ct.feed.a.a.init();
        com.kwad.components.ct.horizontal.detail.a.init();
        com.kwad.components.ct.horizontal.news.a.init();
        com.kwad.components.ct.hotspot.hometab.a.init();
        com.kwad.components.ct.profile.home.a.init();
        com.kwad.components.ct.profile.tabvideo.detail.c.init();
        com.kwad.components.ct.related.b.init();
        com.kwad.components.ct.tube.channel.detail.a.init();
        com.kwad.components.ct.tube.channel.home.a.init();
        com.kwad.components.ct.tube.history.a.init();
        com.kwad.components.ct.tube.slide.a.init();
        com.kwad.components.ct.wallpaper.a.init();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    public static void g(Class<?> cls, Class<?> cls2) {
        ckM.put(cls, cls2);
    }

    public static Class<?> A(Class<?> cls) {
        anp();
        return ckM.get(cls);
    }

    private static synchronized void anr() {
        if (ckP) {
            return;
        }
        ans();
        ckP = true;
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void ans() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.r.b.register();
        SceneImpl.register();
    }

    public static void h(Class cls, Class cls2) {
        ckN.put(cls, cls2);
    }

    public static Class<?> B(Class<?> cls) {
        anr();
        return ckN.get(cls);
    }
}
