package com.tencent.turingfd.sdk.ams.au;

import android.os.Handler;
import android.os.Message;
import com.tencent.turingfd.sdk.ams.au.Cthrow;
import java.lang.reflect.Method;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.for, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cfor implements Handler.Callback {
    public final Handler.Callback a;
    public final Cnew b;
    public final String c;

    public Cfor(Handler.Callback callback, Cnew cnew, String str) {
        this.a = callback;
        this.b = cnew;
        this.c = str;
    }

    public final boolean a(Message message) {
        Object objA;
        Object obj = message.obj;
        if (obj == null) {
            return false;
        }
        Object objA2 = Apricot.a(obj.getClass(), "argi3", message.obj);
        if (!(objA2 instanceof Integer) || (objA = Apricot.a(message.obj.getClass(), "arg1", message.obj)) == null) {
            return false;
        }
        Class<?> cls = objA.getClass();
        Class[] clsArr = {Boolean.TYPE, Integer.TYPE};
        Object[] objArr = {Boolean.FALSE, objA2};
        try {
            Method methodA = Apricot.a(cls, "setPerformAccessibilityActionResult", (Class<?>[]) clsArr);
            if (methodA != null) {
                methodA.invoke(objA, objArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            if (message.what == 1) {
                Cnew cnew = this.b;
                String str = this.c;
                Cthrow.Cdo cdo = (Cthrow.Cdo) cnew;
                if (!cdo.a.get()) {
                    cdo.b.obtainMessage(1, str).sendToTarget();
                }
                if (Cinterface.a.get() && a(message)) {
                    return true;
                }
            }
            Handler.Callback callback = this.a;
            if (callback != null) {
                return callback.handleMessage(message);
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
