package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.bv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class aj extends RelativeLayout {
    private static final int c = 52;
    private static final int d = 132343252;
    private TextView a;
    private Context b;
    private b e;

    public interface b {
        void a();
    }

    public aj(Context context) {
        super(context);
        this.b = context;
        setBackgroundColor(Color.parseColor("#66CDAA"));
        a();
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.setText(str);
            this.a.invalidate();
        }
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    protected void a() {
        int iB = bv.b(this.b, 52);
        View aVar = new a(this.b, Color.parseColor("#FFFFFF"));
        aVar.setId(d);
        addView(aVar, new RelativeLayout.LayoutParams(iB, -1));
        aVar.setOnClickListener(new ak(this));
        this.a = new TextView(this.b);
        this.a.setTextSize(1, 16.0f);
        this.a.setLines(1);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        this.a.setTextColor(-1);
        this.a.setText("");
        this.a.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.a(this.b).width() - (iB * 2), -1);
        layoutParams.addRule(14);
        addView(this.a, layoutParams);
    }

    private static class a extends View {
        private Paint a;
        private int b;

        public a(Context context, int i) {
            super(context);
            this.b = i;
        }

        private Paint a() {
            if (this.a == null) {
                this.a = new Paint();
                this.a.setStyle(Paint.Style.STROKE);
                this.a.setColor(this.b);
                this.a.setAlpha(255);
                this.a.setAntiAlias(true);
                this.a.setStrokeWidth((int) bv.e(getContext()));
            }
            return this.a;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawLine(bv.b(getContext(), 20), bv.b(getContext(), 23), bv.b(getContext(), 28), bv.b(getContext(), 31), a());
            canvas.drawLine(bv.b(getContext(), 20), bv.b(getContext(), 23), bv.b(getContext(), 28), bv.b(getContext(), 15), a());
        }
    }
}
