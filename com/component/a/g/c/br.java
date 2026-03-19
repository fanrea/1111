package com.component.a.g.c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.cf;
import com.component.a.f.c;
import com.component.a.g.c.e;
import com.component.a.i.f;
import com.kuaishou.socket.nano.SocketMessages;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class br extends e {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: Access modifiers changed from: private */
    static class c {
        int a;
        int b;
        View c;
        com.component.feed.ax d;
        com.component.feed.ax e;
        final AnimatorSet f;
        boolean g;

        private c() {
            this.a = 0;
            this.b = 0;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = new AnimatorSet();
            this.g = false;
        }

        /* synthetic */ c(bs bsVar) {
            this();
        }

        public void a() {
            if (this.c != null && this.d != null && this.d.a() != null && this.e != null && this.e.a() != null) {
                cf.a(this.c, new bt(this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            AnimatorSet animatorSetA;
            AnimatorSet animatorSetA2;
            if (this.d.getWidth() != 0 && this.e.getWidth() != 0) {
                this.f.cancel();
                if (this.b == 1) {
                    this.e.setY(this.d.getBottom() - (this.e.getHeight() / 3.0f));
                    animatorSetA = com.baidu.mobads.container.util.animation.j.a((ImageView) this.d, 600, 80, 2);
                    com.component.feed.ax axVar = this.e;
                    Double.isNaN(-this.d.getHeight());
                    animatorSetA2 = com.baidu.mobads.container.util.animation.j.a(axVar, SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC, 300, 0.0f, (int) (r4 * 0.8d), 0.0f, 45.0f);
                } else {
                    this.e.setX(this.d.getLeft() - (this.e.getWidth() / 3.0f));
                    animatorSetA = com.baidu.mobads.container.util.animation.j.a((ImageView) this.d, 600, 3, 1);
                    com.component.feed.ax axVar2 = this.e;
                    Double.isNaN(this.d.getWidth());
                    animatorSetA2 = com.baidu.mobads.container.util.animation.j.a(axVar2, SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC, 300, (int) (r4 * 0.8d), 0.0f, 0.0f, 45.0f);
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setDuration(400L);
                this.f.play(animatorSetA).with(objectAnimatorOfFloat).before(animatorSetA2);
                com.component.a.i.f fVarA = com.component.a.i.f.a(this.c);
                if (fVarA != null) {
                    fVarA.a((Animator) this.f);
                }
                cf.a(this.d, new bw(this));
                return true;
            }
            return false;
        }
    }

    public static class a extends com.component.a.d.c {
        private com.component.a.a.f a;
        private com.component.a.a.q b;
        private final boolean d;
        private final int e;
        private final int f;
        private final int g;

        public a(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.d = eVar.e(-1) == 1;
            JSONObject jSONObjectC = eVar.c();
            this.e = jSONObjectC.optInt("show_position", 1);
            int iOptInt = jSONObjectC.optInt("delay_time", -1);
            if (this.e == 2 && iOptInt < 0) {
                this.f = 3000;
            } else {
                this.f = iOptInt;
            }
            int iOptInt2 = jSONObjectC.optInt(com.baidu.mobads.container.adrequest.n.m, 3000);
            if (iOptInt2 < 0) {
                this.g = 3000;
            } else {
                this.g = iOptInt2;
            }
        }

        public void a() {
            if (this.a != null) {
                this.a.f();
            }
        }

        public void b() {
            if (this.a != null) {
                this.a.s();
            }
        }

        public void a(String str) {
            if (this.b != null) {
                this.b.setText(str);
            }
        }

        public boolean c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public int e() {
            return this.f;
        }

        public int f() {
            return this.g;
        }
    }

    public br(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        String str;
        if (eVar != null) {
            String strM = eVar.m("");
            if (TextUtils.equals("slide_view", strM) || "front_slide_view".equals(strM)) {
                int iOptInt = eVar.c().optInt("style", 0);
                Iterator<com.component.a.f.e> it = eVar.iterator();
                while (it.hasNext()) {
                    com.component.a.f.e next = it.next();
                    if (TextUtils.equals("slide_guide_arrow", next.m("")) && TextUtils.isEmpty(next.o(""))) {
                        JSONObject jSONObjectF = next.f();
                        if (jSONObjectF != null) {
                            if (iOptInt == 1) {
                                str = "@res/slide_arrow_point";
                            } else {
                                str = "@res/slide_arrow_duplicate";
                            }
                            com.component.a.i.n.b(jSONObjectF, "src", str);
                        }
                        c.a aVarD = next.d();
                        aVarD.a = 500;
                        aVarD.b = 1000;
                    } else if (TextUtils.equals("slide_guide_finger", next.m(""))) {
                        c.a aVarD2 = next.d();
                        aVarD2.a = 500;
                        aVarD2.b = 1000;
                    }
                }
            } else if (TextUtils.equals("guide_slide", strM)) {
                return new a(this.mAppContext, eVar);
            }
        }
        return super.onPrepareView(view, eVar);
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        boolean z;
        int i;
        boolean z2;
        if (dVar == null) {
            return;
        }
        com.component.a.f.e eVarF = dVar.f();
        View viewE = dVar.e();
        if (eVarF == null || viewE == null) {
            return;
        }
        String strM = eVarF.m("");
        if (TextUtils.equals("slide_view", strM) || "front_slide_view".equals(strM)) {
            c cVar = new c(null);
            cVar.c = viewE;
            com.component.a.i.f.a(viewE, cVar);
            cVar.a = b(eVarF);
            cVar.b = a(eVarF);
            JSONObject jSONObjectC = eVarF.c();
            if (jSONObjectC != null) {
                boolean z3 = jSONObjectC.optInt(com.baidu.mobads.container.k.CC_REGION_CLICK, 0) == 1;
                int color = Color.parseColor(jSONObjectC.optString("foreground_color", "#FFFFFF"));
                z2 = jSONObjectC.optInt("legal_adjustment", 0) == 1;
                z = z3;
                i = color;
            } else {
                z = false;
                i = -1;
                z2 = true;
            }
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(viewE);
            View viewA = com.component.a.i.n.a(mapA, "slide_subtitle");
            if (viewA instanceof TextView) {
                ((TextView) viewA).setText(a());
            }
            View viewA2 = com.component.a.i.n.a(mapA, "slide_guide_arrow");
            if (viewA2 instanceof com.component.feed.ax) {
                cVar.d = (com.component.feed.ax) viewA2;
                com.component.a.i.f.a(viewA2, cVar);
                a(cVar.d, cVar, true);
            }
            View viewA3 = com.component.a.i.n.a(mapA, "slide_guide_finger");
            if (viewA3 instanceof com.component.feed.ax) {
                cVar.e = (com.component.feed.ax) viewA3;
                com.component.a.i.f.a(viewA3, cVar);
                a(cVar.e, cVar, false);
            }
            View viewA4 = com.component.a.i.n.a(mapA, "slide_background");
            View viewA5 = com.component.a.i.n.a(mapA, "slide_touch_view");
            if ((viewE instanceof com.component.a.d.c) && ((com.component.a.d.c) viewE).p()) {
                if (viewA4 != null) {
                    viewA4.setVisibility(8);
                }
                if (viewA5 != null) {
                    viewA5.setVisibility(8);
                    return;
                }
                return;
            }
            if (viewA5 instanceof ViewGroup) {
                com.baidu.mobads.container.s.al.a((ViewGroup) viewA5, viewA4, new bs(this, viewE, eVarF, strM), z, cVar.b, i, z2);
                return;
            }
            return;
        }
        if (TextUtils.equals("guide_slide", strM) && (viewE instanceof a)) {
            Map<View, com.component.a.f.e> mapA2 = com.component.a.i.n.a(viewE);
            View viewA6 = com.component.a.i.n.a(mapA2, "guide_slide_anim");
            if (viewA6 instanceof com.component.a.a.f) {
                ((a) viewE).a = (com.component.a.a.f) viewA6;
            }
            View viewA7 = com.component.a.i.n.a(mapA2, "guide_slide_text");
            if (viewA7 instanceof com.component.a.a.q) {
                ((a) viewE).b = (com.component.a.a.q) viewA7;
            }
        }
    }

    private void a(com.component.feed.ax axVar, c cVar, boolean z) {
        Bitmap bitmapA = axVar.a();
        if (bitmapA != null) {
            b(axVar, bitmapA, cVar.b, z);
            cVar.a();
        } else {
            com.component.a.i.f lifeCycle = axVar.getLifeCycle();
            if (lifeCycle != null) {
                lifeCycle.a((f.a) new b(cVar, z));
            }
        }
    }

    private static class b extends f.a {
        private final boolean a;
        private final c b;

        b(c cVar, boolean z) {
            this.b = cVar;
            this.a = z;
        }

        @Override // com.component.a.i.f.a
        public void a(String str, View view, com.baidu.mobads.container.util.d.c cVar) {
            Bitmap bitmapB;
            if (this.a) {
                if (this.b.a == 1) {
                    bitmapB = com.component.b.a.a().b("ic_slide_arrow_point");
                } else {
                    bitmapB = com.component.b.a.a().b("ic_slide_arrow_duplicate");
                }
            } else {
                bitmapB = com.component.b.a.a().b("ic_white_finger_shadow");
            }
            br.b(view, bitmapB, this.b.b, this.a);
            this.b.a();
        }

        @Override // com.component.a.i.f.a
        public void a(String str, View view, Bitmap bitmap) {
            br.b(view, bitmap, this.b.b, this.a);
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, Bitmap bitmap, int i, boolean z) {
        int i2;
        if ((view instanceof ImageView) && bitmap != null) {
            if (!z && i == 1) {
                i2 = -60;
            } else if (!z && i == 0) {
                i2 = 30;
            } else if (z && i == 0) {
                i2 = 90;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                ((ImageView) view).setImageBitmap(cf.a(bitmap, i2));
            }
        }
    }

    @Override // com.component.a.g.c.e
    public Animator initViewAnimation(View view, com.component.a.f.e eVar) {
        if (eVar != null) {
            String strM = eVar.m("");
            if (TextUtils.equals("slide_view", strM) || "front_slide_view".equals(strM)) {
                Object objD = com.component.a.i.f.d(view);
                if (objD instanceof c) {
                    c cVar = (c) objD;
                    if (cVar.d != null) {
                        cVar.d.setVisibility(4);
                    }
                    if (cVar.e != null) {
                        cVar.e.setVisibility(4);
                    }
                    return cVar.f;
                }
            }
        }
        return super.initViewAnimation(view, eVar);
    }

    private int a(com.component.a.f.e eVar) {
        if (eVar != null) {
            String strM = eVar.m("");
            if (TextUtils.equals("slide_view", strM) || "front_slide_view".equals(strM)) {
                return eVar.g(0);
            }
        }
        return 0;
    }

    private int b(com.component.a.f.e eVar) {
        if (eVar != null) {
            String strM = eVar.m("");
            if (TextUtils.equals("slide_view", strM) || "front_slide_view".equals(strM)) {
                return eVar.c().optInt("style");
            }
            return 0;
        }
        return 0;
    }

    private String a() {
        ab.a aVarA = com.baidu.mobads.container.util.ab.a(this.mAppContext, this.mAdInfo);
        if (aVarA == ab.a.DEEP_LINK) {
            return "跳转至第三方页面";
        }
        if (aVarA == ab.a.APP_DOWNLOAD) {
            return "下载应用";
        }
        return "跳转至详情页";
    }
}
