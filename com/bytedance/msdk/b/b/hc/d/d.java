package com.bytedance.msdk.b.b.hc.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.b.d.an;
import com.bytedance.msdk.b.d.gb;
import com.bytedance.msdk.b.d.h;
import com.bytedance.msdk.b.d.tt;
import com.bytedance.msdk.core.d.d.u;
import com.bytedance.msdk.core.tc.tc;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements Function<SparseArray<Object>, Object> {
    private com.bytedance.msdk.api.d.hc an;
    private int b;
    private Function<SparseArray<Object>, Object> c;
    private b d;
    private tc h;
    private int hc;
    private com.bytedance.msdk.b.an.hc.hc u;

    public d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2, b bVar) {
        this.hc = hcVar.de();
        this.an = hcVar;
        this.b = hcVar2.e();
        this.u = hcVar2;
        this.d = bVar;
        this.h = hcVar2.gb();
    }

    public String d(Context context, String str, Object obj) {
        if (this.c != null) {
            Object objApply = this.c.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8139).d(8009, context).d(8007, str).d(8044, obj).d(String.class).hc());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        com.bytedance.msdk.core.d.d.d.d dVarHc;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHc = com.bykv.d.d.d.d.d.d(sparseArray).hc();
        int iIntValue = pluginValueSetHc.intValue(-99999987);
        Class cls = (Class) pluginValueSetHc.objectValue(-99999985, Class.class);
        if (iIntValue == 8108) {
            this.d.d(new com.bytedance.msdk.api.d(pluginValueSetHc.intValue(8014), pluginValueSetHc.stringValue(8015)));
        } else if (iIntValue == 8112) {
            Function function = (Function) pluginValueSetHc.objectValue(AVMDLDataLoader.KeyIsGetCookieTokenLevel, Function.class);
            int iIntValue2 = pluginValueSetHc.intValue(8014);
            String strStringValue = pluginValueSetHc.stringValue(8015);
            ArrayList arrayList = new ArrayList(1);
            if (function instanceof com.bytedance.msdk.hc.b) {
                arrayList.add((com.bytedance.msdk.hc.b) function);
            } else if (function instanceof Function) {
                Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(-99999977).hc());
                if (objApply instanceof com.bytedance.msdk.hc.b) {
                    arrayList.add((com.bytedance.msdk.hc.b) objApply);
                }
            }
            this.d.d(arrayList, new com.bytedance.msdk.api.d(iIntValue2, strStringValue));
        } else if (iIntValue == 8107) {
            List list = (List) pluginValueSetHc.objectValue(AVMDLDataLoader.KeyIsGetCookieTokenLevel, List.class);
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof com.bytedance.msdk.hc.b) {
                        arrayList2.add((com.bytedance.msdk.hc.b) obj);
                    } else if (obj instanceof Function) {
                        Object objApply2 = ((Function) obj).apply(com.bytedance.sdk.openadsdk.w.c.d().d(-99999977).hc());
                        if (objApply2 instanceof com.bytedance.msdk.hc.b) {
                            arrayList2.add((com.bytedance.msdk.hc.b) objApply2);
                        }
                    }
                }
            }
            this.d.d(arrayList2);
        } else {
            if (iIntValue == 8127) {
                return d();
            }
            if (iIntValue == 8110) {
                return Boolean.valueOf(this.u.d());
            }
            if (iIntValue == 8136) {
                return Boolean.valueOf(this.u.v());
            }
            if (iIntValue == 8141) {
                return Boolean.valueOf(this.u.np());
            }
            if (iIntValue == 8137) {
                return this.u.yi();
            }
            if (iIntValue == 8226) {
                return Integer.valueOf(this.u.rf());
            }
            if (iIntValue == 8138) {
                this.c = (Function) pluginValueSetHc.objectValue(8043, Function.class);
            } else {
                if (iIntValue == 8210) {
                    return Boolean.valueOf(this.d.d());
                }
                if (iIntValue == 20000) {
                    Function<SparseArray<Object>, Object> function2 = (Function) pluginValueSetHc.objectValue(10010, Function.class);
                    String str = (String) pluginValueSetHc.objectValue(10011, String.class);
                    Context context = (Context) pluginValueSetHc.objectValue(10000, Context.class);
                    if (function2 != null && !TextUtils.isEmpty(str) && this.an != null && this.h != null && (dVarHc = u.hc(str, this.hc, this.b)) != null) {
                        u.d(this.an);
                        dVarHc.d(context, function2, this.an, this.h, new com.bytedance.msdk.core.d.d.d.hc() { // from class: com.bytedance.msdk.b.b.hc.d.d.1
                            @Override // com.bytedance.msdk.core.d.d.d.hc
                            public void d(List<com.bytedance.msdk.hc.b> list2) {
                                if (d.this.d != null) {
                                    d.this.d.d(list2);
                                }
                            }

                            @Override // com.bytedance.msdk.core.d.d.d.hc
                            public void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d dVar) {
                                if (d.this.d != null) {
                                    d.this.d.d(bVar, dVar);
                                }
                            }

                            @Override // com.bytedance.msdk.core.d.d.d.hc
                            public void d(int i, String str2) {
                                if (d.this.d != null) {
                                    d.this.d.d(new com.bytedance.msdk.api.d(i, str2));
                                }
                            }
                        });
                    } else {
                        u.hc(this.an);
                    }
                }
            }
        }
        return com.bytedance.msdk.core.cb.d.d(cls);
    }

    private com.bytedance.msdk.hc.b d() {
        switch (this.hc) {
            case 1:
                return new com.bytedance.msdk.b.d.b(this.u);
            case 2:
                return new an(this.u);
            case 3:
                return new tt(this.u);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                int i = this.b;
                if (i == 4) {
                    return new h(this.u, this.d);
                }
                if (i == 3) {
                    return new com.bytedance.msdk.b.d.b(this.u);
                }
                if (i == 5) {
                    return new h(this.u, this.d);
                }
                return new h(this.u, this.d);
            case 7:
                int i2 = this.b;
                if (i2 == 6) {
                    return new gb(this.u);
                }
                if (i2 == 7) {
                    return new com.bytedance.msdk.b.d.u(this.u);
                }
                return new gb(this.u);
            case 8:
                return new com.bytedance.msdk.b.d.u(this.u);
            case 9:
                return new h(this.u, this.d);
            case 10:
                int i3 = this.b;
                if (i3 == 1) {
                    return new an(this.u);
                }
                if (i3 == 2) {
                    return new com.bytedance.msdk.b.d.u(this.u);
                }
                return null;
        }
    }
}
