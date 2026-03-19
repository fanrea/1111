package com.bytedance.sdk.djx.core.business.view.rv.base;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class IMultiItemView {
    public abstract void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i);

    public abstract Object getItemViewLayoutId();

    public abstract boolean isForViewType(Object obj, int i);

    public void onItemClick(BaseViewHolder baseViewHolder, Object obj, int i) {
    }

    public boolean onItemLongClick(BaseViewHolder baseViewHolder, Object obj, int i) {
        return false;
    }

    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i, List<Object> list) {
        if (list.isEmpty()) {
            bindViewHolder(baseViewHolder, obj, i);
        }
    }
}
