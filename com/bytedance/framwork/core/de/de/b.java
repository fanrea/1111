package com.bytedance.framwork.core.de.de;

import java.util.List;
import org.json.JSONObject;

/* compiled from: IMonitorConfigure.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface b {
    boolean getRemoveSwitch();

    int reportCount();

    int reportFailRepeatBaseTime();

    int reportFailRepeatCount();

    int reportInterval();

    JSONObject reportJsonHeaderInfo();

    List<String> reportUrl(String str);
}
