package com.bytedance.msdk.b.d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.d.h.tc;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends c {
    public b(com.bytedance.msdk.b.an.hc.d dVar) {
        super(dVar);
    }

    private com.bytedance.msdk.api.c.d.d.d xq() {
        return (com.bytedance.msdk.api.c.d.d.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        return com.bytedance.msdk.core.d.d.u.d(nr(), this.tt);
    }

    @Override // com.bytedance.msdk.hc.b
    public String ai() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8147).d(String.class).hc());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        }
        return super.ai();
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
    public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tc tcVar, List<View> list4) {
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8159).d(Void.class).d(20033, activity).d(8067, viewGroup).d(8068, list).d(8069, list2).d(8070, list3).d(8071, tc.d(tcVar)).hc());
        }
    }

    @Override // com.bytedance.msdk.b.d.c
    public <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 1008) {
            if (!(this.h instanceof com.bytedance.msdk.api.c.d.d.d)) {
                return null;
            }
            xq().hc(null);
            return null;
        }
        if (i != 1009) {
            if (i != 1014) {
                if (i == 1016) {
                    boolean z = this.h instanceof com.bytedance.msdk.api.c.d.d.d;
                } else if (i == 8111) {
                    d(pluginValueSet.doubleValue(8016));
                } else if (i == 8140) {
                    String strStringValue = pluginValueSet.stringValue(8045);
                    String strStringValue2 = pluginValueSet.stringValue(8046);
                    int iIntValue = pluginValueSet.intValue(8047);
                    String strStringValue3 = pluginValueSet.stringValue(8048);
                    String strStringValue4 = pluginValueSet.stringValue(8049);
                    String strStringValue5 = pluginValueSet.stringValue(8050);
                    int iIntValue2 = pluginValueSet.intValue(8051);
                    int iIntValue3 = pluginValueSet.intValue(8052);
                    List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
                    String strStringValue6 = pluginValueSet.stringValue(8054);
                    boolean zBooleanValue = pluginValueSet.booleanValue(8055);
                    String strStringValue7 = pluginValueSet.stringValue(8056);
                    String strStringValue8 = pluginValueSet.stringValue(8057);
                    Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
                    String strStringValue9 = pluginValueSet.stringValue(8058);
                    double dDoubleValue = pluginValueSet.doubleValue(8016);
                    boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
                    int iIntValue4 = pluginValueSet.intValue(8060);
                    String strStringValue10 = pluginValueSet.stringValue(8061);
                    String strStringValue11 = pluginValueSet.stringValue(8061);
                    long jLongValue = pluginValueSet.longValue(8078);
                    String strStringValue12 = pluginValueSet.stringValue(8079);
                    Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
                    String strStringValue13 = pluginValueSet.stringValue(8080);
                    String strStringValue14 = pluginValueSet.stringValue(8081);
                    double dDoubleValue2 = pluginValueSet.doubleValue(8082);
                    int iIntValue5 = pluginValueSet.intValue(8059);
                    String strStringValue15 = pluginValueSet.stringValue(8551);
                    String strStringValue16 = pluginValueSet.stringValue(8559);
                    us(strStringValue);
                    z(strStringValue2);
                    jh(iIntValue);
                    vv(strStringValue3);
                    fs(strStringValue4);
                    zw(strStringValue5);
                    rf(iIntValue2);
                    yo(iIntValue3);
                    d(list);
                    s(strStringValue6);
                    gb(zBooleanValue);
                    de(strStringValue7);
                    v(strStringValue8);
                    if (TextUtils.equals(nw(), AdnName.BAIDU)) {
                        d("baidu_dislike_info", objObjectValue);
                    }
                    k(strStringValue9);
                    d(dDoubleValue);
                    h(zBooleanValue2);
                    mk(iIntValue4);
                    mq(iIntValue5);
                    j(strStringValue10);
                    sy(strStringValue11);
                    hc(jLongValue);
                    np(strStringValue12);
                    u(map);
                    yi(strStringValue13);
                    he(strStringValue14);
                    c(dDoubleValue2);
                    mq(strStringValue15);
                    tc(strStringValue16);
                } else if (i == 8207) {
                    k(pluginValueSet.stringValue(8058));
                }
            } else if (this.h instanceof com.bytedance.msdk.api.c.d.d.d) {
                if (this.tc != null) {
                    com.bytedance.msdk.core.hc.d.d(this.tc.hc());
                }
                xq().f_();
            }
        } else if (this.h instanceof com.bytedance.msdk.api.c.d.d.d) {
            xq().d((View) null);
            return null;
        }
        return null;
    }
}
