package com.bytedance.sdk.component.panglearmor.d.hc;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b {
    public static hc d(RandomAccessFile randomAccessFile, long j, long j2) {
        return d(randomAccessFile.getChannel(), j, j2);
    }

    public static hc d(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new c(fileChannel, j, j2);
    }
}
