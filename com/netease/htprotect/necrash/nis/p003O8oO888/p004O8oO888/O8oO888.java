package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import android.os.Process;
import android.util.Log;
import com.alipay.sdk.m.u.b;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class O8oO888 implements Thread.UncaughtExceptionHandler {

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final String f84O8 = "BaseJavaCrashHandler";

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private String f85O8oO888 = "https://crash.163.com/uploadCrashLogInfo.do";

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private String f86Ooo = "https://crash.163.com/client/api/uploadStartUpInfo.do";

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private Thread.UncaughtExceptionHandler f87o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private Oo0 f88oO;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private o0o0 m549O8oO888(String str, String str2) throws UnsupportedEncodingException {
        return new o0o0(mo536O8oO888(str), this.f85O8oO888, new O8(this, str2));
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static void m550O8() {
        throw new RuntimeException("test java exception");
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private void m551O8(String str) throws Throwable {
        String strM564o0o0 = Oo0.m564o0o0(str);
        o8o0.m581Ooo(strM564o0o0);
        Thread thread = new Thread(m549O8oO888(strM564o0o0, str));
        thread.start();
        try {
            thread.join(b.a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            o8o0.m579O8("quick upload isInterrupted");
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private void m552Ooo() {
        o8o0.m581Ooo("check and report crash info");
        File[] fileArrM568Ooo = this.f88oO.m568Ooo();
        if (fileArrM568Ooo.length > 0) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 5, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
            for (File file : fileArrM568Ooo) {
                try {
                    threadPoolExecutor.execute(m549O8oO888(Oo0.m564o0o0(file.getAbsolutePath()), file.getAbsolutePath()));
                } catch (UnsupportedEncodingException unused) {
                    o8o0.m582Ooo(f84O8, "logInfo encode error");
                }
            }
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private void m553Ooo(Throwable th) throws Throwable {
        try {
            m551O8(this.f88oO.m567Ooo(Log.getStackTraceString(th)).getAbsolutePath());
        } catch (UnsupportedEncodingException unused) {
            o8o0.m582Ooo(f84O8, "logInfo encode error");
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private void m554o0o0(String str) {
        this.f85O8oO888 = str;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private void m555oO(String str) {
        this.f86Ooo = str;
    }

    /* renamed from: O8〇oO8〇88 */
    protected abstract Map mo535O8oO888();

    /* renamed from: O8〇oO8〇88 */
    protected abstract Map mo536O8oO888(String str);

    /* renamed from: O8〇oO8〇88 */
    protected boolean mo538O8oO888(Throwable th) {
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws Throwable {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f87o0o0;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        try {
            if (!mo538O8oO888(th)) {
                try {
                    m551O8(this.f88oO.m567Ooo(Log.getStackTraceString(th)).getAbsolutePath());
                } catch (UnsupportedEncodingException unused) {
                    o8o0.m582Ooo(f84O8, "logInfo encode error");
                }
            }
        } catch (Exception e) {
            o8o0.m582Ooo(f84O8, "JavaCrashHandler handleException failed" + e.getMessage());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f87o0o0;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final void m556Ooo(String str) {
        this.f87o0o0 = Thread.getDefaultUncaughtExceptionHandler();
        try {
            Thread.setDefaultUncaughtExceptionHandler(this);
        } catch (Exception e) {
            o8o0.m582Ooo(f84O8, "JavaCrashHandler setDefaultUncaughtExceptionHandler failed" + e.getMessage());
        }
        Oo0 oo0M562O8oO888 = Oo0.m562O8oO888();
        this.f88oO = oo0M562O8oO888;
        oo0M562O8oO888.m565O8oO888(str);
        m552Ooo();
    }
}
