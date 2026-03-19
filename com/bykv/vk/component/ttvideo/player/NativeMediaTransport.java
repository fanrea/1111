package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import com.bykv.vk.component.ttvideo.player.MediaTransport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NativeMediaTransport extends MediaTransport {
    @Override // com.bykv.vk.component.ttvideo.player.MediaTransport
    protected void sendPacket(MediaTransport.MediaPacket mediaPacket) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeMediaTransport(MediaTransport mediaTransport) {
        return mediaTransport instanceof NativeMediaTransport;
    }
}
