package com.kwad.components.offline.api.core.api;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getFileSha256(File file);

    String getMD5(String str);

    String getResponseData(String str);

    String getSha256(String str);
}
