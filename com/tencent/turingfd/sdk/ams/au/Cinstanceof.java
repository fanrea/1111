package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.Banana;
import com.tencent.turingfd.sdk.ams.au.Csynchronized;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.instanceof, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cinstanceof implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Csynchronized.Cdo b;

    public Cinstanceof(Csynchronized.Cdo cdo, int i) {
        this.b = cdo;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        if (!Scorpius.c(context)) {
            return;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.b.a;
            if (i >= strArr.length) {
                return;
            }
            try {
                Banana.Cdo cdo = new Banana.Cdo(strArr[i]);
                int i2 = this.a;
                if (i2 > 0) {
                    cdo.d = i2;
                }
                if (i2 > 0) {
                    cdo.e = i2;
                }
                Banana banana = new Banana(cdo);
                Andromeda.a(banana, banana.b, banana.d);
                this.b.b = i;
                return;
            } catch (Throwable unused) {
                i++;
            }
        }
    }
}
