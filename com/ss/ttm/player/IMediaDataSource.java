package com.ss.ttm.player;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IMediaDataSource extends Closeable {
    public static final int MDS_VERSION_0 = 0;
    public static final int MDS_VERSION_1 = 1;

    default int close(int i) {
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    default String getFilePath() {
        return "/mds_default_file";
    }

    default int getMDSVersion() {
        return 0;
    }

    long getSize() throws IOException;

    default long getSize(int i) {
        return -1L;
    }

    default int open(String str) {
        return -1;
    }

    default int readAt(int i, long j, ByteBuffer byteBuffer, int i2, int i3) {
        return -1;
    }

    int readAt(long j, byte[] bArr, int i, int i2) throws IOException;
}
