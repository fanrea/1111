package com.just.agentweb;

import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class IndicatorHandler implements IndicatorController {
    private BaseIndicatorSpec mBaseIndicatorSpec;

    static IndicatorHandler getInstance() {
        return new IndicatorHandler();
    }

    @Override // com.just.agentweb.IndicatorController
    public void finish() {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.hide();
        }
    }

    IndicatorHandler inJectIndicator(BaseIndicatorSpec baseIndicatorSpec) {
        this.mBaseIndicatorSpec = baseIndicatorSpec;
        return this;
    }

    @Override // com.just.agentweb.IndicatorController
    public BaseIndicatorSpec offerIndicator() {
        return this.mBaseIndicatorSpec;
    }

    @Override // com.just.agentweb.IndicatorController
    public void progress(WebView webView, int i) {
        if (i == 0) {
            reset();
            return;
        }
        if (i > 0 && i <= 10) {
            showIndicator();
        } else if (i > 10 && i < 95) {
            setProgress(i);
        } else {
            setProgress(i);
            finish();
        }
    }

    public void reset() {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.reset();
        }
    }

    @Override // com.just.agentweb.IndicatorController
    public void setProgress(int i) {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.setProgress(i);
        }
    }

    @Override // com.just.agentweb.IndicatorController
    public void showIndicator() {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.show();
        }
    }
}
