package com.apm.applog.network;

import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface INetworkClient {
    NetworkResponse get(String str, Map<String, String> map) throws Exception;

    NetworkResponse post(String str, byte[] bArr, Map<String, String> map) throws Exception;
}
