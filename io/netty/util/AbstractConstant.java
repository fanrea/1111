package io.netty.util;

import io.netty.util.AbstractConstant;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThreadLocalRandom;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private ByteBuffer directBuffer;
    private final int id;
    private final String name;
    private volatile long uniquifier;

    protected AbstractConstant(int i, String str) {
        this.id = i;
        this.name = str;
    }

    @Override // io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    @Override // io.netty.util.Constant
    public final int id() {
        return this.id;
    }

    public final String toString() {
        return name();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.lang.Comparable
    public final int compareTo(T t) {
        if (this == t) {
            return 0;
        }
        int iHashCode = hashCode() - t.hashCode();
        if (iHashCode != 0) {
            return iHashCode;
        }
        long jUniquifier = uniquifier();
        long jUniquifier2 = t.uniquifier();
        if (jUniquifier < jUniquifier2) {
            return -1;
        }
        if (jUniquifier > jUniquifier2) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }

    private long uniquifier() {
        long j = this.uniquifier;
        if (j == 0) {
            synchronized (this) {
                while (true) {
                    j = this.uniquifier;
                    if (j != 0) {
                        break;
                    }
                    if (PlatformDependent.hasUnsafe()) {
                        this.directBuffer = ByteBuffer.allocateDirect(1);
                        this.uniquifier = PlatformDependent.directBufferAddress(this.directBuffer);
                    } else {
                        this.directBuffer = null;
                        this.uniquifier = ThreadLocalRandom.current().nextLong();
                    }
                }
            }
        }
        return j;
    }
}
