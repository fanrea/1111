package com.android.gdt.qone.ad;

import android.content.Context;
import com.android.gdt.qone.q.a$$ExternalSyntheticBackport0;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a {
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public final String a;
    public boolean b;

    public a(String str) {
        this.a = str;
    }

    public static a a(String str) {
        ConcurrentHashMap concurrentHashMap = c;
        a aVar = (a) concurrentHashMap.get(str);
        if (aVar == null) {
            synchronized (a.class) {
                aVar = (a) concurrentHashMap.get(str);
                if (aVar == null) {
                    aVar = new a(str);
                    concurrentHashMap.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    public final synchronized void a(Context context, String str) {
        if (this.b) {
            return;
        }
        com.android.gdt.qone.ae.b.a(this.a);
        a$$ExternalSyntheticBackport0.m(context.getApplicationContext().getFilesDir(), ILogConst.CACHE_PLAY_REASON_NULL);
        String str2 = File.separator;
        this.b = true;
    }
}
