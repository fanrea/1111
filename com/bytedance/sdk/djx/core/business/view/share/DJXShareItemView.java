package com.bytedance.sdk.djx.core.business.view.share;

import android.view.View;
import com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import com.bytedance.sdk.djx.core.business.view.share.DJXShareAdapter;
import com.bytedance.sdk.djx.core.business.view.share.DJXShareConfig;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXShareItemView extends IMultiItemView {
    private DJXShareAdapter.OnShareClickListener mOnShareClickListener;

    public void setOnShareClickListener(DJXShareAdapter.OnShareClickListener onShareClickListener) {
        this.mOnShareClickListener = onShareClickListener;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public Object getItemViewLayoutId() {
        return Integer.valueOf(R.layout.djx_item_share_dialog);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public boolean isForViewType(Object obj, int i) {
        return obj instanceof String;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i) {
        final String str = (String) obj;
        baseViewHolder.setBackgroundRes(R.id.djx_iv_icon, getImageSource(str));
        baseViewHolder.setText(R.id.djx_tv_title, getText(str));
        baseViewHolder.setOnClickListener(R.id.djx_ll_channel, new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.share.DJXShareItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXShareItemView.this.mOnShareClickListener != null) {
                    DJXShareItemView.this.mOnShareClickListener.onShareClick(str);
                }
            }
        });
    }

    public int getImageSource(String str) {
        str.hashCode();
        if (str.equals("report")) {
            return R.drawable.djx_share_report;
        }
        if (str.equals(DJXShareConfig.CHANNEL_NAME.PRIVACY_SETTING)) {
            return R.drawable.djx_share_privacy_setting;
        }
        return -1;
    }

    public int getText(String str) {
        str.hashCode();
        if (str.equals("report")) {
            return R.string.djx_str_report;
        }
        if (str.equals(DJXShareConfig.CHANNEL_NAME.PRIVACY_SETTING)) {
            return R.string.djx_str_privacy_setting;
        }
        return -1;
    }
}
