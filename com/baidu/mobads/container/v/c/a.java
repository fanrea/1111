package com.baidu.mobads.container.v.c;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.bridge.w;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.g.c;
import com.baidu.mobads.container.v.d;
import com.bytedance.sdk.djx.core.log.ILogConst;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends d {
    private boolean e;
    private boolean f;
    private c g;
    private int h;

    public a(t tVar) {
        super(tVar);
        this.e = true;
        this.h = 1;
    }

    @Override // com.baidu.mobads.container.v.d, com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = "XSplashMouldAdContainer";
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x013a  */
    @Override // com.baidu.mobads.container.v.d, com.baidu.mobads.container.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doStartOnUIThread() {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.v.c.a.doStartOnUIThread():void");
    }

    @Override // com.baidu.mobads.container.k
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g != null) {
            this.g.d();
            this.g.b((View) null);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.g != null && this.h == 2) {
            if (z) {
                this.g.a();
            } else {
                this.g.b();
            }
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mLimitRegionClick = jSONObject.optInt(k.CC_REGION_CLICK, this.mLimitRegionClick ? 1 : 0) == 1;
                int iOptInt = jSONObject.optInt(k.CC_REGION_CLICK, this.mDisplayClickButton ? 2 : 0);
                this.mDisplayClickButton = iOptInt == 1 || iOptInt == 2;
                addSlideView();
            } catch (Throwable th) {
                bq.a().a(th);
            }
        }
    }

    public void e() {
        if (this.mBridgeHandler != null) {
            this.mBridgeHandler.h(w.m);
        }
        if (this.g != null && this.h != 2) {
            this.g.d();
            this.g.b((View) null);
            this.g = null;
        }
        sendSplashShakeLog("onadclick");
    }

    public void f() {
        if (this.mBridgeHandler != null) {
            this.mBridgeHandler.h(w.n);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void handlePause(j jVar) {
        super.handlePause(jVar);
        if (this.mWebView != null) {
            this.mWebView.onPause();
        }
    }

    @Override // com.baidu.mobads.container.k
    public void handleResume(j jVar) {
        super.handleResume(jVar);
        if (this.mWebView != null) {
            this.mWebView.onResume();
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onAdClick(j jVar, View view) {
        sendRsplashExpClickLog(2);
    }

    @Override // com.baidu.mobads.container.k
    protected int getSplashLogType() {
        return 2;
    }

    @Override // com.baidu.mobads.container.k
    protected void onSplashAdClick(String str, com.baidu.mobads.container.o.b bVar) {
        if (TextUtils.equals(str, ILogConst.DRAW_ENTER_TYPE_SLIDE)) {
            f();
        }
    }
}
