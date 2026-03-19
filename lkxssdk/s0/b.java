package lkxssdk.s0;

import com.lingku.xuanshang.xutils.image.ImageOptions;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class b {
    public final String a;
    public final ImageOptions b;

    public b(String str, ImageOptions imageOptions) {
        this.a = str;
        this.b = imageOptions;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a.equals(bVar.a)) {
            return this.b.equals(bVar.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return this.a + this.b.toString();
    }
}
