package com.qq.e.comm.plugin;

import android.app.Activity;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.lang.reflect.Constructor;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class v7 {
    public static BaseInterstitialAd a(String str, Activity activity, String str2, String str3, String str4) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(BaseInterstitialAd.class).getDeclaredConstructor(Activity.class, String.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        return (BaseInterstitialAd) declaredConstructor.newInstance(activity, str2, str3, str4);
    }
}
