package com.tencent.turingfd.sdk.ams.au;

import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.abstract, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cabstract {
    public Map<Integer, Long> a = new HashMap();
    public Map<Integer, Long> b = new HashMap();

    public void a(int i, long j) {
        this.a.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        for (Integer num : this.a.keySet()) {
            int iIntValue = num.intValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(iIntValue);
            sb.append(Config.replace);
            sb.append(this.a.get(num));
        }
        for (Integer num2 : this.b.keySet()) {
            int iIntValue2 = num2.intValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append('s');
            sb.append(iIntValue2);
            sb.append(Config.replace);
            sb.append(this.b.get(num2));
        }
        return sb.toString();
    }
}
