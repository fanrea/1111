package androidx.emoji2.text.flatbuffer;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class IntVector extends BaseVector {
    public IntVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 4, byteBuffer);
        return this;
    }

    public int get(int i) {
        return this.bb.getInt(__element(i));
    }

    public long getAsUnsigned(int i) {
        return get(i) & C00oOOo.f362O8oO888;
    }
}
