package com.alliance.ssp.ad.service;

import android.app.IntentService;
import android.content.Intent;
import com.alliance.ssp.ad.m0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YTSDKDownloadService extends IntentService {
    public YTSDKDownloadService() {
        super("YTSDKDownloadService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        action.getClass();
        if (action.equals("SA_TARGET_YT_NOTIFICATION_CLICK")) {
            a.a(this, "SA_TARGET_YT_NOTIFICATION_CLICK");
        } else if (action.equals("SA_TARGET_YT_NOTIFICATION_CANCEL")) {
            a.a(this, "SA_TARGET_YT_NOTIFICATION_CANCEL");
        }
    }

    public YTSDKDownloadService(String str) {
        super(str);
    }
}
