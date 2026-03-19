package com.bytedance.sdk.djx.core.business.bureport;

import android.content.Context;
import com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import com.bytedance.sdk.djx.model.ReportModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ReportAdapter extends MultiItemTypeAdapter {
    private ReportItemView mReportItemView;

    public interface ReportItemListener {
        void onItemClick(int i, ReportModel reportModel, int i2);
    }

    public ReportAdapter(Context context, List<Object> list, ReportItemListener reportItemListener) {
        super(context);
        addAll(list);
        ReportItemView reportItemView = this.mReportItemView;
        if (reportItemView != null) {
            reportItemView.setReportItemListener(reportItemListener);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter
    protected List<IMultiItemView> buildMultiItemViews() {
        ArrayList arrayList = new ArrayList();
        ReportItemView reportItemView = new ReportItemView();
        this.mReportItemView = reportItemView;
        arrayList.add(reportItemView);
        return arrayList;
    }
}
