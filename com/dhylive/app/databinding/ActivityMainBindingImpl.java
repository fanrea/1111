package com.dhylive.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.dhylive.app.R;
import com.noober.background.view.BLImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ActivityMainBindingImpl extends ActivityMainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_page, 1);
        sparseIntArray.put(R.id.ll_tab, 2);
        sparseIntArray.put(R.id.ll_drama, 3);
        sparseIntArray.put(R.id.iv_drama, 4);
        sparseIntArray.put(R.id.tv_drama, 5);
        sparseIntArray.put(R.id.ll_video, 6);
        sparseIntArray.put(R.id.iv_video, 7);
        sparseIntArray.put(R.id.tv_video, 8);
        sparseIntArray.put(R.id.ll_video_ks, 9);
        sparseIntArray.put(R.id.iv_video_ks, 10);
        sparseIntArray.put(R.id.tv_video_ks, 11);
        sparseIntArray.put(R.id.ll_novel, 12);
        sparseIntArray.put(R.id.iv_novel, 13);
        sparseIntArray.put(R.id.tv_novel, 14);
        sparseIntArray.put(R.id.ll_task, 15);
        sparseIntArray.put(R.id.iv_task, 16);
        sparseIntArray.put(R.id.tv_task, 17);
        sparseIntArray.put(R.id.ll_game, 18);
        sparseIntArray.put(R.id.iv_game, 19);
        sparseIntArray.put(R.id.tv_game, 20);
        sparseIntArray.put(R.id.ll_shop, 21);
        sparseIntArray.put(R.id.iv_shop, 22);
        sparseIntArray.put(R.id.tv_shop, 23);
        sparseIntArray.put(R.id.ll_money, 24);
        sparseIntArray.put(R.id.iv_money, 25);
        sparseIntArray.put(R.id.tv_money, 26);
        sparseIntArray.put(R.id.ll_my, 27);
        sparseIntArray.put(R.id.iv_my, 28);
        sparseIntArray.put(R.id.tv_my, 29);
        sparseIntArray.put(2131231356, 30);
    }

    public ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 31, sIncludes, sViewsWithIds));
    }

    private ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[30], (BLImageView) objArr[4], (AppCompatImageView) objArr[19], (AppCompatImageView) objArr[25], (AppCompatImageView) objArr[28], (AppCompatImageView) objArr[13], (AppCompatImageView) objArr[22], (AppCompatImageView) objArr[16], (AppCompatImageView) objArr[7], (AppCompatImageView) objArr[10], (LinearLayout) objArr[3], (LinearLayout) objArr[18], (LinearLayout) objArr[24], (LinearLayout) objArr[27], (LinearLayout) objArr[12], (LinearLayout) objArr[21], (LinearLayout) objArr[2], (LinearLayout) objArr[15], (LinearLayout) objArr[6], (LinearLayout) objArr[9], (TextView) objArr[5], (TextView) objArr[20], (TextView) objArr[26], (TextView) objArr[29], (TextView) objArr[14], (TextView) objArr[23], (TextView) objArr[17], (TextView) objArr[8], (TextView) objArr[11], (ViewPager2) objArr[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
