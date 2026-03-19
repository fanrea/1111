package com.apm.insight.k;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    private static volatile boolean a = false;
    private static final LinkedHashMap<String, byte[]> b = new LinkedHashMap<>();
    private static final Application.ActivityLifecycleCallbacks c = new Application.ActivityLifecycleCallbacks() { // from class: com.apm.insight.k.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
            a.c(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            if (bundle == null) {
                return;
            }
            a.d(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    };

    private static Bundle a(byte[] bArr, ClassLoader classLoader) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return parcelObtain.readBundle(classLoader);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static boolean a(Application application) {
        if (Build.VERSION.SDK_INT < 29 || a) {
            return false;
        }
        a = true;
        application.registerActivityLifecycleCallbacks(c);
        return true;
    }

    private static byte[] a(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeBundle(bundle);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable unused) {
            parcelObtain.recycle();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Activity activity, Bundle bundle) {
        byte[] bArrA = a(bundle);
        if (bArrA == null) {
            bundle.clear();
            return;
        }
        if (bArrA.length > 1024) {
            String string = UUID.randomUUID().toString();
            try {
                LinkedHashMap<String, byte[]> linkedHashMap = b;
                linkedHashMap.put(string, bArrA);
                if (linkedHashMap.size() > 64) {
                    Set<Map.Entry<String, byte[]>> setEntrySet = linkedHashMap.entrySet();
                    ArrayList arrayList = new ArrayList();
                    Iterator<Map.Entry<String, byte[]>> it = setEntrySet.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getKey());
                        if (arrayList.size() >= 12) {
                            break;
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        b.remove((String) it2.next());
                    }
                }
                bundle.clear();
                bundle.putString("APMPLUS_TTL_ActivityRecordKey", string);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Activity activity, Bundle bundle) {
        Bundle bundleA;
        Object obj = bundle.get("APMPLUS_TTL_ActivityRecordKey");
        if (obj instanceof String) {
            try {
                bundle.clear();
                byte[] bArr = b.get(obj);
                if (bArr == null || (bundleA = a(bArr, activity.getClassLoader())) == null) {
                    return;
                }
                bundle.putAll(bundleA);
            } catch (Throwable unused) {
            }
        }
    }
}
