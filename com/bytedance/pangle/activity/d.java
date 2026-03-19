package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements View.OnClickListener {
    private final int b;
    private Method c;
    private final Activity d;
    private final String hc;

    public d(Activity activity, int i, String str) {
        this.d = activity;
        this.hc = str;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.c == null) {
            d(this.d, this.hc);
        }
        try {
            this.c.invoke(this.d, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }

    private void d(Activity activity, String str) throws NoSuchMethodException, SecurityException {
        try {
            Method method = activity.getClass().getMethod(this.hc, View.class);
            if (method != null) {
                this.c = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.hc + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.b);
    }
}
