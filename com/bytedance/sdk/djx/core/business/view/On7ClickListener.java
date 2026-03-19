package com.bytedance.sdk.djx.core.business.view;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.sdk.djx.utils.LG;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class On7ClickListener implements View.OnClickListener {
    private static final long DEFAULT_DURATION = 3000;
    private static final int DEFAULT_MAX_COUNT = 7;
    private static final String TAG = "On7ClickListener";
    private long[] mHitRecord;

    protected long getDuration() {
        return 3000L;
    }

    protected int getMaxCount() {
        return 7;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        System.arraycopy(getHitRecord(), 1, getHitRecord(), 0, getHitRecord().length - 1);
        getHitRecord()[getHitRecord().length - 1] = SystemClock.uptimeMillis();
        if (getHitRecord()[0] >= SystemClock.uptimeMillis() - getDuration()) {
            try {
                Arrays.fill(getHitRecord(), 0L);
            } catch (Throwable unused) {
            }
            onSevenClick();
        }
    }

    protected void onSevenClick() {
        LG.d(TAG, "on seven click");
    }

    private long[] getHitRecord() {
        if (this.mHitRecord == null) {
            this.mHitRecord = new long[getMaxCount()];
        }
        return this.mHitRecord;
    }
}
