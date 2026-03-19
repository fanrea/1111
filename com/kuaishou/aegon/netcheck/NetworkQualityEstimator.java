package com.kuaishou.aegon.netcheck;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class NetworkQualityEstimator {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class Metrics {
        public int downstreamThroughputKbps;
        public float gatewayLoss;
        public float gatewayRttMs;
        public float serverRttMs;
        public int signalStrength;

        public Metrics(float f, float f2, float f3, int i, int i2) {
            this.gatewayLoss = f;
            this.gatewayRttMs = f2;
            this.serverRttMs = f3;
            this.downstreamThroughputKbps = i;
            this.signalStrength = i2;
        }

        public Metrics() {
            this(0.0f, -1.0f, -1.0f, -1, -1);
        }
    }
}
