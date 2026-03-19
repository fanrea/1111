package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.n9;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p9 extends n9 {
    public p9(String[] strArr, int i, int i2, ExecutorService executorService) {
        super(strArr, i, i2, executorService);
    }

    @Override // com.qq.e.comm.plugin.n9
    o9 a(n9.b bVar, String str, String str2, int i) throws Exception {
        DatagramSocket datagramSocket;
        m9 m9Var = new m9((short) (Math.random() * 65535.0d), i, str2);
        byte[] bArrB = m9Var.b();
        InetAddress byName = InetAddress.getByName(str);
        try {
            datagramSocket = new DatagramSocket();
        } catch (Throwable th) {
            th = th;
            datagramSocket = null;
        }
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArrB, bArrB.length, byName, 53);
            datagramSocket.setSoTimeout(this.d * 1000);
            bVar.a(new a(datagramSocket));
            datagramSocket.send(datagramPacket);
            DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1500], 1500);
            datagramSocket.receive(datagramPacket2);
            o9 o9Var = new o9(str, 2, m9Var, datagramPacket2.getData());
            datagramSocket.close();
            return o9Var;
        } catch (Throwable th2) {
            th = th2;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            throw th;
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ DatagramSocket a;

        a(DatagramSocket datagramSocket) {
            this.a = datagramSocket;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.close();
            } catch (Exception unused) {
            }
        }
    }
}
