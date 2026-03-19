package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Taurus extends Solar {
    public static final String b = Cfinally.a(Cfinally.i);

    @Override // com.tencent.turingfd.sdk.ams.au.Solar
    public String a(IBinder iBinder) throws Exception {
        Context context;
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        String packageName = context.getPackageName();
        Signature[] signatureArrA = Cimplements.a(context, packageName);
        String string = null;
        if (signatureArrA != null && signatureArrA.length > 0) {
            byte[] byteArray = signatureArrA[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArrDigest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                    }
                    string = sb.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String strA = Cfinally.a(Cfinally.j);
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(b);
            parcelObtain.writeString(packageName);
            parcelObtain.writeString(string);
            parcelObtain.writeString(strA);
            iBinder.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
