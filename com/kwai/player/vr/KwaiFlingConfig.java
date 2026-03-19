package com.kwai.player.vr;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiFlingConfig {
    private TimeInterpolator mInterpolator = new DecelerateInterpolator();
    private long mDuring = 400;
    private float mSensitivity = 1.0f;

    public KwaiFlingConfig setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public KwaiFlingConfig setDuring(long j) {
        this.mDuring = j;
        return this;
    }

    public KwaiFlingConfig setSensitivity(float f) {
        this.mSensitivity = f;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public long getDuring() {
        return this.mDuring;
    }

    public float getSensitivity() {
        return this.mSensitivity;
    }
}
