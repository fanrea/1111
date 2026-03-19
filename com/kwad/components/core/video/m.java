package com.kwad.components.core.video;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m {
    private static Map<String, Integer> adb = new ConcurrentHashMap();

    public static boolean g(AdTemplate adTemplate, int i) throws NoSuchAlgorithmException {
        boolean zW;
        String strL = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        if (TextUtils.isEmpty(strL)) {
            return false;
        }
        a.C0589a c0589a = new a.C0589a();
        if (i < 0) {
            if (aM(adTemplate)) {
                return true;
            }
            zW = com.kwad.sdk.core.diskcache.b.a.ZH().a(strL, c0589a);
        } else {
            if (i <= 0) {
                return true;
            }
            zW = com.kwad.sdk.core.videocache.c.a.ch(ServiceProvider.getContext()).w(strL, i * 1024);
        }
        if (zW) {
            com.kwad.components.core.q.a.ss().e(adTemplate, 1);
        } else {
            com.kwad.components.core.q.a.ss().f(adTemplate, 1, c0589a.msg);
        }
        return zW;
    }

    public static boolean a(String str, String str2, a.C0589a c0589a) throws NoSuchAlgorithmException {
        String strMd5 = al.md5(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "start cache video key:" + strMd5 + "--url:" + str);
        boolean zB = com.kwad.sdk.core.diskcache.b.a.ZH().b(str, str2, c0589a);
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "finish cache video key:" + strMd5 + "--cache time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--success:" + zB);
        return zB;
    }

    public static boolean aM(AdTemplate adTemplate) {
        File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
        return fileDw != null && fileDw.exists();
    }

    public static String g(Context context, AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.b.e.fb(adTemplate), com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
    }

    public static String h(Context context, String str) {
        return a(context, aU(str), str);
    }

    private static String a(Context context, int i, String str) {
        if (i >= 0) {
            return i > 0 ? com.kwad.sdk.core.videocache.c.a.ch(context).ga(str) : str;
        }
        File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(str);
        return (fileDw == null || !fileDw.exists()) ? str : fileDw.getAbsolutePath();
    }

    public static void m(String str, int i) {
        adb.put(str, Integer.valueOf(i));
    }

    private static int aU(String str) {
        Integer num = adb.get(str);
        if (num != null) {
            return num.intValue();
        }
        return com.kwad.sdk.core.config.e.Uw();
    }
}
