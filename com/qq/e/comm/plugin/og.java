package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.dysi.IGDTVideoPlayer;
import com.qq.e.comm.plugin.hg;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class og implements IGDTVideoPlayer {
    private final com.qq.e.comm.dynamic.b a;
    private mh b;
    private final f5 c;

    og(f9 f9Var, com.qq.e.comm.dynamic.b bVar, h4 h4Var, yq yqVar) throws JSONException {
        this.a = bVar;
        this.c = f5.a(h4Var, yqVar);
        a(f9Var);
    }

    /* compiled from: A */
    class a implements hg.d {
        a() {
        }

        @Override // com.qq.e.comm.plugin.hg.d
        public void a(mh mhVar) throws JSONException {
            og.this.b = mhVar;
            og.this.a();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void play() {
        mh mhVar = this.b;
        if (mhVar != null) {
            mhVar.l();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void pause() {
        mh mhVar = this.b;
        if (mhVar != null) {
            mhVar.k();
        }
    }

    private void a(f9 f9Var) throws JSONException {
        mh mhVarJ = f9Var.j();
        this.b = mhVarJ;
        if (mhVarJ != null) {
            a();
        } else if (f9Var.f() != null) {
            f9Var.f().a(new a());
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void stop() {
        mh mhVar = this.b;
        if (mhVar != null) {
            mhVar.m();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public int currentTime() {
        mh mhVar = this.b;
        if (mhVar == null) {
            return 0;
        }
        return mhVar.getCurrentPosition();
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public int duration() {
        mh mhVar = this.b;
        if (mhVar == null) {
            return 0;
        }
        return mhVar.getDuration();
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void pauseAndLock() {
        mh mhVar = this.b;
        if (mhVar != null) {
            mhVar.y();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void unlockAndPlay() {
        mh mhVar = this.b;
        if (mhVar != null) {
            mhVar.L();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void speed(double d) {
        mh mhVar = this.b;
        if (mhVar != null) {
            mhVar.setSpeed((float) d);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public boolean isPlaying() {
        mh mhVar = this.b;
        if (mhVar != null) {
            return mhVar.isPlaying();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() throws JSONException {
        if (this.b == null) {
            return;
        }
        in.b().a(IGDTVideoPlayer.EVENT_ON_VIDEO_VIEW_INIT, new Object[0]).c().a(this.a, this.c);
    }
}
