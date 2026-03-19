package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.cy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class CPUNovelAd {
    private cy mCpuNovelProd;

    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        cy cyVar = new cy(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = cyVar;
        cyVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public View getNovelView() {
        return this.mCpuNovelProd.w();
    }

    public void destory() {
        cy cyVar = this.mCpuNovelProd;
        if (cyVar != null) {
            cyVar.y();
        }
    }
}
