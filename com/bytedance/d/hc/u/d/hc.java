package com.bytedance.d.hc.u.d;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static com.bytedance.d.hc.c w;
    private long cb;
    private Application d;
    private String e;
    private long gb;
    private String h;
    private Context hc;
    private long k;
    private String mk;
    private long mq;
    private long tc;
    private String tt;
    private String uo;
    private List<String> b = new ArrayList();
    private List<Long> c = new ArrayList();
    private List<String> u = new ArrayList();
    private List<Long> an = new ArrayList();
    private int yo = 0;
    private boolean rf = false;
    private final Application.ActivityLifecycleCallbacks jh = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.d.hc.u.d.hc.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String strD;
            hc hcVar = hc.this;
            if (hc.w != null) {
                strD = hc.w.d(activity);
            } else {
                strD = activity.getClass().getName();
            }
            hcVar.h = strD;
            hc.this.gb = System.currentTimeMillis();
            hc.this.b.add(hc.this.h);
            hc.this.c.add(Long.valueOf(hc.this.gb));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            String strD;
            hc hcVar = hc.this;
            if (hc.w != null) {
                strD = hc.w.d(activity);
            } else {
                strD = activity.getClass().getName();
            }
            hcVar.tt = strD;
            hc.this.tc = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String strD;
            hc hcVar = hc.this;
            if (hc.w != null) {
                strD = hc.w.d(activity);
            } else {
                strD = activity.getClass().getName();
            }
            hcVar.mk = strD;
            hc.this.mq = System.currentTimeMillis();
            hc.this.rf = true;
            hc.u(hc.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String strD;
            hc hcVar = hc.this;
            if (hc.w != null) {
                strD = hc.w.d(activity);
            } else {
                strD = activity.getClass().getName();
            }
            hcVar.uo = strD;
            hc.this.k = System.currentTimeMillis();
            hc.an(hc.this);
            if (hc.this.yo <= 0) {
                hc.this.rf = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            String strD;
            hc hcVar = hc.this;
            if (hc.w != null) {
                strD = hc.w.d(activity);
            } else {
                strD = activity.getClass().getName();
            }
            hcVar.e = strD;
            hc.this.cb = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String strD;
            if (hc.w != null) {
                strD = hc.w.d(activity);
            } else {
                strD = activity.getClass().getName();
            }
            int iIndexOf = hc.this.b.indexOf(strD);
            if (iIndexOf >= 0 && iIndexOf < hc.this.b.size()) {
                hc.this.b.remove(iIndexOf);
                hc.this.c.remove(iIndexOf);
            }
            hc.this.u.add(strD);
            hc.this.an.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    static /* synthetic */ int an(hc hcVar) {
        int i = hcVar.yo;
        hcVar.yo = i - 1;
        return i;
    }

    static /* synthetic */ int u(hc hcVar) {
        int i = hcVar.yo;
        hcVar.yo = i + 1;
        return i;
    }

    hc(Context context) {
        this.hc = context;
        if (context instanceof Application) {
            this.d = (Application) context;
        }
        u();
    }

    private void u() {
        Application application;
        if (Build.VERSION.SDK_INT < 14 || (application = this.d) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.jh);
    }

    private JSONArray an() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.b;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.b.size(); i++) {
                try {
                    jSONArray.put(d(this.b.get(i), this.c.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray h() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.u;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.u.size(); i++) {
                try {
                    jSONArray.put(d(this.u.get(i), this.an.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONObject d(String str, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException e) {
            mq.d(e);
        }
        return jSONObject;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", d(this.h, this.gb));
            jSONObject.put("last_start_activity", d(this.tt, this.tc));
            jSONObject.put("last_resume_activity", d(this.mk, this.mq));
            jSONObject.put("last_pause_activity", d(this.uo, this.k));
            jSONObject.put("last_stop_activity", d(this.e, this.cb));
            jSONObject.put("alive_activities", an());
            jSONObject.put("finish_activities", h());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONArray hc() throws JSONException {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            activityManager = (ActivityManager) this.hc.getSystemService("activity");
        } catch (Exception unused) {
        }
        if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
            return jSONArray;
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", runningTaskInfo.id);
                    jSONObject.put(n.p, runningTaskInfo.baseActivity.getPackageName());
                    jSONObject.put("description", runningTaskInfo.description);
                    jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                    jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                    jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                    jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused2) {
                }
            }
        }
        return jSONArray;
    }

    public boolean b() {
        return this.rf;
    }
}
