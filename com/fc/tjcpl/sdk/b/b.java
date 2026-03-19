package com.fc.tjcpl.sdk.b;

import android.view.View;
import com.fc.tjcpl.sdk.apploader.NonWifiWarnActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements View.OnClickListener {
    public final /* synthetic */ NonWifiWarnActivity a;

    public b(NonWifiWarnActivity nonWifiWarnActivity) {
        this.a = nonWifiWarnActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NonWifiWarnActivity nonWifiWarnActivity = this.a;
        int i = NonWifiWarnActivity.a;
        nonWifiWarnActivity.finish();
        nonWifiWarnActivity.overridePendingTransition(0, 0);
        a.a(false);
    }
}
