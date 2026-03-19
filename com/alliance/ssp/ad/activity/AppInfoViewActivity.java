package com.alliance.ssp.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.p.f;
import com.alliance.ssp.ad.r.i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class AppInfoViewActivity extends Activity {
    public static com.alliance.ssp.ad.t.a f;
    public static NMRewardVideoActivity g;
    public SAAllianceAdData a;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public FrameLayout e;

    public static class b {
        public String a;
        public String b;
        public String c = null;
        public String d;
        public boolean e;

        public b(String str, String str2, String str3, String str4, boolean z) {
            this.a = str;
            this.b = str2;
            this.d = str4;
            this.e = z;
        }
    }

    public interface c {
        void a();
    }

    public class d extends GradientDrawable {
        public View a;

        public d(Context context, View view) {
            this.a = view;
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            super.draw(canvas);
            Paint paint = new Paint();
            int i = this.a.getLayoutParams().width;
            int i2 = this.a.getLayoutParams().height;
            paint.setColor(Color.parseColor("#7c7c7c"));
            paint.setStyle(Paint.Style.STROKE);
            AppInfoViewActivity appInfoViewActivity = AppInfoViewActivity.this;
            com.alliance.ssp.ad.t.a aVar = AppInfoViewActivity.f;
            paint.setStrokeWidth(appInfoViewActivity.a(1.0f));
            float f = i;
            float f2 = f / 2.0f;
            float fA = AppInfoViewActivity.this.a(4.0f);
            float f3 = fA + 0.0f;
            float f4 = (i2 / 2.0f) + fA;
            canvas.drawLine(0.0f, f3, f2, f4, paint);
            canvas.drawLine(f2, f4, f, f3, paint);
        }
    }

    public class e extends GradientDrawable {
        public View a;

        public e(Context context, View view) {
            this.a = view;
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            super.draw(canvas);
            Paint paint = new Paint();
            int i = this.a.getLayoutParams().width;
            int i2 = this.a.getLayoutParams().height;
            AppInfoViewActivity appInfoViewActivity = AppInfoViewActivity.this;
            com.alliance.ssp.ad.t.a aVar = AppInfoViewActivity.f;
            int iA = appInfoViewActivity.a(6.0f);
            paint.setColor(Color.parseColor("#7c7c7c"));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(AppInfoViewActivity.this.a(1.0f));
            float f = iA;
            float f2 = i - iA;
            float f3 = i2 - iA;
            canvas.drawLine(f, f, f2, f3, paint);
            canvas.drawLine(f, f3, f2, f, paint);
        }
    }

    public final int a(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b(LinearLayout linearLayout) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 86.0f);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        textView.setText("应用详情");
        textView.setTextColor(Color.parseColor("#1e1e1e"));
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
    }

    public final void c(LinearLayout linearLayout) {
        int iA = a(24.0f);
        Button button = new Button(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        button.setLayoutParams(layoutParams);
        e eVar = new e(this, button);
        eVar.setShape(1);
        eVar.setColor(-1);
        eVar.setStroke(12, -1);
        button.setBackground(eVar);
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 12.0f);
        layoutParams2.gravity = 8388629;
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        linearLayout.addView(frameLayout);
    }

    public final void d(LinearLayout linearLayout) {
        int iA = a(24.0f);
        Button button = new Button(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        button.setLayoutParams(layoutParams);
        e eVar = new e(this, button);
        eVar.setShape(1);
        eVar.setColor(-1);
        eVar.setStroke(12, -1);
        button.setBackground(eVar);
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 5.0f);
        layoutParams2.gravity = 8388629;
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        });
        linearLayout.addView(frameLayout);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0318  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.activity.AppInfoViewActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e.removeAllViews();
        f = null;
        g = null;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        finish();
    }

    public final LinearLayout a(int i, int i2, float f2, int i3) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2, f2);
        linearLayout.setOrientation(i3);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public final void a(View view, float f2, float f3, float f4, float f5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{a(f2), a(f2), a(f3), a(f3), a(f4), a(f4), a(f5), a(f5)});
        view.setBackground(gradientDrawable);
    }

    public class a implements i.a {
        public final /* synthetic */ ImageView a;

        public a(ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Bitmap bitmap) {
            int i = l.a;
            AppInfoViewActivity appInfoViewActivity = AppInfoViewActivity.this;
            com.alliance.ssp.ad.t.a aVar = AppInfoViewActivity.f;
            this.a.setImageBitmap(appInfoViewActivity.a(bitmap, appInfoViewActivity.a(56.0f), AppInfoViewActivity.this.a(56.0f), AppInfoViewActivity.this.a(16.0f)));
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            Objects.toString(exc);
            int i = l.a;
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(AppInfoViewActivity.this.getResources(), R.drawable.nmadssp_ic_launcher);
            if (bitmapDecodeResource != null) {
                AppInfoViewActivity appInfoViewActivity = AppInfoViewActivity.this;
                com.alliance.ssp.ad.t.a aVar = AppInfoViewActivity.f;
                this.a.setImageBitmap(appInfoViewActivity.a(bitmapDecodeResource, appInfoViewActivity.a(56.0f), AppInfoViewActivity.this.a(56.0f), AppInfoViewActivity.this.a(16.0f)));
            }
        }
    }

    public final void b(LinearLayout linearLayout, final c cVar) {
        int iA = a(16.0f);
        Button button = new Button(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        button.setLayoutParams(layoutParams);
        d dVar = new d(this, button);
        dVar.setShape(1);
        dVar.setColor(-1);
        dVar.setStroke(12, -1);
        button.setBackground(dVar);
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 2.0f);
        layoutParams2.gravity = 8388629;
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(button);
        linearLayout.addView(frameLayout);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cVar.a();
            }
        });
    }

    public final Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        float f2 = i;
        float f3 = i2;
        float height = (1.0f * f3) / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale((f2 * 1.0f) / bitmap.getWidth(), height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f4 = i3;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f2, f3), f4, f4, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        finish();
    }

    public final void a(LinearLayout linearLayout, final c cVar) {
        int iA = a(16.0f);
        Button button = new Button(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        button.setLayoutParams(layoutParams);
        d dVar = new d(this, button);
        dVar.setShape(1);
        dVar.setColor(-1);
        dVar.setStroke(12, -1);
        button.setBackground(dVar);
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 5.0f);
        layoutParams2.gravity = 8388629;
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(button);
        linearLayout.addView(frameLayout);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cVar.a();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinearLayout b(Context context, String str, String str2, String str3, String str4, boolean z) {
        final TextView textView;
        new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayoutA = a(-1, -1, 1.0f, 0);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
        textView2.setTextSize(14.0f);
        textView2.setTextColor(-16777216);
        textView2.setText(str);
        linearLayoutA.addView(textView2);
        if (str2 != null) {
            TextView textView3 = new TextView(context);
            textView3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
            textView3.setGravity(GravityCompat.END);
            textView3.setTextSize(14.0f);
            textView3.setTextColor(Color.parseColor("#7c7c7c"));
            textView3.setText(str2);
            linearLayoutA.addView(textView3);
        }
        linearLayout.addView(linearLayoutA);
        if (z) {
            if (str3 != null) {
                TextView textView4 = new TextView(context);
                textView4.setText(str3);
                textView4.setTextSize(12.0f);
                textView4.setTextColor(Color.parseColor("#7c7c7c"));
                textView4.setVisibility(8);
                linearLayout.addView(textView4);
                textView = textView4;
            } else if (str4 != null) {
                WebView webViewA = a(str4);
                linearLayout.addView(webViewA);
                webViewA.setVisibility(8);
                textView = webViewA;
            } else {
                TextView textView5 = new TextView(context);
                textView5.setText("素材采集中...");
                textView5.setTextSize(12.0f);
                textView5.setTextColor(Color.parseColor("#7c7c7c"));
                textView5.setVisibility(8);
                linearLayout.addView(textView5);
                textView = textView5;
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppInfoViewActivity.b(textView, view);
                }
            });
            b(linearLayoutA, new c() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda2
                @Override // com.alliance.ssp.ad.activity.AppInfoViewActivity.c
                public final void a() {
                    AppInfoViewActivity.b(textView);
                }
            });
        }
        linearLayout.addView(a());
        return linearLayout;
    }

    public final void a(LinearLayout linearLayout) {
        final ImageView imageView = new ImageView(this);
        new LinearLayout.LayoutParams(-2, -2).gravity = 17;
        Runnable runnable = new Runnable() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(imageView);
            }
        };
        SAAllianceAdData sAAllianceAdData = this.a;
        if (sAAllianceAdData != null && sAAllianceAdData.getMaterial() != null && this.a.getMaterial().getIconurl() != null && !this.a.getMaterial().getIconurl().isEmpty()) {
            n.d.a.execute(runnable);
        } else {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.nmadssp_ic_launcher);
            if (bitmapDecodeResource != null) {
                imageView.setImageBitmap(a(bitmapDecodeResource, a(56.0f), a(56.0f), a(16.0f)));
            }
        }
        linearLayout.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ImageView imageView) {
        int i = l.a;
        try {
            i.a().a(this.a.getMaterial().getIconurl(), new a(imageView));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinearLayout a(Context context, String str, String str2, String str3, String str4, boolean z) {
        final TextView textView;
        new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayoutA = a(-1, -1, 1.0f, 0);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
        textView2.setTextSize(14.0f);
        textView2.setTextColor(-16777216);
        textView2.setText(str);
        linearLayoutA.addView(textView2);
        if (str2 != null) {
            TextView textView3 = new TextView(context);
            textView3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
            textView3.setGravity(GravityCompat.END);
            textView3.setTextSize(14.0f);
            textView3.setTextColor(Color.parseColor("#7c7c7c"));
            textView3.setText(str2);
            linearLayoutA.addView(textView3);
        }
        linearLayout.addView(linearLayoutA);
        if (z) {
            if (str3 != null) {
                TextView textView4 = new TextView(context);
                textView4.setText(str3);
                textView4.setTextSize(12.0f);
                textView4.setTextColor(Color.parseColor("#7c7c7c"));
                textView4.setVisibility(8);
                linearLayout.addView(textView4);
                textView = textView4;
            } else if (str4 != null) {
                WebView webViewA = a(str4);
                linearLayout.addView(webViewA);
                webViewA.setVisibility(8);
                textView = webViewA;
            } else {
                TextView textView5 = new TextView(context);
                textView5.setText("素材采集中...");
                textView5.setTextSize(12.0f);
                textView5.setTextColor(Color.parseColor("#7c7c7c"));
                textView5.setVisibility(8);
                linearLayout.addView(textView5);
                textView = textView5;
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppInfoViewActivity.a(textView, view);
                }
            });
            a(linearLayoutA, new c() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda6
                @Override // com.alliance.ssp.ad.activity.AppInfoViewActivity.c
                public final void a() {
                    AppInfoViewActivity.a(textView);
                }
            });
        }
        linearLayout.addView(a());
        return linearLayout;
    }

    public static /* synthetic */ void b(View view, View view2) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static /* synthetic */ void b(View view) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final List<b> b() {
        SAAllianceAdData sAAllianceAdData = this.a;
        if (sAAllianceAdData == null || sAAllianceAdData.getMaterial() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b("应用名称", this.a.getMaterial().getApkname(), null, null, false));
        arrayList.add(new b("版本", this.a.getMaterial().getVersionName(), null, null, false));
        arrayList.add(new b("开发者名称", this.a.getMaterial().getAppPublisher(), null, null, false));
        arrayList.add(new b("权限列表", null, null, this.a.getMaterial().getPermissionUrl(), true));
        arrayList.add(new b("隐私协议", null, null, this.a.getMaterial().getPrivacyUrl(), true));
        arrayList.add(new b("产品介绍", null, null, this.a.getMaterial().getAppIntro(), true));
        return arrayList;
    }

    public static /* synthetic */ void a(View view, View view2) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static /* synthetic */ void a(View view) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final WebView a(final String str) {
        final WebView webView = new WebView(this);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.setWebViewClient(new WebViewClient());
        f.a(webView, this.c, this.d);
        final String tagCode = this.a.getTagCode();
        runOnUiThread(new Runnable() { // from class: com.alliance.ssp.ad.activity.AppInfoViewActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.a(tagCode, webView, str);
            }
        });
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, WebView webView, String str2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (str != null && !str.isEmpty() && this.b == 0) {
            try {
                HashMap map = new HashMap();
                map.put("X-Requested-With", URLEncoder.encode(str, "UTF-8"));
                webView.loadUrl(str2, map);
                return;
            } catch (Exception e2) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("AppInfoViewActivity 001: ")), e2);
                return;
            }
        }
        webView.loadUrl(str2);
    }

    public final FrameLayout a() {
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
        layoutParams.setMargins(0, a(4.0f), 0, a(4.0f));
        layoutParams.gravity = 80;
        frameLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#edeeeeee"));
        frameLayout.setBackground(gradientDrawable);
        return frameLayout;
    }
}
