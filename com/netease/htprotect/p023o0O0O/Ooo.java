package com.netease.htprotect.p023o0O0O;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.panglearmor.d.hc.u$$ExternalSyntheticBackport0;
import com.netease.htprotect.poly.a;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/* renamed from: com.netease.htprotect.〇o〇0O〇0O.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static final int f604O8oO888 = 10001;
    private static HandlerThread Oo0 = null;

    /* renamed from: 〇O, reason: contains not printable characters */
    private static volatile boolean f605O = false;

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static final int f606O8 = 10003;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static final int f607Ooo = 10002;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static volatile boolean f608o0o0 = false;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static volatile oO f609oO;

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static final Handler f610o0O0O = new Handler(Looper.getMainLooper());

    /* renamed from: com.netease.htprotect.〇o〇0O〇0O.〇Ooo$O8〇oO8〇88, reason: invalid class name */
    public static class O8oO888 extends Handler {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private long f611O8oO888;

        /* renamed from: 〇O8, reason: contains not printable characters */
        private final ArrayBlockingQueue f612O8;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private long f613Ooo;

        public O8oO888(Looper looper) {
            super(looper);
            this.f611O8oO888 = 0L;
            this.f613Ooo = 0L;
            this.f612O8 = new ArrayBlockingQueue(5);
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private void m1172O8oO888(String str) throws Throwable {
            boolean z;
            Throwable th;
            if (this.f612O8.remainingCapacity() > 0) {
                this.f612O8.offer(str);
                return;
            }
            if (this.f612O8.size() <= 0) {
                return;
            }
            boolean z2 = false;
            try {
                ArrayList arrayList = new ArrayList();
                z = true;
                if (this.f612O8.drainTo(arrayList) > 0) {
                    try {
                        if (arrayList.size() > 0) {
                            a.acd(u$$ExternalSyntheticBackport0.m(",", arrayList));
                        }
                    } catch (Exception unused) {
                        z2 = true;
                        if (z2) {
                            return;
                        }
                        this.f612O8.clear();
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z) {
                            this.f612O8.clear();
                        }
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                z = false;
                th = th3;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            boolean z;
            Throwable th;
            if (message == null) {
                return;
            }
            O oM1148O8oO888 = O.m1148O8oO888();
            if (message.what == 10001) {
                if (O.m1158o0o0()) {
                    if (oM1148O8oO888.m1163O8() || oM1148O8oO888.m1164Ooo()) {
                        try {
                            Object obj = message.obj;
                            if (obj instanceof MotionEvent) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (jCurrentTimeMillis - this.f611O8oO888 > 200) {
                                    this.f611O8oO888 = jCurrentTimeMillis;
                                    MotionEvent motionEvent = (MotionEvent) obj;
                                    oM1148O8oO888.m1160O8oO888(motionEvent.getX() + "," + motionEvent.getY() + "," + jCurrentTimeMillis);
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (message.what != 10002) {
                if (message.what == 10003) {
                    try {
                        Object obj2 = message.obj;
                        if (obj2 instanceof String) {
                            String str = (String) obj2;
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            a.wli(str);
                            return;
                        }
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
                return;
            }
            try {
                Object obj3 = message.obj;
                if (!(obj3 instanceof String)) {
                    return;
                }
                String str2 = (String) obj3;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 - this.f613Ooo <= 2000) {
                    return;
                }
                this.f613Ooo = jCurrentTimeMillis2;
                if (this.f612O8.remainingCapacity() > 0) {
                    this.f612O8.offer(str2);
                    return;
                }
                if (this.f612O8.size() <= 0) {
                    return;
                }
                boolean z2 = false;
                try {
                    ArrayList arrayList = new ArrayList();
                    z = true;
                    if (this.f612O8.drainTo(arrayList) > 0) {
                        try {
                            if (arrayList.size() > 0) {
                                a.acd(u$$ExternalSyntheticBackport0.m(",", arrayList));
                            }
                        } catch (Exception unused3) {
                            z2 = true;
                            if (z2) {
                                return;
                            }
                            this.f612O8.clear();
                        } catch (Throwable th2) {
                            th = th2;
                            if (!z) {
                                this.f612O8.clear();
                            }
                            throw th;
                        }
                    }
                } catch (Exception unused4) {
                } catch (Throwable th3) {
                    z = false;
                    th = th3;
                }
            } catch (Exception unused5) {
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static synchronized boolean m1168O8oO888(Context context) {
        O8oO888 o8oO888;
        if (context == null) {
            return false;
        }
        if (f608o0o0) {
            return true;
        }
        f608o0o0 = true;
        Application application = (Application) context.getApplicationContext();
        O.m1148O8oO888().m1162O8oO888(context);
        synchronized (O8oO888.class) {
            HandlerThread handlerThread = new HandlerThread("YDHandler");
            Oo0 = handlerThread;
            handlerThread.start();
            o8oO888 = new O8oO888(Oo0.getLooper());
        }
        O8 o8 = new O8(o8oO888, application);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            o8.run();
        } else {
            f610o0O0O.post(o8);
        }
        return true;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static void m1169Ooo(Handler handler) {
        f610o0O0O.postDelayed(new o0o0(handler), 60000L);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean m1171Ooo(Context context) {
        if (context == null || !f608o0o0) {
            return false;
        }
        Application application = (Application) context.getApplicationContext();
        if (f609oO != null) {
            synchronized (Ooo.class) {
                if (f609oO != null) {
                    application.unregisterActivityLifecycleCallbacks(f609oO);
                    HandlerThread handlerThread = Oo0;
                    if (handlerThread != null) {
                        handlerThread.quitSafely();
                        Oo0 = null;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
