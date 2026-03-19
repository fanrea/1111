package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kuaishou.socket.nano.SocketMessages;
import com.sigmob.sdk.base.mta.PointType;
import com.tencent.turingfd.sdk.ams.au.Cprotected;
import com.tencent.turingfd.sdk.ams.au.Gooseberry;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Hickory {
    public static final String i = Cfinally.a(Cfinally.b1);
    public static final String j = Cfinally.a(Cfinally.c1);
    public static final String k = Cfinally.a(Cfinally.d1);
    public static final Hickory l = new Hickory();
    public static final long m = TimeUnit.MINUTES.toMillis(30);
    public static final int[] n = {0, 15, 30, 90, 240, 360, 600, SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC, 2400, 3200, 4800, 7200};
    public Foxnut a;
    public Handler b;
    public Kiwifruit d;
    public boolean c = false;
    public final Object e = new Object();
    public final AtomicReference<Gooseberry> f = new AtomicReference<>(null);
    public final AtomicReference<Boolean> g = new AtomicReference<>(Boolean.FALSE);
    public final AtomicReference<FutureTask<Cprotected.Cdo>> h = new AtomicReference<>(null);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Hickory$do, reason: invalid class name */
    public class Cdo extends Handler {
        public Context a;

        public Cdo(Looper looper, Context context) {
            super(looper);
            this.a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws NumberFormatException {
            System.currentTimeMillis();
            int i = message.what;
            if (i == 1) {
                Hickory.this.a(this.a, true, 3);
                return;
            }
            if (i != 2) {
                return;
            }
            Hickory.this.a(Hickory.this.a(this.a, true, false, ((Integer) message.obj).intValue()), false);
            synchronized (Hickory.this.g) {
                Hickory.this.g.set(Boolean.FALSE);
                Hickory.this.g.notifyAll();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.tencent.turingfd.sdk.ams.au.Hickory r13) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Hickory.a(com.tencent.turingfd.sdk.ams.au.Hickory):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x084b  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x08ae A[LOOP:1: B:323:0x08a8->B:325:0x08ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0934  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0987  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0572 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingfd.sdk.ams.au.Gooseberry b(android.content.Context r27, boolean r28, int r29) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Hickory.b(android.content.Context, boolean, int):com.tencent.turingfd.sdk.ams.au.Gooseberry");
    }

    public Gooseberry a(Context context) {
        Gooseberry gooseberry;
        Gooseberry gooseberryA;
        synchronized (this.f) {
            gooseberry = this.f.get();
            if (gooseberry == null) {
                Kiwifruit kiwifruit = this.d;
                if (kiwifruit != null) {
                    gooseberryA = kiwifruit.a(context);
                } else {
                    gooseberryA = Gooseberry.a(1);
                }
                gooseberry = gooseberryA;
                this.f.set(gooseberry);
            }
        }
        return gooseberry;
    }

    public final void a(Gooseberry gooseberry, boolean z) {
        synchronized (this.f) {
            try {
                if (gooseberry == null) {
                    return;
                }
                if (z || gooseberry.c == 0) {
                    this.f.set(gooseberry);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this.g) {
            if (this.g.get().booleanValue()) {
                return;
            }
            this.g.set(Boolean.TRUE);
            this.b.sendMessageDelayed(Message.obtain(this.b, 2, 3), 0L);
        }
    }

    public final Gooseberry a(Context context, boolean z, int i2) {
        Gooseberry gooseberryA;
        Gooseberry gooseberryA2 = a(context);
        if (this.a == null) {
            return Gooseberry.a(-10002);
        }
        int iA = a(gooseberryA2);
        if (iA == 1) {
            return gooseberryA2;
        }
        if (iA != 2) {
            if (iA == 3) {
                a();
            }
            return gooseberryA2;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
            return Gooseberry.a(-10008);
        }
        synchronized (this.e) {
            gooseberryA = a(context);
            if (gooseberryA == gooseberryA2 || a(gooseberryA) != 1) {
                synchronized (this.g) {
                    if (!this.g.get().booleanValue()) {
                        this.g.set(Boolean.TRUE);
                        this.b.post(new Guava(this, context, true, i2));
                    }
                    try {
                        this.g.wait(z ? this.a.w : ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    } catch (InterruptedException unused) {
                    }
                }
                gooseberryA = a(context);
                if (gooseberryA == gooseberryA2) {
                    gooseberryA = Gooseberry.a(-10004);
                }
            }
        }
        return gooseberryA;
    }

    public final int a(Gooseberry gooseberry) {
        Context context;
        long jLongValue;
        Context context2;
        if (this.a.s || gooseberry.c != 0 || TextUtils.isEmpty(gooseberry.a)) {
            return 2;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (jCurrentTimeMillis >= gooseberry.b) {
            this.a.getClass();
            return 3;
        }
        Kiwifruit kiwifruit = this.d;
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        kiwifruit.getClass();
        try {
            jLongValue = Long.valueOf(Kiwifruit.b(context, PointType.WIND_ACTIVE)).longValue();
        } catch (Throwable unused) {
            jLongValue = 0;
        }
        Kiwifruit kiwifruit2 = this.d;
        synchronized (Ccase.class) {
            context2 = Ccase.a;
        }
        if (Math.abs(jCurrentTimeMillis - kiwifruit2.a(context2, "108")) < jLongValue) {
            return 1;
        }
        this.a.getClass();
        return 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
    
        if (r19 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e6, code lost:
    
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r8.longValue()) >= com.tencent.turingfd.sdk.ams.au.Hickory.m) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ef, code lost:
    
        return com.tencent.turingfd.sdk.ams.au.Gooseberry.a(-10011);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingfd.sdk.ams.au.Gooseberry a(android.content.Context r17, boolean r18, boolean r19, int r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Hickory.a(android.content.Context, boolean, boolean, int):com.tencent.turingfd.sdk.ams.au.Gooseberry");
    }

    public final Gooseberry a(Context context, byte[] bArr, int i2) {
        try {
            HashMap map = new HashMap();
            if (Lemon.f.a("e_w_t", false)) {
                map.put("2007", "1");
            }
            SparseArray<Object> sparseArrayB90_BD4FE23C352252DC = TNative$aa.b90_BD4FE23C352252DC(new SparseArray(), bArr, map, i2);
            int iB = Sagittarius.b(sparseArrayB90_BD4FE23C352252DC);
            if (iB != 0) {
                return Gooseberry.a(iB);
            }
            Integer num = (Integer) Sagittarius.a(sparseArrayB90_BD4FE23C352252DC, 102, Integer.class);
            if (num == null) {
                return Gooseberry.a(-30000);
            }
            if (num.intValue() < 0) {
                return Gooseberry.a(num.intValue() - 30000);
            }
            String str = (String) Sagittarius.a(sparseArrayB90_BD4FE23C352252DC, 101, String.class);
            int i3 = Date.a;
            if (str == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return Gooseberry.a(num.intValue() - 10010);
            }
            String str2 = (String) Sagittarius.a(sparseArrayB90_BD4FE23C352252DC, 104, String.class);
            if (str2 == null) {
                str2 = "";
            }
            String str3 = (String) Sagittarius.a(sparseArrayB90_BD4FE23C352252DC, 105, String.class);
            if (str3 == null) {
                str3 = "";
            }
            String str4 = (String) Sagittarius.a(sparseArrayB90_BD4FE23C352252DC, 106, String.class);
            if (str4 == null) {
                str4 = "";
            }
            Integer num2 = (Integer) Sagittarius.a(sparseArrayB90_BD4FE23C352252DC, 107, Integer.class);
            String str5 = (String) Sagittarius.a(sparseArrayB90_BD4FE23C352252DC, 108, String.class);
            if (str5 == null) {
                str5 = "";
            }
            if (num2 == null || num2.intValue() < 3600) {
                num2 = 3600;
            }
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + num2.intValue();
            Gooseberry.Cdo cdo = new Gooseberry.Cdo(0);
            cdo.b = jCurrentTimeMillis;
            cdo.a = str;
            cdo.d = str2;
            cdo.e = str3;
            cdo.f = str4;
            cdo.g = str5;
            Gooseberry gooseberry = new Gooseberry(cdo);
            Kiwifruit kiwifruit = this.d;
            kiwifruit.getClass();
            HashMap map2 = new HashMap();
            map2.put(PointType.ANTI_SPAM, gooseberry.a);
            map2.put(PointType.ANTI_SPAM_TOUCH, "" + gooseberry.b);
            if (!TextUtils.isEmpty(gooseberry.d)) {
                map2.put("104", gooseberry.d);
            }
            if (!TextUtils.isEmpty(gooseberry.e)) {
                map2.put("105", gooseberry.e);
            }
            if (!TextUtils.isEmpty(gooseberry.f)) {
                map2.put("106", gooseberry.f);
            }
            if (!TextUtils.isEmpty(gooseberry.g)) {
                map2.put("110", gooseberry.g);
            }
            kiwifruit.a(context, (Map<String, String>) map2, true);
            Kiwifruit kiwifruit2 = this.d;
            long jIntValue = num2.intValue();
            kiwifruit2.getClass();
            kiwifruit2.a(context, PointType.WIND_ACTIVE, "" + jIntValue, true);
            kiwifruit2.a(context, "108", "" + (System.currentTimeMillis() / 1000), true);
            return gooseberry;
        } catch (Throwable unused) {
            return Gooseberry.a(-10007);
        }
    }

    public static String a(long j2, long j3) {
        MediaDrm mediaDrm;
        try {
            UUID uuid = new UUID(j2, j3);
            mediaDrm = new MediaDrm(uuid);
            try {
                byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                if (propertyByteArray.length == 0) {
                    try {
                        if (Build.VERSION.SDK_INT >= 28) {
                            mediaDrm.release();
                        } else {
                            mediaDrm.release();
                        }
                    } catch (Throwable unused) {
                    }
                    return null;
                }
                String str = uuid + ":" + Date.a(propertyByteArray);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        mediaDrm.release();
                    } else {
                        mediaDrm.release();
                    }
                } catch (Throwable unused2) {
                }
                return str;
            } catch (Throwable unused3) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (mediaDrm != null) {
                            mediaDrm.release();
                        }
                    } else if (mediaDrm != null) {
                        mediaDrm.release();
                    }
                } catch (Throwable unused4) {
                }
                return null;
            }
        } catch (Throwable unused5) {
            mediaDrm = null;
        }
    }
}
