package com.baidu.mobads.container.components.a;

import android.content.Context;
import android.os.Handler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    com.baidu.mobads.container.components.command.j a;
    Handler b;
    long c;
    public long d = 0;
    public boolean e = false;
    public Context f;
    private com.baidu.mobads.container.components.b.e g;

    public void a(Context context, com.baidu.mobads.container.components.command.j jVar) {
        try {
            this.f = context;
            this.a = jVar;
            this.c = System.currentTimeMillis();
            this.g = new f(this);
            com.baidu.mobads.container.components.b.c.a().a(context, this.g);
            com.baidu.mobads.container.util.h.a(new g(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f != null && this.g != null) {
            com.baidu.mobads.container.components.b.c.a().b(this.f, this.g);
        }
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
        }
        this.a = null;
        this.f = null;
    }
}
