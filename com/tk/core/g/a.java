package com.tk.core.g;

import android.text.TextUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.view.TKView;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.g;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private HashMap<String, List<JsValueRef<V8Function>>> ahZ;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void n(String str, V8Function v8Function) {
        if (!cB(str) || v8Function == null) {
            return;
        }
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        if (jsValueRefRetainJsValue != null) {
            List<JsValueRef<V8Function>> arrayList = rN().get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                rN().put(str, arrayList);
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
            if (!z) {
                arrayList.add(jsValueRefRetainJsValue);
            }
        }
        TKView tKViewPt = pO().pt();
        if (tKViewPt != null) {
            tKViewPt.qC();
        }
    }

    private HashMap<String, List<JsValueRef<V8Function>>> rN() {
        if (this.ahZ == null) {
            this.ahZ = new HashMap<>();
        }
        return this.ahZ;
    }

    public final void o(String str, V8Function v8Function) {
        List<JsValueRef<V8Function>> list;
        if (!cB(str) || v8Function == null || this.ahZ == null || (list = rN().get(str)) == null) {
            return;
        }
        JsValueRef<V8Function> jsValueRef = null;
        Iterator<JsValueRef<V8Function>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JsValueRef<V8Function> next = it.next();
            if (next != null && next.get() != null && next.get().getHandle() == v8Function.getHandle()) {
                ad.unRetainJsValue(next);
                jsValueRef = next;
                break;
            }
        }
        if (jsValueRef != null) {
            list.remove(jsValueRef);
            if (list.isEmpty()) {
                rN().remove(str);
            }
            if (rO()) {
                return;
            }
            rx();
        }
    }

    public final void cA(String str) {
        List<JsValueRef<V8Function>> list;
        if (!cB(str) || this.ahZ == null || (list = rN().get(str)) == null) {
            return;
        }
        Iterator<JsValueRef<V8Function>> it = list.iterator();
        while (it.hasNext()) {
            ad.unRetainJsValue(it.next());
        }
        list.clear();
        rN().remove(str);
        if (rO()) {
            return;
        }
        rx();
    }

    public final void dismiss() {
        g.S(getTKContext().getContext());
    }

    public final void a(String str, HashMap map) throws Throwable {
        List<JsValueRef<V8Function>> list;
        if (TextUtils.isEmpty(str) || this.ahZ == null || (list = rN().get(str)) == null) {
            return;
        }
        for (JsValueRef<V8Function> jsValueRef : list) {
            if (jsValueRef != null && ad.isV8Valid(jsValueRef.get())) {
                try {
                    jsValueRef.get().call(null, map);
                } catch (Exception e) {
                    com.tk.core.exception.a.a(pO(), e);
                }
            }
        }
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            mN();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.mN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN() {
        HashMap<String, List<JsValueRef<V8Function>>> map = this.ahZ;
        if (map != null) {
            if (!map.isEmpty()) {
                for (List<JsValueRef<V8Function>> list : this.ahZ.values()) {
                    if (list != null) {
                        list.clear();
                    }
                }
                this.ahZ.clear();
            }
            this.ahZ = null;
        }
    }

    public final boolean rO() {
        HashMap<String, List<JsValueRef<V8Function>>> map = this.ahZ;
        return (map == null || map.isEmpty()) ? false : true;
    }

    private void rx() {
        TKView tKViewPt = pO().pt();
        if (tKViewPt != null) {
            tKViewPt.rx();
        }
    }

    private static boolean cB(String str) {
        return "keyboardDidShow".equals(str) || "keyboardDidHide".equals(str);
    }
}
