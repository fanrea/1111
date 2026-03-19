package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k implements e, h<ShakeAnimationView> {
    private String an;
    private Context b;
    private DynamicBaseWidget c;
    public int d;
    private boolean gb;
    private com.bytedance.sdk.component.adexpress.dynamic.b.tc h;
    private ShakeAnimationView hc;
    private com.bytedance.sdk.component.adexpress.dynamic.b.h u;

    public k(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, String str, com.bytedance.sdk.component.adexpress.dynamic.b.tc tcVar, boolean z, int i) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.u = hVar;
        this.an = str;
        this.h = tcVar;
        this.gb = z;
        this.d = i;
        an();
    }

    private void an() {
        final com.bytedance.sdk.component.adexpress.dynamic.u.d dynamicClickListener = this.c.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.d(jSONObject);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.an)) {
            Context context = this.b;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.bytedance.sdk.component.adexpress.b.d.gb(context), this.h, this.gb, this.d);
            this.hc = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.hc.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.b;
            this.hc = new ShakeAnimationView(context2, com.bytedance.sdk.component.adexpress.b.d.h(context2), this.h, this.gb, this.d);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hc.setGravity(17);
        layoutParams.gravity = 17;
        this.hc.setLayoutParams(layoutParams);
        this.hc.setTranslationY(com.bytedance.sdk.component.adexpress.c.gb.d(this.b, this.u.ey()));
        this.hc.setShakeText(this.u.fu());
        this.hc.setClipChildren(false);
        this.hc.setOnShakeViewListener(new ShakeAnimationView.d() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.k.1
            @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.d
            public void d(boolean z) {
                com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = dynamicClickListener;
                if (dVar != null) {
                    dVar.d(z, k.this);
                }
                k.this.hc.setOnClickListener((View.OnClickListener) dynamicClickListener);
                k.this.hc.performClick();
                if (k.this.u == null || !k.this.u.ra()) {
                    return;
                }
                k.this.hc.setOnClickListener(null);
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
    public ShakeAnimationView b() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void u() {
        if (this.hc.getParent() != null) {
            ((ViewGroup) this.hc.getParent()).setVisibility(8);
        }
    }
}
