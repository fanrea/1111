package com.bytedance.rpc;

import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.serialize.SerializeType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RpcMethod.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class h {
    private Method a;
    private Class b;
    private int c = -1;
    private int d;
    private Annotation[][] e;
    private Annotation[] f;
    private String g;
    private String h;
    private boolean i;
    private boolean j;
    private String[] k;
    private SerializeType l;
    private Type m;

    h(Class cls, Method method) {
        this.a = method;
        this.b = cls;
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        int length = genericParameterTypes == null ? 0 : genericParameterTypes.length;
        this.d = length;
        a(genericParameterTypes, length);
    }

    public String a() {
        if (this.f == null) {
            k();
        }
        String str = this.g;
        return str == null ? "" : str;
    }

    public String b() {
        if (this.f == null) {
            k();
        }
        String str = this.h;
        return str == null ? "" : str;
    }

    public boolean c() {
        if (this.f == null) {
            k();
        }
        return this.j;
    }

    public String[] d() {
        return this.k;
    }

    public SerializeType e() {
        if (this.f == null) {
            k();
        }
        SerializeType serializeType = this.l;
        return serializeType == null ? SerializeType.JSON : serializeType;
    }

    public Method f() {
        return this.a;
    }

    public Class g() {
        return this.b;
    }

    public Type h() {
        return this.a.getGenericReturnType();
    }

    public boolean i() {
        return this.c >= 0;
    }

    public Annotation[][] j() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    Annotation[][] parameterAnnotations = this.a.getParameterAnnotations();
                    int i = this.c;
                    if (i < 0 || parameterAnnotations == null || parameterAnnotations.length < this.d) {
                        if (parameterAnnotations == null) {
                            parameterAnnotations = new Annotation[0][];
                        }
                        this.e = parameterAnnotations;
                    } else {
                        Annotation[][] annotationArr = new Annotation[parameterAnnotations.length - 1][];
                        this.e = annotationArr;
                        a(parameterAnnotations, annotationArr, i);
                    }
                }
            }
        }
        return this.e;
    }

    public Annotation[] k() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    a(this.a);
                    Annotation[] annotations = this.a.getAnnotations();
                    if (annotations != null && annotations.length > 0) {
                        List<Annotation> listA = a(annotations);
                        if (listA.size() > 0) {
                            this.f = (Annotation[]) listA.toArray(new Annotation[listA.size()]);
                        }
                    }
                    if (this.f == null) {
                        this.f = new Annotation[0];
                    }
                }
            }
        }
        return this.f;
    }

    private List<Annotation> a(Annotation[] annotationArr) {
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            if (clsAnnotationType != com.bytedance.rpc.annotation.f.class && clsAnnotationType != com.bytedance.rpc.annotation.g.class && clsAnnotationType != com.bytedance.rpc.annotation.h.class && clsAnnotationType != com.bytedance.rpc.annotation.a.class) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    private void a(Method method) {
        com.bytedance.rpc.annotation.f fVar = (com.bytedance.rpc.annotation.f) method.getAnnotation(com.bytedance.rpc.annotation.f.class);
        com.bytedance.rpc.annotation.j jVar = (com.bytedance.rpc.annotation.j) method.getAnnotation(com.bytedance.rpc.annotation.j.class);
        com.bytedance.rpc.annotation.h hVar = (com.bytedance.rpc.annotation.h) method.getAnnotation(com.bytedance.rpc.annotation.h.class);
        com.bytedance.rpc.annotation.g gVar = (com.bytedance.rpc.annotation.g) method.getAnnotation(com.bytedance.rpc.annotation.g.class);
        com.bytedance.rpc.annotation.a aVar = (com.bytedance.rpc.annotation.a) method.getAnnotation(com.bytedance.rpc.annotation.a.class);
        boolean zB = gVar == null ? true : gVar.b();
        SerializeType serializeTypeA = gVar == null ? SerializeType.JSON : gVar.a();
        String[] strArrC = gVar == null ? com.bytedance.sdk.djx.proguard3.c.d.a : gVar.c();
        if (aVar != null) {
            strArrC = aVar.a();
        }
        this.k = strArrC;
        if (hVar != null) {
            zB = hVar.a();
        }
        this.j = zB;
        if (jVar != null) {
            serializeTypeA = jVar.a();
        }
        this.l = serializeTypeA;
        String strA = fVar == null ? "" : fVar.a();
        this.h = strA;
        if (com.bytedance.sdk.djx.proguard3.c.d.c(strA)) {
            throw new RuntimeException(String.format("%s#%s should use annotation with RpcOperation", this.b.getSimpleName(), method.getName()));
        }
        int iIndexOf = strA.indexOf(36) + 1;
        int iIndexOf2 = strA.indexOf(32, iIndexOf);
        if (iIndexOf < 0 || iIndexOf2 <= iIndexOf) {
            return;
        }
        this.i = "POST".equalsIgnoreCase(strA.substring(iIndexOf, iIndexOf2).trim());
        this.g = strA.substring(iIndexOf2 + 1).trim();
    }

    private void a(Object[] objArr, Object[] objArr2, int i) {
        int length = objArr2.length;
        if (length > 0) {
            if (i != 0 && i != length) {
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(objArr, i + 1, objArr2, i, length - i);
            } else if (i > 0) {
                System.arraycopy(objArr, 0, objArr2, 0, length);
            } else {
                System.arraycopy(objArr, 1, objArr2, 0, length);
            }
        }
    }

    private void a(Type[] typeArr, int i) {
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                Type type = typeArr[i2];
                if (type instanceof Class) {
                    if (RpcCallback.class.isAssignableFrom((Class) type)) {
                        this.c = i2;
                        this.m = type;
                        return;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    if ((rawType instanceof Class) && RpcCallback.class.isAssignableFrom((Class) rawType)) {
                        this.c = i2;
                        this.m = type;
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public j a(f fVar, Object[] objArr) {
        RpcCallback rpcCallback;
        int i = this.c;
        if (i < 0 || objArr == null || objArr.length < this.d) {
            rpcCallback = null;
        } else {
            RpcCallback rpcCallback2 = (RpcCallback) objArr[i];
            Object[] objArr2 = new Object[objArr.length - 1];
            a(objArr, objArr2, i);
            rpcCallback = rpcCallback2;
            objArr = objArr2;
        }
        if (objArr == null) {
            objArr = com.bytedance.sdk.djx.proguard3.c.d.b;
        }
        return new j(fVar, this, objArr, rpcCallback, this.m);
    }
}
