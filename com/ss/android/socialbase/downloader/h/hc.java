package com.ss.android.socialbase.downloader.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements Parcelable {
    public static final Parcelable.Creator<hc> CREATOR = new Parcelable.Creator<hc>() { // from class: com.ss.android.socialbase.downloader.h.hc.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public hc createFromParcel(Parcel parcel) {
            return new hc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public hc[] newArray(int i) {
            return new hc[i];
        }
    };
    private static final String d = "hc";
    private long an;
    private long b;
    private AtomicLong c;
    private com.ss.android.socialbase.downloader.k.hc e;
    private AtomicInteger gb;
    private int h;
    private int hc;
    private AtomicBoolean k;
    private hc mk;
    private int mq;
    private List<hc> tc;
    private long tt;
    private long u;
    private boolean uo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private hc(d dVar) {
        if (dVar == null) {
            return;
        }
        this.hc = dVar.d;
        this.b = dVar.hc;
        this.c = new AtomicLong(dVar.b);
        this.u = dVar.c;
        this.an = dVar.u;
        this.h = dVar.an;
        this.tt = dVar.h;
        this.gb = new AtomicInteger(-1);
        d(dVar.gb);
        this.k = new AtomicBoolean(false);
    }

    public hc(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.hc = cursor.getInt(cursor.getColumnIndex("_id"));
        this.h = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.b = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.c = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.c = new AtomicLong(0L);
        }
        this.u = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.gb = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.gb = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.an = cursor.getLong(columnIndex3);
        }
        this.k = new AtomicBoolean(false);
    }

    protected hc(Parcel parcel) {
        this.hc = parcel.readInt();
        this.b = parcel.readLong();
        this.c = new AtomicLong(parcel.readLong());
        this.u = parcel.readLong();
        this.an = parcel.readLong();
        this.h = parcel.readInt();
        this.gb = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hc);
        parcel.writeLong(this.b);
        AtomicLong atomicLong = this.c;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.u);
        parcel.writeLong(this.an);
        parcel.writeInt(this.h);
        AtomicInteger atomicInteger = this.gb;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public ContentValues d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.hc));
        contentValues.put("chunkIndex", Integer.valueOf(this.h));
        contentValues.put("startOffset", Long.valueOf(this.b));
        contentValues.put("curOffset", Long.valueOf(k()));
        contentValues.put("endOffset", Long.valueOf(this.u));
        contentValues.put("chunkContentLen", Long.valueOf(this.an));
        contentValues.put("hostChunkIndex", Integer.valueOf(hc()));
        return contentValues;
    }

    public void d(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.mq = 0;
        sQLiteStatement.clearBindings();
        int i = this.mq + 1;
        this.mq = i;
        sQLiteStatement.bindLong(i, this.hc);
        int i2 = this.mq + 1;
        this.mq = i2;
        sQLiteStatement.bindLong(i2, this.h);
        int i3 = this.mq + 1;
        this.mq = i3;
        sQLiteStatement.bindLong(i3, this.b);
        int i4 = this.mq + 1;
        this.mq = i4;
        sQLiteStatement.bindLong(i4, k());
        int i5 = this.mq + 1;
        this.mq = i5;
        sQLiteStatement.bindLong(i5, this.u);
        int i6 = this.mq + 1;
        this.mq = i6;
        sQLiteStatement.bindLong(i6, this.an);
        int i7 = this.mq + 1;
        this.mq = i7;
        sQLiteStatement.bindLong(i7, hc());
    }

    public int hc() {
        AtomicInteger atomicInteger = this.gb;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void d(int i) {
        AtomicInteger atomicInteger = this.gb;
        if (atomicInteger == null) {
            this.gb = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public boolean b() {
        AtomicBoolean atomicBoolean = this.k;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public void d(com.ss.android.socialbase.downloader.k.hc hcVar) {
        this.e = hcVar;
        yo();
    }

    public void d(boolean z) {
        AtomicBoolean atomicBoolean = this.k;
        if (atomicBoolean == null) {
            this.k = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.e = null;
    }

    public void d(hc hcVar) {
        this.mk = hcVar;
        if (hcVar != null) {
            d(hcVar.rf());
        }
    }

    public boolean c() {
        return hc() == -1;
    }

    public hc u() {
        hc hcVar = !c() ? this.mk : this;
        if (hcVar == null || !hcVar.an()) {
            return null;
        }
        return hcVar.h().get(0);
    }

    public boolean an() {
        List<hc> list = this.tc;
        return list != null && list.size() > 0;
    }

    public void d(List<hc> list) {
        this.tc = list;
    }

    public List<hc> h() {
        return this.tc;
    }

    public boolean gb() {
        hc hcVar = this.mk;
        if (hcVar == null) {
            return true;
        }
        if (!hcVar.an()) {
            return false;
        }
        for (int i = 0; i < this.mk.h().size(); i++) {
            hc hcVar2 = this.mk.h().get(i);
            if (hcVar2 != null) {
                int iIndexOf = this.mk.h().indexOf(this);
                if (iIndexOf > i && !hcVar2.tt()) {
                    return false;
                }
                if (iIndexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void hc(boolean z) {
        this.uo = z;
    }

    public boolean tt() {
        long j = this.b;
        if (c()) {
            long j2 = this.tt;
            if (j2 > this.b) {
                j = j2;
            }
        }
        return k() - j >= this.an;
    }

    public long tc() {
        hc hcVar = this.mk;
        if (hcVar != null && hcVar.h() != null) {
            int iIndexOf = this.mk.h().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.mk.h().size(); i++) {
                hc hcVar2 = this.mk.h().get(i);
                if (hcVar2 != null) {
                    if (z) {
                        return hcVar2.k();
                    }
                    if (iIndexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public void hc(int i) {
        this.hc = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public void d(long j) {
        this.an = j;
    }

    public int mk() {
        return this.hc;
    }

    public long mq() {
        return this.b;
    }

    public long uo() {
        AtomicLong atomicLong = this.c;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long k() {
        if (c() && an()) {
            long jUo = 0;
            for (int i = 0; i < this.tc.size(); i++) {
                hc hcVar = this.tc.get(i);
                if (hcVar != null) {
                    if (!hcVar.tt()) {
                        return hcVar.uo();
                    }
                    if (jUo < hcVar.uo()) {
                        jUo = hcVar.uo();
                    }
                }
            }
            return jUo;
        }
        return uo();
    }

    public void hc(long j) {
        AtomicLong atomicLong = this.c;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.c = new AtomicLong(j);
        }
    }

    public long e() {
        long jK = k() - this.b;
        if (an()) {
            jK = 0;
            for (int i = 0; i < this.tc.size(); i++) {
                hc hcVar = this.tc.get(i);
                if (hcVar != null) {
                    jK += hcVar.k() - hcVar.mq();
                }
            }
        }
        return jK;
    }

    public long cb() {
        return this.u;
    }

    public long w() {
        return this.an;
    }

    public void yo() {
        this.tt = k();
    }

    public long b(boolean z) {
        long jK = k();
        long j = this.an;
        long j2 = this.tt;
        long j3 = j - (jK - j2);
        if (!z && jK == j2) {
            j3 = j - (jK - this.b);
        }
        com.ss.android.socialbase.downloader.an.d.hc("DownloadChunk", "contentLength:" + this.an + " curOffset:" + k() + " oldOffset:" + this.tt + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public List<hc> d(int i, long j) {
        hc hcVar;
        long jCb;
        long jMq;
        long j2;
        long j3;
        hc hcVar2 = this;
        int i2 = i;
        if (!c() || an()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jUo = uo();
        long jB = hcVar2.b(true);
        long j4 = jB / i2;
        com.ss.android.socialbase.downloader.an.d.hc(d, "retainLen:" + jB + " divideChunkForReuse chunkSize:" + j4 + " current host downloadChunk index:" + hcVar2.h);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                jMq = mq();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long jCb2 = cb();
                    j2 = jCb2;
                    j3 = jCb2 > jUo ? (jCb2 - jUo) + 1 : jB - (i4 * j4);
                    jMq = jUo;
                    long j5 = jB;
                    long j6 = j3;
                    hc hcVarD = new d(hcVar2.hc).d((-i3) - 1).d(jMq).hc(jUo).u(jUo).b(j2).c(j6).d(hcVar2).d();
                    com.ss.android.socialbase.downloader.an.d.hc(d, "divide sub chunk : " + i3 + " startOffset:" + jMq + " curOffset:" + jUo + " endOffset:" + j2 + " contentLen:" + j6);
                    arrayList.add(hcVarD);
                    jUo += j4;
                    i3++;
                    hcVar2 = this;
                    i2 = i;
                    jB = j5;
                } else {
                    jMq = jUo;
                }
            }
            j2 = (jUo + j4) - 1;
            j3 = j4;
            long j52 = jB;
            long j62 = j3;
            hc hcVarD2 = new d(hcVar2.hc).d((-i3) - 1).d(jMq).hc(jUo).u(jUo).b(j2).c(j62).d(hcVar2).d();
            com.ss.android.socialbase.downloader.an.d.hc(d, "divide sub chunk : " + i3 + " startOffset:" + jMq + " curOffset:" + jUo + " endOffset:" + j2 + " contentLen:" + j62);
            arrayList.add(hcVarD2);
            jUo += j4;
            i3++;
            hcVar2 = this;
            i2 = i;
            jB = j52;
        }
        long jW = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            hc hcVar3 = arrayList.get(size);
            if (hcVar3 != null) {
                jW += hcVar3.w();
            }
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, "reuseChunkContentLen:".concat(String.valueOf(jW)));
        hc hcVar4 = arrayList.get(0);
        if (hcVar4 != null) {
            if (cb() == 0) {
                jCb = j - mq();
            } else {
                jCb = (cb() - mq()) + 1;
            }
            hcVar4.d(jCb - jW);
            hcVar = this;
            hcVar4.b(hcVar.h);
            com.ss.android.socialbase.downloader.k.hc hcVar5 = hcVar.e;
            if (hcVar5 != null) {
                hcVar5.d(hcVar4.cb(), w() - jW);
            }
        } else {
            hcVar = this;
        }
        hcVar.d(arrayList);
        return arrayList;
    }

    public int rf() {
        return this.h;
    }

    public static class d {
        private int an;
        private long b;
        private long c;
        private int d;
        private hc gb;
        private long h;
        private long hc;
        private long u;

        public d(int i) {
            this.d = i;
        }

        public d d(long j) {
            this.hc = j;
            return this;
        }

        public d hc(long j) {
            this.b = j;
            return this;
        }

        public d b(long j) {
            this.c = j;
            return this;
        }

        public d c(long j) {
            this.u = j;
            return this;
        }

        public d d(int i) {
            this.an = i;
            return this;
        }

        public d d(hc hcVar) {
            this.gb = hcVar;
            return this;
        }

        public d u(long j) {
            this.h = j;
            return this;
        }

        public hc d() {
            return new hc(this);
        }
    }
}
