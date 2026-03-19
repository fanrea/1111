package com.android.gdt.qone.aw;

import com.android.gdt.qone.ag.o;
import com.android.gdt.qone.ap.f;
import com.android.gdt.qone.au.d;
import com.android.gdt.qone.shell.sdkinfo.UserInfoType;
import com.android.gdt.qone.w.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b {
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public final String a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final AtomicBoolean c = new AtomicBoolean(false);

    public b(String str) {
        this.a = str;
    }

    public static synchronized b a(String str) {
        b bVar;
        ConcurrentHashMap concurrentHashMap = d;
        bVar = (b) concurrentHashMap.get(str);
        if (bVar == null) {
            bVar = new b(str);
            concurrentHashMap.put(str, bVar);
        }
        return bVar;
    }

    public final String[] b() throws NumberFormatException {
        c cVar;
        com.android.gdt.qone.ak.b bVarA = f.a(this.a);
        if (bVarA != null && !bVarA.c()) {
            if (!bVarA.a().isEmpty()) {
                this.b.put(UserInfoType.TYPE_Q16.toString(), bVarA.a());
            }
            if (!bVarA.b().isEmpty()) {
                this.b.put(UserInfoType.TYPE_Q36.toString(), bVarA.b());
            }
        }
        this.b.put(UserInfoType.TYPE_PRE_AUDIT_STATE.toString(), d.a(com.android.gdt.qone.au.a.m, com.android.gdt.qone.at.a.a(this.a).a.l).booleanValue() ? "1" : "0");
        if (!this.c.get()) {
            synchronized (c.class) {
                cVar = c.p;
            }
            String str = this.a;
            com.android.gdt.qone.ar.a aVar = new com.android.gdt.qone.ar.a(str);
            o oVarA = o.a(str);
            this.b.put(UserInfoType.TYPE_SDK_VERSION.toString(), "2.1.3.19");
            this.b.put(UserInfoType.TYPE_APP_KEY.toString(), this.a);
            this.b.put(UserInfoType.TYPE_NET_WORK_TYPE.toString(), cVar.k());
            ConcurrentHashMap concurrentHashMap = this.b;
            String string = UserInfoType.TYPE_APP_VERSION.toString();
            if (com.android.gdt.qone.w.a.c == null) {
                com.android.gdt.qone.w.a.c = com.android.gdt.qone.w.a.f();
            }
            concurrentHashMap.put(string, com.android.gdt.qone.w.a.c);
            this.b.put(UserInfoType.TYPE_CHANNEL_ID.toString(), aVar.b());
            this.b.put(UserInfoType.TYPE_USER_ID_PARAM.toString(), aVar.e());
            this.b.put(UserInfoType.TYPE_OS_VERSION.toString(), cVar.n());
            this.b.put(UserInfoType.TYPE_MODEL.toString(), oVarA.b());
            this.c.set(true);
        }
        int iA = UserInfoType.MAX_TYPE_SIZE.a();
        String[] strArr = new String[iA];
        for (Map.Entry entry : this.b.entrySet()) {
            int i = Integer.parseInt((String) entry.getKey());
            if (i < iA) {
                strArr[i] = (String) entry.getValue();
            }
        }
        return strArr;
    }

    public final void a() {
        c cVar;
        synchronized (c.class) {
            cVar = c.p;
        }
        this.b.put(UserInfoType.TYPE_NET_WORK_TYPE.toString(), cVar.k());
    }
}
