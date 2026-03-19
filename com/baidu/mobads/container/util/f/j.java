package com.baidu.mobads.container.util.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import dalvik.system.InMemoryDexClassLoader;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements ServiceConnection {
    final /* synthetic */ Context a;

    j(Context context) {
        this.a = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Class clsLoadClass;
        z.a(this.a, "hw-connect", "");
        try {
            clsLoadClass = Class.forName(com.alipay.sdk.m.c.b.a);
        } catch (Throwable th) {
            z.a(this.a, "hw-serror" + th.getMessage(), "");
            clsLoadClass = null;
        }
        if (clsLoadClass == null) {
            try {
                if (com.baidu.mobads.container.util.x.a(this.a).a() >= 26) {
                    clsLoadClass = new InMemoryDexClassLoader(ByteBuffer.wrap(i.a), getClass().getClassLoader()).loadClass(com.alipay.sdk.m.c.b.a);
                }
            } catch (Throwable th2) {
                z.a(this.a, "hw-serror1" + th2.getMessage(), "");
            }
        }
        if (clsLoadClass != null) {
            try {
                Class<?> cls = null;
                for (Class<?> cls2 : clsLoadClass.getDeclaredClasses()) {
                    if (cls2.getSimpleName().equals("Stub")) {
                        cls = cls2;
                    }
                }
                if (cls != null) {
                    Object objInvoke = cls.getMethod("asInterface", IBinder.class).invoke(null, iBinder);
                    Method method = objInvoke.getClass().getMethod("getOaid", new Class[0]);
                    Method method2 = objInvoke.getClass().getMethod("isOaidTrackLimited", new Class[0]);
                    String str = (String) method.invoke(objInvoke, new Object[0]);
                    if (!TextUtils.isEmpty(str)) {
                        z.a(str);
                        z.a(this.a, "hw-valid", str);
                        z.a(2592000000L, str);
                    } else {
                        z.a(this.a, "hw-empty", "");
                    }
                    if (!"huawei".equalsIgnoreCase(com.baidu.mobads.container.util.x.a(this.a).e()) && !"honor".equalsIgnoreCase(com.baidu.mobads.container.util.x.a(this.a).e())) {
                        z.a(this.a, "huawei");
                    }
                    boolean unused = i.b = ((Boolean) method2.invoke(objInvoke, new Object[0])).booleanValue();
                }
            } catch (Throwable th3) {
                z.a(this.a, "hw-error" + th3.getMessage(), "");
            }
        }
        try {
            this.a.unbindService(this);
        } catch (Throwable th4) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
