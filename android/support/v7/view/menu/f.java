package android.support.v7.view.menu;

import android.support.v7.view.menu.n;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class f extends BaseAdapter {
    private final LayoutInflater ek;
    private boolean hD;
    private final int he;
    private final boolean hn;
    g ii;
    private int ij = -1;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.hn = z;
        this.ek = layoutInflater;
        this.ii = gVar;
        this.he = i;
        bk();
    }

    public final void setForceShowIcon(boolean z) {
        this.hD = z;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<h> arrayListBv = this.hn ? this.ii.bv() : this.ii.bs();
        if (this.ij < 0) {
            return arrayListBv.size();
        }
        return arrayListBv.size() - 1;
    }

    public final g bj() {
        return this.ii;
    }

    @Override // android.widget.Adapter
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final h getItem(int i) {
        ArrayList<h> arrayListBv = this.hn ? this.ii.bv() : this.ii.bs();
        int i2 = this.ij;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return arrayListBv.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.ek.inflate(this.he, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.ii.bl() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.hD) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    private void bk() {
        h hVarBz = this.ii.bz();
        if (hVarBz != null) {
            ArrayList<h> arrayListBv = this.ii.bv();
            int size = arrayListBv.size();
            for (int i = 0; i < size; i++) {
                if (arrayListBv.get(i) == hVarBz) {
                    this.ij = i;
                    return;
                }
            }
        }
        this.ij = -1;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        bk();
        super.notifyDataSetChanged();
    }
}
