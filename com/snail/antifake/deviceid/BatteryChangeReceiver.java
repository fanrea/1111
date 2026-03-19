package com.snail.antifake.deviceid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BatteryChangeReceiver extends BroadcastReceiver {
    private int mCurrentLevel;
    private boolean mIsCharging;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("status", 0);
        this.mCurrentLevel = intent.getIntExtra("level", 0);
        if (intExtra != 1 && intExtra != 2) {
            if (intExtra == 3 || intExtra == 4) {
                this.mIsCharging = false;
                return;
            } else if (intExtra != 5) {
                return;
            }
        }
        this.mIsCharging = true;
    }

    public boolean isCharging() {
        return this.mIsCharging;
    }

    public int getCurrentLevel() {
        return this.mCurrentLevel;
    }
}
