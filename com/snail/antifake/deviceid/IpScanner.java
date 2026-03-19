package com.snail.antifake.deviceid;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.m.u.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class IpScanner {
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public interface OnScanListener {
        void scan(Map<String, String> map);
    }

    public void startScan(final OnScanListener onScanListener) throws SocketException {
        new ArrayList();
        new HashMap();
        String hostIP = getHostIP();
        if (TextUtils.isEmpty(hostIP)) {
            return;
        }
        final String strSubstring = hostIP.substring(0, hostIP.lastIndexOf(".") + 1);
        new Thread(new Runnable() { // from class: com.snail.antifake.deviceid.IpScanner.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[0], 0, 0);
                try {
                    DatagramSocket datagramSocket = new DatagramSocket();
                    int i = 2;
                    while (i < 255) {
                        Log.e("kalshen", "run: udp-" + strSubstring + i);
                        datagramPacket.setAddress(InetAddress.getByName(strSubstring + String.valueOf(i)));
                        datagramSocket.send(datagramPacket);
                        i++;
                        if (i == 125) {
                            datagramSocket.close();
                            datagramSocket = new DatagramSocket();
                        }
                    }
                    datagramSocket.close();
                    IpScanner.this.execCatForArp(onScanListener);
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execCatForArp(final OnScanListener onScanListener) {
        new Thread(new Runnable() { // from class: com.snail.antifake.deviceid.IpScanner.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                try {
                    final HashMap map = new HashMap();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            IpScanner.this.mHandler.post(new Runnable() { // from class: com.snail.antifake.deviceid.IpScanner.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    onScanListener.scan(map);
                                }
                            });
                            return;
                        }
                        Log.e("kalshen", "run: " + line);
                        if (!line.contains(c.a) && !line.contains("IP")) {
                            String[] strArrSplit = line.split("\\s+");
                            map.put(strArrSplit[3], strArrSplit[0]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String getHostIP() throws SocketException {
        String hostAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!(inetAddressNextElement instanceof Inet6Address) && !"127.0.0.1".equals(inetAddressNextElement.getHostAddress())) {
                            hostAddress = inetAddressNextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            Log.i("kalshen", "SocketException");
            e.printStackTrace();
        }
        return hostAddress;
    }
}
