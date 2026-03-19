package com.bytedance.sdk.component.b.hc.d.h;

import com.bytedance.sdk.component.b.hc.np;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class b extends u {
    private final Method b;
    private final Class<?> c;
    private final Method d;
    private final Method hc;
    private final Class<?> u;

    b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.d = method;
        this.hc = method2;
        this.b = method3;
        this.c = cls;
        this.u = cls2;
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public void d(SSLSocket sSLSocket, String str, List<np> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.d.invoke(null, sSLSocket, Proxy.newProxyInstance(u.class.getClassLoader(), new Class[]{this.c, this.u}, new d(d(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public void hc(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.b.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public String d(SSLSocket sSLSocket) {
        try {
            d dVar = (d) Proxy.getInvocationHandler(this.hc.invoke(null, sSLSocket));
            if (!dVar.d && dVar.hc == null) {
                hc().d(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (dVar.d) {
                return null;
            }
            return dVar.hc;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to get selected protocol", (Exception) e);
        }
    }

    public static u d() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            return new b(cls.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    private static class d implements InvocationHandler {
        private final List<String> b;
        boolean d;
        String hc;

        d(List<String> list) {
            this.b = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.component.b.hc.d.b.hc;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.d = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.b;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.b.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.hc = str;
                            return str;
                        }
                    }
                    String str2 = this.b.get(0);
                    this.hc = str2;
                    return str2;
                }
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.hc = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
