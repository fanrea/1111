package com.yxcorp.livestream.longconnection.horserace;

import com.kuaishou.android.live.model.Round;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class RacePolicyFactory {
    private static final int BARRIER = 2;
    private static final int FASTEST = 1;

    public static RacePolicy create(Round round, boolean z) {
        if (round.mPolicy != 2) {
            return new FastestPolicy(round.mTimeout, z);
        }
        return new BarrierPolicy(round.mBarriers, round.mTimeout, z);
    }
}
