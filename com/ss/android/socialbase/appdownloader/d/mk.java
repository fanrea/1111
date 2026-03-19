package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mk extends d {
    public mk(Context context, com.ss.android.socialbase.downloader.uo.d dVar, String str) {
        super(context, dVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.d.u
    public Intent hc() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.b);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
