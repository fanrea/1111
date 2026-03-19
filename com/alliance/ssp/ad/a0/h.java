package com.alliance.ssp.ad.a0;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: NMStreamAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h implements View.OnClickListener {
    public final /* synthetic */ b a;

    public h(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Activity activityB = com.alliance.ssp.ad.o0.b.b();
        if (activityB != null) {
            activityB.setRequestedOrientation(1);
            b bVar = this.a;
            bVar.getClass();
            try {
                bVar.G0.setVisibility(0);
                bVar.H0.setVisibility(8);
                bVar.I0.width = bVar.g.getExpressViewAcceptedWidth();
                bVar.I0.height = bVar.g.getExpressViewAcceptedHeight();
                bVar.D0.setLayoutParams(bVar.I0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
