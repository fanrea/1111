package com.bytedance.framwork.core.de.fg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.bytedance.framwork.core.apm.SDKMonitorUtils;
import com.bytedance.framwork.core.ef.a;
import com.component.a.a.b;
import java.net.URL;
import java.util.List;

/* compiled from: DefaultLogSendImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a implements b {
    com.bytedance.framwork.core.ef.a a;
    volatile long b;
    boolean c;
    int d;
    Context e;
    String f;
    int g;
    volatile long h;
    volatile long i;
    String j;
    private boolean k = true;

    public a(Context context, final String str) {
        this.f = str;
        this.e = context;
        this.a = new com.bytedance.framwork.core.ef.a(context.getApplicationContext(), new a.AbstractC0210a() { // from class: com.bytedance.framwork.core.de.fg.a.1
            @Override // com.bytedance.framwork.core.ef.a.b
            public String a() {
                return str + "sdk_monitor";
            }

            @Override // com.bytedance.framwork.core.ef.a.b
            public List<String> b() {
                return com.bytedance.framwork.core.de.de.c.a(str, "sdk_monitor");
            }

            @Override // com.bytedance.framwork.core.ef.a.AbstractC0210a, com.bytedance.framwork.core.ef.a.b
            public int c() {
                return com.bytedance.framwork.core.de.de.c.d(str);
            }

            @Override // com.bytedance.framwork.core.ef.a.AbstractC0210a, com.bytedance.framwork.core.ef.a.b
            public long d() {
                return com.bytedance.framwork.core.de.de.c.e(str);
            }

            @Override // com.bytedance.framwork.core.ef.a.AbstractC0210a, com.bytedance.framwork.core.ef.a.b
            public String e() {
                List<String> listB;
                if (TextUtils.isEmpty(a.this.j) || (listB = b()) == null || listB.size() <= 0) {
                    return null;
                }
                try {
                    return "https://" + a.this.j + new URL(listB.get(0)).getPath();
                } catch (Throwable unused) {
                    return null;
                }
            }
        }, new a.c() { // from class: com.bytedance.framwork.core.de.fg.a.2
            @Override // com.bytedance.framwork.core.ef.a.c
            public boolean a() {
                return com.bytedance.framwork.core.de.de.c.f(str);
            }

            @Override // com.bytedance.framwork.core.ef.a.c
            public long b() {
                return a.this.g();
            }

            @Override // com.bytedance.framwork.core.ef.a.c
            public boolean c() {
                return a.this.c;
            }
        }) { // from class: com.bytedance.framwork.core.de.fg.a.3
            @Override // com.bytedance.framwork.core.ef.a
            protected boolean a(String str2, byte[] bArr) {
                if (d.a(str) != null) {
                    e eVarSendLog = d.a(str).sendLog(str2, bArr);
                    a.this.c((String) null);
                    if (eVarSendLog == null || eVarSendLog.a <= 0) {
                        a.this.b();
                        a.this.c = true;
                    } else {
                        a.this.c = false;
                        if (eVarSendLog.a == 200 && eVarSendLog.b != null) {
                            if ("success".equals(eVarSendLog.b.opt(cm.V))) {
                                a.this.c();
                                String strOptString = eVarSendLog.b.optString("redirect");
                                long jOptLong = eVarSendLog.b.optLong(b.e.c);
                                if (!TextUtils.isEmpty(strOptString)) {
                                    a.this.c(strOptString);
                                }
                                if (jOptLong > 0) {
                                    a.this.a(jOptLong);
                                }
                                return true;
                            }
                            boolean zEquals = "drop data".equals(eVarSendLog.b.opt(cm.V));
                            boolean zEquals2 = "drop all data".equals(eVarSendLog.b.opt(cm.V));
                            String strOptString2 = eVarSendLog.b.optString("redirect");
                            long jOptLong2 = eVarSendLog.b.optLong(b.e.c);
                            if (!TextUtils.isEmpty(strOptString2)) {
                                a.this.c(strOptString2);
                            }
                            if (jOptLong2 > 0) {
                                a.this.a(jOptLong2);
                            }
                            if (zEquals) {
                                a.this.d();
                            } else {
                                a.this.e();
                            }
                            if (zEquals2) {
                                a.this.f();
                            }
                            return false;
                        }
                        if (500 <= eVarSendLog.a && eVarSendLog.a <= 600) {
                            a.this.a();
                            return false;
                        }
                    }
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.k) {
            int i = this.d;
            if (i == 0) {
                this.b = 300000L;
                this.d++;
            } else if (i == 1) {
                this.b = 900000L;
                this.d++;
            } else if (i == 2) {
                this.b = 1800000L;
                this.d++;
            } else {
                this.b = 1800000L;
                this.d++;
            }
            SDKMonitorUtils.getInstance(this.f).setCollectDelay(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.k) {
            int i = this.g;
            if (i == 0) {
                this.h = 30000L;
                this.g++;
            } else if (i == 1) {
                this.h = 60000L;
                this.g++;
            } else if (i == 2) {
                this.h = 120000L;
                this.g++;
            } else if (i == 3) {
                this.h = 240000L;
                this.g++;
            } else {
                this.h = 300000L;
                this.g++;
            }
            SDKMonitorUtils.getInstance(this.f).setCollectDelay(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.k) {
            SDKMonitorUtils.getInstance(this.f).restoreCollectDelay();
            SDKMonitorUtils.getInstance(this.f).setStopCollect(false);
            this.d = 0;
            this.b = 0L;
            this.g = 0;
            this.h = 0L;
            this.i = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.k) {
            a();
            SDKMonitorUtils.getInstance(this.f).setStopCollect(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.k) {
            SDKMonitorUtils.getInstance(this.f).setStopCollect(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.k) {
            a();
            SDKMonitorUtils.getInstance(this.f).setStopCollect(true);
            SDKMonitorUtils.getInstance(this.f).deleteAllLogs();
            SDKMonitorUtils.getInstance(this.f).dropAllData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.k) {
            this.j = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.k) {
            this.i = j * 1000;
            SDKMonitorUtils.getInstance(this.f).setCollectDelay(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g() {
        if (!this.k) {
            return 0L;
        }
        long j = this.b > this.h ? this.b : this.h;
        return j > this.i ? j : this.i;
    }

    @Override // com.bytedance.framwork.core.de.fg.b
    public boolean a(String str) {
        return this.a.a(str);
    }

    public void b(String str) {
        this.a.b(str);
    }
}
