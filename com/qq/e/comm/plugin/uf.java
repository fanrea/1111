package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.w40;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class uf extends u4<c> {

    /* compiled from: A */
    public static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new uf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c b(e8 e8Var) {
        c cVar = new c(e8Var.d());
        cVar.setVisibility(8);
        return cVar;
    }

    uf() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        super.M();
        lb lbVar = this.t;
        if (lbVar == null || !lbVar.a() || A() == 0) {
            return;
        }
        ((c) A()).setWillNotDraw(false);
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void m() {
        h8 h8Var;
        if (this.u != null && K()) {
            List<h8> listT = t();
            if (listT.size() > 0) {
                h8Var = listT.get(0);
            } else {
                h8Var = new h8(1, "miitActivity");
            }
            ((c) this.A).setOnClickListener(new a(h8Var));
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "adModel":
                ((c) this.A).a((h4) cmVar.e(new JSONObject[0]));
                return true;
            case "14":
                ((c) this.A).setGravity(v30.c(cmVar));
                return true;
            case "51":
                ((c) this.A).setOrientation(cmVar.f(new JSONObject[0]));
                return true;
            case "72":
                ((c) this.A).c(cmVar.a(new JSONObject[0]));
                return true;
            case "73":
                ((c) this.A).a(v30.b(cmVar));
                return true;
            case "75":
                ((c) this.A).b(cmVar.f(new JSONObject[0]));
                return true;
            case "type":
                ((c) this.A).d(cmVar.f(new JSONObject[0]));
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        final /* synthetic */ h8 a;

        a(h8 h8Var) {
            this.a = h8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (uf.this.u != null) {
                uf.this.u.b(uf.this, this.a);
            }
        }
    }

    /* compiled from: A */
    static class c extends LinearLayout implements dl<uf> {
        private static int h;
        private static int i;
        private int a;
        private TextView b;
        private int c;
        private int d;
        private int e;
        private uf f;
        private View.OnClickListener g;

        public c(Context context) {
            super(context);
            this.a = 0;
            this.b = new TextView(getContext());
            if (i == 0) {
                i = zu.a(9.0d);
            }
            if (h == 0) {
                h = zu.a(12.0d);
            }
            this.c = -1;
            this.d = i;
            setOrientation(1);
        }

        /* compiled from: A */
        class a implements View.OnTouchListener {
            final /* synthetic */ TextView a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;

            a(TextView textView, int i, int i2) {
                this.a = textView;
                this.b = i;
                this.c = i2;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int offsetForHorizontal;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 || c.this.g == null) {
                        return false;
                    }
                    c.this.g.onClick(view);
                    return true;
                }
                Layout layout = this.a.getLayout();
                return layout != null && (offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) y), x)) >= this.b && offsetForHorizontal < this.c;
            }
        }

        public void d(int i2) {
            this.a = i2;
        }

        public void c(int i2) {
            this.d = i2;
        }

        public void b(int i2) {
            this.e = i2;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.g = onClickListener;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int width;
            int height;
            xj xjVarS = this.f.s();
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
        protected void onVisibilityChanged(View view, int i2) {
            uf ufVar = this.f;
            if (ufVar != null) {
                ufVar.a(view, i2);
            }
        }

        private void a(SpannableStringBuilder spannableStringBuilder, i3 i3Var) {
            String str;
            int i2 = this.a;
            String str2 = i2 == 1 ? "%s | %s | %s | 适龄%s | " : i2 == 2 ? "%s | %s | 适龄%s | " : i2 == 3 ? "开发者：%s | 应用版本：%s | 适龄%s | " : "应用名称：%s | 开发者：%s | 应用版本：%s | 适用年龄：%s | ";
            if (i2 != 2 && i2 != 3) {
                str = String.format(str2, i3Var.a(), i3Var.b(), i3Var.j(), i3Var.i());
            } else {
                str = String.format(str2, i3Var.b(), i3Var.j(), i3Var.i());
            }
            spannableStringBuilder.append((CharSequence) m10.c(str));
        }

        private void a(SpannableStringBuilder spannableStringBuilder) {
            String str;
            String str2;
            String str3;
            if (this.a == 0) {
                str = "权限详情";
                str2 = "隐私协议";
                str3 = "功能介绍";
            } else {
                str = "权限";
                str2 = "隐私";
                str3 = "功能";
            }
            if (Build.VERSION.SDK_INT >= 21) {
                spannableStringBuilder.append(str, new UnderlineSpan(), 33);
                spannableStringBuilder.append(" | ");
                spannableStringBuilder.append(str2, new UnderlineSpan(), 33);
                spannableStringBuilder.append(" | ");
                spannableStringBuilder.append(str3, new UnderlineSpan(), 33);
                spannableStringBuilder.append(" | ");
                spannableStringBuilder.append("备案信息", new UnderlineSpan(), 33);
                return;
            }
            spannableStringBuilder.append((CharSequence) String.format("%s > | %s > | %s > | %s >", str, str2, str3, "备案信息"));
        }

        private void a(TextView textView, int i2, int i3) {
            textView.setOnTouchListener(new a(textView, i2, i3));
        }

        public void a(int[] iArr) {
            if (iArr == null || iArr.length != 4) {
                return;
            }
            this.b.setShadowLayer(iArr[2], iArr[0], iArr[1], iArr[3]);
        }

        public void a(int i2) {
            this.c = i2;
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(uf ufVar) {
            this.f = ufVar;
        }

        public void a(h4 h4Var) {
            l3 l3VarO;
            i3 i3VarB;
            if (h4Var == null || (l3VarO = h4Var.o()) == null || (i3VarB = l3VarO.b()) == null) {
                return;
            }
            this.b.setTextColor(this.c);
            this.b.setTextSize(0, this.d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            a(spannableStringBuilder, i3VarB);
            int length = spannableStringBuilder.length();
            a(spannableStringBuilder);
            int length2 = spannableStringBuilder.length();
            this.b.setText(spannableStringBuilder);
            a(this.b, length, length2);
            int i2 = this.e;
            if (i2 > 0) {
                this.b.setMaxLines(i2);
                this.b.setEllipsize(TextUtils.TruncateAt.END);
            }
            addView(this.b, new LinearLayout.LayoutParams(-2, -2));
            setVisibility(0);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void b(int[] iArr) {
        ((c) this.A).a(iArr);
    }
}
