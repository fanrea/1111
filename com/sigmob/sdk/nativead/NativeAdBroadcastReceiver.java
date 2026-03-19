package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.nativead.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeAdBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter a;
    private e.a b;

    public NativeAdBroadcastReceiver(e.a nativeAdInterstitialListener, String broadcastIdentifier) {
        super(broadcastIdentifier);
        this.b = nativeAdInterstitialListener;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (a == null) {
            IntentFilter intentFilter = new IntentFilter();
            a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW);
            a.addAction(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
            a.addAction(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
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
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.b != null && a(intent)) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            action.hashCode();
            switch (action) {
                case "action.native.temple.dismiss":
                    this.b.e();
                    break;
                case "action.native.temple.click":
                    this.b.d();
                    break;
                case "action.native.temple.show":
                    this.b.c();
                    break;
                case "action.loadpage.show":
                    this.b.a();
                    break;
                case "action.loadpage.dismiss":
                    this.b.b();
                    break;
            }
        }
    }
}
