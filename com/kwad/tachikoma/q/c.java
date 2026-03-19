package com.kwad.tachikoma.q;

import com.kwad.tachikoma.t.i;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8ObjectProxy;
import com.tkruntime.v8.V8OneTimeObject;
import com.tkruntime.v8.V8Value;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends V8ObjectProxy {
    private b EC;
    private V8 mV8;

    public static V8OneTimeObject a(V8 v8, b bVar) {
        return new V8OneTimeObject(v8, new c(v8, bVar).getHandle());
    }

    private c(V8 v8, b bVar) {
        super(v8, "TK_CUSTOM_PROXY");
        this.EC = null;
        this.mV8 = null;
        this.EC = bVar;
        this.EC.a(v8);
        setNativeObject(bVar);
        this.mV8 = v8;
    }

    private void addPrimaryType(String str, Object obj) {
        if (obj == null) {
            addNull(str);
            return;
        }
        if (obj instanceof String) {
            add(str, (String) obj);
            return;
        }
        if (obj instanceof Number) {
            if (obj instanceof Integer) {
                add(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Double) {
                add(str, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Float) {
                add(str, ((Float) obj).doubleValue());
                return;
            } else if (obj instanceof Boolean) {
                add(str, ((Boolean) obj).booleanValue());
                return;
            } else {
                if (obj instanceof Short) {
                    add(str, ((Short) obj).intValue());
                    return;
                }
                return;
            }
        }
        if (obj instanceof Boolean) {
            add(str, ((Boolean) obj).booleanValue());
        } else {
            addNull(str);
        }
    }

    private Object s(Object obj) {
        if (obj == null) {
            return null;
        }
        if (i.u(obj) || (obj instanceof V8Value)) {
            return obj;
        }
        if (obj instanceof a) {
            V8Array v8Array = new V8Array(this.v8);
            a aVar = (a) obj;
            int length = aVar.length();
            for (int i = 0; i < length; i++) {
                Object objS = s(aVar.iU());
                v8Array.push(objS);
                if (objS instanceof V8Value) {
                    ((V8Value) objS).setWeak();
                }
            }
            return v8Array;
        }
        if (obj instanceof b) {
            return a(this.v8, (b) obj);
        }
        return null;
    }

    @Override // com.tkruntime.v8.V8ObjectProxy, com.tkruntime.v8.V8Object
    public final Object onPropCall(boolean z, String str, Object obj) {
        b bVar = this.EC;
        if (bVar == null) {
            return null;
        }
        if (z) {
            Object objS = s(bVar.get(str));
            addProp(objS, str);
            return objS;
        }
        bVar.set(str, obj);
        return null;
    }

    private void addProp(Object obj, String str) {
        if (obj instanceof V8Value) {
            V8Value v8Value = (V8Value) obj;
            add(str, v8Value);
            v8Value.setWeak();
        } else if (obj == null) {
            addNull(str);
        } else if (i.u(obj)) {
            addPrimaryType(str, obj);
        }
    }
}
