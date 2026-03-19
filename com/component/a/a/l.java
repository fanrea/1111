package com.component.a.a;

import android.os.Message;
import com.component.a.a.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements Runnable {
    final /* synthetic */ f.b a;
    final /* synthetic */ f b;

    l(f fVar, f.b bVar) {
        this.b = fVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.t.removeCallbacksAndMessages(null);
            if (this.b.q <= 0) {
                if (this.a.b != this.b.c()) {
                    this.b.a(this.a.b);
                }
                this.b.G();
                this.b.m = 1;
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.obj = this.a.b;
            this.b.t.sendMessageDelayed(message, this.b.q);
        } catch (Throwable th) {
            com.component.lottie.g.c.c("Error playing...", th);
        }
    }
}
