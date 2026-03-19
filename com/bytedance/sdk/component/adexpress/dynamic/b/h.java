package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.sdk.component.adexpress.dynamic.c.mk;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private u an;
    public String b;
    public JSONObject c;
    public int d;
    private String h;
    public String hc;
    private an u;

    public h(u uVar) {
        this.an = uVar;
        this.d = uVar.d();
        this.hc = uVar.hc();
        this.b = uVar.b();
        this.c = uVar.u().qr();
        this.h = uVar.c();
        if (com.bytedance.sdk.component.adexpress.c.hc() == 1) {
            this.u = uVar.h();
        } else {
            this.u = uVar.u();
        }
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            this.u = uVar.u();
        }
    }

    public int d() {
        return (int) this.u.k();
    }

    public int hc() {
        return (int) this.u.w();
    }

    public int b() {
        return (int) this.u.e();
    }

    public int c() {
        return (int) this.u.cb();
    }

    public float u() {
        return this.u.yo();
    }

    public String an() {
        if (this.d != 0) {
            return "";
        }
        if (!TextUtils.isEmpty(this.hc)) {
            return this.hc;
        }
        return this.c.optString(com.bytedance.sdk.component.adexpress.c.gb.c(com.bytedance.sdk.component.adexpress.c.getContext()));
    }

    public int h() {
        return d(this.u.de());
    }

    public int gb() {
        String strSy = this.u.sy();
        if (j.d.equals(strSy)) {
            return 17;
        }
        if ("center".equals(strSy)) {
            return 4;
        }
        return j.e.equals(strSy) ? 3 : 2;
    }

    public int tt() {
        int iGb = gb();
        if (iGb == 4) {
            return 17;
        }
        return iGb == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String tc() {
        int i = this.d;
        return (i == 2 || i == 13) ? this.hc : "";
    }

    public String mk() {
        int i = this.d;
        return (i == 1 || i == 29) ? this.hc : "";
    }

    public String mq() {
        return this.h;
    }

    public double uo() throws NumberFormatException {
        if (this.d == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.c.d() ? (int) r3 : Double.parseDouble(this.hc);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double k() {
        return this.u.rf();
    }

    public float e() {
        return this.u.mk();
    }

    public int cb() {
        return d(this.u.he());
    }

    public float w() {
        return this.u.mq();
    }

    public int yo() {
        return this.u.ho();
    }

    public int rf() {
        return this.u.ec();
    }

    public boolean jh() {
        return this.u.ic();
    }

    public String sy() {
        return this.u.np();
    }

    public void d(float f) {
        this.u.d(f);
    }

    public boolean de() {
        return this.u.nv();
    }

    public int v() {
        return this.u.y();
    }

    public String np() {
        return this.u.hv();
    }

    public String yi() {
        return this.u.qv();
    }

    public long he() {
        return this.u.xi();
    }

    public int vv() {
        String strHv = this.u.hv();
        if ("skip-with-time-skip-btn".equals(this.an.getType()) || "skip".equals(this.an.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.an.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.an.getType()) && !"skip-with-time".equals(this.an.getType())) {
            if (this.d == 10 && TextUtils.equals(this.u.bc(), "click")) {
                return 5;
            }
            if (fv() && pq()) {
                return 0;
            }
            if (fv()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.an.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strHv) && !strHv.equals("none")) {
                if (strHv.equals("video") || (this.an.d() == 7 && TextUtils.equals(strHv, "normal"))) {
                    return (com.bytedance.sdk.component.adexpress.c.d() && this.an.u() != null && this.an.u().cj()) ? 11 : 4;
                }
                if (strHv.equals("normal")) {
                    return 1;
                }
                return (strHv.equals("creative") || ILogConst.DRAW_ENTER_TYPE_SLIDE.equals(this.u.bc())) ? 2 : 0;
            }
        }
        return 0;
    }

    private boolean fv() {
        return (com.bytedance.sdk.component.adexpress.c.d() && (this.an.getType().contains("logo-union") || this.an.getType().contains("logounion") || this.an.getType().contains("logoad"))) || "logo-union".equals(this.an.getType()) || "logounion".equals(this.an.getType()) || "logoad".equals(this.an.getType());
    }

    public int zw() {
        return d(this.u.v());
    }

    public double j() {
        return this.u.gb();
    }

    public int s() {
        return this.u.b();
    }

    public int us() {
        return this.u.hc();
    }

    public int z() {
        return this.u.u();
    }

    public int fs() {
        return this.u.c();
    }

    public int ba() {
        return this.u.tt();
    }

    public String mt() {
        return this.u.tc();
    }

    public String r() {
        return this.u.bc();
    }

    private boolean pq() {
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.hc) && this.hc.contains("adx:")) || mk.hc();
    }

    public static int d(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return -16777216;
    }

    public static float[] hc(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public boolean d(int i) {
        u uVar = this.an;
        if (uVar == null) {
            return false;
        }
        if (i == 1) {
            this.u = uVar.h();
        } else {
            this.u = uVar.u();
        }
        return this.u != null;
    }

    public boolean hv() {
        return this.u.t();
    }

    public int bc() {
        return this.u.gv();
    }

    public int dc() {
        return this.u.ph();
    }

    public String tr() {
        return this.u.r();
    }

    public boolean nv() {
        return this.u.f();
    }

    public int y() {
        return this.u.h();
    }

    public int wl() {
        return this.u.gu();
    }

    public int q() {
        return this.u.lv();
    }

    public int ru() {
        return this.u.oc();
    }

    public int yn() {
        return this.u.pq();
    }

    public boolean l() {
        return this.u.rs();
    }

    public String fu() {
        return this.u.j();
    }

    public String xp() {
        return this.u.tj();
    }

    public String to() {
        return this.u.ed();
    }

    public boolean ra() {
        return this.u.uo();
    }

    public boolean rw() {
        return this.u.us();
    }

    public String ia() {
        return this.u.s();
    }

    public int nw() {
        return this.u.z();
    }

    public int dz() {
        return this.u.fs();
    }

    public double nr() {
        return this.u.ba();
    }

    public double i() {
        return this.u.mt();
    }

    public int ey() {
        return this.u.ox();
    }

    public String qr() {
        return this.u.nk();
    }

    public String ar() {
        return this.u.kb();
    }

    public boolean t() {
        return this.u.js();
    }

    public int ph() {
        return this.u.o();
    }

    public int gv() {
        return this.u.mb();
    }

    public int qy() {
        return this.u.wb();
    }

    public boolean nf() {
        return this.u.rs();
    }

    public String gw() {
        return this.u.yi();
    }

    public String fy() {
        return this.d == 29 ? this.b : "";
    }

    public List<String> zv() {
        return this.u.ai();
    }

    public boolean um() {
        return this.u.mg();
    }
}
