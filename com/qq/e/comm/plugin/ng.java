package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.app.NotificationCompat;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.callback.biz.DLInterceptStateCallback;
import com.qq.e.comm.plugin.callback.biz.DynamicAdCallback;
import com.qq.e.comm.plugin.callback.biz.TimerStateCallback;
import com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle;
import com.qq.e.comm.plugin.dysi.IGDTADM;
import com.qq.e.comm.plugin.dysi.IGDTAdDataHelper;
import com.qq.e.comm.plugin.dysi.IGDTAudioPlayer;
import com.qq.e.comm.plugin.dysi.IGDTBiz;
import com.qq.e.comm.plugin.dysi.IGDTSDK;
import com.qq.e.comm.plugin.dysi.IGDTVideoPlayer;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.s3;
import com.ss.texturerender.TextureRenderKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ng implements os {
    private static Set<WeakReference<ng>> A;
    private static final String y = "var GDTEnv={OS:2,Android:2,iOS:1,EngineVersion:23,OSVersion:" + Build.VERSION.SDK_INT + "};var GDTViewNode={VISIBLE:0,INVISIBLE:1,GONE:2};";
    private static final boolean z;
    private og b;
    private lg c;
    private long d;
    private final com.qq.e.comm.dynamic.b e;
    private final nb f;
    private final s3.g g;
    private final h4 j;
    private final f5 m;
    private final yq n;
    private final f9 o;
    private int p;
    private Map<Integer, Object> q;
    private m s;
    private final IGDTBiz t;
    private boolean w;
    private WeakReference<ng> a = null;
    private final ns i = new ns();
    private boolean r = false;
    private JSONObject u = new JSONObject();
    private ViewTreeObserver.OnWindowFocusChangeListener v = null;
    private final Runnable x = new d();
    private final Handler h = new Handler(Looper.getMainLooper());

    static {
        z = r1.d().f().a("cfcddv", 0) == 1;
        A = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    private void b() {
        pro.getVresult(48, 0, this);
    }

    private void c(String str) {
        pro.getVresult(49, 0, this, str);
    }

    private void f() {
    }

    private void g() {
    }

    private ng(com.qq.e.comm.dynamic.b bVar, f9 f9Var, im imVar, h4 h4Var, yq yqVar) throws JSONException {
        this.e = bVar;
        this.j = h4Var;
        this.n = yqVar;
        this.o = f9Var;
        this.t = new of(bVar, h4Var, yqVar);
        f5 f5VarA = f5.a(h4Var, yqVar);
        this.m = f5VarA;
        a(f9Var, imVar, h4Var);
        a(imVar, h4Var, yqVar);
        nb nbVarA = nb.a(bVar, h4Var, yqVar);
        this.f = nbVarA;
        if (nbVarA == null) {
            this.g = null;
            return;
        }
        a aVar = new a();
        this.g = aVar;
        s3.b().a(aVar);
        long jCurrentTimeMillis = System.currentTimeMillis();
        nbVarA.onViewCreate();
        ey.b((int) (System.currentTimeMillis() - jCurrentTimeMillis), f5VarA);
        int iA = r1.d().f().a("qpi", 0);
        this.p = iA;
        a(iA);
        f();
    }

    /* compiled from: A */
    class a implements s3.g {
        a() {
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() throws JSONException {
            ng.this.f.onAppForeground();
            return false;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() throws JSONException {
            ng.this.f.onAppBackground();
            return false;
        }
    }

    /* compiled from: A */
    class b implements IGDTSDK {
        final /* synthetic */ h4 a;
        final /* synthetic */ im b;
        final /* synthetic */ f9 c;

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void bindData(String str) throws JSONException {
            int iOptInt;
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("extAd");
                int length = jSONArrayOptJSONArray == null ? 0 : jSONArrayOptJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    Object obj = JSONObject.NULL;
                    if (!obj.equals(jSONObjectOptJSONObject)) {
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("dlInfo");
                        if (!obj.equals(jSONObjectOptJSONObject2) && (iOptInt = jSONObjectOptJSONObject2.optInt("adModel", -1)) >= 0) {
                            jSONObjectOptJSONObject2.put("adModel", this.a.b(iOptInt));
                        }
                    }
                }
                this.b.a(jSONObject);
            } catch (JSONException unused) {
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public String gdm() {
            return r1.d().c().j;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public int getSettingInt(String str) {
            return xc.e() ? xc.a(str, -1, this.a) : xc.a(str, this.a.y0(), -1, this.a.x0());
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public int getSettingIntWithDef(String str, int i2) {
            return xc.e() ? xc.a(str, i2, this.a) : xc.a(str, this.a.y0(), i2, this.a.x0());
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public String getSettingString(String str) {
            return xc.e() ? xc.a(str, "-1", this.a) : xc.a(str, this.a.y0(), "-1", this.a.x0());
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public String getSettingStringWithDef(String str, String str2) {
            return xc.e() ? xc.a(str, str2, this.a) : xc.a(str, this.a.y0(), str2, this.a.x0());
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public String gti(String str) {
            if ("1".equals(str)) {
                return d8.a(ng.this.j);
            }
            JSONObject jSONObjectA = new jn(str).a();
            return "2".equals(jSONObjectA.optString("type")) ? mw.a(ng.this.j, jSONObjectA.optJSONObject("params"), ng.this.e, ng.this.m) : "";
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public boolean oa(String str) throws JSONException {
            Context contextA = r1.d().a();
            JSONObject jSONObjectA = new jn(str).a();
            String strOptString = jSONObjectA.optString("scheme");
            String strOptString2 = jSONObjectA.optString(Config.INPUT_DEF_PKG);
            if (!TextUtils.isEmpty(strOptString)) {
                Intent intentC = ct.c(contextA, strOptString);
                if (intentC != null) {
                    if (!TextUtils.isEmpty(strOptString2)) {
                        Intent intent = new Intent(intentC);
                        intent.setPackage(strOptString2);
                        if (ct.a(contextA, intent) != null && ct.b(contextA, intent)) {
                            a(true, ng.this.m, 1, strOptString);
                            return true;
                        }
                    }
                    if (ct.a(contextA, intentC) != null && ct.b(contextA, intentC)) {
                        a(true, ng.this.m, 1, strOptString);
                        return true;
                    }
                }
                a(false, ng.this.m, 1, strOptString);
            }
            if (!TextUtils.isEmpty(strOptString2)) {
                Intent intentB = ct.b(contextA, strOptString2);
                if (intentB != null && ct.b(contextA, intentB)) {
                    a(true, ng.this.m, 2, strOptString2);
                    return true;
                }
                a(false, ng.this.m, 2, strOptString2);
            }
            return false;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void observeDLEngine(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = ng.this.u.optInt(IGDTBiz.KEY_GDTBIZ) | jSONObject.optInt(IGDTBiz.KEY_GDTBIZ);
                jSONObject.putOpt(IGDTBiz.KEY_GDTBIZ, Integer.valueOf(iOptInt));
                ng.this.t.setObserveFlag(iOptInt);
                if (a("GDTAudioPlayer", ng.this.u, jSONObject)) {
                    ng.this.e.a("GDTAudioPlayer", IGDTAudioPlayer.class, new mg(this.c, ng.this.j, ng.this.n, ng.this.e));
                }
                if (a(IGDTVideoPlayer.KEY_VIDEO_PLAYER, ng.this.u, jSONObject)) {
                    ng ngVar = ng.this;
                    ngVar.b = new og(this.c, ngVar.e, this.a, ng.this.n);
                    ng.this.e.a(IGDTVideoPlayer.KEY_VIDEO_PLAYER, IGDTVideoPlayer.class, ng.this.b);
                }
                if (a("GDTADM", ng.this.u, jSONObject)) {
                    ng ngVar2 = ng.this;
                    ngVar2.c = new lg(ngVar2.h, ng.this.e, this.a, ng.this.n);
                    ng.this.e.a("GDTADM", IGDTADM.class, ng.this.c);
                }
                if (ng.this.f != null && Build.VERSION.SDK_INT >= 18 && a("window", ng.this.u, jSONObject)) {
                    ng.this.v = new i();
                    this.b.g().getViewTreeObserver().addOnWindowFocusChangeListener(ng.this.v);
                }
                if (a("eventEmit", ng.this.u, jSONObject)) {
                    ng.this.w = true;
                }
                if (ng.this.c != null) {
                    int iOptInt2 = ng.this.u.optInt("GDTADM") | jSONObject.optInt("GDTADM");
                    jSONObject.putOpt("GDTADM", Integer.valueOf(iOptInt2));
                    ng.this.c.setObserveFlag(iOptInt2);
                }
                ng ngVar3 = ng.this;
                ngVar3.u = ln.b(ngVar3.u, jSONObject);
                this.c.a(a(ng.this.u.optJSONArray("dlInfo")), a(ng.this.u.optJSONArray("animation")));
            } catch (JSONException unused) {
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void playAnimatableImage(String str) {
            JSONObject jSONObjectA = new jn(str).a();
            String strOptString = jSONObjectA.optString("group");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            String strOptString2 = jSONObjectA.optString(TextureRenderKeys.KEY_IS_CALLBACK);
            r2 aVar = !TextUtils.isEmpty(strOptString2) ? new a(strOptString2) : null;
            if (jSONObjectA.optInt(NotificationCompat.CATEGORY_EVENT) == 1) {
                aVar = new C0717b();
            }
            this.b.a(strOptString, aVar);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void rco(String str) {
            i6 i6Var = new i6(ng.this.j);
            JSONObject jSONObjectA = new jn(str).a();
            if (jSONObjectA.optInt("type", 0) == 1) {
                FSCallback fSCallback = (FSCallback) x5.b(ng.this.j.s0(), FSCallback.class);
                if (fSCallback == null) {
                    return;
                }
                i6Var.h = 4;
                i6Var.c = 1005;
                i6Var.n = true;
                fSCallback.V().b(i6Var);
                d8.b(ng.this.j);
                return;
            }
            if (jSONObjectA.has("interactiveType")) {
                i6Var.h = jSONObjectA.optInt("interactiveType");
            } else {
                i6Var.h = 8;
            }
            if (jSONObjectA.has("componentId")) {
                i6Var.c = jSONObjectA.optInt("componentId");
            }
            if (jSONObjectA.has("reportOnly")) {
                i6Var.n = jSONObjectA.optInt("reportOnly", 0) == 1;
            }
            if (jSONObjectA.has("mdpaIndex")) {
                i6Var.l = jSONObjectA.optInt("mdpaIndex");
            }
            i6Var.u = jSONObjectA.optInt("acra", 0);
            if (this.c.a(i6Var)) {
                d8.b(ng.this.j);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void vibrateMobilePhone(String str) {
            z30.a();
        }

        b(h4 h4Var, im imVar, f9 f9Var) {
            this.a = h4Var;
            this.b = imVar;
            this.c = f9Var;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void log(String str) {
            ng.this.a(str);
        }

        /* compiled from: A */
        class a implements r2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // com.qq.e.comm.plugin.r2
            public void a(String str) {
                ng.this.b(this.a);
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.ng$b$b, reason: collision with other inner class name */
        class C0717b implements r2 {
            @Override // com.qq.e.comm.plugin.r2
            public void a(String str) throws JSONException {
                in.b().a("event_onEndAnimatableImage", str).c().a(ng.this.e, ng.this.m);
            }

            C0717b() {
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void showAnimation(String str) {
            if (str != null && str.length() > 12 && str.charAt(0) == '{') {
                JSONObject jSONObjectA = new jn(str).a();
                String strOptString = jSONObjectA.optString("group", s2.q);
                String strOptString2 = jSONObjectA.optString(TextureRenderKeys.KEY_IS_CALLBACK);
                cVar = TextUtils.isEmpty(strOptString2) ? null : new c(strOptString2);
                if (jSONObjectA.optInt(NotificationCompat.CATEGORY_EVENT) == 1) {
                    cVar = new d();
                }
                str = strOptString;
            }
            y7 y7VarB = this.b.b(str);
            if (y7VarB != null) {
                y7VarB.a(cVar);
            }
        }

        /* compiled from: A */
        class c implements r2 {
            final /* synthetic */ String a;

            c(String str) {
                this.a = str;
            }

            @Override // com.qq.e.comm.plugin.r2
            public void a(String str) {
                ng.this.b(this.a);
            }
        }

        /* compiled from: A */
        class d implements r2 {
            @Override // com.qq.e.comm.plugin.r2
            public void a(String str) throws JSONException {
                in.b().a("event_onEndAnimation", str).c().a(ng.this.e, ng.this.m);
            }

            d() {
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void showAnimationFraction(String str, double d2) {
            y7 y7VarB = this.b.b(str);
            if (y7VarB != null) {
                y7VarB.a((float) d2);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void cancelAnimation(String str) {
            y7 y7VarB = this.b.b(str);
            if (y7VarB != null) {
                y7VarB.cancel();
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void setTimeout(String str, int i2) {
            if (i2 < 0 || TextUtils.isEmpty(str)) {
                return;
            }
            ng.this.h.postDelayed(new e(str), i2);
        }

        /* compiled from: A */
        class e implements Runnable {
            final /* synthetic */ String a;

            e(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                ng.this.d(this.a);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void setEventTimeout(String str, int i2) {
            if (i2 < 0 || TextUtils.isEmpty(str)) {
                return;
            }
            ng.this.h.postDelayed(new f(str), i2);
        }

        /* compiled from: A */
        class f implements Runnable {
            final /* synthetic */ String a;

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                in.b().a(this.a, new Object[0]).c().a(ng.this.e, ng.this.m);
            }

            f(String str) {
                this.a = str;
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void loadAd(String str, String str2) {
            h4 h4VarB;
            DynamicAdCallback dynamicAdCallback = (DynamicAdCallback) x5.b(this.a.s0(), DynamicAdCallback.class);
            m8 m8Var = new m8(str2);
            int iOptInt = m8Var.f().optInt("extAdIndex", -1);
            if (iOptInt < 0) {
                return;
            }
            int iOptInt2 = m8Var.f().optInt("sas");
            String strValueOf = String.valueOf(iOptInt + 2);
            if ((iOptInt2 & 2) == 2 && (h4VarB = this.a.b(iOptInt)) != null) {
                a(str, iOptInt, strValueOf, h4VarB, m8Var);
            } else if ((iOptInt2 & 1) == 0) {
                a(str, iOptInt, strValueOf, null, m8Var);
            } else {
                dynamicAdCallback.N().a(new g(ng.this, strValueOf, str, iOptInt, m8Var));
                dynamicAdCallback.loadAd().b(strValueOf);
            }
        }

        /* compiled from: A */
        class g extends ms<Pair<String, h4>> {
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ int d;
            final /* synthetic */ m8 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(os osVar, String str, String str2, int i, m8 m8Var) {
                super(osVar);
                this.b = str;
                this.c = str2;
                this.d = i;
                this.e = m8Var;
            }

            @Override // com.qq.e.comm.plugin.ms
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(Pair<String, h4> pair) {
                if (pair == null) {
                    return;
                }
                if (this.b.equals((String) pair.first)) {
                    b.this.a(this.c, this.d, this.b, (h4) pair.second, this.e);
                }
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void setReducedTime(int i2) {
            ke.a(i2);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void pauseTimer() {
            ((TimerStateCallback) x5.b(ng.this.j.s0(), TimerStateCallback.class)).onPause().a();
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void resumeTimer() {
            ((TimerStateCallback) x5.b(ng.this.j.s0(), TimerStateCallback.class)).onResume().a();
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void track(String str) {
            ey.b(str, ng.this.m);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public int findViewByTag(String str) {
            View viewFindViewWithTag;
            if (TextUtils.isEmpty(str) || (viewFindViewWithTag = this.b.g().findViewWithTag(str)) == null || ng.this.q == null) {
                return -1;
            }
            int iIdentityHashCode = System.identityHashCode(viewFindViewWithTag);
            ng.this.q.put(Integer.valueOf(iIdentityHashCode), viewFindViewWithTag);
            return iIdentityHashCode;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void clickAdContinued(String str) {
            this.c.b((JSONObject) null);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void interactionContinued(String str) {
            this.c.b((JSONObject) null);
        }

        /* compiled from: A */
        class h implements Runnable {
            final /* synthetic */ String a;

            @Override // java.lang.Runnable
            public void run() {
                if (new jn(this.a).a().optInt("codType", 0) == 0) {
                    b.this.c.a(new h8(1, "adClose"));
                    return;
                }
                b.this.c.b(new h8(1, "forceCloseAd"));
                if (ng.z) {
                    xo.d(new a());
                }
            }

            h(String str) {
                this.a = str;
            }

            /* compiled from: A */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ng.this.o.c();
                }
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void cod(String str) {
            ng.this.h.post(new h(str));
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void tar(int i2) {
            if (i2 != yw.a(ng.this.j)) {
                b10.a(1403021, ng.this.m, 2, Integer.valueOf(i2), null);
            } else {
                ((FSCallback) x5.b(ng.this.j.s0(), FSCallback.class)).c0().b(new zw(ng.this.d, ng.this.j.p1() ? 2 : 0, -1, -1, -1, -1));
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void tar2(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt(com.baidu.mobads.container.adrequest.g.ac);
                if (iOptInt != yw.a(ng.this.j)) {
                    b10.a(1403021, ng.this.m, 2, Integer.valueOf(iOptInt), null);
                } else {
                    ((FSCallback) x5.b(ng.this.j.s0(), FSCallback.class)).c0().b(new zw(ng.this.d, ng.this.j.p1() ? 2 : 0, jSONObject.optInt("rin", -1), jSONObject.optInt("ic", -1), jSONObject.optInt("rit", -1), jSONObject.optInt("it", -1)));
                }
            } catch (Throwable unused) {
            }
        }

        /* compiled from: A */
        class i implements ViewTreeObserver.OnWindowFocusChangeListener {
            i() {
            }

            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z) throws JSONException {
                if (ng.this.f == null) {
                    return;
                }
                if (z) {
                    ng.this.f.onWindowFocus();
                } else {
                    ng.this.f.onWindowBlur();
                }
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void ue(String str) {
            int iOptInt;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ng.this.a("ue " + str);
            JSONObject jSONObjectA = new jn(str).a();
            int iOptInt2 = jSONObjectA.optInt("type");
            if (iOptInt2 == 1) {
                ng.this.j.p0().a(jSONObjectA.optInt(com.baidu.mobads.container.adrequest.g.ac));
                ng.this.j.p0().a(jSONObjectA.optInt("flr") != 1);
                ke.i(ng.this.j);
            } else if (iOptInt2 == 2 && (iOptInt = jSONObjectA.optInt("dlcte", -1)) != -1) {
                if (ng.this.j.J0() != 0) {
                    if (!ng.this.j.I1()) {
                        ng.this.o.e().a(iOptInt);
                        ((DLInterceptStateCallback) x5.b(ng.this.j.s0(), DLInterceptStateCallback.class)).E().b(Integer.valueOf(iOptInt));
                        return;
                    } else {
                        ng.this.a("突破到最大次数");
                        return;
                    }
                }
                ng.this.a("默认不突破，仅可突破情况才可修改");
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public int grt() {
            e2 e2VarK = ng.this.j.k();
            if (e2VarK.k() || e2VarK.h()) {
                return ke.b();
            }
            return 0;
        }

        private boolean a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            return jSONObject.optInt(str) == 0 && jSONObject2.optInt(str) > 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i2, String str2, h4 h4Var, m8 m8Var) {
            if (h4Var != null) {
                h4Var.f(3);
                h4Var.a(this.a.p0());
                h4Var.b(str2);
                this.a.a(i2, h4Var);
                m8Var.d(h4Var);
            }
            String strI = h4Var != null ? h4Var.i() : "\"null\"";
            ng.this.b(str + "(" + strI + ", " + m8Var.f() + ")");
        }

        private List<String> a(JSONArray jSONArray) {
            int length;
            if (jSONArray == null || (length = jSONArray.length()) <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(jSONArray.optString(i2));
            }
            return arrayList;
        }

        private void a(boolean z, f5 f5Var, int i2, String str) throws JSONException {
            ja jaVar = new ja();
            jaVar.a("msg", str);
            b10.a(1100960, f5Var, Integer.valueOf(i2), Integer.valueOf(!z ? 1 : 0), jaVar);
        }
    }

    public IDynamicScriptLifecycle e() {
        return this.f;
    }

    public IGDTBiz d() {
        return this.t;
    }

    public Object b(String str) {
        return d(str);
    }

    /* compiled from: A */
    class c implements IGDTAdDataHelper {
        final /* synthetic */ h4 a;

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public String gdm() {
            return r1.d().c().j;
        }

        c(h4 h4Var) {
            this.a = h4Var;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public String gpn() {
            h4 h4Var = this.a;
            if (h4Var == null || !h4Var.k1() || this.a.o() == null) {
                return "";
            }
            String strE = this.a.o().e();
            return !TextUtils.isEmpty(strE) ? strE : "";
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public void adsl(String str, String str2) throws JSONException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || ng.this.s != null) {
                return;
            }
            ng.this.a(str, com.qq.e.comm.plugin.apkmanager.l.e().b(str), -1, str2);
            ng.this.s = new a(str, str2);
            com.qq.e.comm.plugin.apkmanager.l.e().a(str, ng.this.s);
        }

        /* compiled from: A */
        class a implements m {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.ng$c$a$a, reason: collision with other inner class name */
            class RunnableC0718a implements Runnable {
                final /* synthetic */ String a;
                final /* synthetic */ int b;
                final /* synthetic */ int c;

                RunnableC0718a(String str, int i, int i2) {
                    this.a = str;
                    this.b = i;
                    this.c = i2;
                }

                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    a aVar = a.this;
                    ng.this.a(this.a, this.b, this.c, aVar.b);
                }
            }

            @Override // com.qq.e.comm.plugin.m
            public void a(String str, int i, int i2, long j) {
                if (TextUtils.equals(str, this.a)) {
                    ng.this.h.post(new RunnableC0718a(str, i, i2));
                }
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public void rdsl(String str) {
            if (TextUtils.isEmpty(str) || ng.this.s == null) {
                return;
            }
            com.qq.e.comm.plugin.apkmanager.l.e().b(ng.this.s);
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            try {
                if (ng.this.e != null) {
                    ng.this.e.b("GDTSDK.log('ping');");
                }
            } catch (Throwable unused) {
                ey.a("GDTSDK.log('ping');", ng.this.m);
            }
            ng ngVar = ng.this;
            ngVar.a(ngVar.p);
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ng.this.c();
        }
    }

    public static ng a(f9 f9Var, im imVar, h4 h4Var, yq yqVar) {
        if (TextUtils.isEmpty(imVar.e())) {
            return null;
        }
        com.qq.e.comm.dynamic.b bVarA = com.qq.e.comm.dynamic.b.a(1);
        if (bVarA == null) {
            ey.a(f5.a(h4Var, yqVar));
            return null;
        }
        return new ng(bVarA, f9Var, imVar, h4Var, yqVar);
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.r;
    }

    public void c() {
        f9 f9Var;
        if (this.r) {
            return;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.h.post(new e());
            return;
        }
        this.r = true;
        if (this.s != null) {
            com.qq.e.comm.plugin.apkmanager.l.e().b(this.s);
            this.s = null;
        }
        if (this.g != null) {
            s3.b().c(this.g);
        }
        lg lgVar = this.c;
        if (lgVar != null) {
            lgVar.b();
            this.c = null;
        }
        if (this.v != null && (f9Var = this.o) != null) {
            f9Var.l().getViewTreeObserver().removeOnWindowFocusChangeListener(this.v);
        }
        nb nbVar = this.f;
        if (nbVar != null) {
            nbVar.onViewDestroy();
        }
        this.h.removeCallbacksAndMessages(null);
        Map<Integer, Object> map = this.q;
        if (map != null) {
            map.clear();
            this.q = null;
        }
        x5.c(this.j.s0(), TimerStateCallback.class);
        g();
        this.e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object d(String str) throws JSONException {
        com.qq.e.comm.dynamic.b bVar = this.e;
        if (bVar == null) {
            return null;
        }
        try {
            return bVar.b(str);
        } catch (Throwable th) {
            ey.a(str, this.m, th);
            a(th.toString());
            return null;
        }
    }

    private void a(im imVar, h4 h4Var, yq yqVar) {
        StringBuilder sb = new StringBuilder(y);
        sb.append("var GDTAdInfo=");
        sb.append(h4Var.i());
        sb.append(";var GDTTplInfo=");
        sb.append(yqVar == null ? "{}" : yqVar.q());
        sb.append(';');
        sb.append(imVar.e());
        long jCurrentTimeMillis = System.currentTimeMillis();
        c(sb.toString());
        ey.a((int) (System.currentTimeMillis() - jCurrentTimeMillis), this.m);
    }

    private void a(f9 f9Var, im imVar, h4 h4Var) {
        this.e.a("GDTSDK", IGDTSDK.class, new b(h4Var, imVar, f9Var));
        this.e.a("GDTAdDataHelper", IGDTAdDataHelper.class, new c(h4Var));
        b();
    }

    public void a(h8 h8Var, String str) {
        if (!this.w || h8Var == null) {
            return;
        }
        jn jnVar = new jn();
        jn jnVar2 = new jn();
        jnVar2.a("eventType", h8Var.a);
        jnVar2.a("eventAction", str);
        jnVar2.a("eventParams", h8Var.c);
        jnVar.a(NotificationCompat.CATEGORY_EVENT, jnVar2.a());
        jnVar.a("compoId", String.valueOf(h8Var.d()));
        a7 a7VarC = h8Var.c();
        if (a7VarC != null) {
            jnVar.a("complexComponentId", a7VarC.a());
        }
        in.b().a("event_onEventEmited", jnVar.toString()).c().a(this.e, this.m);
    }

    public void a(long j) {
        this.d = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Handler handler;
        if (k() || (handler = this.h) == null || i <= 0) {
            return;
        }
        handler.postDelayed(this.x, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Config.PACKAGE_NAME, str);
            jSONObject.putOpt("s", Integer.valueOf(i));
            jSONObject.putOpt("p", Integer.valueOf(i2));
            d(str2 + "(" + jSONObject + ")");
        } catch (JSONException unused) {
        }
    }

    public Object a(String str, String str2, Object... objArr) {
        return in.b().a(null, str2, objArr).d().a(str + Config.replace + str2, objArr).c().a(this.e, this.m);
    }
}
