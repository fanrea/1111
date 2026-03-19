package com.dhylive.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ActivityRegisterBindingImpl extends ActivityRegisterBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

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
        sparseIntArray.put(R.id.iv_back, 1);
        sparseIntArray.put(R.id.tv_login_hint, 2);
        sparseIntArray.put(R.id.ll_phone, 3);
        sparseIntArray.put(R.id.et_phone, 4);
        sparseIntArray.put(R.id.ll_pwd, 5);
        sparseIntArray.put(R.id.etPsw, 6);
        sparseIntArray.put(R.id.ivPswVisibility, 7);
        sparseIntArray.put(R.id.ll_pwd2, 8);
        sparseIntArray.put(R.id.etPsw2, 9);
        sparseIntArray.put(R.id.ivPswVisibility2, 10);
        sparseIntArray.put(R.id.rl_code, 11);
        sparseIntArray.put(R.id.etCode, 12);
        sparseIntArray.put(R.id.tv_send, 13);
        sparseIntArray.put(R.id.tv_login, 14);
        sparseIntArray.put(R.id.ll_select, 15);
        sparseIntArray.put(R.id.iv_select, 16);
        sparseIntArray.put(2131234088, 17);
    }

    public ActivityRegisterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private ActivityRegisterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatEditText) objArr[12], (BLEditText) objArr[4], (AppCompatEditText) objArr[6], (AppCompatEditText) objArr[9], (AppCompatImageView) objArr[1], (AppCompatImageView) objArr[7], (AppCompatImageView) objArr[10], (AppCompatImageView) objArr[16], (BLLinearLayout) objArr[3], (BLLinearLayout) objArr[5], (BLLinearLayout) objArr[8], (LinearLayout) objArr[15], (BLLinearLayout) objArr[11], (BLTextView) objArr[14], (TextView) objArr[2], (AppCompatTextView) objArr[17], (TextView) objArr[13]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
