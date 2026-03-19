package com.dhylive.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.dhylive.app.R;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ActivityResetPasswordBindingImpl extends ActivityResetPasswordBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar"}, new int[]{1}, new int[]{R.layout.layout_toolbar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_login_hint, 2);
        sparseIntArray.put(R.id.ll_pwd, 3);
        sparseIntArray.put(R.id.etPsw, 4);
        sparseIntArray.put(R.id.ivPswVisibility, 5);
        sparseIntArray.put(R.id.ll_pwd2, 6);
        sparseIntArray.put(R.id.etPsw2, 7);
        sparseIntArray.put(R.id.ivPswVisibility2, 8);
        sparseIntArray.put(R.id.ll_phone, 9);
        sparseIntArray.put(R.id.et_phone, 10);
        sparseIntArray.put(R.id.rl_code, 11);
        sparseIntArray.put(R.id.etCode, 12);
        sparseIntArray.put(R.id.tv_send, 13);
        sparseIntArray.put(R.id.tv_login, 14);
    }

    public ActivityResetPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ActivityResetPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AppCompatEditText) objArr[12], (BLEditText) objArr[10], (AppCompatEditText) objArr[4], (AppCompatEditText) objArr[7], (LayoutToolbarBinding) objArr[1], (AppCompatImageView) objArr[5], (AppCompatImageView) objArr[8], (BLLinearLayout) objArr[9], (BLLinearLayout) objArr[3], (BLLinearLayout) objArr[6], (BLLinearLayout) objArr[11], (BLTextView) objArr[14], (TextView) objArr[2], (TextView) objArr[13]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.includeToolbar);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        this.includeToolbar.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.includeToolbar.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeToolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeIncludeToolbar((LayoutToolbarBinding) obj, i2);
    }

    private boolean onChangeIncludeToolbar(LayoutToolbarBinding layoutToolbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        executeBindingsOn(this.includeToolbar);
    }
}
