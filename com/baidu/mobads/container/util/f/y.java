package com.baidu.mobads.container.util.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.alipay.sdk.m.k0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements ServiceConnection {
    final /* synthetic */ Context a;

    y(Context context) {
        this.a = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName(a.AbstractBinderC0051a.a);
            } catch (Throwable th) {
                try {
                    z.a(this.a, "sam-serror" + th.getMessage(), "");
                    cls = null;
                } catch (Throwable th2) {
                    try {
                        z.a(this.a, "sam-error" + th2.getMessage(), "");
                        this.a.unbindService(this);
                        return;
                    } catch (Throwable th3) {
                        try {
                            this.a.unbindService(this);
                        } catch (Throwable th4) {
                        }
                        throw th3;
                    }
                }
            }
            if (cls != null) {
                try {
                    Class<?> cls2 = null;
                    for (Class<?> cls3 : cls.getDeclaredClasses()) {
                        if (cls3.getSimpleName().equals("Stub")) {
                            cls2 = cls3;
                        }
                    }
                    if (cls2 != null) {
                        Object objInvoke = cls2.getMethod("asInterface", IBinder.class).invoke(null, iBinder);
                        String str = (String) objInvoke.getClass().getMethod("getOAID", new Class[0]).invoke(objInvoke, new Object[0]);
                        if (!TextUtils.isEmpty(str)) {
                            z.a(str);
                            z.a(this.a, "sam-valid", str);
                            z.a(2592000000L, str);
                        } else {
                            z.a(this.a, "sam-empty", "");
                        }
                    }
                } catch (Throwable th5) {
                    z.a(this.a, "sam-error" + th5.getMessage(), "");
                }
            }
            this.a.unbindService(this);
        } catch (Throwable th6) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
