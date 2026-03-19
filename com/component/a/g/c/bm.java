package com.component.a.g.c;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mobads.container.s.ab;
import com.baidu.mobstat.forbes.Config;
import com.component.a.a.b;
import com.component.a.g.c.e;
import com.component.feed.ae;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bm extends e {
    public static final String a = "shake_view";
    public static final String b = "feed_shake_view";
    public static final String c = "render_shake_view";
    public static final String d = "front_shake_view";
    public static final String e = "cover_shake_view";
    public static final String f = "shake_gt_view";
    public static final String g = "mix_interact_view";
    public static final String h = "on_shake";
    private com.baidu.mobads.container.s.ab i;
    private final a j;

    public bm(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar, a aVar2) {
        super(context, jVar, aVar);
        this.j = aVar2;
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        if (eVar == null || this.mAdInfo == null) {
            return null;
        }
        try {
            String strM = eVar.m("");
            int iE = eVar.e(-1);
            if (TextUtils.equals("shake_view", strM) || TextUtils.equals(c, strM) || TextUtils.equals(d, strM) || TextUtils.equals(e, strM) || TextUtils.equals(b, strM)) {
                boolean z = true;
                if (iE == 1) {
                    String strO = eVar.o("");
                    if (!TextUtils.isEmpty(strO)) {
                        com.baidu.mobads.container.util.d.d.a(this.mAppContext).e(strO);
                    }
                    ab.b bVar = new ab.b();
                    JSONObject jSONObjectC = eVar.c();
                    if (jSONObjectC != null) {
                        bVar.f(jSONObjectC.optInt(Config.INPUT_DEF_VERSION, 2));
                        if (this.j != null) {
                            bVar.g(jSONObjectC.optInt("logoSize", this.j.b));
                        }
                        bVar.a((float) jSONObjectC.optDouble("velocity", 7.0d));
                        bVar.m(jSONObjectC.optInt("vibrate", 1));
                        bVar.c(jSONObjectC.optInt("open_func", 0) == 1);
                        bVar.n(jSONObjectC.optInt("interval_time", 190));
                        bVar.o(jSONObjectC.optInt("detection_times", 1));
                        bVar.c((float) jSONObjectC.optDouble(b.e.a, 6.0d));
                        bVar.d((float) jSONObjectC.optDouble("shake_angle", 0.0d));
                        bVar.e((float) jSONObjectC.optDouble("shake_optime", 0.0d));
                        bVar.g((float) jSONObjectC.optDouble("startup_rate", 4.0d));
                        bVar.f((float) jSONObjectC.optDouble("twoway_angle", 35.0d));
                        bVar.d(jSONObjectC.optInt("twoway_switch", 0) == 1);
                        bVar.p(jSONObjectC.optInt("delay_time", 0));
                        bVar.q(jSONObjectC.optInt(com.baidu.mobads.container.adrequest.n.m, 2000));
                    }
                    if (eVar.e(1) != 1) {
                        z = false;
                    }
                    bVar.b(z);
                    this.i = a(this.mAppContext, bVar, strM, new bn(this, eVar));
                    this.i.j();
                    return this.i;
                }
            }
            if (g.equals(strM)) {
                return new com.baidu.mobads.container.s.g(this.mAppContext, eVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        if (dVar == null) {
            return;
        }
        com.component.a.f.e eVarF = dVar.f();
        View viewE = dVar.e();
        if (eVarF != null && viewE != null && TextUtils.equals(f, eVarF.m("")) && this.i != null && (viewE instanceof ImageView)) {
            this.i.a = (ImageView) viewE;
        }
    }

    @Override // com.component.a.g.c.e
    public Animator initViewAnimation(View view, com.component.a.f.e eVar) {
        if (TextUtils.equals(f, eVar.m("")) && this.i != null && this.i.a != null) {
            return this.i.n();
        }
        return super.initViewAnimation(view, eVar);
    }

    private com.baidu.mobads.container.s.ab a(Context context, ab.b bVar, String str, com.baidu.mobads.container.util.g.b bVar2) {
        if (TextUtils.equals(b, str)) {
            return new com.component.feed.ae(context, bVar, true, new ae.a(bVar2));
        }
        return new com.baidu.mobads.container.s.ab(context, bVar, true, bVar2);
    }

    public static class a {
        private int a;
        private int b;
        private float c;

        public a a(int i) {
            this.a = i;
            return this;
        }

        public a b(int i) {
            this.b = i;
            return this;
        }

        public a a(float f) {
            this.c = f;
            return this;
        }
    }
}
