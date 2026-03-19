package com.kwad.components.ad.fullscreen.b;

import com.kwad.sdk.core.d.c;
import com.pandora.common.utils.Times;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat ls = new SimpleDateFormat(Times.YYYY_MM_DD);
    public long lt;
    public int lu;

    public b() {
        this.lt = -1L;
        this.lu = -1;
    }

    public b(long j, int i) {
        this.lt = j;
        this.lu = 1;
    }

    public final boolean j(long j) {
        if (this.lt > 0 && j > 0) {
            try {
                return ls.format(new Date(this.lt)).equals(ls.format(new Date(j)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public final boolean F(int i) {
        int i2 = this.lu;
        return i2 > 0 && i2 >= i;
    }
}
