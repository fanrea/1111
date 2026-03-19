package net.security.device.api.id.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;
import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class OppoImpl implements IOAID {
    private final Context context;
    private String sign;

    public OppoImpl(Context context) {
        this.context = context;
    }

    @Override // net.security.device.api.id.IOAID
    public boolean supportOAID() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.heytap.openid", 0) != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // net.security.device.api.id.IOAID
    public void doGet(final IOAIDGetter iOAIDGetter) {
        if (this.context == null) {
            iOAIDGetter.onOAIDGetError(new NullPointerException("OAID context is null"));
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        try {
            if (this.context.bindService(intent, new ServiceConnection() { // from class: net.security.device.api.id.oaid.OppoImpl.1
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Context context;
                    String strRealGetOUID;
                    try {
                        try {
                            strRealGetOUID = OppoImpl.this.realGetOUID(iBinder);
                        } catch (Throwable th) {
                            try {
                                th.printStackTrace();
                                context = OppoImpl.this.context;
                            } catch (Throwable th2) {
                                OppoImpl.this.context.unbindService(this);
                                throw th2;
                            }
                        }
                        if (strRealGetOUID == null || strRealGetOUID.length() == 0) {
                            throw new RuntimeException("HeyTap OUID get failed");
                        }
                        iOAIDGetter.onOAIDGetComplete(strRealGetOUID);
                        context = OppoImpl.this.context;
                        context.unbindService(this);
                    } catch (Exception e) {
                        iOAIDGetter.onOAIDGetError(e);
                    }
                }
            }, 1)) {
            } else {
                throw new RuntimeException("HeyTap IdentifyService bind failed");
            }
        } catch (Exception e) {
            iOAIDGetter.onOAIDGetError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String realGetOUID(IBinder iBinder) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        byte[] byteArray;
        byte[] bArrDigest;
        Context context = this.context;
        if (context == null || iBinder == null) {
            return null;
        }
        String packageName = context.getPackageName();
        if (this.sign == null) {
            try {
                PackageManager packageManager = this.context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 64)) != null && (signatureArr = packageInfo.signatures) != null && (byteArray = signatureArr[0].toByteArray()) != null && (bArrDigest = MessageDigest.getInstance("SHA1").digest(byteArray)) != null) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    this.sign = sb.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(packageName);
                parcelObtain.writeString(this.sign);
                parcelObtain.writeString("OUID");
                if (iBinder.transact(1, parcelObtain, parcelObtain2, 0)) {
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
