package com.bytedance.sdk.djx.core.business.view.share;

import android.content.Context;
import com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXShareAdapter extends MultiItemTypeAdapter {
    private DJXShareItemView mDJXShareItemView;

    public interface OnShareClickListener {
        void onShareClick(String str);
    }

    public DJXShareAdapter(Context context, OnShareClickListener onShareClickListener) {
        super(context);
        DJXShareItemView dJXShareItemView = this.mDJXShareItemView;
        if (dJXShareItemView != null) {
            dJXShareItemView.setOnShareClickListener(onShareClickListener);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter
    protected List<IMultiItemView> buildMultiItemViews() {
        ArrayList arrayList = new ArrayList();
        if (this.mDJXShareItemView == null) {
            this.mDJXShareItemView = new DJXShareItemView();
        }
        arrayList.add(this.mDJXShareItemView);
        return arrayList;
    }
}
