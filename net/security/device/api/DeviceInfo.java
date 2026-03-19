package net.security.device.api;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class DeviceInfo {
    public static String getIpAddressString() throws SocketException {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null) {
                    String name = networkInterfaceNextElement.getName();
                    if (name.isEmpty()) {
                        name = "Unknown";
                    }
                    name.replace('#', SignatureImpl.SEP);
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (inetAddressNextElement != null && (inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                            str = (((str + name) + "/") + inetAddressNextElement.getHostAddress()) + ",";
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return str.length() > 0 ? str.substring(0, str.length() - 1) : "0.0.0.0";
    }
}
