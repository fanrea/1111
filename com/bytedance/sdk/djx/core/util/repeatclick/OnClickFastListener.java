package com.bytedance.sdk.djx.core.util.repeatclick;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class OnClickFastListener extends BaseClickListener {
    private static long lastClickTime;
    private long DELAY_TIME = 900;

    public abstract void onFastClick(View view);

    private boolean isFastDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - lastClickTime;
        if (0 < j && j < this.DELAY_TIME) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.util.repeatclick.BaseClickListener, android.view.View.OnClickListener
    public void onClick(View view) {
        if (isFastDoubleClick()) {
            return;
        }
        onFastClick(view);
    }

    public OnClickFastListener setLastClickTime(long j) {
        this.DELAY_TIME = j;
        return this;
    }
}
