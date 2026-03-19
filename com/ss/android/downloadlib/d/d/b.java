package com.ss.android.downloadlib.d.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.d.d.c;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface b extends IInterface {
    void d(hc hcVar, c cVar) throws RemoteException;

    public static abstract class d extends Binder implements b {
        private static String d = "";

        public static b d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(d);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) {
                return new C0755d(iBinder);
            }
            return (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(d);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(d);
                d(parcel.readInt() != 0 ? hc.CREATOR.createFromParcel(parcel) : null, c.d.d(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* renamed from: com.ss.android.downloadlib.d.d.b$d$d, reason: collision with other inner class name */
        private static class C0755d implements b {
            private IBinder d;

            C0755d(IBinder iBinder) {
                if (TextUtils.isEmpty(d.d)) {
                    JSONObject jSONObjectTt = mq.tt();
                    String unused = d.d = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString(t.k), jSONObjectTt.optString("s"));
                }
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.ss.android.downloadlib.d.d.b
            public void d(hc hcVar, c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.d);
                    if (hcVar != null) {
                        parcelObtain.writeInt(1);
                        hcVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
