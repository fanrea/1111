package com.dhylive.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ActivityCrashBindingImpl extends ActivityCrashBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.ll_crash_bar, 1);
        sparseIntArray.put(R.id.iv_crash_info, 2);
        sparseIntArray.put(R.id.tv_crash_title, 3);
        sparseIntArray.put(R.id.iv_crash_share, 4);
        sparseIntArray.put(R.id.iv_crash_restart, 5);
        sparseIntArray.put(R.id.tv_crash_message, 6);
        sparseIntArray.put(R.id.ll_crash_info, 7);
        sparseIntArray.put(R.id.tv_crash_info, 8);
    }

    public ActivityCrashBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ActivityCrashBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (DrawerLayout) objArr[0], (AppCompatImageView) objArr[2], (AppCompatImageView) objArr[5], (AppCompatImageView) objArr[4], (LinearLayout) objArr[1], (LinearLayout) objArr[7], (AppCompatTextView) objArr[8], (AppCompatTextView) objArr[6], (AppCompatTextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.dlCrashDrawer.setTag(null);
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
