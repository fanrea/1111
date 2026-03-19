package com.tk.core.bridge;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.luck.picture.lib.config.PictureMimeType;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.view.TKView;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tk.core.o.p;
import com.tk.core.o.s;
import com.tk.core.o.t;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import com.tkruntime.v8.V8Value;
import com.tkruntime.v8.env.DynamicEnv;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends TKBaseNativeModule {
    private static String Zu;
    private static Boolean Zv;
    private JsValueRef<V8Function> Zw;
    private HashMap<String, List<JsValueRef<V8Function>>> Zx;
    private final Map<String, JsValueRef<V8Function>> Zy;
    private V8ObjectProxy Zz;
    private float density;

    public static void preLoad() {
        o.getDisplayMetrics();
        HashMap map = new HashMap();
        map.put("appName", com.tk.core.o.e.sy().sz());
        map.put("appVersion", com.tk.core.o.e.sy().getAppVersion());
        map.put("appDetailVersion", com.tk.core.o.e.sy().sA());
        com.tk.core.o.e.sy();
        map.put("osVersion", com.tk.core.o.e.getOsVersion());
        com.tk.core.o.e.sy();
        map.put("scale", Float.valueOf(com.tk.core.o.e.sB()));
        com.tk.core.o.e.sy();
        map.put("platform", com.tk.core.o.e.sC());
        map.put("statusBarHeight", Integer.valueOf(o.ec(o.sN())));
        map.put("productName", com.tk.core.o.e.sy().getProductName());
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(entry.getKey());
            sb.append(",");
            sb.append(entry.getValue());
        }
        String string = sb.toString();
        Zu = string;
        V8.injectSEnv(string);
    }

    public d(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Zw = null;
        this.Zy = new HashMap();
        this.density = -1.0f;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        this.Zy.clear();
    }

    public final double b(double d) {
        pD();
        double d2 = this.density;
        Double.isNaN(d2);
        return d / d2;
    }

    public final double c(double d) {
        pD();
        Double.isNaN(this.density);
        return (int) ((r0 * d) + 0.5d);
    }

    public static boolean pz() {
        com.tk.core.a.oP().getCommonParams();
        return false;
    }

    @Deprecated
    public final void x(V8Object v8Object) {
        pO().w(v8Object);
    }

    public final void h(String str, V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        if (this.Zy.containsKey(str)) {
            ad.unRetainJsValue(this.Zy.remove(str));
        }
        this.Zy.put(str, jsValueRefRetainJsValue);
    }

    public final V8Function bc(String str) {
        JsValueRef<V8Function> jsValueRef = this.Zy.get(str);
        if (jsValueRef == null) {
            return null;
        }
        return jsValueRef.get();
    }

    public final void aF(V8Function v8Function) {
        ad.unRetainJsValue(this.Zw);
        this.Zw = ad.retainJsValue(v8Function, this);
    }

    public static void bd(String str) {
        if (TextUtils.isEmpty(str)) {
        }
    }

    public final Map<String, Object> pA() {
        HashMap map = new HashMap();
        TkBundleInfo tkBundleInfoPr = pO().pr();
        if (tkBundleInfoPr != null) {
            map.put("bundleId", tkBundleInfoPr.mBundleId);
            map.put("versionCode", Integer.valueOf(tkBundleInfoPr.mVersionCode));
            map.put("taskId", String.valueOf(tkBundleInfoPr.mTaskId));
        }
        return map;
    }

    public final V8Function pB() {
        JsValueRef<V8Function> jsValueRef = this.Zw;
        if (jsValueRef == null) {
            return null;
        }
        return jsValueRef.get();
    }

    public final V8ObjectProxy pC() {
        if (this.Zz == null) {
            this.Zz = new V8ObjectProxy(pP().pi(), "Tachikoma-env") { // from class: com.tk.core.bridge.d.1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // com.tkruntime.v8.V8ObjectProxy, com.tkruntime.v8.V8Object
                public final Object onPropCall(boolean z, String str, Object obj) {
                    CustomEnv customEnv;
                    if (TextUtils.isEmpty(str) || !z) {
                        return PROP_SET_IGNORE;
                    }
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -2061629315:
                            if (str.equals("availableWidth")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -2007745357:
                            if (str.equals("screenHeight")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1550605040:
                            if (str.equals("deviceWidth")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1491817446:
                            if (str.equals("productName")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -1416229834:
                            if (str.equals("engineVersion")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1325626522:
                            if (str.equals("navigationBarHeight")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -1257110755:
                            if (str.equals("deviceHeight")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -794136500:
                            if (str.equals("appName")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -50798406:
                            if (str.equals("screenWidth")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 13795144:
                            if (str.equals("statusBarHeight")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 81005904:
                            if (str.equals("availableHeight")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 109250890:
                            if (str.equals("scale")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 534954662:
                            if (str.equals("appDetailVersion")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 633489322:
                            if (str.equals("targetFontScale")) {
                                c = StringUtil.CARRIAGE_RETURN;
                                break;
                            }
                            break;
                        case 1484112759:
                            if (str.equals("appVersion")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1812004436:
                            if (str.equals("osVersion")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1874684019:
                            if (str.equals("platform")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 2056864585:
                            if (str.equals("isDebug")) {
                                c = 14;
                                break;
                            }
                            break;
                    }
                    Object objSz = null;
                    switch (c) {
                        case 0:
                            objSz = "Android";
                            break;
                        case 1:
                            objSz = com.tk.core.o.e.sy().sz();
                            break;
                        case 2:
                        case 3:
                            objSz = com.tk.core.o.e.sy().sA();
                            break;
                        case 4:
                            objSz = Build.VERSION.RELEASE;
                            break;
                        case 5:
                        case 6:
                            objSz = Integer.valueOf(o.Y(d.this.getContext()));
                            com.tk.core.o.e.sy().dZ(((Integer) objSz).intValue());
                            com.tk.core.i.a.z("TachikomaGlobalObject", "device width is " + objSz);
                            if (d.pG()) {
                                com.tk.core.i.a.z("TachikomaGlobalObject", "use dynamic env, device width is " + objSz);
                                DynamicEnv.getInstance().update("deviceWidth", objSz);
                                break;
                            }
                            break;
                        case 7:
                        case '\b':
                            objSz = Integer.valueOf(o.Z(d.this.getContext()));
                            com.tk.core.o.e.sy().ea(((Integer) objSz).intValue());
                            com.tk.core.i.a.z("TachikomaGlobalObject", "device height is " + objSz);
                            if (d.pG()) {
                                com.tk.core.i.a.z("TachikomaGlobalObject", "use dynamic env, device height is " + objSz);
                                DynamicEnv.getInstance().update("deviceHeight", objSz);
                                break;
                            }
                            break;
                        case '\t':
                            objSz = Float.valueOf(o.getDisplayMetrics().density);
                            com.tk.core.i.a.z("TachikomaGlobalObject", "scale is " + objSz);
                            break;
                        case '\n':
                            objSz = "1.0";
                            break;
                        case 11:
                            objSz = Integer.valueOf(o.ec(o.sN()));
                            com.tk.core.i.a.z("TachikomaGlobalObject", "statusBarHeight is " + objSz);
                            break;
                        case '\f':
                            com.tk.core.a.oP().getCommonParams();
                            if (!TextUtils.isEmpty(null)) {
                                add(str, (String) null);
                                break;
                            }
                            break;
                        case '\r':
                            objSz = Float.valueOf(d.pF());
                            break;
                        case 14:
                            objSz = Boolean.valueOf(!t.sQ());
                            add(str, ((Boolean) objSz).booleanValue());
                            break;
                        case 15:
                            objSz = Integer.valueOf(com.tk.core.o.e.sy().sD());
                            com.tk.core.i.a.z("TachikomaGlobalObject", "screen width is " + objSz);
                            if (d.pG()) {
                                com.tk.core.i.a.z("TachikomaGlobalObject", "use dynamic env, screen width is " + objSz);
                                DynamicEnv.getInstance().update("screenWidth", objSz);
                                break;
                            }
                            break;
                        case 16:
                            objSz = Integer.valueOf(com.tk.core.o.e.sy().sE());
                            com.tk.core.i.a.z("TachikomaGlobalObject", "screen height is " + objSz);
                            if (d.pG()) {
                                com.tk.core.i.a.z("TachikomaGlobalObject", "use dynamic env, screen height is " + objSz);
                                DynamicEnv.getInstance().update("screenHeight", objSz);
                                break;
                            }
                            break;
                        case 17:
                            objSz = Integer.valueOf(com.tk.core.o.e.sy().P(d.this.getContext()));
                            com.tk.core.i.a.z("TachikomaGlobalObject", "navigationBarHeight is " + objSz);
                            break;
                        default:
                            Map<String, CustomEnv> mapPp = d.this.pO().pp();
                            if (mapPp != null && (customEnv = mapPp.get(str)) != null) {
                                objSz = V8ObjectUtilsQuick.toReturnObjectForV8(this.v8, customEnv.value);
                                if (!customEnv.isMutable) {
                                    if (objSz instanceof Integer) {
                                        add(str, ((Integer) objSz).intValue());
                                    } else if (objSz instanceof Boolean) {
                                        add(str, ((Boolean) objSz).booleanValue());
                                    } else if (objSz instanceof Double) {
                                        add(str, ((Double) objSz).doubleValue());
                                    } else if (objSz instanceof String) {
                                        add(str, (String) objSz);
                                    } else if (objSz instanceof V8Value) {
                                        add(str, (V8Value) objSz);
                                    }
                                }
                            }
                            return objSz;
                    }
                    return V8ObjectUtilsQuick.toReturnObjectForV8(this.v8, objSz);
                }
            };
            if (getJsObj() != null) {
                getJsObj().add("env", this.Zz);
            }
        }
        return this.Zz;
    }

    public static String F(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        try {
            if (i == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            return context.getString(i);
        } catch (Exception e) {
            e.printStackTrace();
            return applicationInfo.name;
        }
    }

    public static String G(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            com.tk.core.exception.a.a((b) null, th);
            return "";
        }
    }

    private void pD() {
        try {
            if (this.density == -1.0f) {
                this.density = o.getDisplayMetrics().density;
            }
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    public final V8Object pE() {
        TKView tKViewPt = pO().pt();
        if (tKViewPt == null) {
            return null;
        }
        return tKViewPt.getJsObj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float pF() {
        Resources resources = s.getContext().getResources();
        if (resources != null) {
            return resources.getConfiguration().fontScale;
        }
        return 1.0f;
    }

    public final void b(V8Object v8Object, V8Function v8Function) throws Throwable {
        com.tk.core.component.e eVar = (com.tk.core.component.e) getNativeModule(v8Object);
        if (eVar == null || eVar.getView() == null) {
            v8Function.call(null, new Object[0]);
            return;
        }
        final JsValueRef jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        View view = eVar.getView();
        final Bitmap bitmapA = com.tk.core.o.b.a(view, view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        final long jNanoTime = System.nanoTime();
        p.execute(new Runnable() { // from class: com.tk.core.bridge.d.2
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                File file = new File(d.this.getContext().getFilesDir(), "kds_native/image");
                if (!file.exists()) {
                    file.mkdirs();
                }
                final File fileA = com.tk.core.o.b.a(bitmapA, new File(file, d.this.pO().pq() + Config.replace + jNanoTime + PictureMimeType.PNG).getAbsolutePath(), 100);
                ac.runOnUiThread(new Runnable() { // from class: com.tk.core.bridge.d.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (jsValueRefRetainJsValue == null || !ad.isV8Valid((V8Object) jsValueRefRetainJsValue.get())) {
                            return;
                        }
                        try {
                            if (fileA != null) {
                                ((V8Function) jsValueRefRetainJsValue.get()).call(null, fileA.getAbsolutePath());
                            } else {
                                ((V8Function) jsValueRefRetainJsValue.get()).call(null, new Object[0]);
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                });
            }
        });
    }

    public final void e(V8Array v8Array) {
        if (v8Array == null) {
            return;
        }
        final List list = v8Array.getList();
        p.execute(new Runnable() { // from class: com.tk.core.bridge.d.3
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable th) {
                        com.tk.core.i.a.a("TachikomaGlobalObject", "removeFile exception", th);
                    }
                }
            }
        });
    }

    public final void i(String str, V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue;
        if (TextUtils.isEmpty(str) || v8Function == null || (jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this)) == null) {
            return;
        }
        if (this.Zx == null) {
            this.Zx = new HashMap<>();
        }
        List<JsValueRef<V8Function>> arrayList = this.Zx.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.Zx.put(str, arrayList);
        }
        boolean z = false;
        if (!arrayList.isEmpty()) {
            Iterator<JsValueRef<V8Function>> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JsValueRef<V8Function> next = it.next();
                if (next != null && next.get() != null && next.get().getHandle() == v8Function.getHandle()) {
                    z = true;
                    ad.unRetainJsValue(jsValueRefRetainJsValue);
                    break;
                }
            }
        }
        if (z) {
            return;
        }
        arrayList.add(jsValueRefRetainJsValue);
    }

    public final void j(String str, V8Function v8Function) {
        HashMap<String, List<JsValueRef<V8Function>>> map;
        List<JsValueRef<V8Function>> list;
        if (TextUtils.isEmpty(str) || (map = this.Zx) == null || !map.containsKey(str) || (list = this.Zx.get(str)) == null || list.isEmpty()) {
            return;
        }
        if (v8Function == null) {
            for (JsValueRef<V8Function> jsValueRef : list) {
                if (jsValueRef != null) {
                    ad.unRetainJsValue(jsValueRef);
                }
            }
            list.clear();
            this.Zx.remove(str);
            return;
        }
        JsValueRef<V8Function> jsValueRef2 = null;
        Iterator<JsValueRef<V8Function>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JsValueRef<V8Function> next = it.next();
            if (next != null && next.get() != null && next.get().getHandle() == v8Function.getHandle()) {
                jsValueRef2 = next;
                break;
            }
        }
        if (jsValueRef2 != null) {
            ad.unRetainJsValue(jsValueRef2);
            list.remove(jsValueRef2);
            if (list.isEmpty()) {
                this.Zx.remove(str);
            }
        }
    }

    public final void be(String str) throws Throwable {
        HashMap<String, List<JsValueRef<V8Function>>> map;
        List<JsValueRef<V8Function>> list;
        if (TextUtils.isEmpty(str) || (map = this.Zx) == null || !map.containsKey(str) || (list = this.Zx.get(str)) == null || list.isEmpty()) {
            return;
        }
        for (JsValueRef<V8Function> jsValueRef : list) {
            if (jsValueRef != null && ad.isV8Valid(jsValueRef.get())) {
                try {
                    jsValueRef.get().call(null, new Object[0]);
                } catch (Exception e) {
                    com.tk.core.exception.a.a(pO(), e);
                }
            }
        }
    }

    public static boolean pG() {
        if (Zv == null && com.tk.core.a.oP().getTKSwitch() != null) {
            Zv = Boolean.valueOf(com.tk.core.a.oP().getTKSwitch().oY());
            com.tk.core.i.a.z("TachikomaGlobalObject", "isUseDynamicEnv " + Zv);
        }
        Boolean bool = Zv;
        return bool != null && bool.booleanValue();
    }
}
