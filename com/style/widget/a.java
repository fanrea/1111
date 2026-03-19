package com.style.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends PopupWindow {
    private ab a;
    private final Context b;
    private b c;

    /* renamed from: com.style.widget.a$a, reason: collision with other inner class name */
    public enum EnumC0796a {
        WITH_CLOSE_ICON,
        WITH_CANCEL_TEXT
    }

    public interface b {
        void a(String str);
    }

    public interface c extends b {
        void a();

        void b();
    }

    private a(Context context, EnumC0796a enumC0796a) {
        super(context);
        this.b = context;
        int i = 1;
        if (!(context instanceof Activity)) {
            bq.a().c("仅接受Activity类型的Context");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ab.a);
            this.a = new ab();
            new com.component.c.b(context).a(this.a, intentFilter);
            if (enumC0796a == EnumC0796a.WITH_CANCEL_TEXT || enumC0796a != EnumC0796a.WITH_CLOSE_ICON) {
                i = 0;
            }
            Intent intent = new Intent();
            intent.putExtra("uiflag", i);
            com.baidu.mobads.container.util.h.e(context, intent);
            return;
        }
        setContentView(b());
        setWidth(-2);
        setHeight(-2);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setAlpha(120);
        setBackgroundDrawable(colorDrawable);
        setOutsideTouchable(true);
        setFocusable(true);
    }

    private a(Context context, String str) {
        super(context);
        this.b = context;
        if (!(context instanceof Activity)) {
            bq.a().c("仅接受Activity类型的Context");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ab.a);
            this.a = new ab();
            new com.component.c.b(context).a(this.a, intentFilter);
            Intent intent = new Intent();
            intent.putExtra("json", str);
            com.baidu.mobads.container.util.h.e(context, intent);
            return;
        }
        setContentView(new com.component.a.a(com.component.a.i.n.b(str)).a(context, new com.style.widget.b(this)).b());
        setWidth(-2);
        setHeight(-2);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setAlpha(120);
        setBackgroundDrawable(colorDrawable);
        setOutsideTouchable(true);
        setFocusable(true);
    }

    public void a(b bVar) {
        this.c = bVar;
        if (this.a != null) {
            this.a.a(this.b, bVar);
        }
    }

    private View b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setId(67);
        ImageView imageView = new ImageView(this.b);
        imageView.setId(18);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.b, 25.0f), com.baidu.mobads.container.util.ab.a(this.b, 25.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.bottomMargin = com.baidu.mobads.container.util.ab.a(this.b, 5.0f);
        com.component.b.a.a().a(imageView, "ic_white_cross_circle_shadow");
        relativeLayout.addView(imageView, layoutParams);
        imageView.setVisibility(0);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
        relativeLayout2.setBackgroundColor(-1);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f}, null, null));
        shapeDrawable.getPaint().setColor(-1);
        relativeLayout2.setBackgroundDrawable(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, 18);
        LinearLayout linearLayoutA = a("ic_gray_unlike", "不感兴趣", true);
        linearLayoutA.setId(20);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(10);
        relativeLayout2.addView(linearLayoutA, layoutParams3);
        View view = new View(this.b);
        view.setId(32);
        view.setBackgroundColor(-394759);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, com.baidu.mobads.container.util.ab.a(this.b, 1.5f));
        layoutParams4.addRule(3, 20);
        int iA = com.baidu.mobads.container.util.ab.a(this.b, 10.0f);
        layoutParams4.bottomMargin = iA;
        layoutParams4.topMargin = iA;
        relativeLayout2.addView(view, layoutParams4);
        LinearLayout linearLayoutA2 = a("ic_gray_low_quality", "内容质量差", true);
        linearLayoutA2.setId(21);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, 32);
        layoutParams5.addRule(5, 32);
        relativeLayout2.addView(linearLayoutA2, layoutParams5);
        View view2 = new View(this.b);
        view2.setId(33);
        view2.setBackgroundColor(-394759);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.baidu.mobads.container.util.ab.a(this.b, 1.5f));
        layoutParams6.addRule(3, 21);
        int iA2 = com.baidu.mobads.container.util.ab.a(this.b, 10.0f);
        layoutParams6.bottomMargin = iA2;
        layoutParams6.topMargin = iA2;
        relativeLayout2.addView(view2, layoutParams6);
        LinearLayout linearLayoutA3 = a("ic_gray_repeat", "推荐重复", true);
        linearLayoutA3.setId(22);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(3, 33);
        layoutParams7.addRule(5, 33);
        relativeLayout2.addView(linearLayoutA3, layoutParams7);
        View view3 = new View(this.b);
        view3.setId(34);
        view3.setBackgroundColor(-394759);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.baidu.mobads.container.util.ab.a(this.b, 1.0f));
        layoutParams8.addRule(3, 22);
        int iA3 = com.baidu.mobads.container.util.ab.a(this.b, 10.0f);
        layoutParams8.bottomMargin = iA3;
        layoutParams8.topMargin = iA3;
        relativeLayout2.addView(view3, layoutParams8);
        LinearLayout linearLayoutA4 = a("ic_gray_complaints", "投诉广告", false);
        linearLayoutA4.setId(23);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams9.addRule(3, 34);
        layoutParams9.addRule(5, 34);
        layoutParams9.bottomMargin = com.baidu.mobads.container.util.ab.a(this.b, 6.0f);
        relativeLayout2.addView(linearLayoutA4, layoutParams9);
        TextView textViewA = a(48, "低俗色情");
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(3, 23);
        layoutParams10.addRule(5, 23);
        relativeLayout2.addView(textViewA, layoutParams10);
        TextView textViewA2 = a(49, "违法违规");
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        int iA4 = com.baidu.mobads.container.util.ab.a(this.b, 8.0f);
        layoutParams11.rightMargin = iA4;
        layoutParams11.leftMargin = iA4;
        layoutParams11.addRule(1, 48);
        layoutParams11.addRule(8, 48);
        relativeLayout2.addView(textViewA2, layoutParams11);
        TextView textViewA3 = a(50, "虚假欺诈");
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.addRule(1, 49);
        layoutParams12.addRule(8, 49);
        relativeLayout2.addView(textViewA3, layoutParams12);
        TextView textViewA4 = a(51, "诱导点击");
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(3, 48);
        layoutParams13.addRule(5, 48);
        layoutParams13.topMargin = com.baidu.mobads.container.util.ab.a(this.b, 6.0f);
        relativeLayout2.addView(textViewA4, layoutParams13);
        TextView textViewA5 = a(52, "疑似抄袭");
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams14.addRule(1, 51);
        layoutParams14.addRule(8, 51);
        layoutParams14.addRule(5, 49);
        relativeLayout2.addView(textViewA5, layoutParams14);
        View view4 = new View(this.b);
        view4.setId(35);
        view4.setBackgroundColor(-394759);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-1, com.baidu.mobads.container.util.ab.a(this.b, 1.0f));
        layoutParams15.addRule(3, 52);
        int iA5 = com.baidu.mobads.container.util.ab.a(this.b, 10.0f);
        layoutParams15.bottomMargin = iA5;
        layoutParams15.topMargin = iA5;
        relativeLayout2.addView(view4, layoutParams15);
        TextView textView = new TextView(this.b);
        textView.setText("取消");
        textView.setId(66);
        textView.setTextSize(17.0f);
        textView.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(3, 35);
        layoutParams16.addRule(14);
        relativeLayout2.addView(textView, layoutParams16);
        textView.setVisibility(0);
        relativeLayout2.setPadding(com.baidu.mobads.container.util.ab.a(this.b, 15.0f), com.baidu.mobads.container.util.ab.a(this.b, 13.0f), 0, com.baidu.mobads.container.util.ab.a(this.b, 10.0f));
        relativeLayout.addView(relativeLayout2, layoutParams2);
        View.OnClickListener cVar = new com.style.widget.c(this);
        textView.setOnClickListener(cVar);
        relativeLayout.setOnClickListener(cVar);
        relativeLayout2.setOnClickListener(new d(this));
        return relativeLayout;
    }

    private TextView a(int i, String str) {
        TextView textView = new TextView(this.b);
        textView.setId(i);
        textView.setTextColor(-10066330);
        textView.setText(str);
        textView.setBackgroundColor(-723724);
        textView.setPadding(com.baidu.mobads.container.util.ab.a(this.b, 18.0f), com.baidu.mobads.container.util.ab.a(this.b, 5.0f), com.baidu.mobads.container.util.ab.a(this.b, 18.0f), com.baidu.mobads.container.util.ab.a(this.b, 5.0f));
        textView.setOnClickListener(new e(this, str));
        return textView;
    }

    private LinearLayout a(String str, String str2, boolean z) {
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(this.b);
        com.component.b.a.a().a(imageView, str);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.b, 18.0f), com.baidu.mobads.container.util.ab.a(this.b, 18.0f)));
        TextView textView = new TextView(this.b);
        textView.setText(str2);
        textView.setTextSize(16.0f);
        textView.setTextColor(-10066330);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.baidu.mobads.container.util.ab.a(this.b, 6.0f);
        linearLayout.addView(textView, layoutParams);
        if (z) {
            linearLayout.setOnClickListener(new f(this, str2));
        }
        return linearLayout;
    }

    public void a() {
        try {
            WindowManager.LayoutParams attributes = ((Activity) this.b).getWindow().getAttributes();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(attributes);
            attributes.alpha = 0.7f;
            ((Activity) this.b).getWindow().addFlags(2);
            ((Activity) this.b).getWindow().setAttributes(attributes);
            setOnDismissListener(new g(this, layoutParams));
            showAtLocation(((Activity) this.b).getWindow().getDecorView(), 17, 0, 0);
            if (this.c instanceof c) {
                ((c) this.c).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(com.baidu.mobads.container.e.a aVar) {
        try {
            Dialog dialogD = aVar.d();
            WindowManager.LayoutParams attributes = dialogD.getWindow().getAttributes();
            new WindowManager.LayoutParams().copyFrom(attributes);
            dialogD.getWindow().addFlags(2);
            dialogD.getWindow().setAttributes(attributes);
            setOnDismissListener(new h(this, dialogD));
            showAtLocation(dialogD.getWindow().getDecorView(), 17, 0, 0);
            if (this.c instanceof c) {
                ((c) this.c).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static a a(Context context) {
        return a(context, EnumC0796a.WITH_CLOSE_ICON);
    }

    public static a a(Context context, EnumC0796a enumC0796a) {
        a aVar;
        a aVar2 = null;
        try {
            aVar = new a(context, enumC0796a);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (enumC0796a == EnumC0796a.WITH_CLOSE_ICON) {
                aVar.a(66);
            } else {
                aVar.a(18);
            }
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            aVar2 = aVar;
            th.printStackTrace();
            return aVar2;
        }
    }

    public static a a(Context context, String str) {
        try {
            return new a(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void a(int i) {
        View viewFindViewById;
        View contentView = getContentView();
        if (contentView != null && (viewFindViewById = contentView.findViewById(i)) != null) {
            viewFindViewById.setVisibility(8);
        }
    }
}
