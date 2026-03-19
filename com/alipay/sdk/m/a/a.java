package com.alipay.sdk.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* renamed from: com.alipay.sdk.m.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0044a extends Binder implements a {

        /* renamed from: com.alipay.sdk.m.a.a$a$a, reason: collision with other inner class name */
        public static class C0045a implements a {
            public IBinder a;

            public C0045a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0045a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    public class b {
        public static boolean a = false;
        public static boolean b = false;
    }

    public class c {
        public a a = null;
        public String b = null;
        public String c = null;
        public final Object d = new Object();
        public ServiceConnection e = new ServiceConnectionC0046a();

        /* renamed from: com.alipay.sdk.m.a.a$c$a, reason: collision with other inner class name */
        public class ServiceConnectionC0046a implements ServiceConnection {
            public ServiceConnectionC0046a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.a = AbstractBinderC0044a.a(iBinder);
                synchronized (c.this.d) {
                    c.this.d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                c.this.a = null;
            }
        }

        public static class b {
            public static final c a = new c(null);
        }

        public /* synthetic */ c(ServiceConnectionC0046a serviceConnectionC0046a) {
        }

        public boolean a(Context context) throws PackageManager.NameNotFoundException {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }

        public final String b(Context context, String str) throws NoSuchAlgorithmException {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.b)) {
                this.b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.c)) {
                String string = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    signatureArr = null;
                }
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
                            string = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.c = string;
            }
            String strA = ((AbstractBinderC0044a.C0045a) this.a).a(this.b, this.c, str);
            return TextUtils.isEmpty(strA) ? "" : strA;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized java.lang.String a(android.content.Context r5, java.lang.String r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                android.os.Looper r0 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L6f
                android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L6f
                if (r0 == r1) goto L67
                com.alipay.sdk.m.a.a r0 = r4.a     // Catch: java.lang.Throwable -> L6f
                if (r0 != 0) goto L59
                android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L6f
                r0.<init>()     // Catch: java.lang.Throwable -> L6f
                android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L6f
                java.lang.String r2 = "com.heytap.openid"
                java.lang.String r3 = "com.heytap.openid.IdentifyService"
                r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6f
                r0.setComponent(r1)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r1 = "action.com.heytap.openid.OPEN_ID_SERVICE"
                r0.setAction(r1)     // Catch: java.lang.Throwable -> L6f
                android.content.ServiceConnection r1 = r4.e     // Catch: java.lang.Throwable -> L6f
                r2 = 1
                boolean r0 = r5.bindService(r0, r1, r2)     // Catch: java.lang.Throwable -> L6f
                if (r0 == 0) goto L43
                java.lang.Object r0 = r4.d     // Catch: java.lang.Throwable -> L6f
                monitor-enter(r0)     // Catch: java.lang.Throwable -> L6f
                java.lang.Object r1 = r4.d     // Catch: java.lang.Throwable -> L39 java.lang.InterruptedException -> L3b
                r2 = 3000(0xbb8, double:1.482E-320)
                r1.wait(r2)     // Catch: java.lang.Throwable -> L39 java.lang.InterruptedException -> L3b
                goto L3f
            L39:
                r5 = move-exception
                goto L41
            L3b:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L39
            L3f:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
                goto L43
            L41:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
                throw r5     // Catch: java.lang.Throwable -> L6f
            L43:
                com.alipay.sdk.m.a.a r0 = r4.a     // Catch: java.lang.Throwable -> L6f
                if (r0 != 0) goto L4b
                java.lang.String r5 = ""
                monitor-exit(r4)
                return r5
            L4b:
                java.lang.String r5 = r4.b(r5, r6)     // Catch: android.os.RemoteException -> L51 java.lang.Throwable -> L6f
                monitor-exit(r4)
                return r5
            L51:
                r5 = move-exception
                r5.printStackTrace()     // Catch: java.lang.Throwable -> L6f
                java.lang.String r5 = ""
                monitor-exit(r4)
                return r5
            L59:
                java.lang.String r5 = r4.b(r5, r6)     // Catch: android.os.RemoteException -> L5f java.lang.Throwable -> L6f
                monitor-exit(r4)
                return r5
            L5f:
                r5 = move-exception
                r5.printStackTrace()     // Catch: java.lang.Throwable -> L6f
                java.lang.String r5 = ""
                monitor-exit(r4)
                return r5
            L67:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6f
                java.lang.String r6 = "Cannot run on MainThread"
                r5.<init>(r6)     // Catch: java.lang.Throwable -> L6f
                throw r5     // Catch: java.lang.Throwable -> L6f
            L6f:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a.a.c.a(android.content.Context, java.lang.String):java.lang.String");
        }
    }
}
