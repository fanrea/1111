package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.component.a.a.b;
import com.qq.e.comm.plugin.mh;
import com.qq.e.comm.plugin.w40;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hg extends u4<b> {
    private static final List<String> H;
    public static final boolean I;
    private final Map<String, cm> G = new HashMap();

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new hg();
        }
    }

    /* compiled from: A */
    public interface c {
        void a(int i);

        void onPlayStateChange(j40 j40Var, int i);
    }

    /* compiled from: A */
    public interface d {
        void a(mh mhVar);
    }

    static {
        ArrayList arrayList = new ArrayList();
        H = arrayList;
        I = r1.d().f().a("svsl", 1) != 1;
        arrayList.add("adModel");
        arrayList.add(TextureRenderKeys.KEY_IS_CALLBACK);
        arrayList.add("muted");
        arrayList.add("93");
        arrayList.add(b.e.a);
        arrayList.add("replay");
    }

    protected hg() {
    }

    public boolean c(String str, cm cmVar) throws JSONException {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "adModel":
                ((b) this.A).a((h4) cmVar.e(new JSONObject[0]));
                return true;
            case "replay":
                ((b) this.A).b(cmVar.f(new JSONObject[0]) == 1);
                return true;
            case "callback":
                ((b) this.A).a((yg) cmVar.e(new JSONObject[0]));
                return true;
            case "14":
                ((b) this.A).a(v30.c(cmVar) | 17);
                return true;
            case "91":
                ((b) this.A).a(cmVar.toString());
                return true;
            case "93":
                ((b) this.A).b(cmVar.f(new JSONObject[0]));
                return true;
            case "muted":
                ((b) this.A).a(cmVar.f(new JSONObject[0]) == 1);
                return true;
            case "speed":
                ((b) this.A).a(cmVar.b(new JSONObject[0]));
                return true;
            default:
                return false;
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void a(z10 z10Var) {
        f10 f10Var;
        Map<String, f10> map = z10Var.c;
        if (map != null && (f10Var = map.get("68")) != null && f10Var.f(new JSONObject[0]) == -1) {
            ((b) this.A).d();
        }
        super.a(z10Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        super.M();
        lb lbVar = this.t;
        if (lbVar != null && lbVar.a()) {
            ((b) A()).setWillNotDraw(false);
        }
        ((b) this.A).g();
    }

    private boolean d(String str, cm cmVar) {
        if (((b) this.A).h()) {
            if (!"91".equals(str) || TextUtils.isEmpty(cmVar.toString())) {
                if (H.contains(str)) {
                    this.G.put(str, cmVar);
                    return true;
                }
            } else {
                ((b) this.A).d();
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b b(e8 e8Var) {
        b bVar = new b(this, e8Var.d(), e8Var);
        if (p8.b) {
            bVar.d();
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void N() {
        Map<String, cm> map = this.G;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, cm> entry : this.G.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        this.G.clear();
    }

    /* compiled from: A */
    public static class b extends FrameLayout implements dl<hg> {
        private final FrameLayout.LayoutParams a;
        private final e8 b;
        private boolean c;
        private hg d;
        private mh e;
        private boolean f;
        private ImageView g;
        private boolean h;
        private d i;
        private boolean j;
        private yg m;
        private c n;

        public void e() {
            if (hg.I) {
                return;
            }
            this.e.a(new C0710b());
            this.e.a(new c());
        }

        public b(hg hgVar, Context context, e8 e8Var) {
            super(context);
            this.a = new FrameLayout.LayoutParams(-1, -1, 17);
            this.c = false;
            this.f = false;
            this.h = false;
            setTag("GDTDLVideoView");
            this.d = hgVar;
            this.b = e8Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h() {
            return !this.f;
        }

        @Override // android.view.View
        public void setBackgroundColor(int i) {
            this.d.f(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            if (h()) {
                return;
            }
            ViewParent parent = this.e.r().getParent();
            if (parent == this) {
                if (this.h) {
                    this.e.r().setLayoutParams(this.a);
                    this.g.setLayoutParams(this.a);
                }
            } else {
                if (parent != null) {
                    b50.a(this.e.r());
                    b50.a(this.g);
                }
                addView(this.e.r(), this.a);
                addView(this.g, this.a);
            }
            this.h = false;
        }

        /* compiled from: A */
        class a implements yg {
            final /* synthetic */ yg a;

            a(yg ygVar) {
                this.a = ygVar;
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoReady() {
                this.a.onVideoReady();
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoStart() {
                this.a.onVideoStart();
                b.this.g.setVisibility(8);
            }

            @Override // com.qq.e.comm.plugin.yg
            public void a() {
                this.a.a();
                b.this.g.setVisibility(0);
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoStop() {
                this.a.onVideoStop();
                b.this.g.setVisibility(0);
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoPause() {
                this.a.onVideoPause();
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoResume() {
                this.a.onVideoResume();
            }

            @Override // com.qq.e.comm.plugin.yg
            public void d() {
                this.a.d();
            }

            @Override // com.qq.e.comm.plugin.yg
            public void b() {
                this.a.b();
            }

            @Override // com.qq.e.comm.plugin.yg
            public void c() {
                this.a.c();
            }

            @Override // com.qq.e.comm.plugin.yg
            public void a(int i, Exception exc) {
                this.a.a(i, exc);
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.hg$b$b, reason: collision with other inner class name */
        class C0710b implements yg {
            C0710b() {
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoReady() {
                if (b.this.n != null) {
                    b.this.n.onPlayStateChange(j40.PREPARED, b.this.b().getCurrentPosition());
                }
                if (b.this.m != null) {
                    b.this.m.onVideoReady();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoStart() {
                b.this.g.setVisibility(8);
                if (b.this.n != null) {
                    b.this.n.onPlayStateChange(b.this.b().getVideoState(), b.this.b().getCurrentPosition());
                }
                if (b.this.m != null) {
                    b.this.m.onVideoStart();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void a() {
                b.this.g.setVisibility(0);
                if (b.this.n != null) {
                    b.this.n.onPlayStateChange(b.this.b().getVideoState(), b.this.b().getCurrentPosition());
                }
                if (b.this.m != null) {
                    b.this.m.a();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoStop() {
                b.this.g.setVisibility(0);
                if (b.this.n != null) {
                    b.this.n.onPlayStateChange(b.this.b().getVideoState(), b.this.b().i());
                }
                if (b.this.m != null) {
                    b.this.m.onVideoStop();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoPause() {
                if (b.this.n != null) {
                    b.this.n.onPlayStateChange(b.this.b().getVideoState(), b.this.b().i());
                }
                if (b.this.m != null) {
                    b.this.m.onVideoPause();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void onVideoResume() {
                if (b.this.n != null) {
                    b.this.n.onPlayStateChange(b.this.b().getVideoState(), b.this.b().i());
                }
                if (b.this.m != null) {
                    b.this.m.onVideoResume();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void d() {
                if (b.this.m != null) {
                    b.this.m.d();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void b() {
                if (b.this.m != null) {
                    b.this.m.b();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void c() {
                if (b.this.m != null) {
                    b.this.m.c();
                }
            }

            @Override // com.qq.e.comm.plugin.yg
            public void a(int i, Exception exc) {
                if (b.this.n != null) {
                    b.this.n.onPlayStateChange(b.this.b().getVideoState(), b.this.b().getCurrentPosition());
                }
                if (b.this.m != null) {
                    b.this.m.a(i, exc);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void d() {
            if (h()) {
                this.g = new ImageView(getContext());
                this.e = new mh(getContext(), this.b.b());
                this.f = true;
                e();
                this.d.N();
                d dVar = this.i;
                if (dVar != null) {
                    dVar.a(this.e);
                }
            }
        }

        @Deprecated
        public boolean c() {
            return this.c;
        }

        /* compiled from: A */
        class c implements mh.l {
            c() {
            }

            @Override // com.qq.e.comm.plugin.mh.l
            public void a(int i) {
                if (b.this.n != null) {
                    b.this.n.a(i);
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            v40<V> v40VarV = this.d.v();
            if (v40VarV == 0) {
                super.onMeasure(i, i2);
                return;
            }
            Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
            super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
            Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
            if (pairA != null) {
                super.onMeasure(((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue());
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int width;
            int height;
            xj xjVarS = this.d.s();
            if (xjVarS != null) {
                width = getWidth();
                height = getHeight();
                xjVarS.a(canvas, width, height);
            } else {
                width = 0;
                height = 0;
            }
            super.draw(canvas);
            if (xjVarS != null) {
                xjVarS.b(canvas, width, height);
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            hg hgVar = this.d;
            if (hgVar != null) {
                hgVar.a(view, i);
            }
        }

        public boolean f() {
            return this.j;
        }

        public mh b() {
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z) {
            this.j = z;
        }

        public void a() {
            mh mhVar = this.e;
            if (mhVar != null) {
                mhVar.free();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i) {
            dy dyVar;
            if (this.e == null) {
                return;
            }
            this.c = true;
            if (i == 2) {
                dyVar = dy.CENTER_CROP;
            } else if (i != 3) {
                dyVar = dy.DEFAULT;
            } else {
                a(1);
                dyVar = dy.CROP;
            }
            this.e.a(dyVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            mh mhVar = this.e;
            if (mhVar == null) {
                return;
            }
            mhVar.setDataSource(str);
            this.e.play();
        }

        public void a(h4 h4Var) throws JSONException {
            this.e.a(h4Var);
            h4Var.b(true);
            e2 e2VarK = h4Var.k();
            if (e2VarK == e2.REWARDVIDEOAD || e2VarK == e2.UNIFIED_INTERSTITIAL_FULLSCREEN) {
                mm.a().a(h4Var.c0(), this.g);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            this.a.gravity = i;
            this.h = true;
        }

        public void a(d dVar) {
            this.i = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            mh mhVar = this.e;
            if (mhVar == null) {
                return;
            }
            if (z) {
                mhVar.a();
            } else {
                mhVar.c();
            }
        }

        public void a(c cVar) {
            this.n = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f) {
            mh mhVar = this.e;
            if (mhVar != null) {
                mhVar.setSpeed(f);
            }
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(hg hgVar) {
            this.d = hgVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(yg ygVar) {
            if (!hg.I) {
                this.m = ygVar;
            } else {
                this.e.a(new a(ygVar));
            }
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        if (d(str, cmVar) || c(str, cmVar)) {
            return true;
        }
        return super.a(str, cmVar);
    }

    @Override // com.qq.e.comm.plugin.w40, com.qq.e.comm.plugin.fm
    public void a(String str, JSONObject jSONObject) {
        if ("initVideo".equals(str)) {
            ((b) this.A).d();
            ((b) this.A).g();
        }
    }
}
