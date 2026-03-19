package ca.da.ca.ja;

import com.apm.applog.network.INetworkClient;
import com.apm.applog.network.NetworkResponse;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DefaultClient.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements INetworkClient {
    @Override // com.apm.applog.network.INetworkClient
    public NetworkResponse get(String str, Map<String, String> map) throws Exception {
        return null;
    }

    @Override // com.apm.applog.network.INetworkClient
    public NetworkResponse post(String str, byte[] bArr, Map<String, String> map) throws Exception {
        return new NetworkResponse(200, ca.da.ca.ba.a.a(1, str, (HashMap) map, bArr).getBytes());
    }
}
