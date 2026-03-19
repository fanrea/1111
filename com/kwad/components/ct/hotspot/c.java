package com.kwad.components.ct.hotspot;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.hotspot.view.HotspotListItemView;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends RecyclerView.Adapter<a> implements View.OnClickListener, m {
    private final RecyclerView Wj;
    private final HotspotInfo aPD;
    private final List<HotspotInfo> aPE;
    private d aPF;
    private final Context mContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return o(viewGroup);
    }

    public c(RecyclerView recyclerView, List<HotspotInfo> list, HotspotInfo hotspotInfo) {
        ArrayList arrayList = new ArrayList();
        this.aPE = arrayList;
        this.Wj = recyclerView;
        this.mContext = recyclerView.getContext();
        this.aPD = hotspotInfo;
        arrayList.addAll(list);
    }

    public final void setItemClickListener(d dVar) {
        this.aPF = dVar;
    }

    private a o(ViewGroup viewGroup) {
        HotspotListItemView hotspotListItemView = (HotspotListItemView) com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_hot_list_item, false);
        hotspotListItemView.setVisibleListener(this);
        hotspotListItemView.setOnClickListener(this);
        hotspotListItemView.ca(this.aPD == null);
        return new a(hotspotListItemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.aPE.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        HotspotInfo hotspotInfo = this.aPE.get(i);
        HotspotListItemView hotspotListItemView = aVar.aPG;
        HotspotInfo hotspotInfo2 = this.aPD;
        hotspotListItemView.a(hotspotInfo, hotspotInfo2 != null && hotspotInfo2.trendId == hotspotInfo.trendId);
    }

    public final void IG() {
        if (this.Wj != null) {
            for (int i = 0; i < this.Wj.getChildCount(); i++) {
                ((a) this.Wj.getChildViewHolder(this.Wj.getChildAt(i))).aPG.ca(true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int childAdapterPosition = this.Wj.getChildAdapterPosition(view);
        HotspotInfo hotspotInfo = this.aPE.get(childAdapterPosition);
        d dVar = this.aPF;
        if (dVar != null) {
            dVar.a(view, hotspotInfo, childAdapterPosition);
        }
    }

    @Override // com.kwad.sdk.widget.m
    public final void E(View view) {
        HotspotInfo hotspotInfo = this.aPE.get(this.Wj.getChildAdapterPosition(view));
        d dVar = this.aPF;
        if (dVar != null) {
            dVar.c(hotspotInfo);
        }
    }

    protected static class a extends RecyclerView.ViewHolder {
        private final HotspotListItemView aPG;

        public a(HotspotListItemView hotspotListItemView) {
            super(hotspotListItemView);
            this.aPG = hotspotListItemView;
        }
    }
}
