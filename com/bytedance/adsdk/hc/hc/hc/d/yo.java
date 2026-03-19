package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yo extends w {
    private static final ThreadLocal<StringBuilder> c = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.hc.hc.hc.d.yo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public yo() {
        super(com.bytedance.adsdk.hc.hc.c.b.PLUS);
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        Object objD;
        Object objD2 = this.d.d(map);
        if (objD2 == null || (objD = this.hc.d(map)) == null) {
            return null;
        }
        if ((objD2 instanceof String) || (objD instanceof String)) {
            StringBuilder sb = c.get();
            sb.append(objD2).append(objD);
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        return com.bytedance.adsdk.hc.hc.u.d.gb.d((Number) objD2, (Number) objD);
    }
}
