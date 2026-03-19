package com.baidu.mobads.container.e;

import android.text.TextUtils;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ar implements Runnable {
    final /* synthetic */ l a;

    ar(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup.LayoutParams layoutParams;
        try {
            if (this.a.aX != null && this.a.aX.getLayout() != null && this.a.aX.getLayout().getEllipsisCount(0) > 0 && (layoutParams = this.a.aX.getLayoutParams()) != null) {
                layoutParams.width = -1;
                this.a.aX.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                this.a.aX.setSingleLine();
                this.a.aX.setMarqueeRepeatLimit(-1);
                this.a.aX.setSelected(true);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
