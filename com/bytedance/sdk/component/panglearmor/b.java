package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static volatile b d;
    private final ArrayList<String> hc = new ArrayList<>();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private long c = System.currentTimeMillis();
    private long u = 0;
    private long an = 0;
    private String h = "";
    private String gb = "";
    private String tt = "";
    private boolean tc = false;
    private boolean mk = false;

    public static b d(Application application) {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    b bVar = new b();
                    d = bVar;
                    bVar.tc = tc.d(application);
                    d.mk = tc.d(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    d.d();
                }
            }
        }
        return d;
    }

    public void d(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.hc.size() == 0) {
            this.h = localClassName;
            this.u = System.currentTimeMillis();
            this.an = System.currentTimeMillis() - this.c;
            this.b.set(false);
        }
        if (!this.hc.contains(localClassName)) {
            this.hc.add(localClassName);
        }
        this.tt = localClassName;
    }

    public void hc(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.hc.contains(localClassName)) {
            this.hc.remove(localClassName);
        }
        if (this.hc.size() == 0) {
            this.c = System.currentTimeMillis();
            this.b.set(true);
            this.gb = localClassName;
        }
    }

    private void d() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int size;
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
                if (arrayMap != null && (size = arrayMap.size()) > 0) {
                    Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                    Field declaredField2 = cls2.getDeclaredField("stopped");
                    declaredField2.setAccessible(true);
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    for (int i = 0; i < size; i++) {
                        Object objValueAt = arrayMap.valueAt(i);
                        if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                            String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                            if (!this.hc.contains(localClassName)) {
                                this.hc.add(localClassName);
                            }
                        }
                    }
                    this.b.set(this.hc.size() <= 0);
                }
            } catch (Exception unused) {
            }
        }
    }

    public String d(String str, long j, int i, boolean z) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.u;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.b.get() && this.mk) {
            i2 |= 2;
        }
        if (!this.b.get() && this.an >= 5000 && j2 < 1000) {
            i2 = this.gb.equals(this.tt) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("bakdur", this.an).put("popt", j2).put("uct", j3).put("isbak", this.b).put("alert", this.mk).put("rit", i).put("tag", str).put("sys", this.tc).put("size", this.hc.size()).put("mutipro", z).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.h = "";
        this.an = 0L;
        this.u = 0L;
        this.c = System.currentTimeMillis();
        return string;
    }
}
