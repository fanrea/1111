package com.kwai.video.ksliveplayer;

import com.kwai.video.ksliveplayer.impl.KSLiveManifestImpl;
import com.kwai.video.ksliveplayer.model.LiveAdaptionModel;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class UseLastQualityTypeHelper {
    private static boolean sEnableRecord = false;
    private static boolean sHasSelectSwitch = false;
    private static String sLastQualityType;

    public static int getCurrentIndex(KSLiveManifestImpl kSLiveManifestImpl, int i) {
        if (LiveAdaptionModel.QUALITY_AUTO.equals(sLastQualityType)) {
            return -1;
        }
        List<KSLiveAdaptationCell> liveAdaptationCells = kSLiveManifestImpl.getLiveAdaptationCells();
        if (liveAdaptationCells == null) {
            return i;
        }
        for (int i2 = 0; i2 < liveAdaptationCells.size(); i2++) {
            if (liveAdaptationCells.get(i2).getQualityType().equals(sLastQualityType)) {
                return i2;
            }
        }
        return i;
    }

    public static boolean needUseLastSelectQualityType() {
        return sEnableRecord && sHasSelectSwitch;
    }

    public static void enable(boolean z) {
        sEnableRecord = z;
    }

    public static void recordIfNeed(KSLiveManifestImpl kSLiveManifestImpl, int i) {
        if (!sEnableRecord || kSLiveManifestImpl == null) {
            return;
        }
        sHasSelectSwitch = true;
        if (i == -1) {
            sLastQualityType = LiveAdaptionModel.QUALITY_AUTO;
            return;
        }
        List<KSLiveAdaptationCell> liveAdaptationCells = kSLiveManifestImpl.getLiveAdaptationCells();
        if (liveAdaptationCells == null || liveAdaptationCells.size() <= i) {
            return;
        }
        sLastQualityType = liveAdaptationCells.get(i).getQualityType();
    }
}
