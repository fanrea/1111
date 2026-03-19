package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class h extends MessageSnapshot {
    h(int i2) {
        super(i2);
        this.bgn = false;
    }

    h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long Ok() {
        return Oj();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long Om() {
        return Oi();
    }

    public static class f extends h {
        private final int bgw;
        private final int bgx;

        public byte Mg() {
            return (byte) 1;
        }

        f(f fVar) {
            this(fVar.getId(), fVar.Oi(), fVar.Oj());
        }

        f(int i, int i2, int i3) {
            super(i);
            this.bgx = i2;
            this.bgw = i3;
        }

        f(Parcel parcel) {
            super(parcel);
            this.bgx = parcel.readInt();
            this.bgw = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.bgx);
            parcel.writeInt(this.bgw);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int Oi() {
            return this.bgx;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int Oj() {
            return this.bgw;
        }
    }

    public static class c extends h {
        private final String beI;
        private final boolean bgk;
        private final int bgw;
        private final String fileName;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.bgk = z;
            this.bgw = i2;
            this.beI = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.bgk ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bgw);
            parcel.writeString(this.beI);
            parcel.writeString(this.fileName);
        }

        c(Parcel parcel) {
            super(parcel);
            this.bgk = parcel.readByte() != 0;
            this.bgw = parcel.readInt();
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
        public final int Oj() {
            return this.bgw;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.beI;
        }
    }

    public static class g extends h {
        private final int bgx;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        g(int i, int i2) {
            super(i);
            this.bgx = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int Oi() {
            return this.bgx;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.bgx);
        }

        g(Parcel parcel) {
            super(parcel);
            this.bgx = parcel.readInt();
        }
    }

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    public static class b extends h {
        private final boolean bgj;
        private final int bgw;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        b(int i, boolean z, int i2) {
            super(i);
            this.bgj = z;
            this.bgw = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.bgj ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bgw);
        }

        b(Parcel parcel) {
            super(parcel);
            this.bgj = parcel.readByte() != 0;
            this.bgw = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int Oj() {
            return this.bgw;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean Ol() {
            return this.bgj;
        }
    }

    public static class d extends h {
        private final Throwable bgm;
        private final int bgx;

        @Override // com.kwad.framework.filedownloader.message.c
        public byte Mg() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        d(int i, int i2, Throwable th) {
            super(i);
            this.bgx = i2;
            this.bgm = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int Oi() {
            return this.bgx;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable On() {
            return this.bgm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.bgx);
            parcel.writeSerializable(this.bgm);
        }

        d(Parcel parcel) {
            super(parcel);
            this.bgx = parcel.readInt();
            this.bgm = (Throwable) parcel.readSerializable();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$h, reason: collision with other inner class name */
    public static class C0560h extends d {
        private final int bfS;

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        C0560h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.bfS = i3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int Mk() {
            return this.bfS;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.bfS);
        }

        C0560h(Parcel parcel) {
            super(parcel);
            this.bfS = parcel.readInt();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) -4;
        }

        j(int i, int i2, int i3) {
            super(i, i2, i3);
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
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte Mg() {
            return (byte) -2;
        }

        e(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }
}
