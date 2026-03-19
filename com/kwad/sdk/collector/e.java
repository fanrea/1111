package com.kwad.sdk.collector;

import android.os.Build;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    public static String dU(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return new String(com.kwad.sdk.core.a.c.ZW().encode(q.s(w.af(new File(str)))));
            } catch (IOException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return null;
    }
}
