package com.kwad.sdk.ip.direct;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float cbU = -1.0f;
    private int cca = 20;
    private int cbZ = 3;
    private StringBuffer ccb = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.cbZ + ", pingWaitTime=" + this.cca + ", pingTime='" + this.cbU + " ms', success=" + this.success + '}';
    }

    public final int akC() {
        return this.cbZ;
    }

    public final String getIp() {
        return this.ip;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final void dd(boolean z) {
        this.success = z;
    }

    public final float akD() {
        return this.cbU;
    }

    public final void R(float f) {
        this.cbU = f;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void gx(int i) {
        this.weight = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return (int) (this.cbU - cVar.cbU);
    }
}
