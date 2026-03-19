package com.qq.e.ads.immersive;

import com.qq.e.comm.util.AdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface ImmersiveADFlowListener {
    void onADClick(String str);

    void onADExpose(String str);

    void onADLoaded();

    void onADPageDestroy();

    void onADPageShow();

    void onNoAD(AdError adError);
}
