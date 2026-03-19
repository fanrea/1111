package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.permissionx.guolindev.PermissionX;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadHandleNotificationActivity extends Activity {
    private static final String[] d = {PermissionX.permission.POST_NOTIFICATIONS};
    private DownloadHandlerService hc = new DownloadHandlerService();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws JSONException {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
            d();
        } else {
            this.hc.onStartCommand(intent, 0, 0);
        }
        finish();
    }

    private void d() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(d, 1000);
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.an.d.hc("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            com.ss.android.socialbase.downloader.an.d.hc("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
