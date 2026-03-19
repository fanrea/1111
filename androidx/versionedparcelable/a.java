package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class a extends VersionedParcel {
    private final int bV;
    private final int bY;
    private final SparseIntArray wX;
    private final Parcel wY;
    private final String wZ;
    private int xa;
    private int xb;

    a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    private a(Parcel parcel, int i, int i2, String str) {
        this.wX = new SparseIntArray();
        this.xa = -1;
        this.xb = 0;
        this.wY = parcel;
        this.bV = i;
        this.bY = i2;
        this.xb = this.bV;
        this.wZ = str;
    }

    private int bq(int i) {
        int i2;
        do {
            int i3 = this.xb;
            if (i3 >= this.bY) {
                return -1;
            }
            this.wY.setDataPosition(i3);
            int i4 = this.wY.readInt();
            i2 = this.wY.readInt();
            this.xb += i4;
        } while (i2 != i);
        return this.wY.dataPosition();
    }

    public final boolean bo(int i) {
        int iBq = bq(i);
        if (iBq == -1) {
            return false;
        }
        this.wY.setDataPosition(iBq);
        return true;
    }

    public final void bp(int i) {
        fJ();
        this.xa = i;
        this.wX.put(i, this.wY.dataPosition());
        writeInt(0);
        writeInt(i);
    }

    public final void fJ() {
        int i = this.xa;
        if (i >= 0) {
            int i2 = this.wX.get(i);
            int iDataPosition = this.wY.dataPosition();
            this.wY.setDataPosition(i2);
            this.wY.writeInt(iDataPosition - i2);
            this.wY.setDataPosition(iDataPosition);
        }
    }

    protected final VersionedParcel fK() {
        Parcel parcel = this.wY;
        int iDataPosition = parcel.dataPosition();
        int i = this.xb;
        if (i == this.bV) {
            i = this.bY;
        }
        return new a(parcel, iDataPosition, i, this.wZ + "  ");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            this.wY.writeInt(bArr.length);
            this.wY.writeByteArray(bArr);
        } else {
            this.wY.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeInt(int i) {
        this.wY.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeString(String str) {
        this.wY.writeString(str);
    }

    public final void a(Parcelable parcelable) {
        this.wY.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int readInt() {
        return this.wY.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String readString() {
        return this.wY.readString();
    }

    public final byte[] fL() {
        int i = this.wY.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.wY.readByteArray(bArr);
        return bArr;
    }

    public final <T extends Parcelable> T fM() {
        return (T) this.wY.readParcelable(getClass().getClassLoader());
    }
}
