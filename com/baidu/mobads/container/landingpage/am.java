package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.bv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class am extends RelativeLayout {
    public static final String a = "{\"id\":\"lp_actionbar_view\",\"type\":\"relative\",\"w\":-1,\"h\":-1,\"margins\":[0,0,0,0],\"background\":{\"color\":\"#000000\"},\"child_view\":[{\"id\":\"lp_goback\",\"type\":\"image\",\"scale\":\"center_crop\",\"margins\":[8,0,0,0],\"gravity\":36,\"w\":22,\"h\":22,\"src\":\"@res/lp_go_back\",\"click\":\"lp_go_back\"},{\"id\":\"lp_setting_view\",\"type\":\"relative\",\"w\":60,\"h\":28,\"gravity\":40,\"margins\":[0,0,6,0],\"background\":{\"border_width\":1,\"border_color\":\"#D8D8D8\",\"alpha\":0,\"shape\":\"round_rect\",\"radius\":[12,12,12,12,12,12,12,12]},\"child_view\":[{\"id\":\"lp_three_points\",\"type\":\"image\",\"margins\":[4,0,0,0],\"w\":20,\"h\":20,\"scale\":\"center_crop\",\"gravity\":32,\"src\":\"@res/lp_three_points\",\"click\":\"lp_three_points\"},{\"id\":\"lp_devider\",\"type\":\"relative\",\"margins\":[4,0,5,0],\"w\":1,\"h\":20,\"gravity\":32,\"right\":\"lp_three_points\",\"background\":{\"color\":\"#FFFFFF\"}},{\"id\":\"lp_close\",\"type\":\"image\",\"margins\":[0,0,0,0],\"w\":20,\"h\":20,\"gravity\":32,\"right\":\"lp_devider\",\"click\":\"lp_close\",\"scale\":\"center_crop\",\"src\":\"@res/lp_close\"}]}]}";
    public static final String b = "{\"id\":\"lp_actionbar_view\",\"type\":\"relative\",\"w\":-1,\"h\":-1,\"margins\":[0,0,0,0],\"background\":{\"color\":\"#FFFFFF\"},\"child_view\":[{\"id\":\"lp_goback\",\"type\":\"image\",\"scale\":\"center_crop\",\"margins\":[8,0,0,0],\"gravity\":36,\"w\":22,\"h\":22,\"src\":\"@res/lp_go_back_light\",\"click\":\"lp_go_back\"},{\"id\":\"lp_setting_view\",\"type\":\"relative\",\"w\":60,\"h\":28,\"gravity\":40,\"margins\":[0,0,6,0],\"background\":{\"border_width\":1,\"border_color\":\"#D8D8D8\",\"alpha\":0,\"shape\":\"round_rect\",\"radius\":[12,12,12,12,12,12,12,12]},\"child_view\":[{\"id\":\"lp_three_points\",\"type\":\"image\",\"margins\":[4,0,0,0],\"w\":20,\"h\":20,\"scale\":\"center_crop\",\"gravity\":32,\"src\":\"@res/lp_three_points_light\",\"click\":\"lp_three_points\"},{\"id\":\"lp_devider\",\"type\":\"relative\",\"margins\":[4,0,5,0],\"w\":1,\"h\":20,\"gravity\":32,\"right\":\"lp_three_points\",\"background\":{\"color\":\"#FFFFFF\"}},{\"id\":\"lp_close\",\"type\":\"image\",\"margins\":[0,0,0,0],\"w\":20,\"h\":20,\"gravity\":32,\"right\":\"lp_devider\",\"click\":\"lp_close\",\"scale\":\"center_crop\",\"src\":\"@res/lp_close_light\"}]}]}";
    public static final int c = 46;
    public static final int d = 16;
    private static final int h = 132343241;
    private static final int i = 132343242;
    private static final int j = 132343243;
    private static final int k = 40;
    protected c e;
    int f;
    int g;
    private Context l;
    private App2Activity.a m;
    private TextView n;

    public interface c {
        void a();

        void b();

        void c();
    }

    public am(Context context) {
        super(context);
        this.m = new App2Activity.a(-5987164, -6842473, -11113262, -328966);
        this.f = 0;
        this.g = 0;
        this.l = context;
    }

    public am(Context context, App2Activity.a aVar) {
        this(context);
        if (aVar != null) {
            this.m = aVar;
        }
        setBackgroundColor(this.m.d);
        a();
    }

    public void a(String str) {
        if (this.n != null) {
            this.n.setText(str);
            this.n.invalidate();
        }
    }

    public void a(c cVar) {
        this.e = cVar;
    }

    protected void a() {
        int iB = bv.b(this.l, 40);
        b bVar = new b(this.l, this.m.a);
        bVar.setId(h);
        bVar.a(1);
        addView(bVar, new RelativeLayout.LayoutParams(iB, -1));
        bVar.setOnClickListener(new an(this));
        View bVar2 = new b(this.l, this.m.a);
        bVar2.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, -1);
        layoutParams.rightMargin = bv.a(this.l, 12.0f);
        layoutParams.addRule(1, h);
        addView(bVar2, layoutParams);
        bVar2.setOnClickListener(new ao(this));
        View dVar = new d(this.l, this.m.a);
        dVar.setId(j);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iB, -1);
        layoutParams2.addRule(11);
        dVar.setOnClickListener(new ap(this));
        addView(dVar, layoutParams2);
        this.n = new TextView(this.l);
        this.n.setTextSize(1, 16.0f);
        this.n.setLines(1);
        this.n.setTextSize(0, bv.b(this.l, 20));
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setGravity(16);
        this.n.setTextColor(this.m.a);
        this.n.setText("");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(0, j);
        layoutParams3.addRule(1, i);
        addView(this.n, layoutParams3);
    }

    public static class a extends View {
        static final int a = 20;
        static final int b = 23;
        static final int c = 8;
        static final int d = 4;
        static final int e = 8;

        public a(Context context) {
            super(context);
        }
    }

    private class b extends a {
        private Paint g;
        private int h;
        private int i;

        public b(Context context, int i) {
            super(context);
            this.i = 0;
            this.h = i;
        }

        public void a(int i) {
            this.i = i;
        }

        private Paint a() {
            if (this.g == null) {
                this.g = new Paint();
                this.g.setStyle(Paint.Style.STROKE);
                this.g.setColor(this.h);
                this.g.setAlpha(255);
                this.g.setAntiAlias(true);
                this.g.setStrokeWidth((int) bv.e(getContext()));
            }
            return this.g;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.i == 0) {
                canvas.drawLine(bv.b(getContext(), 12), bv.b(getContext(), 15), bv.b(getContext(), 28), bv.b(getContext(), 31), a());
                canvas.drawLine(bv.b(getContext(), 12), bv.b(getContext(), 31), bv.b(getContext(), 28), bv.b(getContext(), 15), a());
            } else if (1 == this.i) {
                canvas.drawLine(bv.b(getContext(), 24), bv.b(getContext(), 15), bv.b(getContext(), 16), bv.b(getContext(), 23), a());
                canvas.drawLine(bv.b(getContext(), 16), bv.b(getContext(), 23), bv.b(getContext(), 24), bv.b(getContext(), 31), a());
            }
        }
    }

    private class d extends a {
        private static final float g = 1.0f;
        private Paint h;
        private int i;

        public d(Context context, int i) {
            super(context);
            this.i = i;
        }

        private Paint a() {
            if (this.h == null) {
                this.h = new Paint();
                this.h.setColor(this.i);
                this.h.setAlpha(255);
                this.h.setAntiAlias(true);
            }
            return this.h;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            a(canvas, 31);
            a(canvas, 15);
            a(canvas, 23);
        }

        private void a(Canvas canvas, int i) {
            canvas.drawCircle(bv.b(getContext(), 20), bv.b(getContext(), i), (int) (bv.e(getContext()) * 1.0f), a());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f = i4 - i2;
        this.g = i5 - i3;
    }
}
