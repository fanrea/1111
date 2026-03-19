package com.qq.e.comm.plugin;

import android.graphics.Matrix;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface jj {
    void free();

    int getCurrentPosition();

    int getDuration();

    int getPlayerVersion();

    boolean isPlaying();

    void pause();

    void play();

    void seekTo(int i);

    void setDataSource(String str);

    void setSpeed(float f);

    void setTransform(Matrix matrix);
}
