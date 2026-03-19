package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetConfig;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import okhttp3.internal.http2.Header;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dv {
    private static final String d = jh.e;
    private TnetQuicRequest a;
    private fv b;
    private String c;

    /* compiled from: A */
    class a extends TnetQuicRequest.Callback {
        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onClose(int i, String str) throws Exception {
            String unused = dv.d;
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onHeaderRecv(String str) throws Exception {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onNetworkLinked() throws Exception {
        }

        a() {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onConnect(int i) throws Exception {
            dv.this.b = null;
            dv.this.c = "HEAD";
            dv.this.a.addHeaders(Header.TARGET_METHOD_UTF8, "HEAD");
            dv.this.a.sendRequest(new byte[0], 0, true);
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onDataRecv(byte[] bArr) throws Exception {
            if (dv.this.b == null) {
                dv.this.b = new fv();
            }
            try {
                dv.this.b.a(bArr);
            } catch (Exception e) {
                String unused = dv.d;
                e.toString();
            }
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onComplete(int i) throws Exception {
            String unused = dv.d;
            if (i == 0 && TextUtils.equals("HEAD", dv.this.c)) {
                dv.this.b.f();
                if (dv.this.b.a() == 200) {
                    String unused2 = dv.d;
                }
            }
        }
    }

    public void b() {
        this.a = new TnetQuicRequest(new a(), new TnetConfig.Builder().setConnectTimeoutMillis(4000).setTotalTimeoutMillis(8000).build(), 0);
        try {
            URL url = new URL("https://mi.gdt.qq.com/gdt_mview.fcg");
            InetAddress inetAddressA = a(url.getHost());
            if (inetAddressA != null) {
                this.a.connect(url.toString(), inetAddressA.getHostAddress());
            }
        } catch (Exception e) {
            e.toString();
        }
    }

    private InetAddress a(String str) throws UnknownHostException {
        InetAddress inetAddress;
        InetAddress[] allByName = InetAddress.getAllByName(str);
        int length = allByName.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                inetAddress = null;
                break;
            }
            inetAddress = allByName[i];
            if (inetAddress instanceof Inet4Address) {
                break;
            }
            i++;
        }
        return (inetAddress != null || allByName.length <= 0) ? inetAddress : allByName[0];
    }
}
