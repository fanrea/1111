package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> {
    private boolean jl;
    protected long jm;
    private float jn;
    private float jo;
    private int jp;
    private MotionEvent jq;
    protected SimpleImageLoadingListener jr;

    public final void co() {
        if (this.jl) {
            return;
        }
        this.jl = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 1, getStayTime());
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.jn = motionEvent.getX();
            this.jo = motionEvent.getY();
            this.jq = MotionEvent.obtain(motionEvent);
            this.jp = 0;
        }
        if (a(motionEvent)) {
            if (!com.kwad.sdk.utils.b.a(this.jq, motionEvent, this.mAdTemplate)) {
                return true;
            }
            if (action == 3 && this.jp == 0) {
                motionEvent.setAction(1);
                this.jp = 1;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || !(action != 3 || motionEvent.getX() == 0.0f || motionEvent.getY() == 0.0f)) {
            return Math.abs(motionEvent.getX() - this.jn) > 20.0f || Math.abs(motionEvent.getY() - this.jo) > 20.0f;
        }
        return false;
    }

    public a(Context context) {
        super(context);
        this.jp = 0;
        this.jr = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.jm);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.jm);
            }
        };
    }

    protected final void cp() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        if (com.kwad.sdk.core.response.b.a.aT(this.mAdInfo)) {
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
        } else {
            complianceTextView.setVisibility(8);
        }
    }
}
