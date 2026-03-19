package com.style.widget.viewpager2;

import android.view.View;
import com.baidu.mobads.container.adrequest.i;
import com.component.interfaces.RemoteDelegator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class RVViewHolder extends RemoteDelegator<Object> {
    public final View itemView;

    public RVViewHolder(i iVar, View view) {
        super("RVViewHolder", iVar, view);
        this.itemView = view;
    }

    @Override // com.component.interfaces.RemoteDelegator
    protected Object transformInstance(Object obj) {
        return obj;
    }
}
