package com.tencent.turingfd.sdk.ams.au;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Herbaceous extends Thread {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ ITuringDeviceInfoProvider c;
    public final /* synthetic */ Object d;

    public Herbaceous(Hickory hickory, AtomicBoolean atomicBoolean, HashMap map, ITuringDeviceInfoProvider iTuringDeviceInfoProvider, long j, Object obj) {
        this.a = atomicBoolean;
        this.b = map;
        this.c = iTuringDeviceInfoProvider;
        this.d = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (this.a.get()) {
            return;
        }
        try {
            HashMap map = this.b;
            String strA = this.c.a();
            if (strA == null) {
                strA = "";
            }
            map.put("274", strA);
            HashMap map2 = this.b;
            String strC = this.c.c();
            if (strC == null) {
                strC = "";
            }
            map2.put("276", strC);
            HashMap map3 = this.b;
            String strB = this.c.b();
            if (strB == null) {
                strB = "";
            }
            map3.put("275", strB);
        } catch (Throwable unused) {
            Log.w("Turing", "invoke info impl exception");
        }
        synchronized (this.d) {
            this.d.notify();
        }
    }
}
