package com.bytedance.adsdk.ugeno.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc {
    private final DataSetObservable d = new DataSetObservable();
    private DataSetObserver hc;

    public float d(int i) {
        return 1.0f;
    }

    public abstract int d();

    public int d(Object obj) {
        return -1;
    }

    public abstract boolean d(View view, Object obj);

    public Parcelable hc() {
        return null;
    }

    public Object d(ViewGroup viewGroup, int i) {
        return d((View) viewGroup, i);
    }

    public void d(ViewGroup viewGroup, int i, Object obj) {
        d((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object d(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void d(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void b() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.hc;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.d.notifyChanged();
    }

    void d(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.hc = dataSetObserver;
        }
    }
}
