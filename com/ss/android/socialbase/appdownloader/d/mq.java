package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mq extends d {
    public mq(Context context, com.ss.android.socialbase.downloader.uo.d dVar, String str) {
        super(context, dVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.d.u
    public Intent hc() {
        String strB = this.hc.b("s");
        String strD = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("ag"), strB);
        String strD2 = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("ah"), strB);
        String strD3 = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("ai"), strB);
        String strD4 = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("aj"), strB);
        Intent intent = new Intent();
        intent.putExtra(strD, this.b);
        intent.putExtra(strD2, "*/*");
        intent.putExtra(strD3, true);
        intent.setAction(strD4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
