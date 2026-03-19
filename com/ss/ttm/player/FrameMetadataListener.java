package com.ss.ttm.player;

import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface FrameMetadataListener {
    default void didReceivePacket(int i, long j, long j2, Map<Integer, String> map) {
    }

    void frameDTSNotify(int i, long j, long j2);

    default void onAbrDecisionInfo(long j, String str) {
    }

    void onFrameAboutToBeRendered(int i, long j, long j2, Map<Integer, String> map);

    default void receiveBinarySei(ByteBuffer byteBuffer) {
    }

    void updateFrameTerminatedDTS(int i, long j, long j2);
}
