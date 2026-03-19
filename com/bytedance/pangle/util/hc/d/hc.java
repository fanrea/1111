package com.bytedance.pangle.util.hc.d;

import com.bytedance.pangle.util.hc.hc.c;
import com.ss.ttm.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public void d(c cVar, RandomAccessFile randomAccessFile) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (cVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            long filePointer = randomAccessFile.getFilePointer();
            d(cVar, byteArrayOutputStream);
            d(cVar, byteArrayOutputStream.size(), (int) filePointer, byteArrayOutputStream);
            randomAccessFile.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th;
        }
    }

    private void d(c cVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (cVar.d() == null || cVar.d().d() == null || cVar.d().d().size() <= 0) {
            return;
        }
        Iterator<com.bytedance.pangle.util.hc.hc.b> it = cVar.d().d().iterator();
        while (it.hasNext()) {
            d(it.next(), byteArrayOutputStream, cVar.c());
        }
    }

    private void d(com.bytedance.pangle.util.hc.hc.b bVar, ByteArrayOutputStream byteArrayOutputStream, b bVar2) throws IOException {
        if (bVar == null) {
            throw new IOException("input parameters is null, cannot write local file header");
        }
        byte[] bArr = {0, 0};
        bVar2.d((OutputStream) byteArrayOutputStream, 33639248);
        bVar2.d(byteArrayOutputStream, 0);
        bVar2.d(byteArrayOutputStream, 0);
        bVar2.d(byteArrayOutputStream, 0);
        bVar2.d(byteArrayOutputStream, bVar.d());
        bVar2.d(byteArrayOutputStream, 2081);
        bVar2.d(byteArrayOutputStream, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SWITCH_ACTION);
        bVar2.d((OutputStream) byteArrayOutputStream, (int) bVar.h());
        bVar2.d((OutputStream) byteArrayOutputStream, (int) bVar.gb());
        bVar2.d((OutputStream) byteArrayOutputStream, (int) bVar.tt());
        byte[] bArrD = new byte[0];
        if (bVar.mq() != null && bVar.mq().trim().length() > 0) {
            bArrD = d(bVar.mq());
        }
        bVar2.d(byteArrayOutputStream, bArrD.length);
        int iMk = bVar.mk();
        bVar2.d(byteArrayOutputStream, iMk);
        bVar2.d(byteArrayOutputStream, 0);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        bVar2.d((OutputStream) byteArrayOutputStream, (int) bVar.uo());
        if (bArrD.length > 0) {
            byteArrayOutputStream.write(bArrD);
        }
        if (iMk > 0) {
            byteArrayOutputStream.write(new byte[iMk]);
        }
    }

    private void d(c cVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        cVar.c().d((OutputStream) byteArrayOutputStream, 101010256);
        cVar.c().d(byteArrayOutputStream, 0);
        cVar.c().d(byteArrayOutputStream, 0);
        int size = cVar.d().d().size();
        cVar.c().d(byteArrayOutputStream, size);
        cVar.c().d(byteArrayOutputStream, size);
        cVar.c().d((OutputStream) byteArrayOutputStream, i);
        cVar.c().d((OutputStream) byteArrayOutputStream, i2);
        cVar.c().d(byteArrayOutputStream, 0);
    }

    private byte[] d(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}
