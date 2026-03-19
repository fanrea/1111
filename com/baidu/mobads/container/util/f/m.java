package com.baidu.mobads.container.util.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.alipay.sdk.m.q0.a;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m implements ServiceConnection {
    final /* synthetic */ Context a;

    m(Context context) {
        this.a = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Method method;
        try {
            Class<?> cls = Class.forName(a.AbstractBinderC0056a.a);
            if (cls != null) {
                Class<?> cls2 = null;
                for (Class<?> cls3 : cls.getDeclaredClasses()) {
                    if (cls3.getSimpleName().equals("Stub")) {
                        cls2 = cls3;
                    }
                }
                if (cls2 != null && (method = cls2.getMethod("asInterface", IBinder.class)) != null) {
                    Object objInvoke = method.invoke(null, iBinder);
                    Method method2 = cls.getMethod("a", new Class[0]);
                    if (objInvoke != null && method2 != null) {
                        String str = (String) method2.invoke(objInvoke, new Object[0]);
                        if (TextUtils.isEmpty(str)) {
                            z.a(this.a, "lenove-empty", "");
                        } else {
                            z.a(str);
                            z.a(2592000000L, str);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            z.a(this.a, "lenove-error" + th.getMessage(), "");
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
