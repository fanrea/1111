package com.bytedance.dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.f5;
import com.bytedance.bdtracker.n5;
import com.bytedance.bdtracker.t4;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.aidl.e;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class k implements OaidApi {
    public final OaidApi a;
    public f5<Boolean> b = new a(this);

    public class a extends f5<Boolean> {
        public a(k kVar) {
        }

        @Override // com.bytedance.bdtracker.f5
        public Boolean a(Object[] objArr) {
            try {
                PackageInfo packageInfoA = t4.a((Context) objArr[0], "com.heytap.openid", 0);
                if (packageInfoA == null) {
                    return false;
                }
                return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfoA.getLongVersionCode() : (long) packageInfoA.versionCode) >= 1);
            } catch (Throwable th) {
                LoggerImpl.global().error(1, "Get package:{} info failed", th, "com.heytap.openid");
                return false;
            }
        }
    }

    public class b implements n5.b<com.bytedance.dr.aidl.e, String> {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.n5.b
        public com.bytedance.dr.aidl.e a(IBinder iBinder) {
            return e.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.n5.b
        public String a(com.bytedance.dr.aidl.e eVar) {
            com.bytedance.dr.aidl.e eVar2 = eVar;
            if (eVar2 != null) {
                String strA = k.this.a(this.a);
                if (!TextUtils.isEmpty(strA)) {
                    String packageName = this.a.getPackageName();
                    e.a.C0195a c0195a = (e.a.C0195a) eVar2;
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        parcelObtain.writeString(packageName);
                        parcelObtain.writeString(strA);
                        parcelObtain.writeString("OUID");
                        c0195a.a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        return parcelObtain2.readString();
                    } finally {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                }
            }
            return null;
        }
    }

    public k(OaidApi oaidApi) {
        this.a = oaidApi;
    }

    public final String a(Context context) {
        PackageInfo packageInfoA;
        try {
            packageInfoA = t4.a(context, context.getPackageName(), 64);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "getPackageInfo failed", th, new Object[0]);
        }
        Signature[] signatureArr = packageInfoA != null ? packageInfoA.signatures : null;
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArrDigest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                    }
                    return sb.toString();
                }
            } catch (Throwable th2) {
                LoggerImpl.global().error(1, "Sign package info failed", th2, new Object[0]);
            }
        }
        return null;
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return (this.a == null || this.b.b(new Object[0]).booleanValue()) ? "OnePlus/Oppo" : this.a.getName();
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        if (this.a != null && !this.b.b(new Object[0]).booleanValue()) {
            return this.a.getOaid(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new n5(context, intent, new b(context)).a();
        OaidApi.a aVar = new OaidApi.a();
        aVar.a = str;
        return aVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolB = this.b.b(context);
        return (this.a == null || boolB.booleanValue()) ? boolB.booleanValue() : this.a.support(context);
    }
}
