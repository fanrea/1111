package com.sigmob.sdk.nativead;

import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class s implements r {
    private final WeakReference<com.sigmob.sdk.videoplayer.f> a;
    private j b;

    public s(com.sigmob.sdk.videoplayer.f adView) {
        this.a = new WeakReference<>(adView);
    }

    private com.sigmob.sdk.videoplayer.f k() {
        return this.a.get();
    }

    @Override // com.sigmob.sdk.nativead.r
    public void a() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return;
        }
        fVarK.D();
    }

    public void a(int resId) {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return;
        }
        fVarK.setHolderImageResource(resId);
    }

    @Override // com.sigmob.sdk.nativead.r
    public void a(j adVideoStatusListener) {
        this.b = adVideoStatusListener;
    }

    @Override // com.sigmob.sdk.nativead.r
    public void a(boolean isMute) {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return;
        }
        fVarK.setSoundChange(isMute);
    }

    @Override // com.sigmob.sdk.nativead.r
    public void b() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return;
        }
        fVarK.C();
    }

    @Override // com.sigmob.sdk.nativead.r
    public void c() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return;
        }
        fVarK.C();
    }

    @Override // com.sigmob.sdk.nativead.r
    public void d() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return;
        }
        fVarK.E();
    }

    @Override // com.sigmob.sdk.nativead.r
    public int e() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null || fVarK.getDuration() == 0) {
            return 0;
        }
        return (int) (fVarK.getDuration() / 1000);
    }

    @Override // com.sigmob.sdk.nativead.r
    public int f() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null || fVarK.getCurrentPositionWhenPlaying() == 0) {
            return 0;
        }
        return (int) ((fVarK.getCurrentPositionWhenPlaying() * 100) / fVarK.getDuration());
    }

    @Override // com.sigmob.sdk.nativead.r
    public j g() {
        return this.b;
    }

    @Override // com.sigmob.sdk.nativead.r
    public void h() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return;
        }
        fVarK.d();
    }

    @Override // com.sigmob.sdk.nativead.r
    public void i() {
        com.sigmob.sdk.videoplayer.f fVar = this.a.get();
        if (fVar != null) {
            fVar.a();
        }
        this.a.clear();
        this.b = null;
    }

    @Override // com.sigmob.sdk.nativead.r
    public int j() {
        com.sigmob.sdk.videoplayer.f fVarK = k();
        if (fVarK == null) {
            return 0;
        }
        return (int) (fVarK.getCurrentPositionWhenPlaying() / 1000);
    }
}
