package com.baidu.mobads.container.components.h.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.ProdAdRequestInfo;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.adrequest.l;
import com.baidu.mobads.container.util.bq;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f implements Handler.Callback {
    private static final String a = "StateRecorder";
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private static final int h = 7;
    private static final int i = 8;
    private static final int j = 9;
    private static final long k = 3600000;
    private static final long l = 60000;
    private static final long m = 5000;
    private static volatile f o;
    private final AtomicLong n = new AtomicLong();
    private boolean p = false;
    private HandlerThread q;
    private volatile Handler r;
    private final d s;

    private f(Context context) {
        this.s = new d(context);
    }

    public static f a(Context context) {
        if (o == null) {
            synchronized (f.class) {
                if (o == null) {
                    o = new f(context);
                    o.a(com.baidu.mobads.container.h.a.a().p());
                    o.b(com.baidu.mobads.container.h.a.a().q());
                }
            }
        }
        return o;
    }

    public boolean a() {
        return this.p;
    }

    public void a(int i2) {
        this.p = i2 >= 0;
        this.s.a(i2);
    }

    public void b(int i2) {
        this.s.b(i2);
    }

    public boolean a(String str, ProdAdRequestInfo prodAdRequestInfo) {
        if (!this.p || !a(1, b(str, prodAdRequestInfo))) {
            return false;
        }
        a(3600000L);
        return true;
    }

    public void a(String str, l lVar) {
        ArrayList<j> arrayListO;
        if (lVar == null || !this.p || (arrayListO = lVar.o()) == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayListO.size(); i2++) {
            j jVar = arrayListO.get(i2);
            com.baidu.mobads.container.components.h.b.d dVarA = a(jVar);
            if (a(1, dVarA)) {
                a(dVarA, str);
            }
            String strA = b.a(jVar);
            if (!TextUtils.isEmpty(strA)) {
                a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.b.a.c, strA);
                a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_DATA_LACK);
            }
        }
        a(3600000L);
    }

    public void a(String str, com.baidu.mobads.container.components.h.a aVar) {
        a(str, aVar, "");
    }

    public void a(String str, com.baidu.mobads.container.components.h.a aVar, Throwable th) {
        a(str, aVar, th.getMessage());
    }

    public void a(String str, com.baidu.mobads.container.components.h.a aVar, String str2) {
        if (this.p) {
            a(2, str, new com.baidu.mobads.container.components.h.b.c(aVar.b(), str2));
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.p) {
            a(5, str, str2, str3);
        }
    }

    public void a(String str, String str2) {
        if (this.p) {
            a(6, str, str2);
        }
    }

    public void a(String str, String str2, int i2) {
        if (this.p) {
            a(7, str, str2, Integer.valueOf(i2));
        }
    }

    public void a(String str) {
        if (this.p) {
            a(3, str);
        }
    }

    public void b(String str, com.baidu.mobads.container.components.h.a aVar) {
        if (this.p) {
            a(9, 5000L, str, new com.baidu.mobads.container.components.h.b.c(aVar.b(), ""));
        }
    }

    public void b() {
        a(0L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.c> copyOnWriteArrayListF;
        if (this.s == null) {
            return false;
        }
        switch (message.what) {
            case 1:
                if (message.obj instanceof Object[]) {
                    this.s.b((com.baidu.mobads.container.components.h.b.d) ((Object[]) message.obj)[0]);
                }
                return true;
            case 2:
                if (message.obj instanceof Object[]) {
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr.length > 1) {
                        this.s.a((String) objArr[0], (com.baidu.mobads.container.components.h.b.c) objArr[1]);
                    }
                }
                return true;
            case 3:
                if (message.obj instanceof Object[]) {
                    this.s.c((String) ((Object[]) message.obj)[0]);
                }
                return true;
            case 4:
                this.s.a();
                d();
                return true;
            case 5:
                if (message.obj instanceof Object[]) {
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2.length > 2) {
                        this.s.a((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    }
                }
                return true;
            case 6:
                if (message.obj instanceof Object[]) {
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3.length > 1) {
                        this.s.b((String) objArr3[0], (String) objArr3[1]);
                    }
                }
                return true;
            case 7:
                if (message.obj instanceof Object[]) {
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4.length > 2) {
                        String str = (String) objArr4[0];
                        String str2 = (String) objArr4[1];
                        int iIntValue = ((Integer) objArr4[2]).intValue();
                        com.baidu.mobads.container.components.h.b.d dVarB = this.s.b(str);
                        if (dVarB != null) {
                            try {
                                dVarB.a(str2, "" + (Integer.parseInt(dVarB.b(str2)) + iIntValue));
                            } catch (Throwable th) {
                                bq.a().b(a, th.getMessage());
                            }
                        }
                    }
                }
                return true;
            case 8:
                if (message.obj instanceof Object[]) {
                    Object[] objArr5 = (Object[]) message.obj;
                    if (objArr5.length > 1) {
                        com.baidu.mobads.container.components.h.b.d dVar = (com.baidu.mobads.container.components.h.b.d) objArr5[0];
                        com.baidu.mobads.container.components.h.b.d dVarB2 = this.s.b((String) objArr5[1]);
                        if (dVar != null && dVarB2 != null) {
                            dVar.a(dVarB2);
                            dVarB2.b(dVar);
                            this.s.a(dVar);
                        }
                    }
                }
                return true;
            case 9:
                if (message.obj instanceof Object[]) {
                    Object[] objArr6 = (Object[]) message.obj;
                    if (objArr6.length > 1) {
                        String str3 = (String) objArr6[0];
                        com.baidu.mobads.container.components.h.b.c cVar = (com.baidu.mobads.container.components.h.b.c) objArr6[1];
                        com.baidu.mobads.container.components.h.b.d dVarB3 = this.s.b(str3);
                        if (cVar != null && dVarB3 != null && (copyOnWriteArrayListF = dVarB3.f()) != null && copyOnWriteArrayListF.size() > 0 && copyOnWriteArrayListF.get(copyOnWriteArrayListF.size() - 1).a() == cVar.a()) {
                            this.s.c(dVarB3);
                        }
                    }
                }
                return true;
            default:
                return true;
        }
    }

    private com.baidu.mobads.container.components.h.b.d b(String str, ProdAdRequestInfo prodAdRequestInfo) {
        com.baidu.mobads.container.components.h.b.d dVarA = this.s.a("request");
        try {
            dVarA.a(new com.baidu.mobads.container.components.h.b.c(com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_START.b(), ""));
            dVarA.a(str);
            dVarA.a(com.baidu.mobads.container.components.h.b.e.a, prodAdRequestInfo.adProdTemplate.z());
            dVarA.a(com.baidu.mobads.container.components.h.b.e.b, prodAdRequestInfo.adProdTemplate.l());
            dVarA.a("prod", prodAdRequestInfo.adProdTemplate.k());
            dVarA.a(com.baidu.mobads.container.components.h.b.e.e, String.valueOf(prodAdRequestInfo.adProdTemplate.e));
            dVarA.a(com.baidu.mobads.container.components.h.b.e.f, String.valueOf(prodAdRequestInfo.getAllAdParam().optInt(com.baidu.mobads.container.components.h.b.e.f, 0)));
            dVarA.a(com.baidu.mobads.container.components.h.b.e.d, String.valueOf(prodAdRequestInfo.getAllAdParam().optInt("adSrc", 0)));
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
        }
        return dVarA;
    }

    private com.baidu.mobads.container.components.h.b.d a(j jVar) {
        com.baidu.mobads.container.components.h.b.d dVarA = this.s.a("ad");
        try {
            dVarA.a(new com.baidu.mobads.container.components.h.b.c(com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_SUCCESS.b(), ""));
            dVarA.a(jVar.getExpiration() * 1000);
            dVarA.a(jVar.getUniqueId());
            dVarA.a("adid", jVar.getAdId());
            dVarA.a("sd", jVar.getQueryKey());
            dVarA.a(com.baidu.mobads.container.components.h.b.a.k, String.valueOf(jVar.getExpiration()));
            dVarA.a(com.baidu.mobads.container.components.h.b.a.d, jVar.getBuyer());
            dVarA.a("act", String.valueOf(jVar.getActionType()));
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
        }
        return dVarA;
    }

    private void a(com.baidu.mobads.container.components.h.b.d dVar, String str) {
        a(8, dVar, str);
    }

    private void c() {
        synchronized (this) {
            this.q = new HandlerThread("bd_state_thread");
            if (!this.q.isAlive()) {
                this.q.start();
            }
            this.r = new Handler(this.q.getLooper(), this);
            a(60000L);
        }
    }

    private boolean a(int i2, Object... objArr) {
        if (this.r == null) {
            c();
        }
        return this.r.sendMessage(this.r.obtainMessage(i2, objArr));
    }

    private void a(int i2, long j2, Object... objArr) {
        if (this.r == null) {
            c();
        }
        this.r.sendMessageDelayed(this.r.obtainMessage(i2, objArr), j2);
    }

    private void a(long j2) {
        if (this.r != null && this.r.hasMessages(4)) {
            this.r.removeMessages(4);
        }
        b(j2);
        a(4, j2, new Object[0]);
    }

    private void b(long j2) {
        this.n.set(System.currentTimeMillis() + j2);
    }

    private void d() {
        synchronized (this) {
            if (System.currentTimeMillis() > this.n.get()) {
                this.n.set(0L);
                if (this.q != null && this.q.isAlive()) {
                    a(this.q);
                }
                if (this.r != null) {
                    this.r.removeCallbacksAndMessages(null);
                }
                this.r = null;
            }
        }
    }

    private void a(HandlerThread handlerThread) {
        if (Build.VERSION.SDK_INT >= 18) {
            handlerThread.quitSafely();
        } else {
            handlerThread.quit();
        }
    }
}
