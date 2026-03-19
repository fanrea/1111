package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.an;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.hc.k;
import com.bytedance.sdk.component.adexpress.hc.mk;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.c, com.bytedance.sdk.component.adexpress.theme.d {
    private com.bytedance.sdk.component.adexpress.dynamic.u.d an;
    public View b;
    private mk c;
    private Context cb;
    protected final k d;
    private uo e;
    private com.bytedance.sdk.component.adexpress.dynamic.hc gb;
    private ThemeStatusBroadcastReceiver h;
    boolean hc;
    private int k;
    private List<com.bytedance.sdk.component.adexpress.dynamic.b> mk;
    private com.bytedance.sdk.component.adexpress.dynamic.u mq;
    private int tc;
    private ViewGroup tt;
    private DynamicBaseWidget u;
    private int uo;
    private String w;
    private Map<Integer, String> yo;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, uo uoVar, com.bytedance.sdk.component.adexpress.dynamic.u.d dVar) {
        super(context);
        this.tt = null;
        this.tc = 0;
        this.mk = new ArrayList();
        this.uo = 0;
        this.k = 0;
        this.cb = context;
        k kVar = new k();
        this.d = kVar;
        kVar.d(2);
        this.an = dVar;
        dVar.d(this);
        this.h = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.d(this);
        this.hc = z;
        this.e = uoVar;
    }

    public String getBgColor() {
        return this.w;
    }

    public void setBgColor(String str) {
        this.w = str;
    }

    public void setRenderListener(mk mkVar) {
        this.c = mkVar;
        this.an.d(mkVar);
    }

    public void d(gb gbVar, int i) {
        this.u = d(gbVar, this, i);
        this.d.d(true);
        this.d.d(this.u.u);
        this.d.hc(this.u.an);
        this.d.d(this.b);
        this.c.d(this.d);
    }

    public DynamicBaseWidget d(gb gbVar, ViewGroup viewGroup, int i) throws JSONException {
        if (gbVar == null) {
            return null;
        }
        List<gb> listMk = gbVar.mk();
        DynamicBaseWidget dynamicBaseWidgetD = com.bytedance.sdk.component.adexpress.dynamic.d.hc.d(this.cb, this, gbVar);
        if (dynamicBaseWidgetD instanceof DynamicUnKnowView) {
            d(i == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        d(gbVar);
        dynamicBaseWidgetD.d();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetD);
            d(viewGroup, gbVar);
        }
        if (listMk == null || listMk.size() <= 0) {
            return null;
        }
        Iterator<gb> it = listMk.iterator();
        while (it.hasNext()) {
            d(it.next(), dynamicBaseWidgetD, i);
        }
        return dynamicBaseWidgetD;
    }

    private void d(gb gbVar) {
        an anVarU;
        com.bytedance.sdk.component.adexpress.dynamic.b.u uVarTc = gbVar.tc();
        if (uVarTc == null || (anVarU = uVarTc.u()) == null) {
            return;
        }
        this.d.hc(anVarU.zk());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.yo;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.yo = map;
    }

    private void d(ViewGroup viewGroup, gb gbVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !gbVar.np()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void d(double d, double d2, double d3, double d4, float f) {
        this.d.b(d);
        this.d.c(d2);
        this.d.u(d3);
        this.d.an(d4);
        this.d.d(f);
        this.d.hc(f);
        this.d.b(f);
        this.d.c(f);
    }

    public void d(int i, String str) {
        this.d.d(false);
        this.d.hc(i);
        this.d.d(str);
        this.c.d(this.d);
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.hc hcVar) {
        this.gb = hcVar;
    }

    public void setDislikeView(View view) {
        this.an.hc(view);
    }

    public mk getRenderListener() {
        return this.c;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.u.d getDynamicClickListener() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.d
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.u;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.d(i);
    }

    public void d() {
        d(this.u, 0);
    }

    public void hc() {
        d(this.u, 4);
    }

    public void d(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            if (dynamicBaseWidget.e != null) {
                dynamicBaseWidget.e.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                d((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.c
    public void d(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.mk.size(); i3++) {
            if (this.mk.get(i3) != null) {
                this.mk.get(i3).d(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.c
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.hc hcVar = this.gb;
        if (hcVar != null) {
            hcVar.setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i) {
        this.mq.setTimeUpdate(i);
    }

    public ViewGroup getTimeOut() {
        return this.tt;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.tt = viewGroup;
    }

    public int getTimedown() {
        return this.tc;
    }

    public void setTimedown(int i) {
        this.tc = i;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.b> getTimeOutListener() {
        return this.mk;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.b bVar) {
        this.mk.add(bVar);
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.u uVar) {
        this.mq = uVar;
    }

    public int getScoreCountWithIcon() {
        return this.k;
    }

    public void setScoreCountWithIcon(int i) {
        this.k = i;
    }

    public int getLogoUnionHeight() {
        return this.uo;
    }

    public void setLogoUnionHeight(int i) {
        this.uo = i;
    }

    public uo getRenderRequest() {
        return this.e;
    }
}
