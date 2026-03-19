package com.style.widget.viewpager2;

import android.view.ViewGroup;
import com.baidu.mobads.container.adrequest.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class PageItemHolder extends RVViewHolder {
    public PageItemHolder(i iVar, ViewGroup viewGroup) {
        super(iVar, viewGroup);
    }

    public ViewGroup getContainer() {
        return (ViewGroup) this.itemView;
    }
}
