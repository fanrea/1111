package com.kwad.sdk.crash.report;

import android.util.Log;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class c implements e {
    private ArrayList<a> bOx = new ArrayList<>();

    public final void a(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        try {
            aex();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            this.bOx.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private void aex() {
        if (this.bOx.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.bOx.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.bOy, next.bOz, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    static class a {
        private ExceptionMessage bOy;
        private int bOz;

        a(ExceptionMessage exceptionMessage, int i) {
            this.bOy = exceptionMessage;
            this.bOz = i;
        }
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e eVarAef = com.kwad.sdk.crash.e.aef();
            if (eVarAef.aek() != null && eVarAef.aej() != 2) {
                List<com.kwad.sdk.crash.a> list = eVarAef.aek().bNf;
                double d = eVarAef.aek().bMG;
                String appId = eVarAef.getAppId();
                String sdkVersion = eVarAef.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.bMD) || aVar.bMD.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.bME) || aVar.bME.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.bMF) || a(exceptionMessage.mCrashDetail, aVar.bMF)) {
                                d = aVar.bMG;
                            }
                        }
                    }
                }
                return Math.random() < d;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
