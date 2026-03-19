package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeMaskInfo extends MaskInfo {
    @Override // com.ss.ttm.player.MaskInfo
    protected void onMaskInfoCallback(int i, int i2, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeMaskInfo(MaskInfo maskInfo) {
        return maskInfo instanceof NativeMaskInfo;
    }
}
