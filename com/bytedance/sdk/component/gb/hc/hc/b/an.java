package com.bytedance.sdk.component.gb.hc.hc.b;

import android.os.Handler;
import com.bytedance.sdk.component.gb.d.tc;
import com.bytedance.sdk.component.utils.mq;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private final com.bytedance.sdk.component.gb.hc.hc.hc an;
    private b b;
    private volatile long c = 0;
    public final AtomicInteger d = new AtomicInteger(0);
    public final AtomicInteger hc = new AtomicInteger(0);
    private final com.bytedance.sdk.component.gb.d.u u;

    public an(com.bytedance.sdk.component.gb.d.u uVar, com.bytedance.sdk.component.gb.hc.hc.hc hcVar) {
        this.u = uVar;
        this.an = hcVar;
    }

    public void d(List<com.bytedance.sdk.component.gb.d.hc> list, boolean z, String str, int i, Object obj, com.bytedance.sdk.component.gb.hc.d.hc hcVar) {
        this.b = this.an.u();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.gb.hc.b.d.d(list, i, str, this.u);
        if (this.u.tc() != null) {
            d(list, z, jCurrentTimeMillis, obj, i);
        } else {
            com.bytedance.sdk.component.gb.hc.b.d.d(list, str, hcVar);
            d(list, z, jCurrentTimeMillis, i, obj);
        }
    }

    private void d(final List<com.bytedance.sdk.component.gb.d.hc> list, final boolean z, final long j, final int i, final Object obj) {
        com.bytedance.sdk.component.gb.d.c cVarC = this.u.c();
        if (cVarC != null) {
            Executor executorTt = cVarC.tt();
            if (list.get(0).u() == 1) {
                executorTt = cVarC.gb();
            }
            Executor executor = executorTt;
            if (executor == null) {
                return;
            }
            this.hc.incrementAndGet();
            executor.execute(new com.bytedance.sdk.component.gb.hc.u.hc("csj_log_upload") { // from class: com.bytedance.sdk.component.gb.hc.hc.b.an.1
                @Override // java.lang.Runnable
                public void run() {
                    an.this.hc(list, z, j, i, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(List<com.bytedance.sdk.component.gb.d.hc> list, boolean z, long j, int i, Object obj) {
        hc hcVarD;
        try {
            com.bytedance.sdk.component.gb.d.hc hcVar = list.get(0);
            com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.jh(), 1, this.u);
            if (hcVar.c() == 0) {
                hcVarD = com.bytedance.sdk.component.gb.hc.hc.an().d(list);
                d(hcVarD, list);
                if (hcVarD != null) {
                    com.bytedance.sdk.component.gb.hc.b.d.d(list, hcVarD.c, this.u);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.gb.d.hc> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().h());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    com.bytedance.sdk.component.gb.hc.b.b.b("_error", "json exception:" + e.getMessage(), this.u);
                }
                hcVarD = com.bytedance.sdk.component.gb.hc.hc.an().d(jSONObject);
            }
            hc hcVar2 = hcVarD;
            this.hc.decrementAndGet();
            d(z, hcVar2, list, j, obj, i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "inner exception:" + th.getMessage(), this.u);
            com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.b(), 1, this.u);
            this.hc.decrementAndGet();
        }
    }

    private void d(hc hcVar, List<com.bytedance.sdk.component.gb.d.hc> list) {
        if (hcVar == null || !hcVar.d) {
            return;
        }
        List<com.bytedance.sdk.component.gb.d.b> listD = com.bytedance.sdk.component.gb.hc.d.d();
        if (list == null || listD == null || listD.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.gb.d.hc hcVar2 : list) {
            if (hcVar2.u() == 1) {
                String strD = com.bytedance.sdk.component.gb.hc.b.d.d(hcVar2, this.u);
                String strAn = com.bytedance.sdk.component.gb.hc.b.d.an(hcVar2, this.u);
                for (com.bytedance.sdk.component.gb.d.b bVar : listD) {
                    if (bVar != null) {
                        bVar.d(strD, strAn);
                    }
                }
            }
        }
    }

    private void d(List<com.bytedance.sdk.component.gb.d.hc> list, final boolean z, final long j, final Object obj, final int i) {
        this.hc.incrementAndGet();
        com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.jh(), 1, this.u);
        try {
            this.u.tc().d(list, new tc() { // from class: com.bytedance.sdk.component.gb.hc.hc.b.an.2
                @Override // com.bytedance.sdk.component.gb.d.tc
                public void d(List<d> list2) {
                    try {
                        an.this.hc.decrementAndGet();
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        int size = list2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            d dVar = list2.get(i2);
                            if (dVar != null) {
                                an.this.d(z, dVar.d(), dVar.hc(), j, obj, i);
                            }
                        }
                    } catch (Exception e) {
                        mq.d(e);
                    }
                }
            });
        } catch (Exception e) {
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "outer exception：" + e.getMessage(), this.u);
            com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.b(), 1, this.u);
            this.hc.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, hc hcVar, List<com.bytedance.sdk.component.gb.d.hc> list, long j, Object obj, int i) {
        if (z) {
            return;
        }
        if (hcVar != null) {
            int i2 = hcVar.hc;
            if (hcVar.u) {
                i2 = -1;
            } else if (i2 < 0) {
                i2 = -2;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            int i3 = (hcVar.d || ((i2 < 500 || i2 >= 509) && i2 <= 513)) ? i2 : -2;
            if (list != null) {
                list.size();
                this.hc.get();
            }
            d(i3, list, j, obj, i, hcVar);
            return;
        }
        d(-1, list, j, obj, i, (hc) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x0025, B:35:0x00c0, B:36:0x00c3, B:20:0x003c, B:22:0x0044, B:24:0x0051, B:26:0x005e, B:27:0x0068, B:29:0x0070, B:30:0x007f, B:32:0x008b, B:33:0x00b5, B:38:0x00c5), top: B:43:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(int r9, java.util.List<com.bytedance.sdk.component.gb.d.hc> r10, long r11, java.lang.Object r13, int r14, com.bytedance.sdk.component.gb.hc.hc.b.hc r15) {
        /*
            r8 = this;
            com.bytedance.sdk.component.gb.hc.hc.b.b r0 = r8.b
            monitor-enter(r13)
            if (r10 == 0) goto Lc5
            if (r0 != 0) goto L9
            goto Lc5
        L9:
            android.os.Handler r1 = r0.hc()     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.d.u r6 = r8.u     // Catch: java.lang.Throwable -> Lc7
            r2 = r9
            r3 = r10
            r4 = r11
            r7 = r15
            com.bytedance.sdk.component.gb.hc.b.d.d(r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.hc.d.u r11 = r0.d()     // Catch: java.lang.Throwable -> Lc7
            r11.d(r9, r10, r14)     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.d.u r11 = r8.u     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.d.c r11 = r11.c()     // Catch: java.lang.Throwable -> Lc7
            if (r11 == 0) goto L28
            r11.mq()     // Catch: java.lang.Throwable -> Lc7
        L28:
            r12 = -2
            r15 = 72
            if (r9 == r12) goto L89
            r12 = -1
            if (r9 == r12) goto L68
            if (r9 == 0) goto L89
            r11 = 200(0xc8, float:2.8E-43)
            if (r9 == r11) goto L68
            r11 = 509(0x1fd, float:7.13E-43)
            if (r9 == r11) goto L3c
            goto Lbe
        L3c:
            com.bytedance.sdk.component.gb.d.u r9 = r8.u     // Catch: java.lang.Throwable -> Lc7
            boolean r9 = com.bytedance.sdk.component.gb.hc.b.d.hc(r10, r9)     // Catch: java.lang.Throwable -> Lc7
            if (r9 == 0) goto Lbe
            com.bytedance.sdk.component.gb.hc.hc.hc r9 = r8.an     // Catch: java.lang.Throwable -> Lc7
            r10 = 1
            r9.d(r10)     // Catch: java.lang.Throwable -> Lc7
            r9 = 3
            boolean r10 = r1.hasMessages(r9)     // Catch: java.lang.Throwable -> Lc7
            if (r10 != 0) goto Lbe
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc7
            long r2 = r8.c     // Catch: java.lang.Throwable -> Lc7
            long r10 = r10 - r2
            r2 = 15000(0x3a98, double:7.411E-320)
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 < 0) goto Lbe
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc7
            r8.c = r10     // Catch: java.lang.Throwable -> Lc7
            r8.d(r9, r2, r1)     // Catch: java.lang.Throwable -> Lc7
            goto Lbe
        L68:
            com.bytedance.sdk.component.gb.hc.hc.hc r9 = r8.an     // Catch: java.lang.Throwable -> Lc7
            boolean r9 = r9.c()     // Catch: java.lang.Throwable -> Lc7
            if (r9 == 0) goto L7f
            java.lang.String r9 = "_flush"
            java.lang.String r10 = "send reset error"
            com.bytedance.sdk.component.gb.d.u r11 = r8.u     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.hc.b.b.b(r9, r10, r11)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r9 = "handle_result"
            r0.d(r15, r9)     // Catch: java.lang.Throwable -> Lc7
            goto Lbe
        L7f:
            com.bytedance.sdk.component.gb.hc.hc.hc r9 = r8.an     // Catch: java.lang.Throwable -> Lc7
            r11 = 0
            r9.d(r11)     // Catch: java.lang.Throwable -> Lc7
            r8.d(r1, r10, r0)     // Catch: java.lang.Throwable -> Lc7
            goto Lbe
        L89:
            if (r11 == 0) goto Lb5
            java.lang.String r12 = "_error"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r3 = "net is available:"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.d.u r3 = r8.u     // Catch: java.lang.Throwable -> Lc7
            android.content.Context r3 = r3.getContext()     // Catch: java.lang.Throwable -> Lc7
            boolean r11 = r11.d(r3)     // Catch: java.lang.Throwable -> Lc7
            java.lang.StringBuilder r11 = r2.append(r11)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r2 = " code:"
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch: java.lang.Throwable -> Lc7
            java.lang.StringBuilder r9 = r11.append(r9)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.d.u r11 = r8.u     // Catch: java.lang.Throwable -> Lc7
            com.bytedance.sdk.component.gb.hc.b.b.b(r12, r9, r11)     // Catch: java.lang.Throwable -> Lc7
        Lb5:
            com.bytedance.sdk.component.gb.hc.hc.hc r9 = r8.an     // Catch: java.lang.Throwable -> Lc7
            r11 = 2
            r9.d(r11)     // Catch: java.lang.Throwable -> Lc7
            r8.d(r1, r10, r0)     // Catch: java.lang.Throwable -> Lc7
        Lbe:
            if (r14 != r15) goto Lc3
            r13.notify()     // Catch: java.lang.Throwable -> Lc7
        Lc3:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Lc7
            return
        Lc5:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Lc7
            return
        Lc7:
            r9 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Lc7
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.gb.hc.hc.b.an.d(int, java.util.List, long, java.lang.Object, int, com.bytedance.sdk.component.gb.hc.hc.b.hc):void");
    }

    private void d(Handler handler, List<com.bytedance.sdk.component.gb.d.hc> list, b bVar) {
        boolean zC = bVar.c();
        boolean zHc = com.bytedance.sdk.component.gb.hc.b.d.hc(list, this.u);
        if (zC && zHc) {
            if (handler.hasMessages(3)) {
                handler.removeMessages(3);
            }
            this.d.set(0);
            this.c = 0L;
            com.bytedance.sdk.component.gb.hc.b.b.b("_flush", "send reset busy", this.u);
            com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.c(), 1, this.u);
            bVar.d(72, "handle_result");
        }
    }

    public void d(int i, long j, Handler handler) {
        if (handler == null) {
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "mHandler == null", this.u);
            return;
        }
        if (i == 3) {
            if (handler.hasMessages(i)) {
                handler.removeMessages(i);
            }
            long j2 = (((r1 - 1) % 4) + 1) * j;
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "sendBusyMsg:" + i + "  retryCount:" + this.d.incrementAndGet() + " delayTime:" + (j2 / 1000), this.u);
            handler.sendEmptyMessageDelayed(i, j2);
            return;
        }
        com.bytedance.sdk.component.gb.hc.b.b.b("_error", "sendBusyMsg error state", this.u);
    }
}
