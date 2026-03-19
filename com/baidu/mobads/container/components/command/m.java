package com.baidu.mobads.container.components.command;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.bj;
import com.baidu.mobads.container.util.bp;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.t;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class m {
    private static final String a = "XAdRemoteDownloadAPKCommand";
    private Context b;
    private o c;
    private bq d;
    private IOAdEventListener e;
    private a f;

    public m(Context context, o oVar) {
        this(context, oVar, null);
    }

    public m(Context context, o oVar, IOAdEventListener iOAdEventListener) {
        this.d = bq.a();
        this.f = new a();
        this.c = oVar;
        this.b = context;
        this.e = iOAdEventListener;
    }

    public void a() {
        j jVarA;
        Object obj;
        try {
            String strE = e();
            com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(this.b).b(strE);
            c cVarA = c.a(strE);
            boolean z = true;
            if (cVarA != null && bVarB != null) {
                jVarA = cVarA.a();
                cVarA.a(this.e);
                a(jVarA);
                bVarB.c(!jVarA.ao);
                b.a aVarI = bVarB.i();
                this.d.a(a, "startDownload>> downloader exist: state=" + aVarI);
                if (aVarI != b.a.CANCELLED && aVarI != b.a.ERROR && aVarI != b.a.PAUSED) {
                    if (aVarI == b.a.COMPLETED) {
                        if (a(this.b, jVarA)) {
                            by.a(this.c.d());
                            a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_COMPLETE);
                            a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
                            return;
                        } else {
                            bVarB.s();
                            c.b(strE);
                            com.baidu.mobads.container.components.e.f.a(this.b).c(strE);
                        }
                    } else {
                        if (aVarI != b.a.DOWNLOADING) {
                            if (aVarI == b.a.INITING) {
                            }
                        }
                        bp.a().a(this.b, bu.i, "downloading", this.c);
                        a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_DOWNLOADING);
                        a(this.b, "应用即将下载完成，请耐心等待~", 0, Boolean.valueOf(this.c.k()));
                        return;
                    }
                }
                bVarB.c();
                StringBuilder sb = new StringBuilder("resume");
                sb.append("&preState=").append(aVarI.b());
                bp.a().a(this.b, 407, sb.toString(), this.c);
                a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_RESUME);
                by.a(this.c.d());
                this.f.a(this.b, jVarA.d());
                return;
            }
            if (bVarB != null) {
                bVarB.s();
            }
            c.b(strE);
            com.baidu.mobads.container.components.e.f.a(this.b).c(strE);
            jVarA = null;
            j jVarA2 = j.a(this.b, strE);
            if (jVarA2 != null) {
                a(jVarA2);
                if (jVarA2.X == b.a.COMPLETED && a(this.b, jVarA2)) {
                    by.a(this.c.d());
                    a(jVarA2, com.baidu.mobads.container.components.h.a.EVENT_DL_COMPLETE);
                    a(jVarA2, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
                    return;
                }
                jVarA2.a(this.c.g(), this.c.a(), this.c.d(), this.c.t(), this.c.h);
                obj = "";
                jVarA2.a(this.c.C(), this.c.n, this.c.E(), this.c.F(), this.c.G(), this.c.H(), this.c.I());
                jVarA2.al = this.c.A();
                jVarA2.W = c.c(strE);
                jVarA2.a(this.c.x, this.c.w);
                jVarA2.a(ap.a(jVarA2.aa) + ".apk", bw.i(this.b));
                by.a(this.c.d());
            } else {
                obj = "";
                if (d()) {
                    bp.a().a(this.b, bu.i, "alreadyinstalled_call_openapp1", this.c);
                    a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_OPEN);
                    bj.b(this.b, this.c.j());
                    by.a(this.c.d());
                    a(301, true);
                    this.f.f(this.b, jVarA);
                    return;
                }
                String strH = this.c.h();
                if ((strH == null || strH.equals(obj)) && ((strH = this.c.c()) == null || strH.equals(obj))) {
                    strH = "您点击的应用";
                }
                j jVar = new j(strE, strH);
                jVar.aD = j.a(this.c.L);
                jVar.ak = strH;
                jVar.a(this.c.g(), this.c.a(), this.c.d(), this.c.t(), this.c.h);
                jVar.a(this.c.C(), this.c.n, this.c.E(), this.c.F(), this.c.G(), this.c.H(), this.c.I());
                jVar.a(this.c.x, this.c.w);
                jVar.ad = this.c.k();
                jVar.al = this.c.A();
                jVar.a(ap.a(jVar.aa) + ".apk", bw.i(this.b));
                jVar.a(this.c.r(), this.c.q(), this.c.s());
                jVar.W = c.c(strE);
                jVar.ao = !this.c.e();
                jVar.a(System.currentTimeMillis());
                jVar.b(this.c.f());
                jVar.a(this.c.l());
                jVar.a(this.c.x());
                jVar.a(this.c.x, this.c.w);
                jVar.av = this.c.u();
                jVar.aw = this.c.v();
                jVar.ax = this.c.w();
                jVar.au = a(this.c);
                jVar.aA = this.c.n();
                jVar.aB = this.c.o();
                try {
                    jVar.c("act", String.valueOf(this.c.b()));
                } catch (Exception e) {
                }
                jVarA2 = jVar;
            }
            jVarA2.ap = System.currentTimeMillis();
            com.baidu.mobads.container.components.e.b bVarA = com.baidu.mobads.container.components.e.f.a(this.b).a(new URL(jVarA2.aa), jVarA2.T, jVarA2.S, 3, jVarA2.Z, this.c.B());
            if (this.c.m() && this.c.p() != null && !this.c.p().equals(obj)) {
                jVarA2.as = true;
                jVarA2.at = this.c.p();
            }
            jVarA2.aE = this.c.J;
            jVarA2.aF = this.c.f725K;
            c cVar = new c(this.b, jVarA2);
            cVar.a(this.e);
            if (jVarA2.ao) {
                z = false;
            }
            bVarA.c(z);
            bVarA.addObserver(cVar);
            if (jVarA2.ao || com.baidu.mobads.container.util.e.a.i(this.b).booleanValue()) {
                bp.a().a(this.b, bu.g, "realstart", this.c);
                this.f.b(this.b, jVarA2);
                c();
                a(jVarA2, com.baidu.mobads.container.components.h.a.EVENT_DL_START);
                bVarA.d();
                a(this.b, "开始下载 " + b(jVarA2), 0, Boolean.valueOf(this.c.k()));
                return;
            }
            bp.a().a(this.b, bu.i, "waitwifi", this.c);
            bVarA.a(0);
            a(this.b, "将在连入Wifi后开始下载", 0, Boolean.valueOf(this.c.k()));
            a(jVarA2, com.baidu.mobads.container.components.h.a.EVENT_DL_WAIT_WIFI);
        } catch (Exception e2) {
            this.d.c(a, e2);
        }
    }

    public static void a(Context context, String str, int i, Boolean bool) {
        if (bool.booleanValue()) {
            com.baidu.mobads.container.util.h.a(new n(context, str, i));
        }
    }

    private void c() {
        try {
            Iterator<String> it = this.c.J.iterator();
            while (it.hasNext()) {
                new com.baidu.mobads.container.components.g.f(1, it.next()).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean d() {
        return com.baidu.mobads.container.util.j.b(this.b, this.c.j());
    }

    protected boolean a(Context context, j jVar) {
        boolean zB = com.baidu.mobads.container.util.j.b(context, jVar.Z);
        bp bpVarA = bp.a();
        if (zB) {
            bpVarA.a(this.b, bu.i, bp.a, this.c);
            this.f.f(context, jVar);
            a(jVar, com.baidu.mobads.container.components.h.a.EVENT_DL_OPEN);
            bj.b(context, jVar.Z);
            a(301, true);
            return true;
        }
        String str = jVar.T + jVar.S;
        File file = new File(str);
        if (!file.exists() || file.length() <= 0 || a(file, jVar)) {
            return false;
        }
        bpVarA.a(this.b, bu.i, bp.b, this.c);
        this.f.e(context, jVar);
        a(jVar, com.baidu.mobads.container.components.h.a.EVENT_DL_INSTALL);
        t.a aVarE = t.e(this.b, str);
        if (aVarE != null && !TextUtils.isEmpty(aVarE.c) && !aVarE.c.equals(jVar.Z)) {
            jVar.b(this.b);
            jVar.Z = aVarE.c;
        }
        com.baidu.mobads.container.components.c.g.a().a(context, jVar);
        com.baidu.mobads.container.util.j.a(context, file, jVar);
        a(300, false);
        return true;
    }

    private static boolean a(File file, j jVar) {
        try {
            if (System.currentTimeMillis() - file.lastModified() <= 1296000000 || !file.delete()) {
                return false;
            }
            jVar.an = 0;
            jVar.U = -1L;
            jVar.V = 0;
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    private void a(j jVar) {
        if (jVar != null && this.c != null) {
            jVar.ad = this.c.k();
            jVar.ao = !this.c.e();
            jVar.ac = this.c.t();
            jVar.as = false;
            jVar.aa = this.c.d();
            if (this.c.m() && !TextUtils.isEmpty(this.c.p())) {
                jVar.as = true;
                jVar.at = this.c.p();
            }
            jVar.au = a(this.c);
            jVar.aA = this.c.n();
            jVar.aB = this.c.o();
            jVar.a(this.c.x());
            jVar.a(this.c.x, this.c.w);
            jVar.c("cur_qk", this.c.g());
            jVar.c("cur_adid", this.c.a());
            jVar.c("cur_buyer", this.c.h);
            jVar.c("cur_apid", this.c.r());
            jVar.c("cur_prod", this.c.q());
            jVar.c("cur_appsid", this.c.s());
            jVar.c("cur_url", this.c.d());
            jVar.aD = j.a(this.c.L);
            try {
                jVar.c("act", String.valueOf(this.c.b()));
            } catch (Exception e) {
            }
        }
    }

    public boolean b() {
        try {
            String strE = e();
            bp bpVarA = bp.a();
            com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(this.b).b(strE);
            c cVarA = c.a(strE);
            if (cVarA != null && bVarB != null) {
                j jVarA = cVarA.a();
                cVarA.a(this.e);
                a(jVarA);
                bVarB.c(!jVarA.ao);
                b.a aVarI = bVarB.i();
                this.d.a(a, "startDownload>> downloader exist: state=" + aVarI);
                if (aVarI != b.a.CANCELLED && aVarI != b.a.ERROR && aVarI != b.a.PAUSED) {
                    if (aVarI == b.a.COMPLETED) {
                        if (a(this.b, jVarA)) {
                            by.a(this.c.d());
                            a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_COMPLETE);
                            a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
                            return true;
                        }
                        bVarB.s();
                        c.b(strE);
                        com.baidu.mobads.container.components.e.f.a(this.b).c(strE);
                    } else {
                        if (aVarI != b.a.DOWNLOADING) {
                            if (aVarI == b.a.INITING) {
                            }
                        }
                        bpVarA.a(this.b, bu.i, "downloading", this.c);
                        a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_DOWNLOADING);
                        a(this.b, b(jVarA) + bVarB.i().c(), 0, Boolean.valueOf(this.c.k()));
                        return true;
                    }
                }
                bVarB.c();
                StringBuilder sb = new StringBuilder("resume");
                sb.append("&preState=").append(aVarI.b());
                bpVarA.a(this.b, 407, sb.toString(), this.c);
                a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_RESUME);
                by.a(this.c.d());
                return true;
            }
            if (bVarB != null) {
                bVarB.s();
            }
            c.b(strE);
            com.baidu.mobads.container.components.e.f.a(this.b).c(strE);
            j jVarA2 = j.a(this.b, strE);
            if (jVarA2 != null) {
                a(jVarA2);
                if (jVarA2.X == b.a.COMPLETED) {
                    if (a(this.b, jVarA2)) {
                        a(jVarA2, com.baidu.mobads.container.components.h.a.EVENT_DL_COMPLETE);
                        a(jVarA2, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
                        return true;
                    }
                } else if (jVarA2.X == b.a.CANCELLED || jVarA2.X == b.a.ERROR || jVarA2.X == b.a.PAUSED || jVarA2.X == b.a.DOWNLOADING) {
                    jVarA2.al = this.c.A();
                    jVarA2.W = c.c(strE);
                    jVarA2.ap = System.currentTimeMillis();
                    com.baidu.mobads.container.components.e.b bVarA = com.baidu.mobads.container.components.e.f.a(this.b).a(new URL(jVarA2.aa), jVarA2.T, jVarA2.S, 3, jVarA2.Z, this.c.B());
                    if (this.c.m() && this.c.p() != null && !this.c.p().equals("")) {
                        jVarA2.as = true;
                        jVarA2.at = this.c.p();
                    }
                    c cVar = new c(this.b, jVarA2);
                    cVar.a(this.e);
                    bVarA.c(!jVarA2.ao);
                    bVarA.addObserver(cVar);
                    bpVarA.a(this.b, 407, "resume_saved_info&preState=" + jVarA2.X.b(), this.c);
                    a(jVarA2, com.baidu.mobads.container.components.h.a.EVENT_DL_RESUME);
                    bVarA.d();
                    return true;
                }
            }
        } catch (Throwable th) {
            this.d.c(a, th);
        }
        return false;
    }

    public static boolean b(Context context, j jVar) {
        try {
            String strD = jVar.d();
            bp bpVarA = bp.a();
            com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(context).b(strD);
            c cVarA = c.a(strD);
            if (cVarA != null && bVarB != null) {
                j jVarA = cVarA.a();
                bVarB.c(!jVarA.ao);
                b.a aVarI = bVarB.i();
                com.baidu.mobads.container.l.g.b(a, "startDownload>> downloader exist: state=" + aVarI);
                if (aVarI != b.a.CANCELLED && aVarI != b.a.ERROR && aVarI != b.a.PAUSED) {
                    if (aVarI == b.a.COMPLETED) {
                        if (d(context, jVarA)) {
                            by.a(jVarA.aa);
                            return true;
                        }
                        bVarB.s();
                        c.b(strD);
                        com.baidu.mobads.container.components.e.f.a(context).c(strD);
                    } else {
                        if (aVarI != b.a.DOWNLOADING) {
                            if (aVarI == b.a.INITING) {
                            }
                        }
                        bpVarA.a(context, bu.i, "downloading", jVarA);
                        a(context, b(jVarA) + bVarB.i().c(), 0, Boolean.valueOf(jVarA.ad));
                        return true;
                    }
                }
                bVarB.c();
                StringBuilder sb = new StringBuilder("resume");
                sb.append("&preState=").append(aVarI.b());
                bpVarA.a(context, 407, sb.toString(), jVarA);
                by.a(jVarA.aa);
                return true;
            }
            if (bVarB != null) {
                bVarB.s();
            }
            c.b(strD);
            com.baidu.mobads.container.components.e.f.a(context).c(strD);
            if (jVar.X == b.a.COMPLETED) {
                if (d(context, jVar)) {
                    return true;
                }
            } else {
                if (jVar.X != b.a.CANCELLED) {
                    if (jVar.X != b.a.ERROR) {
                        if (jVar.X != b.a.PAUSED) {
                            if (jVar.X == b.a.DOWNLOADING) {
                            }
                        }
                    }
                }
                jVar.W = c.c(strD);
                jVar.ap = System.currentTimeMillis();
                com.baidu.mobads.container.components.e.b bVarA = com.baidu.mobads.container.components.e.f.a(context).a(new URL(jVar.aa), jVar.T, jVar.S, 3, jVar.Z, false);
                c cVar = new c(context, jVar);
                bVarA.c(!jVar.ao);
                bVarA.addObserver(cVar);
                bpVarA.a(context, 407, "resume_saved_info&preState=" + jVar.X.b(), jVar);
                bVarA.d();
                return true;
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(a, th);
        }
        return false;
    }

    private static boolean d(Context context, j jVar) {
        boolean zB = com.baidu.mobads.container.util.j.b(context, jVar.Z);
        bp bpVarA = bp.a();
        a aVar = new a();
        if (zB) {
            bpVarA.a(context, bu.i, bp.a, jVar);
            aVar.f(context, jVar);
            bj.b(context, jVar.Z);
            a(301, true, jVar);
            return true;
        }
        if (!c(context, jVar)) {
            return false;
        }
        bpVarA.a(context, bu.i, bp.b, jVar);
        aVar.e(context, jVar);
        a(300, false, jVar);
        return true;
    }

    public static boolean c(Context context, j jVar) {
        if (context != null && jVar != null) {
            String str = jVar.T + jVar.S;
            File file = new File(str);
            if (!file.exists() || file.length() <= 0 || a(file, jVar)) {
                return false;
            }
            t.a aVarE = t.e(context, str);
            if (aVarE != null && !TextUtils.isEmpty(aVarE.c) && !aVarE.c.equals(jVar.Z)) {
                jVar.b(context);
                jVar.Z = aVarE.c;
            }
            com.baidu.mobads.container.components.c.g.a().a(context, jVar);
            com.baidu.mobads.container.util.j.a(context, file, jVar);
            return true;
        }
        return false;
    }

    private String e() {
        try {
            String strJ = this.c.j();
            this.d.b(a, "download pkg = " + strJ + "， DownloadURL= " + this.c.d());
            if (TextUtils.isEmpty(strJ) && !TextUtils.isEmpty(this.c.d())) {
                this.d.b(a, "start to download but package is empty");
                return ap.a(this.c.d());
            }
            return strJ;
        } catch (Throwable th) {
            this.d.b(a, th.getMessage());
            return "";
        }
    }

    private static void a(int i, boolean z, j jVar) {
        try {
            com.baidu.mobads.container.components.h.a.a.a().b(jVar.i(), jVar.h(), i, z);
        } catch (Exception e) {
            bq.a().a(e);
        }
    }

    private void a(int i, boolean z) {
        try {
            com.baidu.mobads.container.components.h.a.a.a().b(this.c.g(), this.c.a(), i, z);
        } catch (Exception e) {
            bq.a().a(e);
        }
    }

    private void a(j jVar, com.baidu.mobads.container.components.h.a aVar) {
        if (jVar != null) {
            try {
                if (jVar.am != null && aVar != null) {
                    String str = jVar.am.get("uniqueId");
                    if (com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END.b() == aVar.b()) {
                        com.baidu.mobads.container.components.h.d.b(str);
                    } else {
                        com.baidu.mobads.container.components.h.d.a(str, aVar);
                    }
                }
            } catch (Exception e) {
                bq.a().a(e);
            }
        }
    }

    private static String b(j jVar) {
        String str = jVar.R;
        if (jVar.ak != null && !jVar.ak.isEmpty()) {
            return jVar.ak;
        }
        return str;
    }

    private String a(o oVar) {
        JSONObject jSONObject;
        try {
            String strZ = oVar.z();
            if (TextUtils.isEmpty(strZ)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(strZ);
            }
            if (jSONObject != null) {
                return jSONObject.optString("page");
            }
        } catch (Throwable th) {
        }
        return null;
    }
}
