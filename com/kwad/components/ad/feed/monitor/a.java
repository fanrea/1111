package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static Pair<Integer, String> n(AdTemplate adTemplate) {
        String strL = com.kwad.sdk.core.response.b.a.L(e.eP(adTemplate));
        if (TextUtils.isEmpty(strL)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int iUw = com.kwad.sdk.core.config.e.Uw();
        String str = "";
        int i = 1;
        if (iUw < 0) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(strL);
            if (!w.Y(fileDw)) {
                a.C0589a c0589a = new a.C0589a();
                int i2 = com.kwad.sdk.core.diskcache.b.a.ZH().a(strL, c0589a) ? 1 : 2;
                str = c0589a.msg;
                i = i2;
            }
            adTemplate.setDownloadSize(fileDw != null ? fileDw.length() : 0L);
        } else if (iUw > 0) {
            a.C0589a c0589a2 = new a.C0589a();
            f fVarCh = com.kwad.sdk.core.videocache.c.a.ch(ServiceProvider.getContext());
            if (!fVarCh.gc(strL)) {
                i = fVarCh.a(strL, (long) (iUw * 1024), c0589a2, null) ? 1 : 2;
            }
            str = c0589a2.msg;
            adTemplate.setDownloadSize(iUw * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i), str);
    }
}
