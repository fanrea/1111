package com.kwai.video.ksvodplayerkit.MultiRate;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HlsAdaptationModel {
    public HlsAdaptationSet adaptationSet;
    public transient String host;
    public String version = "1.0";
    public String type = LiveConfigKey.HLS;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class HlsAdaptationSet {
        public List<HlsRepresentation> representation;
    }
}
