package com.sigmob.sdk.archives;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    private static final d a = new d();

    private static void a() {
        System.out.println("Parameters: archive-name [archive-type]");
    }

    public static void a(String[] args) throws Exception {
        if (args.length == 0) {
            a();
            return;
        }
        System.out.println("Analysing " + args[0]);
        File file = new File(args[0]);
        if (!file.isFile()) {
            System.err.println(file + " doesn't exist or is a directory");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        c cVarA = args.length > 1 ? a.a(args[1], bufferedInputStream) : a.a(bufferedInputStream);
        System.out.println("Created " + cVarA.toString());
        while (true) {
            a aVarA = cVarA.a();
            if (aVarA == null) {
                cVarA.close();
                bufferedInputStream.close();
                return;
            }
            System.out.println(aVarA.a());
        }
    }
}
