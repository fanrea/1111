package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.protected, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cprotected {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.protected$do, reason: invalid class name */
    public static final class Cdo {
        public final String a;
        public final boolean b;

        public Cdo(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.protected$if, reason: invalid class name */
    public static final class Cif implements ServiceConnection {
        public boolean a = false;
        public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

        public IBinder a() throws InterruptedException {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static Cdo a() throws PackageManager.NameNotFoundException {
        Context context;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Cif cif = new Cif();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, cif, 1)) {
                try {
                    IBinder iBinderA = cif.a();
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        iBinderA.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        parcelObtain = Parcel.obtain();
                        parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            parcelObtain.writeInt(1);
                            iBinderA.transact(2, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                            boolean z = parcelObtain2.readInt() != 0;
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return new Cdo(string, z);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception unused) {
                } finally {
                    context.unbindService(cif);
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }
}
