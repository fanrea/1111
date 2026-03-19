package com.style.widget.viewpager2;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.mobads.container.activity.b;
import com.baidu.mobads.container.adrequest.i;
import com.baidu.mobads.container.util.bm;
import com.baidu.mobads.container.util.bq;
import com.component.interfaces.RemoteDelegator;
import com.component.lottie.b.b;
import com.style.widget.viewpager2.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class PageItemAdapter extends RVAdapter<PageItemHolder> {
    private final b<PageItem> mActiveItems;
    private final b<Integer> mActiveViewHolderIds;
    private final com.baidu.mobads.container.activity.b mActivityLifecycle;
    private final List<ViewPager2.DataSetChangeObserver> mDataSetChangeObservers;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final List<? extends PageItem> mModelItems;
    private PageItemMaxLifecycleEnforcer mPageItemMaxLifecycleEnforcer;
    private int selectedItem;

    @Override // com.style.widget.viewpager2.RVAdapter
    public abstract PageItemHolder onCreateViewHolder(ViewGroup viewGroup, int i);

    public PageItemAdapter(i iVar, Activity activity, List<? extends PageItem> list) {
        super(iVar);
        this.mActiveItems = new b<>();
        this.mActiveViewHolderIds = new b<>();
        this.selectedItem = -1;
        this.mHasStaleFragments = false;
        this.mIsInGracePeriod = false;
        this.mDataSetChangeObservers = new ArrayList();
        this.mModelItems = list;
        this.mActivityLifecycle = com.baidu.mobads.container.activity.b.a(activity, new MyActivityLifecycleCallback());
    }

    public com.baidu.mobads.container.activity.b getRegisteredLifeCycle() {
        return this.mActivityLifecycle;
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public void onBindViewHolder(PageItemHolder pageItemHolder, int i) {
        long itemId = getItemId(i);
        int id = pageItemHolder.getContainer().getId();
        Long lItemForViewHolder = itemForViewHolder(id);
        if (lItemForViewHolder != null && lItemForViewHolder.longValue() != itemId) {
            removePageItem(lItemForViewHolder.longValue(), pageItemHolder);
            this.mActiveViewHolderIds.c(lItemForViewHolder.longValue());
        }
        this.mActiveViewHolderIds.d(itemId, Integer.valueOf(id));
        ensureItemCreated(i);
        placePageItemInViewHolder(itemId, pageItemHolder);
        gcFragments();
    }

    void placePageItemInViewHolder(long j, PageItemHolder pageItemHolder) {
        PageItem pageItemA = this.mActiveItems.a(j);
        if (pageItemA != null) {
            pageItemA.onPageBindHolder(pageItemHolder);
        }
        this.mPageItemMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
    }

    void gcFragments() {
        if (!this.mHasStaleFragments) {
            return;
        }
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        for (int i = 0; i < this.mActiveItems.b(); i++) {
            long jB = this.mActiveItems.b(i);
            if (!containsItem(jB)) {
                copyOnWriteArraySet.add(Long.valueOf(jB));
                this.mActiveViewHolderIds.c(jB);
            }
        }
        if (!this.mIsInGracePeriod) {
            this.mHasStaleFragments = false;
            for (int i2 = 0; i2 < this.mActiveItems.b(); i2++) {
                long jB2 = this.mActiveItems.b(i2);
                if (!isFragmentViewBound(jB2)) {
                    copyOnWriteArraySet.add(Long.valueOf(jB2));
                }
            }
        }
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            removePageItem(((Long) it.next()).longValue(), null);
        }
    }

    private boolean isFragmentViewBound(long j) {
        if (this.mActiveViewHolderIds.e(j)) {
            return true;
        }
        this.mActiveItems.a(j);
        return false;
    }

    private Long itemForViewHolder(int i) {
        Long lValueOf = null;
        for (int i2 = 0; i2 < this.mActiveViewHolderIds.b(); i2++) {
            if (this.mActiveViewHolderIds.c(i2).intValue() == i) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.mActiveViewHolderIds.b(i2));
            }
        }
        return lValueOf;
    }

    private void ensureItemCreated(int i) {
        long itemId = getItemId(i);
        if (!this.mActiveItems.e(itemId)) {
            PageItem pageItem = this.mModelItems.get(i);
            pageItem.getLifecycle().setMinLifecycle(State.CREATED);
            this.mActiveItems.d(itemId, pageItem);
        }
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public void onAttachedToRecyclerView(ViewGroup viewGroup) {
        bm.a(this.mPageItemMaxLifecycleEnforcer == null);
        this.mPageItemMaxLifecycleEnforcer = new PageItemMaxLifecycleEnforcer();
        this.mPageItemMaxLifecycleEnforcer.register(viewGroup);
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public void onDetachedFromRecyclerView(ViewGroup viewGroup) {
        this.mPageItemMaxLifecycleEnforcer.unregister(viewGroup);
        this.mPageItemMaxLifecycleEnforcer = null;
    }

    public void registerAdapterDataObserver(ViewPager2.DataSetChangeObserver dataSetChangeObserver) {
        this.mDataSetChangeObservers.add(dataSetChangeObserver);
    }

    public void unregisterAdapterDataObserver(ViewPager2.DataSetChangeObserver dataSetChangeObserver) {
        this.mDataSetChangeObservers.remove(dataSetChangeObserver);
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    protected void onDataSetChanged() {
        Iterator<ViewPager2.DataSetChangeObserver> it = this.mDataSetChangeObservers.iterator();
        while (it.hasNext()) {
            it.next().onChanged();
        }
    }

    class PageItemMaxLifecycleEnforcer {
        private ViewPager2.DataSetChangeObserver mDataObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        PageItemMaxLifecycleEnforcer() {
        }

        void register(ViewGroup viewGroup) {
            this.mViewPager = inferViewPager(viewGroup);
            this.mPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.style.widget.viewpager2.PageItemAdapter.PageItemMaxLifecycleEnforcer.1
                @Override // com.style.widget.viewpager2.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    PageItemMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                @Override // com.style.widget.viewpager2.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i) {
                    PageItemMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mViewPager.registerOnPageChangeCallback(this.mPageChangeCallback);
            this.mDataObserver = new ViewPager2.DataSetChangeObserver() { // from class: com.style.widget.viewpager2.PageItemAdapter.PageItemMaxLifecycleEnforcer.2
                @Override // com.style.widget.viewpager2.ViewPager2.DataSetChangeObserver
                public void onChanged() {
                    PageItemMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            PageItemAdapter.this.registerAdapterDataObserver(this.mDataObserver);
        }

        void unregister(ViewGroup viewGroup) {
            inferViewPager(viewGroup).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            PageItemAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            this.mViewPager = null;
        }

        void updateFragmentMaxLifecycle(boolean z) {
            int currentItem;
            try {
                if (this.mViewPager.getScrollState() != 0 || PageItemAdapter.this.mActiveItems.c() || PageItemAdapter.this.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= PageItemAdapter.this.getItemCount()) {
                    return;
                }
                long itemId = PageItemAdapter.this.getItemId(currentItem);
                if ((itemId == this.mPrimaryItemId && !z) || ((PageItem) PageItemAdapter.this.mActiveItems.a(itemId)) == null) {
                    return;
                }
                this.mPrimaryItemId = itemId;
                PageItem pageItem = null;
                for (int i = 0; i < PageItemAdapter.this.mActiveItems.b(); i++) {
                    long jB = PageItemAdapter.this.mActiveItems.b(i);
                    PageItem pageItem2 = (PageItem) PageItemAdapter.this.mActiveItems.c(i);
                    if (pageItem2 != null) {
                        if (jB != this.mPrimaryItemId) {
                            PageItemLifecycle lifecycle = pageItem2.getLifecycle();
                            if (lifecycle.isCreated()) {
                                lifecycle.moveToState(State.STARTED);
                            }
                        } else {
                            pageItem = pageItem2;
                        }
                    }
                }
                if (pageItem != null) {
                    PageItemLifecycle lifecycle2 = pageItem.getLifecycle();
                    if (lifecycle2.getCurrentState().isAtLeast(State.CREATED) && PageItemAdapter.this.mActivityLifecycle.b().isAtLeast(State.RESUMED)) {
                        lifecycle2.moveToState(State.RESUMED);
                    }
                }
            } catch (Throwable th) {
                bq.a().c(th);
            }
        }

        private ViewPager2 inferViewPager(ViewGroup viewGroup) {
            ViewParent parent = viewGroup.getParent();
            Object remoteTarget = RemoteDelegator.getRemoteTarget(parent);
            if (remoteTarget instanceof ViewPager2) {
                return (ViewPager2) remoteTarget;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public final void onViewRecycled(PageItemHolder pageItemHolder) {
        Long lItemForViewHolder = itemForViewHolder(pageItemHolder.getContainer().getId());
        if (lItemForViewHolder != null) {
            removePageItem(lItemForViewHolder.longValue(), pageItemHolder);
            this.mActiveViewHolderIds.c(lItemForViewHolder.longValue());
        }
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public final void onViewAttachedToWindow(RVViewHolder rVViewHolder) {
        gcFragments();
    }

    private void removePageItem(long j, PageItemHolder pageItemHolder) {
        PageItem pageItemA = this.mActiveItems.a(j);
        if (pageItemA == null) {
            return;
        }
        pageItemA.onPageUnBind(pageItemHolder);
        this.mActiveItems.c(j);
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public long getItemId(int i) {
        return i;
    }

    public boolean containsItem(long j) {
        return j > 0 && j < ((long) getItemCount());
    }

    @Override // com.style.widget.viewpager2.RVAdapter
    public boolean onFailedToRecycleView(RVViewHolder rVViewHolder) {
        return true;
    }

    private class MyActivityLifecycleCallback extends b.a {
        private MyActivityLifecycleCallback() {
        }

        @Override // com.baidu.mobads.container.activity.b.a
        public void onActivityStarted(com.baidu.mobads.container.activity.b bVar) {
            for (int i = 0; i < PageItemAdapter.this.mActiveItems.b(); i++) {
                PageItem pageItem = (PageItem) PageItemAdapter.this.mActiveItems.c(i);
                if (pageItem != null) {
                    PageItemLifecycle lifecycle = pageItem.getLifecycle();
                    if (lifecycle.isCreated()) {
                        lifecycle.setMinLifecycle(State.STARTED);
                    }
                }
            }
        }

        @Override // com.baidu.mobads.container.activity.b.a
        public void onActivityResumed(com.baidu.mobads.container.activity.b bVar) {
            if (PageItemAdapter.this.mPageItemMaxLifecycleEnforcer != null) {
                PageItemAdapter.this.mPageItemMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
            }
        }

        @Override // com.baidu.mobads.container.activity.b.a
        public void onActivityPaused(com.baidu.mobads.container.activity.b bVar) {
            for (int i = 0; i < PageItemAdapter.this.mActiveItems.b(); i++) {
                PageItem pageItem = (PageItem) PageItemAdapter.this.mActiveItems.c(i);
                if (pageItem != null) {
                    pageItem.getLifecycle().setMaxLifecycle(State.STARTED);
                }
            }
        }

        @Override // com.baidu.mobads.container.activity.b.a
        public void onActivityStopped(com.baidu.mobads.container.activity.b bVar) {
            for (int i = 0; i < PageItemAdapter.this.mActiveItems.b(); i++) {
                PageItem pageItem = (PageItem) PageItemAdapter.this.mActiveItems.c(i);
                if (pageItem != null) {
                    pageItem.getLifecycle().setMaxLifecycle(State.CREATED);
                }
            }
        }

        @Override // com.baidu.mobads.container.activity.b.a
        public void onActivityDestroyed(com.baidu.mobads.container.activity.b bVar) {
            for (int i = 0; i < PageItemAdapter.this.mModelItems.size(); i++) {
                PageItem pageItem = (PageItem) PageItemAdapter.this.mModelItems.get(i);
                if (pageItem != null) {
                    pageItem.getLifecycle().moveToState(State.DESTROYED);
                }
            }
            bVar.b(this);
        }
    }
}
