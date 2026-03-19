package com.bytedance.msdk.b.d;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.d.h.tc;
import com.bytedance.sdk.component.utils.jh;
import com.bytedance.sdk.openadsdk.w.b.hc.mq;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends c {
    private com.bytedance.sdk.openadsdk.jh.d.hc.d.d mk;
    private com.bytedance.msdk.b.b.hc.d.b mq;

    public h(com.bytedance.msdk.b.an.hc.d dVar, com.bytedance.msdk.b.b.hc.d.b bVar) {
        super(dVar);
        this.mq = bVar;
    }

    @Override // com.bytedance.msdk.b.d.c
    public <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8130) {
            if (el() == 5) {
                if (nv() == 5) {
                    if (this.an != null) {
                        this.an.d(null);
                    }
                } else if (this.d != null) {
                    this.d.d(null);
                }
            } else if (el() == 9 && this.an != null) {
                this.an.d(null);
            }
        } else if (i == 8113) {
            if (el() == 5) {
                if (nv() == 5) {
                    if (this.an != null) {
                        this.an.d();
                    }
                } else if (this.d != null) {
                    this.d.d();
                }
            } else if (el() == 9 && this.an != null) {
                this.an.d();
            }
        } else if (i == 8131) {
            if (this.mq != null) {
                this.mq.d(this, pluginValueSet.stringValue(8036));
            }
        } else if (i == 8132) {
            if (this.tc != null) {
                com.bytedance.msdk.core.hc.d.d(this.tc.hc());
            }
            if (this.mk != null) {
                this.mk.d(pluginValueSet.intValue(8038), pluginValueSet.stringValue(8039), false);
            }
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            if (el() == 5) {
                if (nv() == 5) {
                    if (this.an instanceof com.bytedance.msdk.api.c.d.b.c) {
                        ((com.bytedance.msdk.api.c.d.b.c) this.an).d(fFloatValue, fFloatValue2);
                    }
                } else if (this.d instanceof com.bytedance.msdk.api.c.d.h.an) {
                    ((com.bytedance.msdk.api.c.d.h.an) this.d).d(fFloatValue, fFloatValue2);
                }
            } else if (el() == 9 && (this.an instanceof com.bytedance.msdk.api.c.d.b.c)) {
                ((com.bytedance.msdk.api.c.d.b.c) this.an).d(fFloatValue, fFloatValue2);
            }
        } else if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (el() == 5) {
                if (nv() == 5) {
                    if (this.an instanceof com.bytedance.msdk.api.c.d.b.c) {
                        ((com.bytedance.msdk.api.c.d.b.c) this.an).d(view, strStringValue, iIntValue);
                    }
                } else if (this.d instanceof com.bytedance.msdk.api.c.d.h.an) {
                    ((com.bytedance.msdk.api.c.d.h.an) this.d).d(view, strStringValue, iIntValue);
                }
            } else if (el() == 9 && (this.an instanceof com.bytedance.msdk.api.c.d.b.c)) {
                ((com.bytedance.msdk.api.c.d.b.c) this.an).d(view, strStringValue, iIntValue);
            }
        } else if (i == 8140) {
            String strStringValue2 = pluginValueSet.stringValue(8045);
            String strStringValue3 = pluginValueSet.stringValue(8046);
            int iIntValue2 = pluginValueSet.intValue(8047);
            String strStringValue4 = pluginValueSet.stringValue(8048);
            String strStringValue5 = pluginValueSet.stringValue(8049);
            String strStringValue6 = pluginValueSet.stringValue(8050);
            int iIntValue3 = pluginValueSet.intValue(8051);
            int iIntValue4 = pluginValueSet.intValue(8052);
            List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
            String strStringValue7 = pluginValueSet.stringValue(8054);
            boolean zBooleanValue = pluginValueSet.booleanValue(8055);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            String strStringValue9 = pluginValueSet.stringValue(8057);
            Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
            String strStringValue10 = pluginValueSet.stringValue(8058);
            double dDoubleValue = pluginValueSet.doubleValue(8016);
            boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
            int iIntValue5 = pluginValueSet.intValue(8060);
            String strStringValue11 = pluginValueSet.stringValue(8061);
            String strStringValue12 = pluginValueSet.stringValue(8061);
            long jLongValue = pluginValueSet.longValue(8078);
            String strStringValue13 = pluginValueSet.stringValue(8079);
            Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
            String strStringValue14 = pluginValueSet.stringValue(8080);
            String strStringValue15 = pluginValueSet.stringValue(8081);
            double dDoubleValue2 = pluginValueSet.doubleValue(8082);
            int iIntValue6 = pluginValueSet.intValue(8059);
            String strStringValue16 = pluginValueSet.stringValue(8551);
            String strStringValue17 = pluginValueSet.stringValue(8559);
            int iIntValue7 = pluginValueSet.intValue(8553);
            us(strStringValue2);
            z(strStringValue3);
            jh(iIntValue2);
            vv(strStringValue4);
            fs(strStringValue5);
            zw(strStringValue6);
            rf(iIntValue3);
            yo(iIntValue4);
            d(list);
            s(strStringValue7);
            gb(zBooleanValue);
            de(strStringValue8);
            v(strStringValue9);
            if (TextUtils.equals(nw(), AdnName.BAIDU)) {
                d("baidu_dislike_info", objObjectValue);
            }
            k(strStringValue10);
            d(dDoubleValue);
            h(zBooleanValue2);
            mk(iIntValue5);
            j(strStringValue11);
            sy(strStringValue12);
            hc(jLongValue);
            np(strStringValue13);
            u(map);
            yi(strStringValue14);
            he(strStringValue15);
            c(dDoubleValue2);
            mq(iIntValue6);
            mq(strStringValue16);
            tc(strStringValue17);
            hc(iIntValue7);
        } else {
            if (i == 8143) {
                return (T) Double.valueOf(kb());
            }
            if (i == 8145) {
                if (this.hc != null) {
                    this.hc.hc();
                }
            } else if (i == 8146) {
                if (this.hc != null) {
                    this.hc.b();
                }
            } else if (i == 8118) {
                if (this.hc != null) {
                    this.hc.u();
                }
            } else if (i == 8117) {
                int iIntValue8 = pluginValueSet.intValue(8014);
                String strStringValue18 = pluginValueSet.stringValue(8015);
                if (this.hc != null) {
                    this.hc.d(new com.bytedance.msdk.api.d(iIntValue8, strStringValue18));
                }
            } else if (i == 8150) {
                if (this.hc != null) {
                    this.hc.c();
                }
            } else if (i == 1025) {
                if (this.hc != null) {
                    this.hc.d(pluginValueSet.longValue(8072), pluginValueSet.longValue(8073));
                }
            } else if (i == 8152) {
                if (this.b != null) {
                    this.b.d();
                }
            } else if (i == 8153) {
                if (this.b != null) {
                    this.b.hc();
                }
            } else if (i == 8187) {
                if (this.b != null) {
                    this.b.d(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.intValue(8064), pluginValueSet.intValue(8065), "", "");
                }
            } else if (i == 8155) {
                if (this.b != null) {
                    this.b.d(pluginValueSet.longValue(8062), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8156) {
                if (this.b != null) {
                    this.b.d(pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8157) {
                if (this.b != null) {
                    this.b.hc(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8158) {
                if (this.b != null) {
                    this.b.d(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else {
                if (i == 8160) {
                    return (T) Boolean.valueOf(mt());
                }
                if (i == 6069) {
                    return (T) Integer.valueOf(ar());
                }
                if (i == 8185) {
                    com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar = this.mk;
                    if (dVar != null) {
                        dVar.d();
                    }
                } else if (i == 8184) {
                    com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = this.mk;
                    if (dVar2 != null) {
                        dVar2.hc();
                    }
                } else {
                    if (i == 8196) {
                        return (T) Boolean.valueOf(ey());
                    }
                    if (i == 8197) {
                        if (this.c != null) {
                            this.c.d();
                        }
                    } else if (i == 8227) {
                        if (pluginValueSet != null) {
                            c((Map<String, Object>) pluginValueSet.objectValue(8075, Map.class));
                        }
                    } else if (i == 6107 && this.u != null) {
                        this.u.d(pluginValueSet.intValue(20055));
                    }
                }
            }
        }
        return (T) com.bytedance.msdk.core.cb.d.d(cls);
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
        this.mk = dVar;
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6085).d(Void.class).d(20033, activity).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void mk() {
        super.mk();
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6083).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public View tt() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6081).d(View.class).hc());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.tt();
    }

    @Override // com.bytedance.msdk.hc.b
    public View tc() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6164).d(View.class).hc());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.tc();
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean jh() {
        try {
            if (this.tt != null) {
                Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8135).d(Boolean.class).hc());
                if (objApply instanceof Boolean) {
                    return ((Boolean) objApply).booleanValue();
                }
                return false;
            }
        } catch (Exception unused) {
        }
        return super.jh();
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        return com.bytedance.msdk.core.d.d.u.d(nr(), this.tt);
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tc tcVar, List<View> list4) {
        super.d(activity, viewGroup, list, list2, list3, tcVar, list4);
        hc(activity, viewGroup, list, list2, list3, tcVar, list4);
    }

    private void hc(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tc tcVar, List<View> list4) {
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8159).d(Void.class).d(20033, activity).d(8067, viewGroup).d(8068, list).d(8069, list2).d(8070, list3).d(8071, tc.d(tcVar)).d(8053, list4).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public String ai() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8147).d(String.class).hc());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.ai();
    }

    @Override // com.bytedance.msdk.hc.b
    public int mg() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8161).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.mg();
    }

    @Override // com.bytedance.msdk.hc.b
    public int pa() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8162).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.mg();
    }

    @Override // com.bytedance.msdk.hc.b
    public String h() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8163).d(String.class).hc());
            return objApply instanceof String ? objApply.toString() : "";
        }
        return super.h();
    }

    @Override // com.bytedance.msdk.hc.b
    public mq n() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8269).d(Map.class).hc());
            if (objApply instanceof Map) {
                Map map = (Map) objApply;
                Object obj = map.get("imgUrl");
                final Object obj2 = map.get("width");
                final Object obj3 = map.get("height");
                final Object obj4 = map.get("valid");
                final Object obj5 = map.get("duration");
                if (obj instanceof String) {
                    final String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        return new mq() { // from class: com.bytedance.msdk.b.d.h.1
                            public int d() {
                                Object obj6 = obj3;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            public int hc() {
                                Object obj6 = obj2;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            public String b() {
                                return str;
                            }

                            public double c() {
                                Object obj6 = obj5;
                                if (obj6 instanceof Double) {
                                    return ((Double) obj6).doubleValue();
                                }
                                return 0.0d;
                            }

                            public boolean u() {
                                Object obj6 = obj4;
                                return (obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue();
                            }
                        };
                    }
                }
            }
        }
        return super.n();
    }

    @Override // com.bytedance.msdk.hc.b
    public Bitmap uq() {
        if (TextUtils.equals(nr(), "gdt") && com.bytedance.msdk.core.d.d.u.d("gdt")) {
            return jh.c(com.bytedance.msdk.core.hc.getContext(), "tt_adapter_gdt_logo");
        }
        if (TextUtils.equals(nr(), "ks") && com.bytedance.msdk.core.d.d.u.d("ks")) {
            return jh.c(com.bytedance.msdk.core.hc.getContext(), "tt_adapter_ks_logo");
        }
        if (TextUtils.equals(nr(), AdnName.BAIDU) && com.bytedance.msdk.core.d.d.u.d(AdnName.BAIDU)) {
            return jh.c(com.bytedance.msdk.core.hc.getContext(), "tt_adapter_baidu_logo");
        }
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8267).d(Bitmap.class).hc());
            if (objApply instanceof Bitmap) {
                return (Bitmap) objApply;
            }
            return null;
        }
        return super.uq();
    }

    @Override // com.bytedance.msdk.hc.b
    public double bd() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8268).d(Double.class).hc());
            if (objApply instanceof Double) {
                return ((Double) objApply).doubleValue();
            }
            return 0.0d;
        }
        return super.bd();
    }

    @Override // com.bytedance.msdk.hc.b
    public com.bytedance.msdk.api.c.d.h.u gb() {
        if (this.tt == null) {
            return null;
        }
        Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8320).d(Function.class).hc());
        if (objApply instanceof Function) {
            return com.bytedance.msdk.core.d.d.d((Function) objApply);
        }
        return null;
    }

    @Override // com.bytedance.msdk.hc.b
    public void d() {
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8191).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc() {
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8192).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void b() {
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6093).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public int c() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8193).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.c();
    }
}
