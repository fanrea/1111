package com.netease.htprotect.p023o0O0O;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.components.command.j;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.netease.htprotect.〇o〇0O〇0O.〇O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O implements SensorEventListener {

    /* renamed from: OO〇8, reason: contains not printable characters */
    private static volatile int f582OO8 = 30;

    /* renamed from: O〇80Oo0O, reason: contains not printable characters */
    private static volatile boolean f583O80Oo0O = false;

    /* renamed from: oo0〇OO〇O8, reason: contains not printable characters */
    private static volatile int f584oo0OOO8 = 3;

    /* renamed from: 〇00oOOo, reason: contains not printable characters */
    private static volatile int f58500oOOo = 100;

    /* renamed from: 〇O, reason: contains not printable characters */
    private static volatile boolean f586O = false;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static List f587O8 = null;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static volatile boolean f588o0o0 = false;

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static volatile int f589o0O0O = 30;

    /* renamed from: 〇〇, reason: contains not printable characters */
    private static volatile int f590 = 100;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private Context f591O8oO888;
    private String Oo;
    private volatile boolean Oo0;

    /* renamed from: O〇o8ooOo〇, reason: contains not printable characters */
    private long f592Oo8ooOo;

    /* renamed from: O〇〇〇o, reason: contains not printable characters */
    private int f593Oo;

    /* renamed from: o0o8〇, reason: contains not printable characters */
    private int f594o0o8;
    private final ArrayBlockingQueue o8o0;

    /* renamed from: o〇0〇8o〇, reason: contains not printable characters */
    private final AtomicInteger f595o08o;

    /* renamed from: 〇8〇0, reason: contains not printable characters */
    private int f59680;

    /* renamed from: 〇O8O00oo〇, reason: contains not printable characters */
    private final ArrayBlockingQueue f597O8O00oo;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private HandlerThread f598Ooo;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private SensorManager f599oO;

    /* renamed from: 〇oO00O, reason: contains not printable characters */
    private long f600oO00O;

    /* renamed from: com.netease.htprotect.〇o〇0O〇0O.〇O$O8〇oO8〇88, reason: invalid class name */
    private static class O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        static final O f601O8oO888 = new O(0);

        private O8oO888() {
        }
    }

    private O() {
        this.f591O8oO888 = null;
        this.f599oO = null;
        this.Oo0 = false;
        this.Oo = "";
        this.f594o0o8 = 10;
        this.f592Oo8ooOo = 0L;
        this.f593Oo = 100;
        this.f59680 = 100;
        this.f597O8O00oo = new ArrayBlockingQueue(1000);
        this.f600oO00O = 0L;
        this.o8o0 = new ArrayBlockingQueue(200);
        this.f595o08o = new AtomicInteger(0);
    }

    /* synthetic */ O(byte b) {
        this();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static O m1148O8oO888() {
        return O8oO888.f601O8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1149O8oO888(SensorEvent sensorEvent) {
        return sensorEvent.values[0] + "," + sensorEvent.values[1] + "," + sensorEvent.values[2] + "," + System.currentTimeMillis();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1150O8oO888(View view) {
        String name;
        if (view != null) {
            try {
                name = view.getClass().getName();
            } catch (Exception unused) {
                return "";
            }
        } else {
            name = "";
        }
        return TextUtils.isEmpty(name) ? "" : name;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static List m1151O8oO888(SensorManager sensorManager) {
        try {
            return (List) SensorManager.class.getDeclaredMethod("getSensorList", Integer.TYPE).invoke(sensorManager, -1);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1152O8oO888(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i, Handler handler) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SensorManager.class.getDeclaredMethod("registerListener", SensorEventListener.class, Sensor.class, Integer.TYPE, Handler.class).invoke(sensorManager, sensorEventListener, sensor, Integer.valueOf(i), handler);
        } catch (Exception unused) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1153O8oO888(JSONObject jSONObject, String str, String[] strArr) throws JSONException {
        if (m1155O8oO888(strArr)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strArr);
            if (jSONArray.length() > 0) {
                jSONObject.put(str, jSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private synchronized boolean m1154O8oO888(int i, int i2, int i3, int i4, int i5) {
        if (this.f591O8oO888 == null) {
            return false;
        }
        if (!f588o0o0) {
            return false;
        }
        if (this.Oo0) {
            return true;
        }
        if (i4 <= 0) {
            return false;
        }
        if (System.currentTimeMillis() - this.f592Oo8ooOo < i4 * 60 * 1000) {
            return false;
        }
        this.f592Oo8ooOo = System.currentTimeMillis();
        if (i5 <= 0) {
            i5 = 1;
        } else if (i5 > 3) {
            i5 = 3;
        }
        if (i < 10) {
            i = 10;
        } else if (i > 60) {
            i = 60;
        }
        if (i2 < 50) {
            i2 = 50;
        } else if (i2 > 1000) {
            i2 = 1000;
        }
        if (i3 < 50) {
            i3 = 50;
        } else if (i3 > 3000) {
            i3 = 3000;
        }
        this.f594o0o8 = i;
        this.f593Oo = i2;
        this.f59680 = i3;
        SensorManager sensorManager = (SensorManager) this.f591O8oO888.getSystemService("sensor");
        this.f599oO = sensorManager;
        if (sensorManager == null) {
            return false;
        }
        List list = f587O8;
        if (list == null || list.size() == 0) {
            f587O8 = m1151O8oO888(this.f599oO);
        }
        List list2 = f587O8;
        if (list2 == null || list2.size() == 0) {
            return false;
        }
        try {
            HandlerThread handlerThread = new HandlerThread("SensorThread");
            this.f598Ooo = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.f598Ooo.getLooper());
            for (Sensor sensor : f587O8) {
                if (sensor != null && sensor.getType() == 1) {
                    try {
                        SensorManager.class.getDeclaredMethod("registerListener", SensorEventListener.class, Sensor.class, Integer.TYPE, Handler.class).invoke(this.f599oO, this, sensor, Integer.valueOf(i5), handler);
                    } catch (Exception unused) {
                    }
                }
            }
            this.Oo0 = true;
            return true;
        } catch (Exception unused2) {
            this.Oo0 = false;
            return false;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m1155O8oO888(String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String[] m1156O8oO888(ArrayBlockingQueue arrayBlockingQueue) {
        if (arrayBlockingQueue.size() > 0) {
            return (String[]) arrayBlockingQueue.toArray(new String[0]);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:13:0x0025, B:17:0x0058, B:20:0x0075, B:16:0x0056), top: B:24:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075 A[Catch: Exception -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0090, blocks: (B:13:0x0025, B:17:0x0058, B:20:0x0075, B:16:0x0056), top: B:24:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Oo0() throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.util.concurrent.ArrayBlockingQueue r2 = r9.f597O8O00oo     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1f
            java.lang.String[] r2 = m1156O8oO888(r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1f
            java.util.concurrent.ArrayBlockingQueue r3 = r9.o8o0     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L1a
            java.lang.String[] r3 = m1156O8oO888(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L1a
            java.util.concurrent.atomic.AtomicInteger r4 = r9.f595o08o     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L21
            int r4 = r4.getAndSet(r0)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L21
            r9.m1157O()
            goto L25
        L18:
            r3 = r1
            goto L21
        L1a:
            r0 = move-exception
            r9.m1157O()
            throw r0
        L1f:
            r2 = r1
            r3 = r2
        L21:
            r9.m1157O()
            r4 = -1
        L25:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L90
            r5.<init>()     // Catch: java.lang.Exception -> L90
            java.lang.String r6 = "fts"
            long r7 = r9.f592Oo8ooOo     // Catch: java.lang.Exception -> L90
            r5.put(r6, r7)     // Catch: java.lang.Exception -> L90
            java.lang.String r6 = "ts"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L90
            r5.put(r6, r7)     // Catch: java.lang.Exception -> L90
            java.lang.String r6 = "msgId"
            java.util.UUID r7 = java.util.UUID.randomUUID()     // Catch: java.lang.Exception -> L90
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L90
            r5.put(r6, r7)     // Catch: java.lang.Exception -> L90
            java.lang.String r6 = "view"
            java.lang.String r7 = r9.Oo     // Catch: java.lang.Exception -> L90
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L90
            if (r7 == 0) goto L56
            java.lang.String r7 = ""
            goto L58
        L56:
            java.lang.String r7 = r9.Oo     // Catch: java.lang.Exception -> L90
        L58:
            r5.put(r6, r7)     // Catch: java.lang.Exception -> L90
            java.lang.String r6 = "acc"
            m1153O8oO888(r5, r6, r2)     // Catch: java.lang.Exception -> L90
            java.lang.String r2 = "md"
            m1153O8oO888(r5, r2, r3)     // Catch: java.lang.Exception -> L90
            java.lang.String r2 = "mc"
            r5.put(r2, r4)     // Catch: java.lang.Exception -> L90
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Exception -> L90
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L90
            if (r3 == 0) goto L75
            return
        L75:
            java.lang.String r3 = "com.netease.htprotect.poly.a"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L90
            java.lang.String r4 = "z"
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L90
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r0] = r7     // Catch: java.lang.Exception -> L90
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r6)     // Catch: java.lang.Exception -> L90
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L90
            r4[r0] = r2     // Catch: java.lang.Exception -> L90
            r3.invoke(r1, r4)     // Catch: java.lang.Exception -> L90
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.p023o0O0O.O.Oo0():void");
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private void m1157O() {
        try {
            this.f597O8O00oo.clear();
            this.o8o0.clear();
        } catch (Exception unused) {
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public static boolean m1158o0o0() {
        return f586O;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private synchronized void m1159oO() {
        String[] strArrM1156O8oO888;
        String[] strArrM1156O8oO8882;
        this.Oo0 = false;
        SensorManager sensorManager = this.f599oO;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f599oO = null;
        }
        HandlerThread handlerThread = this.f598Ooo;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f598Ooo = null;
        }
        int andSet = -1;
        try {
            try {
                try {
                    strArrM1156O8oO888 = m1156O8oO888(this.f597O8O00oo);
                    try {
                        strArrM1156O8oO8882 = m1156O8oO888(this.o8o0);
                        try {
                            andSet = this.f595o08o.getAndSet(0);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        strArrM1156O8oO8882 = null;
                    }
                } catch (Exception unused3) {
                    strArrM1156O8oO888 = null;
                    strArrM1156O8oO8882 = null;
                }
                m1157O();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fts", this.f592Oo8ooOo);
                    jSONObject.put(j.s, System.currentTimeMillis());
                    jSONObject.put("msgId", UUID.randomUUID().toString());
                    jSONObject.put("view", TextUtils.isEmpty(this.Oo) ? "" : this.Oo);
                    m1153O8oO888(jSONObject, "acc", strArrM1156O8oO888);
                    m1153O8oO888(jSONObject, LiveConfigKey.MEDIUM, strArrM1156O8oO8882);
                    jSONObject.put("mc", andSet);
                    String string = jSONObject.toString();
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    try {
                        Class.forName("com.netease.htprotect.poly.a").getDeclaredMethod("z", String.class).invoke(null, string);
                    } catch (Exception unused4) {
                    }
                } catch (Exception unused5) {
                }
            } catch (Throwable th) {
                m1157O();
                throw th;
            }
        } catch (Exception unused6) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m1160O8oO888(String str) {
        if (this.o8o0.remainingCapacity() == 0) {
            this.o8o0.poll();
        }
        this.o8o0.offer(str);
        this.f595o08o.incrementAndGet();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final synchronized void m1161O8oO888(boolean z, int i, int i2, int i3, int i4, int i5) {
        f586O = z;
        if (z) {
            if (i < 10 || i > 600) {
                return;
            }
            if (i2 < 50 || i2 > 1000) {
                return;
            }
            if (i3 < 50 || i3 > 3000) {
                return;
            }
            if (i4 <= 0) {
                return;
            }
            if (i5 <= 0 || i5 > 3) {
                return;
            }
            f583O80Oo0O = true;
            f589o0O0O = i;
            f590 = i2;
            f58500oOOo = i3;
            f582OO8 = i4;
            f584oo0OOO8 = i5;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final boolean m1162O8oO888(Context context) {
        if (context == null) {
            return false;
        }
        if (f588o0o0) {
            return true;
        }
        this.f591O8oO888 = context;
        f588o0o0 = true;
        return true;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (System.currentTimeMillis() - this.f592Oo8ooOo >= this.f594o0o8 * 1000) {
            m1159oO();
            return;
        }
        if (this.f597O8O00oo.size() >= this.f593Oo) {
            m1159oO();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f600oO00O < this.f59680) {
            return;
        }
        this.f600oO00O = jCurrentTimeMillis;
        if (sensorEvent.sensor.getType() == 1) {
            try {
                this.f597O8O00oo.offer(sensorEvent.values[0] + "," + sensorEvent.values[1] + "," + sensorEvent.values[2] + "," + System.currentTimeMillis());
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final boolean m1163O8() {
        return this.Oo0;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final boolean m1164Ooo() {
        if (f586O && f583O80Oo0O) {
            return m1154O8oO888(f589o0O0O, f590, f58500oOOo, f582OO8, f584oo0OOO8);
        }
        return false;
    }
}
