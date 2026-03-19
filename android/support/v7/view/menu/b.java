package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.n;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class b implements m {
    protected LayoutInflater ek;
    protected Context gZ;
    public g ha;
    protected LayoutInflater hb;
    private m.a hc;
    private int hd;
    private int he;
    public n hf;
    protected Context mContext;

    public abstract void a(h hVar, n.a aVar);

    public boolean a(h hVar) {
        return true;
    }

    @Override // android.support.v7.view.menu.m
    public final boolean b(h hVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.m
    public boolean bb() {
        return false;
    }

    @Override // android.support.v7.view.menu.m
    public final boolean c(h hVar) {
        return false;
    }

    public b(Context context, int i, int i2) {
        this.gZ = context;
        this.hb = LayoutInflater.from(context);
        this.hd = i;
        this.he = i2;
    }

    @Override // android.support.v7.view.menu.m
    public void a(Context context, g gVar) {
        this.mContext = context;
        this.ek = LayoutInflater.from(this.mContext);
        this.ha = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.view.menu.m
    public void l(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.hf;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.ha;
        int i = 0;
        if (gVar != null) {
            gVar.bt();
            ArrayList<h> arrayListBs = this.ha.bs();
            int size = arrayListBs.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                h hVar = arrayListBs.get(i3);
                if (a(hVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    h itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View viewA = a(hVar, childAt, viewGroup);
                    if (hVar != itemData) {
                        viewA.setPressed(false);
                        viewA.jumpDrawablesToCurrentState();
                    }
                    if (viewA != childAt) {
                        d(viewA, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    private void d(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.hf).addView(view, i);
    }

    protected boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // android.support.v7.view.menu.m
    public final void a(m.a aVar) {
        this.hc = aVar;
    }

    public final m.a ba() {
        return this.hc;
    }

    private n.a a(ViewGroup viewGroup) {
        return (n.a) this.hb.inflate(this.he, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(h hVar, View view, ViewGroup viewGroup) {
        n.a aVarA;
        if (view instanceof n.a) {
            aVarA = (n.a) view;
        } else {
            aVarA = a(viewGroup);
        }
        a(hVar, aVarA);
        return (View) aVarA;
    }

    @Override // android.support.v7.view.menu.m
    public void a(g gVar, boolean z) {
        m.a aVar = this.hc;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // android.support.v7.view.menu.m
    public boolean a(s sVar) {
        m.a aVar = this.hc;
        if (aVar != null) {
            return aVar.e(sVar);
        }
        return false;
    }
}
