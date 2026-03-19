package com.apm.insight.entity;

import com.apm.insight.g;
import com.baidu.mobads.container.util.cm;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends a {
    private String c;

    public c(String str) {
        this.c = str;
    }

    public static c a(StackTraceElement stackTraceElement, String str, String str2, String str3, boolean z, String str4, String str5) {
        c cVar = new c(str5);
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        cVar.a(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, (Object) "exception");
        cVar.a("log_type", (Object) str5);
        cVar.a(com.alipay.sdk.m.t.a.k, Long.valueOf(System.currentTimeMillis()));
        cVar.a("crash_time", Long.valueOf(System.currentTimeMillis()));
        cVar.a("class_ref", (Object) className);
        cVar.a(com.alipay.sdk.m.p.e.s, (Object) methodName);
        cVar.a("line_num", Integer.valueOf(lineNumber));
        cVar.a("stack", (Object) str);
        cVar.a("exception_type", (Object) 1);
        cVar.a("ensure_type", (Object) str4);
        cVar.a("is_core", Integer.valueOf(z ? 1 : 0));
        cVar.a(cm.V, (Object) str2);
        cVar.a(ContentProviderManager.PLUGIN_PROCESS_NAME, (Object) com.apm.insight.o.a.c(g.f()));
        cVar.a("crash_thread_name", (Object) str3);
        d.b(cVar.h());
        return cVar;
    }
}
