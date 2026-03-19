package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ia extends LinearLayout {
    private float a;
    private float b;
    private final int[] c;
    private int d;
    private int e;
    private float f;
    private float g;
    private final int h;
    private Drawable i;
    private Drawable j;

    public ia(Context context) {
        super(context);
        this.c = new int[4];
        this.h = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ia.this.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007a A[PHI: r4
  0x007a: PHI (r4v3 int) = (r4v2 int), (r4v7 int) binds: [B:13:0x0070, B:16:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            if (r0 == 0) goto La1
            r1 = 0
            r3 = 1
            if (r0 == r3) goto L5a
            r4 = 2
            if (r0 == r4) goto L13
            r4 = 3
            if (r0 == r4) goto L5a
            goto Lbc
        L13:
            android.graphics.drawable.Drawable r0 = r6.a(r3)
            r6.setBackgroundDrawable(r0)
            float r0 = r7.getRawX()
            float r3 = r6.a
            float r0 = r0 + r3
            float r3 = r7.getRawY()
            float r4 = r6.b
            float r3 = r3 + r4
            float r4 = r6.f
            float r5 = r6.getX()
            float r5 = r0 - r5
            float r5 = java.lang.Math.abs(r5)
            float r4 = r4 + r5
            r6.f = r4
            float r4 = r6.g
            float r5 = r6.getY()
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            float r4 = r4 + r5
            r6.g = r4
            android.view.ViewPropertyAnimator r4 = r6.animate()
            android.view.ViewPropertyAnimator r0 = r4.x(r0)
            android.view.ViewPropertyAnimator r0 = r0.y(r3)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
            r0.start()
            goto Lbc
        L5a:
            r0 = 0
            android.graphics.drawable.Drawable r0 = r6.a(r0)
            r6.setBackgroundDrawable(r0)
            float r0 = r7.getRawY()
            float r4 = r6.b
            float r0 = r0 + r4
            int[] r4 = r6.c
            r4 = r4[r3]
            float r5 = (float) r4
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 >= 0) goto L73
            goto L7a
        L73:
            int r4 = r6.e
            float r5 = (float) r4
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 <= 0) goto L7b
        L7a:
            float r0 = (float) r4
        L7b:
            int r4 = r6.d
            float r4 = (float) r4
            android.view.ViewPropertyAnimator r5 = r6.animate()
            android.view.ViewPropertyAnimator r4 = r5.x(r4)
            android.view.ViewPropertyAnimator r0 = r4.y(r0)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
            r0.start()
            float r0 = r6.f
            int r1 = r6.h
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto La0
            float r0 = r6.g
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto Lbc
        La0:
            return r3
        La1:
            float r0 = r6.getX()
            float r1 = r7.getRawX()
            float r0 = r0 - r1
            r6.a = r0
            float r0 = r6.getY()
            float r1 = r7.getRawY()
            float r0 = r0 - r1
            r6.b = r0
            r0 = 0
            r6.f = r0
            r6.g = r0
        Lbc:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.ia.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private Drawable a(boolean z) {
        Drawable drawable;
        Drawable drawable2;
        if (z && (drawable2 = this.j) != null) {
            return drawable2;
        }
        if (!z && (drawable = this.i) != null) {
            return drawable;
        }
        int iA = yu.a(getContext(), 20);
        int color = Color.parseColor(z ? "#bb000000" : "#88000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        float[] fArr = new float[8];
        float f = iA;
        fArr[0] = f;
        fArr[1] = f;
        fArr[2] = z ? f : 0.0f;
        fArr[3] = z ? f : 0.0f;
        fArr[4] = z ? f : 0.0f;
        fArr[5] = z ? f : 0.0f;
        fArr[6] = f;
        fArr[7] = f;
        gradientDrawable.setCornerRadii(fArr);
        if (z) {
            this.j = gradientDrawable;
        } else {
            this.i = gradientDrawable;
        }
        return gradientDrawable;
    }

    public void a(h4 h4Var) {
        int iA = yu.a(getContext(), 5);
        setPadding(iA, iA, iA, iA);
        setBackgroundDrawable(a(false));
        setGravity(16);
        setClickable(true);
        int[] iArr = this.c;
        iArr[0] = 0;
        iArr[1] = yu.a(getContext(), 68);
        this.c[2] = yu.a(getContext(), 124);
        this.c[3] = yu.a(getContext(), pd.a(h4Var, false) + 40);
        a();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(gw.a("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"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(yu.a(getContext(), 40), yu.a(getContext(), 28));
        layoutParams.leftMargin = yu.a(getContext(), 2);
        imageView.setLayoutParams(layoutParams);
        addView(imageView, layoutParams);
        TextView textView = new TextView(getContext());
        textView.setText("点击试玩");
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(-1);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 16;
        addView(textView, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        View view = (View) getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int[] iArr = this.c;
        this.e = height - iArr[3];
        this.d = width - iArr[2];
    }
}
