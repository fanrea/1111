package com.baidu.mobads.container.rewardvideo;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.style.widget.viewpager2.PageItem;
import com.style.widget.viewpager2.PageItemAdapter;
import com.style.widget.viewpager2.PageItemHolder;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class RewardFragmentAdapter extends PageItemAdapter {
    private final com.baidu.mobads.container.adrequest.i mDispatcher;
    List<? extends PageItem> mPageItems;

    public RewardFragmentAdapter(com.baidu.mobads.container.adrequest.i iVar, Activity activity, List<? extends PageItem> list) {
        super(iVar, activity, list);
        this.mDispatcher = iVar;
        this.mPageItems = list;
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public int getItemCount() {
        return this.mPageItems.size();
    }

    @Override // com.style.widget.viewpager2.PageItemAdapter, com.style.widget.viewpager2.RVAdapter
    public PageItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(com.baidu.mobads.container.util.cf.a());
        frameLayout.setSaveEnabled(false);
        return new dl(this, this.mDispatcher, frameLayout);
    }
}
