package com.bytedance.sdk.component.hc.d;

import com.baidu.mobstat.forbes.Config;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum uo {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(Config.EVENT_NATIVE_VIEW_HIERARCHY);

    private final String u;

    uo(String str) {
        this.u = str;
    }

    public static uo d(String str) throws IOException {
        uo uoVar = HTTP_1_0;
        if (str.equals(uoVar.u)) {
            return uoVar;
        }
        uo uoVar2 = HTTP_1_1;
        if (str.equals(uoVar2.u)) {
            return uoVar2;
        }
        uo uoVar3 = HTTP_2;
        if (str.equals(uoVar3.u)) {
            return uoVar3;
        }
        uo uoVar4 = SPDY_3;
        if (str.equals(uoVar4.u)) {
            return uoVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.u;
    }
}
