package com.netease.htprotect.p000O8oO888;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.netease.htprotect.O8〇oO8〇88.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: com.netease.htprotect.O8〇oO8〇88.O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
    private static final class ServiceConnectionC0660O8oO888 implements ServiceConnection {

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        boolean f28Ooo = false;

        /* renamed from: 〇O8, reason: contains not printable characters */
        private final LinkedBlockingQueue f27O8 = new LinkedBlockingQueue(1);

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        long f26O8oO888 = 2000;

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final IBinder m480O8oO888() throws InterruptedException {
            if (this.f28Ooo) {
                throw new IllegalStateException();
            }
            this.f28Ooo = true;
            return (IBinder) this.f27O8.poll(this.f26O8oO888, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f27O8.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.netease.htprotect.O8〇oO8〇88.O8〇oO8〇88$〇O8, reason: invalid class name */
    private static final class O8 implements IInterface {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private final IBinder f29O8oO888;

        public O8(IBinder iBinder) {
            this.f29O8oO888 = iBinder;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final String m481O8oO888() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f29O8oO888.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f29O8oO888;
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public final boolean m482Ooo() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.f29O8oO888.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    /* renamed from: com.netease.htprotect.O8〇oO8〇88.O8〇oO8〇88$〇Ooo, reason: invalid class name */
    public static final class Ooo {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private final String f30O8oO888;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private final boolean f31Ooo;

        Ooo(String str, boolean z) {
            this.f30O8oO888 = str;
            this.f31Ooo = z;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private String m483O8oO888() {
            return this.f30O8oO888;
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private boolean m486Ooo() {
            return this.f31Ooo;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m478O8oO888(Context context) {
        try {
            Ooo oooM479Ooo = m479Ooo(context);
            if (oooM479Ooo.f31Ooo) {
                return oooM479Ooo.f30O8oO888;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static Ooo m479Ooo(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC0660O8oO888 serviceConnectionC0660O8oO888 = new ServiceConnectionC0660O8oO888();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, serviceConnectionC0660O8oO888, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    O8 o8 = new O8(serviceConnectionC0660O8oO888.m480O8oO888());
                    return new Ooo(o8.m481O8oO888(), o8.m482Ooo());
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                context.unbindService(serviceConnectionC0660O8oO888);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
