package com.kwai.video.ksliveplayer;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface KSLiveManifest {
    List<KSLiveAdaptationCell> getLiveAdaptationCells();

    String getManifestType();

    String getManifestVersion();

    boolean isCdnFreeTraffic();

    boolean isHideAuto();
}
