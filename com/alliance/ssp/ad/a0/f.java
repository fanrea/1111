package com.alliance.ssp.ad.a0;

import android.view.View;
import com.alliance.ssp.ad.o0.n;

/* compiled from: NMStreamAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f implements View.OnClickListener {
    public final /* synthetic */ b a;

    public f(b bVar) {
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.a.J0.c.onAdSkip();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.Q0.removeCallbacksAndMessages(null);
        i iVar = this.a.J0;
        if (iVar == null || iVar.c == null) {
            return;
        }
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.a0.f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }
}
