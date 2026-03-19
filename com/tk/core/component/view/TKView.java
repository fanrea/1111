package com.tk.core.component.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.component.f;
import com.tk.core.e.b;
import com.tk.core.o.aa;
import com.tk.core.o.ac;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKView extends e<f> {
    public String PT;

    @Deprecated
    public boolean XE;
    private boolean abr;
    private final Map<String, e> ahu;
    public final ArrayList<e> ahv;

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return true;
    }

    public TKView(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.ahu = new HashMap();
        this.ahv = new ArrayList<>();
        this.XE = true;
        this.PT = "none";
    }

    public TKView(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
        this.ahu = new HashMap();
        this.ahv = new ArrayList<>();
        this.XE = true;
        this.PT = "none";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tk.core.component.e
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public f n(Context context) {
        return new f(context);
    }

    @Override // com.tk.core.component.e
    public void addEventListener(String str, V8Function v8Function, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if ("dispatch".equals(str)) {
            getView().a(new f.b() { // from class: com.tk.core.component.view.TKView.1
                @Override // com.tk.core.component.f.b
                public final boolean dispatchTouchEvent(final MotionEvent motionEvent) {
                    return TKView.this.b("dispatch", new b.a() { // from class: com.tk.core.component.view.TKView.1.1
                        @Override // com.tk.core.e.b.a
                        public final void a(com.tk.core.e.a.b bVar) {
                            if (bVar instanceof com.tk.core.e.b.a) {
                                com.tk.core.e.b.a aVar = (com.tk.core.e.b.a) bVar;
                                aVar.bX("dispatch");
                                aVar.o(new HashMap<String, Float>() { // from class: com.tk.core.component.view.TKView.1.1.1
                                    {
                                        put("x", Float.valueOf(motionEvent.getX()));
                                        put("y", Float.valueOf(motionEvent.getY()));
                                    }
                                });
                                aVar.setState(com.tk.core.e.a.a.m(motionEvent));
                            }
                        }
                    });
                }
            });
        }
        super.addEventListener(str, v8Function, z);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            nj();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.view.TKView.2
                @Override // java.lang.Runnable
                public final void run() {
                    TKView.this.nj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        if (pQ()) {
            getView().qy();
        }
        getView().onDestroy();
        this.ahv.clear();
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public void ih() {
        super.ih();
        for (e eVar : this.ahu.values()) {
            if (eVar != null) {
                eVar.pM();
            }
        }
    }

    public final void setClipChildren(boolean z) {
        this.XE = z;
        getView().setClipChildren(z);
    }

    public final void aq(String str) {
        if (TextUtils.equals(str, this.PT)) {
            return;
        }
        if (TextUtils.equals("none", str) || TextUtils.equals("on-touch", str) || TextUtils.equals("on-tap", str)) {
            this.PT = str;
            char c = 65535;
            int iHashCode = str.hashCode();
            int i = 2;
            if (iHashCode != -1014089035) {
                if (iHashCode != 3387192) {
                    if (iHashCode == 418438609 && str.equals("on-touch")) {
                        c = 0;
                    }
                } else if (str.equals("none")) {
                    c = 2;
                }
            } else if (str.equals("on-tap")) {
                c = 1;
            }
            if (c == 0) {
                i = 1;
            } else if (c != 1) {
                i = 0;
            }
            getView().setKeyboardDismissMode(i);
        }
    }

    public final void d(V8Object v8Object) {
        if (v8Object == null) {
            com.tk.core.i.a.z("TKView", "add null subview");
            return;
        }
        e eVar = (e) getNativeModule(v8Object);
        if (eVar == null || this.ahu.containsValue(eVar)) {
            return;
        }
        eVar.pL();
        pR().r(eVar);
        this.ahu.put(eVar.pT(), eVar);
        this.ahv.add(eVar);
        eVar.a(this);
    }

    public final void e(V8Object v8Object) {
        e eVar;
        if (v8Object == null || (eVar = (e) getNativeModule(v8Object)) == null || !this.ahu.containsValue(eVar)) {
            return;
        }
        eVar.b(this);
        pR().s(eVar);
        this.ahu.remove(eVar.pT());
        this.ahv.remove(eVar);
        eVar.pM();
    }

    public final void removeAll() {
        for (e eVar : this.ahu.values()) {
            eVar.b(this);
            eVar.pM();
        }
        pR().rQ();
        this.ahu.clear();
        this.ahv.clear();
    }

    public final void b(V8Object v8Object, V8Object v8Object2) {
        e eVar = (e) getNativeModule(v8Object);
        e eVar2 = (e) getNativeModule(v8Object2);
        if (eVar2 == null || !this.ahu.containsValue(eVar2)) {
            d(v8Object);
            return;
        }
        if (eVar == null || this.ahu.containsValue(eVar)) {
            return;
        }
        eVar.pL();
        pR().a(eVar, eVar2);
        this.ahu.put(eVar.pT(), eVar);
        this.ahv.add(eVar);
        eVar.a(this);
    }

    public final void c(V8Object v8Object, V8Object v8Object2) {
        e eVar = (e) getNativeModule(v8Object);
        e eVar2 = (e) getNativeModule(v8Object2);
        if (eVar == null || eVar2 == null || !this.ahu.containsValue(eVar2) || this.ahu.containsValue(eVar)) {
            return;
        }
        eVar2.b(this);
        this.ahu.remove(eVar2.pT());
        eVar2.pM();
        eVar.pL();
        pR().b(eVar, eVar2);
        this.ahu.put(eVar.pT(), eVar);
        int i = 0;
        while (true) {
            if (i >= this.ahv.size()) {
                break;
            }
            if (this.ahv.get(i) == eVar2) {
                this.ahv.remove(eVar2);
                this.ahv.add(i, eVar);
                break;
            }
            i++;
        }
        eVar.a(this);
    }

    @Override // com.tk.core.component.e
    public final void nQ() {
        pR().rR();
    }

    public final V8Object aV(String str) {
        V8Object v8ObjectAV;
        e eVar = this.ahu.get(str);
        if (eVar != null) {
            return eVar.getJsObj();
        }
        for (e eVar2 : this.ahu.values()) {
            if ((eVar2 instanceof TKView) && (v8ObjectAV = ((TKView) eVar2).aV(str)) != null) {
                return v8ObjectAV;
            }
        }
        return null;
    }

    public final void u(String str, String str2) {
        e eVar;
        if (str == null || (eVar = this.ahu.get(str)) == null) {
            return;
        }
        if (str2 != null) {
            this.ahu.put(str2, eVar);
        }
        this.ahu.remove(str);
    }

    @Override // com.tk.core.component.e
    public final void a(HashMap map) {
        super.a(map);
        c((HashMap<?, ?>) map);
    }

    private void c(HashMap<?, ?> map) {
        if (TextUtils.isEmpty(aa.t(map))) {
            return;
        }
        setClipChildren(!aa.db(r2));
    }

    private boolean qA() {
        return this.abr;
    }

    public final void aC(boolean z) {
        this.abr = true;
        getView().a(true, (com.tk.core.g.a) pO().getGlobalNativeObject("Keyboard"), pO());
        getView().setRealContext(getTKContext().getContext());
        getView().setKeyboardEventListener(new f.c() { // from class: com.tk.core.component.view.TKView.3
            @Override // com.tk.core.component.f.c
            public final void b(String str, HashMap map) throws Throwable {
                com.tk.core.g.a aVar = (com.tk.core.g.a) TKView.this.pO().getGlobalNativeObject("Keyboard");
                if (aVar != null) {
                    aVar.a(str, map);
                }
            }
        });
    }

    public final void qC() {
        if (pN() || !qA()) {
            return;
        }
        getView().qC();
    }

    public final void rx() {
        if (qA()) {
            getView().qE();
        }
    }
}
