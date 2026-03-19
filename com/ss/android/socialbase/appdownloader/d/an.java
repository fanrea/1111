package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an extends d {
    public an(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.d.u
    public Intent hc() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
