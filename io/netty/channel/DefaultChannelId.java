package io.netty.channel;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadLocalRandom;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class DefaultChannelId implements ChannelId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] MACHINE_ID;
    private static final int MACHINE_ID_LEN = 8;
    private static final int MAX_PROCESS_ID = 4194304;
    private static final int PROCESS_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int RANDOM_LEN = 4;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final long serialVersionUID = 3884076183504074063L;
    private final byte[] data = new byte[28];
    private int hashCode;
    private transient String longValue;
    private transient String shortValue;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelId.class);
    private static final Pattern MACHINE_ID_PATTERN = Pattern.compile("^(?:[0-9a-fA-F][:-]?){6,8}$");
    private static final AtomicInteger nextSequence = new AtomicInteger();

    @Override // java.lang.Comparable
    public final int compareTo(ChannelId channelId) {
        return 0;
    }

    DefaultChannelId() {
    }

    static {
        int i;
        String str = SystemPropertyUtil.get("io.netty.processId");
        int iDefaultProcessId = -1;
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i < 0 || i > 4194304) {
                logger.warn("-Dio.netty.processId: {} (malformed)", str);
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i));
                }
                iDefaultProcessId = i;
            }
        }
        if (iDefaultProcessId < 0) {
            iDefaultProcessId = defaultProcessId();
            if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(iDefaultProcessId));
            }
        }
        PROCESS_ID = iDefaultProcessId;
        byte[] bArrDefaultMachineId = null;
        String str2 = SystemPropertyUtil.get("io.netty.machineId");
        if (str2 != null) {
            if (MACHINE_ID_PATTERN.matcher(str2).matches()) {
                bArrDefaultMachineId = parseMachineId(str2);
                logger.debug("-Dio.netty.machineId: {} (user-set)", str2);
            } else {
                logger.warn("-Dio.netty.machineId: {} (malformed)", str2);
            }
        }
        if (bArrDefaultMachineId == null) {
            bArrDefaultMachineId = defaultMachineId();
            if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.machineId: {} (auto-detected)", formatAddress(bArrDefaultMachineId));
            }
        }
        MACHINE_ID = bArrDefaultMachineId;
    }

    static ChannelId newInstance() {
        DefaultChannelId defaultChannelId = new DefaultChannelId();
        defaultChannelId.init();
        return defaultChannelId;
    }

    private static byte[] parseMachineId(String str) {
        String strReplaceAll = str.replaceAll("[:-]", "");
        byte[] bArr = new byte[8];
        int i = 0;
        while (i < strReplaceAll.length()) {
            int i2 = i + 2;
            bArr[i] = (byte) Integer.parseInt(strReplaceAll.substring(i, i2), 16);
            i = i2;
        }
        return bArr;
    }

    private static byte[] defaultMachineId() throws Throwable {
        InetAddress byAddress;
        int iCompareAddresses;
        byte[] bArr = {-1};
        try {
            byAddress = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        } catch (UnknownHostException e) {
            PlatformDependent.throwException(e);
            byAddress = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                if (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        linkedHashMap.put(networkInterfaceNextElement, inetAddressNextElement);
                    }
                }
            }
        } catch (SocketException e2) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e2);
        }
        InetAddress inetAddress = byAddress;
        byte[] bArr2 = bArr;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            NetworkInterface networkInterface = (NetworkInterface) entry.getKey();
            InetAddress inetAddress2 = (InetAddress) entry.getValue();
            if (!networkInterface.isVirtual()) {
                try {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    int iCompareAddresses2 = compareAddresses(bArr2, hardwareAddress);
                    if (iCompareAddresses2 < 0 || (iCompareAddresses2 == 0 && ((iCompareAddresses = compareAddresses(inetAddress, inetAddress2)) < 0 || (iCompareAddresses == 0 && bArr2.length < hardwareAddress.length)))) {
                        inetAddress = inetAddress2;
                        bArr2 = hardwareAddress;
                    }
                } catch (SocketException e3) {
                    logger.debug("Failed to get the hardware address of a network interface: {}", networkInterface, e3);
                }
            }
        }
        if (bArr2 == bArr) {
            bArr2 = new byte[8];
            ThreadLocalRandom.current().nextBytes(bArr2);
            logger.warn("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", formatAddress(bArr2));
        }
        if (bArr2.length == 6) {
            byte[] bArr3 = new byte[8];
            System.arraycopy(bArr2, 0, bArr3, 0, 3);
            bArr3[3] = -1;
            bArr3[4] = -2;
            System.arraycopy(bArr2, 3, bArr3, 5, 3);
            return bArr3;
        }
        return Arrays.copyOf(bArr2, 8);
    }

    private static int compareAddresses(byte[] bArr, byte[] bArr2) {
        boolean z;
        if (bArr2 == null || bArr2.length < 6) {
            return 1;
        }
        int length = bArr2.length;
        int i = 0;
        while (true) {
            if (i < length) {
                byte b = bArr2[i];
                if (b != 0 && b != 1) {
                    z = false;
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (!z && (bArr2[0] & 1) == 0) {
            return (bArr[0] & 2) == 0 ? (bArr2[0] & 2) == 0 ? 0 : 1 : (bArr2[0] & 2) == 0 ? -1 : 0;
        }
        return 1;
    }

    private static int compareAddresses(InetAddress inetAddress, InetAddress inetAddress2) {
        return scoreAddress(inetAddress) - scoreAddress(inetAddress2);
    }

    private static int scoreAddress(InetAddress inetAddress) {
        if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
            return 0;
        }
        if (inetAddress.isMulticastAddress()) {
            return 1;
        }
        if (inetAddress.isLinkLocalAddress()) {
            return 2;
        }
        return inetAddress.isSiteLocalAddress() ? 3 : 4;
    }

    private static String formatAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder(24);
        for (byte b : bArr) {
            sb.append(String.format("%02x:", Integer.valueOf(b & 255)));
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static int defaultProcessId() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String string;
        int i;
        ClassLoader systemClassLoader = PlatformDependent.getSystemClassLoader();
        try {
            Class<?> cls = Class.forName("java.lang.management.ManagementFactory", true, systemClassLoader);
            Class<?> cls2 = Class.forName("java.lang.management.RuntimeMXBean", true, systemClassLoader);
            string = (String) cls2.getDeclaredMethod("getName", EmptyArrays.EMPTY_CLASSES).invoke(cls.getMethod("getRuntimeMXBean", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS), EmptyArrays.EMPTY_OBJECTS);
        } catch (Exception e) {
            logger.debug("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", (Throwable) e);
            try {
                string = Class.forName("android.os.Process", true, systemClassLoader).getMethod("myPid", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS).toString();
            } catch (Exception e2) {
                logger.debug("Could not invoke Process.myPid(); not Android?", (Throwable) e2);
                string = "";
            }
        }
        int iIndexOf = string.indexOf(64);
        if (iIndexOf >= 0) {
            string = string.substring(0, iIndexOf);
        }
        try {
            i = Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i >= 0 && i <= 4194304) {
            return i;
        }
        int iNextInt = ThreadLocalRandom.current().nextInt(4194305);
        logger.warn("Failed to find the current process ID from '{}'; using a random value: {}", string, Integer.valueOf(iNextInt));
        return iNextInt;
    }

    private void init() {
        System.arraycopy(MACHINE_ID, 0, this.data, 0, 8);
        int iWriteLong = writeLong(writeInt(writeInt(8, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis());
        int iNextInt = ThreadLocalRandom.current().nextInt();
        this.hashCode = iNextInt;
        writeInt(iWriteLong, iNextInt);
    }

    private int writeInt(int i, int i2) {
        byte[] bArr = this.data;
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        return i6;
    }

    private int writeLong(int i, long j) {
        byte[] bArr = this.data;
        int i2 = i + 1;
        bArr[i] = (byte) (j >>> 56);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >>> 48);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >>> 40);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >>> 32);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >>> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >>> 16);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j >>> 8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) j;
        return i9;
    }

    @Override // io.netty.channel.ChannelId
    public final String asShortText() {
        String str = this.shortValue;
        if (str != null) {
            return str;
        }
        String strHexDump = ByteBufUtil.hexDump(this.data, 24, 4);
        this.shortValue = strHexDump;
        return strHexDump;
    }

    @Override // io.netty.channel.ChannelId
    public final String asLongText() {
        String str = this.longValue;
        if (str != null) {
            return str;
        }
        String strNewLongValue = newLongValue();
        this.longValue = strNewLongValue;
        return strNewLongValue;
    }

    private String newLongValue() {
        StringBuilder sb = new StringBuilder((this.data.length * 2) + 5);
        appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, 0, 8), 4), 4), 8), 4);
        return sb.substring(0, sb.length() - 1);
    }

    private int appendHexDumpField(StringBuilder sb, int i, int i2) {
        sb.append(ByteBufUtil.hexDump(this.data, i, i2));
        sb.append(SignatureImpl.SEP);
        return i + i2;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DefaultChannelId) {
            return Arrays.equals(this.data, ((DefaultChannelId) obj).data);
        }
        return false;
    }

    public final String toString() {
        return asShortText();
    }
}
