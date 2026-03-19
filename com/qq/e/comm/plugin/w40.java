package com.qq.e.comm.plugin;

import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.room.RoomMasterTable;
import com.qq.e.comm.plugin.dl;
import com.qq.e.comm.plugin.v30;
import com.qq.e.comm.plugin.v40;
import com.sigmob.sdk.base.mta.PointType;
import com.ss.ttm.player.MediaPlayer;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class w40<T extends v40<V>, V extends View & dl> implements fm {
    protected V A;
    private String B;
    private String D;
    private a7 E;
    private a7 F;
    private Map<String, ob> a;
    private Map<String, f10> b;
    private Map<s2, pb> e;
    protected T f;
    protected im n;
    protected zn o;
    protected rk p;
    private s2[] r;
    private pc s;
    protected d u;
    private f v;
    protected int w;
    private List<g> x;
    private d10 z;
    private int h = -1;
    private int i = 0;
    private boolean j = false;
    private int m = -1;
    protected u8 q = new u8();
    private List<z8> y = Collections.emptyList();
    private boolean C = false;
    private final Map<String, f10> c = new HashMap();
    private final List<h8> d = new ArrayList(2);
    protected final lb t = new lb();
    private final bo g = new bo(this);

    /* compiled from: A */
    public interface d extends gk {
    }

    /* compiled from: A */
    public interface e {
        w40 a();
    }

    /* compiled from: A */
    public interface f {
        void a(w40 w40Var, z8 z8Var);
    }

    /* compiled from: A */
    public interface g {
        void a(w40 w40Var, int i, int i2);
    }

    private void G() {
    }

    public void a(t40 t40Var) {
    }

    @Override // com.qq.e.comm.plugin.fm
    public void a(String str, JSONObject jSONObject) {
    }

    protected abstract V b(e8 e8Var);

    protected abstract T p();

    public void H() {
        this.n.a().a(this.r, this);
        bo boVar = this.g;
        if (boVar != null) {
            boVar.d();
        }
    }

    public void I() {
        V v = (V) b(c());
        this.A = v;
        v.a(this);
        G();
        this.f = (T) p();
        this.p = a(this.A);
        this.g.b(true);
    }

    public xj s() {
        return this.t;
    }

    public void a(xj xjVar) {
        if (xjVar == null) {
            return;
        }
        this.t.a(xjVar);
    }

    public void f(int i) {
        if (this.t.a(i)) {
            J();
        }
    }

    /* compiled from: A */
    class a implements v30.d {
        a() {
        }

        @Override // com.qq.e.comm.plugin.v30.d
        public void a(Object[] objArr) {
            if (w40.this.t.a(objArr)) {
                w40.this.o();
            }
        }
    }

    /* compiled from: A */
    class b implements v30.c {
        b() {
        }

        @Override // com.qq.e.comm.plugin.v30.c
        public void a(int i) {
            if (w40.this.t.a(i)) {
                w40.this.o();
            }
        }
    }

    /* compiled from: A */
    class c implements v30.c {
        c() {
        }

        @Override // com.qq.e.comm.plugin.v30.c
        public void a(int i) {
            if (w40.this.t.b(i)) {
                w40.this.o();
            }
        }
    }

    public void g(int i) {
        if (this.t.b(i)) {
            J();
        }
    }

    public void h(int i) {
        if (this.t.c(i)) {
            J();
        }
    }

    private void J() {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        viewA.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        View viewA = A();
        if (viewA != null && viewA.willNotDraw()) {
            viewA.setWillNotDraw(false);
        }
        J();
    }

    public im D() {
        return this.n;
    }

    public final zn C() {
        return this.o;
    }

    public void l() {
        if (this.c.size() > 0) {
            for (Map.Entry<String, f10> entry : this.c.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            M();
        }
    }

    private void d(z10 z10Var) {
        rc[] rcVarArr = z10Var.f;
        if (rcVarArr == null) {
            return;
        }
        if (!this.d.isEmpty()) {
            this.d.clear();
        }
        for (rc rcVar : rcVarArr) {
            this.d.add(new h8(rcVar));
        }
        Iterator<h8> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(this.n, (w40<?, ?>) this);
        }
    }

    private void c(z10 z10Var) {
        Map<String, ob> map = z10Var.e;
        int size = map == null ? 0 : map.size();
        if (size > 0) {
            this.a = new HashMap(size);
            for (Map.Entry<String, ob> entry : z10Var.e.entrySet()) {
                String key = entry.getKey();
                ob obVar = (ob) entry.getValue().a();
                this.a.put(key, obVar);
                if (x9.c()) {
                    this.n.i().a((w40<?, ?>) this, obVar, key);
                }
            }
        }
    }

    private void e(z10 z10Var) {
        Map<String, f10> map;
        if (z10Var == null || (map = z10Var.c) == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, f10> entry : z10Var.c.entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
    }

    public List<h8> t() {
        return this.d;
    }

    public boolean K() {
        return this.g.e();
    }

    public final int E() {
        return this.i;
    }

    private void j() {
        V v;
        if (this.C || (v = this.A) == null) {
            return;
        }
        this.C = true;
        if (Build.VERSION.SDK_INT >= 16) {
            float cameraDistance = v.getCameraDistance();
            if (cameraDistance <= 0.0f) {
                cameraDistance = 1920.0f;
            }
            this.A.setCameraDistance(cameraDistance * 2.56576f);
        }
    }

    private final void b(int i) {
        e8 e8VarC;
        ol olVarG;
        View viewA = A();
        if (viewA == null || (e8VarC = c()) == null || (olVarG = e8VarC.g()) == null) {
            return;
        }
        olVarG.a(viewA, i);
    }

    public final void i(int i) {
        T t = this.f;
        if (t != null) {
            t.a(i);
        }
    }

    public final boolean L() {
        return this.i == 0;
    }

    public V A() {
        return this.A;
    }

    public rk w() {
        return this.p;
    }

    public u8 B() {
        return this.q;
    }

    public T v() {
        return this.f;
    }

    protected void M() {
        T t = this.f;
        if (t != null) {
            t.h();
        }
    }

    public int z() {
        return this.f.e();
    }

    public int y() {
        return this.f.d();
    }

    void b(z10 z10Var) {
        this.B = z10Var.o;
        this.D = z10Var.a;
        this.g.a(z10Var);
        d(z10Var);
        a(z10Var.g);
        c(z10Var);
        this.b = z10Var.d;
        this.r = z10Var.h;
    }

    public Rect F() {
        View viewA = A();
        if (viewA == null || !viewA.isShown()) {
            return null;
        }
        Rect rect = new Rect();
        if (!viewA.getGlobalVisibleRect(rect)) {
            return null;
        }
        int[] iArr = new int[2];
        viewA.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        viewA.getLocationInWindow(iArr2);
        int i = iArr[0] - iArr2[0];
        if (i != 0) {
            rect.right += i;
            rect.left += i;
        }
        int i2 = iArr[1] - iArr2[1];
        if (i2 != 0) {
            rect.bottom += i2;
            rect.top += i2;
        }
        return rect;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0 || this.g.a(jSONObject) || !K()) {
            return;
        }
        Iterator<h8> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(jSONObject);
        }
        Iterator<z8> it2 = this.y.iterator();
        while (it2.hasNext()) {
            it2.next().a(jSONObject);
        }
        b(jSONObject);
        Map<String, ob> map = this.a;
        if (map == null || map.size() == 0) {
            return;
        }
        boolean z = this.c.size() == 0;
        boolean z2 = false;
        for (Map.Entry<String, ob> entry : this.a.entrySet()) {
            Object objE = entry.getValue().e(jSONObject);
            if (objE != null) {
                f10 f10VarC = t30.c(objE);
                String key = entry.getKey();
                if (z || !f10VarC.equals(this.c.get(key))) {
                    this.c.put(key, f10VarC);
                    b(key, f10VarC);
                    z2 = true;
                }
            }
        }
        if (z2) {
            M();
        }
    }

    private final void d(int i) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        viewA.setPivotX(i);
    }

    private final void e(int i) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        viewA.setPivotY(i);
    }

    public a7 q() {
        return this.F;
    }

    public final void l(int i) {
        T t = this.f;
        if (t != null) {
            t.b(i);
        }
    }

    protected void m() {
        if (!K() || this.u == null || this.s != null || this.d.size() <= 0) {
            return;
        }
        pc pcVar = new pc(this, this.u);
        this.s = pcVar;
        pcVar.a(this.d);
    }

    public int r() {
        return this.w;
    }

    protected final void n() {
        List<z8> list;
        if (!K() || this.v == null || this.z != null || (list = this.y) == null || list.size() <= 0) {
            return;
        }
        this.z = new d10(this, this.v);
        if (this.o.K()) {
            this.z.a(this.y);
        }
    }

    public void k() {
        Map<String, f10> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, f10> entry : this.b.entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
    }

    public int u() {
        return this.m;
    }

    public bo x() {
        return this.g;
    }

    public void clear() {
        this.g.a();
        this.A = null;
        this.f = null;
        this.c.clear();
        this.q = new u8();
        this.u = null;
        this.s = null;
        List<h8> list = this.d;
        int size = list == null ? 0 : list.size();
        for (int i = 0; i < size; i++) {
            h8 h8Var = this.d.get(i);
            if (h8Var != null) {
                h8Var.b();
            }
        }
        this.v = null;
        this.z = null;
        this.x = null;
        Map<String, ob> map = this.a;
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<String, ob>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().c();
        }
    }

    protected void d(String str) {
        e8 e8VarC = c();
        if (TextUtils.isEmpty(str) || e8VarC == null) {
            return;
        }
        v30.a(t30.c((Object) str), e8VarC.f(), new b());
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.add(gVar);
    }

    private void b(JSONObject jSONObject) {
        Object objE;
        Map<s2, pb> map = this.e;
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<s2, pb>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            pb value = it.next().getValue();
            if (value != null && (objE = value.a().e(jSONObject)) != null) {
                try {
                    value.a(new JSONArray(objE.toString()));
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void a(z10 z10Var) {
        if (z10Var == null) {
            return;
        }
        this.f.b(z10Var.j);
        this.f.a(z10Var.k);
        e(z10Var);
        if (this.c.size() == 0) {
            M();
        }
    }

    public void k(int i) {
        View viewA;
        this.i = i;
        if (this.j || (viewA = A()) == null) {
            return;
        }
        int i2 = this.i;
        if (i2 == 1) {
            if (viewA.getVisibility() != 4) {
                viewA.setVisibility(4);
            }
        } else if (i2 != 2) {
            if (viewA.getVisibility() != 0) {
                viewA.setVisibility(0);
            }
        } else if (viewA.getVisibility() != 8) {
            viewA.setVisibility(8);
        }
    }

    public void j(int i) {
        this.m = i;
    }

    public final void d(float f2) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        j();
        viewA.setRotationY(f2);
    }

    private int c(int i) {
        int i2;
        if (i == 8 || (i2 = this.i) == 2) {
            return 2;
        }
        if (i == 4) {
            i2 = 1;
        }
        w40<T, V> w40VarC = this;
        do {
            w40VarC = w40VarC.C();
            if (w40VarC == null) {
                break;
            }
            int iE = w40VarC.E();
            if (iE > i2) {
                i2 = iE;
            }
        } while (i2 != 2);
        return i2;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            return;
        }
        f10 f10VarC = t30.c(obj);
        if (f10VarC.equals(this.c.get(str))) {
            return;
        }
        this.c.put(str, f10VarC);
        if (!this.g.a(str, f10VarC) && K()) {
            b(str, f10VarC);
            M();
        }
    }

    public final e8 c() {
        im imVar = this.n;
        if (imVar == null) {
            return null;
        }
        return imVar.c();
    }

    private void a(e10[] e10VarArr) {
        if (e10VarArr == null) {
            return;
        }
        this.y = new ArrayList(e10VarArr.length);
        for (e10 e10Var : e10VarArr) {
            this.y.add(new z8(e10Var));
        }
        Iterator<z8> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().a(this.n, (w40<?, ?>) this);
        }
    }

    public JSONArray b(s2 s2Var) {
        JSONArray jSONArrayB;
        if (s2Var == null) {
            return null;
        }
        pb pbVar = this.e.get(s2Var);
        return (pbVar == null || (jSONArrayB = pbVar.b()) == null) ? s2Var.c : jSONArrayB;
    }

    public void b(cm cmVar) {
        v30.a(cmVar, c().f(), new c());
    }

    public final void c(float f2) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        j();
        viewA.setRotationX(f2);
    }

    public void a(s2 s2Var) {
        if (this.e == null) {
            this.e = new ConcurrentHashMap();
        }
        ob obVarB = t30.b((Object) s2Var.b());
        if (obVarB != null) {
            this.e.put(s2Var, new pb(obVarB));
            if (x9.c()) {
                this.n.i().a((w40<?, ?>) this, obVarB, s2Var);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.qq.e.comm.plugin.v40] */
    protected rk a(View view) {
        zn znVar = this.o;
        if (znVar != null) {
            return znVar.v().a(this.A);
        }
        return this.f.a(this.A);
    }

    public void b(a7 a7Var) {
        this.E = a7Var;
    }

    public final void b(float f2) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        viewA.setRotation(f2);
    }

    public void b(int[] iArr) {
        if (this.t.b(iArr)) {
            o();
        }
    }

    public final void a(View view, int i) {
        int iC;
        List<g> list = this.x;
        if (list == null || list.size() <= 0 || (iC = c(i)) == this.h) {
            return;
        }
        Iterator<g> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.h, iC);
        }
        this.h = iC;
    }

    public final void b(Float f2, Float f3) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        if (f2 != null) {
            viewA.setTranslationX(f2.floatValue());
        }
        if (f3 != null) {
            viewA.setTranslationY(f3.floatValue());
        }
    }

    public final void a(float f2) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        viewA.setAlpha(f2);
    }

    private boolean b(String str, cm cmVar) {
        return a(str, cmVar) || this.p.a(str, cmVar) || this.q.a(str, cmVar);
    }

    protected boolean a(String str, cm cmVar) {
        return a(str, cmVar, this.p.o(), this.p.l());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean a(String str, cm cmVar, int i, int i2) {
        str.hashCode();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1572:
                if (str.equals("15")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1574:
                if (str.equals(PointType.LOAD_READY)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1576:
                if (str.equals("19")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1604:
                if (str.equals("26")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1636:
                if (str.equals("37")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1660:
                if (str.equals("40")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1661:
                if (str.equals("41")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1662:
                if (str.equals(RoomMasterTable.DEFAULT_ID)) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1665:
                if (str.equals("45")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1667:
                if (str.equals("47")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1668:
                if (str.equals("48")) {
                    c2 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1669:
                if (str.equals("49")) {
                    c2 = 14;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_OUT_OF_SYNC_WHEN_MASTER_REMOVED /* 1727 */:
                if (str.equals("65")) {
                    c2 = 15;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MULTISTREAM_SHOULD_CHECK_BUFFER_STATE /* 1728 */:
                if (str.equals("66")) {
                    c2 = 16;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MULTISTREAM_FORBID_PLAY_SPEED_CHANGE /* 1729 */:
                if (str.equals("67")) {
                    c2 = 17;
                    break;
                }
                break;
            case 1785:
                if (str.equals("81")) {
                    c2 = 18;
                    break;
                }
                break;
            case 1786:
                if (str.equals("82")) {
                    c2 = 19;
                    break;
                }
                break;
            case 454217397:
                if (str.equals("viewTag")) {
                    c2 = 20;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                k(cmVar.f(new JSONObject[0]));
                return true;
            case 1:
                f(v30.b(cmVar));
                return true;
            case 2:
                a(cmVar.b(new JSONObject[0]));
                return true;
            case 3:
                h(cmVar.c(new JSONObject[0]).a(new r8(i, i2, D().d(), D().f())));
                return true;
            case 4:
                b(cmVar);
                return true;
            case 5:
                a(v30.a(cmVar, new r8(i, i2, D().d(), D().f())));
                return true;
            case 6:
                b(cmVar.f(new JSONObject[0]));
                return true;
            case 7:
                a(cmVar);
                return true;
            case '\b':
                d(cmVar.c(new JSONObject[0]).a(new r8(i, i2, D().d(), D().f())));
                return true;
            case '\t':
                e(cmVar.c(new JSONObject[0]).a(new r8(i, i2, D().d(), D().f())));
                return true;
            case '\n':
                b(cmVar.b(new JSONObject[0]));
                return true;
            case 11:
                this.w = cmVar.f(new JSONObject[0]);
                return true;
            case '\f':
                d(cmVar.toString());
                return true;
            case '\r':
                Pair<Float, Float> pairF = v30.f(cmVar);
                if (pairF != null) {
                    b((Float) pairF.first, (Float) pairF.second);
                }
                return true;
            case 14:
                Pair<Float, Float> pairE = v30.e(cmVar);
                if (pairE != null) {
                    a((Float) pairE.first, (Float) pairE.second);
                }
                return true;
            case 15:
                c(cmVar.b(new JSONObject[0]));
                return true;
            case 16:
                d(cmVar.b(new JSONObject[0]));
                return true;
            case 17:
                b(v30.b(cmVar, new r8(i, i2, D().d(), D().f())));
                return true;
            case 18:
                int[] iArrD = v30.d(cmVar);
                if (iArrD != null) {
                    this.f.b(iArrD);
                }
                return true;
            case 19:
                int[] iArrD2 = v30.d(cmVar);
                if (iArrD2 != null) {
                    this.f.a(iArrD2);
                }
                return true;
            case 20:
                View viewA = A();
                if (viewA != null) {
                    viewA.setTag(cmVar.toString());
                }
                return true;
            default:
                return false;
        }
    }

    private void a(cm cmVar) {
        v30.a(cmVar, c().f(), new a());
    }

    public void a(Object[] objArr) {
        if (this.t.a(objArr)) {
            o();
        }
    }

    public void a(int[] iArr) {
        if (this.t.a(iArr)) {
            J();
        }
    }

    public void a(a7 a7Var) {
        this.F = a7Var;
    }

    public void a(d dVar) {
        this.u = dVar;
        m();
    }

    public final void a(zn znVar) {
        if (znVar == null) {
            return;
        }
        this.o = znVar;
        this.g.a(znVar);
    }

    public final void a(Float f2, Float f3) {
        View viewA = A();
        if (viewA == null) {
            return;
        }
        if (f2 != null) {
            viewA.setScaleX(f2.floatValue());
        }
        if (f3 != null) {
            viewA.setScaleY(f3.floatValue());
        }
    }

    public void a(f fVar) {
        this.v = fVar;
        n();
    }

    public void a(im imVar) {
        this.n = imVar;
    }

    public void a(boolean z) {
        this.j = z;
        if (z) {
            View viewA = A();
            if (viewA == null || viewA.getVisibility() == 8) {
                return;
            }
            viewA.setVisibility(8);
            return;
        }
        k(this.i);
    }
}
