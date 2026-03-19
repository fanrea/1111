package com.bytedance.msdk.b.b.hc.d.d;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends hc {
    public b(String str, com.bytedance.msdk.b.d.hc hcVar) {
        super(str, hcVar);
    }

    public void hc(List<Function<SparseArray<Object>, Object>> list) {
        if (list != null) {
            if (!hc()) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<Function<SparseArray<Object>, Object>> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.bytedance.msdk.b.d.d.c(this, it.next()));
                }
                d(arrayList);
                return;
            }
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        d(new com.bytedance.msdk.api.c.d.hc.d(49010, "list is null"));
    }

    public void d(com.bytedance.msdk.api.c.d.hc.d dVar) {
        if (!d()) {
            d(new com.bytedance.msdk.api.d(49010, com.bytedance.msdk.api.d.d(49010), dVar == null ? -1 : dVar.d(), dVar == null ? "" : dVar.hc()));
        } else {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
        }
    }

    public boolean b() {
        return this.hc != null && this.hc.hc() == 1;
    }

    public boolean c() {
        return this.hc != null && this.hc.hc() == 2;
    }

    @Override // com.bytedance.msdk.b.b.hc.d.d.hc
    public <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8222) {
            boolean zB = b();
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom draw loader : isExpressRender: " + zB);
            return (T) Boolean.valueOf(zB);
        }
        if (i == 8223) {
            boolean zC = c();
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom draw loader : isNativeAd: " + zC);
            return (T) Boolean.valueOf(zC);
        }
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom draw loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            d(iIntValue, strStringValue);
            return null;
        }
        if (i != 8107) {
            return null;
        }
        List<Function<SparseArray<Object>, Object>> list = (List) pluginValueSet.objectValue(AVMDLDataLoader.KeyIsGetCookieTokenLevel, List.class);
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom draw loader : callLoadSucceed  list size:" + (list != null ? list.size() : 0));
        hc(list);
        return null;
    }
}
