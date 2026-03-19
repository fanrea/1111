package com.bykv.vk.openvk.component.video.d.hc;

import android.content.Context;
import com.bykv.vk.openvk.component.video.d.hc.d.b;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    static volatile boolean an;
    public static volatile boolean c;
    static volatile com.bykv.vk.openvk.component.video.d.hc.d.hc d;
    static volatile com.bykv.vk.openvk.component.video.d.hc.d.b hc;
    private static volatile Context mk;
    private static volatile com.bykv.vk.openvk.component.video.d.hc.hc.b tc;
    public static volatile Integer tt;
    public static final boolean b = com.bytedance.sdk.component.utils.mq.b();
    static volatile boolean u = true;
    static volatile int h = 0;
    public static volatile int gb = 3;

    public static Context getContext() {
        return mk;
    }

    public static void d(boolean z) {
        u = z;
    }

    public static void hc(boolean z) {
        an = z;
    }

    public static void d(int i) {
        h = i;
    }

    public static void d(com.bykv.vk.openvk.component.video.d.hc.d.b bVar, Context context) {
        if (bVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        mk = context.getApplicationContext();
        if (hc != null) {
            return;
        }
        com.bykv.vk.openvk.component.video.d.hc.d.hc hcVar = d;
        if (hcVar != null && hcVar.d.getAbsolutePath().equals(bVar.d.getAbsolutePath())) {
            throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
        }
        hc = bVar;
        tc = com.bykv.vk.openvk.component.video.d.hc.hc.b.d(context);
        hc.d(new b.d() { // from class: com.bykv.vk.openvk.component.video.d.hc.u.1
            @Override // com.bykv.vk.openvk.component.video.d.hc.d.b.d
            public void d(String str) {
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_DiskLruCache", "new cache created: ".concat(String.valueOf(str)));
                }
            }

            @Override // com.bykv.vk.openvk.component.video.d.hc.d.b.d
            public void d(Set<String> set) {
                u.tc.d(set, 0);
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_DiskLruCache", "cache file removed, ".concat(String.valueOf(set)));
                }
            }
        });
        an anVarD = an.d();
        anVarD.d(bVar);
        anVarD.d(tc);
        c cVarB = c.b();
        cVarB.d(bVar);
        cVarB.d(tc);
    }

    public static com.bykv.vk.openvk.component.video.d.hc.d.b d() {
        return hc;
    }

    public static com.bykv.vk.openvk.component.video.d.hc.d.hc hc() {
        return d;
    }
}
