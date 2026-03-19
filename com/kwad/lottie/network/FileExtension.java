package com.kwad.lottie.network;

import com.kwad.lottie.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public enum FileExtension {
    Json(".json"),
    Zip(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public final String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        c.df("Unable to find correct extension for " + str);
        return Json;
    }
}
