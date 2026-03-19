package com.baidu.mobads.container.util.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bk;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u implements ServiceConnection {
    final /* synthetic */ Context a;

    u(Context context) {
        this.a = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws NoSuchAlgorithmException {
        Signature[] signatureArr;
        String string;
        z.a(this.a, "oppo-connect", "");
        iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
        String packageName = this.a.getPackageName();
        String string2 = null;
        try {
            signatureArr = bk.a(this.a, packageName, 64).signatures;
        } catch (Exception e) {
            e.printStackTrace();
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest == null) {
                    string = null;
                } else {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    string = sb.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            string = null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(packageName);
                parcelObtain.writeString(string);
                parcelObtain.writeString("OUID");
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string2 = parcelObtain2.readString();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            parcelObtain.recycle();
            parcelObtain2.recycle();
            if (!TextUtils.isEmpty(string2)) {
                z.a(string2);
                z.a(this.a, "oppo-valid", string2);
                z.a(2592000000L, string2);
            } else {
                z.a(this.a, "oppo-empty", "");
            }
            if (!"oppo".equalsIgnoreCase(com.baidu.mobads.container.util.x.a(this.a).e())) {
                z.a(this.a, "oppo");
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
