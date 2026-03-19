package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class BDStatCore {
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;
    private static BDStatCore a;
    private Handler b;
    private SessionAnalysis d;
    private EventAnalysis e;
    private Runnable f;
    private Handler i;
    private volatile boolean c = false;
    private long g = 0;
    private volatile boolean h = false;

    public static BDStatCore instance() {
        if (a == null) {
            synchronized (BDStatCore.class) {
                if (a == null) {
                    a = new BDStatCore();
                }
            }
        }
        return a;
    }

    private BDStatCore() {
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
        this.d = new SessionAnalysis();
        this.e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.i = new Handler(handlerThread2.getLooper());
    }

    private void a(Context context) {
        String appKey = CooperService.instance().getAppKey(context);
        if (!TextUtils.isEmpty(appKey)) {
            p.a(appKey);
        }
    }

    public void init(final Context context) {
        a(context);
        if (this.c) {
            return;
        }
        ActivityLifeTask.registerActivityLifeCallback(context);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.1
            @Override // java.lang.Runnable
            public void run() {
                if (BDStatCore.this.c) {
                    return;
                }
                PrefOperate.loadMetaDataConfig(context);
                BDStatCore.this.c = true;
            }
        });
    }

    public void setAutoSendLog(Context context, boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        this.d.setAutoSend(z);
    }

    public void setSessionTimeOut(int i) {
        this.d.setSessionTimeOut(i);
    }

    public JSONObject getPageSessionHead() {
        return this.d.getPageSessionHead();
    }

    public long getSessionStartTime() {
        return this.d.getSessionStartTime();
    }

    public int getSessionSize() {
        return this.d.getSessionSize();
    }

    public void onSessionStart(final Context context, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.12
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.d.onSessionStart(context, jCurrentTimeMillis, z);
            }
        });
    }

    public void autoTrackLaunchInfo(Context context, final LaunchInfo launchInfo, final boolean z) {
        if (launchInfo == null) {
            return;
        }
        if (z) {
            this.d.autoTrackLaunchInfo(launchInfo, z);
        } else {
            init(context);
            this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.17
                @Override // java.lang.Runnable
                public void run() {
                    BDStatCore.this.d.autoTrackLaunchInfo(launchInfo, z);
                }
            });
        }
    }

    public void autoTrackSessionStartTime(final Context context) {
        if (context == null) {
            return;
        }
        init(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.18
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.d.autoTrackSessionStartTime(context, jCurrentTimeMillis);
            }
        });
    }

    public void autoTrackSessionEndTime(final Context context) {
        if (context == null) {
            return;
        }
        init(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.19
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.d.autoTrackSessionEndTime(context, jCurrentTimeMillis);
            }
        });
    }

    public void doSendLogCheck(final Context context) {
        if (context == null) {
            return;
        }
        int sessionTimeOut = this.d.getSessionTimeOut();
        this.f = new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!CooperService.instance().isCloseTrace()) {
                        BDStatCore.this.d.doSendLogCheck(context, System.currentTimeMillis());
                    } else {
                        ActivityLifeObserver.instance().clearObservers();
                        ActivityLifeObserver.instance().unRegister(context);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.b.postDelayed(this.f, sessionTimeOut);
    }

    public void doSendNewSessionLog(Context context) {
    }

    public void cancelSendLogCheck() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.b.removeCallbacks(runnable);
        }
        this.f = null;
    }

    public void onPageStart(final Context context, final String str) throws ClassNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        final int iA = a();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.21
            @Override // java.lang.Runnable
            public void run() {
                v.c().a("Start page view " + str);
                BDStatCore.this.d.onPageStart(context, str, iA, jCurrentTimeMillis);
            }
        });
    }

    public void onPageEnd(Context context, String str, ExtraInfo extraInfo) {
        onPageEnd(context, str, extraInfo, false);
    }

    public void onPageEnd(final Context context, final String str, final ExtraInfo extraInfo, final boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        final String strB = b();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.22
            @Override // java.lang.Runnable
            public void run() {
                v.c().a("End page view " + str);
                BDStatCore.this.d.onPageEnd(context, str, str, strB, jCurrentTimeMillis, extraInfo, z);
            }
        });
    }

    public void onResume(Activity activity, final boolean z) {
        final Context applicationContext;
        if (activity == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(activity);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.2
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (z) {
                    q.a().a(applicationContext, name);
                }
                if (!z) {
                    v.c().a("Start page view " + cls.getSimpleName());
                }
                BDStatCore.this.d.onPageStartAct(applicationContext, name, jCurrentTimeMillis, z);
            }
        });
    }

    public void onResume(Fragment fragment) {
        FragmentActivity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.3
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Fragment fragment2 = (Fragment) weakReference.get();
                if (fragment2 == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long jCurrentTimeMillis = System.currentTimeMillis();
                v.c().a("Start page view " + cls.getSimpleName());
                BDStatCore.this.d.onPageStartFrag(applicationContext, name, jCurrentTimeMillis);
            }
        });
    }

    public void onResume(android.app.Fragment fragment) {
        Activity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.4
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                android.app.Fragment fragment2 = (android.app.Fragment) weakReference.get();
                if (fragment2 == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long jCurrentTimeMillis = System.currentTimeMillis();
                v.c().a("Start page view " + cls.getSimpleName());
                BDStatCore.this.d.onPageStartFrag(applicationContext, name, jCurrentTimeMillis);
            }
        });
    }

    public void onPause(Activity activity, final boolean z, final ExtraInfo extraInfo) {
        final Context applicationContext;
        if (activity == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(activity);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.5
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String string = title == null ? "" : title.toString();
                if (!z) {
                    v.c().a("End page view " + cls.getSimpleName());
                }
                BDStatCore.this.d.onPageEndAct(applicationContext, name, simpleName, string, System.currentTimeMillis(), z, extraInfo);
            }
        });
    }

    public void onPause(final Fragment fragment) {
        final FragmentActivity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.6
            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2 = (Fragment) weakReference.get();
                if (fragment2 == null || fragment2.getClass() == null) {
                    return;
                }
                String name = fragment.getClass().getName();
                String simpleName = fragment.getClass().getSimpleName();
                CharSequence title = activity.getTitle();
                String string = title == null ? "" : title.toString();
                v.c().a("End page view " + simpleName);
                BDStatCore.this.d.onPageEndFrag(applicationContext, name, simpleName, string, System.currentTimeMillis());
            }
        });
    }

    public void onPause(final android.app.Fragment fragment) {
        final Activity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.7
            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2 = (android.app.Fragment) weakReference.get();
                if (fragment2 == null || fragment2.getClass() == null) {
                    return;
                }
                String name = fragment.getClass().getName();
                String simpleName = fragment.getClass().getSimpleName();
                CharSequence title = activity.getTitle();
                String string = title == null ? "" : title.toString();
                v.c().a("End page view " + simpleName);
                BDStatCore.this.d.onPageEndFrag(applicationContext, name, simpleName, string, System.currentTimeMillis());
            }
        });
    }

    private int a() throws ClassNotFoundException {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (ClassNotFoundException e) {
            cls = null;
        }
        try {
            cls2 = Class.forName("android.support.v4.app.Fragment");
        } catch (ClassNotFoundException e2) {
            cls2 = null;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; stackTrace != null && i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!TextUtils.isEmpty(className) && "onResume".equals(stackTrace[i].getMethodName())) {
                try {
                    cls3 = Class.forName(className);
                } catch (Throwable th) {
                    cls3 = null;
                }
                if (cls3 == null) {
                    continue;
                } else {
                    if (Activity.class.isAssignableFrom(cls3)) {
                        return 1;
                    }
                    if (cls != null && cls.isAssignableFrom(cls3)) {
                        return 2;
                    }
                    if (cls2 != null && cls2.isAssignableFrom(cls3)) {
                        return 2;
                    }
                }
            }
        }
        return 3;
    }

    private String b() {
        Class<?> cls;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className)) {
                try {
                    cls = Class.forName(className);
                } catch (Throwable th) {
                    cls = null;
                }
                if (cls != null && Activity.class.isAssignableFrom(cls)) {
                    return cls.getName();
                }
            }
        }
        return "";
    }

    public void onEvent(Context context, String str, String str2, int i, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEvent(context, str, str2, i, extraInfo, map, z, false);
    }

    public void onEvent(final Context context, final String str, final String str2, final int i, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z, final boolean z2) {
        if (context == null) {
            return;
        }
        init(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.8
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.d.onSessionStart(context, jCurrentTimeMillis, z);
                v.c().a("Put event" + BDStatCore.this.a(str, str3, i, 0L, map, extraInfo));
                BDStatCore.this.e.onEvent(context, BDStatCore.this.d.getSessionStartTime(), str, str3, i, jCurrentTimeMillis, extraInfo, map, z2);
            }
        });
    }

    public void onEvent(final Context context, final String str, final String str2, final int i, final String str3, final String str4, final int i2, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.9
            @Override // java.lang.Runnable
            public void run() {
                String str5 = str2;
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                BDStatCore.this.d.onSessionStart(context, jCurrentTimeMillis, false);
                v.c().a("Put event" + BDStatCore.this.a(str, str5, i, 0L, null, null));
                BDStatCore.this.e.onEvent(context, BDStatCore.this.d.getSessionStartTime(), str, str5, i, jCurrentTimeMillis, str3, str4, i2, z);
            }
        });
    }

    public void onEvent(Context context, String str, String str2, int i, long j, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        onEvent(context, str, str2, i, j, jSONArray, jSONArray2, str3, str4, str5, map, false);
    }

    public void onEvent(final Context context, final String str, final String str2, final int i, final long j, final JSONArray jSONArray, final JSONArray jSONArray2, final String str3, final String str4, final String str5, final Map<String, String> map, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.10
            @Override // java.lang.Runnable
            public void run() {
                String str6 = str2;
                if (TextUtils.isEmpty(str6)) {
                    str6 = "";
                }
                BDStatCore.this.d.onSessionStart(context, j, false);
                v.c().a("Put event" + BDStatCore.this.a(str, str6, i, 0L, map, null));
                BDStatCore.this.e.onEvent(context, BDStatCore.this.d.getSessionStartTime(), str, str6, i, j, jSONArray, jSONArray2, str3, str4, str5, map, z);
            }
        });
    }

    public void onEventStart(final Context context, final String str, final String str2, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.11
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.d.onSessionStart(context, jCurrentTimeMillis, z);
                v.c().a("Start event" + BDStatCore.this.a(str, str3, 1, -1L, null, null));
                BDStatCore.this.e.onEventStart(context, str, str3, jCurrentTimeMillis);
            }
        });
    }

    public void onEventEnd(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        onEventEnd(context, str, str2, extraInfo, map, false);
    }

    public void onEventEnd(final Context context, final String str, final String str2, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.13
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                long sessionStartTime = BDStatCore.this.d.getSessionStartTime();
                v.c().a("End event" + BDStatCore.this.a(str, str3, 1, -1L, map, extraInfo));
                BDStatCore.this.e.onEventEnd(context, sessionStartTime, str, str3, jCurrentTimeMillis, extraInfo, map, z);
            }
        });
    }

    public void onEventDuration(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEventDuration(context, str, str2, j, extraInfo, map, z, false);
    }

    public void onEventDuration(final Context context, final String str, final String str2, final long j, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z, final boolean z2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.14
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.d.onSessionStart(context, jCurrentTimeMillis, z);
                v.c().a("Put event" + BDStatCore.this.a(str, str3, 1, j, map, extraInfo));
                BDStatCore.this.e.onEventDuration(context, BDStatCore.this.d.getSessionStartTime(), str, str3, jCurrentTimeMillis, j, extraInfo, map, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, int i, long j, Map<String, String> map, ExtraInfo extraInfo) throws JSONException {
        JSONObject jSONObject;
        StringBuilder sb = new StringBuilder();
        JSONObject jSONObjectDumpToJson = null;
        if (map != null && map.size() != 0) {
            try {
                jSONObject = new JSONObject(map.toString());
            } catch (Exception e) {
            }
        } else {
            jSONObject = null;
        }
        if (extraInfo != null) {
            jSONObjectDumpToJson = extraInfo.dumpToJson();
        }
        sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i);
        if (j > 0) {
            sb.append(", with duration " + j);
        }
        if (jSONObject != null && jSONObject.length() != 0) {
            sb.append(", with attributes " + jSONObject);
        }
        if (jSONObjectDumpToJson != null && jSONObjectDumpToJson.length() != 0) {
            sb.append(", with extraInfo " + jSONObjectDumpToJson);
        }
        return sb.toString();
    }

    public void onStat(final Context context, final String str) {
        if (this.d.isSessionStart()) {
            return;
        }
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.15
            @Override // java.lang.Runnable
            public void run() {
                LogSender.instance().sendEmptyLogData(context, str);
            }
        });
    }

    public void onErised(final Context context, String str, final String str2, final String str3) {
        if (this.d.isSessionStart()) {
            return;
        }
        init(context);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.forbes.BDStatCore.16
            @Override // java.lang.Runnable
            public void run() {
                DataCore.instance().init(context);
                BDStatCore.this.e.onEvent(context, jCurrentTimeMillis, str2, str3, 1, jCurrentTimeMillis, null, null, false);
                DataCore.instance().saveLogData(context, true, false, jCurrentTimeMillis, false);
                if (jCurrentTimeMillis - BDStatCore.this.g > 30000 && ar.h(context)) {
                    LogSender.instance().onSend(context);
                    BDStatCore.this.g = jCurrentTimeMillis;
                }
            }
        });
    }

    private void b(Context context) {
    }
}
