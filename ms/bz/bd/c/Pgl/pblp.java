package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblp implements IInterface {
    private final IBinder d;

    public pblp(IBinder iBinder) {
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
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f0e422", new byte[]{116, 61, 27, 14, 24, 42, 97, 24, 39, 42, com.sigmob.sdk.archives.tar.e.R, 34, 19, 78, 9, 32, 115, 24, com.sigmob.sdk.archives.tar.e.O, 97, 57, com.sigmob.sdk.archives.tar.e.f789K, 31, 68, 1, 107, 74, 1, com.sigmob.sdk.archives.tar.e.I, 106, com.sigmob.sdk.archives.tar.e.Q, com.sigmob.sdk.archives.tar.e.O, 0, 73, 14, 32, com.sigmob.sdk.archives.tar.e.P, 21, com.sigmob.sdk.archives.tar.e.I, 106, 99, 59, 16, 73, 8, com.sigmob.sdk.archives.tar.e.O, 86, 20, 38, 114, 126, com.sigmob.sdk.archives.tar.e.I, 19}));
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.d.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable th2) {
            th = th2;
            parcelObtain.recycle();
            parcelObtain2.recycle();
            mq.d(th);
            string = null;
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return string;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
