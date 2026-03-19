package com.bytedance.sdk.component.b.hc;

import com.baidu.mobstat.forbes.Config;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum np {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(Config.EVENT_NATIVE_VIEW_HIERARCHY);

    private final String u;

    np(String str) {
        this.u = str;
    }

    public static np d(String str) throws IOException {
        np npVar = HTTP_1_0;
        if (str.equals(npVar.u)) {
            return npVar;
        }
        np npVar2 = HTTP_1_1;
        if (str.equals(npVar2.u)) {
            return npVar2;
        }
        np npVar3 = HTTP_2;
        if (str.equals(npVar3.u)) {
            return npVar3;
        }
        np npVar4 = SPDY_3;
        if (str.equals(npVar4.u)) {
            return npVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.u;
    }
}
