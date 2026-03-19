package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebSettings;
import com.czhj.sdk.common.utils.ReflectionUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class l extends g {
    private float a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Paint f;
    private Paint g;

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public l(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context);
        this.a = 40.0f;
        a(getSettings());
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint();
        this.f = paint;
        paint.setColor(-1);
        this.f.setAntiAlias(true);
        this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setXfermode(null);
    }

    private void a(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.d, this.a);
        path.lineTo(this.d, this.e);
        path.lineTo(this.a, this.e);
        int i = this.d;
        int i2 = this.e;
        float f = this.a;
        path.arcTo(new RectF(i, i2, i + (f * 2.0f), i2 + (f * 2.0f)), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f);
    }

    private void a(WebSettings webSettings) {
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.n.D, 2)));
            methodBuilder.addParam(Boolean.TYPE, true);
            methodBuilder.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.n.F, 2)));
            methodBuilder2.addParam(Boolean.TYPE, true);
            methodBuilder2.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setCacheMode(-1);
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowContentAccess(true);
        if (Build.VERSION.SDK_INT < 16) {
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                webSettings.setSafeBrowsingEnabled(false);
            } catch (Throwable unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                webSettings.setMixedContentMode(0);
            } catch (Throwable unused2) {
            }
        }
    }

    private void b(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.d + this.b, this.e + this.a);
        path.lineTo(this.d + this.b, this.e);
        path.lineTo((this.d + this.b) - this.a, this.e);
        int i = this.d;
        int i2 = this.b;
        float f = this.a;
        int i3 = this.e;
        path.arcTo(new RectF((i + i2) - (f * 2.0f), i3, i + i2, i3 + (f * 2.0f)), -90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f);
    }

    private void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.d, (this.e + this.c) - this.a);
        path.lineTo(this.d, this.e + this.c);
        path.lineTo(this.d + this.a, this.e + this.c);
        int i = this.d;
        int i2 = this.e;
        int i3 = this.c;
        float f = this.a;
        path.arcTo(new RectF(i, (i2 + i3) - (f * 2.0f), i + (f * 2.0f), i2 + i3), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f);
    }

    private void d(Canvas canvas) {
        Path path = new Path();
        path.moveTo((this.d + this.b) - this.a, this.e + this.c);
        path.lineTo(this.d + this.b, this.e + this.c);
        path.lineTo(this.d + this.b, (this.e + this.c) - this.a);
        int i = this.d;
        int i2 = this.b;
        float f = this.a;
        int i3 = this.e;
        int i4 = this.c;
        path.arcTo(new RectF((i + i2) - (f * 2.0f), (i3 + i4) - (f * 2.0f), i + i2, i3 + i4), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f);
    }

    @Override // com.sigmob.sdk.base.views.g
    public void a(final boolean enabled) {
        WebSettings settings;
        WebSettings.PluginState pluginState;
        if (Build.VERSION.SDK_INT >= 18) {
            return;
        }
        if (enabled) {
            settings = getSettings();
            pluginState = WebSettings.PluginState.ON;
        } else {
            settings = getSettings();
            pluginState = WebSettings.PluginState.OFF;
        }
        settings.setPluginState(pluginState);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.d = getScrollX();
        int scrollY = getScrollY();
        this.e = scrollY;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.d + this.b, scrollY + this.c, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        super.draw(canvas2);
        a(canvas2);
        b(canvas2);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.g);
        bitmapCreateBitmap.recycle();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.b = getMeasuredWidth();
        this.c = getMeasuredHeight();
    }

    public void setRadius(float radius) {
        this.a = radius;
    }
}
