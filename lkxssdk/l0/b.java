package lkxssdk.l0;

import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b {
    public UUID a;

    public b() {
        if (this.a == null) {
            synchronized (b.class) {
                if (this.a == null) {
                    String strA = d.a().a(com.baidu.mobads.upgrade.remote.gray.c.l, null);
                    if (strA != null) {
                        this.a = UUID.fromString(strA);
                    } else {
                        this.a = UUID.randomUUID();
                        d.a().b(com.baidu.mobads.upgrade.remote.gray.c.l, this.a.toString());
                    }
                }
            }
        }
    }
}
