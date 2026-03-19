package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AJMediaCodecFrame implements Cloneable {
    public ByteBuffer data;
    public int flags;
    public int index;
    public long pts = -269488145;
    public int size;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m1513clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
