package com.bytedance.sdk.djx.core.business.budrama.home;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.FeedAdModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaGridAdapter extends MultiItemTypeAdapter {
    private DJXHomeAdItemView mDJXHomeAdItemView;
    private DramaItemView mDramaItemView;

    public interface DJXHomeAdItemListener {
        void onItemClose(View view, int i, Feed feed);
    }

    public DramaGridAdapter(Context context, RecyclerView recyclerView, AdKey adKey) {
        this.mContext = context;
        addItemViews(buildMultiItemViews());
        this.mDramaItemView.setContainer(recyclerView);
        this.mDJXHomeAdItemView.setContainer(recyclerView);
        this.mDJXHomeAdItemView.setListener(new DJXHomeAdItemListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DramaGridAdapter.1
            @Override // com.bytedance.sdk.djx.core.business.budrama.home.DramaGridAdapter.DJXHomeAdItemListener
            public void onItemClose(View view, int i, Feed feed) {
                DramaGridAdapter.this.remove(i);
            }
        });
        setParams(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.adapter.MultiItemTypeAdapter
    protected List<IMultiItemView> buildMultiItemViews() {
        ArrayList arrayList = new ArrayList();
        this.mDramaItemView = new DramaItemView();
        this.mDJXHomeAdItemView = new DJXHomeAdItemView();
        arrayList.add(this.mDramaItemView);
        arrayList.add(this.mDJXHomeAdItemView);
        return arrayList;
    }

    public void resetAd() {
        List<Object> dataList = getDataList();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) instanceof FeedAdModel) {
                notifyItemChanged(i, "update by BEAdCome");
            }
        }
    }

    public void removeAd() {
        List<Object> dataList = getDataList();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) instanceof FeedAdModel) {
                remove(i);
            }
        }
    }

    public void setParams(AdKey adKey) {
        DJXHomeAdItemView dJXHomeAdItemView = this.mDJXHomeAdItemView;
        if (dJXHomeAdItemView == null || adKey == null) {
            return;
        }
        dJXHomeAdItemView.setAdKey(adKey);
    }
}
