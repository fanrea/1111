package com.bytedance.msdk.core.mq;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.gb.vv;
import com.bytedance.sdk.component.utils.mq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static u c;
    private final Set<String> d = new HashSet(1);
    private final List<an> hc = new ArrayList(1);
    private final List<WeakReference<an>> b = new ArrayList(1);

    public static u d() {
        if (c == null) {
            c = new u();
        }
        return c;
    }

    private u() {
        hc();
    }

    private void hc() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = com.bytedance.msdk.core.hc.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.d.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void d(String[] strArr, an anVar) {
        if (anVar != null) {
            anVar.d(strArr);
            this.hc.add(anVar);
            this.b.add(new WeakReference<>(anVar));
        }
    }

    private synchronized void d(an anVar) {
        Iterator<WeakReference<an>> it = this.b.iterator();
        while (it.hasNext()) {
            WeakReference<an> next = it.next();
            if (next.get() == anVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<an> it2 = this.hc.iterator();
        while (it2.hasNext()) {
            if (it2.next() == anVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean d(Context context, String str) {
        if (context != null) {
            return vv.u() ? hc.d(context, str) && (b.d(context, str) == 0 || !this.d.contains(str)) : b.d(context, str) == 0 || !this.d.contains(str);
        }
        return false;
    }

    public synchronized void d(Activity activity, String[] strArr, an anVar) {
        if (activity != null) {
            try {
                d(strArr, anVar);
                if (Build.VERSION.SDK_INT < 23) {
                    hc(activity, strArr, anVar);
                    return;
                }
                List<String> listB = b(activity, strArr, anVar);
                if (listB.isEmpty()) {
                    d(anVar);
                } else {
                    b.requestPermissions(activity, (String[]) listB.toArray(new String[listB.size()]), 1);
                }
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    private void hc(Activity activity, String[] strArr, an anVar) {
        boolean zD;
        for (String str : strArr) {
            if (anVar != null) {
                try {
                    if (!this.d.contains(str)) {
                        zD = anVar.d(str, c.NOT_FOUND);
                    } else if (b.d(activity, str) != 0) {
                        zD = anVar.d(str, c.DENIED);
                    } else {
                        zD = anVar.d(str, c.GRANTED);
                    }
                    if (zD) {
                        break;
                    }
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        }
        d(anVar);
    }

    private List<String> b(Activity activity, String[] strArr, an anVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.d.contains(str)) {
                if (!d(activity, str)) {
                    arrayList.add(str);
                } else if (anVar != null) {
                    anVar.d(str, c.GRANTED);
                }
            } else if (anVar != null) {
                anVar.d(str, c.NOT_FOUND);
            }
        }
        return arrayList;
    }

    public synchronized void d(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (vv.u() && !hc.d(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            d(strArr, iArr);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void d(String[] strArr, int[] iArr) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<an>> it = this.b.iterator();
            while (it.hasNext()) {
                an anVar = it.next().get();
                while (i < length) {
                    i = (anVar == null || anVar.d(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<an> it2 = this.hc.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }
}
