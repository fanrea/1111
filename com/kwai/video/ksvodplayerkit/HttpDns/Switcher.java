package com.kwai.video.ksvodplayerkit.HttpDns;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Switcher<T> {
    private int mCurrentPosition;
    public final List<T> mElements = new ArrayList();

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
}
