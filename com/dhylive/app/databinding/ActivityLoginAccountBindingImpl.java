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
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ActivityLoginAccountBindingImpl extends ActivityLoginAccountBinding {
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
        sparseIntArray.put(R.id.iv_icon, 1);
        sparseIntArray.put(R.id.tv_login_hint, 2);
        sparseIntArray.put(R.id.cl_all, 3);
        sparseIntArray.put(R.id.ll_phone, 4);
        sparseIntArray.put(R.id.et_phone, 5);
        sparseIntArray.put(R.id.ll_pwd, 6);
        sparseIntArray.put(R.id.etPsw, 7);
        sparseIntArray.put(R.id.ivPswVisibility, 8);
        sparseIntArray.put(R.id.rl_code, 9);
        sparseIntArray.put(R.id.etCode, 10);
        sparseIntArray.put(R.id.tv_send, 11);
        sparseIntArray.put(R.id.tv_register, 12);
        sparseIntArray.put(R.id.tv_reset_password, 13);
        sparseIntArray.put(R.id.tv_login, 14);
        sparseIntArray.put(R.id.ll_select, 15);
        sparseIntArray.put(R.id.iv_select, 16);
        sparseIntArray.put(2131234088, 17);
        sparseIntArray.put(R.id.tv_other_login_hint, 18);
        sparseIntArray.put(R.id.iv_wx_login, 19);
        sparseIntArray.put(R.id.iv_code_login, 20);
        sparseIntArray.put(R.id.iv_phone_login, 21);
        sparseIntArray.put(R.id.ll_wx, 22);
        sparseIntArray.put(R.id.fl_wx_login, 23);
        sparseIntArray.put(R.id.ll_select_wx, 24);
        sparseIntArray.put(R.id.iv_select_wx, 25);
        sparseIntArray.put(R.id.tv_privacy_wx, 26);
    }

    public ActivityLoginAccountBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 27, sIncludes, sViewsWithIds));
    }

    private ActivityLoginAccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[3], (AppCompatEditText) objArr[10], (BLEditText) objArr[5], (AppCompatEditText) objArr[7], (BLFrameLayout) objArr[23], (AppCompatImageView) objArr[20], (AppCompatImageView) objArr[1], (AppCompatImageView) objArr[21], (AppCompatImageView) objArr[8], (AppCompatImageView) objArr[16], (AppCompatImageView) objArr[25], (AppCompatImageView) objArr[19], (BLLinearLayout) objArr[4], (BLLinearLayout) objArr[6], (LinearLayout) objArr[15], (LinearLayout) objArr[24], (LinearLayout) objArr[22], (BLLinearLayout) objArr[9], (BLTextView) objArr[14], (TextView) objArr[2], (AppCompatTextView) objArr[18], (AppCompatTextView) objArr[17], (AppCompatTextView) objArr[26], (AppCompatTextView) objArr[12], (AppCompatTextView) objArr[13], (TextView) objArr[11]);
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
