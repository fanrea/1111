package com.bytedance.sdk.component.an.b.d.d;

import com.fendasz.moku.planet.utils.thirdparty.codec.CharEncoding;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class c {
    static final Charset d = Charset.forName(CharEncoding.US_ASCII);
    static final Charset hc = Charset.forName("UTF-8");

    static void d(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                d(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }
}
