package com.tencent.turingfd.sdk.ams.au;

import com.baidu.mobstat.forbes.Config;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Pear implements Runnable {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ Object c;

    public Pear(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.a = atomicBoolean;
        this.b = atomicReference;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() throws Exception {
        if (this.a.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e) {
            String strA = Cfinally.a(Cfinally.F0);
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (strA.equals(stackTraceElement.getClassName() + Config.replace + stackTraceElement.getMethodName())) {
                    this.b.set(Boolean.TRUE);
                }
            }
            synchronized (this.c) {
                this.c.notify();
            }
        }
    }
}
