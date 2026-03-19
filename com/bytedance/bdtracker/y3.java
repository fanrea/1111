package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.event.EventPolicy;
import com.bytedance.applog.event.EventType;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.bdtracker.l0;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class y3 {
    public final e0 a;
    public final x3 b;

    public y3(e0 e0Var, x3 x3Var) {
        this.a = e0Var;
        this.b = x3Var;
    }

    public final EventPolicy a(IEventHandler iEventHandler, int i, String str, t3 t3Var, JSONObject jSONObject) {
        t3Var.h();
        String strE = t3Var.e();
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(strE)) {
            try {
                jSONObject2 = new JSONObject(strE);
            } catch (Throwable unused) {
                this.a.d.D.error(5, "Param:[{}] is not a json string", strE);
            }
        }
        if (jSONObject != null) {
            l0.b.b(jSONObject, jSONObject2);
        }
        EventPolicy eventPolicyOnReceive = iEventHandler.onReceive(i, str, jSONObject2);
        t3Var.o = jSONObject2;
        return eventPolicyOnReceive;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x013f A[Catch: all -> 0x0165, TryCatch #1 {all -> 0x0165, blocks: (B:66:0x0135, B:67:0x0139, B:69:0x013f, B:71:0x014d, B:72:0x0159), top: B:94:0x0135 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017f A[Catch: all -> 0x01af, LOOP:2: B:77:0x0179->B:79:0x017f, LOOP_END, TryCatch #4 {all -> 0x01af, blocks: (B:76:0x0175, B:77:0x0179, B:79:0x017f, B:80:0x0193, B:81:0x0197, B:83:0x019d), top: B:99:0x0175 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019d A[Catch: all -> 0x01af, LOOP:3: B:81:0x0197->B:83:0x019d, LOOP_END, TRY_LEAVE, TryCatch #4 {all -> 0x01af, blocks: (B:76:0x0175, B:77:0x0179, B:79:0x017f, B:80:0x0193, B:81:0x0197, B:83:0x019d), top: B:99:0x0175 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.List<com.bytedance.bdtracker.t3> r20) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.y3.b(java.util.List):void");
    }

    public final boolean a(IEventHandler iEventHandler, t3 t3Var) {
        String str;
        if (iEventHandler != null && t3Var != null) {
            EventPolicy eventPolicyA = null;
            int iAcceptType = iEventHandler.acceptType();
            if (!(t3Var instanceof v3)) {
                int i = 2;
                if (t3Var instanceof a4) {
                    if (EventType.a(iAcceptType, 1)) {
                        str = ((a4) t3Var).u;
                        i = 1;
                        eventPolicyA = a(iEventHandler, i, l0.b.a((Object) str), t3Var, t3Var.o);
                    }
                } else if (t3Var instanceof d4) {
                    if (EventType.a(iAcceptType, 4)) {
                        eventPolicyA = a(iEventHandler, 4, "bav2b_page", t3Var, t3Var.o);
                    }
                } else if ((t3Var instanceof e4) && EventType.a(iAcceptType, 2)) {
                    str = ((e4) t3Var).t;
                    eventPolicyA = a(iEventHandler, i, l0.b.a((Object) str), t3Var, t3Var.o);
                }
            } else if (EventType.a(iAcceptType, 8)) {
                eventPolicyA = a(iEventHandler, 8, "bav2b_click", t3Var, t3Var.o);
            }
            if (eventPolicyA == EventPolicy.DENY) {
                return false;
            }
        }
        return true;
    }

    public void a(List<t3> list) {
        try {
            for (t3 t3Var : list) {
                if ("eventv3".equals(t3Var.f())) {
                    a4 a4Var = (a4) t3Var;
                    f1 f1Var = this.a.d.c;
                    String str = a4Var.u;
                    String str2 = a4Var.s;
                    f1Var.onEventV3(str, str2 != null ? new JSONObject(str2) : null);
                }
            }
        } catch (Throwable th) {
            this.a.d.D.debug(5, "Notify event observer failed", th);
        }
    }
}
