package com.baidu.mobads.container.w.c;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private final HashSet<String> a;
    private final HashSet<String> b;

    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    private b() {
        this.a = new HashSet<>();
        this.b = new HashSet<>();
        this.b.add("com.baidu.mobads.sdk.api.AdViewListener");
        this.b.add("com.baidu.mobads.sdk.api.SplashInteractionListener");
        this.b.add("com.baidu.mobads.sdk.api.ScreenVideoAdListener");
        this.b.add("com.baidu.mobads.sdk.api.INativeVideoListener");
        this.b.add("com.baidu.mobads.sdk.api.IFeedPortraitListener");
        this.b.add("com.baidu.mobads.sdk.api.ExpressInterstitialListener");
        this.b.add("com.baidu.mobads.sdk.api.SplashAd");
        this.b.add("com.baidu.mobads.sdk.api.RewardVideoAd");
        this.b.add("com.baidu.mobads.sdk.api.ExpressInterstitialAd");
        this.b.add("com.baidu.mobads.sdk.api.BaiduNativeManager");
        this.b.add("com.baidu.mobads.sdk.api.NativeCPUManager");
        try {
            Iterator<String> it = this.b.iterator();
            while (it.hasNext()) {
                Class<?> cls = Class.forName(it.next());
                if (cls.isInterface()) {
                    for (Method method : cls.getMethods()) {
                        this.a.add(method.getName());
                    }
                } else {
                    for (Class<?> cls2 : cls.getDeclaredClasses()) {
                        if (cls2.isInterface()) {
                            for (Method method2 : cls2.getMethods()) {
                                this.a.add(method2.getName());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static b a() {
        return a.a;
    }

    public boolean a(String str) {
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }
}
