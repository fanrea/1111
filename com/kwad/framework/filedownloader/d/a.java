package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private long beN;
    private long beO;
    private long beP;
    private int id;
    private int index;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final long getStartOffset() {
        return this.beN;
    }

    public final void setStartOffset(long j) {
        this.beN = j;
    }

    public final long Or() {
        return this.beO;
    }

    public final void av(long j) {
        this.beO = j;
    }

    public final long Os() {
        return this.beP;
    }

    public final void aw(long j) {
        this.beP = j;
    }

    public final ContentValues Ot() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put("startOffset", Long.valueOf(this.beN));
        contentValues.put("currentOffset", Long.valueOf(this.beO));
        contentValues.put("endOffset", Long.valueOf(this.beP));
        return contentValues;
    }

    public static long Z(List<a> list) {
        long jOr = 0;
        for (a aVar : list) {
            jOr += aVar.Or() - aVar.getStartOffset();
        }
        return jOr;
    }

    public final String toString() {
        return f.c("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.beN), Long.valueOf(this.beP), Long.valueOf(this.beO));
    }
}
