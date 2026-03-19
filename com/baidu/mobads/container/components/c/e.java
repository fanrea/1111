package com.baidu.mobads.container.components.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends f {
    public static final String b = "network_changed";
    private static final String c = "BasicNetworkController";
    private int d;
    private d e;
    private IntentFilter f;

    public e(Context context) {
        super(context);
    }

    @Override // com.baidu.mobads.container.components.c.f
    public void a(BroadcastReceiver broadcastReceiver) {
        this.e = (d) broadcastReceiver;
    }

    @Override // com.baidu.mobads.container.components.c.c
    public void b() {
        if (this.d == 0) {
            if (this.e == null) {
                a(new d(this));
            }
            this.f = new IntentFilter();
            this.f.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        this.d++;
        new com.component.c.b(this.a).a(this.e, this.f);
    }

    public void d() {
        dispatchEvent(new cm(b));
    }

    @Override // com.baidu.mobads.container.components.c.c
    public void c() {
        this.d = 0;
        try {
            new com.component.c.b(this.a).a(this.e);
        } catch (Exception e) {
        }
    }
}
