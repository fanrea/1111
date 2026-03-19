package com.kwad.components.ad.splashscreen.e;

import android.os.Message;
import android.view.View;
import com.kwad.sdk.core.config.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.core.widget.a.c {
    public d(View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.a, com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        long jZc = e.Zc();
        if (message.what == 666) {
            wJ();
            this.dC.sendEmptyMessageDelayed(666, jZc);
        }
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ai() {
        com.kwad.sdk.core.c.b.aaf();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.aaf();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ai();
        }
        return super.ai();
    }
}
