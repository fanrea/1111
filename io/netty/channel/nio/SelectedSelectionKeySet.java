package io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class SelectedSelectionKeySet extends AbstractSet<SelectionKey> {
    private int keysASize;
    private int keysBSize;
    private boolean isA = true;
    private SelectionKey[] keysA = new SelectionKey[1024];
    private SelectionKey[] keysB = (SelectionKey[]) this.keysA.clone();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return false;
    }

    SelectedSelectionKeySet() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(SelectionKey selectionKey) {
        if (selectionKey == null) {
            return false;
        }
        if (this.isA) {
            int i = this.keysASize;
            SelectionKey[] selectionKeyArr = this.keysA;
            int i2 = i + 1;
            selectionKeyArr[i] = selectionKey;
            this.keysASize = i2;
            if (i2 != selectionKeyArr.length) {
                return true;
            }
            doubleCapacityA();
            return true;
        }
        int i3 = this.keysBSize;
        SelectionKey[] selectionKeyArr2 = this.keysB;
        int i4 = i3 + 1;
        selectionKeyArr2[i3] = selectionKey;
        this.keysBSize = i4;
        if (i4 != selectionKeyArr2.length) {
            return true;
        }
        doubleCapacityB();
        return true;
    }

    private void doubleCapacityA() {
        SelectionKey[] selectionKeyArr = this.keysA;
        SelectionKey[] selectionKeyArr2 = new SelectionKey[selectionKeyArr.length << 1];
        System.arraycopy(selectionKeyArr, 0, selectionKeyArr2, 0, this.keysASize);
        this.keysA = selectionKeyArr2;
    }

    private void doubleCapacityB() {
        SelectionKey[] selectionKeyArr = this.keysB;
        SelectionKey[] selectionKeyArr2 = new SelectionKey[selectionKeyArr.length << 1];
        System.arraycopy(selectionKeyArr, 0, selectionKeyArr2, 0, this.keysBSize);
        this.keysB = selectionKeyArr2;
    }

    final SelectionKey[] flip() {
        if (this.isA) {
            this.isA = false;
            SelectionKey[] selectionKeyArr = this.keysA;
            selectionKeyArr[this.keysASize] = null;
            this.keysBSize = 0;
            return selectionKeyArr;
        }
        this.isA = true;
        SelectionKey[] selectionKeyArr2 = this.keysB;
        selectionKeyArr2[this.keysBSize] = null;
        this.keysASize = 0;
        return selectionKeyArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        if (this.isA) {
            return this.keysASize;
        }
        return this.keysBSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<SelectionKey> iterator() {
        throw new UnsupportedOperationException();
    }
}
