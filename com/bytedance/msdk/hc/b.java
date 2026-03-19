package com.bytedance.msdk.hc;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.api.c.d.h.gb;
import com.bytedance.msdk.api.c.d.h.tc;
import com.bytedance.msdk.api.c.d.h.tt;
import com.bytedance.msdk.api.c.d.h.u;
import com.bytedance.msdk.d.hc.an;
import com.bytedance.msdk.gb.sy;
import com.bytedance.sdk.openadsdk.core.ba.c;
import com.bytedance.sdk.openadsdk.w.b.hc.h;
import com.bytedance.sdk.openadsdk.w.b.hc.mq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b extends c implements Comparable<b> {
    protected com.bytedance.msdk.api.c.d.b.d an;
    private int ar;
    protected com.bytedance.msdk.api.c.d.hc b;
    private String ba;
    private double bc;
    protected com.bytedance.msdk.api.c.d.c c;
    private int cb;
    protected com.bytedance.msdk.api.c.d.h.hc d;
    private int dc;
    private double de;
    private int e;
    private com.bytedance.sdk.openadsdk.jh.d.hc.d.d ec;
    private volatile boolean f;
    private String fs;
    private String fu;
    private String fv;
    private int fy;
    protected an gb;
    private String gu;
    private String gv;
    private int gw;
    protected an h;
    protected gb hc;
    private boolean he;
    private String hg;
    private d ho;
    private String hr;
    private double hv;
    private String j;
    private String js;
    private int k;
    private String l;
    private String mb;
    private String mk;
    private String mq;
    private Map<String, String> mt;
    private String nf;
    private boolean o;
    private volatile boolean oc;
    private String ox;
    private int ph;
    private int pq;
    private String q;
    private boolean qy;
    private Map<String, Object> r;
    private boolean ra;
    private double rf;
    private long rs;
    private int ru;
    private int rw;
    private String s;
    private String sy;
    private int t;
    private String tc;
    private String tj;
    private String to;
    private String tt;
    protected tt u;
    private String um;
    private int uo;
    private long us;
    private int v;
    private String vv;
    private String w;
    private String wb;
    private String xp;
    private int yi;
    private int yn;
    private String yo;
    private String z;
    private int zv;
    private boolean zw;
    private List<String> jh = new ArrayList();
    private int np = -1;
    private int tr = 1;
    private int nv = 1;
    private int y = 1;
    private int wl = 1;
    private volatile boolean ia = false;
    private volatile boolean nw = false;
    private volatile boolean dz = false;
    private volatile boolean nr = false;
    private final Map<String, Object> i = new sy();
    private boolean ey = false;
    private boolean qr = false;
    private String kb = "1";
    private Map<String, Object> p = new HashMap();
    private Map<String, Object> ic = new ConcurrentHashMap();

    public interface d {
        void d();

        void d(b bVar);
    }

    public String ai() {
        return null;
    }

    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public void b() {
    }

    public double bd() {
        return 0.0d;
    }

    public int c() {
        return -1;
    }

    public void cb() {
    }

    public boolean cw() {
        return false;
    }

    public h d(Activity activity) {
        return null;
    }

    public void d() {
    }

    public void d(Activity activity, Object obj, String str) {
    }

    public void d(Dialog dialog, Integer[] numArr) {
    }

    public void d(Bitmap bitmap, int i) {
    }

    public void d(ViewGroup viewGroup) {
    }

    public void d(ViewGroup viewGroup, Activity activity) {
    }

    public void d(com.bytedance.sdk.openadsdk.de.d.hc.d.d dVar) {
    }

    public void d(com.bytedance.sdk.openadsdk.he.d.hc.d.b bVar) {
    }

    public void d(com.bytedance.sdk.openadsdk.w.b.d.b bVar) {
    }

    public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
    }

    public void d(Object obj) {
    }

    public void d(Map<String, Object> map) {
    }

    public int dr() {
        return 0;
    }

    public u gb() {
        return null;
    }

    public String h() {
        return null;
    }

    public h hc(Dialog dialog, Integer[] numArr) {
        return null;
    }

    public void hc() {
    }

    public void hc(Activity activity) {
    }

    public void hc(Map<String, Object> map) {
    }

    public boolean jh() {
        return false;
    }

    public void m() {
    }

    public void mk() {
    }

    public void mt(String str) {
    }

    public mq n() {
        return null;
    }

    public View tc() {
        return null;
    }

    public void tc(boolean z) {
    }

    public boolean tr() {
        return false;
    }

    public View tt() {
        return null;
    }

    public abstract boolean u();

    public Bitmap uq() {
        return null;
    }

    public void v(int i) {
    }

    public com.bytedance.sdk.openadsdk.w.b.hc.c vg() {
        return null;
    }

    public com.bytedance.sdk.openadsdk.w.b.hc.u vs() {
        return null;
    }

    public void w() {
    }

    public long xi() {
        return 0L;
    }

    public long yb() {
        return 0L;
    }

    public void d(String str) {
        this.nf = str;
    }

    public String sy() {
        return this.nf;
    }

    public void d(boolean z) {
        this.qy = z;
    }

    public boolean de() {
        return this.qy;
    }

    public void hc(String str) {
        this.gv = str;
    }

    public String v() {
        return this.gv;
    }

    public void d(int i) {
        this.ph = i;
    }

    public int np() {
        return this.ph;
    }

    public int yi() {
        return this.t;
    }

    public void hc(int i) {
        this.t = i;
    }

    public void b(int i) {
        this.ar = i;
    }

    public int he() {
        return this.ar;
    }

    public boolean vv() {
        return this.qr;
    }

    public void hc(boolean z) {
        this.qr = z;
    }

    public boolean zw() {
        return this.ey;
    }

    public void b(boolean z) {
        this.ey = z;
    }

    public void b(Map<String, Object> map) {
        if (map != null) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "setMediaExtraInfo ".concat(String.valueOf(map)));
            this.i.putAll(map);
        }
    }

    public Map<String, Object> j() {
        return this.i;
    }

    public boolean s() {
        if (this.ia) {
            return true;
        }
        this.ia = true;
        return false;
    }

    public boolean us() {
        if (this.nw) {
            return true;
        }
        this.nw = true;
        return false;
    }

    public boolean z() {
        if (this.dz) {
            return true;
        }
        this.dz = true;
        return false;
    }

    public boolean fs() {
        if (this.nr) {
            return true;
        }
        this.nr = true;
        return false;
    }

    public int ba() {
        return this.rw;
    }

    public void c(int i) {
        this.rw = i;
    }

    public void c(boolean z) {
        this.ra = z;
    }

    public boolean mt() {
        return this.ra;
    }

    public String r() {
        return this.xp;
    }

    public void b(String str) {
        this.xp = str;
    }

    public String hv() {
        return this.to;
    }

    public void c(String str) {
        this.to = str;
    }

    public String bc() {
        return this.l;
    }

    public void u(String str) {
        this.l = str;
    }

    public String dc() {
        return this.fu;
    }

    public void an(String str) {
        this.fu = str;
    }

    public int nv() {
        return this.yn;
    }

    public void u(int i) {
        this.yn = i;
    }

    public int y() {
        return this.ru;
    }

    public void an(int i) {
        this.ru = i;
    }

    public void h(String str) {
        this.q = str;
    }

    public void h(int i) {
        this.y = i;
    }

    public void gb(int i) {
        this.wl = i;
    }

    public int gb(String str) {
        if (TextUtils.equals(str, this.q)) {
            return this.y;
        }
        return this.tr;
    }

    public void tt(int i) {
        this.tr = i;
    }

    public int tt(String str) {
        if (TextUtils.equals(str, this.q)) {
            return this.wl;
        }
        return this.nv;
    }

    public void tc(int i) {
        this.nv = i;
    }

    public String wl() {
        return this.hg;
    }

    public void tc(String str) {
        this.hg = str;
    }

    public String q() {
        return this.gu;
    }

    public void mk(String str) {
        this.gu = str;
    }

    public String ru() {
        return this.hr;
    }

    public void mq(String str) {
        this.hr = str;
    }

    public void d(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.p.put(str, obj);
    }

    public void c(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.p.putAll(map);
    }

    public final Map<String, Object> yn() {
        return this.p;
    }

    public String l() {
        return this.ox;
    }

    public void uo(String str) {
        this.ox = str;
    }

    public String fu() {
        return this.tj;
    }

    public void k(String str) {
        this.tj = str;
    }

    public boolean xp() {
        return this.f;
    }

    public void u(boolean z) {
        this.f = z;
    }

    public boolean to() {
        return this.oc;
    }

    public void an(boolean z) {
        this.oc = z;
    }

    public final void d(long j) {
        if (this.rs == 0) {
            this.rs = j;
        }
    }

    public final long ra() {
        return this.rs;
    }

    public Map<String, Object> rw() {
        return this.ic;
    }

    public void hc(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.ic.put(str, obj);
    }

    public void e(String str) {
        this.kb = str;
    }

    public String ia() {
        return this.kb;
    }

    public void cb(String str) {
        this.wb = str;
    }

    public String nw() {
        return this.wb;
    }

    public void w(String str) {
        this.mb = str;
    }

    public String dz() {
        return this.mb;
    }

    public String nr() {
        return TextUtils.isEmpty(this.wb) ? this.mb : this.wb;
    }

    public void yo(String str) {
        this.js = str;
    }

    public String i() {
        return this.js;
    }

    public void h(boolean z) {
        this.he = z;
    }

    public boolean ey() {
        return this.he;
    }

    public void mk(int i) {
        this.v = i;
    }

    public void mq(int i) {
        this.np = i;
    }

    public int qr() {
        return this.np;
    }

    public int ar() {
        return this.v;
    }

    public int t() {
        return this.pq;
    }

    public void uo(int i) {
        this.pq = i;
    }

    public void rf(String str) {
        this.um = str;
    }

    public String ph() {
        return this.fv;
    }

    public void jh(String str) {
        this.fv = str;
    }

    public void sy(String str) {
        this.vv = str;
    }

    public void gb(boolean z) {
        this.zw = z;
    }

    public boolean gv() {
        if (!TextUtils.isEmpty(this.j) || !TextUtils.isEmpty(this.s) || this.us > 0 || !TextUtils.isEmpty(this.z)) {
            return true;
        }
        Map<String, String> map = this.mt;
        return ((map == null || map.size() <= 0) && TextUtils.isEmpty(this.fs) && TextUtils.isEmpty(this.ba) && TextUtils.isEmpty(this.hr)) ? false : true;
    }

    public String qy() {
        return this.j;
    }

    public void de(String str) {
        this.j = str;
    }

    public String nf() {
        return this.s;
    }

    public void v(String str) {
        this.s = str;
    }

    public long gw() {
        return this.us;
    }

    public void hc(long j) {
        this.us = j;
    }

    public String fy() {
        return this.z;
    }

    public void np(String str) {
        this.z = str;
    }

    public String zv() {
        return this.fs;
    }

    public void yi(String str) {
        this.fs = str;
    }

    public String um() {
        return this.ba;
    }

    public void he(String str) {
        this.ba = str;
    }

    public Map<String, String> fv() {
        return this.mt;
    }

    public void u(Map<String, String> map) {
        this.mt = map;
    }

    public Map<String, Object> pq() {
        return this.r;
    }

    public double kb() {
        try {
        } catch (NumberFormatException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        if (oc()) {
            if (wb() < 0.0d) {
                return 0.0d;
            }
            return wb();
        }
        if (tj() || ox()) {
            return this.de * Double.valueOf(this.kb).doubleValue();
        }
        return this.de;
    }

    public void d(double d2) {
        this.de = d2;
    }

    public double js() {
        if (!oc()) {
            return this.de;
        }
        if (wb() < 0.0d) {
            return 0.0d;
        }
        return wb();
    }

    public double wb() {
        return this.hv;
    }

    public void hc(double d2) {
        this.hv = d2;
    }

    public double mb() {
        return this.bc;
    }

    public void b(double d2) {
        this.bc = d2;
    }

    public String o() {
        if (oc()) {
            return wb() < 0.0d ? "-1" : String.valueOf(wb());
        }
        return String.valueOf(kb());
    }

    public String f() {
        if (oc()) {
            return mb() < 0.0d ? "-1" : String.valueOf(mb());
        }
        return String.valueOf(kb());
    }

    public boolean oc() {
        return this.zv == 2;
    }

    public boolean rs() {
        int i = this.zv;
        return i == 0 || i == 100;
    }

    public boolean tj() {
        return this.zv == 1;
    }

    public boolean ox() {
        return this.zv == 3;
    }

    public boolean p() {
        return this.zv == 0;
    }

    public boolean hr() {
        return this.zv == 100;
    }

    public void k(int i) {
        this.yi = i;
    }

    public int hg() {
        return this.zv;
    }

    public void e(int i) {
        this.zv = i;
    }

    public void cb(int i) {
        this.gw = i;
    }

    public int gu() {
        return this.gw;
    }

    public void w(int i) {
        this.fy = i;
    }

    public int ho() {
        return this.fy;
    }

    public List<String> ic() {
        return this.jh;
    }

    public void d(List<String> list) {
        if (list != null) {
            this.jh.addAll(list);
        }
    }

    public void vv(String str) {
        this.mk = str;
    }

    public String ec() {
        return this.mk;
    }

    public String jm() {
        return this.mq;
    }

    public void zw(String str) {
        this.mq = str;
    }

    public int cj() {
        return this.uo;
    }

    public void yo(int i) {
        this.uo = i;
    }

    public int lv() {
        return this.k;
    }

    public void rf(int i) {
        this.k = i;
    }

    public String ed() {
        return this.w;
    }

    public void j(String str) {
        this.w = str;
    }

    public void s(String str) {
        this.yo = str;
    }

    public void jh(int i) {
        this.dc = i;
    }

    public int zk() {
        return this.dc;
    }

    public int el() {
        return this.yi;
    }

    public String nk() {
        return this.tt;
    }

    public void us(String str) {
        this.tt = str;
    }

    public void z(String str) {
        this.tc = str;
    }

    public String om() {
        return this.tc;
    }

    public double eu() {
        return this.rf;
    }

    public void c(double d2) {
        this.rf = d2;
    }

    public void fs(String str) {
        this.sy = str;
    }

    public String qv() {
        return this.sy;
    }

    public final boolean ba(String str) {
        Integer numAn = an();
        return numAn.intValue() == 1 ? !com.bytedance.msdk.core.u.d.d.d().d(str, this) : numAn.intValue() == 2;
    }

    public Integer an() {
        return 1;
    }

    public void sy(int i) {
        this.e = i;
    }

    public int mg() {
        return this.e;
    }

    public void de(int i) {
        this.cb = i;
    }

    public int pa() {
        return this.cb;
    }

    public boolean xn() {
        return this.o;
    }

    public void tt(boolean z) {
        this.o = z;
    }

    private void d(ViewGroup viewGroup, tc tcVar) {
        hc(viewGroup);
        View viewFindViewById = viewGroup.findViewById(R.id.tt_mediation_mtg_ad_choice);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (tcVar != null) {
            d(viewGroup.findViewById(tcVar.mq));
        }
    }

    public void d(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
        d(viewGroup, (tc) null);
    }

    public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tc tcVar, List<View> list4) {
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        d(viewGroup, tcVar);
    }

    public void d(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
            }
        }
    }

    public void hc(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    private void hc(ViewGroup viewGroup) {
        try {
            if (viewGroup.getChildCount() == 0) {
                return;
            }
            int i = 0;
            if (t() != 3 && (viewGroup.getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                if ("tt_gdt_developer_view_root".equals(viewGroup2.getTag(R.id.tt_mediation_gdt_developer_view_root_tag_key))) {
                    viewGroup.removeView(viewGroup2);
                    int i2 = 0;
                    while (i2 < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i2);
                        if (childAt != null) {
                            Object tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key);
                            if ((tag instanceof String) && tag.equals("tt_gdt_developer_view")) {
                                viewGroup2.removeView(childAt);
                                viewGroup.addView(childAt, childAt.getLayoutParams());
                            }
                        }
                        i2++;
                    }
                }
            }
            if (t() == 2 || !(viewGroup.getChildAt(0) instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.getChildAt(0);
            if ("tt_admob_native_view_root_tag".equals(viewGroup3.getTag(R.id.tt_mediation_admob_developer_view_root_tag_key))) {
                viewGroup.removeView(viewGroup3);
                while (i < viewGroup3.getChildCount()) {
                    View childAt2 = viewGroup3.getChildAt(i);
                    if (childAt2 != null) {
                        Object tag2 = childAt2.getTag(R.id.tt_mediation_admob_developer_view_tag_key);
                        if ((tag2 instanceof String) && tag2.equals("tt_admob_native_view_tag")) {
                            viewGroup3.removeView(childAt2);
                            viewGroup.addView(childAt2, childAt2.getLayoutParams());
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public void yo() {
        this.d = null;
        this.hc = null;
        this.b = null;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (bVar == null || this.fy > bVar.ho()) {
            return 1;
        }
        if (this.fy < bVar.ho()) {
            return -1;
        }
        if (this.gw > bVar.gu()) {
            return 1;
        }
        return this.gw < bVar.gu() ? -1 : 0;
    }

    public com.bytedance.msdk.api.c.d.h.hc mq() {
        return this.d;
    }

    public com.bytedance.msdk.api.c.d.b.d e() {
        return this.an;
    }

    public gb uo() {
        return this.hc;
    }

    public com.bytedance.msdk.api.c.d.hc k() {
        return this.b;
    }

    public void d(tt ttVar) {
        this.u = ttVar;
    }

    public void d(com.bytedance.msdk.api.c.d.c cVar) {
        this.c = cVar;
    }

    public void d(com.bytedance.msdk.api.c.d.h.hc hcVar) {
        this.d = hcVar;
    }

    public void d(gb gbVar) {
        this.hc = gbVar;
    }

    public void d(final com.bytedance.msdk.api.c.d.hc hcVar) {
        if (hcVar != null) {
            this.b = new com.bytedance.msdk.api.c.d.hc() { // from class: com.bytedance.msdk.hc.b.1
                @Override // com.bytedance.msdk.api.c.d.hc
                public void d() {
                    com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.hc.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hcVar.d();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.c.d.hc
                public void hc() {
                    com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.hc.b.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hcVar.hc();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.c.d.hc
                public void d(final long j, final long j2, final int i, final int i2, final String str, final String str2) {
                    com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.hc.b.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            hcVar.d(j, j2, i, i2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.c.d.hc
                public void d(final long j, final long j2, final String str, final String str2) {
                    com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.hc.b.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            hcVar.d(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.c.d.hc
                public void hc(final long j, final long j2, final String str, final String str2) {
                    com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.hc.b.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            hcVar.hc(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.c.d.hc
                public void d(final long j, final String str, final String str2) {
                    com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.hc.b.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            hcVar.d(j, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.c.d.hc
                public void d(final String str, final String str2) {
                    com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.hc.b.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            hcVar.d(str, str2);
                        }
                    });
                }
            };
        }
    }

    public void d(com.bytedance.msdk.api.c.d.b.d dVar) {
        this.an = dVar;
    }

    public void d(an anVar) {
        this.h = anVar;
    }

    public an yw() {
        return this.h;
    }

    public void hc(an anVar) {
        this.gb = anVar;
    }

    public boolean wz() {
        return (this instanceof com.bytedance.msdk.api.c.d.hc.hc) || (this instanceof com.bytedance.msdk.b.d.d.b);
    }

    public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
        this.ec = dVar;
    }

    public com.bytedance.sdk.openadsdk.jh.d.hc.d.d rf() {
        return this.ec;
    }

    public d vo() {
        return this.ho;
    }

    public void d(d dVar) {
        this.ho = dVar;
    }
}
