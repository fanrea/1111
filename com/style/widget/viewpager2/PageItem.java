package com.style.widget.viewpager2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public interface PageItem {
    PageItemLifecycle getLifecycle();

    int getPageCount();

    long getPageId();

    int getPageIndex();

    void onPageBindHolder(PageItemHolder pageItemHolder);

    void onPageCreate();

    void onPageDestroy();

    void onPagePause();

    void onPageResume();

    void onPageStart();

    void onPageStop();

    void onPageUnBind(PageItemHolder pageItemHolder);
}
