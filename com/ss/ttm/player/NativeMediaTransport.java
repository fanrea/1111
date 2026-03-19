package com.ss.ttm.player;

import android.util.AndroidRuntimeException;
import com.ss.ttm.player.MediaTransport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeMediaTransport extends MediaTransport {
    @Override // com.ss.ttm.player.MediaTransport
    protected void sendPacket(MediaTransport.MediaPacket mediaPacket) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeMediaTransport(MediaTransport mediaTransport) {
        return mediaTransport instanceof NativeMediaTransport;
    }
}
