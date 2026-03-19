package com.apm.insight.runtime.a;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICommonParams;
import com.apm.insight.o.v;
import com.apm.insight.o.w;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.apm.common.utility.ToolUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class c {
    protected CrashType a;
    protected Context b;
    protected ICommonParams c = com.apm.insight.g.a().c();
    protected b d;
    protected d e;

    public interface a {
        com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar);

        com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar, boolean z);

        void a(Throwable th);
    }

    c(CrashType crashType, Context context, b bVar, d dVar) {
        this.a = crashType;
        this.b = context;
        this.d = bVar;
        this.e = dVar;
    }

    private void i(com.apm.insight.entity.a aVar) {
        List<AttachUserData> listA = com.apm.insight.g.b().a(this.a);
        HashMap map = new HashMap();
        JSONObject jSONObjectOptJSONObject = aVar.h().optJSONObject(SchedulerSupport.CUSTOM);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            aVar.a(SchedulerSupport.CUSTOM, jSONObjectOptJSONObject);
        }
        if (listA != null) {
            for (int i = 0; i < listA.size(); i++) {
                try {
                    AttachUserData attachUserData = listA.get(i);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject, attachUserData.getUserData(this.a));
                    map.put("custom_cost_" + attachUserData.getClass().getName() + Config.replace + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
                } catch (Throwable th) {
                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject, th);
                }
            }
        }
        if (this.a != CrashType.EXIT) {
            try {
                jSONObjectOptJSONObject.put("fd_count", com.apm.insight.o.i.a());
            } catch (Throwable unused) {
            }
        }
        List<AttachUserData> listB = com.apm.insight.g.b().b(this.a);
        if (listB != null) {
            JSONObject jSONObjectOptJSONObject2 = aVar.h().optJSONObject("custom_long");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
                aVar.a("custom_long", jSONObjectOptJSONObject2);
            }
            for (int i2 = 0; i2 < listB.size(); i2++) {
                try {
                    AttachUserData attachUserData2 = listB.get(i2);
                    long jUptimeMillis2 = SystemClock.uptimeMillis();
                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, attachUserData2.getUserData(this.a));
                    map.put("custom_cost_" + attachUserData2.getClass().getName() + Config.replace + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis2));
                } catch (Throwable th2) {
                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, th2);
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            try {
                jSONObjectOptJSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Throwable unused2) {
            }
        }
    }

    public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) throws JSONException {
        if (aVar == null) {
            aVar = new com.apm.insight.entity.a();
        }
        if (i == 0) {
            b(aVar);
        } else if (i == 1) {
            c(aVar);
            i(aVar);
        } else if (i == 2) {
            e(aVar);
        } else if (i == 4) {
            f(aVar);
        } else if (i == 5) {
            d(aVar);
        }
        return aVar;
    }

    public com.apm.insight.entity.a a(com.apm.insight.entity.a aVar) {
        return aVar;
    }

    public com.apm.insight.entity.a a(com.apm.insight.entity.a aVar, a aVar2, boolean z) {
        if (aVar == null) {
            aVar = new com.apm.insight.entity.a();
        }
        com.apm.insight.entity.a aVarA = aVar;
        for (int i = 0; i < b(); i++) {
            SystemClock.uptimeMillis();
            if (aVar2 != null) {
                try {
                    aVarA = aVar2.a(i, aVarA);
                } catch (Throwable th) {
                    aVar2.a(th);
                }
            }
            try {
                aVarA = a(i, aVarA);
            } catch (Throwable th2) {
                if (aVar2 != null) {
                    aVar2.a(th2);
                }
            }
            if (aVar2 != null) {
                try {
                    boolean z2 = true;
                    if (i != b() - 1) {
                        z2 = false;
                    }
                    aVarA = aVar2.a(i, aVarA, z2);
                } catch (Throwable th3) {
                    aVar2.a(th3);
                }
                if (z) {
                    if (i != 0) {
                        aVar.c(aVarA.h());
                    } else {
                        aVar = aVarA;
                    }
                    aVarA = new com.apm.insight.entity.a();
                }
            }
        }
        return a(aVar);
    }

    protected boolean a() {
        return false;
    }

    public int b() {
        return 6;
    }

    public com.apm.insight.entity.a b(com.apm.insight.entity.a aVar) throws JSONException {
        aVar.a(com.apm.insight.g.n(), com.apm.insight.g.o());
        if (com.apm.insight.g.l()) {
            aVar.a("is_mp", (Object) 1);
        }
        try {
            aVar.a(this.c.getPluginInfo());
        } catch (Throwable th) {
            try {
                HashMap map = new HashMap();
                map.put("代码中发生了错误导致数据获取失败:\n" + v.a(th), 0);
                aVar.a(map);
            } catch (Throwable unused) {
            }
        }
        aVar.b(com.apm.insight.g.m());
        aVar.a(ContentProviderManager.PLUGIN_PROCESS_NAME, com.apm.insight.o.a.c(com.apm.insight.g.f()));
        return aVar;
    }

    public com.apm.insight.entity.a c(com.apm.insight.entity.a aVar) throws JSONException {
        b bVar;
        if (!com.apm.insight.o.a.b(com.apm.insight.g.f())) {
            aVar.a("remote_process", (Object) 1);
        }
        aVar.a("pid", Integer.valueOf(Process.myPid()));
        aVar.a(com.apm.insight.g.i());
        if (c() && (bVar = this.d) != null) {
            aVar.a(bVar);
        }
        try {
            aVar.a(this.c.getPatchInfo());
        } catch (Throwable th) {
            try {
                aVar.a(Arrays.asList("代码中发生了错误导致数据获取失败:\n" + v.a(th)));
            } catch (Throwable unused) {
            }
        }
        String strJ = com.apm.insight.g.j();
        if (strJ != null) {
            aVar.a("business", (Object) strJ);
        }
        aVar.a("is_background", Boolean.valueOf(!com.apm.insight.o.a.a(this.b)));
        return aVar;
    }

    protected boolean c() {
        return true;
    }

    public com.apm.insight.entity.a d(com.apm.insight.entity.a aVar) {
        if (d()) {
            aVar.b(w.a(this.b));
        }
        return aVar;
    }

    protected boolean d() {
        return true;
    }

    public com.apm.insight.entity.a e(com.apm.insight.entity.a aVar) {
        d dVar = this.e;
        aVar.a("battery", Integer.valueOf(dVar == null ? 0 : dVar.a()));
        aVar.c(com.apm.insight.g.b().a());
        aVar.a("is_harmony_os", ToolUtils.isHarmonyOs() ? "1" : "0");
        return aVar;
    }

    public com.apm.insight.entity.a f(com.apm.insight.entity.a aVar) {
        if (a()) {
            h(aVar);
        }
        return aVar;
    }

    void g(com.apm.insight.entity.a aVar) {
    }

    protected void h(com.apm.insight.entity.a aVar) {
    }
}
