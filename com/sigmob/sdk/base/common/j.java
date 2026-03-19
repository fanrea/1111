package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface j {
    void a();

    void a(int requestedOrientation);

    void a(Class<? extends Activity> clazz, int requestCode, Bundle extras);

    void onBackPressed();

    void onSetContentView(View view);
}
