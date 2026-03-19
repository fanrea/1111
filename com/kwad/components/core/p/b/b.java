package com.kwad.components.core.p.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.p.b.a.j;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.d.c;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static final AtomicBoolean mHasInit = new AtomicBoolean();

    public static void init(final Context context) {
        AtomicBoolean atomicBoolean = mHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new j());
        h.execute(new bh() { // from class: com.kwad.components.core.p.b.b.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                b.ax(context);
            }
        });
    }

    @ForInvoker(methodId = "initOC")
    public static void ax(Context context) {
        com.kwad.components.offline.a.b.aQ(context);
        com.kwad.components.offline.b.b.aQ(context);
        com.kwad.components.offline.c.b.aQ(context);
        c.aQ(context);
    }
}
