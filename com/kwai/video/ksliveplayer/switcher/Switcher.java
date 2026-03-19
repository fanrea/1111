package com.kwai.video.ksliveplayer.switcher;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Switcher<T> {
    private int mCurrentPosition;
    private final List<T> mElements = new ArrayList();

    public void moveToNext() {
        this.mCurrentPosition = (this.mCurrentPosition + 1) % this.mElements.size();
    }

    public int size() {
        return this.mElements.size();
    }

    public T getCurrent() {
        return this.mElements.get(this.mCurrentPosition);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public void append(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.mElements.addAll(list);
    }

    public boolean isLast() {
        return this.mCurrentPosition == this.mElements.size() - 1;
    }
}
