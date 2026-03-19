package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeABRStrategy extends ABRStrategy {
    public NativeABRStrategy(long j) {
        setWeakNativeObj(j);
    }

    @Override // com.ss.ttm.player.ABRStrategy
    protected int probeBitrate(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.ABRStrategy
    protected String probeBitrate(String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    public static boolean isNativeABRStrategy(ABRStrategy aBRStrategy) {
        return aBRStrategy instanceof NativeABRStrategy;
    }
}
