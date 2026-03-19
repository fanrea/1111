package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class j extends c {
    private int ei;
    private int ej;
    private LayoutInflater ek;

    @Deprecated
    public j(Context context, int i, Cursor cursor, boolean z) {
        super(context, null, true);
        this.ej = i;
        this.ei = i;
        this.ek = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.c
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.ek.inflate(this.ei, viewGroup, false);
    }

    @Override // android.support.v4.widget.c
    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.ek.inflate(this.ej, viewGroup, false);
    }
}
