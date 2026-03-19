package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.dynamic.interact.e;
import com.bytedance.sdk.component.adexpress.hc.mk;
import com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup;
import com.bytedance.sdk.djx.core.log.ILogConst;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicImageFlipSlide extends DynamicImageView {
    private final ImageFlipSlideGroup d;
    private final hc hc;

    public interface d {
        void d();
    }

    private interface hc {
        void d(d dVar);
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.hc = new hc() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.1
            @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.hc
            public void d(d dVar) {
                if (DynamicImageFlipSlide.this.d != null) {
                    DynamicImageFlipSlide.this.d.d(dVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().yb(), ILogConst.DRAW_ENTER_TYPE_SLIDE));
        this.d = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d.d();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.hc();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() throws Resources.NotFoundException, NumberFormatException {
        super.gb();
        this.d.d(this.mq.mk(), hc(this.mq.mk()));
        this.d.hc(this.mq.fy(), hc(this.mq.fy()));
        this.d.setFilterColors(this.mq.zv());
        this.d.b();
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public com.bytedance.sdk.component.adexpress.dynamic.u.d getDynamicClickListener() {
        com.bytedance.sdk.component.adexpress.dynamic.u.d dynamicClickListener = this.k.getDynamicClickListener();
        return this.mq.um() ? new b(dynamicClickListener, this.hc) : dynamicClickListener;
    }

    private static class b implements View.OnClickListener, View.OnTouchListener, com.bytedance.sdk.component.adexpress.dynamic.u.d {
        com.bytedance.sdk.component.adexpress.dynamic.u.d d;
        hc hc;

        public b(com.bytedance.sdk.component.adexpress.dynamic.u.d dVar, hc hcVar) {
            this.d = dVar;
            this.hc = hcVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            hc hcVar = this.hc;
            if (hcVar != null) {
                hcVar.d(new d() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.b.1
                    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.d
                    public void d() {
                        if (b.this.d instanceof View.OnClickListener) {
                            ((View.OnClickListener) b.this.d).onClick(view);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = this.d;
            if (dVar instanceof View.OnClickListener) {
                ((View.OnClickListener) dVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = this.d;
            if (dVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) dVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.u.d
        public void d(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = this.d;
            if (dVar != null) {
                dVar.d(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.u.d
        public void hc(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = this.d;
            if (dVar != null) {
                dVar.hc(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.u.d
        public void d(mk mkVar) {
            com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = this.d;
            if (dVar != null) {
                dVar.d(mkVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.u.d
        public void d(boolean z, e eVar) {
            com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = this.d;
            if (dVar != null) {
                dVar.d(z, eVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.u.d
        public void d(JSONObject jSONObject) {
            com.bytedance.sdk.component.adexpress.dynamic.u.d dVar = this.d;
            if (dVar != null) {
                dVar.d(jSONObject);
            }
        }
    }
}
