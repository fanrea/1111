package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblt implements IInterface {
    private final IBinder d;

    public pblt(IBinder iBinder) {
        this.d = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String d() throws Throwable {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d68e76", new byte[]{118, 59, 70, 95, 18, com.sigmob.sdk.archives.tar.e.L, 110, 89, 109, com.sigmob.sdk.archives.tar.e.H, 99, 61, 72, 20, 1, 37, 116, 18, 123, 35, 124, com.sigmob.sdk.archives.tar.e.O, 78, 95, 33, 5, 98, 1, 96, com.sigmob.sdk.archives.tar.e.N, 112, 61, 79, 56, 6, com.sigmob.sdk.archives.tar.e.M, 98, 5, 111, com.sigmob.sdk.archives.tar.e.L, 118, com.sigmob.sdk.archives.tar.e.I}));
            } catch (Exception e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
            try {
                this.d.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Exception e2) {
                e = e2;
                mq.d(e);
                string = null;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            }
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th2) {
            th = th2;
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}
