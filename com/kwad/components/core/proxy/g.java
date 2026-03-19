package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class g extends AlertDialog {
    protected ViewGroup Eu;
    public Activity mActivity;
    protected final Context mContext;

    protected float dA() {
        return -1.0f;
    }

    protected ViewGroup dB() {
        return null;
    }

    protected abstract int getLayoutId();

    protected abstract void h(View view);

    protected boolean pg() {
        return false;
    }

    protected boolean si() {
        return true;
    }

    protected g(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = com.kwad.sdk.p.m.wrapContextIfNeed(activity);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.Eu = (ViewGroup) com.kwad.sdk.p.m.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.Eu = dB();
            }
            setContentView(this.Eu);
            setCanceledOnTouchOutside(pg());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (dA() != -1.0f) {
                attributes.dimAmount = dA();
            }
            getWindow().setAttributes(attributes);
            setCancelable(si());
            h(this.Eu);
        } catch (Throwable th) {
            if (com.kwad.sdk.l.UL().TQ()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                dismiss();
                return;
            }
            throw th;
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(i);
        this.Eu = (ViewGroup) com.kwad.sdk.p.m.inflate(this.mContext, i, null);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        T t = (T) this.Eu.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            com.kwad.sdk.p.m.z(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }
}
