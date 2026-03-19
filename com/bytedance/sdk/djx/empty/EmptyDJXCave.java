package com.bytedance.sdk.djx.empty;

import com.bytedance.sdk.djx.IDJXCave;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EmptyDJXCave implements IDJXCave {
    @Override // com.bytedance.sdk.djx.IDJXCave
    public String a() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXCave
    public void b(Map<String, String> map) {
    }

    public static EmptyDJXCave getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final EmptyDJXCave instance = new EmptyDJXCave();

        private InnerHolder() {
        }
    }
}
