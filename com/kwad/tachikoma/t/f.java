package com.kwad.tachikoma.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    public static <T> T b(T t, String str) {
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("Argument cannot be null " + str);
            if (com.kwad.tachikoma.e.isDebug()) {
                throw nullPointerException;
            }
            com.kwad.tachikoma.e.log().e("Preconditions", "", nullPointerException);
        }
        return t;
    }
}
