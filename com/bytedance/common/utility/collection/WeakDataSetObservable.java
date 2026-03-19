package com.bytedance.common.utility.collection;

import android.database.DataSetObserver;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WeakDataSetObservable<T extends DataSetObserver> {
    protected final WeakContainer<T> mObservers = new WeakContainer<>();

    public void registerObserver(T t) {
        if (t == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (this.mObservers) {
            this.mObservers.add(t);
        }
    }

    public void unregisterObserver(T t) {
        if (t == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (this.mObservers) {
            this.mObservers.remove(t);
        }
    }

    public void unregisterAll() {
        synchronized (this.mObservers) {
            this.mObservers.clear();
        }
    }

    public void notifyChanged() {
        synchronized (this.mObservers) {
            Iterator<T> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().onChanged();
            }
        }
    }

    public void notifyInvalidated() {
        synchronized (this.mObservers) {
            Iterator<T> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().onInvalidated();
            }
        }
    }
}
