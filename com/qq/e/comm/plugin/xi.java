package com.qq.e.comm.plugin;

import android.content.Intent;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.HADI;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xi implements HADI {
    private final HybridADListener a;
    private final HybridADSetting b;

    public xi(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.b = hybridADSetting;
        this.a = hybridADListener;
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        Intent intent = new Intent();
        intent.setClassName(r1.d().a(), wx.a());
        intent.addFlags(268435456);
        intent.putExtra("appid", r1.d().b().a());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.HYBRID_AD_PAGE);
        String strValueOf = String.valueOf(ks.a());
        intent.putExtra("objectId", strValueOf);
        yi yiVar = (yi) zm.a(strValueOf, yi.class);
        HybridADSetting hybridADSetting = this.b;
        if (hybridADSetting == null) {
            hybridADSetting = new HybridADSetting();
        }
        yiVar.a(hybridADSetting);
        yiVar.a(this.a);
        intent.putExtra("url", str);
        r1.d().a().startActivity(intent);
        xo.a((Runnable) new a());
        b10.a(21042, null, 1);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xi.this.a != null) {
                xi.this.a.onPageShow();
            }
        }
    }
}
