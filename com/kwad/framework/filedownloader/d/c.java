package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobstat.forbes.Config;
import com.kwad.framework.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i) {
            return dG(i);
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        private static c[] dG(int i) {
            return new c[i];
        }
    };
    private String adR;
    private final AtomicInteger bgA;
    private final AtomicLong bgB;
    private long bgC;
    private String bgD;
    private String bgE;
    private int bgF;
    private boolean bgn;
    private boolean bgz;
    private String filename;
    private int id;
    private String url;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void g(String str, boolean z) {
        this.adR = str;
        this.bgz = z;
    }

    public final void d(byte b) {
        this.bgA.set(b);
    }

    public final void ax(long j) {
        this.bgB.set(j);
    }

    public final void ay(long j) {
        this.bgB.addAndGet(j);
    }

    public final void az(long j) {
        this.bgn = j > 2147483647L;
        this.bgC = j;
    }

    public final int getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getPath() {
        return this.adR;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), Mc(), getFilename());
    }

    public final String NN() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.cF(getTargetFilePath());
    }

    public final byte Mg() {
        return (byte) this.bgA.get();
    }

    public final long Ov() {
        return this.bgB.get();
    }

    public final long getTotal() {
        return this.bgC;
    }

    public final boolean isChunked() {
        return this.bgC == -1;
    }

    public final String Ow() {
        return this.bgE;
    }

    public final void cz(String str) {
        this.bgE = str;
    }

    private String Ox() {
        return this.bgD;
    }

    public final void cA(String str) {
        this.bgD = str;
    }

    public final void cB(String str) {
        this.filename = str;
    }

    public final boolean Mc() {
        return this.bgz;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final void dF(int i) {
        this.bgF = i;
    }

    public final int Oy() {
        return this.bgF;
    }

    public final void Oz() {
        this.bgF = 1;
    }

    public final ContentValues Ot() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", Byte.valueOf(Mg()));
        contentValues.put("sofar", Long.valueOf(Ov()));
        contentValues.put(Config.EXCEPTION_MEMORY_TOTAL, Long.valueOf(getTotal()));
        contentValues.put("errMsg", Ox());
        contentValues.put("etag", Ow());
        contentValues.put("connectionCount", Integer.valueOf(Oy()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(Mc()));
        if (Mc() && getFilename() != null) {
            contentValues.put("filename", getFilename());
        }
        return contentValues;
    }

    public final boolean Mm() {
        return this.bgn;
    }

    public final String toString() {
        return f.c("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.adR, Integer.valueOf(this.bgA.get()), this.bgB, Long.valueOf(this.bgC), this.bgE, super.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.adR);
        parcel.writeByte(this.bgz ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.bgA.get());
        parcel.writeLong(this.bgB.get());
        parcel.writeLong(this.bgC);
        parcel.writeString(this.bgD);
        parcel.writeString(this.bgE);
        parcel.writeInt(this.bgF);
        parcel.writeByte(this.bgn ? (byte) 1 : (byte) 0);
    }

    public c() {
        this.bgB = new AtomicLong();
        this.bgA = new AtomicInteger();
    }

    protected c(Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.adR = parcel.readString();
        this.bgz = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.bgA = new AtomicInteger(parcel.readByte());
        this.bgB = new AtomicLong(parcel.readLong());
        this.bgC = parcel.readLong();
        this.bgD = parcel.readString();
        this.bgE = parcel.readString();
        this.bgF = parcel.readInt();
        this.bgn = parcel.readByte() != 0;
    }
}
