package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.applog.monitor.MonitorSampling;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class n2 implements i2, Handler.Callback {
    public Handler a;
    public final j2 b;
    public final e0 c;

    public n2(e0 e0Var) {
        Intrinsics.checkParameterIsNotNull(e0Var, "mEngine");
        this.c = e0Var;
        StringBuilder sbA = a.a("bd_tracker_monitor@");
        d dVar = e0Var.d;
        Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
        HandlerThread handlerThread = new HandlerThread(sbA.append(dVar.m).toString());
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper(), this);
        Looper looper = this.a.getLooper();
        Intrinsics.checkExpressionValueIsNotNull(looper, "mHandler.looper");
        d dVar2 = e0Var.d;
        Intrinsics.checkExpressionValueIsNotNull(dVar2, "mEngine.appLog");
        String str = dVar2.m;
        Intrinsics.checkExpressionValueIsNotNull(str, "mEngine.appLog.appId");
        Context contextB = e0Var.b();
        Intrinsics.checkExpressionValueIsNotNull(contextB, "mEngine.context");
        this.b = new j2(looper, str, contextB);
    }

    public void a(q2 q2Var) {
        Intrinsics.checkParameterIsNotNull(q2Var, "data");
        q1 q1Var = this.c.e;
        Intrinsics.checkExpressionValueIsNotNull(q1Var, "mEngine.config");
        if (q1Var.i()) {
            if (MonitorSampling.INSTANCE.isSampling$agent_liteChinaRelease()) {
                d dVar = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
                dVar.D.debug(8, "Monitor EventTrace hint trace:{}", q2Var);
                this.b.a(q2Var).track(q2Var.g(), q2Var.d());
                return;
            }
            if ((q2Var instanceof z2) || (q2Var instanceof t2)) {
                this.b.a(q2Var).track(q2Var.g(), q2Var.d());
            }
            d dVar2 = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar2, "mEngine.appLog");
            dVar2.D.debug(8, "Monitor EventTrace not hint trace:{}", q2Var);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Intrinsics.checkParameterIsNotNull(message, "msg");
        int i = message.what;
        if (i == 1) {
            d dVar = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
            dVar.D.debug(8, "Monitor trace save:{}", message.obj);
            z3 z3VarC = this.c.c();
            Object obj = message.obj;
            if (!TypeIntrinsics.isMutableList(obj)) {
                obj = null;
            }
            z3VarC.c.b((List) obj);
        } else if (i == 2) {
            s1 s1Var = this.c.i;
            if (s1Var == null || s1Var.h() != 0) {
                d dVar2 = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar2, "mEngine.appLog");
                dVar2.D.debug(8, "Monitor report...", new Object[0]);
                z3 z3VarC2 = this.c.c();
                d dVar3 = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar3, "mEngine.appLog");
                String str = dVar3.m;
                s1 s1Var2 = this.c.i;
                Intrinsics.checkExpressionValueIsNotNull(s1Var2, "mEngine.dm");
                z3VarC2.b(str, s1Var2.e());
                e0 e0Var = this.c;
                e0Var.a(e0Var.l);
            } else {
                this.a.sendEmptyMessageDelayed(2, 500L);
            }
        }
        return true;
    }
}
