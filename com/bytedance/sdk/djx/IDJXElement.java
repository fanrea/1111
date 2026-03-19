package com.bytedance.sdk.djx;

import android.view.View;
import com.bytedance.sdk.djx.model.DJXDrama;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXElement {
    void destroy();

    DJXDrama getDrama();

    long getGid();

    String getTitle();

    View getView();

    Boolean isPlaying();

    void pause();

    void refresh();

    void reportShow(long j);

    void setMute(boolean z);

    void start();

    void stop();
}
