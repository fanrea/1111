package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.mq;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AJCodecBuffer implements Cloneable {
    public ByteBuffer data;
    public int index;
    public long pts;
    public int size;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJCodecBuffer m343clone() {
        AJCodecBuffer aJCodecBuffer;
        try {
            aJCodecBuffer = (AJCodecBuffer) super.clone();
        } catch (Throwable th) {
            mq.d(th);
            aJCodecBuffer = null;
        }
        aJCodecBuffer.size = this.size;
        aJCodecBuffer.pts = this.pts;
        aJCodecBuffer.index = this.index;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.size);
        byteBufferAllocateDirect.put(this.data);
        aJCodecBuffer.data = byteBufferAllocateDirect;
        return aJCodecBuffer;
    }
}
