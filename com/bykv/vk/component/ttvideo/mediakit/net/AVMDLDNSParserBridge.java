package com.bykv.vk.component.ttvideo.mediakit.net;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
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
        int i = v2Usable ? parserResult(j, str, 2) : 0;
        return i <= 0 ? parserResult(j, str, 1) : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parserResult(long r12, java.lang.String r14, int r15) {
        /*
            r11 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 == 0) goto L8
            r12 = -1
            return r12
        L8:
            java.util.concurrent.locks.Lock r0 = r11.lock
            r0.lock()
            r11.handle = r12
            r12 = 0
            r13 = 1
            r0 = 0
            r11.host = r14     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            com.bykv.vk.component.ttvideo.mediakit.net.IPCache r1 = com.bykv.vk.component.ttvideo.mediakit.net.IPCache.getInstance()     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo r1 = r1.get(r14)     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            if (r1 == 0) goto L73
            java.lang.String r2 = r1.mIpList     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            r11.ipList = r2     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            java.lang.String r4 = "get result from cache expiredT:%d curT:%d "
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            long r6 = r1.mExpiredTime     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            r5[r0] = r6     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            r5[r13] = r6     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            long r4 = r1.mExpiredTime     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 > 0) goto L4b
            java.lang.String r2 = "cache has expired need try call but not need listener"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            java.lang.String.format(r2, r3)     // Catch: java.lang.Throwable -> L7c java.lang.UnsatisfiedLinkError -> L7e
            r2 = r13
            goto L4c
        L4b:
            r2 = r0
        L4c:
            long r3 = r11.handle     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L6f
            if (r15 != r13) goto L62
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            java.lang.String r6 = r11.ipList     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            long r7 = r1.mExpiredTime     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            r9 = 0
            r5 = r14
            _notifyParserResult(r3, r5, r6, r7, r9)     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            goto L6f
        L62:
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r13     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            java.lang.String r6 = r11.ipList     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            long r7 = r1.mExpiredTime     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            r9 = 0
            int r10 = r1.mType     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
            r5 = r14
            _notifyParserResultV2(r3, r5, r6, r7, r9, r10)     // Catch: java.lang.UnsatisfiedLinkError -> L71 java.lang.Throwable -> L7c
        L6f:
            r15 = r13
            goto L76
        L71:
            r15 = move-exception
            goto L80
        L73:
            r12 = r11
            r2 = r13
            r15 = r0
        L76:
            java.util.concurrent.locks.Lock r1 = r11.lock
            r1.unlock()
            goto L95
        L7c:
            r12 = move-exception
            goto Lb1
        L7e:
            r15 = move-exception
            r2 = r13
        L80:
            java.lang.String r1 = "AVMDLDNSParserBridge"
            java.lang.String r15 = r15.toString()     // Catch: java.lang.Throwable -> L7c
            com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog.e(r1, r15)     // Catch: java.lang.Throwable -> L7c
            boolean r15 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable     // Catch: java.lang.Throwable -> L7c
            if (r15 == 0) goto L8f
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.Throwable -> L7c
        L8f:
            java.util.concurrent.locks.Lock r15 = r11.lock
            r15.unlock()
            r15 = r0
        L95:
            if (r2 == 0) goto La7
            java.lang.Object[] r1 = new java.lang.Object[r13]
            r1[r0] = r12
            java.lang.String r2 = "call add host to parser listener:%s"
            java.lang.String.format(r2, r1)
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser r1 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.getInstance()
            r1.addHost(r14, r12)
        La7:
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r13[r0] = r12
            java.lang.String r12 = "****call start end, listener:%s"
            java.lang.String.format(r12, r13)
            return r15
        Lb1:
            java.util.concurrent.locks.Lock r13 = r11.lock
            r13.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(long, java.lang.String, int):int");
    }

    boolean isFinish() {
        return this.isFinish;
    }

    public String getResult() {
        this.lock.lock();
        try {
            return this.ipList;
        } finally {
            this.lock.unlock();
        }
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        if (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) {
            return null;
        }
        return backUpIp.mIpList;
    }

    public void release() {
        String.format("----start release:%s", this);
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            String.format("remove host:%s", this.host);
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            String.format("****end call release:%s", this);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3, int i2) {
        if (!this.isFinish && v2Usable) {
            parserResult(i, str, str2, j, str3, i2, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i, str, str2, j, str3, i2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parserResult(int r17, java.lang.String r18, java.lang.String r19, long r20, java.lang.String r22, int r23, int r24) {
        /*
            r16 = this;
            r1 = r16
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.lock()
            r0 = 0
            boolean r2 = r1.isFinish     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L8f
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String r6 = "receive completion code:%d result:%s type:%d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r0] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            boolean r7 = android.text.TextUtils.isEmpty(r19)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            if (r7 == 0) goto L24
            java.lang.String r7 = "null"
            goto L26
        L24:
            r7 = r19
        L26:
            r3[r5] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r7 = java.lang.Integer.valueOf(r23)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r4] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String.format(r2, r6, r3)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            boolean r2 = android.text.TextUtils.isEmpty(r19)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r6 = 0
            if (r2 == 0) goto L65
            r2 = 5
            int r2 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.getIntValue(r2)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            if (r2 != r5) goto L65
            com.bykv.vk.component.ttvideo.mediakit.net.IPCache r2 = com.bykv.vk.component.ttvideo.mediakit.net.IPCache.getInstance()     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3 = r18
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo r2 = r2.getBackUpIp(r3)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            if (r2 == 0) goto L67
            java.lang.String r8 = r2.mIpList     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            int r2 = r2.mType     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.util.Locale r9 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String r10 = "get backup ip, result:%s type:%d"
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r11[r0] = r8     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r11[r5] = r12     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String.format(r9, r10, r11)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r15 = r2
            r12 = r6
            r11 = r8
            goto L6d
        L65:
            r3 = r18
        L67:
            r11 = r19
            r12 = r20
            r15 = r23
        L6d:
            r1.ipList = r11     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r1.isFinish = r5     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            long r8 = r1.handle     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto La6
            r2 = r24
            if (r2 != r4) goto L85
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r5     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r10 = r18
            r14 = r22
            _notifyParserResultV2(r8, r10, r11, r12, r14, r15)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            goto La6
        L85:
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r10 = r18
            r14 = r22
            _notifyParserResult(r8, r10, r11, r12, r14)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            goto La6
        L8f:
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String r6 = "has finished not nedd cur completion code:%d result:%s expiredTime:%d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r0] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r5] = r19     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Long r5 = java.lang.Long.valueOf(r20)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r4] = r5     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String.format(r2, r6, r3)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
        La6:
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.unlock()
            return
        Lac:
            r0 = move-exception
            goto Lb7
        Lae:
            boolean r2 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable     // Catch: java.lang.Throwable -> Lac
            if (r2 == 0) goto Lb4
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.Throwable -> Lac
        Lb4:
            r1.isFinish = r0     // Catch: java.lang.Throwable -> Lac
            goto La6
        Lb7:
            java.util.concurrent.locks.Lock r2 = r1.lock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(int, java.lang.String, java.lang.String, long, java.lang.String, int, int):void");
    }
}
