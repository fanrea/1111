package com.kwai.video.ksvodplayerkit.MultiRate;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiMediaManifest implements Serializable {
    private static final long serialVersionUID = -3979385928656523160L;
    public List<KwaiAdaptationSet> adaptationSet;
    public boolean mAutoDefaultSelect;
    public int mBusinessType;
    public boolean mHideAuto;
    public int mMediaType;
    public int mStereoType;
    public String mVersion;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ManifestBusinessType {
        public static final int TYPE_LONG_VIDEO = 1;
        public static final int TYPE_SHORT_VIDEO = 2;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ManifestMediaType {
        public static final int TYPE_HLS = 1;
        public static final int TYPE_MP4 = 2;
    }
}
