package com.dhylive.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.dhylive.app.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class FragmentMineBindingImpl extends FragmentMineBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

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
        sparseIntArray.put(R.id.iv_setting, 1);
        sparseIntArray.put(R.id.iv_scan, 2);
        sparseIntArray.put(R.id.iv_avatar, 3);
        sparseIntArray.put(R.id.mine_tv_nickname, 4);
        sparseIntArray.put(R.id.mine_tv_icode, 5);
        sparseIntArray.put(R.id.mine_tv_lv, 6);
        sparseIntArray.put(R.id.mine_tv_vipendtime, 7);
        sparseIntArray.put(R.id.mine_tv_home, 8);
        sparseIntArray.put(R.id.cl_vip_info, 9);
        sparseIntArray.put(R.id.tv_vip_type, 10);
        sparseIntArray.put(R.id.tv_vip_hint_1, 11);
        sparseIntArray.put(R.id.tv_vip_charge, 12);
        sparseIntArray.put(R.id.cl_money, 13);
        sparseIntArray.put(R.id.tv_coin_num, 14);
        sparseIntArray.put(R.id.tv_coin_hint, 15);
        sparseIntArray.put(R.id.view_coin, 16);
        sparseIntArray.put(2131230846, 17);
        sparseIntArray.put(R.id.tv_money, 18);
        sparseIntArray.put(R.id.tvSendCoin, 19);
        sparseIntArray.put(R.id.tv_cash, 20);
        sparseIntArray.put(R.id.ll_task, 21);
        sparseIntArray.put(R.id.tv_task_hint, 22);
        sparseIntArray.put(R.id.tv_go_task, 23);
        sparseIntArray.put(R.id.mine_ll_feature_two, 24);
        sparseIntArray.put(R.id.recycler, 25);
    }

    public FragmentMineBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private FragmentMineBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Barrier) objArr[17], (ConstraintLayout) objArr[13], (BLConstraintLayout) objArr[9], (AppCompatImageView) objArr[3], (AppCompatImageView) objArr[2], (AppCompatImageView) objArr[1], (BLLinearLayout) objArr[21], (BLLinearLayout) objArr[24], (BLTextView) objArr[8], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[4], (TextView) objArr[7], (RecyclerView) objArr[25], (BLTextView) objArr[20], (AppCompatTextView) objArr[15], (AppCompatTextView) objArr[14], (AppCompatTextView) objArr[23], (AppCompatTextView) objArr[18], (BLTextView) objArr[19], (BLTextView) objArr[22], (BLTextView) objArr[12], (AppCompatTextView) objArr[11], (AppCompatTextView) objArr[10], (View) objArr[16]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
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
