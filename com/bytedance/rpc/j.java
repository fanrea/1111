package com.bytedance.rpc;

import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.serialize.SerializeType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Map;

/* compiled from: RpcRequest.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class j {
    private static com.bytedance.sdk.djx.proguard3.c.c d = new com.bytedance.sdk.djx.proguard3.c.c(1, 999999999);
    a a;
    protected Type b;
    protected Type c;
    private f e;
    private h f;
    private Object[] g;
    private RpcCallback h;
    private int i = d.a();

    j(f fVar, h hVar, Object[] objArr, RpcCallback rpcCallback, Type type) {
        this.e = fVar;
        this.f = hVar;
        this.g = objArr;
        this.h = rpcCallback;
        this.c = com.bytedance.sdk.djx.proguard3.c.f.b(this.f.h());
        if (m()) {
            this.b = a(rpcCallback, type);
        } else {
            this.b = a(objArr, this.c);
        }
    }

    public int a() {
        return this.i;
    }

    public String b() {
        return this.f.a();
    }

    public String c() {
        return this.f.b();
    }

    public boolean d() {
        return this.f.c();
    }

    public SerializeType e() {
        return this.f.e();
    }

    public f f() {
        return this.e;
    }

    public h g() {
        return this.f;
    }

    public Method h() {
        return this.f.f();
    }

    public Object[] i() {
        return this.g;
    }

    public RpcCallback j() {
        return this.h;
    }

    public Class k() {
        return this.f.g();
    }

    public Type l() {
        return this.b;
    }

    public boolean m() {
        return this.f.i();
    }

    boolean a(Map<String, String> map, Map<String, String> map2) {
        String[] strArrD = this.f.d();
        int length = strArrD == null ? 0 : strArrD.length;
        if (length == 0) {
            return this.e.a(null, map, map2);
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.e.a(strArrD[i2], map, map2)) {
                i++;
            }
        }
        return i == length;
    }

    private Type a(Object[] objArr, Type type) {
        Type type2 = null;
        if (type == Object.class && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj instanceof Class) {
                    type2 = (Type) obj;
                }
            }
        }
        return type2 == null ? type : type2;
    }

    private Type a(RpcCallback rpcCallback, Type type) {
        Type[] actualTypeArguments;
        Type type2 = (!(type instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments()) == null || actualTypeArguments.length == 0) ? null : actualTypeArguments[0];
        if (!(type2 instanceof WildcardType)) {
            return type2;
        }
        Type[] genericInterfaces = rpcCallback != null ? rpcCallback.getClass().getGenericInterfaces() : null;
        if (genericInterfaces == null || genericInterfaces.length <= 0) {
            return type2;
        }
        Type type3 = genericInterfaces[0];
        return type3 instanceof ParameterizedType ? ((ParameterizedType) type3).getActualTypeArguments()[0] : type2;
    }
}
