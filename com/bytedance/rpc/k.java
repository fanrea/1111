package com.bytedance.rpc;

import android.app.Application;
import com.bytedance.rpc.RpcConfig;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.log.LogLevel;
import com.bytedance.rpc.serialize.SerializeType;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RpcService.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k {
    private static volatile c a;
    private static volatile g b;
    private static Map<Class<?>, f> c = new HashMap(4);

    public static void a(Application application, RpcConfig rpcConfig) {
        if (application == null || rpcConfig == null) {
            throw new RuntimeException("parameters of RpcService.init should not be null ");
        }
        if (com.bytedance.rpc.log.d.b()) {
            com.bytedance.rpc.log.d.a((CharSequence) String.format("rpc: init config=%s", rpcConfig));
        }
        if (a == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new c(application, rpcConfig);
                    b = new g(a);
                }
            }
        }
    }

    public static boolean a() {
        return a != null;
    }

    public static synchronized <T> T a(Class<T> cls) {
        f();
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new e(cls, b, a((Object) cls)));
    }

    public static c b() {
        f();
        return a;
    }

    public static f a(Object obj) {
        f fVarE;
        if (obj instanceof Class) {
            synchronized (c) {
                fVarE = c.get(obj);
                if (fVarE == null) {
                    f();
                    fVarE = e();
                    c.put((Class) obj, fVarE);
                }
            }
            return fVarE;
        }
        if (!Proxy.isProxyClass(obj.getClass())) {
            throw new IllegalArgumentException(obj.getClass().getName() + " class is not a proxy class ");
        }
        return ((e) Proxy.getInvocationHandler(obj)).a();
    }

    public static void a(RpcInterceptor rpcInterceptor, Class<?>... clsArr) {
        if (rpcInterceptor != null) {
            if (clsArr == null || clsArr.length == 0) {
                a.a(rpcInterceptor);
                return;
            }
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    a((Object) cls).a(rpcInterceptor);
                }
            }
        }
    }

    public static void b(RpcInterceptor rpcInterceptor, Class<?>... clsArr) {
        if (rpcInterceptor != null) {
            f();
            if (clsArr == null || clsArr.length == 0) {
                a.b(rpcInterceptor);
                return;
            }
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    a((Object) cls).b(rpcInterceptor);
                }
            }
        }
    }

    public static void a(com.bytedance.sdk.djx.proguard3.d.j jVar) {
        if (jVar != null) {
            a.a(jVar);
        }
    }

    public static void a(RpcInvokeInterceptor rpcInvokeInterceptor) {
        if (rpcInvokeInterceptor != null) {
            a.a(rpcInvokeInterceptor);
        }
    }

    public static void a(com.bytedance.sdk.djx.proguard3.d.c cVar) {
        f();
        b.a(cVar);
    }

    public static void a(com.bytedance.rpc.serialize.f fVar) {
        f();
        b.a(fVar);
    }

    public static void a(SerializeType serializeType) {
        if (b != null) {
            b.a(serializeType);
        }
    }

    public static RpcConfig.a c() {
        if (a == null) {
            return new RpcConfig.a();
        }
        return a.b().toBuilder();
    }

    public static a d() {
        return b.a();
    }

    public static void a(LogLevel logLevel) {
        com.bytedance.rpc.log.d.a(logLevel);
    }

    private static f e() {
        return new f(a);
    }

    private static void f() {
        if (a == null) {
            throw new RuntimeException("had you called RpcService.init(Application,RpcConfig)");
        }
    }
}
