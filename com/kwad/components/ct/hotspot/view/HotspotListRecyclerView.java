package com.kwad.components.ct.hotspot.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.hotspot.c;
import com.kwad.components.ct.hotspot.d;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HotspotListRecyclerView extends RecyclerView {
    private c aQx;

    public HotspotListRecyclerView(Context context) {
        super(context);
    }

    public HotspotListRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HotspotListRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(List<HotspotInfo> list, HotspotInfo hotspotInfo) {
        setItemAnimator(null);
        setLayoutManager(new LinearLayoutManager(getContext()));
        c cVar = new c(this, list, hotspotInfo);
        this.aQx = cVar;
        setAdapter(cVar);
    }

    public final void IG() {
        c cVar = this.aQx;
        if (cVar != null) {
            cVar.IG();
        }
    }

    public void setItemClickListener(d dVar) {
        this.aQx.setItemClickListener(dVar);
    }
}
