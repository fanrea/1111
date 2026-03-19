package com.baidu.mobads.container.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.style.widget.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class FeedBackWindowActivity implements IActivityImpl {
    private Activity mProxyctivity;

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.mProxyctivity = activity;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        String stringExtra;
        int intExtra;
        com.style.widget.a aVarA;
        if (this.mProxyctivity == null) {
            return;
        }
        Intent intent = this.mProxyctivity.getIntent();
        if (intent != null) {
            intExtra = intent.getIntExtra("uiflag", -1);
            stringExtra = intent.getStringExtra("json");
        } else {
            stringExtra = "";
            intExtra = -1;
        }
        if (com.baidu.mobads.container.util.x.a(this.mProxyctivity).a() >= 21) {
            try {
                this.mProxyctivity.getWindow().clearFlags(67108864);
                this.mProxyctivity.getWindow().addFlags(Integer.MIN_VALUE);
                this.mProxyctivity.getWindow().getDecorView().setSystemUiVisibility(1024);
                this.mProxyctivity.getWindow().setStatusBarColor(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Window window = this.mProxyctivity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        RelativeLayout relativeLayout = new RelativeLayout(this.mProxyctivity);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (TextUtils.isEmpty(stringExtra)) {
            aVarA = null;
        } else {
            aVarA = com.style.widget.a.a(this.mProxyctivity, stringExtra);
        }
        if (intExtra == 0) {
            aVarA = com.style.widget.a.a(this.mProxyctivity, a.EnumC0796a.WITH_CANCEL_TEXT);
        } else if (intExtra == 1) {
            aVarA = com.style.widget.a.a(this.mProxyctivity, a.EnumC0796a.WITH_CLOSE_ICON);
        }
        if (aVarA == null) {
            return;
        }
        View contentView = aVarA.getContentView();
        aVarA.a(new p(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        int iA = com.baidu.mobads.container.util.ab.a(this.mProxyctivity, 10.0f);
        layoutParams.rightMargin = iA;
        layoutParams.leftMargin = iA;
        relativeLayout.addView(contentView, layoutParams);
        relativeLayout.setBackgroundColor(-1291845632);
        this.mProxyctivity.setContentView(relativeLayout);
        relativeLayout.setOnClickListener(new q(this));
        ImageView imageView = (ImageView) contentView.findViewById(18);
        if (imageView != null) {
            imageView.setOnClickListener(new r(this));
        }
        TextView textView = (TextView) contentView.findViewById(66);
        if (textView != null) {
            textView.setOnClickListener(new s(this));
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) contentView.findViewById(67);
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new t(this));
        }
        sendBroadcastWithReason("onShow");
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

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        sendBroadcastWithReason("onDismiss");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBroadcastWithReason(String str) {
        Intent intent = new Intent();
        intent.setAction(com.style.widget.ab.a);
        intent.putExtra("reason", str);
        if (this.mProxyctivity != null) {
            this.mProxyctivity.sendBroadcast(intent);
        }
    }
}
