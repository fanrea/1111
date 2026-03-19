package com.baidu.mobads.container.components.command;

import android.content.Context;
import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;

    n(Context context, String str, int i) {
        this.a = context;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.a, this.b, this.c).show();
    }
}
