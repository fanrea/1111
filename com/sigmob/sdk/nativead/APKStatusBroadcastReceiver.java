package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class APKStatusBroadcastReceiver extends BaseBroadcastReceiver {
    n.a a;
    IntentFilter b;

    public APKStatusBroadcastReceiver(n.a eventInterstitialListener, String broadcastIdentifier) {
        super(broadcastIdentifier);
        this.a = eventInterstitialListener;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (this.b == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.b = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_START);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        }
        return this.b;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        boolean zEqualsIgnoreCase;
        long longExtra;
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.a == null || !a(intent) || (action = intent.getAction()) == null) {
            return;
        }
        zEqualsIgnoreCase = "1".equalsIgnoreCase(intent.getStringExtra("result"));
        longExtra = intent.getLongExtra("downloadId", -1L);
        action.hashCode();
        switch (action) {
            case "action.interstitial.download.end":
                this.a.b(zEqualsIgnoreCase, longExtra);
                break;
            case "action.interstitial.download.pause":
                this.a.c(zEqualsIgnoreCase, longExtra);
                break;
            case "action.interstitial.download.start":
                this.a.a(zEqualsIgnoreCase, longExtra);
                break;
            case "action.interstitial.install.end":
                this.a.b(zEqualsIgnoreCase);
                break;
            case "action.interstitial.install.start":
                this.a.a(zEqualsIgnoreCase);
                break;
        }
    }
}
