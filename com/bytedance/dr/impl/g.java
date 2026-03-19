package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.alipay.sdk.m.q0.a;
import com.bytedance.bdtracker.n5;
import com.bytedance.dr.aidl.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class g extends b<com.bytedance.dr.aidl.c> {

    public class a implements n5.b<com.bytedance.dr.aidl.c, String> {
        public a(g gVar) {
        }

        @Override // com.bytedance.bdtracker.n5.b
        public com.bytedance.dr.aidl.c a(IBinder iBinder) {
            return c.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.n5.b
        public String a(com.bytedance.dr.aidl.c cVar) {
            com.bytedance.dr.aidl.c cVar2 = cVar;
            if (cVar2 == null) {
                return null;
            }
            c.a.C0193a c0193a = (c.a.C0193a) cVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(a.AbstractBinderC0056a.a);
                c0193a.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public g() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public n5.b<com.bytedance.dr.aidl.c, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Lenovo";
    }
}
