package com.dhylive.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.dhylive.app.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ActivityWhithdrawSettingBindingImpl extends ActivityWhithdrawSettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(22);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar"}, new int[]{1}, new int[]{R.layout.layout_toolbar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_bind_bank_card, 2);
        sparseIntArray.put(R.id.tv_bank_title_label, 3);
        sparseIntArray.put(R.id.tv_save_bank, 4);
        sparseIntArray.put(R.id.tv_bank_user_name_label, 5);
        sparseIntArray.put(R.id.et_bank_user_name, 6);
        sparseIntArray.put(R.id.tv_bank_account_label, 7);
        sparseIntArray.put(R.id.et_bank_account, 8);
        sparseIntArray.put(R.id.tv_bank_name_label, 9);
        sparseIntArray.put(R.id.et_bank_name, 10);
        sparseIntArray.put(R.id.tv_bank_sub_name_label, 11);
        sparseIntArray.put(R.id.et_bank_sub_name, 12);
        sparseIntArray.put(R.id.cl_bind_alipay_count, 13);
        sparseIntArray.put(R.id.tv_zfb_title_label, 14);
        sparseIntArray.put(R.id.tv_save_zfb, 15);
        sparseIntArray.put(R.id.tv_zfb_real_name_label, 16);
        sparseIntArray.put(R.id.et_zfb_name, 17);
        sparseIntArray.put(R.id.tv_zfb_account_label, 18);
        sparseIntArray.put(R.id.et_zfb_account, 19);
        sparseIntArray.put(R.id.clBindWX, 20);
        sparseIntArray.put(R.id.tvWX, 21);
    }

    public ActivityWhithdrawSettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private ActivityWhithdrawSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (BLConstraintLayout) objArr[13], (BLConstraintLayout) objArr[2], (BLConstraintLayout) objArr[20], (AppCompatEditText) objArr[8], (AppCompatEditText) objArr[10], (AppCompatEditText) objArr[12], (AppCompatEditText) objArr[6], (AppCompatEditText) objArr[19], (AppCompatEditText) objArr[17], (LayoutToolbarBinding) objArr[1], (TextView) objArr[7], (TextView) objArr[9], (TextView) objArr[11], (TextView) objArr[3], (TextView) objArr[5], (BLTextView) objArr[4], (BLTextView) objArr[15], (BLTextView) objArr[21], (TextView) objArr[18], (TextView) objArr[16], (TextView) objArr[14]);
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
