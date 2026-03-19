package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class ab implements w {
    private final SparseArray<Handler> beg = new SparseArray<>();

    ab() {
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void Nk() {
        for (int i = 0; i < this.beg.size(); i++) {
            a(this.beg.get(this.beg.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void X(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.beg.get(it.next().intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int Nl() {
        return this.beg.size();
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean dj(int i) {
        return this.beg.get(i) != null;
    }

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }
}
