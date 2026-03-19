package com.bytedance.sdk.djx.core.business.bureport;

import android.view.View;
import android.widget.RadioButton;
import com.bytedance.sdk.djx.core.business.bureport.ReportAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import com.bytedance.sdk.djx.model.ReportModel;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ReportItemView extends IMultiItemView {
    private ReportAdapter.ReportItemListener mReportItemListener;
    private int mSelectedPos = -1;

    ReportItemView() {
    }

    public void setReportItemListener(ReportAdapter.ReportItemListener reportItemListener) {
        this.mReportItemListener = reportItemListener;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public Object getItemViewLayoutId() {
        return Integer.valueOf(R.layout.djx_item_report_list);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public boolean isForViewType(Object obj, int i) {
        return obj instanceof ReportModel;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public void bindViewHolder(final BaseViewHolder baseViewHolder, Object obj, final int i) {
        if (baseViewHolder == null || !(obj instanceof ReportModel)) {
            return;
        }
        final ReportModel reportModel = (ReportModel) obj;
        baseViewHolder.setText(R.id.djx_item_radio_btn, reportModel.getReportDesc());
        baseViewHolder.setOnClickListener(R.id.djx_item_radio_btn, new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.bureport.ReportItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReportItemView.this.mReportItemListener.onItemClick(i, reportModel, ReportItemView.this.mSelectedPos);
                ReportItemView.this.mSelectedPos = i;
                ((RadioButton) baseViewHolder.getView(R.id.djx_item_radio_btn)).setChecked(true);
            }
        });
    }
}
