package com.netease.htprotect.p00700oOOo;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.netease.htprotect.〇00oOOo.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo implements Handler.Callback {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final Handler.Callback f212O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final String f213O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final o0o0 f214Ooo;

    public Ooo(Handler.Callback callback, o0o0 o0o0Var, String str) {
        this.f212O8oO888 = callback;
        this.f214Ooo = o0o0Var;
        this.f213O8 = str;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            int i = message.what;
            o0o0 o0o0Var = this.f214Ooo;
            if (o0o0Var != null && (i == 1 || i == 2 || i == 3 || i == 4)) {
                o0o0Var.mo634O8oO888(this.f213O8, i);
            }
        } catch (Throwable unused) {
        }
        Handler.Callback callback = this.f212O8oO888;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }
}
