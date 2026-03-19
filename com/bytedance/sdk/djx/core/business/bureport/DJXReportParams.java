package com.bytedance.sdk.djx.core.business.bureport;

import com.bytedance.sdk.djx.core.business.base.FragProxy;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.Feed;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXReportParams {
    public static final String DRAW_REPORT_SOURCE = "2208";
    public IDJXReportCallback mListener;
    public float mReportTopPadding;
    public String mCategory = "";
    public DramaDetail mDramaDetail = null;
    public Feed mFeed = null;
    public int mPosition = 0;
    public String mSource = null;

    public interface IDJXReportCallback {
        void onClose(FragProxy fragProxy);

        void onDJXReportResult(boolean z, Map<String, Object> map);

        void onOpen(FragProxy fragProxy);
    }

    public static DJXReportParams obtain() {
        return new DJXReportParams();
    }

    public static DJXReportParams obtain(DJXReportParams dJXReportParams) {
        return obtain().reportTopPadding(dJXReportParams.mReportTopPadding).reportListener(dJXReportParams.mListener).source(dJXReportParams.mSource).category(dJXReportParams.mCategory).dramaDetail(dJXReportParams.mDramaDetail).position(dJXReportParams.mPosition);
    }

    public DJXReportParams reportTopPadding(float f) {
        this.mReportTopPadding = f;
        return this;
    }

    public DJXReportParams reportListener(IDJXReportCallback iDJXReportCallback) {
        this.mListener = iDJXReportCallback;
        return this;
    }

    public DJXReportParams category(String str) {
        this.mCategory = str;
        return this;
    }

    public DJXReportParams dramaDetail(DramaDetail dramaDetail) {
        this.mDramaDetail = dramaDetail;
        return this;
    }

    public DJXReportParams feed(Feed feed) {
        this.mFeed = feed;
        return this;
    }

    public DJXReportParams position(int i) {
        this.mPosition = i;
        return this;
    }

    public DJXReportParams source(String str) {
        this.mSource = str;
        return this;
    }
}
