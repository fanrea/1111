package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f {
    public static MessageSnapshot a(int i, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new d.a(i, true, length);
            }
            return new d.b(i, true, length);
        }
        if (z) {
            return new h.a(i, true, (int) length);
        }
        return new h.b(i, true, (int) length);
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        if (j2 > 2147483647L) {
            if (z) {
                return new d.i(i, j, j2);
            }
            return new d.j(i, j, j2);
        }
        if (z) {
            return new h.i(i, (int) j, (int) j2);
        }
        return new h.j(i, (int) j, (int) j2);
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        if (j > 2147483647L) {
            return new d.C0559d(i, j, th);
        }
        return new h.d(i, (int) j, th);
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.Mm()) {
            return new d.e(aVar.getId(), aVar.Me(), aVar.Mf());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.Mg() != -3) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Mg())));
        }
        return new a.C0558a(messageSnapshot);
    }

    public static MessageSnapshot a(byte b, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        MessageSnapshot dVar;
        IllegalStateException illegalStateException;
        int id = cVar.getId();
        if (b == -4) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b == -3) {
            if (cVar.Mm()) {
                return new d.b(id, false, cVar.getTotal());
            }
            return new h.b(id, false, (int) cVar.getTotal());
        }
        if (b != -1) {
            if (b == 1) {
                if (cVar.Mm()) {
                    return new d.f(id, cVar.Ov(), cVar.getTotal());
                }
                return new h.f(id, (int) cVar.Ov(), (int) cVar.getTotal());
            }
            if (b == 2) {
                String filename = cVar.Mc() ? cVar.getFilename() : null;
                if (cVar.Mm()) {
                    return new d.c(id, aVar.Oa(), cVar.getTotal(), cVar.Ow(), filename);
                }
                return new h.c(id, aVar.Oa(), (int) cVar.getTotal(), cVar.Ow(), filename);
            }
            if (b == 3) {
                if (cVar.Mm()) {
                    return new d.g(id, cVar.Ov());
                }
                return new h.g(id, (int) cVar.Ov());
            }
            if (b != 5) {
                if (b == 6) {
                    return new MessageSnapshot.b(id);
                }
                String strC = com.kwad.framework.filedownloader.f.f.c("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                if (aVar.getException() != null) {
                    illegalStateException = new IllegalStateException(strC, aVar.getException());
                } else {
                    illegalStateException = new IllegalStateException(strC);
                }
                if (cVar.Mm()) {
                    return new d.C0559d(id, cVar.Ov(), illegalStateException);
                }
                return new h.d(id, (int) cVar.Ov(), illegalStateException);
            }
            if (cVar.Mm()) {
                dVar = new d.h(id, cVar.Ov(), aVar.getException(), aVar.Mk());
            } else {
                dVar = new h.C0560h(id, (int) cVar.Ov(), aVar.getException(), aVar.Mk());
            }
        } else if (cVar.Mm()) {
            dVar = new d.C0559d(id, cVar.Ov(), aVar.getException());
        } else {
            dVar = new h.d(id, (int) cVar.Ov(), aVar.getException());
        }
        return dVar;
    }
}
