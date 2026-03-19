package com.netease.htprotect.p00700oOOo;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

/* renamed from: com.netease.htprotect.〇00oOOo.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final Window f209O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final o0o0 f210O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final String f211Ooo;

    public O8(Window window, String str, o0o0 o0o0Var) {
        this.f209O8oO888 = window;
        this.f211Ooo = str;
        this.f210O8 = o0o0Var;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m633O8oO888(View view) {
        O8oO888.m629O8oO888(view, this.f210O8, this.f211Ooo);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        try {
            View decorView = this.f209O8oO888.getDecorView();
            decorView.getViewTreeObserver().removeOnPreDrawListener(this);
            O8oO888.m629O8oO888(decorView, this.f210O8, this.f211Ooo);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
