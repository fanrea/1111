package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.dysi.IGDTAudioPlayer;
import com.qq.e.comm.plugin.nf;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mg implements IGDTAudioPlayer, nf.i {
    private final f9 a;
    private final h4 b;
    private final f5 c;
    private nf d;
    private final com.qq.e.comm.dynamic.b e;
    private String f;
    private final boolean g;
    private String h;

    @Override // com.qq.e.comm.plugin.nf.i
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.nf.i
    public void a(Throwable th) {
    }

    @Override // com.qq.e.comm.plugin.nf.i
    public void b() {
    }

    @Override // com.qq.e.comm.plugin.nf.i
    public void c() {
    }

    @Override // com.qq.e.comm.plugin.nf.i
    public void d() {
    }

    @Override // com.qq.e.comm.plugin.nf.i
    public void f() {
    }

    public mg(f9 f9Var, h4 h4Var, yq yqVar, com.qq.e.comm.dynamic.b bVar) {
        this.a = f9Var;
        this.b = h4Var;
        this.c = f5.a(h4Var, yqVar);
        this.e = bVar;
        this.g = xc.a("apsa", h4Var.y0(), 0, h4Var.x0()) == 0;
    }

    private void g() {
        if (this.d == null && this.g) {
            nf nfVar = new nf(this.a.e().d());
            this.d = nfVar;
            nfVar.a(this);
        }
    }

    private boolean h() {
        return this.g && this.d != null;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void prepareAudioPlayer(String str, String str2) {
        g();
        if (h()) {
            this.f = str2;
            this.d.b(str);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void prepare(String str) {
        g();
        if (h()) {
            this.h = str;
            this.d.b(str);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void play() {
        g();
        if (h()) {
            this.d.j();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void pause() {
        if (h()) {
            this.d.r();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void stop() {
        if (h()) {
            this.d.r();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public int currentTime() {
        if (h()) {
            return this.d.f();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public int duration() {
        if (h()) {
            return this.d.g();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public int isPlaying() {
        return (h() && this.d.e() == 3) ? 1 : 0;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void setVolume(double d) {
        g();
        if (h()) {
            if (d > 0.0d) {
                this.d.p();
            } else {
                this.d.n();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void setNumberOfLoops(int i) {
        g();
        if (h()) {
            this.d.a(i);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void free() {
        if (h()) {
            this.d.c();
            this.d = null;
        }
    }

    @Override // com.qq.e.comm.plugin.nf.i
    public void e() throws JSONException {
        if (!TextUtils.isEmpty(this.f)) {
            a(this.f);
        } else {
            in.b().a("event_onAudioPrepared", this.h).c().a(this.e, this.c);
        }
    }

    private void a(String str) throws JSONException {
        com.qq.e.comm.dynamic.b bVar = this.e;
        if (bVar != null) {
            try {
                bVar.b(str);
            } catch (Throwable th) {
                ey.a(str, this.c, th);
            }
        }
    }
}
