package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import java.lang.reflect.InvocationHandler;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class TNative$aa {

    /* compiled from: A */
    public static class bb implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static native SparseArray<Object> a90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Map<Integer, String> map2, int i);

    public static native SparseArray<Object> b90_BD4FE23C352252DC(SparseArray<Object> sparseArray, byte[] bArr, Map<String, String> map, int i);

    public static native SparseArray<Object> c90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context);

    public static native SparseArray<Object> d90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context, int i);

    public static native SparseArray<Object> e90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> f90_BD4FE23C352252DC(SparseArray<Object> sparseArray, byte[] bArr, int i);

    public static native SparseArray<Object> g90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> h90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> i90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Object obj, Object obj2, Object obj3);

    public static native String j90_BD4FE23C352252DC();

    public static native byte[] k90_BD4FE23C352252DC(byte[] bArr);

    public static native void l90_BD4FE23C352252DC(InvocationHandler invocationHandler, AtomicReference<Object> atomicReference, ClassLoader classLoader);

    public static native SparseArray<Object> m90_BD4FE23C352252DC(SparseArray<Object> sparseArray, Context context, Map<String, String> map);
}
