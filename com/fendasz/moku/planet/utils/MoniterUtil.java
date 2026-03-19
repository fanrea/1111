package com.fendasz.moku.planet.utils;

import android.app.ActivityManager;
import android.os.Debug;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MoniterUtil {
    private static final String TAG = "MOKU_Moniter_U=>";
    private static MoniterUtil moniterUtil;
    private static String[] known_qemu_drivers = {"goldfish"};
    private static String[] known_qemu_files = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props"};
    private static String tracerpid = "TracerPid";
    private static String[] known_qemu_pipes = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    private static String[] known_geny_files = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};

    private MoniterUtil() {
    }

    public static MoniterUtil getInstance() {
        MoniterUtil moniterUtil2;
        synchronized (MoniterUtil.class) {
            moniterUtil2 = new MoniterUtil();
            moniterUtil = moniterUtil2;
        }
        return moniterUtil2;
    }

    public boolean hasQEmuDrivers() throws IOException {
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i = 0; i < 2; i++) {
            File file = fileArr[i];
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String str = new String(bArr);
                for (String str2 : known_qemu_drivers) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasQEmuFiles() {
        for (String str : known_qemu_files) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasGenemytion() {
        for (String str : known_geny_files) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasQEMUPipes() {
        for (String str : known_qemu_pipes) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserAMonkey() {
        return ActivityManager.isUserAMonkey();
    }

    public boolean isBeingDebugged() {
        return Debug.isDebuggerConnected();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r1 = java.lang.Integer.decode(r1.substring(com.fendasz.moku.planet.utils.MoniterUtil.tracerpid.length() + 1).trim()).intValue();
        com.fendasz.moku.planet.utils.LogUtils.logD(com.fendasz.moku.planet.utils.MoniterUtil.TAG, "TPID==>" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0069, code lost:
    
        if (r1 <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006b, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006e, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int hasTracerPid() throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
            r4 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
        L15:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            if (r1 == 0) goto L7a
            int r3 = r1.length()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.String r4 = com.fendasz.moku.planet.utils.MoniterUtil.tracerpid     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            int r4 = r4.length()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            if (r3 <= r4) goto L15
            java.lang.String r3 = com.fendasz.moku.planet.utils.MoniterUtil.tracerpid     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            int r3 = r3.length()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.String r3 = r1.substring(r0, r3)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.String r4 = com.fendasz.moku.planet.utils.MoniterUtil.tracerpid     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            if (r3 == 0) goto L15
            java.lang.String r3 = com.fendasz.moku.planet.utils.MoniterUtil.tracerpid     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            int r3 = r3.length()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            int r3 = r3 + 1
            java.lang.String r1 = r1.substring(r3)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.Integer r1 = java.lang.Integer.decode(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.String r3 = "MOKU_Moniter_U=>"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            r4.<init>()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.String r5 = "TPID==>"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.StringBuilder r4 = r4.append(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            com.fendasz.moku.planet.utils.LogUtils.logD(r3, r4)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            if (r1 <= 0) goto L7a
            r2.close()
            return r1
        L6f:
            r1 = move-exception
            goto L77
        L71:
            r0 = move-exception
            goto L80
        L73:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L77:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L7e
        L7a:
            r2.close()
            return r0
        L7e:
            r0 = move-exception
            r1 = r2
        L80:
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.MoniterUtil.hasTracerPid():int");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x009c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:36:0x009c */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasAdbInEmulator() throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r5 = "/proc/net/tcp"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r4 = 1000(0x3e8, float:1.401E-42)
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2.readLine()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            r1.<init>()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
        L1d:
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            if (r3 == 0) goto L31
            java.lang.String r4 = "\\W+"
            java.lang.String[] r3 = r3.split(r4)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            com.fendasz.moku.planet.utils.MoniterUtil$Tcp r3 = com.fendasz.moku.planet.utils.MoniterUtil.Tcp.create(r3)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            r1.add(r3)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            goto L1d
        L31:
            r2.close()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            java.util.Iterator r3 = r1.iterator()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
        L38:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            r5 = 0
            r7 = -1
            if (r4 == 0) goto L50
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            com.fendasz.moku.planet.utils.MoniterUtil$Tcp r4 = (com.fendasz.moku.planet.utils.MoniterUtil.Tcp) r4     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            long r8 = r4.localIp     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 != 0) goto L38
            int r3 = r4.localPort     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            goto L51
        L50:
            r3 = r7
        L51:
            if (r3 == r7) goto L6f
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
        L57:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            if (r4 == 0) goto L6f
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            com.fendasz.moku.planet.utils.MoniterUtil$Tcp r4 = (com.fendasz.moku.planet.utils.MoniterUtil.Tcp) r4     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            long r7 = r4.localIp     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 == 0) goto L57
            int r4 = r4.localPort     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9b
            if (r4 != r3) goto L57
            r0 = 1
            goto L57
        L6f:
            r2.close()
            goto L9a
        L73:
            r1 = move-exception
            goto L7b
        L75:
            r0 = move-exception
            goto L9d
        L77:
            r2 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
        L7b:
            java.lang.String r3 = "MOKU_Moniter_U=>"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r4.<init>()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r5 = "hasAdbInEmulator error:"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9b
            android.util.Log.e(r3, r1)     // Catch: java.lang.Throwable -> L9b
            if (r2 == 0) goto L9a
            goto L6f
        L9a:
            return r0
        L9b:
            r0 = move-exception
            r1 = r2
        L9d:
            if (r1 == 0) goto La2
            r1.close()
        La2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.MoniterUtil.hasAdbInEmulator():boolean");
    }

    private static class Tcp {
        public int id;
        public long localIp;
        public int localPort;
        public int remoteIp;
        public int remotePort;

        static Tcp create(String[] strArr) {
            return new Tcp(strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], strArr[7], strArr[8], strArr[9], strArr[10], strArr[11], strArr[12], strArr[13], strArr[14]);
        }

        public Tcp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.id = Integer.parseInt(str, 16);
            this.localIp = Long.parseLong(str2, 16);
            this.localPort = Integer.parseInt(str3, 16);
        }
    }
}
