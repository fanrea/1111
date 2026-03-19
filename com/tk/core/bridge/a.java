package com.tk.core.bridge;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.tk.core.a.j;
import com.tk.core.bridge.IsolatePool;
import com.tk.core.manager.f;
import com.tk.core.o.t;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8ObjectProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private final V8 YK;
    private int YL;
    private String YM;
    private boolean YP;
    private final IsolatePool.b mIsolateRef;
    private volatile boolean YN = false;
    private final Map<String, V8ObjectProxy> YO = new HashMap();
    private boolean YQ = false;
    private IsolatePool.a YR = null;
    private int YS = 0;
    private int YT = 0;
    private long YU = 0;

    public static a b(boolean z, IsolatePool.b bVar, String str) {
        return new a(z, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[Catch: all -> 0x0052, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:6:0x0026, B:11:0x003d, B:12:0x0042, B:13:0x0047, B:17:0x004c, B:18:0x0051, B:8:0x002c, B:9:0x0031), top: B:24:0x0026, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private a(boolean r5, com.tk.core.bridge.IsolatePool.b r6) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r4.YN = r0
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r4.YO = r1
            r4.YP = r0
            r4.YQ = r0
            r1 = 0
            r4.YR = r1
            r4.YS = r0
            r4.YT = r0
            r1 = 0
            r4.YU = r1
            r4.YP = r5
            r4.mIsolateRef = r6
            r6 = 1
            if (r5 == 0) goto L55
            com.tk.core.bridge.IsolatePool$b r5 = r4.mIsolateRef
            monitor-enter(r5)
            boolean r1 = com.tk.core.o.ac.sX()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L31
            com.tk.core.bridge.IsolatePool$b r2 = r4.mIsolateRef     // Catch: java.lang.Throwable -> L49
            r2.an(r6)     // Catch: java.lang.Throwable -> L49
        L31:
            com.tk.core.bridge.IsolatePool$b r2 = r4.mIsolateRef     // Catch: java.lang.Throwable -> L49
            long r2 = r2.Yz     // Catch: java.lang.Throwable -> L49
            com.tk.core.bridge.c r6 = com.tk.core.bridge.c.a(r2, r6)     // Catch: java.lang.Throwable -> L49
            r4.YK = r6     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L42
            com.tk.core.bridge.IsolatePool$b r6 = r4.mIsolateRef     // Catch: java.lang.Throwable -> L52
            r6.an(r0)     // Catch: java.lang.Throwable -> L52
        L42:
            com.tkruntime.v8.V8 r6 = r4.YK     // Catch: java.lang.Throwable -> L52
            r4.b(r6)     // Catch: java.lang.Throwable -> L52
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L52
            goto L60
        L49:
            r6 = move-exception
            if (r1 == 0) goto L51
            com.tk.core.bridge.IsolatePool$b r1 = r4.mIsolateRef     // Catch: java.lang.Throwable -> L52
            r1.an(r0)     // Catch: java.lang.Throwable -> L52
        L51:
            throw r6     // Catch: java.lang.Throwable -> L52
        L52:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L52
            throw r6
        L55:
            com.tk.core.bridge.c r5 = com.tk.core.bridge.c.a(r1, r6)
            r4.YK = r5
            com.tkruntime.v8.V8 r5 = r4.YK
            r4.b(r5)
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.bridge.a.<init>(boolean, com.tk.core.bridge.IsolatePool$b):void");
    }

    public final IsolatePool.b getBindingIsolateRef() {
        return this.mIsolateRef;
    }

    private void b(V8 v8) {
        this.mIsolateRef.Yz = v8.getBindingIsolatePtr();
        this.mIsolateRef.Yy.incrementAndGet();
    }

    public final void dt(int i) {
        checkReleased();
        this.YL = i;
        this.YM = i + Config.replace + System.currentTimeMillis();
    }

    public final int pg() {
        return this.YL;
    }

    public final String ph() {
        return this.YM;
    }

    public final V8 pi() {
        checkReleased();
        return this.YK;
    }

    public final void destroy() {
        checkReleased();
        this.YN = true;
        this.YO.clear();
        f.st().destroy(this.YM);
        this.YK.close(false);
        IsolatePool.a aVar = this.YR;
        if (aVar != null) {
            IsolatePool.b.b(aVar);
        }
        this.mIsolateRef.a(this.YP, this.YK);
    }

    public final Object a(String str, String str2, int i, String str3, String str4, j jVar) {
        try {
            checkReleased();
            if (TextUtils.isEmpty(str3)) {
                jVar.failed(new Exception("empty bundle script"));
                return null;
            }
            String str5 = TextUtils.isEmpty(str4) ? "" : str4;
            if (!com.tk.core.a.oP().isReleaseMode() && this.YK != null) {
                com.tk.core.i.a.z("JSContext", "executeJS: " + str + ", " + str2 + ", " + str4);
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4) && str4.startsWith("[ad]")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append("[");
                    sb.append(UUID.randomUUID().toString());
                    sb.append("]");
                }
            }
            Object objA = a(str2, i, str3, str5, 0);
            jVar.success();
            return objA;
        } catch (Throwable th) {
            jVar.failed(th);
            com.tk.core.exception.a.b(th, this.YL);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object a(java.lang.String r9, int r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
            r8 = this;
            com.tk.core.d.c.rA()
            boolean r13 = android.text.TextUtils.isEmpty(r9)
            r0 = 0
            if (r13 != 0) goto L59
            com.tk.core.bridge.IsolatePool$b r13 = r8.mIsolateRef
            com.tk.core.bridge.IsolatePool$a r13 = r13.aZ(r9)
            r8.YR = r13
            com.tk.core.bridge.IsolatePool$a r13 = r8.YR
            if (r13 == 0) goto L59
            com.tk.core.bridge.IsolatePool$b r13 = r13.mIsolateRef
            long r2 = r13.Yz
            com.tkruntime.v8.V8 r13 = r8.YK
            long r4 = r13.getBindingIsolatePtr()
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 != 0) goto L31
            com.tk.core.bridge.IsolatePool$a r13 = r8.YR
            int r13 = r13.Yw
            if (r13 != r10) goto L31
            com.tk.core.bridge.IsolatePool$a r9 = r8.YR
            long r9 = r9.Yv
            r6 = r9
            goto L5a
        L31:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r2 = "compile isolate is not the same with evaluate Isolate, scriptId: "
            r13.<init>(r2)
            r13.append(r9)
            java.lang.String r9 = ", compileVersionCode: "
            r13.append(r9)
            com.tk.core.bridge.IsolatePool$a r9 = r8.YR
            int r9 = r9.Yw
            r13.append(r9)
            java.lang.String r9 = ", bundleVersionCode: "
            r13.append(r9)
            r13.append(r10)
            java.lang.String r9 = r13.toString()
            r10 = 0
            java.lang.String r13 = "JSContext"
            com.tk.core.i.a.a(r13, r9, r10)
        L59:
            r6 = r0
        L5a:
            r9 = 1
            r10 = 0
            int r13 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r13 == 0) goto L62
            r13 = 1
            goto L63
        L62:
            r13 = 0
        L63:
            r8.YQ = r13
            boolean r13 = r8.YQ
            if (r13 == 0) goto L6e
            com.tk.core.bridge.IsolatePool$a r13 = r8.YR
            com.tk.core.bridge.IsolatePool.b.a(r13)
        L6e:
            boolean r13 = com.tk.core.o.ac.sX()
            if (r13 == 0) goto L79
            com.tk.core.bridge.IsolatePool$b r0 = r8.mIsolateRef
            r0.an(r9)
        L79:
            com.tk.core.bridge.IsolatePool$b r9 = r8.mIsolateRef
            java.util.concurrent.CopyOnWriteArrayList<com.tk.core.bridge.IsolatePool$a> r9 = r9.YD
            int r9 = r9.size()
            r8.YS = r9
            com.tk.core.bridge.IsolatePool$b r9 = r8.mIsolateRef
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.tk.core.bridge.IsolatePool$a> r9 = r9.YC
            int r9 = r9.size()
            r8.YT = r9
            com.tk.core.bridge.IsolatePool$b r9 = r8.mIsolateRef
            java.util.concurrent.atomic.AtomicLong r9 = r9.YG
            long r0 = r9.get()
            r8.YU = r0
            com.tkruntime.v8.V8 r2 = r8.YK     // Catch: java.lang.Throwable -> La8
            r5 = 0
            r3 = r11
            r4 = r12
            java.lang.Object r9 = r2.executeScript(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La8
            if (r13 == 0) goto La7
            com.tk.core.bridge.IsolatePool$b r11 = r8.mIsolateRef
            r11.an(r10)
        La7:
            return r9
        La8:
            r9 = move-exception
            if (r13 == 0) goto Lb0
            com.tk.core.bridge.IsolatePool$b r11 = r8.mIsolateRef
            r11.an(r10)
        Lb0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.bridge.a.a(java.lang.String, int, java.lang.String, java.lang.String, int):java.lang.Object");
    }

    public final void a(String str, V8ObjectProxy v8ObjectProxy) {
        checkReleased();
        if (this.YO.containsKey(str) && t.isDebug()) {
            throw new RuntimeException(str + " is already added in global js object.");
        }
        this.YO.put(str, v8ObjectProxy);
    }

    public final V8ObjectProxy ba(String str) {
        checkReleased();
        return this.YO.get(str);
    }

    public final void checkReleased() {
        if (this.YN) {
            throw new RuntimeException("JSContext is already destroy().");
        }
    }

    public final boolean isReleased() {
        return this.YN;
    }

    public final boolean isCompile() {
        return this.YQ;
    }

    public final int getRepetitionCompileCount() {
        return this.YS;
    }

    public final int getTotalCompileCount() {
        return this.YT;
    }

    public final long getTotalCompileSize() {
        return this.YU;
    }
}
