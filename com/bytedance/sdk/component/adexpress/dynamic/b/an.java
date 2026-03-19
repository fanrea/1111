package com.bytedance.sdk.component.adexpress.dynamic.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.sdk.m.n.a;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private String ai;
    private float an;
    private int ar;
    private float b;
    private String ba;
    private int bc;
    private float c;
    private String cb;
    private String cj;
    private boolean cw;
    private float d;
    private int dc;
    private String de;
    private boolean dz;
    private String e;
    private int ec;
    private boolean ed;
    private boolean el;
    private int eu;
    private int ey;
    private boolean f;
    private String fs;
    private boolean fu;
    private int fv;
    private int fy;
    private float gb;
    private int gu;
    private String gv;
    private int gw;
    private float h;
    private float hc;
    private int he;
    private JSONObject hg;
    private int ho;
    private boolean hr;
    private int hv;
    private int i;
    private JSONObject ia;
    private int ic;
    private double j;
    private String jh;
    private int jm;
    private boolean js;
    private String k;
    private int kb;
    private String l;
    private int lv;
    private boolean mb;
    private String mg;
    private double mk;
    private double mq;
    private boolean mt;
    private int nf;
    private int nk;
    private String np;
    private int nr;
    private double nv;
    private int nw;
    private int o;
    private double oc;
    private int om;
    private int ox;
    private String p;
    private List<String> pa;
    private String ph;
    private int pq;
    private int q;
    private int qr;
    private String qv;
    private boolean qy;
    private int r;
    private boolean ra;
    private String rf;
    private JSONObject rs;
    private boolean ru;
    private String rw;
    private String s;
    private String sy;
    private int t;
    private float tc;
    private JSONObject tj;
    private boolean to;
    private int tr;
    private float tt;
    private boolean u;
    private int um;
    private String uo;
    private String us;
    private String v;
    private int vv;
    private String w;
    private boolean wb;
    private boolean wl;
    private String xi;
    private String xn;
    private boolean xp;
    private int y;
    private long yb = -1;
    private boolean yi;
    private int yn;
    private String yo;
    private String z;
    private String zk;
    private List<d> zv;
    private double zw;

    public static an d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        an anVar = new an();
        anVar.hc(jSONObject.optString("adType", "embeded"));
        anVar.e(jSONObject.optString("clickArea", "creative"));
        anVar.cb(jSONObject.optString("clickTigger", "click"));
        anVar.b(jSONObject.optString("fontFamily", "PingFangSC"));
        anVar.c(jSONObject.optString("textAlign", j.d));
        anVar.u(jSONObject.optString(TypedValues.Custom.S_COLOR, "#999999"));
        anVar.an(jSONObject.optString("bgColor", "transparent"));
        anVar.h(jSONObject.optString("bgImgUrl", ""));
        anVar.zw(jSONObject.optString("bgImgData", ""));
        anVar.gb(jSONObject.optString("borderColor", "#000000"));
        anVar.tt(jSONObject.optString("borderStyle", "solid"));
        anVar.tc(jSONObject.optString("heightMode", "auto"));
        anVar.mk(jSONObject.optString("widthMode", "fixed"));
        anVar.mq(jSONObject.optString("interactText", ""));
        anVar.b(jSONObject.optBoolean("isShowBgControl", false));
        anVar.uo(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            anVar.h(jSONObjectOptJSONObject.optInt("translateY", 0));
            anVar.gb(jSONObjectOptJSONObject.optInt("translateX", 0));
            anVar.c(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            anVar.u(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        anVar.k(jSONObject.optString("interactType", ""));
        anVar.u(jSONObject.optInt("interactSlideDirection", -1));
        anVar.w(jSONObject.optString("justifyHorizontal", "space-around"));
        anVar.yo(jSONObject.optString("justifyVertical", "flex-start"));
        anVar.hc(jSONObject.optDouble("timingStart"));
        anVar.b(jSONObject.optDouble("timingEnd"));
        anVar.c((float) jSONObject.optDouble("width", 0.0d));
        anVar.b((float) jSONObject.optDouble("height", 0.0d));
        anVar.d((float) jSONObject.optDouble("borderRadius", 0.0d));
        anVar.hc((float) jSONObject.optDouble("borderSize", 0.0d));
        anVar.hc(jSONObject.optBoolean("interactValidate", false));
        anVar.tt((float) jSONObject.optDouble("fontSize", 0.0d));
        anVar.u((float) jSONObject.optDouble("paddingBottom", 0.0d));
        anVar.an((float) jSONObject.optDouble("paddingLeft", 0.0d));
        anVar.h((float) jSONObject.optDouble("paddingRight", 0.0d));
        anVar.gb((float) jSONObject.optDouble("paddingTop", 0.0d));
        anVar.c(jSONObject.optBoolean("lineFeed", false));
        anVar.tt(jSONObject.optInt("lineCount", 0));
        anVar.an(jSONObject.optDouble("lineHeight", 1.2d));
        anVar.k(jSONObject.optInt("letterSpacing", 0));
        anVar.u(jSONObject.optBoolean("isDataFixed", false));
        anVar.e(jSONObject.optInt("fontWeight"));
        anVar.an(jSONObject.optBoolean("lineLimit"));
        anVar.cb(jSONObject.optInt("position"));
        anVar.rf(jSONObject.optString("align"));
        anVar.h(jSONObject.optBoolean("useLeft"));
        anVar.gb(jSONObject.optBoolean("useRight"));
        anVar.tt(jSONObject.optBoolean("useTop"));
        anVar.tc(jSONObject.optBoolean("useBottom"));
        anVar.jh(jSONObject.optString("data"));
        anVar.hc(jSONObject.optJSONObject("i18n"));
        anVar.mq(jSONObject.optInt("marginLeft"));
        anVar.uo(jSONObject.optInt("marginRight"));
        anVar.tc(jSONObject.optInt("marginTop"));
        anVar.mk(jSONObject.optInt("marginBottom"));
        anVar.w(jSONObject.optInt("tagMaxCount"));
        anVar.mk(jSONObject.optBoolean("allowTextFlow"));
        anVar.yo(jSONObject.optInt("textFlowType"));
        anVar.rf(jSONObject.optInt("textFlowDuration"));
        anVar.jh(jSONObject.optInt(j.d));
        anVar.sy(jSONObject.optInt(j.e));
        anVar.de(jSONObject.optInt(j.f));
        anVar.v(jSONObject.optInt(j.g));
        anVar.sy(jSONObject.optString("alignItems", "flex-start"));
        anVar.de(jSONObject.optString("direction", ""));
        anVar.d(jSONObject.optBoolean("loop", false));
        anVar.np(jSONObject.optInt("zIndex"));
        anVar.j(jSONObject.optInt("interactVisibleTime"));
        anVar.yi(jSONObject.optInt("interactHiddenTime"));
        anVar.uo(jSONObject.optBoolean("interactEnableMask"));
        anVar.k(jSONObject.optBoolean("interactWontHide"));
        anVar.d(jSONObject.optString("bgGradient"));
        anVar.us(jSONObject.optInt("areaType"));
        anVar.z(jSONObject.optInt("interactSlideThreshold", 0));
        anVar.mt(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.c.d() ? 0 : 120));
        anVar.yo(jSONObject.optBoolean("openPlayableLandingPage", false));
        anVar.b(jSONObject.optJSONObject("video"));
        anVar.c(jSONObject.optJSONObject("image"));
        anVar.fs(jSONObject.optInt("borderShadowExtent"));
        anVar.e(jSONObject.optBoolean("bgGauseBlur"));
        anVar.ba(jSONObject.optInt("bgGauseBlurRadius"));
        anVar.cb(jSONObject.optBoolean("showTimeProgress", false));
        anVar.w(jSONObject.optBoolean("showPlayButton", false));
        anVar.d(jSONObject.optDouble("bgColorCg", 0.0d));
        anVar.an(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        anVar.hc(jSONObject.optInt("borderTopLeftRadius", 0));
        anVar.d(jSONObject.optInt("borderTopRightRadius", 0));
        anVar.c(jSONObject.optInt("borderBottomLeftRadius", 0));
        anVar.b(jSONObject.optInt("borderBottomRightRadius", 0));
        anVar.u(jSONObject.optJSONObject("interactI18n"));
        anVar.np(jSONObject.optString("imageObjectFit"));
        anVar.yi(jSONObject.optString("interactTitle"));
        anVar.s(jSONObject.optInt("interactTextPositionTop"));
        anVar.v(jSONObject.optString("imageLottieTosPath"));
        anVar.mq(jSONObject.optBoolean("animationsLoop"));
        anVar.he(jSONObject.optInt("lottieAppNameMaxLength"));
        anVar.zw(jSONObject.optInt("lottieAdDescMaxLength"));
        anVar.vv(jSONObject.optInt("lottieAdTitleMaxLength"));
        anVar.vv(jSONObject.optString("imageFlipSlideType"));
        anVar.rf(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filterColor");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
                anVar.hc(arrayList);
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    d dVar = new d();
                    dVar.b(jSONObject2.optString("animationType"));
                    dVar.d(jSONObject2.optDouble("animationDuration"));
                    dVar.hc(jSONObject2.optDouble("animationScaleX"));
                    dVar.b(jSONObject2.optDouble("animationScaleY"));
                    dVar.c(jSONObject2.optString("animationTimeFunction"));
                    dVar.c(jSONObject2.optDouble("animationDelay"));
                    dVar.an(jSONObject2.optInt("animationIterationCount"));
                    dVar.u(jSONObject2.optString("animationDirection"));
                    dVar.u(jSONObject2.optDouble("animationInterval"));
                    dVar.d(jSONObject2.optInt("animationBorderWidth"));
                    dVar.d(jSONObject2.optLong("key"));
                    dVar.hc(jSONObject2.optInt("animationEffectWidth"));
                    dVar.b(jSONObject2.optInt("animationSwing", 1));
                    dVar.c(jSONObject2.optInt("animationTranslateX"));
                    dVar.u(jSONObject2.optInt("animationTranslateY"));
                    dVar.hc(jSONObject2.optString("animationRippleBackgroundColor"));
                    dVar.d(jSONObject2.optString("animationScaleDirection"));
                    dVar.h(jSONObject2.optInt("animationFadeStart"));
                    dVar.gb(jSONObject2.optInt("animationFadeEnd"));
                    dVar.an(jSONObject2.optString("animationFillMode"));
                    dVar.tt(jSONObject2.optInt("animationBounceHeight"));
                    if (anVar.rf() > 0.0d) {
                        dVar.c(dVar.k() + anVar.rf());
                    }
                    arrayList2.add(dVar);
                }
                anVar.d(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                anVar.he(jSONObject.optString("triggerSlideDirection", "0"));
                anVar.d(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return anVar;
    }

    public boolean d() {
        return this.qy;
    }

    public void d(boolean z) {
        this.qy = z;
    }

    public int hc() {
        return this.ho;
    }

    public void d(int i) {
        this.ho = i;
    }

    public int b() {
        return this.ic;
    }

    public void hc(int i) {
        this.ic = i;
    }

    public int c() {
        return this.ec;
    }

    public void b(int i) {
        this.ec = i;
    }

    public int u() {
        return this.jm;
    }

    public void c(int i) {
        this.jm = i;
    }

    public JSONObject an() {
        return this.hg;
    }

    public int h() {
        return this.ox;
    }

    public void u(int i) {
        this.ox = i;
    }

    public double gb() {
        return this.oc;
    }

    public void d(double d) {
        this.oc = d;
    }

    public int tt() {
        return this.gu;
    }

    public void an(int i) {
        this.gu = i;
    }

    public String tc() {
        return this.xn;
    }

    public void d(String str) {
        this.xn = str;
    }

    public float mk() {
        return this.d;
    }

    public void d(float f) {
        this.d = f;
    }

    public float mq() {
        return this.hc;
    }

    public void hc(float f) {
        this.hc = f;
    }

    public void b(float f) {
        this.b = f;
    }

    public void c(float f) {
        this.c = f;
    }

    public boolean uo() {
        return this.u;
    }

    public void hc(boolean z) {
        this.u = z;
    }

    public float k() {
        return this.an;
    }

    public void u(float f) {
        this.an = f;
    }

    public float e() {
        return this.h;
    }

    public void an(float f) {
        this.h = f;
    }

    public float cb() {
        return this.gb;
    }

    public void h(float f) {
        this.gb = f;
    }

    public float w() {
        return this.tt;
    }

    public void gb(float f) {
        this.tt = f;
    }

    public float yo() {
        return this.tc;
    }

    public void tt(float f) {
        this.tc = f;
    }

    public double rf() {
        return this.mk;
    }

    public void hc(double d) {
        this.mk = d;
    }

    public double jh() {
        return this.mq;
    }

    public void b(double d) {
        this.mq = d;
    }

    public void hc(String str) {
        this.uo = str;
    }

    public void b(String str) {
        this.k = str;
    }

    public String sy() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String de() {
        return this.cb;
    }

    public void u(String str) {
        this.cb = str;
    }

    public String v() {
        return this.w;
    }

    public void an(String str) {
        this.w = str;
    }

    public void h(String str) {
        this.yo = str;
    }

    public String np() {
        return this.yo;
    }

    private void zw(String str) {
        this.ai = str;
    }

    public String yi() {
        return this.ai;
    }

    public String he() {
        return this.rf;
    }

    public void gb(String str) {
        this.rf = str;
    }

    public void tt(String str) {
        this.jh = str;
    }

    public String vv() {
        return this.sy;
    }

    public void tc(String str) {
        this.sy = str;
    }

    public String zw() {
        return this.de;
    }

    public void mk(String str) {
        this.de = str;
    }

    public String j() {
        return this.v;
    }

    public void mq(String str) {
        this.v = str;
    }

    public String s() {
        return this.np;
    }

    public void uo(String str) {
        this.np = str;
    }

    public boolean us() {
        return this.yi;
    }

    public void b(boolean z) {
        this.yi = z;
    }

    public int z() {
        return this.he;
    }

    public void h(int i) {
        this.he = i;
    }

    public int fs() {
        return this.vv;
    }

    public void gb(int i) {
        this.vv = i;
    }

    public double ba() {
        return this.zw;
    }

    public void c(double d) {
        this.zw = d;
    }

    public double mt() {
        return this.j;
    }

    public void u(double d) {
        this.j = d;
    }

    public String r() {
        return this.s;
    }

    public void k(String str) {
        this.s = str;
    }

    public String hv() {
        return this.us;
    }

    public void e(String str) {
        this.us = str;
    }

    public String bc() {
        return this.z;
    }

    public void cb(String str) {
        this.z = str;
    }

    public String dc() {
        return this.fs;
    }

    public void w(String str) {
        this.fs = str;
    }

    public String tr() {
        return this.ba;
    }

    public void yo(String str) {
        this.ba = str;
    }

    public boolean nv() {
        return this.mt;
    }

    public void c(boolean z) {
        this.mt = z;
    }

    public void tt(int i) {
        this.r = i;
    }

    public int y() {
        return this.r;
    }

    public int wl() {
        return this.hv;
    }

    public void tc(int i) {
        this.hv = i;
    }

    public int q() {
        return this.bc;
    }

    public void mk(int i) {
        this.bc = i;
    }

    public int ru() {
        return this.dc;
    }

    public void mq(int i) {
        this.dc = i;
    }

    public int yn() {
        return this.tr;
    }

    public void uo(int i) {
        this.tr = i;
    }

    public double l() {
        return this.nv;
    }

    public void an(double d) {
        this.nv = d;
    }

    public int fu() {
        return this.y;
    }

    public void k(int i) {
        this.y = i;
    }

    public boolean xp() {
        return this.wl;
    }

    public void u(boolean z) {
        this.wl = z;
    }

    public int to() {
        return this.q;
    }

    public void e(int i) {
        this.q = i;
    }

    public boolean ra() {
        return this.ru;
    }

    public void an(boolean z) {
        this.ru = z;
    }

    public int rw() {
        return this.yn;
    }

    public void cb(int i) {
        this.yn = i;
    }

    public String ia() {
        return this.l;
    }

    public void rf(String str) {
        this.l = str;
    }

    public boolean nw() {
        return this.fu;
    }

    public void h(boolean z) {
        this.fu = z;
    }

    public boolean dz() {
        return this.xp;
    }

    public void gb(boolean z) {
        this.xp = z;
    }

    public boolean nr() {
        return this.to;
    }

    public void tt(boolean z) {
        this.to = z;
    }

    public boolean i() {
        return this.ra;
    }

    public void tc(boolean z) {
        this.ra = z;
    }

    public String ey() {
        return this.rw;
    }

    public void jh(String str) {
        this.rw = str;
    }

    public void hc(JSONObject jSONObject) {
        this.ia = jSONObject;
    }

    public JSONObject qr() {
        return this.ia;
    }

    public int ar() {
        return this.nw;
    }

    public void w(int i) {
        this.nw = i;
    }

    public boolean t() {
        return this.dz;
    }

    public void mk(boolean z) {
        this.dz = z;
    }

    public int ph() {
        return this.nr;
    }

    public void yo(int i) {
        this.nr = i;
    }

    public int gv() {
        return this.i;
    }

    public void rf(int i) {
        this.i = i;
    }

    public int qy() {
        return this.ey;
    }

    public void jh(int i) {
        this.ey = i;
    }

    public int nf() {
        return this.qr;
    }

    public void sy(int i) {
        this.qr = i;
    }

    public int gw() {
        return this.ar;
    }

    public void de(int i) {
        this.ar = i;
    }

    public int fy() {
        return this.t;
    }

    public void v(int i) {
        this.t = i;
    }

    public String zv() {
        return this.ph;
    }

    public void sy(String str) {
        this.ph = str;
    }

    public String um() {
        return this.gv;
    }

    public void de(String str) {
        this.gv = str;
    }

    public int fv() {
        return this.nf;
    }

    public void np(int i) {
        this.nf = i;
    }

    public int pq() {
        return this.gw;
    }

    public void yi(int i) {
        this.gw = i;
    }

    public String kb() {
        return this.zk;
    }

    public void v(String str) {
        this.zk = str;
    }

    public boolean js() {
        return this.el;
    }

    public void mq(boolean z) {
        this.el = z;
    }

    public int wb() {
        return this.nk;
    }

    public void he(int i) {
        this.nk = i;
    }

    public int mb() {
        return this.om;
    }

    public void vv(int i) {
        this.om = i;
    }

    public int o() {
        return this.eu;
    }

    public void zw(int i) {
        this.eu = i;
    }

    public boolean f() {
        return this.ed;
    }

    public void uo(boolean z) {
        this.ed = z;
    }

    public int oc() {
        return this.fy;
    }

    public void j(int i) {
        this.fy = i;
    }

    public void k(boolean z) {
        this.hr = z;
    }

    public boolean rs() {
        return this.hr;
    }

    public void np(String str) {
        this.cj = str;
    }

    public String tj() {
        return this.cj;
    }

    public void s(int i) {
        this.lv = i;
    }

    public int ox() {
        return this.lv;
    }

    public List<d> p() {
        return this.zv;
    }

    public int hr() {
        List<d> list = this.zv;
        if (list == null) {
            return 0;
        }
        for (d dVar : list) {
            if (j.a.equals(dVar.tt()) && dVar.h() < 0) {
                return -dVar.h();
            }
        }
        return 0;
    }

    public void d(List<d> list) {
        this.zv = list;
    }

    public int hg() {
        return this.um;
    }

    public void us(int i) {
        this.um = i;
    }

    public int gu() {
        return this.fv;
    }

    public void z(int i) {
        this.fv = i;
    }

    public int ho() {
        return this.pq;
    }

    public void fs(int i) {
        this.pq = i;
    }

    public boolean ic() {
        return this.js;
    }

    public void e(boolean z) {
        this.js = z;
    }

    public int ec() {
        return this.kb;
    }

    public void ba(int i) {
        this.kb = i;
    }

    public boolean jm() {
        return this.wb;
    }

    public void cb(boolean z) {
        this.wb = z;
    }

    public boolean cj() {
        return this.mb;
    }

    public void w(boolean z) {
        this.mb = z;
    }

    public int lv() {
        return this.o;
    }

    public void mt(int i) {
        this.o = i;
    }

    public String ed() {
        return this.p;
    }

    public boolean zk() {
        return this.f;
    }

    public void yo(boolean z) {
        this.f = z;
    }

    public void b(JSONObject jSONObject) {
        this.rs = jSONObject;
    }

    public JSONObject el() {
        return this.tj;
    }

    public void c(JSONObject jSONObject) {
        this.tj = jSONObject;
    }

    public void u(JSONObject jSONObject) {
        this.hg = jSONObject;
    }

    public String nk() {
        return this.qv;
    }

    public void yi(String str) {
        this.qv = str;
    }

    public void om() {
        d(this, this.rs);
    }

    public void eu() {
        d(this, this.tj);
    }

    public String qv() {
        return this.xi;
    }

    public void he(String str) {
        this.xi = str;
    }

    public long xi() {
        return this.yb;
    }

    public void d(long j) {
        this.yb = j;
    }

    public String yb() {
        return ("flip".equals(this.mg) || ILogConst.DRAW_ENTER_TYPE_SLIDE.equals(this.mg)) ? this.mg : ILogConst.DRAW_ENTER_TYPE_SLIDE;
    }

    public void vv(String str) {
        this.mg = str;
    }

    public List<String> ai() {
        return this.pa;
    }

    public void hc(List<String> list) {
        this.pa = list;
    }

    public void rf(boolean z) {
        this.cw = z;
    }

    public boolean mg() {
        return this.cw;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void d(an anVar, JSONObject jSONObject) {
        if (anVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            char c = 65535;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1383228885:
                    if (next.equals(j.g)) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        c = 16;
                        break;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        c = 18;
                        break;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        c = 19;
                        break;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        c = 20;
                        break;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        c = 21;
                        break;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        c = 22;
                        break;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        c = 23;
                        break;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        c = 24;
                        break;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        c = 25;
                        break;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        c = 27;
                        break;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        c = 28;
                        break;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        c = 29;
                        break;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        c = 30;
                        break;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        c = 31;
                        break;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        c = '!';
                        break;
                    }
                    break;
                case 115029:
                    if (next.equals(j.f)) {
                        c = '\"';
                        break;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        c = '#';
                        break;
                    }
                    break;
                case 3317767:
                    if (next.equals(j.d)) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        c = '%';
                        break;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 94842723:
                    if (next.equals(TypedValues.Custom.S_COLOR)) {
                        c = '(';
                        break;
                    }
                    break;
                case 108511772:
                    if (next.equals(j.e)) {
                        c = ')';
                        break;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        c = '*';
                        break;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        c = '+';
                        break;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        c = StringUtil.COMMA;
                        break;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        c = SignatureImpl.SEP;
                        break;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        c = '.';
                        break;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        c = '/';
                        break;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        c = '0';
                        break;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        c = '1';
                        break;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        c = '2';
                        break;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        c = '3';
                        break;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        c = '4';
                        break;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        c = '5';
                        break;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        c = '6';
                        break;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        c = '7';
                        break;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        c = '8';
                        break;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        c = '9';
                        break;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        c = ':';
                        break;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        c = ';';
                        break;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        c = Typography.less;
                        break;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        c = a.h;
                        break;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        c = Typography.greater;
                        break;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        c = '?';
                        break;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        c = '@';
                        break;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        c = 'A';
                        break;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        c = 'B';
                        break;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        c = 'C';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    anVar.b(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    anVar.e(jSONObject.optString(next));
                    break;
                case 2:
                    anVar.he(jSONObject.optString(next));
                    break;
                case 3:
                    anVar.h(jSONObject.optString(next));
                    break;
                case 4:
                    anVar.tt(jSONObject.optInt(next));
                    break;
                case 5:
                    anVar.yo(jSONObject.optBoolean(next));
                    break;
                case 6:
                    anVar.an(jSONObject.optBoolean(next));
                    break;
                case 7:
                    anVar.uo(jSONObject.optString(next));
                    break;
                case '\b':
                    anVar.an((float) jSONObject.optDouble(next));
                    break;
                case '\t':
                    anVar.hc(jSONObject.optString(next));
                    break;
                case '\n':
                    anVar.v(jSONObject.optInt(next));
                    break;
                case 11:
                    anVar.b(jSONObject.optString(next));
                    break;
                case '\f':
                    anVar.b((float) jSONObject.optDouble(next));
                    break;
                case '\r':
                    anVar.c(jSONObject.optString(next));
                    break;
                case 14:
                    anVar.sy(jSONObject.optString(next));
                    break;
                case 15:
                    anVar.hc(jSONObject.optBoolean(next));
                    break;
                case 16:
                    anVar.tc(jSONObject.optInt(next));
                    break;
                case 17:
                    anVar.tc(jSONObject.optBoolean(next));
                    break;
                case 18:
                    anVar.d(jSONObject.optLong(next));
                    break;
                case 19:
                    anVar.de(jSONObject.optString(next));
                    break;
                case 20:
                    anVar.w(jSONObject.optInt(next));
                    break;
                case 21:
                    anVar.yi(jSONObject.optInt(next));
                    break;
                case 22:
                    anVar.tt(jSONObject.optBoolean(next));
                    break;
                case 23:
                    anVar.e(jSONObject.optInt(next));
                    break;
                case 24:
                    anVar.np(jSONObject.optInt(next));
                    break;
                case 25:
                    anVar.hc(jSONObject.optDouble(next));
                    break;
                case 26:
                    anVar.an(jSONObject.optDouble(next));
                    break;
                case 27:
                    anVar.rf(jSONObject.optInt(next));
                    break;
                case 28:
                    anVar.gb(jSONObject.optBoolean(next));
                    break;
                case 29:
                    anVar.mk(jSONObject.optInt(next));
                    break;
                case 30:
                    anVar.an(jSONObject.optString(next));
                    break;
                case 31:
                    anVar.k(jSONObject.optBoolean(next));
                    break;
                case ' ':
                    anVar.h(jSONObject.optBoolean(next));
                    break;
                case '!':
                    anVar.mk(jSONObject.optString(next));
                    break;
                case '\"':
                    anVar.de(jSONObject.optInt(next));
                    break;
                case '#':
                    anVar.jh(jSONObject.optString(next));
                    break;
                case '$':
                    anVar.jh(jSONObject.optInt(next));
                    break;
                case '%':
                    anVar.d(jSONObject.optBoolean(next));
                    break;
                case '&':
                    anVar.gb((float) jSONObject.optDouble(next));
                    break;
                case '\'':
                    anVar.rf(jSONObject.optString(next));
                    break;
                case '(':
                    anVar.u(jSONObject.optString(next));
                    break;
                case ')':
                    anVar.sy(jSONObject.optInt(next));
                    break;
                case '*':
                    anVar.c((float) jSONObject.optDouble(next));
                    break;
                case '+':
                    anVar.b(jSONObject.optDouble(next));
                    break;
                case ',':
                    anVar.u((float) jSONObject.optDouble(next));
                    break;
                case '-':
                    anVar.mk(jSONObject.optBoolean(next));
                    break;
                case '.':
                    anVar.k(jSONObject.optBoolean(next));
                    break;
                case '/':
                    anVar.tt((float) jSONObject.optDouble(next));
                    break;
                case '0':
                    anVar.yo(jSONObject.optString(next));
                    break;
                case '1':
                    anVar.j(jSONObject.optInt(next));
                    break;
                case '2':
                    anVar.h((float) jSONObject.optDouble(next));
                    break;
                case '3':
                    anVar.gb(jSONObject.optString(next));
                    break;
                case '4':
                    anVar.tt(jSONObject.optString(next));
                    break;
                case '5':
                    anVar.cb(jSONObject.optInt(next));
                    break;
                case '6':
                    anVar.u(jSONObject.optBoolean(next));
                    break;
                case '7':
                    anVar.uo(jSONObject.optInt(next));
                    break;
                case '8':
                    anVar.w(jSONObject.optString(next));
                    break;
                case '9':
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject == null) {
                        break;
                    } else {
                        anVar.h(jSONObjectOptJSONObject.optInt("translateY", 0));
                        anVar.gb(jSONObjectOptJSONObject.optInt("translateX", 0));
                        anVar.c(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        anVar.u(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                        break;
                    }
                case ':':
                    anVar.c(jSONObject.optBoolean(next));
                    break;
                case ';':
                    anVar.mq(jSONObject.optString(next));
                    break;
                case '<':
                    anVar.k(jSONObject.optString(next));
                    break;
                case '=':
                    anVar.d((float) jSONObject.optDouble(next));
                    break;
                case '>':
                    anVar.cb(jSONObject.optString(next));
                    break;
                case '?':
                    anVar.tc(jSONObject.optString(next));
                    break;
                case '@':
                    anVar.yo(jSONObject.optInt(next));
                    break;
                case 'A':
                    anVar.hc((float) jSONObject.optDouble(next));
                    break;
                case 'B':
                    anVar.mq(jSONObject.optInt(next));
                    break;
                case 'C':
                    anVar.k(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
