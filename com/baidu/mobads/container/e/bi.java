package com.baidu.mobads.container.e;

import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bi implements Runnable {
    final /* synthetic */ bh a;

    bi(bh bhVar) {
        this.a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.ay != null) {
            TextView textView = this.a.a.ay;
            StringBuilder sb = new StringBuilder();
            double d = this.a.a.aw;
            double d2 = this.a.a.au;
            Double.isNaN(d2);
            textView.setText(sb.append(((int) (d - d2)) / 1000).append("s").toString());
        }
    }
}
