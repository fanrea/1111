package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class k3 implements oj, rs {
    private l6 a;
    private l3 b;
    private String c;
    private int d;
    private qs e;
    private int f;
    private boolean g;
    private Boolean h;

    private ApkDownloadTask a(b bVar) {
        return (ApkDownloadTask) pro.getobjresult(194, 0, this, bVar);
    }

    static /* synthetic */ ApkDownloadTask a(k3 k3Var, b bVar) {
        return (ApkDownloadTask) pro.getobjresult(195, 1, k3Var, bVar);
    }

    static /* synthetic */ b a(k3 k3Var) {
        return (b) pro.getobjresult(196, 1, k3Var);
    }

    static /* synthetic */ l3 a(k3 k3Var, String str, Integer num) {
        return (l3) pro.getobjresult(197, 1, k3Var, str, num);
    }

    private l3 a(String str, Integer num) {
        return (l3) pro.getobjresult(198, 0, this, str, num);
    }

    private boolean a(int i) {
        return pro.getZresult(199, 0, this, Integer.valueOf(i));
    }

    private boolean a(String str) {
        return pro.getZresult(200, 0, this, str);
    }

    static /* synthetic */ l6 b(k3 k3Var) {
        return (l6) pro.getobjresult(201, 1, k3Var);
    }

    private void b() {
        pro.getVresult(202, 0, this);
    }

    private boolean b(int i) {
        return pro.getZresult(203, 0, this, Integer.valueOf(i));
    }

    private boolean b(String str) {
        return pro.getZresult(204, 0, this, str);
    }

    static /* synthetic */ qs c(k3 k3Var) {
        return (qs) pro.getobjresult(205, 1, k3Var);
    }

    private void c() {
        pro.getVresult(206, 0, this);
    }

    static /* synthetic */ int d(k3 k3Var) {
        return pro.getIresult(207, 1, k3Var);
    }

    private b d() {
        return (b) pro.getobjresult(208, 0, this);
    }

    private b e() {
        return (b) pro.getobjresult(209, 0, this);
    }

    private void f() {
        pro.getVresult(210, 0, this);
    }

    @Override // com.qq.e.comm.plugin.rs
    public void a(boolean z) {
        pro.getVresult(211, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        return pro.getZresult(212, 0, this, l6Var);
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) {
        return pro.getZresult(213, 0, this, l6Var, qsVar);
    }

    @Override // com.qq.e.comm.plugin.rs
    public boolean a(JSONObject jSONObject) {
        return pro.getZresult(214, 0, this, jSONObject);
    }

    @Override // com.qq.e.comm.plugin.rs
    public void b(boolean z) {
        pro.getVresult(215, 0, this, Boolean.valueOf(z));
    }

    @Override // com.qq.e.comm.plugin.rs
    public void onCancel() {
        pro.getVresult(216, 0, this);
    }

    k3() {
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVarA = k3.a(k3.this);
            if (k3.b(k3.this).a().a != 200) {
                if (k3.c(k3.this) != null) {
                    k3.c(k3.this).i();
                }
                b10.a(1100702, k3.b(k3.this).x, 6);
            } else {
                ApkDownloadTask apkDownloadTaskA = k3.a(k3.this, bVarA);
                if (k3.c(k3.this) != null) {
                    k3.c(k3.this).a(k3.a(k3.this, apkDownloadTaskA.p(), Integer.valueOf(k3.d(k3.this))));
                }
                com.qq.e.comm.plugin.apkmanager.l.e().c(apkDownloadTaskA);
                b10.a(1100703, k3.b(k3.this).x, Integer.valueOf(k3.b(k3.this).B.r1() ? 1 : -1));
            }
        }
    }

    /* compiled from: A */
    private static class b {
        private final String a;
        private final String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }
}
