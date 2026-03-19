package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.ir;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class s7 {
    static BaseNativeUnifiedAd a(String str, Context context, String str2, String str3, String str4) throws Exception {
        return (BaseNativeUnifiedAd) Class.forName(str).asSubclass(BaseNativeUnifiedAd.class).getDeclaredConstructor(Context.class, String.class, String.class, String.class).newInstance(context, str2, str3, str4);
    }

    /* compiled from: A */
    class a implements InvocationHandler {
        final /* synthetic */ Method a;
        final /* synthetic */ ir.c b;
        final /* synthetic */ NativeUnifiedADData c;

        a(Method method, ir.c cVar, NativeUnifiedADData nativeUnifiedADData) {
            this.a = method;
            this.b = cVar;
            this.c = nativeUnifiedADData;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.a.equals(method)) {
                this.b.a((ADListener) objArr[0]);
                return method.invoke(this.c, this.b);
            }
            return method.invoke(this.c, objArr);
        }
    }

    static NativeUnifiedADData a(NativeUnifiedADData nativeUnifiedADData, ir.c cVar) {
        if (!(nativeUnifiedADData instanceof ADEventListener)) {
            return nativeUnifiedADData;
        }
        try {
            return (NativeUnifiedADData) Proxy.newProxyInstance(NativeUnifiedADData.class.getClassLoader(), new Class[]{NativeUnifiedADData.class, ADEventListener.class}, new a(ADEventListener.class.getDeclaredMethod("setAdListener", ADListener.class), cVar, nativeUnifiedADData));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return nativeUnifiedADData;
        }
    }
}
