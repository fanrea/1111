package com.bytedance.sdk.djx.core.util;

import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.SPUtils;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class GuideHelper {
    private static final String KEY_HAD_WATCHED_VIDEO_SET = "hadWatchedVideoSet";
    private static final String KEY_HAS_DRAW_VIDEO = "has_draw_video";
    private static volatile GuideHelper sInstance;
    private boolean mHasDrawShowed;
    private final SPUtils mSPUtils;

    public static GuideHelper getInstance() {
        if (sInstance == null) {
            synchronized (GuideHelper.class) {
                if (sInstance == null) {
                    sInstance = new GuideHelper();
                }
            }
        }
        return sInstance;
    }

    private GuideHelper() {
        SPUtils sPUtilsGuide = SP.guide();
        this.mSPUtils = sPUtilsGuide;
        this.mHasDrawShowed = sPUtilsGuide.getBoolean(KEY_HAS_DRAW_VIDEO, false);
    }

    public boolean hasDrawShowedAndSet() {
        boolean z = this.mHasDrawShowed;
        if (!z) {
            this.mHasDrawShowed = true;
            this.mSPUtils.put(KEY_HAS_DRAW_VIDEO, true);
        }
        return z;
    }

    public void setHadWatchedVideoSet(Set<String> set) {
        this.mSPUtils.put(KEY_HAD_WATCHED_VIDEO_SET, set);
    }

    public Set<String> getHadWatchedVideoSet() {
        return this.mSPUtils.getStringSet(KEY_HAD_WATCHED_VIDEO_SET, (Set) null);
    }
}
