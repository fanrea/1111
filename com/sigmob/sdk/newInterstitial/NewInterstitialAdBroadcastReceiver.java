package com.sigmob.sdk.newInterstitial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.newInterstitial.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NewInterstitialAdBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter a;
    private e.a b;
    private BaseAdUnit c;

    public NewInterstitialAdBroadcastReceiver(BaseAdUnit adUnit, e.a listener, String broadcastIdentifier) {
        super(broadcastIdentifier);
        this.c = adUnit;
        this.b = listener;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (a == null) {
            IntentFilter intentFilter = new IntentFilter();
            a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        return a;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.b == null || this.c == null || !a(intent)) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        action.hashCode();
        switch (action) {
            case "action.rewardedvideo.playFail":
                this.b.c(this.c, intent.getStringExtra("error"));
                break;
            case "action.rewardedvideo.play":
                this.b.q(this.c);
                return;
            case "action.rewardedvideo.skip":
                this.b.p(this.c);
                return;
            case "action.rewardedvideo.Close":
                this.b.o(this.c);
                break;
            default:
                return;
        }
        b(this);
        this.c = null;
    }
}
