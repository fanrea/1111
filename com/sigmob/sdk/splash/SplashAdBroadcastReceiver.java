package com.sigmob.sdk.splash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.splash.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SplashAdBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter a;
    private d.a b;

    public SplashAdBroadcastReceiver(d.a adInteractionListener, String broadcastIdentifier) {
        super(broadcastIdentifier);
        this.b = adInteractionListener;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (a == null) {
            IntentFilter intentFilter = new IntentFilter();
            a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_SPLAH_STOP_TIME);
            a.addAction(IntentActions.ACTION_SPLAH_PLAYFAIL);
            a.addAction(IntentActions.ACTION_SPLAH_SKIP);
            a.addAction(IntentActions.ACTION_LANDPAGE_SHOW);
            a.addAction(IntentActions.ACTION_LANDPAGE_DISMISS);
        }
        return a;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.b != null && a(intent)) {
            String action = intent.getAction();
            if (m.a((CharSequence) action)) {
                return;
            }
            action.hashCode();
            switch (action) {
                case "action.splash.playFail":
                    this.b.a_();
                    break;
                case "action.splash.play":
                    this.b.k();
                    break;
                case "action.splash.skip":
                    this.b.b_();
                    break;
                case "action.loadpage.show":
                    this.b.a();
                    break;
                case "action.splash.stoptime":
                    this.b.l();
                    break;
                case "action.loadpage.dismiss":
                    this.b.b();
                    break;
            }
        }
    }
}
