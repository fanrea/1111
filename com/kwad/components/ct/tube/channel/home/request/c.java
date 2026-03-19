package com.kwad.components.ct.tube.channel.home.request;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends com.kwad.sdk.core.response.a.a {
    public int aUm;
    public int aWM;
    public List<Long> aWN;
    public int freeEpisodeCount;
    public int pcursor;
    public long tubeId;
    public int unlockEpisodeCount;
    public int unlockEpisodeNum;
    public int watchEpisodeNum;

    private c() {
    }

    public static c Kr() {
        return new c();
    }

    public final c am(long j) {
        this.tubeId = j;
        return this;
    }

    public final c cL(int i) {
        this.aWM = i;
        return this;
    }

    public final c cM(int i) {
        this.pcursor = i;
        return this;
    }

    public final c cN(int i) {
        this.freeEpisodeCount = i;
        return this;
    }

    public final c cO(int i) {
        this.unlockEpisodeCount = i;
        return this;
    }

    public final c cP(int i) {
        this.watchEpisodeNum = i;
        return this;
    }

    public final c cQ(int i) {
        this.unlockEpisodeNum = i;
        return this;
    }

    public final c T(List<Long> list) {
        this.aWN = list;
        return this;
    }

    public final c cR(int i) {
        this.aUm = 1;
        return this;
    }
}
