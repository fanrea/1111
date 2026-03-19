package com.bytedance.pangle.an;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.an.an;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.component.a.a.b;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements an.d {
    private static volatile IBinder d;
    private static volatile Object hc;

    public interface d {
    }

    private static String[] d(String... strArr) {
        return strArr;
    }

    @Override // com.bytedance.pangle.an.an.d
    public boolean d(String str, int i) throws IllegalAccessException, IllegalArgumentException {
        d();
        hc(str, i);
        boolean zD = d(b.e.a, str, i);
        b(str, i);
        return zD;
    }

    private static void d() throws IllegalAccessException, IllegalArgumentException {
        PackageManager packageManager;
        Field fieldD;
        IBinder iBinderAsBinder;
        if (d == null && (fieldD = d((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object objD = d(fieldD, packageManager);
            hc = objD;
            if ((objD instanceof IInterface) && (iBinderAsBinder = ((IInterface) hc).asBinder()) != null) {
                d = iBinderAsBinder;
            }
        }
    }

    private static boolean d(String str, String str2, int i) {
        String str3 = com.bytedance.pangle.u.b.gb(str2, i) + File.separator + com.bytedance.pangle.an.hc.d(com.bytedance.pangle.u.b.u(str2, i));
        for (int i2 = 1; i2 <= 3; i2++) {
            d(d(str), (d) null);
            if (com.bytedance.pangle.an.hc.d(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void hc(String str, int i) {
        if (str == null) {
            return;
        }
        String strHc = com.bytedance.pangle.u.b.hc(str, i);
        String strU = com.bytedance.pangle.u.b.u(str, i);
        d(strHc, strU);
        d(Zeus.getAppApplication().getPackageName(), strU, com.bytedance.pangle.an.hc.d());
    }

    private static void d(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT == 30) {
            hc(str, str2, str3);
        } else if (Build.VERSION.SDK_INT == 29) {
            b(str, str2, str3);
        }
    }

    private static void hc(String str, String str2, String str3) {
        if (hc == null || str == null || str2 == null || str3 == null) {
            return;
        }
        d(hc, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void b(String str, String str2, String str3) {
        if (hc == null || str == null || str2 == null || str3 == null) {
            return;
        }
        d(hc, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static void b(String str, int i) {
        if (str == null) {
            return;
        }
        hc(com.bytedance.pangle.u.b.h(str, i), com.bytedance.pangle.u.b.an(str, i));
        hc(com.bytedance.pangle.u.b.u(str, i));
        hc();
    }

    private static void hc() {
        d(b(), (d) null);
    }

    private static void d(String[] strArr, d dVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeFileDescriptor(FileDescriptor.in);
        parcelObtain.writeFileDescriptor(FileDescriptor.out);
        parcelObtain.writeFileDescriptor(FileDescriptor.err);
        parcelObtain.writeStringArray(strArr);
        parcelObtain.writeStrongBinder(null);
        new hc(dVar).writeToParcel(parcelObtain, 0);
        try {
            d.transact(1598246212, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
    }

    private static String[] d(String str) {
        return d("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static String[] b() {
        return d("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void d(String str, String str2) {
        try {
            com.bytedance.pangle.util.gb.d(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void hc(String str, String str2) {
        try {
            com.bytedance.pangle.util.h.d(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void hc(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static class hc extends ResultReceiver {
        private d d;

        public hc(d dVar) {
            super(null);
            this.d = dVar;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    public static Field d(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return d(obj.getClass(), str);
    }

    public static Field d(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object d(Field field, Object obj) throws IllegalAccessException, IllegalArgumentException {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object d(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
