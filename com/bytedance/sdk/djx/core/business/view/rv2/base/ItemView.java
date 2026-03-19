package com.bytedance.sdk.djx.core.business.view.rv2.base;

import android.view.View;
import com.bytedance.sdk.djx.core.business.view.rv2.helper.IDiffHelper;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class ItemView<T> implements IDiffHelper<ItemView<T>> {
    protected boolean isRecycled = false;
    protected T mData;

    public abstract void bind(CommonViewHolder commonViewHolder);

    public abstract int getLayoutRes();

    public void onItemClick(CommonViewHolder commonViewHolder, int i) {
    }

    public boolean onItemLongClick(CommonViewHolder commonViewHolder, int i) {
        return false;
    }

    public void resizeView(View view) {
    }

    public ItemView(T t) {
        this.mData = t;
    }

    public T getData() {
        return this.mData;
    }

    public void bind(CommonViewHolder commonViewHolder, List<Object> list) {
        this.isRecycled = false;
        bind(commonViewHolder);
    }

    public void unbind(CommonViewHolder commonViewHolder) {
        this.isRecycled = true;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv2.helper.IDiffHelper
    public boolean isItemTheSame(ItemView<T> itemView) {
        return getClass() == itemView.getClass() && getLayoutRes() == itemView.getLayoutRes();
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv2.helper.IDiffHelper
    public boolean isContentTheSame(ItemView<T> itemView) {
        return getClass() == itemView.getClass() && this.mData == itemView.mData;
    }
}
