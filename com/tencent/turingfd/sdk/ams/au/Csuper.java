package com.tencent.turingfd.sdk.ams.au;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.super, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Csuper implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ Window a;
    public final /* synthetic */ Cnew b;
    public final /* synthetic */ String c;

    public Csuper(Window window, Cnew cnew, String str) {
        this.a = window;
        this.b = cnew;
        this.c = str;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        Object objInvoke;
        Object objInvoke2;
        Object objA;
        try {
            View decorView = this.a.getDecorView();
            decorView.getViewTreeObserver().removeOnPreDrawListener(this);
            objInvoke = null;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                declaredMethod.setAccessible(true);
                objInvoke2 = declaredMethod.invoke(decorView, new Object[0]);
            } catch (Throwable unused) {
                objInvoke2 = null;
            }
        } catch (Throwable unused2) {
        }
        if (objInvoke2 == null) {
            return true;
        }
        try {
            Method methodA = Apricot.a(objInvoke2.getClass(), "getAccessibilityInteractionController", (Class<?>[]) null);
            if (methodA != null) {
                objInvoke = methodA.invoke(objInvoke2, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (objInvoke == null || (objA = Apricot.a(objInvoke.getClass(), "mHandler", objInvoke)) == null) {
            return true;
        }
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        Handler.Callback callback = (Handler.Callback) declaredField.get(objA);
        if (callback instanceof Cfor) {
            return true;
        }
        declaredField.set(objA, new Cfor(callback, this.b, this.c));
        return true;
    }
}
