package com.alliance.ssp.ad.a0;

import android.view.View;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.r.c;

/* compiled from: NMStreamAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements View.OnClickListener {
    public final /* synthetic */ Material a;
    public final /* synthetic */ b b;

    public e(b bVar, Material material) {
        this.b = bVar;
        this.a = material;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.J0.c.onAdClick();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        b bVar = this.b;
        if (!bVar.a(this.a, bVar.O0, true, (c.b) null, (com.alliance.ssp.ad.c0.a) null) || (iVar = this.b.J0) == null || iVar.c == null) {
            return;
        }
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.a0.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }
}
