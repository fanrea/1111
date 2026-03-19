package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblb implements IInterface {
    private final IBinder d;

    public pblb(IBinder iBinder) {
        this.d = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.d;
    }

    public final String d() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d8a6e", new byte[]{36, 105, 70, 91, 8, 97, 32, 86, 39, 60, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.T, 5, 38, 28, 98, 37, 73, 108, 60, 34, 104, 95, 20, 27, 107, 17, 108, 77, 127, 14, 66, 66, 17, 40, 123, com.sigmob.sdk.archives.tar.e.I, 73, 64, Utf8.REPLACEMENT_BYTE, com.sigmob.sdk.archives.tar.e.f789K, 99, 89, 19, 8, 113, com.sigmob.sdk.archives.tar.e.H}));
            try {
                this.d.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable unused) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                string = null;
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return string;
            }
        } catch (Throwable unused2) {
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
