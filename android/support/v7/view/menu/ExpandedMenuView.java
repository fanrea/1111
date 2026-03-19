package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.support.v7.view.menu.g;
import android.support.v7.widget.av;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {
    private static final int[] hQ = {R.attr.background, R.attr.divider};
    private int hR;
    private g ha;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        av avVarA = av.a(context, attributeSet, hQ, i, 0);
        if (avVarA.hasValue(0)) {
            setBackgroundDrawable(avVarA.getDrawable(0));
        }
        if (avVarA.hasValue(1)) {
            setDivider(avVarA.getDrawable(1));
        }
        avVarA.recycle();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.support.v7.view.menu.g.b
    public final boolean d(h hVar) {
        return this.ha.a(hVar, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        d((h) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.hR;
    }
}
