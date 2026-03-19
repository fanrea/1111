package com.tk.core.component;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g {
    private static final WeakHashMap<View, Integer> abD = new WeakHashMap<>();
    private int abE = 0;
    private int[] abF;
    private final ViewGroup cp;

    public g(ViewGroup viewGroup) {
        this.cp = viewGroup;
    }

    public static void p(View view, int i) {
        abD.put(view, Integer.valueOf(i));
    }

    public static Integer aP(View view) {
        return abD.get(view);
    }

    public final void aQ(View view) {
        if (aP(view) != null) {
            this.abE++;
        }
        this.abF = null;
    }

    public final void aR(View view) {
        if (aP(view) != null) {
            this.abE--;
        }
        this.abF = null;
    }

    public final boolean qG() {
        return this.abE > 0;
    }

    public final int getChildDrawingOrder(int i, int i2) {
        if (this.abF == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i; i3++) {
                arrayList.add(this.cp.getChildAt(i3));
            }
            Collections.sort(arrayList, new Comparator<View>() { // from class: com.tk.core.component.g.1
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(View view, View view2) {
                    return c(view, view2);
                }

                private static int c(View view, View view2) {
                    Integer numAP = g.aP(view);
                    if (numAP == null) {
                        numAP = 0;
                    }
                    Integer numAP2 = g.aP(view2);
                    if (numAP2 == null) {
                        numAP2 = 0;
                    }
                    return numAP.intValue() - numAP2.intValue();
                }
            });
            this.abF = new int[i];
            for (int i4 = 0; i4 < i; i4++) {
                this.abF[i4] = this.cp.indexOfChild((View) arrayList.get(i4));
            }
        }
        return this.abF[i2];
    }

    public final void update() {
        this.abE = 0;
        for (int i = 0; i < this.cp.getChildCount(); i++) {
            if (aP(this.cp.getChildAt(i)) != null) {
                this.abE++;
            }
        }
        this.abF = null;
    }
}
