package com.kwad.components.ct.detail.photo.comment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends RecyclerView.ViewHolder {
    private a asx;

    public j(View view) {
        super(view);
        this.asx = (a) view;
    }

    final void a(b bVar) {
        a aVar = this.asx;
        if (aVar != null) {
            aVar.setData(bVar);
        }
    }
}
