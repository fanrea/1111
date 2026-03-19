package com.kwad.jni;

import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class IteratorHelper {
    private Object mElement;
    private final Iterator mIterator;

    public IteratorHelper(Iterator it) {
        this.mIterator = it;
    }

    public IteratorHelper(Iterable iterable) {
        this.mIterator = iterable.iterator();
    }

    boolean hasNext() {
        if (this.mIterator.hasNext()) {
            this.mElement = this.mIterator.next();
            return true;
        }
        this.mElement = null;
        return false;
    }
}
