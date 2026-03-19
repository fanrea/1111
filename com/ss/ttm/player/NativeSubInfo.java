package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeSubInfo extends SubInfo {
    @Override // com.ss.ttm.player.SubInfo
    protected void onSubInfoCallback(int i, int i2, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubInfoCallback2(int i, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubSwitchCompleted(int i, int i2) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubLoadFinished(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubLoadFinished2(int i, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeSubInfo(SubInfo subInfo) {
        return subInfo instanceof NativeSubInfo;
    }
}
