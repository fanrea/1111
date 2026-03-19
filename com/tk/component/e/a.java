package com.tk.component.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.kuaishou.tk.export.IStorage;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.i;
import com.tk.core.o.p;
import com.tk.core.o.s;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule implements IStorage {
    private List<JsValueRef<V8Function>> WR;

    @Override // com.kuaishou.tk.export.IStorage
    public final Map<String, Object> getAll() {
        return null;
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    @Override // com.kuaishou.tk.export.IStorage
    public final void setItem(final String str, final Object obj, V8Function v8Function) {
        final JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        oE().add(jsValueRefRetainJsValue);
        final String strPq = pO().pq();
        p.execute(new Runnable() { // from class: com.tk.component.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    SharedPreferences.Editor editorEdit = a.aX(strPq).edit();
                    HashMap map = new HashMap();
                    map.put("data", obj);
                    editorEdit.putString(str, i.j(map));
                    if (!editorEdit.commit()) {
                        a.this.a(false, (JsValueRef<V8Function>) jsValueRefRetainJsValue, "setItem commit failure");
                        return;
                    }
                    HashMap map2 = new HashMap();
                    map2.put("code", 1);
                    map2.put(cm.V, "success");
                    a.this.a(false, (JsValueRef<V8Function>) jsValueRefRetainJsValue, (Object) null, (Map<String, Object>) map2);
                } catch (Throwable th) {
                    a.this.a(false, (JsValueRef<V8Function>) jsValueRefRetainJsValue, th.getMessage());
                }
            }
        });
    }

    @Override // com.kuaishou.tk.export.IStorage
    public final void getItem(final String str, V8Function v8Function) {
        final JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        oE().add(jsValueRefRetainJsValue);
        final String strPq = pO().pq();
        p.execute(new Runnable() { // from class: com.tk.component.e.a.2
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                try {
                    SharedPreferences sharedPreferencesAX = a.aX(strPq);
                    if (!sharedPreferencesAX.contains(str)) {
                        a.this.a(true, (JsValueRef<V8Function>) jsValueRefRetainJsValue, "key: " + str + " is not exists");
                        return;
                    }
                    String string = sharedPreferencesAX.getString(str, "");
                    if (TextUtils.isEmpty(string)) {
                        a.this.a(true, (JsValueRef<V8Function>) jsValueRefRetainJsValue, "getItem result is null");
                        return;
                    }
                    Map<String, Object> mapCV = i.cV(string);
                    if (mapCV == null || (obj = mapCV.get("data")) == null) {
                        return;
                    }
                    a.this.a(obj, (JsValueRef<V8Function>) jsValueRefRetainJsValue);
                } catch (Throwable th) {
                    a.this.a(true, (JsValueRef<V8Function>) jsValueRefRetainJsValue, th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, JsValueRef<V8Function> jsValueRef) {
        HashMap map = new HashMap();
        map.put("code", 1);
        map.put(cm.V, "success");
        a(true, jsValueRef, obj, (Map<String, Object>) map);
    }

    @Override // com.kuaishou.tk.export.IStorage
    public final void removeItem(final String str) {
        final String strPq = pO().pq();
        p.execute(new Runnable() { // from class: com.tk.component.e.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.aX(strPq).edit().remove(str).commit();
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(a.this.pO(), th);
                }
            }
        });
    }

    @Override // com.kuaishou.tk.export.IStorage
    public final void clear() {
        final String strPq = pO().pq();
        p.execute(new Runnable() { // from class: com.tk.component.e.a.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.aX(strPq).edit().clear().commit();
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(a.this.pO(), th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, JsValueRef<V8Function> jsValueRef, String str) {
        HashMap map = new HashMap();
        map.put("code", 0);
        map.put(cm.V, str);
        a(z, jsValueRef, (Object) null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final JsValueRef<V8Function> jsValueRef, final Object obj, final Map<String, Object> map) {
        if (pN()) {
            return;
        }
        ac.runOnUiThread(new Runnable() { // from class: com.tk.component.e.a.5
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.pN()) {
                    return;
                }
                try {
                    if (jsValueRef == null || !ad.isV8Valid((V8Object) jsValueRef.get())) {
                        return;
                    }
                    if (z) {
                        ((V8Function) jsValueRef.get()).call(null, obj, map);
                    } else {
                        ((V8Function) jsValueRef.get()).call(null, map);
                    }
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(a.this.pO(), th);
                }
            }
        });
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        List<JsValueRef<V8Function>> list = this.WR;
        if (list != null && list.size() > 0) {
            Iterator<JsValueRef<V8Function>> it = this.WR.iterator();
            while (it.hasNext()) {
                ad.unRetainJsValue(it.next());
            }
        }
        this.WR.clear();
    }

    static SharedPreferences aX(String str) {
        return s.getContext().getSharedPreferences(str + "_kds_native_storage", 0);
    }

    private List<JsValueRef<V8Function>> oE() {
        if (this.WR == null) {
            this.WR = new ArrayList();
        }
        return this.WR;
    }
}
