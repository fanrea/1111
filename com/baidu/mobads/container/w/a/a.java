package com.baidu.mobads.container.w.a;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.w.b.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends com.baidu.mobads.container.w.c.g {
    private static long b = 0;
    private static final long c = 20000;
    private static final int e = 4500;
    private static final int f = 500;
    private static final int g = 20000;
    private static final int h = 40;
    private FileObserver a;
    private f d;
    private boolean i = false;
    private final com.baidu.mobads.container.w.d.a j = new com.baidu.mobads.container.w.d.a();

    @Override // com.baidu.mobads.container.w.c.g
    protected void a() {
        super.a();
        if (Build.VERSION.SDK_INT < 21) {
            g();
        } else {
            f();
        }
    }

    private void f() {
        this.d = new f(e);
        this.d.a(new b(this));
        this.d.start();
    }

    private void g() {
        this.a = new c(this, "/data/anr/", 8);
        try {
            this.a.startWatching();
        } catch (Throwable th) {
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - b >= c) {
                b = jCurrentTimeMillis;
                i();
            }
        } catch (Throwable th) {
        }
    }

    private void i() {
        if (this.i && Build.VERSION.SDK_INT >= 23 && k()) {
            com.baidu.mobads.container.d.b.a().a(new d(this, "Mobads-Check-ANR-State-Thread"));
        } else {
            com.baidu.mobads.container.d.b.a().a(new e(this, "Mobads-Check-ANR-State-Thread"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        try {
            h hVar = (h) com.baidu.mobads.container.w.b.d.b().a(h.class);
            if (hVar == null) {
                return;
            }
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            com.baidu.mobads.container.w.h.g gVar = new com.baidu.mobads.container.w.h.g();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString()).append("\r\n");
                arrayList.add(stackTraceElement.getClassName());
                arrayList2.add(stackTraceElement.getMethodName());
            }
            gVar.c(arrayList2);
            gVar.b(arrayList);
            JSONObject jSONObject = new JSONObject();
            try {
                float fD = com.baidu.mobads.container.w.f.a.a().d();
                float fC = com.baidu.mobads.container.w.f.a.b(com.baidu.mobads.container.w.b.d.b().c()).c();
                jSONObject.put("appUseMemory", String.format("%.2f", Float.valueOf(fD * 100.0f)));
                jSONObject.put("sysUseMemory", String.format("%.2f", Float.valueOf(fC * 100.0f)));
                jSONObject.put("cpuUseRate", String.format("%.2f", Float.valueOf(this.j.c())));
                jSONObject.put("stacktrace", sb.toString());
                if (processErrorStateInfo != null) {
                    jSONObject.put("anrTag", processErrorStateInfo.tag);
                    jSONObject.put("anrMsg", processErrorStateInfo.shortMsg);
                    String str = processErrorStateInfo.longMsg;
                    if (!TextUtils.isEmpty(str)) {
                        Matcher matcher = Pattern.compile("(\\d+(\\.\\d+)?)(?=% TOTAL)").matcher(str);
                        if (matcher.find()) {
                            jSONObject.put("anrSysCpu", String.format("%.2f", Float.valueOf(Float.parseFloat(matcher.group()) / com.baidu.mobads.container.w.d.a.a())));
                        }
                        Matcher matcher2 = Pattern.compile("(\\d+(\\.\\d+)?)" + "(?=% \\d+/x)".replace("x", com.baidu.mobads.container.w.b.d.b().c().getPackageName())).matcher(str);
                        if (matcher2.find()) {
                            jSONObject.put("anrAppCpu", String.format("%.2f", Float.valueOf(Float.parseFloat(matcher2.group()) / com.baidu.mobads.container.w.d.a.a())));
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.baidu.mobads.container.w.b.f fVar = new com.baidu.mobads.container.w.b.f();
            fVar.a(com.baidu.mobads.container.w.g.a.ANR_TAG);
            fVar.a(gVar);
            fVar.a(jSONObject);
            hVar.a(fVar);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActivityManager.ProcessErrorStateInfo j() {
        int i = 0;
        while (i < 40) {
            i++;
            try {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfoL = l();
                if (processErrorStateInfoL != null) {
                    return processErrorStateInfoL;
                }
                Thread.sleep(500L);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    private boolean k() throws NoSuchFieldException {
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            Message message = (Message) declaredField.get(queue);
            if (message == null) {
                return false;
            }
            long when = message.getWhen();
            if (when == 0) {
                return false;
            }
            return SystemClock.uptimeMillis() - when > 5000;
        } catch (Exception e2) {
            return false;
        }
    }

    private ActivityManager.ProcessErrorStateInfo l() {
        try {
            List<ActivityManager.ProcessErrorStateInfo> listB = new com.component.c.a(com.baidu.mobads.container.w.b.d.b().c()).b();
            if (listB == null) {
                return null;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : listB) {
                if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                    return processErrorStateInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.baidu.mobads.container.w.c.g
    protected void b() {
        super.b();
        if (this.d != null) {
            this.d.interrupt();
        }
        if (this.a != null) {
            this.a.stopWatching();
        }
    }
}
