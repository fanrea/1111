package com.baidu.mobads.container.landingpage;

import android.media.MediaPlayer;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.x.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ai implements h.a {
    final /* synthetic */ af a;

    ai(af afVar) {
        this.a = afVar;
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void a() {
        if (this.a.c != null && this.a.l != -1) {
            this.a.c.a(this.a.l);
            this.a.l = -1;
            if (this.a.m != null) {
                com.baidu.mobads.container.nativecpu.a.c.a().a(this.a.b, this.a.m);
            }
        }
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void b(int i) {
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void a(MediaPlayer mediaPlayer, int i, int i2) {
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void a(MediaPlayer mediaPlayer) {
        if (this.a.f != null) {
            this.a.f.setVisibility(0);
        }
        if (this.a.f != null && this.a.f.getParent() == null) {
            this.a.c.addView(this.a.f, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (mediaPlayer != null) {
            mediaPlayer.getDuration();
        }
        if (this.a.n != null) {
            com.baidu.mobads.container.nativecpu.a.c.a().a(this.a.b, this.a.n);
        }
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void a(int i) {
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void b() {
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void c() {
        if (this.a.h != null) {
            this.a.h.a();
        }
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void d() {
        if (this.a.n != null) {
            com.baidu.mobads.container.nativecpu.a.c.a().a(this.a.b, this.a.n);
        }
    }

    @Override // com.baidu.mobads.container.x.h.a
    public void e() {
    }
}
