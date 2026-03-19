package com.apm.insight.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import androidx.profileinstaller.ProfileVerifier;
import com.apm.insight.log.a.a;
import com.apm.insight.log.a.f;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a {
    private static int a = 3;
    private static volatile boolean b = false;
    private static volatile Set<String> c = null;
    private static volatile boolean d = false;
    private static com.apm.insight.log.a.a e;
    private static HandlerThread g;
    private static Handler h;
    private static HashMap<String, com.apm.insight.log.a.a> f = new HashMap<>();
    private static long i = -1;
    private static boolean j = false;
    private static Object k = new Object();

    public static boolean a(VLogConfig vLogConfig) throws Throwable {
        boolean z = false;
        if (vLogConfig == null) {
            return false;
        }
        try {
            com.apm.insight.log.a.a.a(new c());
            synchronized (k) {
                if (j) {
                    return false;
                }
                j = true;
                a = vLogConfig.getLevel();
                boolean zA = c.a(vLogConfig.getContext());
                boolean zIsOffloadMainThreadWrite = vLogConfig.isOffloadMainThreadWrite();
                if (!zIsOffloadMainThreadWrite && vLogConfig.isMainThreadSpeedUp() && zA) {
                    z = true;
                }
                if (!zA) {
                    vLogConfig.setMaxDirSize((int) (vLogConfig.getMaxDirSize() * vLogConfig.getSubProcessMaxDirSizeRatio()));
                }
                f.a(new a.b(vLogConfig.getContext()).a(ILogConst.PLAY_SOURCE_DEFAULT).a(vLogConfig.getLevel() - 2).a(b).b(vLogConfig.getLogDirPath()).b(vLogConfig.getPerSize()).c(z ? (vLogConfig.getMaxDirSize() / 3) << 1 : vLogConfig.getMaxDirSize()).d(vLogConfig.getLogFileExpDays()).c(vLogConfig.getBufferDirPath()).e(zA ? 65536 : 32768).f(zA ? ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE : 65536).a(a.d.a).a(a.g.a).a(a.e.b).a(vLogConfig.isCompress() ? a.c.b : a.c.a).a(vLogConfig.isEncrypt() ? a.f.b : a.f.a).a(vLogConfig.isEncrypt() ? a.EnumC0111a.b : a.EnumC0111a.a).d(vLogConfig.getPubKey()).a());
                if (zIsOffloadMainThreadWrite && zA) {
                    HandlerThread handlerThread = new HandlerThread("volc_log_delegate");
                    g = handlerThread;
                    handlerThread.start();
                    h = new com.apm.insight.log.b(g.getLooper());
                }
                if (z) {
                    e = new a.b(vLogConfig.getContext()).a(LiveConfigKey.MAIN).a(vLogConfig.getLevel() - 2).a(b).b(vLogConfig.getLogDirPath()).b(vLogConfig.getPerSize() / 2).c(vLogConfig.getMaxDirSize() / 3).d(vLogConfig.getLogFileExpDays()).c(vLogConfig.getBufferDirPath()).e(32768).f(98304).a(a.d.a).a(a.g.a).a(a.e.b).a(vLogConfig.isCompress() ? a.c.b : a.c.a).a(vLogConfig.isEncrypt() ? a.f.b : a.f.a).a(vLogConfig.isEncrypt() ? a.EnumC0111a.b : a.EnumC0111a.a).d(vLogConfig.getPubKey()).a();
                }
                vLogConfig.getBufferDirPath();
                vLogConfig.getLogDirPath();
                d = true;
                return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i2, String str) {
        return i2 >= a;
    }

    public static void a(String str, String str2) {
        if (b(2, str)) {
            boolean zA = c.a();
            if (zA && h != null) {
                a(2, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = e;
            if (aVar != null && zA) {
                aVar.a(str, str2);
            } else {
                f.a(str, str2);
            }
        }
    }

    public static void b(String str, String str2) {
        if (b(3, str)) {
            boolean zA = c.a();
            if (zA && h != null) {
                a(3, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = e;
            if (aVar != null && zA) {
                aVar.b(str, str2);
            } else {
                f.b(str, str2);
            }
        }
    }

    public static void c(String str, String str2) {
        if (b(4, str)) {
            boolean zA = c.a();
            if (zA && h != null) {
                a(4, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = e;
            if (aVar != null && zA) {
                aVar.c(str, str2);
            } else {
                f.c(str, str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (b(5, str)) {
            boolean zA = c.a();
            if (zA && h != null) {
                a(5, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = e;
            if (aVar != null && zA) {
                aVar.d(str, str2);
            } else {
                f.d(str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (b(6, str)) {
            boolean zA = c.a();
            if (zA && h != null) {
                a(6, str, str2);
                return;
            }
            com.apm.insight.log.a.a aVar = e;
            if (aVar != null && zA) {
                aVar.e(str, str2);
            } else {
                f.e(str, str2);
            }
        }
    }

    public static void a() {
        Handler handler = h;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
        f.b();
        com.apm.insight.log.a.a aVar = e;
        if (aVar != null) {
            aVar.b();
        }
        Iterator<com.apm.insight.log.a.a> it = f.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public static void a(int i2) {
        a = i2;
        int i3 = i2 - 2;
        f.a(i3);
        com.apm.insight.log.a.a aVar = e;
        if (aVar != null) {
            aVar.b(i3);
        }
    }

    public static HashMap<String, String> b() {
        return f.c();
    }

    public static void c() {
        f.a();
        com.apm.insight.log.a.a aVar = e;
        if (aVar != null) {
            aVar.a();
        }
        if (h != null) {
            g.quit();
            g = null;
            h = null;
        }
    }

    public static void d() {
        f.a();
        com.apm.insight.log.a.a aVar = e;
        if (aVar != null) {
            aVar.a();
        }
        if (h != null) {
            g.quit();
            g = null;
            h = null;
        }
    }

    private static void a(int i2, String str, String str2) {
        a(i2, str, str2, null, 0, null);
    }

    private static void a(int i2, String str, String str2, Throwable th, int i3, Object obj) {
        e();
        C0110a c0110aA = C0110a.a();
        c0110aA.a = i2;
        c0110aA.b = str;
        c0110aA.c = str2;
        c0110aA.d = null;
        c0110aA.e = 0;
        c0110aA.f = null;
        c0110aA.g = i;
        c0110aA.h = System.currentTimeMillis();
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = c0110aA;
        h.sendMessage(messageObtain);
    }

    private static void e() {
        if (i == -1) {
            i = Process.myTid();
        }
    }

    /* renamed from: com.apm.insight.log.a$a, reason: collision with other inner class name */
    static class C0110a {
        private static final Object i = new Object();
        private static C0110a j;
        private static int k;
        public int a;
        public String b;
        public String c;
        public Throwable d;
        public int e = 0;
        public Object f;
        public long g;
        public long h;
        private C0110a l;

        private C0110a() {
        }

        public static C0110a a() {
            synchronized (i) {
                C0110a c0110a = j;
                if (c0110a != null) {
                    j = c0110a.l;
                    c0110a.l = null;
                    k--;
                    return c0110a;
                }
                return new C0110a();
            }
        }

        public final void b() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = null;
            this.g = -1L;
            this.h = 0L;
            this.l = null;
            synchronized (i) {
                int i2 = k;
                if (i2 < 50) {
                    this.l = j;
                    j = this;
                    k = i2 + 1;
                }
            }
        }
    }

    public static b a(String str) {
        com.apm.insight.log.a.a aVar = f.get(str);
        if (aVar == null) {
            return null;
        }
        return new b(aVar);
    }

    public static b a(String str, VLogConfig vLogConfig) {
        if (vLogConfig == null) {
            return null;
        }
        if (!d) {
            try {
                com.apm.insight.log.a.a.a(new c());
            } catch (Throwable unused) {
                return null;
            }
        }
        if (!c.a(vLogConfig.getContext())) {
            vLogConfig.setMaxDirSize((int) (vLogConfig.getMaxDirSize() * vLogConfig.getSubProcessMaxDirSizeRatio()));
        }
        com.apm.insight.log.a.a aVarA = new a.b(vLogConfig.getContext()).a(str).a(vLogConfig.getLevel() - 2).a(b).b(vLogConfig.getLogDirPath()).b(vLogConfig.getPerSize()).c(vLogConfig.getMaxDirSize()).d(vLogConfig.getLogFileExpDays()).c(vLogConfig.getBufferDirPath()).e(65536).f(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE).a(a.d.a).a(a.g.a).a(a.e.b).a(vLogConfig.isCompress() ? a.c.b : a.c.a).a(vLogConfig.isEncrypt() ? a.f.b : a.f.a).a(vLogConfig.isEncrypt() ? a.EnumC0111a.b : a.EnumC0111a.a).d(vLogConfig.getPubKey()).a();
        if (aVarA == null) {
            return null;
        }
        f.put(str, aVarA);
        return new b(aVarA);
    }

    public static class b implements ILog {
        private final com.apm.insight.log.a.a a;

        b(com.apm.insight.log.a.a aVar) {
            this.a = aVar;
        }

        @Override // com.apm.insight.log.ILog
        public final void v(String str, String str2) {
            if (a.b(2, str)) {
                this.a.a(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final void d(String str, String str2) {
            if (a.b(3, str)) {
                this.a.b(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final void i(String str, String str2) {
            if (a.b(4, str)) {
                this.a.c(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final void w(String str, String str2) {
            if (a.b(5, str)) {
                this.a.d(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final void e(String str, String str2) {
            if (a.b(6, str)) {
                this.a.e(str, str2);
            }
        }

        @Override // com.apm.insight.log.ILog
        public final long getNativeRef() {
            return this.a.e();
        }

        @Override // com.apm.insight.log.ILog
        public final List<String> getFiles(long j, long j2) throws Throwable {
            ArrayList arrayList = new ArrayList();
            try {
                File[] fileArrA = this.a.a(j * 1000, j2 * 1000);
                for (File file : fileArrA) {
                    arrayList.add(file.getAbsolutePath());
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        @Override // com.apm.insight.log.ILog
        public final List<String> getFilesOfAllProcesses(long j, long j2) {
            ArrayList arrayList = new ArrayList();
            try {
                File[] fileArrA = this.a.a((String) null, j * 1000, j2 * 1000);
                for (File file : fileArrA) {
                    arrayList.add(file.getAbsolutePath());
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        @Override // com.apm.insight.log.ILog
        public final void asyncFlush() {
            this.a.b();
        }

        @Override // com.apm.insight.log.ILog
        public final void syncFlush() {
            this.a.c();
        }

        @Override // com.apm.insight.log.ILog
        public final void timedSyncFlush(int i) {
            this.a.a(i);
        }
    }

    static /* synthetic */ void a(C0110a c0110a) {
        String str;
        String str2;
        int i2 = c0110a.a - 2;
        if (c0110a.e == 0) {
            if (c0110a.d == null) {
                str2 = c0110a.c;
            } else {
                str2 = (c0110a.c != null ? c0110a.c + "\n" : "") + c.a(c0110a.d);
            }
            str = str2;
        } else {
            str = "";
        }
        f.a(i2, c0110a.b, str, c0110a.g, c0110a.h);
        c0110a.b();
    }
}
