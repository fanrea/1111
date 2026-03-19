package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.mq;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AJMediaCodecFrame implements Cloneable {
    public ByteBuffer data;
    public int flags;
    public int index;
    public long pts = -269488145;
    public int size;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m344clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }
}
