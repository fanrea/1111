package com.dhylive.app.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.x.d;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.dhylive.app.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.tkruntime.v8.V8Trace;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Paging.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 7*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u000278B3\u0012\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u0010'\u001a\u00020\u0018J\u0006\u0010(\u001a\u00020\u0018J\u0006\u0010)\u001a\u00020\u0018J&\u0010*\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000,2\u0006\u0010-\u001a\u00020\u001dH\u0002J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010/\u001a\u00020\u00182\b\b\u0001\u0010\u0011\u001a\u00020\u0012J\u001e\u00100\u001a\u00020\u00182\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,2\u0006\u0010-\u001a\u00020\u001dJ\u000e\u00101\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u00102\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0014J\u001e\u00105\u001a\u00020\u00182\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,2\u0006\u0010-\u001a\u00020\u001dJ\u0016\u00106\u001a\u00020\u00182\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,J\u001e\u00106\u001a\u00020\u00182\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,2\u0006\u0010-\u001a\u00020\u001dR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/dhylive/app/utils/Paging;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/scwang/smart/refresh/layout/listener/OnRefreshListener;", "Lcom/scwang/smart/refresh/layout/listener/OnLoadMoreListener;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "mAdapter", "Lcom/chad/library/adapter4/BaseQuickAdapter;", "mRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "mRefresh", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "mLifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lcom/chad/library/adapter4/BaseQuickAdapter;Landroidx/recyclerview/widget/RecyclerView;Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;Landroidx/lifecycle/Lifecycle;)V", "emptyLayout", "Landroid/view/View;", "emptyLayoutRes", "", "mPagingListener", "Lcom/dhylive/app/utils/Paging$PagingListener;", "page", "pageSize", "displayEmptyView", "", h.i, "getPage", "getPageSize", "isRefresh", "", "loadMoreFail", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onLoadMore", "refreshLayout", "Lcom/scwang/smart/refresh/layout/api/RefreshLayout;", d.p, "onStop", "refresh", "refreshFail", "refreshNoAnima", V8Trace.SECTION_SET_DATA, "data", "", "hasNextPage", "setEmptyLayout", "setEmptyLayoutRes", "setLoadMoreResult", "setPage", "setPageSize", "setPagingListener", "pagingListener", "setRefreshResult", "setResult", "Companion", "PagingListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class Paging<T> implements OnRefreshListener, OnLoadMoreListener, DefaultLifecycleObserver {
    public static final int DEF_PAGE = 1;
    public static final int DEF_PAGE_SIZE = 10;
    private View emptyLayout;
    private int emptyLayoutRes;
    private final BaseQuickAdapter<T, ?> mAdapter;
    private Lifecycle mLifecycle;
    private PagingListener mPagingListener;
    private final RecyclerView mRecycler;
    private final SmartRefreshLayout mRefresh;
    private int page;
    private int pageSize;

    /* compiled from: Paging.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/dhylive/app/utils/Paging$PagingListener;", "", "onLoadMore", "", "page", "", "pageSize", d.p, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface PagingListener {
        void onLoadMore(int page, int pageSize);

        void onRefresh(int page, int pageSize);
    }

    public Paging(BaseQuickAdapter<T, ?> baseQuickAdapter, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "mAdapter");
        Intrinsics.checkNotNullParameter(recyclerView, "mRecycler");
        Intrinsics.checkNotNullParameter(smartRefreshLayout, "mRefresh");
        this.mAdapter = baseQuickAdapter;
        this.mRecycler = recyclerView;
        this.mRefresh = smartRefreshLayout;
        this.mLifecycle = lifecycle;
        this.page = 1;
        this.pageSize = 10;
        AppCompatImageView appCompatImageView = new AppCompatImageView(recyclerView.getContext());
        appCompatImageView.setImageResource(R.drawable.ic_public_load_empty);
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.emptyLayout = appCompatImageView;
        Lifecycle lifecycle2 = this.mLifecycle;
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this);
        }
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter((RecyclerView.Adapter) baseQuickAdapter);
        }
        baseQuickAdapter.setStateViewEnable(true);
        smartRefreshLayout.setEnableOverScrollDrag(false);
        smartRefreshLayout.setDisableContentWhenLoading(true);
        smartRefreshLayout.setDisableContentWhenRefresh(true);
        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
    }

    public /* synthetic */ Paging(BaseQuickAdapter baseQuickAdapter, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, Lifecycle lifecycle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseQuickAdapter, recyclerView, smartRefreshLayout, (i & 8) != 0 ? null : lifecycle);
    }

    @Override // com.scwang.smart.refresh.layout.listener.OnRefreshListener
    public void onRefresh(RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        this.page = 1;
        PagingListener pagingListener = this.mPagingListener;
        if (pagingListener != null) {
            pagingListener.onRefresh(1, this.pageSize);
        }
    }

    @Override // com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        int i = this.page + 1;
        this.page = i;
        PagingListener pagingListener = this.mPagingListener;
        if (pagingListener != null) {
            pagingListener.onLoadMore(i, this.pageSize);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onDestroy(owner);
        this.mLifecycle = null;
        this.mPagingListener = null;
    }

    private final void setData(boolean isRefresh, List<? extends T> data, boolean hasNextPage) {
        int size = data.size();
        if (isRefresh) {
            this.mRefresh.finishRefresh(500);
            if (size == 0) {
                displayEmptyView();
            } else {
                this.mAdapter.submitList(data);
            }
            if (size < this.pageSize || !hasNextPage) {
                this.mRefresh.setNoMoreData(true);
                return;
            } else {
                this.mRefresh.setNoMoreData(false);
                return;
            }
        }
        if (size > 0) {
            this.mAdapter.addAll(data);
        }
        if (size < this.pageSize || !hasNextPage) {
            this.mRefresh.setNoMoreData(true);
        } else {
            this.mRefresh.finishLoadMore();
        }
    }

    private final void displayEmptyView() {
        this.mAdapter.submitList((List) null);
        View view = this.emptyLayout;
        if (view != null) {
            this.mAdapter.setStateView(view);
        } else if (this.emptyLayoutRes != 0) {
            BaseQuickAdapter<T, ?> baseQuickAdapter = this.mAdapter;
            Context context = this.mRecycler.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            baseQuickAdapter.setStateViewLayout(context, this.emptyLayoutRes);
        }
        BaseQuickAdapter.displayEmptyView$default(this.mAdapter, (List) null, 1, (Object) null);
    }

    public final void setPagingListener(PagingListener pagingListener) {
        Intrinsics.checkNotNullParameter(pagingListener, "pagingListener");
        this.mPagingListener = pagingListener;
    }

    public final void setEmptyLayoutRes(int emptyLayoutRes) {
        this.emptyLayoutRes = emptyLayoutRes;
    }

    public final void setEmptyLayout(View emptyLayout) {
        Intrinsics.checkNotNullParameter(emptyLayout, "emptyLayout");
        this.emptyLayout = emptyLayout;
    }

    public final boolean isRefresh() {
        return this.page == 1;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public final void setPage(int page) {
        this.page = page;
    }

    public final void setResult(List<? extends T> data, boolean hasNextPage) {
        boolean zIsRefresh = isRefresh();
        if (data == null) {
            data = CollectionsKt.emptyList();
        }
        setData(zIsRefresh, data, hasNextPage);
    }

    public final void setResult(List<? extends T> data) {
        boolean zIsRefresh = isRefresh();
        List<? extends T> listEmptyList = data == null ? CollectionsKt.emptyList() : data;
        boolean z = false;
        if (data != null && data.size() == getPageSize()) {
            z = true;
        }
        setData(zIsRefresh, listEmptyList, z);
    }

    public final void setRefreshResult(List<? extends T> data, boolean hasNextPage) {
        if (data == null) {
            data = CollectionsKt.emptyList();
        }
        setData(true, data, hasNextPage);
    }

    public final void setLoadMoreResult(List<? extends T> data, boolean hasNextPage) {
        if (data == null) {
            data = CollectionsKt.emptyList();
        }
        setData(false, data, hasNextPage);
    }

    public final void failed() {
        if (isRefresh()) {
            refreshFail();
        } else {
            loadMoreFail();
        }
    }

    public final void refreshFail() {
        this.mRefresh.finishRefresh();
        this.mRefresh.setNoMoreData(true);
        setResult(null);
    }

    public final void loadMoreFail() {
        this.page--;
        this.mRefresh.setEnableRefresh(true);
    }

    public final void refresh() {
        this.mRefresh.autoRefresh();
    }

    public final void refreshNoAnima() {
        this.page = 1;
        PagingListener pagingListener = this.mPagingListener;
        if (pagingListener != null) {
            pagingListener.onRefresh(1, this.pageSize);
        }
    }
}
