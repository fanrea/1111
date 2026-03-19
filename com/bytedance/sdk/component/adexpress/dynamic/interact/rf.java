package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.utils.jh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class rf implements h<WriggleGuideAnimationView> {
    private String an;
    private Context b;
    private DynamicBaseWidget c;
    public int d;
    private boolean gb;
    private com.bytedance.sdk.component.adexpress.dynamic.b.tc h;
    private WriggleGuideAnimationView hc;
    private com.bytedance.sdk.component.adexpress.dynamic.b.h u;

    public rf(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, String str, com.bytedance.sdk.component.adexpress.dynamic.b.tc tcVar, boolean z, int i) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.u = hVar;
        this.an = str;
        this.h = tcVar;
        this.gb = z;
        this.d = i;
        u();
    }

    private void u() {
        int iQ = this.u.q();
        final com.bytedance.sdk.component.adexpress.dynamic.u.d dynamicClickListener = this.c.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.d(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.an)) {
            Context context = this.b;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.bytedance.sdk.component.adexpress.b.d.tt(context), this.h, this.gb, this.d);
            this.hc = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.hc.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.hc.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.u.qr())) {
                    this.hc.getTopTextView().setText(jh.hc(this.b, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.hc.getTopTextView().setText(this.u.qr());
                }
            }
        } else {
            Context context2 = this.b;
            this.hc = new WriggleGuideAnimationView(context2, com.bytedance.sdk.component.adexpress.b.d.tt(context2), this.h, this.gb, this.d);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.hc.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.b, iQ)));
        this.hc.setLayoutParams(layoutParams);
        this.hc.setShakeText(this.u.fu());
        this.hc.setClipChildren(false);
        final View wriggleProgressIv = this.hc.getWriggleProgressIv();
        this.hc.setOnShakeViewListener(new WriggleGuideAnimationView.d() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.rf.1
            @Override // com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.d
            public void d() {
                if (wriggleProgressIv != null) {
                    if (rf.this.hc != null) {
                        rf.this.hc.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        rf.this.hc.performClick();
                    }
                    if (rf.this.u == null || !rf.this.u.ra()) {
                        return;
                    }
                    rf.this.hc.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void d() {
        this.hc.d();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void hc() {
        this.hc.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView b() {
        return this.hc;
    }
}
