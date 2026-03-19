package net.security.device.api.id.gaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import net.security.device.api.id.IGAID;
import net.security.device.api.id.IGAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class GAIDImpl implements IGAID {
    private final Context context;

    public GAIDImpl(Context context) {
        this.context = context;
    }

    @Override // net.security.device.api.id.IGAID
    public boolean supportGAID() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.google.android.gms", 0) != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // net.security.device.api.id.IGAID
    public void doGet(final IGAIDGetter iGAIDGetter) {
        if (this.context == null) {
            iGAIDGetter.onGAIDGetError(new NullPointerException("OAID context is null"));
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (this.context.bindService(intent, new ServiceConnection() { // from class: net.security.device.api.id.gaid.GAIDImpl.1
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
                            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            if (iBinder.transact(1, parcelObtain, parcelObtain2, 0)) {
                                parcelObtain2.readException();
                                string = parcelObtain2.readString();
                            }
                        } catch (Throwable th) {
                            try {
                                th.printStackTrace();
                                parcelObtain.recycle();
                                parcelObtain2.recycle();
                                context = GAIDImpl.this.context;
                            } catch (Throwable th2) {
                                parcelObtain.recycle();
                                parcelObtain2.recycle();
                                GAIDImpl.this.context.unbindService(this);
                                throw th2;
                            }
                        }
                        if (string == null || string.length() == 0) {
                            throw new RuntimeException("Get gaid failed");
                        }
                        iGAIDGetter.onGAIDGetComplete(string);
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        context = GAIDImpl.this.context;
                        context.unbindService(this);
                    } catch (Exception e) {
                        iGAIDGetter.onGAIDGetError(e);
                    }
                }
            }, 1)) {
            } else {
                throw new RuntimeException("com.google.android.gms Service bind failed");
            }
        } catch (Exception e) {
            iGAIDGetter.onGAIDGetError(e);
        }
    }
}
