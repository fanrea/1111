package com.netease.htprotect.necrash.nis.crashreport;

import com.alipay.sdk.m.u.b;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;
import com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.o0o0;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.netease.htprotect.necrash.nis.crashreport.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class O8oO888 {

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final String f168O8 = "BaseNdkHandler";

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0 f171o0o0;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private String f169O8oO888 = "https://crash.163.com/uploadCrashLogInfo.do";

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private String f170Ooo = "https://crash.163.com/client/api/uploadStartUpInfo.do";

    /* renamed from: 〇oO, reason: contains not printable characters */
    private final Oo0 f172oO = new O8(this);

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static void m605O8() {
        NativeHandler.m596O8oO888().m603Ooo();
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private o0o0 m606Ooo(String str, String str2) throws UnsupportedEncodingException {
        return new o0o0(mo540O8oO888(str), this.f169O8oO888, new o0o0(this, str2));
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private void m607Ooo() throws Throwable {
        o8o0.m581Ooo("check and report crash info");
        File[] fileArrM566O8 = this.f171o0o0.m566O8();
        if (fileArrM566O8.length > 0) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 5, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
            for (File file : fileArrM566O8) {
                try {
                    String strM564o0o0 = com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m564o0o0(file.getAbsolutePath());
                    if (mo542Ooo(strM564o0o0)) {
                        com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m563O8(file.getAbsolutePath());
                    } else {
                        o8o0.m581Ooo(strM564o0o0);
                        threadPoolExecutor.execute(m606Ooo(strM564o0o0, file.getAbsolutePath()));
                    }
                } catch (UnsupportedEncodingException unused) {
                    o8o0.m582Ooo(f168O8, "logInfo encode error");
                }
            }
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private void m608o0o0(String str) {
        this.f169O8oO888 = str;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private void m609oO(String str) {
        this.f170Ooo = str;
    }

    /* renamed from: O8〇oO8〇88 */
    protected abstract Map mo539O8oO888();

    /* renamed from: O8〇oO8〇88 */
    protected abstract Map mo540O8oO888(String str);

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m610O8oO888(String str, String str2) throws Throwable {
        com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0 oo0M562O8oO888 = com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m562O8oO888();
        this.f171o0o0 = oo0M562O8oO888;
        oo0M562O8oO888.m565O8oO888(str);
        NativeHandler.m596O8oO888().m602O8oO888(str, str2, this.f172oO);
        o8o0.m581Ooo("check and report crash info");
        File[] fileArrM566O8 = this.f171o0o0.m566O8();
        if (fileArrM566O8.length > 0) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 5, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
            for (File file : fileArrM566O8) {
                try {
                    String strM564o0o0 = com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m564o0o0(file.getAbsolutePath());
                    if (mo542Ooo(strM564o0o0)) {
                        com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m563O8(file.getAbsolutePath());
                    } else {
                        o8o0.m581Ooo(strM564o0o0);
                        threadPoolExecutor.execute(m606Ooo(strM564o0o0, file.getAbsolutePath()));
                    }
                } catch (UnsupportedEncodingException unused) {
                    o8o0.m582Ooo(f168O8, "logInfo encode error");
                }
            }
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    protected final void m611O8(String str) throws Throwable {
        String strM564o0o0 = com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m564o0o0(str);
        if (mo542Ooo(strM564o0o0)) {
            com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m563O8(str);
            return;
        }
        o8o0.m581Ooo(strM564o0o0);
        Thread thread = new Thread(m606Ooo(strM564o0o0, str));
        thread.start();
        try {
            thread.join(b.a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            o8o0.m579O8("quick upload isInterrupted");
        }
    }

    /* renamed from: 〇Ooo */
    protected boolean mo542Ooo(String str) {
        return false;
    }
}
