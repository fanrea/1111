package com.android.gdt.qone.x;

import androidx.core.location.LocationRequestCompat;
import com.android.gdt.qone.ae.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import org.aspectj.lang.JoinPoint;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b {
    public RandomAccessFile a;
    public FileChannel b;
    public FileLock c;

    public final boolean a(String str, a aVar, int i) throws IOException {
        boolean z = false;
        if (!c.a(str)) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(com.android.gdt.qone.w.a.b(), str).getAbsolutePath(), "rw");
            this.a = randomAccessFile;
            FileChannel channel = randomAccessFile.getChannel();
            this.b = channel;
            if (channel != null) {
                if (i == 1) {
                    this.c = channel.tryLock();
                } else if (i == 2) {
                    this.c = channel.lock(0L, LocationRequestCompat.PASSIVE_INTERVAL, true);
                } else if (i == 3) {
                    this.c = channel.lock();
                }
            }
            if (this.c != null) {
                aVar.a();
                z = true;
            }
        } catch (Exception e) {
            com.android.gdt.qone.af.c.b(JoinPoint.SYNCHRONIZATION_LOCK, "except %d, %s", Integer.valueOf(i), e.getMessage());
        } finally {
            a();
        }
        return z;
    }

    public final void a() throws IOException {
        try {
            FileLock fileLock = this.c;
            if (fileLock != null) {
                fileLock.release();
            }
            FileChannel fileChannel = this.b;
            if (fileChannel != null) {
                fileChannel.close();
            }
            RandomAccessFile randomAccessFile = this.a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (IOException e) {
            com.android.gdt.qone.af.c.a(e);
        }
    }
}
