package com.bytedance.sdk.djx.core.toast;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class EmptyToast implements IToast {
    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void cancel() {
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public View getView() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setAnimation(int i) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setDuration(int i) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setGravity(int i) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setGravity(int i, int i2, int i3) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setPriority(int i) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setText(int i, String str) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setText(int i, String str, float f) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setView(View view) {
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void show() {
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void showLong() {
    }

    EmptyToast() {
    }
}
