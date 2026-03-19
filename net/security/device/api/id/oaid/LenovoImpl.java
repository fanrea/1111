package net.security.device.api.id.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import com.alipay.sdk.m.q0.a;
import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class LenovoImpl implements IOAID {
    private final Context context;

    public LenovoImpl(Context context) {
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
                return packageManager.getPackageInfo("com.zui.deviceidservice", 0) != null;
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
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        try {
            if (this.context.bindService(intent, new ServiceConnection() { // from class: net.security.device.api.id.oaid.LenovoImpl.1
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
                            try {
                                parcelObtain.writeInterfaceToken(a.AbstractBinderC0056a.a);
                                if (iBinder.transact(4, parcelObtain, parcelObtain2, 0)) {
                                    parcelObtain2.readException();
                                    string = parcelObtain2.readString();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                parcelObtain2.recycle();
                                parcelObtain.recycle();
                                context = LenovoImpl.this.context;
                            }
                            if (string == null || string.length() == 0) {
                                throw new RuntimeException("Lenovo deviceId get failed");
                            }
                            iOAIDGetter.onOAIDGetComplete(string);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            context = LenovoImpl.this.context;
                            context.unbindService(this);
                        } catch (Throwable th) {
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            LenovoImpl.this.context.unbindService(this);
                            throw th;
                        }
                    } catch (Exception e2) {
                        iOAIDGetter.onOAIDGetError(e2);
                    }
                }
            }, 1)) {
                return;
            }
            iOAIDGetter.onOAIDGetError(new RuntimeException("Lenovo DeviceidService bind failed"));
        } catch (Exception e) {
            iOAIDGetter.onOAIDGetError(e);
        }
    }
}
