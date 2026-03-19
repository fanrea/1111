package com.alliance.ssp.ad.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.alliance.ssp.ad.m0.a;
import com.alliance.ssp.ad.o0.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class DeepLinkProxyActivity extends Activity {
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        int i3 = l.a;
        if (i == 589461) {
            if (i2 == 0) {
                a.a(this, "SA_TARGET_YT_DEEPLINK_OPEN_FAIL");
            } else {
                a.a(this, "SA_TARGET_YT_DEEPLINK_OPEN_SUCCESS");
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = true;
        requestWindowFeature(1);
        int i = l.a;
        if (getIntent() != null) {
            String[] strArr = {getIntent().getStringExtra("adn_sdk_deeplink_url")};
            for (int i2 = 0; i2 < 1; i2++) {
                String str = strArr[i2];
                if (str == null || str.isEmpty()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                String stringExtra = getIntent().getStringExtra("adn_sdk_deeplink_url");
                int i3 = l.a;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringExtra));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 589461);
                    return;
                } else {
                    a.a(this, "SA_TARGET_YT_DEEPLINK_OPEN_FAIL");
                    finish();
                    return;
                }
            }
        }
        a.a(this, "SA_TARGET_YT_DEEPLINK_OPEN_FAIL");
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = l.a;
        a.a(this, "SA_TARGET_YT_DEEPLINK_OPEN_FINISH");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        int i = l.a;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        int i = l.a;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        int i = l.a;
        finish();
    }
}
