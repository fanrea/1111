package com.bytedance.rpc;

import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.bytedance.rpc.b;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.sdk.djx.proguard3.c.g;
import com.bytedance.sdk.djx.proguard3.d.i;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RpcInvoker.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class g implements b.a, g.a {
    private static final ThreadLocal<Object> a = new ThreadLocal<>();
    private static final ThreadLocal<Object> b = new ThreadLocal<>();
    private static final ThreadLocal<RpcRequestModifier> c = new ThreadLocal() { // from class: com.bytedance.rpc.g.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RpcRequestModifier initialValue() {
            return new RpcRequestModifier(null);
        }
    };
    private static final ThreadLocal<a> d = new ThreadLocal() { // from class: com.bytedance.rpc.g.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a initialValue() {
            return new a();
        }
    };
    private final Map<Integer, i> e = new ConcurrentHashMap();
    private final com.bytedance.sdk.djx.proguard3.c.g f;
    private final com.bytedance.sdk.djx.proguard3.c.g g;
    private final com.bytedance.sdk.djx.proguard3.d.e h;
    private final com.bytedance.rpc.serialize.h i;

    public g(c cVar) {
        HandlerThread handlerThread = new HandlerThread("RpcSerialize");
        handlerThread.start();
        this.i = new com.bytedance.rpc.serialize.h();
        this.h = new com.bytedance.sdk.djx.proguard3.d.e(cVar);
        this.f = new com.bytedance.sdk.djx.proguard3.c.g(Looper.getMainLooper(), this);
        this.g = new com.bytedance.sdk.djx.proguard3.c.g(handlerThread.getLooper(), this);
    }

    public i a(int i) {
        return this.e.get(Integer.valueOf(i));
    }

    a a() {
        return d.get();
    }

    boolean b(int i) {
        i iVarA = a(i);
        return (iVarA == null || iVarA.f() == null || iVarA.a()) ? false : true;
    }

    void a(com.bytedance.rpc.serialize.f fVar) {
        this.i.a(fVar);
    }

    void a(SerializeType serializeType) {
        this.i.a(serializeType);
    }

    void a(com.bytedance.sdk.djx.proguard3.d.c cVar) {
        this.h.a(cVar);
    }

    private i d(j jVar) {
        int iA = jVar.a();
        a.set(Integer.valueOf(iA));
        i iVar = this.e.get(Integer.valueOf(iA));
        if (iVar == null) {
            iVar = new i(jVar);
            this.e.put(Integer.valueOf(iA), iVar);
            iVar.a(this.f, 1);
            ThreadLocal<a> threadLocal = d;
            if (threadLocal.get().a()) {
                jVar.a = threadLocal.get();
                threadLocal.remove();
            }
        } else {
            iVar.a(jVar);
        }
        return iVar;
    }

    Object a(j jVar) {
        if (com.bytedance.sdk.djx.proguard3.c.d.c(this.i.a())) {
            throw new RuntimeException(String.format("did you add any rpc-adapter in your dependence ,no serialize factory found", new Object[0]));
        }
        b bVar = null;
        RpcInvokeInterceptor[] rpcInvokeInterceptorArrF = jVar.f().f();
        if (rpcInvokeInterceptorArrF != null && rpcInvokeInterceptorArrF.length > 0) {
            for (RpcInvokeInterceptor rpcInvokeInterceptor : rpcInvokeInterceptorArrF) {
                try {
                    b bVarInvoke = rpcInvokeInterceptor.invoke(jVar.k(), jVar);
                    if (bVarInvoke != null) {
                        bVar = bVarInvoke;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return bVar == null ? b(jVar) : a(bVar, jVar);
    }

    private Object a(b bVar, j jVar) {
        d(jVar);
        return bVar.a(this, jVar);
    }

    public Object b(j jVar) {
        i iVarD = d(jVar);
        if (jVar.m()) {
            this.g.obtainMessage(2, jVar.a(), 0).sendToTarget();
            return null;
        }
        return a(iVarD, jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.Object a(com.bytedance.rpc.i r8, com.bytedance.rpc.j r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8e
            java.lang.Thread r3 = r3.getThread()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8e
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8e
            if (r3 == r4) goto L84
            java.lang.String r3 = "serialize"
            com.bytedance.sdk.djx.proguard3.d.f r4 = r7.c(r9)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            r8.a(r4)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            boolean r4 = r8.a()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            if (r4 != 0) goto L7d
            java.lang.String r3 = "transport"
        L22:
            com.bytedance.sdk.djx.proguard3.d.h r1 = r7.c(r8)     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r8.a()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            if (r4 != 0) goto L49
            java.lang.String r3 = "deserialize"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            r8.b = r4     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            java.lang.Object r0 = r7.a(r9, r1)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            java.util.Map<java.lang.Integer, com.bytedance.rpc.i> r1 = r7.e
            int r9 = r9.a()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1.remove(r9)
            r8.k()
            return r0
        L49:
            com.bytedance.rpc.RpcException r4 = r8.h()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            throw r4     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
        L4e:
            r4 = move-exception
            boolean r5 = r8.a()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            if (r5 != 0) goto L78
            int r5 = r9.a()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            com.bytedance.rpc.RpcException$a r4 = com.bytedance.rpc.RpcException.from(r4)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            com.bytedance.rpc.RpcException$a r4 = r4.a(r3)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            com.bytedance.rpc.RpcException$a r4 = r4.a(r5)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            com.bytedance.rpc.RpcException r4 = r4.a()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            r8.a(r4)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            boolean r4 = r7.a(r8, r5, r2)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            if (r4 == 0) goto L73
            goto L22
        L73:
            com.bytedance.rpc.RpcException r4 = r8.h()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            throw r4     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
        L78:
            com.bytedance.rpc.RpcException r4 = r8.h()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            throw r4     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
        L7d:
            com.bytedance.rpc.RpcException r4 = r8.h()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
            throw r4     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8c
        L82:
            r4 = move-exception
            goto L90
        L84:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8e
            java.lang.String r4 = "should not call client method in the UI thread!"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8e
            throw r3     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8e
        L8c:
            r1 = move-exception
            goto Ld2
        L8e:
            r4 = move-exception
            r3 = r1
        L90:
            com.bytedance.rpc.RpcException$a r5 = com.bytedance.rpc.RpcException.from(r4)     // Catch: java.lang.Throwable -> L8c
            int r6 = r9.a()     // Catch: java.lang.Throwable -> L8c
            com.bytedance.rpc.RpcException$a r5 = r5.a(r6)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto La3
            java.lang.Class<com.bytedance.sdk.djx.proguard3.d.h> r6 = com.bytedance.sdk.djx.proguard3.d.h.class
            r5.a(r6, r1)     // Catch: java.lang.Throwable -> L8c
        La3:
            boolean r1 = r4 instanceof com.bytedance.rpc.RpcException     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto Lbb
            com.bytedance.rpc.RpcException r4 = (com.bytedance.rpc.RpcException) r4     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = r4.getResource()     // Catch: java.lang.Throwable -> L8c
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto Lb6
            r5.a(r3)     // Catch: java.lang.Throwable -> L8c
        Lb6:
            com.bytedance.rpc.RpcException r1 = r5.a(r4)     // Catch: java.lang.Throwable -> L8c
            goto Lc3
        Lbb:
            com.bytedance.rpc.RpcException$a r1 = r5.a(r3)     // Catch: java.lang.Throwable -> L8c
            com.bytedance.rpc.RpcException r1 = r1.a()     // Catch: java.lang.Throwable -> L8c
        Lc3:
            boolean r3 = r8.a()     // Catch: java.lang.Throwable -> L8c
            if (r3 != 0) goto Ld1
            r7.a(r1, r0, r2)     // Catch: java.lang.Throwable -> Lce
            r0 = r2
            goto Ld1
        Lce:
            r1 = move-exception
            r0 = r2
            goto Ld2
        Ld1:
            throw r1     // Catch: java.lang.Throwable -> L8c
        Ld2:
            if (r0 == 0) goto Le4
            java.util.Map<java.lang.Integer, com.bytedance.rpc.i> r0 = r7.e
            int r9 = r9.a()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r0.remove(r9)
            r8.k()
        Le4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.rpc.g.a(com.bytedance.rpc.i, com.bytedance.rpc.j):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.bytedance.sdk.djx.proguard3.d.f c(com.bytedance.rpc.j r17) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.rpc.g.c(com.bytedance.rpc.j):com.bytedance.sdk.djx.proguard3.d.f");
    }

    private boolean a(Object obj) {
        return Build.VERSION.SDK_INT < 24 || obj.getClass().getAnnotationsByType(com.bytedance.rpc.annotation.d.class) == null;
    }

    void a(i iVar) {
        j jVarF = iVar.f();
        try {
            iVar.a(c(jVarF));
            this.g.obtainMessage(3, jVarF.a(), 0).sendToTarget();
        } catch (Exception e) {
            a(RpcException.from(e).a(jVarF.a()).a("serialize").a(), true, true);
        }
    }

    com.bytedance.sdk.djx.proguard3.d.f b(i iVar) {
        com.bytedance.sdk.djx.proguard3.d.f fVarG = iVar.g();
        com.bytedance.sdk.djx.proguard3.d.g[] gVarArrD = iVar.f().f().d();
        if (gVarArrD != null && gVarArrD.length > 0) {
            for (com.bytedance.sdk.djx.proguard3.d.g gVar : gVarArrD) {
                com.bytedance.sdk.djx.proguard3.d.f fVarA = gVar.a(fVarG);
                if (fVarA != null) {
                    fVarG = fVarA;
                }
            }
        }
        return fVarG;
    }

    void a(i iVar, Object obj, com.bytedance.sdk.djx.proguard3.d.h hVar) {
        j jVarF = iVar.f();
        if (jVarF == null) {
            return;
        }
        if (hVar == null && (obj instanceof RpcException)) {
            hVar = (com.bytedance.sdk.djx.proguard3.d.h) ((RpcException) obj).getTag(com.bytedance.sdk.djx.proguard3.d.h.class);
        }
        if (com.bytedance.rpc.log.d.b()) {
            int iA = jVarF.a();
            String str = hVar == null ? String.format("rpc: result (requestId=%d,error=%s)", Integer.valueOf(iA), obj) : String.format("rpc: result (requestId=%d,code=%d,msg=%s,data=%s,headers=%s)", Integer.valueOf(iA), Integer.valueOf(hVar.d()), hVar.e(), obj, hVar.c());
            if (obj instanceof RpcException) {
                com.bytedance.rpc.log.d.b(str);
            } else {
                com.bytedance.rpc.log.d.a((CharSequence) str);
            }
        }
        com.bytedance.sdk.djx.proguard3.d.j[] jVarArrE = jVarF.f().e();
        if (jVarArrE == null || jVarArrE.length <= 0) {
            return;
        }
        i.a aVar = new i.a();
        aVar.setResult(obj);
        aVar.a(jVarF.a());
        aVar.a(iVar.b());
        aVar.b(iVar.c());
        aVar.c(iVar.d());
        aVar.d(iVar.e());
        if (hVar != null) {
            aVar.b(hVar.d());
            aVar.a(hVar.e());
            aVar.a(hVar.c());
            aVar.b(hVar.a());
            aVar.e(hVar.b());
        }
        com.bytedance.sdk.djx.proguard3.d.i iVarA = aVar.a();
        com.bytedance.sdk.djx.proguard3.d.f fVarG = iVar.g();
        if (fVarG == null) {
            fVarG = com.bytedance.sdk.djx.proguard3.d.f.a(jVarF.a()).a();
        }
        for (com.bytedance.sdk.djx.proguard3.d.j jVar : jVarArrE) {
            try {
                jVar.a(iVarA, fVarG);
            } catch (Throwable th) {
                if (com.bytedance.rpc.log.d.c()) {
                    th.printStackTrace();
                }
            }
        }
    }

    com.bytedance.sdk.djx.proguard3.d.h c(i iVar) throws Exception {
        return this.h.b(iVar).a(b(iVar));
    }

    void d(final i iVar) {
        com.bytedance.sdk.djx.proguard3.d.b bVarB = this.h.b(iVar);
        final int iA = iVar.f().a();
        try {
            bVarB.a(b(iVar), new com.bytedance.sdk.djx.proguard3.d.a() { // from class: com.bytedance.rpc.g.3
                public void a(com.bytedance.sdk.djx.proguard3.d.h hVar) {
                    iVar.j();
                    iVar.b = System.currentTimeMillis();
                    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        g.this.g.obtainMessage(4, iA, 0, hVar).sendToTarget();
                        return;
                    }
                    j jVarF = iVar.f();
                    try {
                        g.this.f.obtainMessage(5, jVarF.a(), 0, g.this.a(jVarF, hVar)).sendToTarget();
                    } catch (Exception e) {
                        g.this.a(RpcException.from(e).a(jVarF.a()).a("deserialize").a(com.bytedance.sdk.djx.proguard3.d.h.class, hVar).a(), true, true);
                    }
                }

                public void a(Throwable th) {
                    g.this.a(RpcException.from(th).a(iA).a(), false, true);
                }
            });
        } catch (Exception e) {
            a(RpcException.from(e).a(iA).a(NotificationCompat.CATEGORY_TRANSPORT).a(), false, true);
        }
    }

    Object a(j jVar, com.bytedance.sdk.djx.proguard3.d.h hVar) throws Exception {
        Object objA;
        if (!hVar.g()) {
            if (hVar.f() != null) {
                com.bytedance.sdk.djx.proguard3.c.d.a(hVar.f().c());
            }
            throw RpcException.fromHttp(hVar.d(), hVar.e()).a(NotificationCompat.CATEGORY_TRANSPORT).a(jVar.a()).a();
        }
        if (hVar.f() == null) {
            throw RpcException.fromNew(987654326, "response body is null").a(NotificationCompat.CATEGORY_TRANSPORT).a(jVar.a()).a();
        }
        Type typeL = jVar.l();
        String strA = hVar.a();
        SerializeType serializeTypeA = this.i.a(strA, typeL, (SerializeType) null);
        boolean zIsReflectSupported = false;
        if (typeL == InputStream.class) {
            objA = hVar.f().c();
        } else if (com.bytedance.sdk.djx.proguard3.c.f.a(typeL)) {
            objA = com.bytedance.sdk.djx.proguard3.c.d.a(hVar.f().c());
        } else {
            com.bytedance.rpc.serialize.f fVarB = this.i.b(serializeTypeA);
            com.bytedance.rpc.serialize.d deserializer = fVarB != null ? fVarB.getDeserializer(hVar.f(), typeL) : null;
            if (deserializer == null) {
                if (hVar.f() != null) {
                    com.bytedance.sdk.djx.proguard3.c.d.a(hVar.f().c());
                }
                throw new RuntimeException(String.format("could not found Deserializer with mineType %s to handle %s", strA, typeL));
            }
            zIsReflectSupported = fVarB.isReflectSupported();
            objA = deserializer.a();
        }
        Map<String, String> mapC = hVar.c();
        if (objA != null && zIsReflectSupported && !(objA instanceof InputStream)) {
            com.bytedance.rpc.serialize.h.a(objA, mapC);
        }
        i iVarA = a(jVar.a());
        iVarA.c = System.currentTimeMillis();
        b.set(objA);
        Object objA2 = a(jVar, objA, mapC);
        if (objA2 != null) {
            objA = objA2;
        }
        a(iVarA, objA, hVar);
        return objA;
    }

    void a(i iVar, com.bytedance.sdk.djx.proguard3.d.h hVar) {
        j jVarF = iVar.f();
        try {
            this.f.obtainMessage(5, jVarF.a(), 0, a(jVarF, hVar)).sendToTarget();
        } catch (Exception e) {
            a(RpcException.from(e).a(jVarF.a()).a("deserialize").a(com.bytedance.sdk.djx.proguard3.d.h.class, hVar).a(), true, true);
        }
    }

    boolean a(i iVar, int i, boolean z) {
        boolean zA = this.h.a(iVar);
        if (zA && z) {
            this.g.obtainMessage(3, i, 0).sendToTarget();
        }
        return zA;
    }

    void a(f fVar, j jVar, RpcRequestModifier rpcRequestModifier) throws Exception {
        RpcInterceptor[] rpcInterceptorArrC = fVar.c();
        if (rpcInterceptorArrC.length > 0) {
            Class clsK = jVar.k();
            Method methodH = jVar.h();
            Object[] objArrI = jVar.i();
            String strC = jVar.c();
            int iA = jVar.a();
            for (RpcInterceptor rpcInterceptor : rpcInterceptorArrC) {
                if (!rpcInterceptor.preHandle(clsK, methodH, objArrI, rpcRequestModifier, strC)) {
                    a(iA, "preHandle");
                    return;
                }
            }
        }
    }

    Object a(j jVar, Object obj, Map<String, String> map) throws Exception {
        RpcInterceptor[] rpcInterceptorArrC = jVar.f().c();
        if (rpcInterceptorArrC.length > 0) {
            Class clsK = jVar.k();
            Method methodH = jVar.h();
            ThreadLocal<Object> threadLocal = b;
            String strC = jVar.c();
            int iA = jVar.a();
            for (RpcInterceptor rpcInterceptor : rpcInterceptorArrC) {
                if (!rpcInterceptor.postHandle(clsK, methodH, obj, threadLocal, map, strC)) {
                    a(iA, "postHandle");
                    break;
                }
            }
        }
        return b.get();
    }

    void a(j jVar, RpcException rpcException) {
        if (com.bytedance.rpc.log.d.c()) {
            com.bytedance.rpc.log.d.b(String.format("rpc: exception exception=%s,request=%s", rpcException, jVar));
        }
        RpcInterceptor[] rpcInterceptorArrC = jVar.f().c();
        if (rpcInterceptorArrC.length > 0) {
            Class clsK = jVar.k();
            Method methodH = jVar.h();
            String strC = jVar.c();
            for (RpcInterceptor rpcInterceptor : rpcInterceptorArrC) {
                rpcInterceptor.exceptionHandle(clsK, methodH, rpcException, strC);
            }
        }
    }

    void a(int i, String str) {
        throw RpcException.from(new RuntimeException("this request intercepted by your RpcInterceptor")).b(987654325).a(i).a(str).a();
    }

    void a(int i, boolean z, Throwable th) {
        if (b(i)) {
            i iVarA = a(i);
            this.h.b(iVarA).a(i);
            int i2 = z ? 987654324 : 987654323;
            boolean zM = iVarA.f().m();
            iVarA.i();
            String str = z ? "请求超时" : "";
            if (th == null) {
                a(RpcException.fromNew(i2, str).a("cancel").a(i).a(), true, zM);
            } else {
                a(RpcException.from(th).a(i2, str).a("cancel").a(i).a(), true, zM);
            }
        }
    }

    void a(RpcException rpcException, boolean z, boolean z2) {
        int requestId = rpcException.getRequestId();
        i iVarA = a(requestId);
        if (iVarA != null) {
            iVarA.a(rpcException);
            if (z || iVarA.a() || !a(iVarA, requestId, z2)) {
                if ((z && (rpcException.isCanceled() || rpcException.isTimeout())) || !rpcException.isCanceled()) {
                    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        a(iVarA, rpcException);
                    } else {
                        this.f.obtainMessage(5, requestId, 0, rpcException).sendToTarget();
                    }
                }
            }
        }
    }

    void a(i iVar, Object obj) {
        j jVarF = iVar.f();
        if (jVarF != null) {
            try {
                RpcCallback rpcCallbackJ = jVarF.j();
                if (rpcCallbackJ == null || !jVarF.m()) {
                    if (obj instanceof RpcException) {
                        RpcException rpcException = (RpcException) obj;
                        iVar.c = System.currentTimeMillis();
                        a(jVarF, rpcException);
                        a(iVar, rpcException, (com.bytedance.sdk.djx.proguard3.d.h) null);
                    }
                } else if (rpcCallbackJ != null) {
                    if (obj instanceof RpcException) {
                        RpcException rpcException2 = (RpcException) obj;
                        iVar.c = System.currentTimeMillis();
                        rpcCallbackJ.onFailure(rpcException2);
                        a(jVarF, rpcException2);
                        a(iVar, rpcException2, (com.bytedance.sdk.djx.proguard3.d.h) null);
                    } else {
                        rpcCallbackJ.onSuccess(obj);
                    }
                }
            } finally {
                iVar.k();
                this.e.remove(Integer.valueOf(jVarF.a()));
            }
        }
    }

    public void a(Message message) {
        int i = message.what;
        int i2 = message.arg1;
        com.bytedance.sdk.djx.proguard3.c.g target = message.getTarget();
        i iVar = this.e.get(Integer.valueOf(message.arg1));
        if (iVar == null || target == null) {
            return;
        }
        if (this.g != target || iVar.a()) {
            if (this.f == target) {
                if (1 == i) {
                    a(i2, true, (Throwable) null);
                    return;
                } else {
                    if (5 == i) {
                        a(iVar, message.obj);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (2 == i) {
            a(iVar);
        } else if (3 == i) {
            d(iVar);
        } else if (4 == i) {
            a(iVar, (com.bytedance.sdk.djx.proguard3.d.h) message.obj);
        }
    }
}
