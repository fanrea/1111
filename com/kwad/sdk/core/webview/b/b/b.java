package com.kwad.sdk.core.webview.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.w;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.h.a.b bVar) {
        String str = bVar.cbn;
        File file = new File(str);
        if (!w.Y(file)) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.biL)) {
            String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
            if (fileMD5 != null && fileMD5.length() > 10) {
                fileMD5 = fileMD5.substring(0, 10);
            }
            if (!bq.isEquals(fileMD5, bVar.biL)) {
                w.al(file);
                return false;
            }
        }
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 2);
        try {
            com.kwad.sdk.core.webview.b.c.a.f(context, str, com.kwad.sdk.core.webview.b.c.a.V(context, bVar.cbm));
            w.al(file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 2, e.getMessage());
            return false;
        }
    }
}
