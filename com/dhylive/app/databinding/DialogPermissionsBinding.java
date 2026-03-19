package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class DialogPermissionsBinding extends ViewDataBinding {
    public final TextView tvPermissionsCancel;
    public final TextView tvPermissionsContent;
    public final TextView tvPermissionsOk;
    public final TextView tvPermissionsTitle;

    protected DialogPermissionsBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.tvPermissionsCancel = textView;
        this.tvPermissionsContent = textView2;
        this.tvPermissionsOk = textView3;
        this.tvPermissionsTitle = textView4;
    }

    public static DialogPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPermissionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_permissions, viewGroup, z, obj);
    }

    public static DialogPermissionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPermissionsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPermissionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_permissions, null, false, obj);
    }

    public static DialogPermissionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPermissionsBinding bind(View view, Object obj) {
        return (DialogPermissionsBinding) bind(obj, view, R.layout.dialog_permissions);
    }
}
