package com.bytedance.adsdk.ugeno.hc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.sdk.m.n.a;
import com.baidu.mobads.container.n.f;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.adsdk.ugeno.an.d;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.b.cb;
import com.bytedance.adsdk.ugeno.b.de;
import com.bytedance.adsdk.ugeno.b.h;
import com.bytedance.adsdk.ugeno.b.hc.an;
import com.bytedance.adsdk.ugeno.b.hc.c;
import com.bytedance.adsdk.ugeno.b.hc.u;
import com.bytedance.adsdk.ugeno.b.jh;
import com.bytedance.adsdk.ugeno.b.k;
import com.bytedance.adsdk.ugeno.b.tc;
import com.bytedance.adsdk.ugeno.b.tt;
import com.bytedance.adsdk.ugeno.b.uo;
import com.bytedance.adsdk.ugeno.b.w;
import com.bytedance.adsdk.ugeno.b.yo;
import com.bytedance.adsdk.ugeno.d;
import com.bytedance.adsdk.ugeno.hc.d;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.n;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b<T extends View> implements View.OnTouchListener, com.bytedance.adsdk.ugeno.b, yo.d, yo.hc {
    private boolean ai;
    protected d<ViewGroup> an;
    protected float ar;
    protected JSONObject b;
    protected boolean ba;
    protected ImageView.ScaleType bc;
    private com.bytedance.adsdk.ugeno.u.d.d bd;
    protected JSONObject c;
    protected float cb;
    private com.bytedance.adsdk.ugeno.b.d cj;
    private boolean cw;
    private boolean d;
    protected float dc;
    protected boolean de;
    protected float dz;
    protected float e;
    private GradientDrawable ec;

    @Deprecated
    private com.bytedance.adsdk.ugeno.b.hc.hc ed;

    @Deprecated
    private u el;
    private String eu;
    protected com.bytedance.adsdk.ugeno.d.d ey;
    protected d.C0171d f;
    protected boolean fs;
    protected boolean fu;
    protected float fv;
    protected float fy;
    protected tt.d gb;
    private boolean gu;
    protected float gv;
    protected float gw;
    protected d<ViewGroup> h;
    protected Context hc;
    protected float he;
    private boolean hg;
    private boolean ho;
    private boolean hr;
    protected String hv;
    protected ViewGroup.LayoutParams i;
    protected String ia;
    private boolean ic;
    protected float j;
    protected float jh;
    private String jm;
    protected jh js;
    protected float k;
    protected yo kb;
    protected boolean l;

    @Deprecated
    private an lv;
    private float m;
    protected Map<Integer, cb> mb;
    private boolean mg;
    protected String mk;
    protected String mq;
    protected boolean mt;
    private long n;
    protected float nf;

    @Deprecated
    private c.d nk;
    protected boolean np;
    protected boolean nr;
    protected boolean nv;
    protected int nw;
    protected boolean o;
    protected com.bytedance.adsdk.ugeno.u.tt oc;
    private uo om;
    private boolean ox;
    private boolean p;
    private boolean pa;
    protected float ph;
    protected tc pq;
    protected float q;
    protected com.bytedance.adsdk.ugeno.d.an qr;
    private boolean qv;
    protected float qy;
    protected int r;
    protected float ra;
    protected float rf;
    private boolean rs;
    protected float ru;
    protected int rw;
    protected float s;
    protected float sy;
    protected float t;
    protected boolean tc;
    private boolean tj;
    protected boolean to;
    protected boolean tr;
    protected k tt;
    protected T u;
    protected float um;
    protected float uo;
    private boolean uq;
    protected boolean us;
    protected boolean v;
    private boolean vg;
    protected float vv;
    protected float w;
    protected h wb;
    protected float wl;
    private boolean wz;
    private boolean xi;
    private boolean xn;
    protected boolean xp;
    protected float y;
    private de yb;
    protected boolean yi;
    protected float yn;
    protected float yo;
    private JSONObject yw;
    protected boolean z;

    @Deprecated
    private com.bytedance.adsdk.ugeno.b.hc.b zk;
    protected float zv;
    protected float zw;

    public T d() {
        return null;
    }

    protected void dc() {
    }

    protected void tr() {
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, d<ViewGroup> dVar) {
        this.uo = -2.0f;
        this.k = -2.0f;
        this.ia = "solid";
        this.nw = 0;
        this.nr = true;
        this.ar = 0.0f;
        this.t = 0.0f;
        this.ph = 0.0f;
        this.gv = 1.0f;
        this.qy = 1.0f;
        this.nf = 1.0f;
        this.gw = 0.0f;
        this.fy = 0.0f;
        this.zv = 0.0f;
        this.um = 0.0f;
        this.fv = 1.0f;
        this.ho = true;
        this.xn = true;
        this.wz = false;
        this.vg = false;
        this.uq = false;
        this.m = 12.0f;
        this.hc = context;
        this.an = dVar;
        this.mb = new HashMap();
        this.ec = new GradientDrawable();
        this.u = (T) d();
    }

    public T tt() {
        return this.u;
    }

    public void hc(JSONObject jSONObject) {
        this.c = jSONObject;
        mk();
    }

    public void d(JSONObject jSONObject) throws JSONException {
        this.c = jSONObject;
        mk();
        JSONObject jSONObject2 = this.b;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        d<ViewGroup> dVar = this.an;
        d.C0176d c0176dGb = dVar instanceof d ? dVar.gb() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strD = com.bytedance.adsdk.ugeno.c.hc.d(this.b.optString(next), jSONObject);
            d(next, strD);
            if (c0176dGb != null) {
                c0176dGb.d(this.hc, next, strD);
            }
        }
        if (c0176dGb != null) {
            d(c0176dGb.d());
        }
        if (this.yw == null || this.c == null) {
            return;
        }
        try {
            if (j()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i18n", this.yw);
                this.c.put("xNode", jSONObject3);
                return;
            }
            this.c.put("i18n", this.yw);
        } catch (JSONException e) {
            mq.d(e);
        }
    }

    public JSONObject tc() {
        return this.c;
    }

    public void mk() {
        this.uq = this.c.optBoolean("gesture_through_enable", false);
    }

    public void hc() throws JSONException {
        yi();
        mq();
        hc(this.nw);
        h();
        gb();
        com.bytedance.adsdk.ugeno.u.tt ttVar = this.oc;
        if (ttVar != null) {
            ttVar.d();
            this.oc.hc();
            this.oc.b();
        }
        this.u.setOnTouchListener(this);
        to();
        ViewGroup viewGroup = (ViewGroup) this.u.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.ho);
        }
        com.bytedance.adsdk.ugeno.d.d dVar = this.ey;
        if (dVar != null) {
            dVar.c();
        }
        com.bytedance.adsdk.ugeno.d.an anVar = this.qr;
        if (anVar != null) {
            anVar.d();
        }
        com.bytedance.adsdk.ugeno.u.tt ttVar2 = this.oc;
        if (ttVar2 != null) {
            ttVar2.c();
        }
        if (this.kb == null || !d(22)) {
            return;
        }
        this.kb.d(this.mb.get(22), this, this);
    }

    protected void mq() {
        this.u.setPadding((int) (this.z ? this.vv : this.he), (int) (this.ba ? this.j : this.he), (int) (this.fs ? this.zw : this.he), (int) (this.mt ? this.s : this.he));
    }

    private void h() {
        if (this.d) {
            this.u.setTranslationX(this.t);
        }
        if (this.rs) {
            this.u.setTranslationY(this.ph);
        }
        if (this.tj) {
            this.u.setScaleX(this.qy);
        }
        if (this.ox) {
            this.u.setScaleY(this.nf);
        }
        if (this.p) {
            this.u.setRotation(this.gw);
        }
        if (this.hr) {
            this.u.setRotationX(this.fy);
        }
        if (this.hg) {
            this.u.setRotationY(-this.zv);
        }
        if (this.gu) {
            this.u.setAlpha(this.fv);
        }
        float f = this.um;
        if (f != 0.0f) {
            this.u.setRotation(f);
        }
        if (this.p || this.hr || this.hg) {
            this.u.setCameraDistance(10000.0f);
        }
    }

    public float uo() {
        return this.t;
    }

    public float k() {
        return this.ph;
    }

    public float e() {
        return this.qy;
    }

    public float cb() {
        return this.nf;
    }

    public float w() {
        return this.fy;
    }

    public float yo() {
        return this.zv;
    }

    public float rf() {
        return this.um;
    }

    public float jh() {
        return this.fv;
    }

    public float sy() {
        return this.y;
    }

    @Deprecated
    private void gb() throws JSONException {
        c cVarC;
        this.u.setVisibility(this.nw);
        float f = this.um;
        if (f != 0.0f) {
            this.u.setRotation(f);
        }
        tt.d dVar = this.gb;
        if (dVar != null && TextUtils.isEmpty(dVar.hc())) {
            this.u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.hc.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.pq == null || !b.this.xn) {
                        return;
                    }
                    b.this.pq.d(b.this);
                }
            });
        } else if (d(1) && !this.qv) {
            this.u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.hc.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.kb == null || !b.this.xn) {
                        return;
                    }
                    yo yoVar = b.this.kb;
                    cb cbVar = b.this.mb.get(1);
                    b bVar = b.this;
                    yoVar.d(cbVar, bVar, bVar);
                }
            });
        }
        if (this.kb != null && d(4)) {
            if (d(1)) {
                this.xi = true;
                this.el = new u(this.hc, this.mb.get(4), this.mb.get(1), this.xi, fu());
            } else {
                this.el = new u(this.hc, this.mb.get(4), this.xi, fu());
            }
        }
        if (this.kb != null && d(1) && this.qv) {
            this.zk = new com.bytedance.adsdk.ugeno.b.hc.b(this.hc, this.mb.get(1));
        }
        xp();
        if (this.kb != null && d(3) && (cVarC = com.bytedance.adsdk.ugeno.c.d().c()) != null) {
            c.d dVar2 = this.nk;
            if (dVar2 != null) {
                dVar2.hc();
            }
            c.d dVarD = cVarC.d(this.hc, this);
            this.nk = dVarD;
            dVarD.d(this.m);
            this.nk.d();
            this.nk.d(new c.hc() { // from class: com.bytedance.adsdk.ugeno.hc.b.3
                @Override // com.bytedance.adsdk.ugeno.b.hc.c.hc
                public void d(int i) {
                    b.this.nk.hc();
                    if (b.this.u.isShown() && b.this.kb != null && i == 1) {
                        yo yoVar = b.this.kb;
                        cb cbVar = b.this.mb.get(3);
                        b bVar = b.this;
                        yoVar.d(cbVar, bVar, bVar);
                    }
                }
            });
        }
        if (this.kb != null && d(9)) {
            an anVar = new an(this.hc, this.mb.get(9), this);
            this.lv = anVar;
            anVar.d(this.kb);
        }
        if (d(10)) {
            com.bytedance.adsdk.ugeno.b.hc.hc hcVar = new com.bytedance.adsdk.ugeno.b.hc.hc(this.hc, this.mb.get(10), this);
            this.ed = hcVar;
            hcVar.d(this.kb);
        }
    }

    private void xp() throws JSONException {
        cb cbVar;
        if (this.kb == null || !d(18) || (cbVar = this.mb.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectB = cbVar.b();
        if (jSONObjectB != null) {
            try {
                jSONObjectB.put("rotateZ", com.bytedance.adsdk.ugeno.c.hc.d(jSONObjectB.optString("rotateZ"), this.c));
            } catch (JSONException unused) {
            }
        }
        this.kb.d(cbVar, this, this);
    }

    private void to() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mk);
        this.u.setContentDescription(sb);
    }

    public void d(de deVar) {
        this.yb = deVar;
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void u() {
        if (this.cj != null) {
            uo uoVar = new uo(this.u, this.cj);
            this.om = uoVar;
            uoVar.d();
        }
        com.bytedance.adsdk.ugeno.d.d dVar = this.ey;
        if (dVar != null) {
            dVar.d();
        }
        com.bytedance.adsdk.ugeno.d.an anVar = this.qr;
        if (anVar != null) {
            anVar.hc();
        }
        de deVar = this.yb;
        if (deVar != null) {
            deVar.c();
        }
        com.bytedance.adsdk.ugeno.u.tt ttVar = this.oc;
        if (ttVar != null) {
            ttVar.u();
        }
        if (this.ed != null && d(10)) {
            this.ed.d();
        }
        if (this.lv != null && d(9)) {
            this.lv.d();
        }
        u uVar = this.el;
        if (uVar != null) {
            uVar.d();
        }
        this.n = System.currentTimeMillis();
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void an() {
        uo uoVar = this.om;
        if (uoVar != null) {
            uoVar.hc();
        }
        com.bytedance.adsdk.ugeno.d.d dVar = this.ey;
        if (dVar != null) {
            dVar.b();
        }
        com.bytedance.adsdk.ugeno.d.an anVar = this.qr;
        if (anVar != null) {
            anVar.b();
        }
        de deVar = this.yb;
        if (deVar != null) {
            deVar.u();
        }
        c.d dVar2 = this.nk;
        if (dVar2 != null) {
            dVar2.hc();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void d(boolean z) {
        de deVar = this.yb;
        if (deVar != null) {
            deVar.d(z);
        }
    }

    public yo de() {
        return this.kb;
    }

    public long v() {
        return this.n;
    }

    public void hc(boolean z) {
        this.qv = z;
    }

    public boolean d(int i) {
        Map<Integer, cb> map = this.mb;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void hc(int i) {
        ViewParent viewParent = (ViewGroup) this.u.getParent();
        if (viewParent instanceof hc) {
            ((hc) viewParent).b(this.u, i);
        } else {
            this.u.setVisibility(i);
        }
    }

    public void d(jh jhVar) {
        this.js = jhVar;
    }

    public void d(yo yoVar) {
        this.kb = yoVar;
    }

    public void b(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public JSONObject np() {
        return this.b;
    }

    protected void yi() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapD;
        if (TextUtils.isEmpty(this.hv)) {
            if (this.o) {
                d(this.f);
                return;
            } else {
                this.ec.setColor(this.r);
                b(this.r);
                return;
            }
        }
        if (this.hv.startsWith("local://")) {
            String strReplace = this.hv.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.tr ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.hc.getResources().openRawResource(com.bytedance.adsdk.ugeno.an.c.hc(this.hc, strReplace)), null, options);
                if (this.tr && (bitmapD = gb.d(this.hc, bitmapDecodeStream, (int) this.dc)) != null) {
                    bitmapDrawable = new BitmapDrawable(this.hc.getResources(), bitmapD);
                    d(bitmapDrawable);
                    return;
                } else {
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.hc.getResources(), bitmapDecodeStream);
                    bitmapDrawable = bitmapDrawable2;
                    d(bitmapDrawable);
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        he();
    }

    protected void he() {
        h hVar = this.wb;
        if (hVar != null) {
            hVar.d();
        }
        com.bytedance.adsdk.ugeno.c.d().hc().d(this.tt, this.hv, new d.InterfaceC0174d() { // from class: com.bytedance.adsdk.ugeno.hc.b.4
            @Override // com.bytedance.adsdk.ugeno.d.InterfaceC0174d
            public void d(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (b.this.wb != null) {
                        h hVar2 = b.this.wb;
                        b bVar = b.this;
                        hVar2.hc(bVar, bVar.hv);
                        return;
                    }
                    return;
                }
                if (b.this.wb != null) {
                    h hVar3 = b.this.wb;
                    b bVar2 = b.this;
                    hVar3.d(bVar2, bVar2.hv);
                }
                if (b.this.tr) {
                    final Bitmap bitmapD = gb.d(b.this.hc, bitmap, (int) b.this.dc);
                    if (bitmapD != null) {
                        gb.d(new Runnable() { // from class: com.bytedance.adsdk.ugeno.hc.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.d(new BitmapDrawable(bitmapD));
                            }
                        });
                        return;
                    }
                    return;
                }
                gb.d(new Runnable() { // from class: com.bytedance.adsdk.ugeno.hc.b.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.d(new BitmapDrawable(bitmap));
                    }
                });
            }
        });
    }

    protected void d(d.C0171d c0171d) {
        if (c0171d == null) {
            return;
        }
        this.ec.setShape(0);
        if (c0171d != null) {
            this.ec.setOrientation(c0171d.d);
            if (Build.VERSION.SDK_INT >= 29) {
                this.ec.setColors(c0171d.hc, c0171d.b);
            } else {
                this.ec.setColors(c0171d.hc);
            }
        }
        rw();
        ra();
        this.u.setBackground(this.ec);
    }

    protected void b(int i) {
        this.ec.setShape(0);
        this.ec.setColor(i);
        rw();
        ra();
        this.u.setBackground(this.ec);
    }

    private void ra() {
        if (TextUtils.equals("dashed", this.ia)) {
            GradientDrawable gradientDrawable = this.ec;
            float f = this.ra;
            gradientDrawable.setStroke((int) f, this.rw, 3.0f * f, f);
        } else {
            if (TextUtils.equals("dotted", this.ia)) {
                GradientDrawable gradientDrawable2 = this.ec;
                float f2 = this.ra;
                gradientDrawable2.setStroke((int) f2, this.rw, f2 / 2.0f, f2);
                return;
            }
            this.ec.setStroke((int) this.ra, this.rw);
        }
    }

    private void rw() {
        float f = this.l ? this.wl : this.y;
        float f2 = this.fu ? this.ru : this.y;
        float f3 = this.xp ? this.q : this.y;
        float f4 = this.to ? this.yn : this.y;
        this.ec.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
    }

    protected void d(Drawable drawable) {
        this.u.setBackground(drawable);
    }

    public void d(ViewGroup.LayoutParams layoutParams) {
        T t = this.u;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.i = layoutParams;
    }

    public ViewGroup.LayoutParams vv() {
        return this.i;
    }

    public void d(boolean z, boolean z2) {
        if (this.u != null) {
            d(this.i);
            if (z) {
                c((int) this.uo);
            }
            if (z2) {
                u((int) this.k);
            }
        }
    }

    public void d(tt.d dVar) {
        this.gb = dVar;
    }

    public tt.d zw() {
        return this.gb;
    }

    public b<T> c(String str) {
        return d(str);
    }

    protected b<T> d(String str) {
        if (TextUtils.isEmpty(this.mk) || !TextUtils.equals(this.mk, str)) {
            return null;
        }
        return this;
    }

    public b<T> u(String str) {
        return hc(str);
    }

    protected b<T> hc(String str) {
        if (TextUtils.isEmpty(this.mq) || !TextUtils.equals(this.mq, str)) {
            return null;
        }
        return this;
    }

    public b<T> an(String str) {
        return b(str);
    }

    protected b<T> b(String str) {
        if (tc(str) != null) {
            return this;
        }
        return null;
    }

    public void b(boolean z) {
        this.tc = z;
    }

    public boolean j() {
        return this.tc;
    }

    public d s() {
        return this.an;
    }

    public void d(d dVar) {
        this.an = dVar;
    }

    public void h(String str) {
        this.mk = str;
    }

    public String us() {
        return this.mk;
    }

    public void gb(String str) {
        this.mq = str;
    }

    public String z() {
        return this.mq;
    }

    public int fs() {
        return (int) this.uo;
    }

    public int ba() {
        return (int) this.k;
    }

    public k mt() {
        return this.tt;
    }

    public void d(k kVar) {
        this.tt = kVar;
    }

    public boolean r() {
        return this.nr;
    }

    public void d(tc tcVar) {
        this.pq = tcVar;
    }

    public int hv() {
        return this.r;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    c = 0;
                    break;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    c = 1;
                    break;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    c = 2;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    c = 3;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c = 4;
                    break;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    c = 5;
                    break;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    c = 6;
                    break;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    c = 7;
                    break;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    c = '\b';
                    break;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    c = '\t';
                    break;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    c = '\n';
                    break;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    c = 11;
                    break;
                }
                break;
            case -1291329255:
                if (str.equals("events")) {
                    c = '\f';
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    c = 14;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 15;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    c = 16;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c = 17;
                    break;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    c = 18;
                    break;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    c = 19;
                    break;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    c = 20;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 21;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 22;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c = 23;
                    break;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    c = 24;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c = 25;
                    break;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    c = JSONLexer.EOI;
                    break;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    c = 27;
                    break;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    c = 28;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 29;
                    break;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    c = 30;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = 31;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c = ' ';
                    break;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    c = '!';
                    break;
                }
                break;
            case 108285963:
                if (str.equals(n.C)) {
                    c = '\"';
                    break;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    c = '#';
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = Typography.dollar;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '%';
                    break;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    c = '\'';
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    c = '(';
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    c = ')';
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    c = '*';
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    c = '+';
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = StringUtil.COMMA;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c = SignatureImpl.SEP;
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    c = '.';
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    c = '/';
                    break;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    c = '0';
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c = '1';
                    break;
                }
                break;
            case 1052832078:
                if (str.equals(j.a)) {
                    c = '2';
                    break;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    c = '3';
                    break;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    c = '4';
                    break;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    c = '5';
                    break;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    c = '6';
                    break;
                }
                break;
            case 1287124693:
                if (str.equals(f.T)) {
                    c = '7';
                    break;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    c = '8';
                    break;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    c = '9';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c = ':';
                    break;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    c = ';';
                    break;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    c = Typography.less;
                    break;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    c = a.h;
                    break;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    c = Typography.greater;
                    break;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    c = '?';
                    break;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    c = '@';
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 'A';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c = 'B';
                    break;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    c = 'C';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.xn = com.bytedance.adsdk.ugeno.an.b.d(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 18:
            case '!':
            case '\'':
            case '0':
            case '3':
            case '6':
            case '>':
            case '@':
                hc(str, str2);
                break;
            case 2:
                this.d = true;
                this.t = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
            case 3:
                this.rs = true;
                this.ph = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
            case 4:
                this.vv = gb.d(this.hc, str2);
                this.z = true;
                break;
            case 5:
                this.jh = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 11:
            case '7':
                if (com.bytedance.adsdk.ugeno.an.d.b(str2)) {
                    this.o = true;
                    this.f = com.bytedance.adsdk.ugeno.an.d.hc(str2);
                    break;
                } else {
                    this.r = com.bytedance.adsdk.ugeno.an.d.d(str2, 0);
                    this.o = false;
                    break;
                }
            case '\f':
                this.oc = com.bytedance.adsdk.ugeno.u.tt.d(this, str2);
                break;
            case '\r':
                this.gu = true;
                this.fv = com.bytedance.adsdk.ugeno.an.b.d(str2, 1.0f);
                break;
            case 14:
                this.wl = gb.d(this.hc, str2);
                this.l = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.k = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.k = -2.0f;
                } else {
                    this.k = gb.d(this.hc, str2);
                }
                this.vg = true;
                break;
            case 16:
                this.e = gb.d(this.hc, str2);
                break;
            case 17:
                this.yo = gb.d(this.hc, str2);
                this.np = true;
                break;
            case 19:
            case '8':
                this.hv = str2;
                break;
            case 20:
                this.p = true;
                this.gw = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 21:
                this.tj = true;
                this.qy = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 22:
                this.ox = true;
                this.nf = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 23:
                this.he = gb.d(this.hc, str2);
                this.us = true;
                break;
            case 24:
                this.eu = str2;
                break;
            case 25:
                this.rf = gb.d(this.hc, str2);
                this.yi = true;
                break;
            case 26:
                this.sy = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 27:
                this.mk = str2;
                break;
            case 28:
                this.yw = com.bytedance.adsdk.ugeno.an.hc.d(str2, (JSONObject) null);
                break;
            case 29:
                this.mq = str2;
                break;
            case 30:
                float fD = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                this.dc = fD;
                if (fD > 0.0f) {
                    this.tr = true;
                    break;
                }
                break;
            case 31:
                this.j = gb.d(this.hc, str2);
                this.ba = true;
                break;
            case ' ':
                this.jm = str2;
                break;
            case '\"':
                this.dz = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case '#':
                this.tj = true;
                this.ox = true;
                float[] fArrB = com.bytedance.adsdk.ugeno.d.c.b(str2);
                this.qy = fArrB[0];
                this.nf = fArrB[1];
                break;
            case '$':
                if (TextUtils.equals(str2, "match_parent")) {
                    this.uo = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.uo = -2.0f;
                } else {
                    this.uo = gb.d(this.hc, str2);
                }
                this.wz = true;
                break;
            case '%':
                this.s = gb.d(this.hc, str2);
                this.mt = true;
                break;
            case '&':
                List<com.bytedance.adsdk.ugeno.d.b> listD = com.bytedance.adsdk.ugeno.d.c.d(str2, this.c);
                if (listD != null && !listD.isEmpty()) {
                    this.qr = new com.bytedance.adsdk.ugeno.d.an(this.hc, this, listD);
                    break;
                }
                break;
            case '(':
                this.ru = gb.d(this.hc, str2);
                this.fu = true;
                break;
            case ')':
                this.ho = mq(str2);
                break;
            case '*':
                this.q = gb.d(this.hc, str2);
                this.xp = true;
                break;
            case '+':
                this.yn = gb.d(this.hc, str2);
                this.to = true;
                break;
            case ',':
                this.zw = gb.d(this.hc, str2);
                this.fs = true;
                break;
            case '-':
                this.rw = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case '.':
                this.ia = str2;
                break;
            case '/':
                this.ra = gb.d(this.hc, str2);
                break;
            case '1':
                this.w = gb.d(this.hc, str2);
                this.v = true;
                break;
            case '2':
                this.d = true;
                this.rs = true;
                float[] fArrB2 = com.bytedance.adsdk.ugeno.d.c.b(str2);
                this.t = gb.d(this.hc, fArrB2[0]);
                this.ph = gb.d(this.hc, fArrB2[1]);
                break;
            case '4':
                try {
                    this.ey = new com.bytedance.adsdk.ugeno.d.d(this.hc, this, com.bytedance.adsdk.ugeno.d.c.d(new JSONObject(str2), this.c));
                    break;
                } catch (JSONException e) {
                    mq.d(e);
                    return;
                }
            case '5':
                this.cj = com.bytedance.adsdk.ugeno.b.d.d(str2, this);
                break;
            case '9':
                this.nv = true;
                this.bc = mk(str2);
                break;
            case ':':
                this.y = gb.d(this.hc, str2);
                break;
            case ';':
                this.hr = true;
                this.fy = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case '<':
                this.hg = true;
                this.zv = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case '=':
                this.um = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case '?':
                this.ic = com.bytedance.adsdk.ugeno.an.b.d(str2, false);
                break;
            case 'A':
                if (TextUtils.equals("visible", str2)) {
                    this.nw = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.nw = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.nw = 8;
                }
                this.u.setVisibility(this.nw);
                break;
            case 'B':
                this.cb = gb.d(this.hc, str2);
                this.de = true;
                break;
            case 'C':
                this.nr = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    private ImageView.ScaleType mk(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.bc = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.bc = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.bc = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.bc = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.bc;
    }

    private boolean mq(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    protected void hc(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.mb == null) {
            return;
        }
        try {
            int type = w.d(str).getType();
            cb cbVar = new cb();
            cbVar.d(type);
            cbVar.d(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.m = Float.parseFloat(com.bytedance.adsdk.ugeno.c.hc.d(jSONObject.optString("shakeAmplitude"), this.c));
                } catch (NumberFormatException unused) {
                    this.m = 12.0f;
                }
            }
            yo yoVar = this.kb;
            if (!(yoVar instanceof com.bytedance.adsdk.ugeno.b.d.hc)) {
                d(type, jSONObject, cbVar);
            } else if (!((com.bytedance.adsdk.ugeno.b.d.hc) yoVar).d()) {
                d(type, jSONObject, cbVar);
            } else {
                cbVar.d(jSONObject);
                this.mb.put(Integer.valueOf(type), cbVar);
            }
        } catch (JSONException unused2) {
        }
    }

    @Deprecated
    protected void d(int i, JSONObject jSONObject, cb cbVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            cb cbVar2 = new cb();
            cbVar2.d(jSONObjectOptJSONObject);
            cbVar2.d(this);
            cbVar.d(cbVar2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
        if (jSONObjectOptJSONObject2 != null) {
            cb cbVar3 = new cb();
            cbVar3.d(jSONObjectOptJSONObject2);
            cbVar3.d(this);
            cbVar.hc(cbVar3);
        }
        cbVar.d(jSONObject);
        this.mb.put(Integer.valueOf(i), cbVar);
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void b() {
        if (this.yb == null || this.ai) {
            return;
        }
        this.ai = true;
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void c() {
        if (this.yb == null || this.pa) {
            return;
        }
        this.pa = true;
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public int[] d(int i, int i2) {
        if (this.dz > 0.0f) {
            if (this.wz) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.dz;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.vg) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.dz;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.yb != null && !this.mg) {
            this.mg = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void d(int i, int i2, int i3, int i4) {
        if (this.yb == null || this.cw) {
            return;
        }
        this.cw = true;
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void d(Canvas canvas, com.bytedance.adsdk.ugeno.b.u uVar) {
        uo uoVar = this.om;
        if (uoVar != null) {
            uoVar.d(canvas, uVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void d(Canvas canvas) {
        com.bytedance.adsdk.ugeno.d.d dVar = this.ey;
        if (dVar != null) {
            dVar.d(canvas);
        }
        com.bytedance.adsdk.ugeno.d.an anVar = this.qr;
        if (anVar != null) {
            anVar.d(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b
    public void hc(int i, int i2, int i3, int i4) {
        uo uoVar = this.om;
        if (uoVar != null) {
            uoVar.d(i, i2);
        }
        com.bytedance.adsdk.ugeno.d.d dVar = this.ey;
        if (dVar != null) {
            dVar.d(i, i2);
        }
        com.bytedance.adsdk.ugeno.d.an anVar = this.qr;
        if (anVar != null) {
            anVar.d(i, i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b.yo.hc
    public void d(cb cbVar) {
        d<ViewGroup> dVar;
        b<T> bVarC;
        if (cbVar == null || cbVar.b() == null) {
            return;
        }
        c.d dVar2 = this.nk;
        if (dVar2 != null) {
            dVar2.hc();
        }
        if (TextUtils.equals(cbVar.b().optString("type"), "onDismiss")) {
            String strOptString = cbVar.b().optString("nodeId");
            hc(8);
            this.h = (d) hc(this);
            if (TextUtils.isEmpty(strOptString) || (dVar = this.h) == null || (bVarC = dVar.c(strOptString)) == null) {
                return;
            }
            bVarC.hc(8);
        }
    }

    public void d(com.bytedance.adsdk.ugeno.u.d.d dVar) {
        this.bd = dVar;
    }

    public com.bytedance.adsdk.ugeno.u.d.d bc() {
        return this.bd;
    }

    public b hc(b bVar) {
        return (bVar.s() == null && (bVar instanceof d)) ? bVar : hc(bVar.s());
    }

    public void nv() {
        u uVar = this.el;
        if (uVar != null) {
            uVar.hc();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        u uVar;
        yo yoVar;
        com.bytedance.adsdk.ugeno.b.hc.b bVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            dc();
        } else if (action == 1 || action == 3) {
            tr();
        }
        jh jhVar = this.js;
        if (jhVar != null) {
            jhVar.d(this, motionEvent);
        }
        if (d(17) && motionEvent.getAction() == 0) {
            this.kb.d(this.mb.get(17), this, this);
        }
        if (d(1) && this.qv && (yoVar = this.kb) != null && (bVar = this.zk) != null) {
            return bVar.d(yoVar, this, motionEvent);
        }
        yo yoVar2 = this.kb;
        if (yoVar2 != null && (uVar = this.el) != null) {
            return uVar.d(yoVar2, this, motionEvent, fu());
        }
        com.bytedance.adsdk.ugeno.u.tt ttVar = this.oc;
        if (ttVar != null) {
            return ttVar.d(motionEvent);
        }
        return false;
    }

    public boolean y() {
        return this.dz > 0.0f;
    }

    public float wl() {
        T t = this.u;
        if (t instanceof com.bytedance.adsdk.ugeno.d.h) {
            return ((com.bytedance.adsdk.ugeno.d.h) t).getRipple();
        }
        return 0.0f;
    }

    public float q() {
        T t = this.u;
        if (t instanceof com.bytedance.adsdk.ugeno.d.h) {
            return ((com.bytedance.adsdk.ugeno.d.h) t).getShine();
        }
        return 0.0f;
    }

    public float ru() {
        T t = this.u;
        if (t instanceof com.bytedance.adsdk.ugeno.d.h) {
            return ((com.bytedance.adsdk.ugeno.d.h) t).getStretch();
        }
        return 0.0f;
    }

    public float yn() {
        T t = this.u;
        if (t instanceof com.bytedance.adsdk.ugeno.d.h) {
            return ((com.bytedance.adsdk.ugeno.d.h) t).getRubIn();
        }
        return 0.0f;
    }

    public void c(int i) {
        if (j()) {
            T t = this.u;
            if (t instanceof hc) {
                ((hc) t).d(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof hc) {
                ((hc) viewParent).d(this.u, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        layoutParams.width = i;
        this.u.setLayoutParams(layoutParams);
    }

    public void u(int i) {
        if (j()) {
            T t = this.u;
            if (t instanceof hc) {
                ((hc) t).hc(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof hc) {
                ((hc) viewParent).hc(this.u, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        layoutParams.height = i;
        this.u.setLayoutParams(layoutParams);
    }

    public boolean l() {
        return this.ic;
    }

    public List<com.bytedance.adsdk.ugeno.u.b.hc> tt(String str) {
        com.bytedance.adsdk.ugeno.u.tt ttVar;
        if (TextUtils.isEmpty(str) || (ttVar = this.oc) == null) {
            return null;
        }
        return ttVar.d(str);
    }

    public void d(String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.u.b.hc> listTt = tt(str);
        if (listTt == null || listTt.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.u.b.hc hcVar : listTt) {
            hcVar.d(this.oc);
            hcVar.d(objArr);
        }
    }

    public void d(com.bytedance.adsdk.ugeno.b.an anVar) {
        com.bytedance.adsdk.ugeno.u.tt ttVar = this.oc;
        if (ttVar != null) {
            ttVar.d(anVar);
        }
    }

    public com.bytedance.adsdk.ugeno.d.d tc(String str) {
        com.bytedance.adsdk.ugeno.d.d dVar = this.ey;
        if (dVar != null && TextUtils.equals(str, dVar.u())) {
            return this.ey;
        }
        com.bytedance.adsdk.ugeno.d.an anVar = this.qr;
        if (anVar != null) {
            return anVar.d(str);
        }
        return null;
    }

    public void d(h hVar) {
        this.wb = hVar;
    }

    public boolean fu() {
        return this.uq;
    }
}
