package com.kwad.components.core.m;

import com.kwad.sdk.core.d.c;
import com.pandora.common.utils.Times;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat Te = new SimpleDateFormat(Times.YYYY_MM_DD);
    public int Tf;
    public long Tg;

    public final boolean l(int i, int i2) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.Tg > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = Te.format(new Date(this.Tg));
            String str2 = Te.format(new Date(jCurrentTimeMillis));
            c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + str + ", currentDate: " + str2);
            if (!str.equals(str2)) {
                this.Tf = 0;
                qF();
                return true;
            }
            long j = this.Tg + (i * 60 * 60 * 1000);
            c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.Tf);
            if (j >= jCurrentTimeMillis || this.Tf > i2) {
                return false;
            }
            qF();
            return true;
        }
        qF();
        return true;
    }

    public final void qF() {
        this.Tg = System.currentTimeMillis();
        this.Tf++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Tg + ", currentActiveCount " + this.Tf);
    }
}
