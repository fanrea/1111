package com.bytedance.adsdk.ugeno.yoga.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.h;
import com.bytedance.adsdk.ugeno.yoga.mk;
import com.bytedance.adsdk.ugeno.yoga.tc;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final tc b;
    private final List<View> d;
    private final Map<View, tc> hc;

    public tc getYogaNode() {
        return this.b;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.d(this);
            tc yogaNode = virtualYogaLayout.getYogaNode();
            tc tcVar = this.b;
            tcVar.d(yogaNode, tcVar.d());
            return;
        }
        tc tcVarD = mk.d();
        YogaLayout.d(new YogaLayout.d(layoutParams), tcVarD, view);
        tcVarD.d(view);
        tcVarD.d((h) new YogaLayout.hc());
        tc tcVar2 = this.b;
        tcVar2.d(tcVarD, tcVar2.d());
        d(view, tcVarD);
    }

    public void d(View view, tc tcVar) {
        this.d.add(view);
        this.hc.put(view, tcVar);
    }

    protected void d(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.d) {
                ((VirtualYogaLayout) viewGroup).d(view, this.hc.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.d) {
                ((YogaLayout) viewGroup).d(view2, this.hc.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.d.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.d(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.d(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.d;
    }
}
