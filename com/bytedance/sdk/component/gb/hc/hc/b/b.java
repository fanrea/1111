package com.bytedance.sdk.component.gb.hc.hc.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends u implements Handler.Callback {
    private static int cb = 200;
    private static int e = 10;
    private final int an;
    private final Object c;
    protected com.bytedance.sdk.component.gb.hc.d.u d;
    private com.bytedance.sdk.component.gb.hc.d.hc de;
    private final AtomicInteger gb;
    private int h;
    private volatile String jh;
    private volatile boolean k;
    private volatile Handler mk;
    private final List<com.bytedance.sdk.component.gb.d.hc> mq;
    private volatile int rf;
    private final HashMap<String, List<com.bytedance.sdk.component.gb.d.hc>> sy;
    private final long tc;
    private final long tt;
    private an u;
    private final List<com.bytedance.sdk.component.gb.d.hc> uo;
    private final String w;
    private final String yo;

    public b(com.bytedance.sdk.component.gb.d.u uVar, com.bytedance.sdk.component.gb.hc.hc.hc hcVar) {
        super(uVar, hcVar);
        this.c = new Object();
        this.an = 50;
        this.h = 30;
        this.gb = new AtomicInteger(0);
        this.tt = 5000L;
        this.tc = 5000000000L;
        this.mq = new ArrayList();
        this.uo = new CopyOnWriteArrayList();
        this.k = false;
        this.w = "after_upload";
        this.yo = "prepare_upload";
        this.rf = 0;
        this.jh = "DEFAULT";
        this.sy = new HashMap<>();
        this.d = new com.bytedance.sdk.component.gb.hc.d.b(uVar, this);
        this.u = new an(this.hc, this.b);
    }

    public com.bytedance.sdk.component.gb.hc.d.u d() {
        return this.d;
    }

    public Handler hc() {
        return this.mk;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            boolean zD = this.hc.c().d(this.hc.getContext());
            if (i == 1) {
                synchronized (b.class) {
                    if (!this.uo.isEmpty()) {
                        int size = this.uo.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            d(this.uo.get(i2), 1, zD);
                        }
                    }
                    this.k = true;
                    this.uo.clear();
                }
            } else if (i == 3) {
                hc(3, zD);
            } else if (i == 5) {
                ArrayList arrayList = new ArrayList(this.mq);
                this.mq.clear();
                d(arrayList, false, "timeout_dispatch", 5);
            } else if (i == 74) {
                d((com.bytedance.sdk.component.gb.d.hc) message.obj, 74, zD);
            } else if (i == 71) {
                d(71, zD);
            } else if (i == 72) {
                d(72, zD);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.b("_ms", "error:" + th.getMessage(), this.hc);
        }
        return true;
    }

    private void d(int i, boolean z) {
        hc((com.bytedance.sdk.component.gb.d.hc) null, i, z);
    }

    private void hc(int i, boolean z) {
        hc((com.bytedance.sdk.component.gb.d.hc) null, i, z);
    }

    @Override // com.bytedance.sdk.component.gb.hc.hc.b.u
    public void b() {
        super.b();
        this.mk = new Handler(h(), this);
        this.b.d(this.mk);
        this.mk.sendEmptyMessage(1);
    }

    public boolean d(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (this.hc == null) {
            return false;
        }
        return this.d.d(i, str, hcVar);
    }

    public void d(com.bytedance.sdk.component.gb.d.hc hcVar, boolean z) {
        if (hcVar == null) {
            return;
        }
        if (z) {
            if (this.mk != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(hcVar);
                d(arrayList, true, "ignore_result_dispatch", -1);
                return;
            }
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "other thread handler is null，ignore is true", this.hc);
            return;
        }
        if (this.k) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = hcVar;
            messageObtain.what = 74;
            this.mk.sendMessage(messageObtain);
            return;
        }
        this.uo.add(hcVar);
    }

    public void d(int i, String str) {
        try {
            if (!this.hc.c().d(this.hc.getContext())) {
                com.bytedance.sdk.component.gb.hc.b.b.b("_error", "AdThread NET IS NOT AVAILABLE", this.hc);
                return;
            }
            boolean zD = d(i, str + " check", (com.bytedance.sdk.component.gb.d.hc) null);
            com.bytedance.sdk.component.gb.hc.b.b.hc("_flush", "notify runOnce check: ".concat(String.valueOf(zD)), this.hc);
            if (zD) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                this.mk.sendMessage(messageObtain);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.b(th.getMessage(), this.hc);
        }
    }

    private void d(com.bytedance.sdk.component.gb.d.hc hcVar, int i, boolean z) {
        try {
            d(hcVar);
            hc(hcVar, i, z);
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "run exception:" + th.getMessage(), this.hc);
            com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.b(), 1, this.hc);
        }
    }

    private void d(com.bytedance.sdk.component.gb.d.hc hcVar) throws JSONException {
        this.gb.set(0);
        com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.mk(), 1, this.hc);
        this.d.d(hcVar);
        com.bytedance.sdk.component.gb.hc.b.d.d(hcVar, this.hc, "_ad");
        com.bytedance.sdk.component.gb.hc.b.d.gb(hcVar, this.hc);
    }

    private boolean hc(com.bytedance.sdk.component.gb.d.hc hcVar, boolean z) {
        return com.bytedance.sdk.component.gb.hc.b.d.d(this.hc) && this.hc.b();
    }

    public boolean c() {
        return com.bytedance.sdk.component.gb.hc.b.d.d(this.hc) && this.b.b();
    }

    private void hc(com.bytedance.sdk.component.gb.d.hc hcVar, int i, boolean z) {
        if (hc(hcVar, z)) {
            com.bytedance.sdk.component.gb.hc.b.b.d("_error", " upload cancel cause config " + com.bytedance.sdk.component.gb.hc.b.d.b(hcVar, this.hc), this.hc);
            return;
        }
        boolean zC = c();
        boolean z2 = false;
        boolean z3 = com.bytedance.sdk.component.gb.hc.b.d.tt(hcVar, this.hc) || i == 3;
        boolean zD = com.bytedance.sdk.component.gb.hc.b.d.d(i);
        com.bytedance.sdk.component.gb.hc.b.b.b("_error", "serbusy:" + zC + " isCsjBusy:" + z3 + " flush:" + zD, this.hc);
        if (zC && !zD && z3) {
            if (i == 3) {
                com.bytedance.sdk.component.gb.hc.b.b.b("_error", "start do flush", this.hc);
                d(72, z);
                return;
            } else {
                if (i == 74 || i == 1) {
                    boolean zHasMessages = this.mk.hasMessages(3);
                    com.bytedance.sdk.component.gb.hc.b.b.b("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(zHasMessages)), this.hc);
                    if (zHasMessages) {
                        return;
                    }
                    this.u.d(3, 15000L, this.mk);
                    return;
                }
                com.bytedance.sdk.component.gb.hc.b.b.b("_error", "server busy", this.hc);
                return;
            }
        }
        if (!z) {
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "AdThread NET IS NOT AVAILABLE!!!", this.hc);
            return;
        }
        boolean zD2 = d(i, "needUpload check", hcVar);
        if (zD2) {
            List<com.bytedance.sdk.component.gb.d.hc> listD = this.d.d(i, hcVar, zC, this.rf + Config.replace + this.jh);
            if (listD != null && listD.size() != 0) {
                com.bytedance.sdk.component.gb.hc.b.b.hc("_ms", "prepare get size =" + listD.size(), this.hc);
                d(listD, i);
            } else {
                com.bytedance.sdk.component.gb.hc.b.b.hc("_ms", "prepare get no event need upload", this.hc);
                d("prepare_upload");
                com.bytedance.sdk.component.gb.hc.b.b.d("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.hc);
            }
        } else {
            com.bytedance.sdk.component.gb.hc.b.b.hc("_ms", "prepare upload no need", this.hc);
            this.sy.clear();
            d("prepare_upload");
        }
        z2 = zD2;
        com.bytedance.sdk.component.gb.hc.b.b.d("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.hc);
    }

    private void d(String str) {
        if (this.mq.size() != 0) {
            com.bytedance.sdk.component.gb.d.c cVarC = this.hc.c();
            if (this.mk.hasMessages(5)) {
                this.mk.removeMessages(5);
            }
            long jB = cb;
            if (cVarC != null && cVarC.mq() != null) {
                jB = cVarC.mq().b();
            }
            this.mk.sendEmptyMessageDelayed(5, jB);
            this.mq.size();
            return;
        }
        com.bytedance.sdk.component.gb.hc.b.b.d("_ms", "do nothing", this.hc);
    }

    private void d(List<com.bytedance.sdk.component.gb.d.hc> list, String str, int i) {
        d(list, false, str, i);
    }

    private void d(List<com.bytedance.sdk.component.gb.d.hc> list, int i) {
        com.bytedance.sdk.component.gb.hc.b.d.d(list, this.hc);
        com.bytedance.sdk.component.gb.d.hc hcVar = list.get(0);
        if (hcVar == null) {
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "adLogEvent is null", this.hc);
            return;
        }
        if (list.size() > 1 || com.bytedance.sdk.component.gb.hc.b.d.hc(this.hc) || com.bytedance.sdk.component.gb.hc.b.d.c(this.hc)) {
            if (hcVar.c() == 0 && hcVar.u() == 2 && i == 74) {
                if (hcVar.hc() == 3) {
                    d(list, "version_v3_batch", i);
                    return;
                } else {
                    hc(list, "batchOptimize", i);
                    return;
                }
            }
            d(list, "batchRead", i);
            return;
        }
        if (hcVar.u() == 1) {
            d(list, "highPriority", i);
            return;
        }
        if (hcVar.c() == 0 && hcVar.u() == 2) {
            if (hcVar.hc() == 3) {
                d(list, "version_v3_single_directly", i);
                return;
            } else {
                hc(list, "singleOptimize", i);
                return;
            }
        }
        if (hcVar.c() == 1) {
            d(list, "stats_directly", i);
            return;
        }
        if (hcVar.c() == 3) {
            d(list, "adType_v3_directly", i);
        } else if (hcVar.c() == 2) {
            d(list, "other_directly", i);
        } else {
            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "adLogEvent adType error", this.hc);
        }
    }

    private void hc(List<com.bytedance.sdk.component.gb.d.hc> list, String str, int i) {
        this.mq.addAll(list);
        com.bytedance.sdk.component.gb.d.c cVarC = this.hc.c();
        if (cVarC != null && cVarC.mq() != null) {
            e = cVarC.mq().c();
        }
        if (this.mq.size() >= e) {
            if (this.mk.hasMessages(5)) {
                this.mk.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.mq);
            this.mq.clear();
            d(arrayList, false, "max_size_dispatch", i);
            return;
        }
        d(str);
    }

    private void d(List<com.bytedance.sdk.component.gb.d.hc> list, boolean z, String str, int i) {
        this.u.d(list, z, str, i, this.c, this.de);
        if (z) {
            return;
        }
        d(i);
    }

    private void d(int i) {
        long jNanoTime;
        d("after_upload");
        com.bytedance.sdk.component.gb.hc.b.d.hc(i);
        if (i == 72) {
            synchronized (this.c) {
                try {
                    try {
                        long jNanoTime2 = System.nanoTime();
                        this.c.wait(5000L);
                        jNanoTime = System.nanoTime() - jNanoTime2;
                    } catch (InterruptedException e2) {
                        com.bytedance.sdk.component.gb.hc.b.b.b("_error", "wait exception:" + e2.getMessage(), this.hc);
                    }
                    if (jNanoTime < 5000000000L && 5000000000L - jNanoTime >= 50000000) {
                        if (c()) {
                            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "return wait serverBusy", this.hc);
                            return;
                        }
                        if (this.b.c()) {
                            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "return wait otherError", this.hc);
                            return;
                        }
                        com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.hc(), 1, this.hc);
                        int i2 = this.h + 1;
                        this.h = i2;
                        if (i2 < 50) {
                            com.bytedance.sdk.component.gb.hc.b.b.hc("_flush", "afterUpload send flush again:" + this.h, this.hc);
                            d(72, "continue");
                        } else {
                            this.h = 0;
                            if (this.mk.hasMessages(72)) {
                                this.mk.removeMessages(72);
                            }
                            com.bytedance.sdk.component.gb.hc.b.b.b("_error", "afterUpload send flush end:" + this.h, this.hc);
                        }
                        return;
                    }
                    com.bytedance.sdk.component.gb.hc.b.b.b("_error", "return wait timeout", this.hc);
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.h = 0;
        if (this.mk.hasMessages(72)) {
            this.mk.removeMessages(72);
        }
    }
}
