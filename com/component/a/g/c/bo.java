package com.component.a.g.c;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.component.a.g.c.e;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bo extends e {
    public static final int a = 1000;
    public static final String b = "跳过视频%ds";
    final Runnable c;
    public Observer d;
    private final Handler e;
    private b f;
    private RelativeLayout g;
    private TextView h;
    private com.style.a i;
    private boolean j;
    private d k;
    private int l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;

    public interface c {
        void a(int i);
    }

    public interface d {
        void a();
    }

    static /* synthetic */ int a(bo boVar, int i) {
        int i2 = boVar.n + i;
        boVar.n = i2;
        return i2;
    }

    public bo(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar, a aVar2) {
        super(context, jVar, aVar);
        this.e = new Handler();
        this.j = true;
        this.m = b;
        this.n = 0;
        this.c = new bp(this);
        this.o = 0;
        this.p = 2;
        this.q = -16776961;
        this.d = new bq(this);
        if (aVar2 == null) {
            return;
        }
        this.j = aVar2.b;
        this.f = aVar2.a;
        this.k = aVar2.c;
        this.l = aVar2.d;
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        super.onCreateView(dVar);
        if (dVar == null) {
            return;
        }
        com.component.a.f.e eVarF = dVar.f();
        if (TextUtils.equals("countdown_view", eVarF.m(""))) {
            a(eVarF);
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(dVar.e());
            for (View view : mapA.keySet()) {
                com.component.a.f.e eVar = mapA.get(view);
                if (eVar != null) {
                    if (TextUtils.equals("skip_text", eVar.m(""))) {
                        this.h = (TextView) view;
                    } else if (TextUtils.equals("skip_container", eVar.m(""))) {
                        this.g = (RelativeLayout) view;
                    }
                }
            }
            if (a()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                this.i = new com.style.a(this.mAppContext).a(this.q).b(com.baidu.mobads.container.util.ab.a(this.mAppContext, this.p));
                if (this.g != null) {
                    this.g.addView(this.i, layoutParams);
                }
            }
            if (this.f == null) {
                this.f = new b();
                this.f.b(this.l * 1000);
            }
            this.f.addObserver(this.d);
            if (this.j) {
                this.e.removeCallbacksAndMessages(null);
                this.e.postDelayed(this.c, 0L);
            }
        }
    }

    private void a(com.component.a.f.e eVar) {
        JSONObject jSONObjectC = eVar.c();
        this.o = jSONObjectC.optInt("style", 0);
        if (this.l == -1) {
            this.l = jSONObjectC.optInt("time", 5);
        }
        this.m = eVar.o(b);
        if (a()) {
            this.p = jSONObjectC.optInt("stroke_width", 2);
            this.q = Color.parseColor(jSONObjectC.optString("foreground_color", "#0000FF"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return this.o == 1;
    }

    public static class b extends Observable {
        private int a = 5000;
        private c b;

        public void a(int i) {
            setChanged();
            notifyObservers(Integer.valueOf(i));
        }

        public void b(int i) {
            this.a = i;
        }

        public void a(c cVar) {
            this.b = cVar;
        }
    }

    public static class a {
        private b a;
        private boolean b;
        private d c;
        private int d = -1;

        public a a(b bVar) {
            this.a = bVar;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public a a(d dVar) {
            this.c = dVar;
            return this;
        }

        public a a(int i) {
            this.d = i;
            return this;
        }
    }
}
