package com.qq.e.comm.plugin;

import android.net.InetAddresses;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import androidx.core.location.LocationRequestCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k9 extends LinkedHashMap {
    private static final String g = "kg";
    private static Field h;
    private static Field i;
    private static Method j;
    private static Method m;
    private Field a;
    private final Field b;
    private final Field c;
    private Constructor<?> d;
    private final CopyOnWriteArraySet<String> e;
    private long f;

    private static String a(InetAddress... inetAddressArr) {
        return "";
    }

    public k9() throws Exception {
        try {
            Field declaredField = Class.forName("java.net.AddressCache$AddressCacheKey").getDeclaredField("mHostname");
            declaredField.setAccessible(true);
            this.a = declaredField;
        } catch (Throwable unused) {
        }
        Class<?> cls = Class.forName("java.net.AddressCache$AddressCacheEntry");
        Field declaredField2 = cls.getDeclaredField(com.alipay.sdk.m.p0.b.d);
        declaredField2.setAccessible(true);
        this.b = declaredField2;
        Field declaredField3 = cls.getDeclaredField("expiryNanos");
        declaredField3.setAccessible(true);
        this.c = declaredField3;
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Object.class);
            declaredConstructor.setAccessible(true);
            this.d = declaredConstructor;
        } catch (Exception unused2) {
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(Object.class, Long.TYPE);
            declaredConstructor2.setAccessible(true);
            this.d = declaredConstructor2;
        }
        try {
            Field declaredField4 = InetAddress.class.getDeclaredField("hostName");
            declaredField4.setAccessible(true);
            h = declaredField4;
        } catch (Exception unused3) {
            Field declaredField5 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredField("hostName");
            declaredField5.setAccessible(true);
            i = declaredField5;
            Method declaredMethod = InetAddress.class.getDeclaredMethod("holder", new Class[0]);
            declaredMethod.setAccessible(true);
            j = declaredMethod;
        }
        this.e = new CopyOnWriteArraySet<>(kg.d().h());
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        String str;
        Object objNewInstance;
        try {
            Field field = this.a;
            if (field != null) {
                obj = field.get(obj);
            }
            str = (String) obj;
        } catch (Exception e) {
            Log.getStackTraceString(e);
        }
        if (!TextUtils.isEmpty(str) && this.e.contains(str)) {
            InetAddress[] inetAddressArrB = b(str);
            if (inetAddressArrB != null && inetAddressArrB.length > 0) {
                if (this.d.getParameterTypes().length == 1) {
                    objNewInstance = this.d.newInstance(inetAddressArrB);
                } else {
                    objNewInstance = this.d.newInstance(inetAddressArrB, Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL));
                }
                this.c.set(objNewInstance, Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL));
                return objNewInstance;
            }
            if (kg.d().b() > 1) {
                kg.d().a(false);
            }
            this.f = SystemClock.elapsedRealtime();
            return null;
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        try {
            Field field = this.a;
            if (field != null) {
                obj = field.get(obj);
            }
            String str = (String) obj;
            if (!TextUtils.isEmpty(str) && this.e.contains(str)) {
                Object obj3 = this.b.get(obj2);
                if (obj3 instanceof InetAddress[]) {
                    InetAddress[] inetAddressArr = (InetAddress[]) obj3;
                    SystemClock.elapsedRealtime();
                    a(inetAddressArr);
                    List<String> listB = b(inetAddressArr);
                    long jE = kg.d().e();
                    if (listB != null && !listB.isEmpty()) {
                        h9.c().a(str, listB, jE, 2);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static InetAddress[] a(String str, List<String> list) throws IllegalAccessException, IllegalArgumentException, UnknownHostException {
        Method method;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (a(str2)) {
                try {
                    InetAddress byName = InetAddress.getByName(str2);
                    if (byName != null) {
                        Field field = h;
                        if (field != null) {
                            field.set(byName, str);
                        } else {
                            Field field2 = i;
                            if (field2 != null && (method = j) != null) {
                                field2.set(method.invoke(byName, new Object[0]), str);
                            }
                        }
                        arrayList.add(byName);
                    }
                } catch (Exception unused) {
                }
            }
        }
        list.size();
        qm$h$$ExternalSyntheticBackport0.m(list);
        arrayList.size();
        a((InetAddress[]) arrayList.toArray(new InetAddress[0]));
        if (arrayList.isEmpty()) {
            return null;
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[0]);
    }

    public static boolean a(String str) throws NoSuchMethodException, SecurityException {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return InetAddresses.isNumericAddress(str);
            }
            if (m == null) {
                Method declaredMethod = InetAddress.class.getDeclaredMethod("isNumeric", String.class);
                declaredMethod.setAccessible(true);
                m = declaredMethod;
            }
            return ((Boolean) m.invoke(null, str)).booleanValue();
        } catch (Exception unused) {
            return Patterns.IP_ADDRESS.matcher(str).matches();
        }
    }

    private List<String> b(InetAddress[] inetAddressArr) {
        if (inetAddressArr == null || inetAddressArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (InetAddress inetAddress : inetAddressArr) {
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                if (!TextUtils.isEmpty(hostAddress)) {
                    arrayList.add(hostAddress);
                }
            }
        }
        return arrayList;
    }

    private static InetAddress[] b(String str) {
        List<String> listA = h9.c().a(str);
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return a(str, listA);
    }
}
