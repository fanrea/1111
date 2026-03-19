package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.c.b;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface HWIDInterface extends IInterface {
    boolean getBoos();

    String getIDs();

    public static final class a implements HWIDInterface {
        private IBinder bEj;

        public a(IBinder iBinder) {
            this.bEj = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.bEj;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HWIDInterface
        public final String getIDs() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    this.bEj.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    string = null;
                }
                return string;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HWIDInterface
        public final boolean getBoos() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z = false;
            try {
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    this.bEj.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() == 0) {
                        z = true;
                    }
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                }
                return z;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
