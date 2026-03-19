package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.z50;
import java.lang.ref.WeakReference;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class bt implements oj {
    private String a;
    private long b;

    private static ApkDownloadTask a(String str, l6 l6Var) {
        return (ApkDownloadTask) pro.getobjresult(559, 1, str, l6Var);
    }

    static /* synthetic */ void a(int i, Integer num, l6 l6Var, boolean z, long j) {
        pro.getVresult(560, 1, Integer.valueOf(i), num, l6Var, Boolean.valueOf(z), Long.valueOf(j));
    }

    private void a(Integer num, l6 l6Var) {
        pro.getVresult(561, 0, this, num, l6Var);
    }

    private String b(l6 l6Var) {
        return (String) pro.getobjresult(562, 0, this, l6Var);
    }

    private static void b(int i, Integer num, l6 l6Var, boolean z, long j) {
        pro.getVresult(563, 1, Integer.valueOf(i), num, l6Var, Boolean.valueOf(z), Long.valueOf(j));
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        return pro.getZresult(564, 0, this, l6Var);
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) {
        return pro.getZresult(565, 0, this, l6Var, qsVar);
    }

    bt() {
    }

    /* compiled from: A */
    private static class c implements z50.a {
        private final f5 a;

        private c(f5 f5Var) {
            this.a = f5Var;
        }

        @Override // com.qq.e.comm.plugin.z50.a
        public void b(int i) {
            b10.a(1100944, this.a, 1, Integer.valueOf(i), null);
        }

        @Override // com.qq.e.comm.plugin.z50.a
        public void a(int i) {
            b10.a(1100945, this.a, 1, Integer.valueOf(i), null);
        }
    }

    /* compiled from: A */
    static class b implements c.a {
        private final ApkDownloadTask a;
        private final l6 b;
        private final WeakReference<m> c;
        private final long d;

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return false;
        }

        public b(l6 l6Var, ApkDownloadTask apkDownloadTask, qs qsVar, long j) {
            this.b = l6Var;
            this.a = apkDownloadTask;
            this.d = j;
            this.c = new WeakReference<>(qsVar.h());
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i, String str, boolean z) {
            if (i != 0) {
                return;
            }
            this.a.c(1);
            String strR = this.a.r();
            WeakReference<m> weakReference = this.c;
            m mVar = weakReference == null ? null : weakReference.get();
            if (mVar != null) {
                mVar.a(strR, this.a.o(), 100, this.b.B.o().f());
            }
            com.qq.e.comm.plugin.apkmanager.l.e().d(this.a);
            o.c(this.a, this.b.B);
            v20 v20VarA = j3.a(strR);
            v20VarA.d = 3;
            v20VarA.h = 1;
            t3.a(1100902, (Integer) 100, this.a);
            t3.a(1100903, (Integer) 100, this.a);
            t3.c(1100905, this.a);
            l6 l6Var = this.b;
            if (l6Var.s) {
                bt.a(4001043, null, l6Var, true, this.d);
            } else {
                bt.a(4001017, null, l6Var, false, this.d);
            }
            v20VarA.i = 2;
            ct.a(this.a);
        }
    }
}
