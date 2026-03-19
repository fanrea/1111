package com.baidu.mobads.container.rewardvideo;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.rewardvideo.a;
import com.style.widget.viewpager2.PageItem;
import com.style.widget.viewpager2.PageItemHolder;
import com.style.widget.viewpager2.PageItemLifecycle;
import com.style.widget.viewpager2.State;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class dk implements PageItem {
    private final NativeRewardActivity b;
    private final PageItemLifecycle a = new PageItemLifecycle(this);
    private int c = 0;
    private int d = 1;

    public dk(com.baidu.mobads.container.adrequest.ac acVar, boolean z) {
        if (z) {
            this.b = new dm(acVar, this);
        } else {
            this.b = new NativeRewardActivity(acVar, this);
        }
    }

    public static dk a(com.baidu.mobads.container.adrequest.ac acVar, int i, int i2, boolean z) {
        dk dkVar = new dk(acVar, z);
        dkVar.c = i;
        dkVar.d = i2;
        dkVar.a.saveCurrentState(State.INITIALIZED);
        return dkVar;
    }

    public void a(a.C0132a c0132a) {
        if (this.b != null) {
            this.b.setRewardItemAdCallback(c0132a);
        }
    }

    public void a(dq dqVar) {
        this.b.setSharedItemMediator(dqVar);
    }

    public NativeRewardActivity a() {
        return this.b;
    }

    public void a(int i) {
        if (this.b != null) {
            this.b.onPageSelected(i);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public long getPageId() {
        return getPageIndex();
    }

    @Override // com.style.widget.viewpager2.PageItem
    public int getPageIndex() {
        return this.c;
    }

    @Override // com.style.widget.viewpager2.PageItem
    public int getPageCount() {
        return this.d;
    }

    @Override // com.style.widget.viewpager2.PageItem
    public PageItemLifecycle getLifecycle() {
        return this.a;
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPageCreate() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.b != null) {
            this.b.onCreate(null);
            this.a.saveCurrentState(State.CREATED);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPageBindHolder(PageItemHolder pageItemHolder) {
        RelativeLayout rootView;
        if (this.b != null && (rootView = this.b.getRootView()) != null) {
            ViewParent parent = rootView.getParent();
            if (parent == null) {
                rootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            } else if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(rootView);
            }
            pageItemHolder.getContainer().addView(rootView);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPageUnBind(PageItemHolder pageItemHolder) {
        RelativeLayout rootView;
        if (pageItemHolder != null && this.b != null && (rootView = this.b.getRootView()) != null) {
            pageItemHolder.getContainer().removeView(rootView);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPageStart() {
        if (this.b != null) {
            this.b.onStart();
            this.a.saveCurrentState(State.STARTED);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPageResume() {
        if (this.b != null) {
            this.b.onResume();
            this.a.saveCurrentState(State.RESUMED);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPagePause() {
        if (this.b != null) {
            this.b.onPause();
            this.a.saveCurrentState(State.STARTED);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPageStop() {
        if (this.b != null) {
            this.b.onStop();
            this.a.saveCurrentState(State.CREATED);
        }
    }

    @Override // com.style.widget.viewpager2.PageItem
    public void onPageDestroy() {
        if (this.b != null) {
            this.b.onDestroy();
            this.a.saveCurrentState(State.INITIALIZED);
        }
    }
}
