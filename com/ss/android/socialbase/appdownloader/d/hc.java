package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc extends d {
    public hc(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.d.u
    public Intent hc() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.d.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
