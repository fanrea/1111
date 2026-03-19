package com.qq.e.comm.plugin;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import com.qq.e.comm.plugin.on;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dt extends o0 {
    private b d;
    private boolean e = false;
    private Intent f;
    private ResolveInfo g;

    static /* synthetic */ b a(dt dtVar) {
        return (b) pro.getobjresult(289, 1, dtVar);
    }

    private void f() {
        pro.getVresult(290, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0, com.qq.e.comm.plugin.rs
    public /* bridge */ /* synthetic */ void b(boolean z) {
        pro.getVresult(291, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean b() {
        return pro.getZresult(292, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean c() {
        return pro.getZresult(293, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean d() {
        return pro.getZresult(294, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0, com.qq.e.comm.plugin.rs
    public /* bridge */ /* synthetic */ void onCancel() {
        pro.getVresult(295, 0, this);
    }

    /* compiled from: A */
    class a extends on.b {
        a(int i, f5 f5Var) {
            super(i, f5Var);
        }

        @Override // com.qq.e.comm.plugin.on.b, com.qq.e.comm.plugin.on.c, com.qq.e.comm.plugin.s3.g
        public boolean h() throws JSONException {
            dt.a(dt.this).a(SystemClock.elapsedRealtime() - this.d);
            b10.a(4008011, dt.a(dt.this));
            return super.h();
        }
    }

    /* compiled from: A */
    private static class b extends f5 {
        b(f5 f5Var) throws JSONException {
            super(f5Var);
            a("deeplink_scene", (Object) 1);
        }

        public void a(long j) throws JSONException {
            a("cost_time", Long.valueOf(j));
        }
    }
}
