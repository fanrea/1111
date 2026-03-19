package com.ss.mediakit.net;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLHostProcessor {
    private static final int BACKUP_DNS = 1;
    private static final int MAIN_DNS = 0;
    public static final int STATE_IS_IDLE = 0;
    public static final int STATE_IS_PARSE_END_ERROR = 2;
    public static final int STATE_IS_PARSE_END_SUC = 3;
    public static final int STATE_IS_WAIT_RESULT = 1;
    private static final String TAG = "AVMDLHostProcessor";
    private int mBackUpDelayedTime;
    private int mBackUpDelayedTimeForExpiredCache;
    private int mBackUpType;
    private int mEnableParallel;
    private Handler mHandler;
    public String mHost;
    public HashMap<AVMDLDNSParserListener, Integer> mListeners;
    private int mMainType;
    private BaseDNS[] mParsers;
    private int[] mStates;

    public AVMDLHostProcessor(String str, Handler handler, int i, int i2, int i3, int i4) {
        this.mMainType = i;
        this.mBackUpType = i2;
        this.mHandler = handler;
        this.mHost = str;
        this.mBackUpDelayedTime = i3;
        this.mEnableParallel = i4;
        this.mStates = new int[2];
        this.mParsers = new BaseDNS[2];
        for (int i5 = 0; i5 < 2; i5++) {
            this.mParsers[i5] = null;
        }
        for (int i6 = 0; i6 < 2; i6++) {
            this.mStates[i6] = 0;
        }
        this.mListeners = new HashMap<>();
    }

    public AVMDLHostProcessor(String str, Handler handler, int i, int i2, int i3, int i4, int i5) {
        this.mMainType = i;
        this.mBackUpType = i2;
        this.mHandler = handler;
        this.mHost = str;
        this.mBackUpDelayedTime = i3;
        this.mBackUpDelayedTimeForExpiredCache = i5;
        this.mEnableParallel = i4;
        this.mStates = new int[2];
        this.mParsers = new BaseDNS[2];
        for (int i6 = 0; i6 < 2; i6++) {
            this.mParsers[i6] = null;
        }
        for (int i7 = 0; i7 < 2; i7++) {
            this.mStates[i7] = 0;
        }
        this.mListeners = new HashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void processMsg(int r9, com.ss.mediakit.net.AVMDLDNSInfo r10) {
        /*
            r8 = this;
            java.util.Locale r0 = java.util.Locale.US
            r1 = 3
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = r10.mHost
            r5 = 1
            r2[r5] = r3
            r3 = 2
            r2[r3] = r10
            java.lang.String r6 = "----processor pro msg what:%d host:%s info:%s"
            java.lang.String r0 = java.lang.String.format(r0, r6, r2)
            java.lang.String r2 = "AVMDLHostProcessor"
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r0)
            r0 = 5
            if (r9 == r0) goto L4d
            r0 = 6
            if (r9 == r0) goto L2a
            r0 = 9
            if (r9 == r0) goto L4d
            goto L63
        L2a:
            int[] r0 = r8.mStates
            r6 = r0[r4]
            if (r6 == r5) goto L38
            if (r6 == r3) goto L38
            if (r6 == r1) goto L38
            int r6 = r8.mEnableParallel
            if (r6 <= 0) goto L63
        L38:
            r0 = r0[r5]
            if (r0 != 0) goto L63
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.String r7 = "main dns is not end or enable parrallel and backup dns is idle call backup dns"
            java.lang.String r0 = java.lang.String.format(r0, r7, r6)
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r0)
            r8.doParseInternal(r9, r10)
            goto L63
        L4d:
            int[] r0 = r8.mStates
            r0 = r0[r4]
            if (r0 != 0) goto L63
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.String r7 = "main dns is idle call main dns"
            java.lang.String r0 = java.lang.String.format(r0, r7, r6)
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r0)
            r8.doParseInternal(r9, r10)
        L63:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1[r4] = r9
            java.lang.String r9 = r10.mHost
            r1[r5] = r9
            r1[r3] = r10
            java.lang.String r9 = "****end processor pro msg what:%d host:%s info:%s"
            java.lang.String r9 = java.lang.String.format(r0, r9, r1)
            com.ss.mediakit.medialoader.AVMDLLog.d(r2, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.mediakit.net.AVMDLHostProcessor.processMsg(int, com.ss.mediakit.net.AVMDLDNSInfo):void");
    }

    public boolean isValidSourceId(String str) {
        if (TextUtils.isEmpty(str)) {
            AVMDLLog.d(TAG, String.format(Locale.US, "id: %s is empty", str));
            return false;
        }
        for (int i = 0; i < 2; i++) {
            BaseDNS baseDNS = this.mParsers[i];
            if (baseDNS != null && str.equals(baseDNS.mId)) {
                AVMDLLog.d(TAG, String.format(Locale.US, "id: %s is valid index: %d", str, Integer.valueOf(i)));
                return true;
            }
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "id: %s is valid", str));
        return false;
    }

    public void processResult(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.d(TAG, String.format(Locale.US, "----process result what:%d id:%s host:%s", Integer.valueOf(i), aVMDLDNSInfo.mId, aVMDLDNSInfo.mHost));
        String str = ((i == 2 || i == 3) && aVMDLDNSInfo != null) ? aVMDLDNSInfo.mId : null;
        if (TextUtils.isEmpty(str)) {
            AVMDLLog.d(TAG, String.format(Locale.US, "****process result err id is empty", new Object[0]));
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            BaseDNS baseDNS = this.mParsers[i2];
            if (baseDNS == null || !str.equals(baseDNS.mId)) {
                i2++;
            } else {
                this.mParsers[i2].close();
                this.mParsers[i2] = null;
                if (i == 3) {
                    this.mStates[i2] = 3;
                } else if (i == 2) {
                    this.mStates[i2] = 2;
                }
                AVMDLLog.d(TAG, String.format(Locale.US, "****process result parser index:%d is end, be close", Integer.valueOf(i2)));
            }
        }
        if (i2 == 0 && i == 2) {
            AVMDLLog.d(TAG, String.format(Locale.US, "mian dns parse error, try back up dns", new Object[0]));
            processMsg(6, new AVMDLDNSInfo(this.mBackUpType, aVMDLDNSInfo.mHost, (String) null, 0L, (String) null));
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "****end process result what:%d id:%s host:%s", Integer.valueOf(i), aVMDLDNSInfo.mId, aVMDLDNSInfo.mHost));
    }

    public boolean isEnd() {
        int i;
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.mParsers[i2] != null && (i = this.mStates[i2]) != 3 && i != 2) {
                return false;
            }
        }
        AVMDLLog.d(TAG, "all dns parse is end");
        return true;
    }

    private void doParseInternal(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.d(TAG, String.format(Locale.US, "----do parse internal what:%d info:%s", Integer.valueOf(i), aVMDLDNSInfo));
        if (aVMDLDNSInfo == null) {
            return;
        }
        if ((i == 5 || i == 9) && this.mParsers[0] == null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "create main dns type:%d host:%s", Integer.valueOf(this.mMainType), aVMDLDNSInfo.mHost));
            this.mStates[0] = 1;
            this.mParsers[0] = createDNSParser(aVMDLDNSInfo.mHost, this.mMainType, 0);
            this.mParsers[0].start();
            if (AVMDLDNSParser.mGloabalDisableParallelForExpiredCache <= 0) {
                Message message = new Message();
                message.what = 6;
                message.obj = aVMDLDNSInfo;
                if (this.mBackUpDelayedTime > 0 || this.mEnableParallel > 0) {
                    AVMDLLog.d(TAG, String.format(Locale.US, "BackUpDelayedTime:%d enableparallel:%d send backup delay first", Integer.valueOf(this.mBackUpDelayedTime), Integer.valueOf(this.mEnableParallel)));
                    this.mHandler.sendMessageDelayed(message, this.mBackUpDelayedTime * 1000);
                }
            } else if (i == 9) {
                Message message2 = new Message();
                message2.what = 6;
                message2.obj = aVMDLDNSInfo;
                if (this.mBackUpDelayedTimeForExpiredCache > 0) {
                    AVMDLLog.d(TAG, String.format(Locale.US, "mBackUpDelayedTimeForExpiredCache:%d send backup delay first", Integer.valueOf(this.mBackUpDelayedTimeForExpiredCache)));
                    this.mHandler.sendMessageDelayed(message2, this.mBackUpDelayedTimeForExpiredCache * 1000);
                }
            } else {
                Message message3 = new Message();
                message3.what = 6;
                message3.obj = aVMDLDNSInfo;
                if (this.mBackUpDelayedTime > 0 || this.mEnableParallel > 0) {
                    AVMDLLog.d(TAG, String.format(Locale.US, "BackUpDelayedTime:%d enableparallel:%d send backup delay first", Integer.valueOf(this.mBackUpDelayedTime), Integer.valueOf(this.mEnableParallel)));
                    this.mHandler.sendMessageDelayed(message3, this.mBackUpDelayedTime * 1000);
                }
            }
        } else if (i == 6 && this.mParsers[1] == null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "create backup dns type:%d host:%s", Integer.valueOf(this.mBackUpType), aVMDLDNSInfo.mHost));
            this.mStates[1] = 1;
            this.mParsers[1] = createDNSParser(aVMDLDNSInfo.mHost, this.mBackUpType, 1);
            this.mParsers[1].start();
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "****do parse internal end", new Object[0]));
    }

    private BaseDNS createDNSParser(String str, int i, int i2) {
        CreateConstructor createConstructor;
        try {
            createConstructor = AVMDLDNSManager.getInstance().getCreateConstructor(i);
        } catch (Exception e) {
            e.printStackTrace();
            createConstructor = null;
        }
        if (createConstructor != null) {
            return createConstructor.createDns(str, null, i, this.mHandler);
        }
        if (i == 4 && AVMDLDNSParser.mCustomHttpDNSParser != null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "create custom httpdns parser for host:%s type:%d", str, Integer.valueOf(i)));
            return new CustomHTTPDNS(str, this.mHandler);
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "create local dns parser for host:%s type:%d", str, Integer.valueOf(i)));
        return new LocalDNS(str, this.mHandler);
    }
}
