package com.baidu.mobads.container.landingpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.sdk.api.IActivityImpl;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class AppPriActivity implements IActivityImpl {
    protected static final int ACTIONBAR_VIEW_ID = 1010;
    public static final String PRIVACY_LINK = "privacy_link";
    private static final String TAG = "AppPriActivity";
    private bq mAdLogger = bq.a();
    private LinearLayout mLlContainer;
    private aj mNativeActionBar;
    private RelativeLayout mRlContainer;
    private com.baidu.mobads.container.ax mXMyWebView;
    public Activity proxyActivity;
    RelativeLayout wvTool;

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.proxyActivity = activity;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        Intent intent = this.proxyActivity.getIntent();
        if (intent != null) {
            addGlobalViews(intent.getStringExtra("privacy_link"));
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
    }

    private void addGlobalViews(String str) {
        this.wvTool = new RelativeLayout(this.proxyActivity);
        this.mLlContainer = new LinearLayout(this.proxyActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mLlContainer.setOrientation(1);
        this.wvTool.addView(this.mLlContainer, layoutParams);
        initActionBar();
        this.mLlContainer.addView(this.mNativeActionBar, new RelativeLayout.LayoutParams(-1, bv.b((Context) this.proxyActivity, 46)));
        this.mRlContainer = initFrame(str);
        this.mLlContainer.addView(this.mRlContainer, new RelativeLayout.LayoutParams(-1, -1));
        this.wvTool.setBackgroundColor(-1);
        this.proxyActivity.setContentView(this.wvTool);
    }

    private RelativeLayout initFrame(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a aVar = new a(this.proxyActivity);
        ax.c cVar = new ax.c();
        cVar.a = false;
        this.mXMyWebView = com.baidu.mobads.container.ax.a(this.proxyActivity, bq.a(), true, true, cVar);
        this.mXMyWebView.a = str;
        this.mXMyWebView.getSettings().setUseWideViewPort(true);
        this.mXMyWebView.getSettings().setBuiltInZoomControls(true);
        try {
            this.mXMyWebView.loadUrl(str);
        } catch (Exception e) {
        }
        try {
            WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.mXMyWebView.getSettings(), false);
        } catch (Exception e2) {
            this.mAdLogger.a(TAG, e2.getMessage());
        }
        this.mXMyWebView.setWebChromeClient(new ab(this, aVar));
        RelativeLayout relativeLayout = new RelativeLayout(this.proxyActivity);
        relativeLayout.addView(this.mXMyWebView, new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(aVar, new RelativeLayout.LayoutParams(-1, bv.b(this.proxyActivity.getApplicationContext(), 2)));
        return relativeLayout;
    }

    private void initActionBar() {
        this.mNativeActionBar = new aj(this.proxyActivity);
        this.mNativeActionBar.setId(1010);
        this.mNativeActionBar.a(new ac(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        this.proxyActivity.finish();
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        try {
            if (this.mXMyWebView != null) {
                this.mXMyWebView.removeAllViews();
                ((ViewGroup) this.mXMyWebView.getParent()).removeView(this.mXMyWebView);
                this.mXMyWebView.stopLoading();
                this.mXMyWebView.destroy();
                this.mXMyWebView = null;
            }
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
        sendLpBroadcast();
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i, int i2) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
    }

    class a extends View {
        private Paint b;
        private int c;
        private int d;

        public a(Context context) {
            super(context);
            this.c = 0;
            this.d = 0;
            this.b = new Paint();
            this.b.setColor(Color.parseColor("#483D8B"));
            this.d = bv.a(AppPriActivity.this.proxyActivity.getApplicationContext()).width();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, (this.d * this.c) / 100.0f, getLayoutParams().height, this.b);
        }

        public void a(int i) {
            if (i != this.c) {
                this.c = i;
                postInvalidate();
            }
        }
    }

    private void sendLpBroadcast() {
        if (this.proxyActivity != null) {
            Intent intent = new Intent();
            intent.setAction("lp_close");
            this.proxyActivity.sendBroadcast(intent);
        }
    }
}
