package ca.da.da;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import ca.da.da.n;
import ca.da.da.v;
import ca.fa.ca.a;
import com.bytedance.apm.common.utility.PackageUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: OnePlusOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class r implements n {
    public final n a;
    public ca.da.da.b<Boolean> b = new a(this);

    /* compiled from: OnePlusOaidImpl.java */
    public class a extends ca.da.da.b<Boolean> {
        public a(r rVar) {
        }

        @Override // ca.da.da.b
        public Boolean a(Object[] objArr) {
            try {
                PackageInfo packageInfo = PackageUtils.getPackageInfo((Context) objArr[0], "com.heytap.openid");
                if (packageInfo == null) {
                    return false;
                }
                return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public r(n nVar) {
        this.a = nVar;
    }

    @Override // ca.da.da.n
    public n.a a(Context context) {
        if (this.a != null && !this.b.b(new Object[0]).booleanValue()) {
            return this.a.a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new v(context, intent, new b(context)).a();
        n.a aVar = new n.a();
        aVar.a = str;
        return aVar;
    }

    @Override // ca.da.da.n
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolB = this.b.b(context);
        return (this.a == null || boolB.booleanValue()) ? boolB.booleanValue() : this.a.b(context);
    }

    public final String c(Context context) throws NoSuchAlgorithmException {
        PackageInfo packageSignature;
        try {
            packageSignature = PackageUtils.getPackageSignature(context, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Signature[] signatureArr = packageSignature != null ? packageSignature.signatures : null;
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* compiled from: OnePlusOaidImpl.java */
    public class b implements v.b<ca.fa.ca.a, String> {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // ca.da.da.v.b
        public String a(ca.fa.ca.a aVar) throws Exception {
            ca.fa.ca.a aVar2 = aVar;
            if (aVar2 != null) {
                String strC = r.this.c(this.a);
                if (!TextUtils.isEmpty(strC)) {
                    String packageName = this.a.getPackageName();
                    a.AbstractBinderC0039a.C0040a c0040a = (a.AbstractBinderC0039a.C0040a) aVar2;
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        parcelObtain.writeString(packageName);
                        parcelObtain.writeString(strC);
                        parcelObtain.writeString("OUID");
                        c0040a.a.transact(1, parcelObtain, parcelObtain2, 0);
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

        @Override // ca.da.da.v.b
        public ca.fa.ca.a a(IBinder iBinder) {
            return a.AbstractBinderC0039a.a(iBinder);
        }
    }
}
