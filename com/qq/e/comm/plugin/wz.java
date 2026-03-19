package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.q6;
import com.qq.e.comm.plugin.sl;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class wz extends FrameLayout implements sl {
    private b00 a;
    private final xz b;
    private final q6.b c;
    private final sl.a d;
    private final View.OnClickListener e;

    @Override // com.qq.e.comm.plugin.sl
    public View a() {
        return this;
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (wz.this.d != null) {
                wz.this.d.b(view.getId());
            }
        }
    }

    public wz(xz xzVar, sl.a aVar) {
        super(xzVar.a);
        this.e = new a();
        this.b = xzVar;
        this.c = q6.a(q6.c.SPLASH, xzVar.b());
        this.d = aVar;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.wz.b():void");
    }

    @Override // com.qq.e.comm.plugin.sl
    public void a(long j) {
        this.a.a(j);
    }

    private void a(mu muVar, boolean z, ka kaVar, boolean z2) {
        if (muVar == null || TextUtils.isEmpty(muVar.a1())) {
            return;
        }
        if ((z && kaVar.a()) || this.b.g()) {
            return;
        }
        j00.a(this, muVar.a1(), this.e, z2);
    }
}
