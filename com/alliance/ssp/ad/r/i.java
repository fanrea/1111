package com.alliance.ssp.ad.r;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ImageLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i {
    public static i c;
    public com.alliance.ssp.ad.s.c a;
    public ExecutorService b = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /* compiled from: ImageLoader.java */
    public interface a {
        void a(String str, Bitmap bitmap);

        void a(String str, Exception exc);
    }

    public i() {
        Context contextA = com.alliance.ssp.ad.d0.b.b().a();
        if (contextA != null) {
            this.a = new com.alliance.ssp.ad.s.d(contextA);
        }
    }

    public static i a() {
        if (c == null) {
            synchronized (i.class) {
                c = new i();
            }
        }
        return c;
    }

    public void a(String str, a aVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                if (aVar != null) {
                    aVar.a(str, new Exception("image url is empty"));
                    return;
                }
                return;
            }
            com.alliance.ssp.ad.s.c cVar = this.a;
            Bitmap bitmapA = cVar == null ? null : cVar.a(str);
            if (bitmapA != null && aVar != null) {
                aVar.a(str, bitmapA);
            } else {
                this.b.submit(new h(this, str, aVar));
            }
        } catch (Exception e) {
            if (aVar != null) {
                aVar.a(str, e);
            }
        }
    }
}
