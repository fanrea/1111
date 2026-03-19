package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.w40;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class gg extends u4<b> {
    private String G;

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new gg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b b(e8 e8Var) {
        return new b(e8Var.d());
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        super.M();
        if (this.f.f()) {
            return;
        }
        ((b) this.A).b();
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        if (!str.equals("twistType")) {
            return super.a(str, cmVar);
        }
        this.G = cmVar.toString();
        zl zlVarJ = c().j();
        if (zlVarJ.d()) {
            this.G = "doubleLine";
        }
        if (!"doubleLine".equals(this.G)) {
            return true;
        }
        zlVarJ.c();
        return true;
    }

    @Override // com.qq.e.comm.plugin.w40
    public void k() {
        super.k();
        ((b) this.A).b();
    }

    /* compiled from: A */
    static class b extends FrameLayout implements dl<gg> {
        private gg a;
        private am b;

        public b(Context context) {
            this(context, null);
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e8 e8VarC;
                b.this.removeAllViews();
                if (b.this.b == null || (e8VarC = b.this.a.c()) == null) {
                    return;
                }
                e8VarC.j().b(b.this.b);
                b.this.b = null;
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            gg ggVar = this.a;
            if (ggVar != null) {
                ggVar.a(view, i);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            a();
            int iMin = Math.min(this.a.w().g(), this.a.w().h());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin, iMin);
            layoutParams.gravity = 17;
            if (!"doubleArrow".equals(this.a.G)) {
                if (!"3d".equals(this.a.G)) {
                    if ("doubleLine".equals(this.a.G)) {
                        addView(new h6(getContext(), iMin), layoutParams);
                        this.b = new za(getContext(), iMin);
                        this.a.c().j().a(this.b);
                        addView((View) this.b, layoutParams);
                        return;
                    }
                    return;
                }
                this.b = new y20(getContext(), iMin);
                this.a.c().j().a(this.b);
                addView((View) this.b, layoutParams);
                return;
            }
            addView(new h6(getContext(), iMin), layoutParams);
            this.b = new ya(getContext(), iMin);
            this.a.c().j().a(this.b);
            addView((View) this.b, layoutParams);
        }

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(gg ggVar) {
            this.a = ggVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            xo.d(new a());
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        V v = this.A;
        if (v != 0) {
            ((b) v).a();
        }
        super.clear();
        this.G = null;
    }
}
