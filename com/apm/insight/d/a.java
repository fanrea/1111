package com.apm.insight.d;

import com.apm.insight.CrashType;
import com.apm.insight.IUploadCallback;
import com.apm.insight.g;
import com.apm.insight.n.e;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.q;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static void a(String str) {
        a(str, null, null, null);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, IUploadCallback iUploadCallback) {
        a(str, map, map2, null, iUploadCallback);
    }

    public static void a(final String str, final Map<? extends String, ? extends String> map, final Map<String, String> map2, final Map<String, String> map3, final IUploadCallback iUploadCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            q.b().a(new Runnable() { // from class: com.apm.insight.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean zA = false;
                    try {
                        com.apm.insight.entity.a aVarA = f.a().a(CrashType.DART, com.apm.insight.entity.a.a(jCurrentTimeMillis, g.f(), str));
                        if (map != null) {
                            JSONObject jSONObjectOptJSONObject = aVarA.h().optJSONObject(SchedulerSupport.CUSTOM);
                            if (jSONObjectOptJSONObject == null) {
                                jSONObjectOptJSONObject = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject, (Map<? extends String, ? extends String>) map);
                            aVarA.a(SchedulerSupport.CUSTOM, jSONObjectOptJSONObject);
                        }
                        if (map2 != null) {
                            JSONObject jSONObjectOptJSONObject2 = aVarA.h().optJSONObject("custom_long");
                            if (jSONObjectOptJSONObject2 == null) {
                                jSONObjectOptJSONObject2 = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, (Map<? extends String, ? extends String>) map2);
                            aVarA.a("custom_long", jSONObjectOptJSONObject2);
                        }
                        if (map3 != null) {
                            JSONObject jSONObjectOptJSONObject3 = aVarA.h().optJSONObject("filters");
                            if (jSONObjectOptJSONObject3 == null) {
                                jSONObjectOptJSONObject3 = new JSONObject();
                                aVarA.a("filters", jSONObjectOptJSONObject3);
                            }
                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject3, (Map<? extends String, ? extends String>) map3);
                        }
                        zA = e.a().a(jCurrentTimeMillis, aVarA.h());
                        com.apm.insight.a.a.a().b(str);
                    } catch (Throwable unused) {
                    }
                    IUploadCallback iUploadCallback2 = iUploadCallback;
                    if (iUploadCallback2 != null) {
                        try {
                            iUploadCallback2.afterUpload(zA);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
