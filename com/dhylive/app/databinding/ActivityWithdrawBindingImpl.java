package com.dhylive.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ActivityWithdrawBindingImpl extends ActivityWithdrawBinding {
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
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.public_iv_back, 2);
        sparseIntArray.put(R.id.public_tv_title, 3);
        sparseIntArray.put(R.id.tvRecord, 4);
        sparseIntArray.put(R.id.ll_balance, 5);
        sparseIntArray.put(R.id.tv_coin_num, 6);
        sparseIntArray.put(R.id.tv_coin_hint, 7);
        sparseIntArray.put(2131231401, 8);
        sparseIntArray.put(R.id.tv_money, 9);
        sparseIntArray.put(R.id.appCompatTextView, 10);
        sparseIntArray.put(2131233088, 11);
        sparseIntArray.put(R.id.tv_bank, 12);
        sparseIntArray.put(R.id.tv_zfb, 13);
        sparseIntArray.put(R.id.tv_wx, 14);
        sparseIntArray.put(R.id.tvAdd, 15);
        sparseIntArray.put(R.id.tv_withdraw, 16);
        sparseIntArray.put(R.id.tv_withdraw_label, 17);
    }

    public ActivityWithdrawBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private ActivityWithdrawBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatTextView) objArr[10], (Guideline) objArr[8], (ConstraintLayout) objArr[5], (AppCompatImageView) objArr[2], (AppCompatTextView) objArr[3], (RecyclerView) objArr[11], (ConstraintLayout) objArr[1], (BLTextView) objArr[15], (BLTextView) objArr[12], (AppCompatTextView) objArr[7], (AppCompatTextView) objArr[6], (AppCompatTextView) objArr[9], (BLTextView) objArr[4], (BLTextView) objArr[16], (TextView) objArr[17], (BLTextView) objArr[14], (BLTextView) objArr[13]);
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
