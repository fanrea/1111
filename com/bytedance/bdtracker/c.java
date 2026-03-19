package com.bytedance.bdtracker;

import com.bytedance.bdtracker.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c implements b.d {

    public class a implements Runnable {
        public final /* synthetic */ d a;

        public a(c cVar, d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            q1 q1Var = dVar.b("getConfig") ? null : dVar.q.e;
            if (q1Var != null) {
                if (q1Var.r || q1Var.f.getBoolean("enter_background_not_send", false)) {
                    return;
                }
                this.a.flush();
            }
        }
    }

    @Override // com.bytedance.bdtracker.b.d
    public void a(d dVar) {
        x.a.execute(new a(this, dVar));
    }
}
