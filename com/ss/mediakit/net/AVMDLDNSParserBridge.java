package com.ss.mediakit.net;

import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j, String str, String str2, long j2, String str3);

    private static native void _notifyParserResultV2(long j, String str, String str2, long j2, String str3, int i);

    public int start(long j, String str) {
        int i = v2Usable ? parserResult(j, str, 2, -1) : 0;
        return i <= 0 ? parserResult(j, str, 1, -1) : i;
    }

    public int start(long j, String str, int i) {
        int i2 = v2Usable ? parserResult(j, str, 2, i) : 0;
        return i2 <= 0 ? parserResult(j, str, 1, i) : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ac A[Catch: UnsatisfiedLinkError -> 0x0101, all -> 0x0112, TryCatch #0 {UnsatisfiedLinkError -> 0x0101, blocks: (B:19:0x00a4, B:21:0x00ac, B:23:0x00e0, B:24:0x00ef), top: B:46:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parserResult(long r18, java.lang.String r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.mediakit.net.AVMDLDNSParserBridge.parserResult(long, java.lang.String, int, int):int");
    }

    public void triggerRefresh(long j, String str, int i) {
        AVMDLDNSParser.getInstance().postDNSInfoRefreshMsg(str, i);
    }

    boolean isFinish() {
        return this.isFinish;
    }

    public String getResult() {
        this.lock.lock();
        try {
            String str = this.ipList;
            this.lock.unlock();
            AVMDLLog.d(TAG, "****get result:" + str);
            return str;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        String str2 = (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) ? null : backUpIp.mIpList;
        AVMDLLog.d(TAG, "****get backup ip result:" + str2);
        return str2;
    }

    public void release() {
        AVMDLLog.d(TAG, String.format(Locale.US, "----start release:%s", this));
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.US, "remove host:%s", this.host));
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            AVMDLLog.d(TAG, String.format(Locale.US, "****end call release:%s", this));
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // com.ss.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3, int i2) {
        if (!this.isFinish && v2Usable) {
            parserResult(i, str, str2, j, str3, i2, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i, str, str2, j, str3, i2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parserResult(int r18, java.lang.String r19, java.lang.String r20, long r21, java.lang.String r23, int r24, int r25) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "AVMDLDNSParserBridge"
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.lock()
            r3 = 0
            boolean r0 = r1.isFinish     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 != 0) goto L9f
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.String r7 = "receive completion code:%d result:%s type:%d"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.Integer r8 = java.lang.Integer.valueOf(r18)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r4[r3] = r8     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            boolean r8 = android.text.TextUtils.isEmpty(r20)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            if (r8 == 0) goto L26
            java.lang.String r8 = "null"
            goto L28
        L26:
            r8 = r20
        L28:
            r4[r6] = r8     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.Integer r8 = java.lang.Integer.valueOf(r24)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r4[r5] = r8     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.String r0 = java.lang.String.format(r0, r7, r4)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r0)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            boolean r0 = android.text.TextUtils.isEmpty(r20)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r7 = 0
            if (r0 == 0) goto L75
            r0 = 5
            int r0 = com.ss.mediakit.net.AVMDLDNSParser.getIntValue(r0)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            if (r0 != r6) goto L75
            java.lang.String r0 = "pare result is null, try get backupip"
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r0)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            com.ss.mediakit.net.IPCache r0 = com.ss.mediakit.net.IPCache.getInstance()     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r4 = r19
            com.ss.mediakit.net.AVMDLDNSInfo r0 = r0.getBackUpIp(r4)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            if (r0 == 0) goto L77
            java.lang.String r9 = r0.mIpList     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            int r0 = r0.mType     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.util.Locale r10 = java.util.Locale.US     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.String r11 = "get backup ip, result:%s type:%d"
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r12[r3] = r9     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r12[r6] = r13     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.String r10 = java.lang.String.format(r10, r11, r12)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r10)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r16 = r0
            r13 = r7
            r12 = r9
            goto L7d
        L75:
            r4 = r19
        L77:
            r12 = r20
            r13 = r21
            r16 = r24
        L7d:
            r1.ipList = r12     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r1.isFinish = r6     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            long r9 = r1.handle     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 == 0) goto Lcd
            r0 = r25
            if (r0 != r5) goto L95
            com.ss.mediakit.net.AVMDLDNSParserBridge.v2Usable = r6     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r11 = r19
            r15 = r23
            _notifyParserResultV2(r9, r11, r12, r13, r15, r16)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            goto Lcd
        L95:
            com.ss.mediakit.net.AVMDLDNSParserBridge.v2Usable = r3     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r11 = r19
            r15 = r23
            _notifyParserResult(r9, r11, r12, r13, r15)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            goto Lcd
        L9f:
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.String r7 = "has finished not nedd cur completion code:%d result:%s expiredTime:%d"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.Integer r8 = java.lang.Integer.valueOf(r18)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r4[r3] = r8     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r4[r6] = r20     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.Long r6 = java.lang.Long.valueOf(r21)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            r4[r5] = r6     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            java.lang.String r0 = java.lang.String.format(r0, r7, r4)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r0)     // Catch: java.lang.Throwable -> Lbb java.lang.UnsatisfiedLinkError -> Lbd
            goto Lcd
        Lbb:
            r0 = move-exception
            goto Ld3
        Lbd:
            r0 = move-exception
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lbb
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r0)     // Catch: java.lang.Throwable -> Lbb
            boolean r0 = com.ss.mediakit.net.AVMDLDNSParserBridge.v2Usable     // Catch: java.lang.Throwable -> Lbb
            if (r0 == 0) goto Lcb
            com.ss.mediakit.net.AVMDLDNSParserBridge.v2Usable = r3     // Catch: java.lang.Throwable -> Lbb
        Lcb:
            r1.isFinish = r3     // Catch: java.lang.Throwable -> Lbb
        Lcd:
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.unlock()
            return
        Ld3:
            java.util.concurrent.locks.Lock r2 = r1.lock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.mediakit.net.AVMDLDNSParserBridge.parserResult(int, java.lang.String, java.lang.String, long, java.lang.String, int, int):void");
    }
}
