package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.android.live.network.ApiStatus;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class p30 implements jl, Callable<Boolean> {
    private m7 a;

    p30() {
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean call() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.p30.call():java.lang.Boolean");
    }

    private boolean b(m7 m7Var) throws JSONException {
        int length;
        byte[] bArr = m7Var.j;
        if (bArr == null || (length = bArr.length) == 0) {
            return true;
        }
        int i = 0;
        while (i < length && bArr[i] == 0) {
            i++;
        }
        if (i != length) {
            return false;
        }
        a(m7Var.b == null ? -3 : -2, null);
        return true;
    }

    private void a(int i, String str) throws JSONException {
        qc qcVar = new qc(9801001);
        qcVar.d(i);
        if (!TextUtils.isEmpty(str)) {
            ja jaVar = new ja();
            jaVar.a("msg", str);
            qcVar.a(jaVar);
        }
        b10.a(qcVar);
    }

    @Override // com.qq.e.comm.plugin.jl
    public boolean a(m7 m7Var) throws JSONException {
        String stackTraceString;
        int i;
        if (TextUtils.isEmpty(g2.e())) {
            a(-1, null);
            return false;
        }
        if (b(m7Var)) {
            return false;
        }
        zr zrVarF = as.f();
        if (zrVarF != zr.WIFI && zrVarF != zr.NET_4G) {
            return false;
        }
        this.a = m7Var;
        FutureTask futureTask = new FutureTask(this);
        if (m7Var.i) {
            h2.a().postAtFrontOfQueue(futureTask);
        } else {
            futureTask.run();
        }
        try {
            Boolean bool = (Boolean) futureTask.get();
            if (bool == null || !bool.booleanValue()) {
                return false;
            }
            File file = m7Var.h;
            if (file == null) {
                return true;
            }
            file.delete();
            return true;
        } catch (InterruptedException e) {
            a(ApiStatus.SC_INTERCEPT_BY_KEY_CONFIG, Log.getStackTraceString(e));
            return false;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof SocketTimeoutException) {
                stackTraceString = cause.getMessage();
                i = -4;
            } else {
                stackTraceString = Log.getStackTraceString(cause);
                i = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
            }
            a(i, stackTraceString);
            return false;
        } catch (Throwable th) {
            a(-1000, Log.getStackTraceString(th));
            return false;
        }
    }
}
