package net.security.device.api.id.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import com.alipay.sdk.m.k0.a;
import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class SamsungImpl implements IOAID {
    private final Context context;

    public SamsungImpl(Context context) {
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
                return packageManager.getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
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
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        try {
            if (this.context.bindService(intent, new ServiceConnection() { // from class: net.security.device.api.id.oaid.SamsungImpl.1
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Context context;
                    try {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        String string = null;
                        try {
                            parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                            if (iBinder.transact(1, parcelObtain, parcelObtain2, 0)) {
                                parcelObtain2.readException();
                                string = parcelObtain2.readString();
                            }
                        } catch (Throwable th) {
                            try {
                                th.printStackTrace();
                                parcelObtain2.recycle();
                                parcelObtain.recycle();
                                context = SamsungImpl.this.context;
                            } catch (Throwable th2) {
                                parcelObtain2.recycle();
                                parcelObtain.recycle();
                                SamsungImpl.this.context.unbindService(this);
                                throw th2;
                            }
                        }
                        if (string == null || string.length() == 0) {
                            throw new RuntimeException("Samsung OAID get failed");
                        }
                        iOAIDGetter.onOAIDGetComplete(string);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        context = SamsungImpl.this.context;
                        context.unbindService(this);
                    } catch (Exception e) {
                        iOAIDGetter.onOAIDGetError(e);
                    }
                }
            }, 1)) {
            } else {
                throw new RuntimeException("Samsung DeviceIdService bind failed");
            }
        } catch (Exception e) {
            iOAIDGetter.onOAIDGetError(e);
        }
    }
}
