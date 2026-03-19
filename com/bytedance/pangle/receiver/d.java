package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.tt;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    private static final b d;

    private interface b {
        boolean d(Context context) throws Throwable;
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            d = new C0255d();
            return;
        }
        if (i < 26) {
            d = new c();
        } else if (i < 28) {
            d = new u();
        } else {
            d = new hc();
        }
    }

    public static void d(Application application) {
        if (application != null) {
            try {
                if (tt.jh()) {
                    d.d(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static class hc extends u {
        @Override // com.bytedance.pangle.receiver.d.u, com.bytedance.pangle.receiver.d.C0255d, com.bytedance.pangle.receiver.d.b
        public boolean d(Context context) throws Throwable {
            return false;
        }

        private hc() {
            super();
        }
    }

    private static class u extends C0255d {
        private u() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.d.C0255d, com.bytedance.pangle.receiver.d.b
        public boolean d(Context context) throws Throwable {
            Object objD = d(context, "mWhiteListMap");
            if (!(objD instanceof Map)) {
                return false;
            }
            Map map = (Map) objD;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    private static class c extends C0255d {
        private c() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.d.C0255d, com.bytedance.pangle.receiver.d.b
        public boolean d(Context context) throws Throwable {
            Object objD = d(context, "mWhiteList");
            if (!(objD instanceof List)) {
                return false;
            }
            ((List) objD).add(context.getPackageName());
            return true;
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.d$d, reason: collision with other inner class name */
    private static class C0255d implements b {
        private C0255d() {
        }

        @Override // com.bytedance.pangle.receiver.d.b
        public boolean d(Context context) throws Throwable {
            Object objHc = hc(context);
            Object objD = d(objHc, "mWhiteList");
            if (!(objD instanceof String[])) {
                if (objHc == null) {
                    return false;
                }
                FieldUtils.writeField(objHc, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objD);
            FieldUtils.writeField(objHc, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        Object d(Context context, String str) {
            return d(hc(context), str);
        }

        private Object d(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }

        private Object hc(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
