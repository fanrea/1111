package com.sigmob.sdk.mraid;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.common.ak;
import com.sigmob.sdk.base.views.v;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h extends j {
    private v c;
    private ak.a d;
    private com.sigmob.sdk.mraid2.i e;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h(android.content.Context r5, final java.lang.String r6, int r7) {
        /*
            r4 = this;
            r4.<init>(r6)
            android.content.Context r0 = com.sigmob.sdk.b.e()
            r1 = 3
            r2 = 1
            if (r7 == 0) goto L56
            if (r7 == r2) goto L40
            r3 = 2
            if (r7 == r3) goto L2c
            if (r7 == r1) goto L18
            java.lang.String r5 = "MMotionView type is not support"
            com.czhj.sdk.logger.SigmobLog.e(r5)
            goto L6e
        L18:
            com.sigmob.sdk.base.views.an r7 = new com.sigmob.sdk.base.views.an
            r7.<init>(r5)
            r4.c = r7
            com.sigmob.sdk.base.common.ak$a r5 = new com.sigmob.sdk.base.common.ak$a
            com.sigmob.sdk.mraid.h$4 r7 = new com.sigmob.sdk.mraid.h$4
            r7.<init>()
            com.sigmob.sdk.base.common.ak$c r6 = com.sigmob.sdk.base.common.ak.c.SWING
            r5.<init>(r0, r7, r6)
            goto L69
        L2c:
            com.sigmob.sdk.base.views.ak r7 = new com.sigmob.sdk.base.views.ak
            r7.<init>(r5)
            r4.c = r7
            com.sigmob.sdk.base.common.ak$a r5 = new com.sigmob.sdk.base.common.ak$a
            com.sigmob.sdk.mraid.h$3 r7 = new com.sigmob.sdk.mraid.h$3
            r7.<init>()
            com.sigmob.sdk.base.common.ak$c r6 = com.sigmob.sdk.base.common.ak.c.SLOPE
            r5.<init>(r0, r7, r6)
            goto L69
        L40:
            com.sigmob.sdk.base.views.au r7 = new com.sigmob.sdk.base.views.au
            r7.<init>(r5)
            r4.c = r7
            com.sigmob.sdk.base.common.ak$a r5 = new com.sigmob.sdk.base.common.ak$a
            com.sigmob.sdk.mraid.h$2 r7 = new com.sigmob.sdk.mraid.h$2
            r7.<init>()
            com.sigmob.sdk.base.common.ak$c r6 = com.sigmob.sdk.base.common.ak.c.WRING
            r5.<init>(r0, r7, r6)
            r4.d = r5
            goto L6e
        L56:
            com.sigmob.sdk.base.views.ac r7 = new com.sigmob.sdk.base.views.ac
            r7.<init>(r5)
            r4.c = r7
            com.sigmob.sdk.base.common.ak$a r5 = new com.sigmob.sdk.base.common.ak$a
            com.sigmob.sdk.mraid.h$1 r7 = new com.sigmob.sdk.mraid.h$1
            r7.<init>()
            com.sigmob.sdk.base.common.ak$c r6 = com.sigmob.sdk.base.common.ak.c.SHAKE
            r5.<init>(r0, r7, r6)
        L69:
            r4.d = r5
            r5.a(r2)
        L6e:
            com.sigmob.sdk.base.views.v r5 = r4.c
            if (r5 == 0) goto L75
            r5.a()
        L75:
            com.sigmob.sdk.base.common.ak$a r5 = r4.d
            r5.c(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.h.<init>(android.content.Context, java.lang.String, int):void");
    }

    public h(String uniqueId) {
        super(uniqueId);
    }

    public void a() {
        ak.a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public void a(int sensitivity) {
        ak.a aVar = this.d;
        if (aVar == null) {
            return;
        }
        if (sensitivity == 0) {
            sensitivity = 3;
        } else if (sensitivity == 2) {
            sensitivity = 1;
        } else if (sensitivity == 1) {
            sensitivity = 2;
        }
        aVar.c(sensitivity);
    }

    public void a(com.sigmob.sdk.mraid2.i mraidBridgeMotionListener) {
        this.e = mraidBridgeMotionListener;
    }

    public void a(JSONObject args) {
        JSONObject jSONObjectOptJSONObject;
        if (this.c == null || args == null || (jSONObjectOptJSONObject = args.optJSONObject(TypedValues.AttributesType.S_FRAME)) == null) {
            return;
        }
        int iOptDouble = (int) jSONObjectOptJSONObject.optDouble("x", 0.0d);
        int iOptDouble2 = (int) jSONObjectOptJSONObject.optDouble("y", 0.0d);
        int iOptDouble3 = (int) jSONObjectOptJSONObject.optDouble("w", -1.0d);
        int iOptDouble4 = (int) jSONObjectOptJSONObject.optDouble("h", -1.0d);
        if (iOptDouble3 > 0) {
            iOptDouble3 = Dips.dipsToIntPixels(iOptDouble3, com.sigmob.sdk.b.e());
        }
        if (iOptDouble4 > 0) {
            iOptDouble4 = Dips.dipsToIntPixels(iOptDouble4, com.sigmob.sdk.b.e());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iOptDouble3, iOptDouble4);
        this.c.setX(Dips.dipsToIntPixels(iOptDouble, com.sigmob.sdk.b.e()));
        this.c.setY(Dips.dipsToIntPixels(iOptDouble2, com.sigmob.sdk.b.e()));
        this.c.setLayoutParams(layoutParams);
        this.c.requestLayout();
    }

    public void a(boolean hidden) {
        v vVar = this.c;
        if (vVar == null) {
            return;
        }
        if (hidden) {
            vVar.setVisibility(4);
            this.d.b();
        } else {
            vVar.setVisibility(0);
            this.d.a();
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public View b() {
        return this.c;
    }

    public void b(int sensitivityRaw) {
        ak.a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.b(sensitivityRaw);
    }

    @Override // com.sigmob.sdk.mraid.j
    public void c() {
        v vVar = this.c;
        if (vVar != null) {
            com.sigmob.sdk.base.utils.o.a(vVar);
            this.c = null;
        }
        ak.a aVar = this.d;
        if (aVar != null) {
            aVar.c();
        }
    }
}
