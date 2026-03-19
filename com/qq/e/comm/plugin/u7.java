package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.lang.reflect.Constructor;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class u7 {
    public static BaseSplashAd a(String str, Context context, String str2, String str3, String str4) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(BaseSplashAd.class).getDeclaredConstructor(Context.class, String.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        return (BaseSplashAd) declaredConstructor.newInstance(context, str2, str3, str4);
    }
}
