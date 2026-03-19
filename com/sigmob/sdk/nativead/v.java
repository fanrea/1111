package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.common.ak;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.views.an;
import com.sigmob.sdk.base.views.au;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class v extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int a = 100;
    public static final int b = 70;
    public static final int c = 30;
    public static final int d = 12;
    private static com.sigmob.sdk.base.views.v m;
    private static ak.a n;
    private final int e;
    private com.sigmob.sdk.base.views.v f;
    private TextView g;
    private ak.a h;
    private boolean i;
    private ClickCommon j;
    private c k;
    private boolean l;
    private final int o;
    private final int p;
    private final int q;
    private boolean r;
    private Boolean s;
    private final int t;
    private String title;
    private final int u;

    /* renamed from: com.sigmob.sdk.nativead.v$1, reason: invalid class name */
    class AnonymousClass1 implements ak.b {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            v.this.j.sld = "5";
            v.this.e();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || v.this.i) {
                return;
            }
            v.this.i = true;
            Number number = info.get("turn_x");
            Number number2 = info.get("turn_y");
            Number number3 = info.get("turn_z");
            Number number4 = info.get("turn_time");
            if (number != null) {
                v.this.j.turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                v.this.j.turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                v.this.j.turn_z = String.valueOf(number3.intValue());
            }
            v.this.j.turn_time = String.valueOf(number4);
            v.this.f.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.v$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.nativead.v$2, reason: invalid class name */
    class AnonymousClass2 implements ak.b {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (v.this.i) {
                return;
            }
            v.this.j.sld = "2";
            v.this.e();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            Number number = info.get("x_max_acc");
            Number number2 = info.get("y_max_acc");
            Number number3 = info.get("z_max_acc");
            if (number != null && v.this.j != null) {
                v.this.j.x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null && v.this.j != null) {
                v.this.j.y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null && v.this.j != null) {
                v.this.j.z_max_acc = String.valueOf(number3.intValue());
            }
            v.this.f.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.v$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.nativead.v$3, reason: invalid class name */
    class AnonymousClass3 implements ak.b {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            v.this.j.sld = "5";
            v.this.e();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
            if (v.this.f instanceof com.sigmob.sdk.base.views.ak) {
                ((com.sigmob.sdk.base.views.ak) v.this.f).a(progress);
            }
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || v.this.i) {
                return;
            }
            v.this.i = true;
            Number number = info.get("turn_x");
            Number number2 = info.get("turn_y");
            Number number3 = info.get("turn_z");
            Number number4 = info.get("turn_time");
            if (number != null) {
                v.this.j.turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                v.this.j.turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                v.this.j.turn_z = String.valueOf(number3.intValue());
            }
            v.this.j.turn_time = String.valueOf(number4);
            v.this.f.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.v$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.nativead.v$4, reason: invalid class name */
    class AnonymousClass4 implements ak.b {
        AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            v.this.j.sld = "2";
            v.this.e();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
            if (v.this.f instanceof an) {
                ((an) v.this.f).a(progress);
            }
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || v.this.i) {
                return;
            }
            v.this.i = true;
            Number number = info.get("x_max_acc");
            Number number2 = info.get("y_max_acc");
            Number number3 = info.get("z_max_acc");
            if (number != null && v.this.j != null) {
                v.this.j.x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null && v.this.j != null) {
                v.this.j.y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null && v.this.j != null) {
                v.this.j.z_max_acc = String.valueOf(number3.intValue());
            }
            v.this.f.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.v$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    public v(Context context, int referenceWidth, int referenceHeight) {
        super(context);
        this.i = false;
        this.s = null;
        this.o = Dips.dipsToIntPixels(100.0f, context);
        this.p = Dips.dipsToIntPixels(70.0f, context);
        this.q = Dips.dipsToIntPixels(30.0f, context);
        this.e = Dips.dipsToIntPixels(0.5f, getContext());
        this.t = referenceWidth;
        this.u = referenceHeight;
    }

    private void a(int sensitivity) {
        this.f = new au(getContext());
        this.title = "扭动或点击前往";
        ak.a aVar = new ak.a(getContext(), new AnonymousClass1(), ak.c.WRING);
        this.h = aVar;
        aVar.c(sensitivity);
    }

    private void b(int sensitivity) {
        this.f = new com.sigmob.sdk.base.views.ac(getContext());
        this.title = "摇一摇或点击前往";
        ak.a aVar = new ak.a(getContext(), new AnonymousClass2(), ak.c.SHAKE);
        this.h = aVar;
        aVar.c(sensitivity);
    }

    private void c(int sensitivity) {
        this.f = new com.sigmob.sdk.base.views.ak(getContext());
        this.title = "前倾或点击前往";
        ak.a aVar = new ak.a(getContext(), new AnonymousClass3(), ak.c.SLOPE);
        this.h = aVar;
        aVar.c(sensitivity);
    }

    private void d() {
        this.r = true;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private void d(int sensitivity) {
        this.f = new an(getContext());
        this.title = "晃动或点击前往";
        ak.a aVar = new ak.a(getContext(), new AnonymousClass4(), ak.c.SWING);
        this.h = aVar;
        aVar.c(sensitivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c cVar = this.k;
        if (cVar != null) {
            cVar.onAction();
        }
    }

    protected void a() {
        if (this.l && this.f.getVisibility() == 0) {
            com.sigmob.sdk.base.views.v vVar = m;
            if (vVar != null && vVar != this.f) {
                vVar.b();
                m = null;
            }
            ak.a aVar = n;
            if (aVar != null && aVar != this.h) {
                aVar.b();
                n = null;
            }
            this.i = false;
            if (this.h != null && this.l && com.sigmob.sdk.base.utils.o.b(this)) {
                ak.a aVar2 = n;
                ak.a aVar3 = this.h;
                if (aVar2 != aVar3) {
                    n = aVar3;
                    aVar3.a();
                }
                com.sigmob.sdk.base.views.v vVar2 = this.f;
                if (vVar2 == null || vVar2 == m || vVar2.getVisibility() != 0) {
                    return;
                }
                com.sigmob.sdk.base.views.v vVar3 = this.f;
                m = vVar3;
                vVar3.a();
            }
        }
    }

    public boolean a(int widgetId, int sensitivity, ClickCommon clickCommon) {
        this.j = clickCommon;
        switch (widgetId) {
            case 138731:
                d(sensitivity);
                break;
            case 138733:
                c(sensitivity);
                break;
            case 138757:
                b(sensitivity);
                break;
            case 138758:
                a(sensitivity);
                break;
        }
        if (this.f == null) {
            return false;
        }
        this.j.widget_id = widgetId;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f.setId(ClientMetadata.generateViewId());
        addView(this.f, layoutParams);
        TextView textView = new TextView(getContext());
        this.g = textView;
        textView.setText(this.title);
        this.g.setTextSize(2, 12.0f);
        this.g.setTextColor(-1);
        this.g.setTypeface(Typeface.DEFAULT_BOLD);
        this.g.setId(ClientMetadata.generateViewId());
        return true;
    }

    public void b() {
        com.sigmob.sdk.base.views.v vVar = this.f;
        if (vVar != null) {
            vVar.b();
        }
        ak.a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
        com.sigmob.sdk.base.views.v vVar2 = m;
        if (vVar2 != null && vVar2 == this.f) {
            m = null;
        }
        ak.a aVar2 = n;
        if (aVar2 == null || aVar2 != this.h) {
            return;
        }
        n = null;
    }

    public void c() {
        com.sigmob.sdk.base.views.v vVar = m;
        if (vVar != null && vVar == this.f) {
            m = null;
        }
        ak.a aVar = n;
        if (aVar != null && aVar == this.h) {
            n = null;
        }
        com.sigmob.sdk.base.views.v vVar2 = this.f;
        if (vVar2 != null) {
            vVar2.b();
            com.sigmob.sdk.base.utils.o.a(this.f);
            this.f = null;
        }
        TextView textView = this.g;
        if (textView != null) {
            com.sigmob.sdk.base.utils.o.a(textView);
            this.g = null;
        }
        ak.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.c();
            this.h = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = false;
        this.r = false;
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.r) {
            this.r = false;
            int iMin = Math.min(this.t, this.u);
            com.sigmob.sdk.base.utils.o.a(this.g);
            if (iMin < this.q) {
                com.sigmob.sdk.base.views.v vVar = this.f;
                if (vVar != null) {
                    vVar.b();
                    this.f.setVisibility(4);
                }
                ak.a aVar = this.h;
                if (aVar != null) {
                    aVar.b();
                }
                this.s = false;
                return;
            }
            com.sigmob.sdk.base.views.v vVar2 = this.f;
            if (vVar2 == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = vVar2.getLayoutParams();
            if (layoutParams != null && layoutParams.width != iMin) {
                layoutParams.width = iMin;
                layoutParams.height = iMin;
                this.f.setLayoutParams(layoutParams);
            }
            Boolean bool = this.s;
            if (bool != null && !bool.booleanValue()) {
                this.f.a();
                this.f.setVisibility(0);
                ak.a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
            if (iMin < this.o) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) getParent();
            Context context = getContext();
            if (context == null || viewGroup == null || this.g == null) {
                return;
            }
            int top = getTop() + this.f.getMeasuredHeight();
            com.sigmob.sdk.base.utils.o.a(this.g);
            int drawableId = ResourceUtil.getDrawableId(context, "sig_layout_background_radius");
            if (drawableId > 0) {
                this.g.setBackgroundResource(drawableId);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            layoutParams2.setMargins(0, top + this.e, 0, 0);
            viewGroup.addView(this.g, layoutParams2);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.r = true;
    }

    public void setMotionActionListener(c listener) {
        this.k = listener;
    }
}
