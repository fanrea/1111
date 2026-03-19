package com.kwad.sdk.crash.online.monitor.block;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BlockEvent extends com.kwad.sdk.core.response.a.a {
    public long blockTimeThreshold;
    public long blockDuration = 0;
    public long blockLoopInterval = 100;
    public long calcBlockOverhead = 0;
    public String currentActivity = "";
    public String processName = "";
    public List<a> stackTraceSample = new ArrayList();

    public static class a extends com.kwad.sdk.core.response.a.a {
        public long bOa;
        public boolean bOb = false;
        public String bOc;
        public long bOd;
        public int repeatCount;
    }
}
