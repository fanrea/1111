package com.qq.e.comm.plugin;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class sv implements oj {
    private static volatile int b = -1;
    private String a;

    private m6 a(hw hwVar, l6 l6Var) {
        return (m6) pro.getobjresult(com.baidu.mobads.container.util.bu.h, 0, this, hwVar, l6Var);
    }

    static /* synthetic */ m6 a(sv svVar, hw hwVar, l6 l6Var) {
        return (m6) pro.getobjresult(com.baidu.mobads.container.util.bu.i, 1, svVar, hwVar, l6Var);
    }

    static /* synthetic */ String a(sv svVar) {
        return (String) pro.getobjresult(530, 1, svVar);
    }

    private void a(aw awVar, l6 l6Var, int i) {
        pro.getVresult(531, 0, this, awVar, l6Var, Integer.valueOf(i));
    }

    static /* synthetic */ void a(sv svVar, aw awVar, l6 l6Var, int i) {
        pro.getVresult(532, 1, svVar, awVar, l6Var, Integer.valueOf(i));
    }

    static /* synthetic */ int b() {
        return pro.getIresult(533, 1, new Object[0]);
    }

    private String b(l6 l6Var) {
        return (String) pro.getobjresult(534, 0, this, l6Var);
    }

    private String b(l6 l6Var, String str) {
        return (String) pro.getobjresult(535, 0, this, l6Var, str);
    }

    private String c(l6 l6Var, String str) {
        return (String) pro.getobjresult(536, 0, this, l6Var, str);
    }

    private Future<m6> d(l6 l6Var, String str) {
        return (Future) pro.getobjresult(537, 0, this, l6Var, str);
    }

    protected String a(l6 l6Var, String str) {
        return (String) pro.getobjresult(538, 0, this, l6Var, str);
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        return pro.getZresult(539, 0, this, l6Var);
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) {
        return pro.getZresult(540, 0, this, l6Var, qsVar);
    }

    sv() {
    }

    /* compiled from: A */
    class a implements Future<m6> {
        private m6 a;
        final /* synthetic */ Future b;
        final /* synthetic */ l6 c;
        final /* synthetic */ aw d;

        a(Future future, l6 l6Var, aw awVar) {
            this.b = future;
            this.c = l6Var;
            this.d = awVar;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.b.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.b.isDone();
        }

        @Override // java.util.concurrent.Future
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m6 get() {
            return get(this.c.w, TimeUnit.SECONDS);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[Catch: all -> 0x0095, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x0091, B:31:0x0081, B:35:0x008e, B:34:0x008a, B:20:0x0049), top: B:43:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[Catch: all -> 0x0095, TryCatch #1 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x0091, B:31:0x0081, B:35:0x008e, B:34:0x008a, B:20:0x0049), top: B:43:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[Catch: all -> 0x0095, TryCatch #1 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x0091, B:31:0x0081, B:35:0x008e, B:34:0x008a, B:20:0x0049), top: B:43:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0081 A[Catch: all -> 0x0095, TryCatch #1 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x0091, B:31:0x0081, B:35:0x008e, B:34:0x008a, B:20:0x0049), top: B:43:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008a A[Catch: all -> 0x0095, TryCatch #1 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x0091, B:31:0x0081, B:35:0x008e, B:34:0x008a, B:20:0x0049), top: B:43:0x0001 }] */
        @Override // java.util.concurrent.Future
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized com.qq.e.comm.plugin.m6 get(long r5, java.util.concurrent.TimeUnit r7) {
            /*
                r4 = this;
                monitor-enter(r4)
                com.qq.e.comm.plugin.m6 r0 = r4.a     // Catch: java.lang.Throwable -> L95
                if (r0 == 0) goto L7
                monitor-exit(r4)
                return r0
            L7:
                r0 = 0
                long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                java.util.concurrent.Future r3 = r4.b     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                java.lang.Object r5 = r3.get(r5, r7)     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.hw r5 = (com.qq.e.comm.plugin.hw) r5     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.l6 r6 = r4.c     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                r7 = 2300009(0x231869, float:3.222999E-39)
                com.qq.e.comm.plugin.o6.a(r7, r1, r6)     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                if (r5 != 0) goto L1f
                goto L2b
            L1f:
                com.qq.e.comm.plugin.sv r6 = com.qq.e.comm.plugin.sv.this     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.l6 r7 = r4.c     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.m6 r5 = com.qq.e.comm.plugin.sv.a(r6, r5, r7)     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                r4.a = r5     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                r5 = 0
                goto L36
            L2b:
                r5 = -5006(0xffffffffffffec72, float:NaN)
                goto L36
            L2e:
                r5 = -5005(0xffffffffffffec73, float:NaN)
                goto L36
            L31:
                r5 = -5004(0xffffffffffffec74, float:NaN)
                goto L36
            L34:
                r5 = -5003(0xffffffffffffec75, float:NaN)
            L36:
                r6 = 1
                if (r5 == 0) goto L49
                java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L95
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L95
                r6[r0] = r7     // Catch: java.lang.Throwable -> L95
                java.lang.String r7 = "#clickRes#"
                java.lang.String r0 = "resp == null,errorCode:%s"
                com.qq.e.comm.plugin.p20.a(r7, r0, r6)     // Catch: java.lang.Throwable -> L95
                goto L5a
            L49:
                com.qq.e.comm.plugin.sv r7 = com.qq.e.comm.plugin.sv.this     // Catch: java.lang.Throwable -> L95
                java.lang.String r7 = com.qq.e.comm.plugin.sv.a(r7)     // Catch: java.lang.Throwable -> L95
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L95
                r6[r0] = r7     // Catch: java.lang.Throwable -> L95
                java.lang.String r7 = "#clickRes#"
                java.lang.String r0 = "resp:%s"
                com.qq.e.comm.plugin.p20.a(r7, r0, r6)     // Catch: java.lang.Throwable -> L95
            L5a:
                com.qq.e.comm.plugin.m6 r6 = r4.a     // Catch: java.lang.Throwable -> L95
                if (r6 != 0) goto L6c
                java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L95
                com.qq.e.comm.plugin.l6 r7 = r4.c     // Catch: java.lang.Throwable -> L95
                com.qq.e.comm.plugin.o6.a(r6, r5, r7)     // Catch: java.lang.Throwable -> L95
                com.qq.e.comm.plugin.m6 r6 = new com.qq.e.comm.plugin.m6     // Catch: java.lang.Throwable -> L95
                r6.<init>(r5)     // Catch: java.lang.Throwable -> L95
                r4.a = r6     // Catch: java.lang.Throwable -> L95
            L6c:
                if (r5 != 0) goto L81
                com.qq.e.comm.plugin.m6 r6 = r4.a     // Catch: java.lang.Throwable -> L95
                int r6 = r6.a     // Catch: java.lang.Throwable -> L95
                r7 = 200(0xc8, float:2.8E-43)
                if (r6 == r7) goto L7d
                boolean r6 = com.qq.e.comm.plugin.as.a(r6)     // Catch: java.lang.Throwable -> L95
                if (r6 != 0) goto L7d
                goto L81
            L7d:
                com.qq.e.comm.plugin.vv.i()     // Catch: java.lang.Throwable -> L95
                goto L91
            L81:
                com.qq.e.comm.plugin.l6 r6 = r4.c     // Catch: java.lang.Throwable -> L95
                com.qq.e.comm.plugin.h4 r6 = r6.B     // Catch: java.lang.Throwable -> L95
                com.qq.e.comm.plugin.aw r7 = r4.d     // Catch: java.lang.Throwable -> L95
                if (r5 == 0) goto L8a
                goto L8e
            L8a:
                com.qq.e.comm.plugin.m6 r5 = r4.a     // Catch: java.lang.Throwable -> L95
                int r5 = r5.a     // Catch: java.lang.Throwable -> L95
            L8e:
                com.qq.e.comm.plugin.vv.a(r6, r7, r5)     // Catch: java.lang.Throwable -> L95
            L91:
                com.qq.e.comm.plugin.m6 r5 = r4.a     // Catch: java.lang.Throwable -> L95
                monitor-exit(r4)
                return r5
            L95:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.sv.a.get(long, java.util.concurrent.TimeUnit):com.qq.e.comm.plugin.m6");
        }
    }

    /* compiled from: A */
    class b extends hz {
        final /* synthetic */ int a;
        final /* synthetic */ l6 b;
        final /* synthetic */ aw c;

        b(int i, l6 l6Var, aw awVar) {
            this.a = i;
            this.b = l6Var;
            this.c = awVar;
        }

        private void a(int i, String str) throws JSONException {
            boolean z = i == 0;
            int i2 = this.a;
            if (i2 > 0) {
                o6.a(i, i2, this.b, str);
            } else if (i2 == 0) {
                o6.a(Boolean.valueOf(!z), i, this.b);
                if (!z) {
                    vv.a(this.b.B, this.c, i);
                }
            }
            if (z) {
                vv.i();
            } else if (this.a < sv.b()) {
                sv.a(sv.this, this.c, this.b, this.a + 1);
            }
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) throws JSONException {
            a(i, exc.getMessage());
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) throws JSONException {
            int iA = hwVar.a();
            if (iA != 200 && !as.a(iA)) {
                a(iA, (String) null);
            } else {
                a(0, (String) null);
            }
        }
    }
}
