package com.style.widget.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.util.bq;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i {
    private static final String a = i.class.getSimpleName();
    private static final int k = 132043942;
    private Context c;
    private double d;
    private String e;
    private Dialog f;
    private ax g;
    private ProgressBar i;
    private h j;
    private boolean b = false;
    private bq h = bq.a();

    private i(Context context, double d, String str) {
        this.c = context;
        this.d = d;
        this.e = str;
    }

    public static i a(Context context, String str) {
        return new i(context, 0.9d, str);
    }

    public void a(double d) {
        this.d = d;
    }

    public void a(h hVar) {
        this.j = hVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.c == null) {
            return;
        }
        try {
            this.f = new Dialog(this.c);
            this.f.requestWindowFeature(1);
            Window window = this.f.getWindow();
            if (window != null) {
                if (this.b) {
                    window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                }
                window.getDecorView().setPadding(0, 0, 0, 0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(-1);
                gradientDrawable.setCornerRadii(new float[]{40.0f, 40.0f, 40.0f, 40.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                window.getDecorView().setBackground(gradientDrawable);
                WindowManager.LayoutParams attributes = window.getAttributes();
                DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
                attributes.width = displayMetrics.widthPixels;
                attributes.gravity = 80;
                double d = displayMetrics.heightPixels;
                double d2 = this.d;
                Double.isNaN(d);
                attributes.height = (int) (d * d2);
                window.setAttributes(attributes);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.c);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            RelativeLayout relativeLayout2 = new RelativeLayout(this.c);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, a(this.c, 50.0f)));
            relativeLayout2.setId(k);
            TextView textView = new TextView(this.c);
            textView.setText("应用权限");
            textView.setTextSize(2, 18.0f);
            textView.setTextColor(-16777216);
            textView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            relativeLayout2.addView(textView, layoutParams);
            ImageView imageView = new ImageView(this.c);
            imageView.setClickable(true);
            com.component.b.a.a().a(imageView, "ic_black_cross");
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setOnClickListener(new j(this));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(this.c, 26.0f), a(this.c, 26.0f));
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.setMargins(0, 0, a(this.c, 10.0f), 0);
            relativeLayout2.addView(imageView, layoutParams2);
            relativeLayout.addView(relativeLayout2);
            this.i = new ProgressBar(this.c);
            this.i.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            relativeLayout.addView(this.i, layoutParams3);
            ax.c cVar = new ax.c();
            cVar.a = false;
            this.g = ax.a(this.c, bq.a(), true, true, cVar);
            this.g.a = this.e;
            this.g.getSettings().setUseWideViewPort(true);
            this.g.getSettings().setBuiltInZoomControls(true);
            try {
                this.g.loadUrl(this.e);
                WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.g.getSettings(), false);
            } catch (Exception e) {
                this.h.a(a, e.getMessage());
            }
            this.g.setWebViewClient(new k(this));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams4.addRule(3, relativeLayout2.getId());
            relativeLayout.addView(this.g, layoutParams4);
            this.f.setContentView(relativeLayout);
            this.f.setOnDismissListener(new l(this));
            if (this.j != null) {
                this.j.a();
            }
            this.f.show();
        } catch (Exception e2) {
            this.h.b(a, e2.getMessage());
        }
    }

    private int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void b() {
        if (this.f != null && this.f.isShowing()) {
            try {
                if (this.g != null) {
                    this.g.removeAllViews();
                    ((ViewGroup) this.g.getParent()).removeView(this.g);
                    this.g.stopLoading();
                    this.g.destroy();
                    this.g = null;
                }
            } catch (Exception e) {
                this.h.a(a, e.getMessage());
            }
            if (this.i != null) {
                this.i = null;
            }
        }
        if (this.j != null) {
            this.j.b();
        }
    }
}
