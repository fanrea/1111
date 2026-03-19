package com.qq.e.comm.plugin;

import com.kuaishou.socket.nano.SocketMessages;
import java.io.File;
import java.security.PublicKey;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y30 {
    private static final byte[] c = {82, com.sigmob.sdk.archives.tar.e.Q, 65, 47, 69, 67, 66, 47, 80, 75, 67, com.sigmob.sdk.archives.tar.e.Q, com.sigmob.sdk.archives.tar.e.I, 80, 97, 100, 100, 105, 110, com.sigmob.sdk.archives.tar.e.T};
    private PublicKey a;
    private final boolean b;

    /* compiled from: A */
    private static final class b {
        public static final y30 a = new y30();
    }

    public static y30 a() {
        return (y30) pro.getobjresult(SocketMessages.PayloadType.SC_AUTHOR_CHAT_END, 1, new Object[0]);
    }

    private String a(String str) {
        return (String) pro.getobjresult(SocketMessages.PayloadType.SC_AUTHOR_CHAT_REJECT, 0, this, str);
    }

    private PublicKey b() throws Exception {
        return (PublicKey) pro.getobjresult(484, 0, this);
    }

    public boolean a(String str, File file) {
        return pro.getZresult(485, 0, this, str, file);
    }

    public boolean a(String str, String str2) {
        return pro.getZresult(486, 0, this, str, str2);
    }

    public boolean b(String str, String str2) {
        return pro.getZresult(487, 0, this, str, str2);
    }

    private y30() {
        boolean z;
        try {
            this.a = b();
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.b = z;
    }
}
