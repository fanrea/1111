package com.dhylive.app.utils;

import com.alipay.sdk.m.x.d;
import com.dhylive.app.utils.Paging;
import kotlin.Metadata;

/* compiled from: Paging.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/dhylive/app/utils/SimplePagingListener;", "Lcom/dhylive/app/utils/Paging$PagingListener;", "()V", "onAction", "", "page", "", "pageSize", "onLoadMore", d.p, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class SimplePagingListener implements Paging.PagingListener {
    public abstract void onAction(int page, int pageSize);

    @Override // com.dhylive.app.utils.Paging.PagingListener
    public void onRefresh(int page, int pageSize) {
        onAction(page, pageSize);
    }

    @Override // com.dhylive.app.utils.Paging.PagingListener
    public void onLoadMore(int page, int pageSize) {
        onAction(page, pageSize);
    }
}
