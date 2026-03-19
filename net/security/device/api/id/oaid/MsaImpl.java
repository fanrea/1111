package net.security.device.api.id.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class MsaImpl implements IOAID {
    private final Context context;

    public MsaImpl(Context context) {
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
                return packageManager.getPackageInfo("com.mdid.msa", 0) != null;
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
        startMsaKlService();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.context.getPackageName());
        try {
            if (this.context.bindService(intent, new ServiceConnection() { // from class: net.security.device.api.id.oaid.MsaImpl.1
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Context context;
                    String string = null;
                    try {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                            if (iBinder.transact(3, parcelObtain, parcelObtain2, 0)) {
                                parcelObtain2.readException();
                                string = parcelObtain2.readString();
                            }
                        } catch (Throwable th) {
                            try {
                                th.printStackTrace();
                                parcelObtain.recycle();
                                parcelObtain2.recycle();
                                context = MsaImpl.this.context;
                            } catch (Throwable th2) {
                                parcelObtain.recycle();
                                parcelObtain2.recycle();
                                MsaImpl.this.context.unbindService(this);
                                throw th2;
                            }
                        }
                        if (string == null || string.length() == 0) {
                            throw new RuntimeException("Msa oaid get failed");
                        }
                        iOAIDGetter.onOAIDGetComplete(string);
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        context = MsaImpl.this.context;
                        context.unbindService(this);
                    } catch (Exception e) {
                        iOAIDGetter.onOAIDGetError(e);
                    }
                }
            }, 1)) {
            } else {
                throw new RuntimeException("MsaIdService bind failed");
            }
        } catch (Exception e) {
            iOAIDGetter.onOAIDGetError(e);
        }
    }

    private void startMsaKlService() {
        if (this.context == null) {
            return;
        }
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.context.getPackageName());
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.context.startService(intent);
        } catch (Exception unused) {
        }
    }
}
