package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.hc.d.mq;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static int an = 1;
    private static String b = null;
    private static boolean c = false;
    public static boolean d = false;
    private static Context hc;
    private static mq u;

    public static Context getContext() {
        return hc;
    }

    public static String d() {
        if (TextUtils.isEmpty(b)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hc.d(getContext()), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                b = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
        return b;
    }

    public static void d(Context context, String str) {
        hc = context;
        b = str;
    }

    public static boolean hc() {
        return c;
    }

    public static void d(boolean z) {
        c = z;
    }

    public static mq b() {
        if (u == null) {
            u = new mq.d("v_config").d(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).hc(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).b(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).d();
        }
        return u;
    }

    public static void d(mq mqVar) {
        u = mqVar;
    }

    public static boolean c() {
        return d;
    }

    public static int u() {
        return an;
    }
}
