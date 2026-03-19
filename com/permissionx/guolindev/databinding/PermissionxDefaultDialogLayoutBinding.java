package com.permissionx.guolindev.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.permissionx.guolindev.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PermissionxDefaultDialogLayoutBinding implements ViewBinding {
    public final TextView messageText;
    public final Button negativeBtn;
    public final LinearLayout negativeLayout;
    public final LinearLayout permissionsLayout;
    public final Button positiveBtn;
    public final LinearLayout positiveLayout;
    private final LinearLayout rootView;

    private PermissionxDefaultDialogLayoutBinding(LinearLayout linearLayout, TextView textView, Button button, LinearLayout linearLayout2, LinearLayout linearLayout3, Button button2, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.messageText = textView;
        this.negativeBtn = button;
        this.negativeLayout = linearLayout2;
        this.permissionsLayout = linearLayout3;
        this.positiveBtn = button2;
        this.positiveLayout = linearLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PermissionxDefaultDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PermissionxDefaultDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.permissionx_default_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PermissionxDefaultDialogLayoutBinding bind(View view) {
        int i = R.id.messageText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.negativeBtn;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.negativeLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.permissionsLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.positiveBtn;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            i = R.id.positiveLayout;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                return new PermissionxDefaultDialogLayoutBinding((LinearLayout) view, textView, button, linearLayout, linearLayout2, button2, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
