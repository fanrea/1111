package com.bytedance.framwork.core.de.de;

import java.util.List;
import org.json.JSONObject;

/* compiled from: DefaultMonitorConfigure.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a implements b {
    @Override // com.bytedance.framwork.core.de.de.b
    public boolean getRemoveSwitch() {
        return false;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportCount() {
        return 100;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportFailRepeatBaseTime() {
        return 15;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportFailRepeatCount() {
        return 4;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportInterval() {
        return 120;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public JSONObject reportJsonHeaderInfo() {
        return null;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public List<String> reportUrl(String str) {
        return null;
    }
}
