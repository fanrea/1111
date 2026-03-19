package com.qq.e.comm.plugin;

import android.widget.ImageView;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class om implements nm {
    private final nm a;
    private final long b = System.currentTimeMillis();

    public om(nm nmVar) {
        this.a = nmVar;
    }

    @Override // com.qq.e.comm.plugin.nm
    public void a(String str, ImageView imageView, ko koVar) throws JSONException {
        a(str, koVar, this.b);
        nm nmVar = this.a;
        if (nmVar != null) {
            nmVar.a(str, imageView, koVar);
        }
    }

    @Override // com.qq.e.comm.plugin.nm
    public void a(String str, int i, Exception exc) {
        nm nmVar = this.a;
        if (nmVar != null) {
            nmVar.a(str, i, exc);
        }
    }

    private void a(String str, ko koVar, long j) throws JSONException {
        int i;
        if (koVar.a() || j <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (koVar.g()) {
            i = 2130004;
        } else {
            i = koVar.h() ? 2130003 : 2130001;
        }
        wt wtVar = new wt(i);
        wtVar.b(jCurrentTimeMillis);
        wtVar.b((int) (koVar.d().length() / 1024));
        ja jaVar = new ja();
        jaVar.a("vu", str);
        wtVar.a(jaVar);
        b10.a(wtVar);
    }
}
