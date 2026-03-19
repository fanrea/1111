package com.sigmob.sdk.base.common;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.IntentActions;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class i {
    protected Context a;
    protected String b;
    protected RelativeLayout c;
    protected j d;
    protected f e;
    private ImageView f;
    private RelativeLayout g;
    private final WeakReference<Activity> h;
    private a i;

    public interface a {
        void onAdClicked();
    }

    protected i(Activity context, String broadcastIdentifier, j baseAdViewControllerListener) {
        this.a = context.getApplicationContext();
        this.h = new WeakReference<>(context);
        this.b = broadcastIdentifier;
        this.d = baseAdViewControllerListener;
        this.c = new RelativeLayout(this.a);
    }

    private void a() {
        ViewGroup viewGroup;
        View childAt;
        Activity activityC = com.sigmob.sdk.b.c();
        ViewGroup viewGroupM = m();
        if (activityC == null || viewGroupM == null || (viewGroup = (ViewGroup) activityC.getWindow().findViewById(R.id.content)) == null || (childAt = viewGroup.getChildAt(0)) == null) {
            return;
        }
        com.sigmob.sdk.base.blurkit.a.a(this.a);
        Bitmap bitmapA = com.sigmob.sdk.base.blurkit.a.a().a(childAt, 25);
        if (this.f == null) {
            this.f = new ImageView(this.a);
        }
        this.f.setImageBitmap(bitmapA);
    }

    public void a(final int requestCode, final int resultCode, final Intent data) {
    }

    protected void a(Context context, int orientation, Bundle intentExtras) {
        f fVar;
        if (intentExtras == null) {
            return;
        }
        try {
            if (intentExtras.getBoolean(com.sigmob.sdk.base.n.y, false)) {
                int i = context.getResources().getDisplayMetrics().widthPixels;
                int i2 = context.getResources().getDisplayMetrics().heightPixels;
                if (orientation == 6) {
                    int iMin = (Math.min(i, i2) * 85) / 100;
                    fVar = new f((iMin * 16) / 9, iMin);
                } else {
                    int iMin2 = (Math.min(i, i2) * 85) / 100;
                    fVar = new f(iMin2, (iMin2 * 16) / 9);
                }
                this.e = fVar;
                this.g = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e.a(), this.e.b());
                layoutParams.addRule(13);
                this.g.setLayoutParams(layoutParams);
                this.c.removeAllViews();
                this.c.addView(this.g);
            }
        } catch (Throwable unused) {
        }
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle outState);

    public void a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Activity activityN = n();
        if (activityN != null && Build.VERSION.SDK_INT >= 20) {
            activityN.getWindow().getDecorView().setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
        }
    }

    public void a(a eventListener) {
        this.i = eventListener;
    }

    protected void a(String action) {
        String str = this.b;
        if (str == null) {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
            return;
        }
        BaseBroadcastReceiver.a(this.a, str, action);
        if (com.sigmob.sdk.base.utils.n.b(this.i) && com.sigmob.sdk.base.utils.m.b(action) && action.equals(IntentActions.ACTION_INTERSTITIAL_CLICK)) {
            this.i.onAdClicked();
        }
    }

    protected void a(String action, int delay) {
        String str = this.b;
        if (str == null) {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        } else {
            BaseBroadcastReceiver.a(this.a, str, action, delay);
        }
    }

    protected void a(String action, Map<String, Object> extras) {
        String str = this.b;
        if (str == null) {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        } else {
            BaseBroadcastReceiver.a(this.a, str, extras, action, 0);
        }
    }

    protected boolean a(Dialog dialog) {
        if (dialog == null) {
            return false;
        }
        return dialog.isShowing();
    }

    public void b() {
        WindowManager.LayoutParams attributes = n().getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        n().getWindow().setAttributes(attributes);
    }

    public void c() {
        try {
            a();
            ImageView imageView = this.f;
            if (imageView == null) {
                return;
            }
            this.c.addView(imageView, 0, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ImageView imageView = this.f;
        if (imageView == null) {
            return;
        }
        try {
            com.sigmob.sdk.base.utils.o.a(imageView);
            this.f = null;
        } catch (Throwable unused) {
        }
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public void h() {
        this.d = null;
        if (Build.VERSION.SDK_INT >= 23) {
            Activity activityN = n();
            if (com.sigmob.sdk.base.utils.n.b(activityN)) {
                activityN.getWindow().getDecorView().setOnApplyWindowInsetsListener(null);
            }
        }
        if (com.sigmob.sdk.base.utils.n.b(this.c)) {
            this.c.removeAllViews();
        }
    }

    public abstract void i();

    public boolean j() {
        return true;
    }

    protected j k() {
        return this.d;
    }

    protected Context l() {
        return this.a;
    }

    protected ViewGroup m() {
        RelativeLayout relativeLayout = this.g;
        return relativeLayout == null ? this.c : relativeLayout;
    }

    protected Activity n() {
        Activity activityC = com.sigmob.sdk.base.utils.o.c(this.c);
        if (activityC != null) {
            return activityC;
        }
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public abstract void o();
}
