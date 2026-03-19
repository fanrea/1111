package com.bykv.vk.component.ttvideo.medialoader;

import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.baidu.mobads.upgrade.remote.gray.c;
import com.bykv.vk.component.ttvideo.AppInfo;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.mq;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class MediaLoaderWrapper implements AVMDLDataLoaderListener {
    public static final int DATALOADER_KEY_NOTIFY_OWNVDPLOG = 1;
    public static final int DATALOADER_KEY_NOTIFY_SPEEDINFO = 2;
    public static final int DATALOADER_KEY_NOTIFY_TASKLOG = 0;
    static final String HTTP_PROTO_PREFIX = "http://";
    static final String MDL_PROTO_PREFIX = "mdl://";
    static final String TAG = "MediaLoaderWrapper";
    private volatile boolean isProxyLibraryLoaded;
    public AVMDLDataLoaderConfigure mConfigure;
    private boolean mEnableLoadLibrary;
    private boolean mIsRunning;
    private MediaLoaderListener mListener;
    private LiveLoggerService mLogService;
    private MediaPlayer mPlayer;
    private volatile LibraryLoadProxy mProxy;

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i, long j, String str) {
        return null;
    }

    private static class Holder {
        private static MediaLoaderWrapper instance = new MediaLoaderWrapper();

        private Holder() {
        }
    }

    private MediaLoaderWrapper() {
        this.isProxyLibraryLoaded = false;
        this.mProxy = null;
        this.mIsRunning = false;
        this.mEnableLoadLibrary = false;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
    }

    public MediaLoaderWrapper(MediaLoaderListener mediaLoaderListener) {
        this.isProxyLibraryLoaded = false;
        this.mProxy = null;
        this.mIsRunning = false;
        this.mEnableLoadLibrary = false;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
        this.mListener = mediaLoaderListener;
    }

    public static MediaLoaderWrapper getDataLoader() {
        return Holder.instance;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void setLogService(LiveLoggerService liveLoggerService) {
        this.mLogService = liveLoggerService;
    }

    public void setListener(MediaLoaderListener mediaLoaderListener) {
        this.mListener = mediaLoaderListener;
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
        } catch (Exception e) {
            mq.d(e);
            MyLog.i(TAG, String.format("create loader failed: exception is" + e.toString(), new Object[0]));
        }
    }

    public void setLoadProxy(LibraryLoadProxy libraryLoadProxy) {
        this.mProxy = libraryLoadProxy;
    }

    public void enableLoadLibrary() {
        this.mEnableLoadLibrary = true;
    }

    public void start() throws Exception {
        if (this.mIsRunning) {
            return;
        }
        if (!initInternal()) {
            throw new Exception("init mediaLoader fail");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (AppInfo.mAppChannel != null) {
                if (!TextUtils.isEmpty(AppInfo.mAppChannel)) {
                    jSONObject.put("app_channel", AppInfo.mAppChannel);
                }
                if (!TextUtils.isEmpty(AppInfo.mAppName)) {
                    jSONObject.put("app_name", AppInfo.mAppName);
                }
                if (!TextUtils.isEmpty(AppInfo.mDeviceId)) {
                    jSONObject.put(c.l, AppInfo.mDeviceId);
                }
                if (!TextUtils.isEmpty(AppInfo.mAppVersion)) {
                    jSONObject.put("app_version", AppInfo.mAppVersion);
                }
                jSONObject.put(b.D0, AppInfo.mAppID);
            }
        } catch (JSONException e) {
            mq.d(e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        this.mConfigure.mAppInfo = jSONObject.toString();
        if (AppInfo.mAppID != -1) {
            MyLog.i(TAG, "set config");
            AVMDLDataLoader.getInstance().setConfigure(this.mConfigure);
        }
        if (AVMDLDataLoader.getInstance().start() < 0) {
            throw new Exception("start mediaLoader fail");
        }
        this.mIsRunning = true;
    }

    public void close() {
        if (!this.mIsRunning) {
            MyLog.e(TAG, "MediaLoader not started, not need close");
            return;
        }
        this.mListener = null;
        AVMDLDataLoader.getInstance().close();
        AVMDLDataLoader.getInstance().cancelAll();
        this.mIsRunning = false;
    }

    public boolean isRunning() {
        if (AVMDLDataLoader.getInstance() == null) {
            return false;
        }
        return AVMDLDataLoader.getInstance().isRunning();
    }

    public long getLongValueFromLoader(int i) {
        MyLog.i(TAG, "get long value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (i == 7218) {
            if (aVMDLDataLoader == null) {
                return -1L;
            }
            return aVMDLDataLoader.getLongValue(7218);
        }
        switch (i) {
            case 8100:
                if (aVMDLDataLoader == null) {
                    return -1L;
                }
                return aVMDLDataLoader.getLongValue(8100);
            case 8101:
                if (aVMDLDataLoader == null) {
                    return -1L;
                }
                return aVMDLDataLoader.getLongValue(8101);
            case 8102:
                return (aVMDLDataLoader != null ? aVMDLDataLoader.getLongValue(8102) : -1L) == 1 ? 1L : 0L;
            default:
                return -1L;
        }
    }

    public String getStringValueFromLoader(int i) {
        MyLog.i(TAG, "get string value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (i == 11 && aVMDLDataLoader != null) {
            return aVMDLDataLoader.getStringValue(11);
        }
        return null;
    }

    public void setIntValue(int i, int i2) {
        if (i == 51) {
            this.mConfigure.mRWTimeOut = i2;
            return;
        }
        if (i == 52) {
            this.mConfigure.mOpenTimeOut = i2;
            return;
        }
        if (i == 53) {
            this.mConfigure.mTryCount = i2;
            return;
        }
        if (i == 49) {
            MyLog.i(TAG, "allow p2p:".concat(String.valueOf(i2)));
            this.mConfigure.mLiveP2pAllow = i2;
        } else if (i == 50) {
            MyLog.i(TAG, "loader type:".concat(String.valueOf(i2)));
            this.mConfigure.mLiveLoaderType = i2;
        }
    }

    public void setLongValue(int i, long j) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader != null && i == 59) {
            aVMDLDataLoader.setLongValue(1100, j);
        }
    }

    public void setInt64ValueByStrKey(int i, String str, int i2) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        if (i == 7213 || i == 7215) {
            aVMDLDataLoader.setInt64ValueByStrKey(i, str, i2);
        } else {
            aVMDLDataLoader.setInt64ValueByStrKey(i, str, System.currentTimeMillis());
        }
    }

    public void setStringValue(int i, String str) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.setStringValue(i, str);
    }

    public String getProxyUrl(String str, Boolean bool) {
        String strEncode = null;
        if (str == null) {
            return null;
        }
        if (!supportProxy(str)) {
            return str;
        }
        String localAddr = AVMDLDataLoader.getInstance().getLocalAddr();
        if (TextUtils.isEmpty(localAddr)) {
            return null;
        }
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th) {
            mq.d(th);
        }
        String str2 = localAddr + "?rk=v02004b50000bh9ajqhdli3lfv2rgsgg&k=426161df8c5ce110209a6fc6641e049ddfrfgaf&u0=" + strEncode;
        if (bool.booleanValue()) {
            return "mdl://".concat(String.valueOf(str2));
        }
        return "http://".concat(String.valueOf(str2));
    }

    private boolean initInternal() {
        if (this.mEnableLoadLibrary) {
            if (!loadLibrary()) {
                MyLog.i(TAG, String.format("library load fail", new Object[0]));
                return false;
            }
            if (AVMDLDataLoader.init(this.mProxy != null) != 0) {
                String.format("library has not been loaded", new Object[0]);
                return false;
            }
        }
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
            return true;
        } catch (Exception e) {
            mq.d(e);
            MyLog.i(TAG, String.format("create loader failed: exception is" + e.toString(), new Object[0]));
            return false;
        }
    }

    private boolean loadLibrary() {
        if (this.mProxy == null) {
            return true;
        }
        if (this.mProxy != null && !this.isProxyLibraryLoaded) {
            this.isProxyLibraryLoaded = this.mProxy.loadLibrary("avmdl");
        }
        return this.isProxyLibraryLoaded;
    }

    private boolean supportProxy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith(UriUtils.FILE_PREFIX) || lowerCase.startsWith("/") || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?") || lowerCase.contains(".m3u8?") || lowerCase.endsWith(".m3u8")) ? false : true;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        if (aVMDLDataLoaderNotifyInfo == null || this.mListener == null) {
            return;
        }
        MyLog.i(TAG, "what:" + aVMDLDataLoaderNotifyInfo.what);
        int i = aVMDLDataLoaderNotifyInfo.what;
        if (i == 9) {
            MediaLoaderListener mediaLoaderListener = this.mListener;
            if (mediaLoaderListener != null) {
                mediaLoaderListener.onDataLoaderError((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
            }
            MyLog.i(TAG, "live loader errorCode:" + aVMDLDataLoaderNotifyInfo.parameter + " errorInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
            return;
        }
        if (i != 12) {
            return;
        }
        MediaLoaderListener mediaLoaderListener2 = this.mListener;
        if (mediaLoaderListener2 != null) {
            mediaLoaderListener2.onSwitchLoaderType((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
        }
        MyLog.i(TAG, "switch reason:" + aVMDLDataLoaderNotifyInfo.parameter + " switchInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i, long j) {
        MediaLoaderListener mediaLoaderListener;
        MyLog.i(TAG, "getInt64Value:".concat(String.valueOf(i)));
        if (i != 8003) {
            return (i == 8004 && (mediaLoaderListener = this.mListener) != null) ? mediaLoaderListener.getInt64Value(0, j) : j;
        }
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null ? mediaPlayer.getLongOption(73, 0L) : j;
    }
}
