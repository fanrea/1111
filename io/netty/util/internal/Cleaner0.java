package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import sun.misc.Cleaner;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class Cleaner0 {
    private static final long CLEANER_FIELD_OFFSET;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Cleaner0.class);

    static {
        long jObjectFieldOffset;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
        if (PlatformDependent0.hasUnsafe()) {
            try {
                Field declaredField = byteBufferAllocateDirect.getClass().getDeclaredField("cleaner");
                declaredField.setAccessible(true);
                ((Cleaner) declaredField.get(byteBufferAllocateDirect)).clean();
                jObjectFieldOffset = PlatformDependent0.objectFieldOffset(declaredField);
            } catch (Throwable unused) {
            }
        } else {
            jObjectFieldOffset = -1;
        }
        logger.debug("java.nio.ByteBuffer.cleaner(): {}", jObjectFieldOffset != -1 ? "available" : "unavailable");
        CLEANER_FIELD_OFFSET = jObjectFieldOffset;
        freeDirectBuffer(byteBufferAllocateDirect);
    }

    static void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (CLEANER_FIELD_OFFSET == -1 || !byteBuffer.isDirect()) {
            return;
        }
        try {
            Cleaner cleaner = (Cleaner) PlatformDependent0.getObject(byteBuffer, CLEANER_FIELD_OFFSET);
            if (cleaner != null) {
                cleaner.clean();
            }
        } catch (Throwable unused) {
        }
    }

    private Cleaner0() {
    }
}
