package com.qq.e.comm.plugin;

import com.qq.e.comm.pi.AdData;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class h40 implements AdData.VideoPlayer {
    private WeakReference<mh> a;

    public h40(mh mhVar) {
        this.a = new WeakReference<>(mhVar);
    }

    @Override // com.qq.e.comm.pi.AdData.VideoPlayer
    public int getVideoState() {
        j40 videoState;
        mh mhVar = this.a.get();
        if (mhVar == null) {
            videoState = j40.ERROR;
        } else {
            videoState = mhVar.getVideoState();
        }
        return videoState.ordinal();
    }

    @Override // com.qq.e.comm.pi.AdData.VideoPlayer
    public int getDuration() {
        mh mhVar = this.a.get();
        if (mhVar != null) {
            return mhVar.getDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.AdData.VideoPlayer
    public int getCurrentPosition() {
        mh mhVar = this.a.get();
        if (mhVar != null) {
            return mhVar.getCurrentPosition();
        }
        return 0;
    }
}
