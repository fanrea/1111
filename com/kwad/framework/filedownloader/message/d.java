package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class d extends MessageSnapshot {
    d(int i2) {
        super(i2);
        this.bgn = true;
    }

    d(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int Oi() {
        if (Om() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) Om();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int Oj() {
        if (Ok() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) Ok();
    }

    public static class f extends d {
        private final long bgl;
        private final long totalBytes;

        public byte Mg() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        f(f fVar) {
            this(fVar.getId(), fVar.Om(), fVar.Ok());
        }

        f(int i, long j, long j2) {
            super(i);
            this.bgl = j;
            this.totalBytes = j2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long Om() {
            return this.bgl;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long Ok() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.bgl);
            parcel.writeLong(this.totalBytes);
        }

        f(Parcel parcel) {
            super(parcel);
            this.bgl = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    public static class c extends d {
        private final String beI;
        private final boolean bgk;
        private final String fileName;
        private final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.bgk = z;
            this.totalBytes = j;
            this.beI = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.bgk ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.beI);
            parcel.writeString(this.fileName);
        }

        c(Parcel parcel) {
            super(parcel);
            this.bgk = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.beI = parcel.readString();
            this.fileName = parcel.readString();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.fileName;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean Oa() {
            return this.bgk;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long Ok() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.beI;
        }
    }

    public static class g extends d {
        private final long bgl;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        g(int i, long j) {
            super(i);
            this.bgl = j;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long Om() {
            return this.bgl;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.bgl);
        }

        g(Parcel parcel) {
            super(parcel);
            this.bgl = parcel.readLong();
        }
    }

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        a(int i, boolean z, long j) {
            super(i, true, j);
        }
    }

    public static class b extends d {
        private final boolean bgj;
        private final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        b(int i, boolean z, long j) {
            super(i);
            this.bgj = z;
            this.totalBytes = j;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.bgj ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        b(Parcel parcel) {
            super(parcel);
            this.bgj = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long Ok() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean Ol() {
            return this.bgj;
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$d, reason: collision with other inner class name */
    public static class C0559d extends d {
        private final long bgl;
        private final Throwable bgm;

        @Override // com.kwad.framework.filedownloader.message.c
        public byte Mg() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        C0559d(int i, long j, Throwable th) {
            super(i);
            this.bgl = j;
            this.bgm = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long Om() {
            return this.bgl;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable On() {
            return this.bgm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.bgl);
            parcel.writeSerializable(this.bgm);
        }

        C0559d(Parcel parcel) {
            super(parcel);
            this.bgl = parcel.readLong();
            this.bgm = (Throwable) parcel.readSerializable();
        }
    }

    public static class h extends C0559d {
        private final int bfS;

        @Override // com.kwad.framework.filedownloader.message.d.C0559d, com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0559d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.bfS = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int Mk() {
            return this.bfS;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0559d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.bfS);
        }

        h(Parcel parcel) {
            super(parcel);
            this.bfS = parcel.readInt();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) -4;
        }

        j(int i, long j, long j2) {
            super(i, j, j2);
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot Oo() {
            return new f(this);
        }
    }

    public static class e extends f {
        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) -2;
        }

        e(int i, long j, long j2) {
            super(i, j, j2);
        }
    }
}
