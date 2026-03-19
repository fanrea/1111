package com.bytedance.sdk.djx.core.vod;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.djx.core.vod.player.AbstractPlayer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IVideoRender {
    void attachPlayer(AbstractPlayer abstractPlayer);

    Bitmap doScreenShot();

    View getView();

    void release();

    void setScaleType(int i);

    void setVideoRotation(int i);

    void setVideoSize(int i, int i2);
}
