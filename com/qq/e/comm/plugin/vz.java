package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.rl;
import com.qq.e.comm.plugin.sl;
import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vz implements rl, View.OnClickListener, sl.a {
    private final xz a;
    private final rl.a b;
    private final rl.b c;
    private mh d;
    private sl e;

    @Override // com.qq.e.comm.plugin.rl
    public boolean c() {
        return false;
    }

    public vz(xz xzVar, rl.b bVar) {
        this.a = xzVar;
        this.c = bVar;
        rl.a aVar = new rl.a(xzVar);
        this.b = aVar;
        mu muVarB = xzVar.b();
        if (muVarB.v0() <= muVarB.w0()) {
            aVar.setBackgroundColor(-16777216);
        }
    }

    @Override // com.qq.e.comm.plugin.rl
    public void e() {
        wz wzVar = new wz(this.a, this);
        this.b.addView(wzVar.a(), rl.k);
        this.e = wzVar;
    }

    @Override // com.qq.e.comm.plugin.rl
    public void g() {
        sl slVar = this.e;
        if (slVar != null) {
            this.b.removeView(slVar.a());
        }
    }

    @Override // com.qq.e.comm.plugin.rl
    public void f() {
        this.b.removeAllViews();
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(boolean z) {
        b(z);
        this.b.a();
    }

    private void b(boolean z) {
        mh mhVar = this.d;
        if (mhVar != null) {
            if (!z) {
                mhVar.pause();
                this.d.a((yg) null);
                this.d.free();
            }
            this.d = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.c.a(view.getId(), 0);
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void d() {
        this.c.d();
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void k() {
        this.c.k();
    }

    @Override // com.qq.e.comm.plugin.rl
    public ViewGroup a() {
        return this.b;
    }

    @Override // com.qq.e.comm.plugin.rl
    public mh b() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(long j) {
        sl slVar = this.e;
        if (slVar != null) {
            slVar.a(j);
        }
    }

    @Override // com.qq.e.comm.plugin.sl.a
    public void b(int i) {
        this.c.a(i, 0);
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(File file) throws IOException {
        if (file == null || !file.exists()) {
            return;
        }
        if (this.b.getChildCount() > 0) {
            this.b.removeAllViews();
        }
        b(false);
        sz szVar = new sz(this.b.getContext());
        szVar.a(file);
        this.b.addView(szVar, rl.k);
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(String str, yg ygVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mu muVarB = this.a.b();
        mh mhVar = new mh(this.b.getContext().getApplicationContext(), e2.SPLASH);
        mhVar.a();
        mhVar.r().setId(5);
        this.b.addView(mhVar.r(), rl.k);
        mhVar.a(muVarB);
        mhVar.a(ygVar);
        mhVar.setDataSource(str);
        mhVar.play();
        if (muVarB.X0() > muVarB.b1()) {
            mhVar.a(dy.CENTER_CROP);
        }
        mhVar.a(new bh(muVarB, false));
        this.d = mhVar;
        this.b.b = mhVar;
    }
}
