package com.alliance.ssp.ad.template;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.alliance.ssp.ad.a.b;
import com.alliance.ssp.ad.t.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceContainerView extends FrameLayout {
    public a a;

    public SAAllianceContainerView(Context context, a aVar) {
        super(context);
        this.a = aVar;
    }

    private void setupPoint(MotionEvent motionEvent) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.f716K = b.a("").append((int) motionEvent.getRawX()).toString();
            this.a.L = b.a("").append((int) motionEvent.getRawY()).toString();
            this.a.M = b.a("").append((int) motionEvent.getRawX()).toString();
            this.a.N = b.a("").append((int) motionEvent.getRawY()).toString();
            this.a.P = b.a("").append((int) motionEvent.getX()).toString();
            this.a.Q = b.a("").append((int) motionEvent.getY()).toString();
            this.a.R = b.a("").append((int) motionEvent.getX()).toString();
            this.a.S = b.a("").append((int) motionEvent.getY()).toString();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.a.I = String.valueOf(jCurrentTimeMillis);
            this.a.Z = String.valueOf((int) (jCurrentTimeMillis / 1000));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            setupPoint(motionEvent);
        } else if (action == 1 && (aVar = this.a) != null) {
            aVar.M = b.a("").append((int) motionEvent.getRawX()).toString();
            this.a.N = b.a("").append((int) motionEvent.getRawY()).toString();
            this.a.R = b.a("").append((int) motionEvent.getX()).toString();
            this.a.S = b.a("").append((int) motionEvent.getY()).toString();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setImpl(a aVar) {
        this.a = aVar;
    }

    public SAAllianceContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public SAAllianceContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
    }
}
