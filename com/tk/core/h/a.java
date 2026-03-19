package com.tk.core.h;

import android.view.View;
import com.baidu.mobstat.forbes.Config;
import com.kwad.yoga.c;
import com.kwad.yoga.d;
import com.tk.core.component.e;
import com.tk.core.o.t;
import com.tk.core.p.a.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a<T extends View> {
    public String aib = rT();
    private e<T> aic;
    private c aid;

    private a(e<T> eVar, String str) {
        this.aic = eVar;
    }

    public final void reset() {
        c cVar = this.aid;
        if (cVar != null) {
            cVar.setData(null);
            this.aid = null;
        }
        this.aib = null;
        this.aic = null;
    }

    public static <T extends View> a q(e<T> eVar) {
        return new a(eVar, null);
    }

    public final void bg(View view) {
        if (this.aid != null) {
            return;
        }
        if (view instanceof com.tk.core.p.a.a) {
            this.aid = ((com.tk.core.p.a.a) view).getYogaNode();
            return;
        }
        this.aid = new d();
        this.aid.setData(view);
        this.aid.setMeasureFunction(new a.C0828a());
    }

    private View rP() {
        e<T> eVar = this.aic;
        if (eVar == null) {
            return null;
        }
        return eVar.getView();
    }

    public final c getYogaNode() {
        return this.aid;
    }

    public final void q(HashMap map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        View viewRP = rP();
        s(map);
        viewRP.requestLayout();
    }

    public final void r(e eVar) {
        b(eVar, getYogaNode().getChildCount());
    }

    private void b(e eVar, int i) {
        a<T> aVarPR;
        if (eVar == null || (aVarPR = eVar.pR()) == null) {
            return;
        }
        com.tk.core.p.a.a aVarRS = rS();
        if (aVarRS == null) {
            if (t.isDebug()) {
                throw new IllegalStateException("Super view must be YogaLayout!");
            }
        } else {
            aVarRS.a(eVar.getView(), aVarPR.getYogaNode(), i);
        }
    }

    public final void s(e eVar) {
        if (eVar == null || eVar.pR() == null) {
            return;
        }
        com.tk.core.p.a.a aVarRS = rS();
        if (aVarRS == null) {
            if (t.isDebug()) {
                throw new IllegalStateException("Super view must be YogaLayout!");
            }
        } else {
            aVarRS.removeView(eVar.getView());
        }
    }

    public final void rQ() {
        com.tk.core.p.a.a aVarRS = rS();
        if (aVarRS == null) {
            return;
        }
        aVarRS.removeAllViews();
    }

    public final void a(e eVar, e eVar2) {
        com.tk.core.p.a.a aVarRS = rS();
        if (aVarRS == null) {
            return;
        }
        b(eVar, aVarRS.indexOfChild(eVar2.getView()));
    }

    public final void b(e eVar, e eVar2) {
        if (eVar == null || eVar2 == null) {
            return;
        }
        com.tk.core.p.a.a aVarRS = rS();
        if (aVarRS == null) {
            if (t.isDebug()) {
                throw new IllegalStateException("Super view must be YogaLayout!");
            }
        } else {
            int iIndexOfChild = aVarRS.indexOfChild(eVar2.getView());
            s(eVar2);
            b(eVar, iIndexOfChild);
        }
    }

    public final void rR() {
        e eVarQq;
        if (rS() == null) {
            return;
        }
        a<T> aVarPR = this;
        a<T> aVarPR2 = aVarPR;
        while (true) {
            e<T> eVar = aVarPR.aic;
            if (eVar == null || (eVarQq = eVar.qq()) == null) {
                break;
            }
            if (eVarQq.getView() instanceof com.tk.core.p.a.a) {
                aVarPR2 = eVarQq.pR();
            }
            aVarPR = eVarQq.pR();
        }
        if (aVarPR2 != null) {
            c yogaNode = aVarPR2.getYogaNode();
            yogaNode.calculateLayout(yogaNode.getLayoutWidth(), yogaNode.getLayoutHeight());
        }
    }

    private com.tk.core.p.a.a rS() {
        View viewRP = rP();
        if (viewRP instanceof com.tk.core.p.a.a) {
            return (com.tk.core.p.a.a) viewRP;
        }
        return null;
    }

    private void r(HashMap map) {
        if (map == null) {
            return;
        }
        c yogaNode = getYogaNode();
        b.a(yogaNode, this.aic);
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            Object value = entry.getValue();
            if (!(value instanceof HashMap)) {
                a(iIntValue, value, yogaNode);
            }
        }
    }

    private void s(HashMap map) {
        if (map == null) {
            return;
        }
        r(map);
    }

    private static void a(int i, Object obj, c cVar) {
        if (obj == null || cVar == null) {
            return;
        }
        b.a(cVar, i, obj);
    }

    private static String rT() {
        return Config.replace + String.valueOf(System.nanoTime());
    }
}
