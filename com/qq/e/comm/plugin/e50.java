package com.qq.e.comm.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e50 extends BroadcastReceiver {
    private a a;
    private boolean b;

    /* compiled from: A */
    public interface a {
        void a(float f);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 3) == 3) {
            this.a.a(((AudioManager) context.getSystemService("audio")).getStreamVolume(3));
        }
    }

    public e50(a aVar) {
        this.a = aVar;
    }

    public void a(Context context) {
        try {
            if (this.b) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            context.getApplicationContext().registerReceiver(this, intentFilter);
            this.b = true;
        } catch (Exception unused) {
        }
    }

    public void b(Context context) {
        if (this.b) {
            try {
                context.getApplicationContext().unregisterReceiver(this);
                this.b = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
