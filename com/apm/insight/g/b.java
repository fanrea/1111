package com.apm.insight.g;

import android.app.ApplicationExitInfo;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.apm.insight.CrashType;
import com.apm.insight.ExitType;
import com.apm.insight.MonitorCrash;
import com.apm.insight.entity.Header;
import com.apm.insight.g;
import com.apm.insight.o.e;
import com.apm.insight.o.j;
import com.apm.insight.runtime.a.c;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.l;
import com.apm.insight.runtime.s;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    private static AtomicBoolean a = new AtomicBoolean(false);

    private static com.apm.insight.entity.a a(final ApplicationExitInfo applicationExitInfo) {
        return f.a().a(CrashType.EXIT, null, new c.a() { // from class: com.apm.insight.g.b.1
            @Override // com.apm.insight.runtime.a.c.a
            public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
                Object objValueOf;
                String str;
                if (i != 0) {
                    if (i != 1) {
                        try {
                            if (i == 2) {
                                long jA = s.a(applicationExitInfo.getPid(), applicationExitInfo.getTimestamp(), applicationExitInfo.getProcessName());
                                if (jA < 0) {
                                    aVar.a("npth_init", "false");
                                    aVar.a("launch_time", Long.valueOf(applicationExitInfo.getTimestamp()));
                                    jA = applicationExitInfo.getTimestamp();
                                } else {
                                    aVar.a("launch_time", Long.valueOf(jA));
                                }
                                aVar.a("app_start_time", Long.valueOf(jA));
                                if (applicationExitInfo.getTraceInputStream() != null) {
                                    aVar.a("exit_info_trace", "true");
                                }
                            } else if (i == 3) {
                                aVar.a("crash_uuid", g.a(applicationExitInfo.getTimestamp(), CrashType.EXIT, false, false));
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("exit_pss", a.a(applicationExitInfo.getPss()));
                                jSONObject.put("exit_rss", a.a(applicationExitInfo.getRss()));
                                jSONObject.put("exit_status", String.valueOf(applicationExitInfo.getStatus()));
                                jSONObject.put("exit_importance", applicationExitInfo.getImportance());
                                jSONObject.put("exit_reason", applicationExitInfo.getReason());
                                jSONObject.put("description", applicationExitInfo.getDescription());
                                aVar.a(SchedulerSupport.CUSTOM, jSONObject);
                            } else if (i == 4) {
                                aVar.a("exit_reason", a.b(applicationExitInfo.getReason()));
                                aVar.a("exit_status", String.valueOf(applicationExitInfo.getStatus()));
                                aVar.a("exit_importance", String.valueOf(applicationExitInfo.getImportance()));
                                aVar.a("exit_pss", a.a(applicationExitInfo.getPss()));
                                aVar.a("exit_rss", a.a(applicationExitInfo.getRss()));
                                aVar.c();
                            } else if (i == 5) {
                                aVar.a("is_background", Boolean.valueOf(!(s.a(aVar, applicationExitInfo.getPid(), applicationExitInfo.getTimestamp(), applicationExitInfo.getProcessName()) || applicationExitInfo.getImportance() <= 200)));
                                try {
                                    aVar.a("crash_md5", e.a(a.a(applicationExitInfo)));
                                } catch (Throwable unused) {
                                }
                                if (!a.d(applicationExitInfo.getReason())) {
                                    objValueOf = l.a(g.e(), 500L);
                                    str = "logcat";
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    } else {
                        aVar.a(com.alipay.sdk.m.t.a.k, Long.valueOf(applicationExitInfo.getTimestamp()));
                        objValueOf = String.valueOf(a.d(applicationExitInfo.getReason()));
                        str = "user_exit";
                    }
                    aVar.a(str, objValueOf);
                } else {
                    int reason = applicationExitInfo.getReason();
                    String strC = "";
                    try {
                        strC = a.c(((Integer) applicationExitInfo.getClass().getDeclaredMethod("getSubReason", new Class[0]).invoke(applicationExitInfo, new Object[0])).intValue());
                        aVar.a("exit_sub_reason", (Object) strC);
                        aVar.a("exit_sub_reason", strC);
                    } catch (Throwable unused3) {
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("REASON = ").append(a.b(reason));
                    sb.append("，SUB_REASON = ").append(strC);
                    aVar.a(cm.V, sb.toString());
                    aVar.a("stack", a.a(applicationExitInfo));
                    aVar.a(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, d.z);
                    aVar.a("log_type", "process_exit");
                    aVar.a("pid", Integer.valueOf(applicationExitInfo.getPid()));
                    aVar.a(ContentProviderManager.PLUGIN_PROCESS_NAME, applicationExitInfo.getProcessName());
                    aVar.a("crash_time", Long.valueOf(applicationExitInfo.getTimestamp()));
                    aVar.a("exit_reason", a.b(reason));
                }
                return aVar;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar, boolean z) {
                return aVar;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public void a(Throwable th) {
            }
        }, true);
    }

    public static void a(Context context) {
        j.a aVar;
        ApplicationExitInfo next;
        if (a.compareAndSet(false, true)) {
            try {
                List<ApplicationExitInfo> listA = a.a(15);
                if (listA == null || listA.isEmpty()) {
                    return;
                }
                String strC = com.apm.insight.o.a.c(context);
                Iterator<ApplicationExitInfo> it = listA.iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (TextUtils.equals(next.getProcessName(), strC)) {
                            break;
                        }
                    }
                }
                if (next == null) {
                    return;
                }
                com.apm.insight.a.a.a().a(next.getReason(), next.getDescription(), next.getStatus());
                if (com.apm.insight.runtime.a.l()) {
                    if (g.u() == ExitType.EXCEPTION.type && a.d(next.getReason())) {
                        return;
                    }
                    com.apm.insight.entity.a aVarA = a(next);
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(aVarA.h());
                    jSONObject.put("data", jSONArray);
                    Header headerA = Header.a(context, next.getTimestamp());
                    String deviceId = "";
                    try {
                        deviceId = ((MonitorCrash) com.apm.insight.f.a()).config().getDeviceId();
                        if (TextUtils.isEmpty(headerA.g().optString(com.baidu.mobads.upgrade.remote.gray.c.l))) {
                            if (TextUtils.isEmpty(deviceId)) {
                                headerA.d();
                            } else {
                                headerA.g().put(com.baidu.mobads.upgrade.remote.gray.c.l, deviceId);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    String str = "android__" + deviceId + Config.replace + next.getTimestamp() + Config.replace + CrashType.EXIT;
                    JSONObject jSONObjectG = headerA.g();
                    jSONObjectG.put("unique_key", str);
                    jSONObject.put("header", jSONObjectG);
                    String launchCrashUploadUrl = g.h().getLaunchCrashUploadUrl();
                    if (a.d(next.getReason())) {
                        com.apm.insight.n.f.a(launchCrashUploadUrl, jSONObject.toString(), new j.a[0]);
                        return;
                    }
                    File fileA = s.a(next.getProcessName(), next.getTimestamp());
                    j.a aVar2 = (fileA == null || !fileA.exists()) ? null : new j.a(new FileInputStream(fileA), fileA.getName(), true);
                    if (next.getTraceInputStream() != null) {
                        aVar = new j.a(next.getTraceInputStream(), next.getReason() == 5 ? "tombstone" : next.getReason() == 6 ? "anr_trace.txt" : "ext.dump", true);
                    }
                    com.apm.insight.n.f.a(launchCrashUploadUrl, jSONObject.toString(), aVar, aVar2);
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
