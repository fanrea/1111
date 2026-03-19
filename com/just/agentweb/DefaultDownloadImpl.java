package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import com.download.library.DownloadImpl;
import com.download.library.DownloadListenerAdapter;
import com.download.library.Extra;
import com.download.library.ResourceRequest;
import com.sigmob.sdk.base.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DefaultDownloadImpl implements DownloadListener {
    private static final String TAG = "DefaultDownloadImpl";
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean isInstallDownloader;
    protected WeakReference<Activity> mActivityWeakReference;
    protected WeakReference<AbsAgentWebUIController> mAgentWebUIController;
    protected Context mContext;
    protected ConcurrentHashMap<String, ResourceRequest> mDownloadTasks = new ConcurrentHashMap<>();
    protected PermissionInterceptor mPermissionListener;

    protected DefaultDownloadImpl(Activity activity, WebView webView, PermissionInterceptor permissionInterceptor) {
        this.mActivityWeakReference = null;
        this.mPermissionListener = null;
        this.mContext = activity.getApplicationContext();
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mPermissionListener = permissionInterceptor;
        this.mAgentWebUIController = new WeakReference<>(AgentWebUtils.getAgentWebUIControllerByWebView(webView));
        try {
            DownloadImpl.getInstance(this.mContext);
            this.isInstallDownloader = true;
        } catch (Throwable th) {
            LogUtils.e(TAG, "implementation 'com.download.library:Downloader:x.x.x'");
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
            this.isInstallDownloader = false;
        }
    }

    public static DefaultDownloadImpl create(Activity activity, WebView webView, PermissionInterceptor permissionInterceptor) {
        return new DefaultDownloadImpl(activity, webView, permissionInterceptor);
    }

    protected Handler.Callback createCallback(final String str) {
        return new Handler.Callback() { // from class: com.just.agentweb.DefaultDownloadImpl.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                DefaultDownloadImpl.this.forceDownload(str);
                return true;
            }
        };
    }

    protected ResourceRequest createResourceRequest(String str) {
        return DownloadImpl.getInstance(this.mContext).with(str).setEnableIndicator(true).autoOpenIgnoreMD5();
    }

    protected void forceDownload(String str) {
        this.mDownloadTasks.get(str).setForceDownload(true);
        performDownload(str);
    }

    protected boolean isForceRequest(String str) {
        ResourceRequest resourceRequest = this.mDownloadTasks.get(str);
        if (resourceRequest != null) {
            return resourceRequest.getDownloadTask().isForceDownload();
        }
        return false;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(final String str, final String str2, final String str3, final String str4, final long j) {
        if (this.isInstallDownloader) {
            mHandler.post(new Runnable() { // from class: com.just.agentweb.DefaultDownloadImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultDownloadImpl.this.onDownloadStartInternal(str, str2, str3, str4, j);
                }
            });
        } else {
            LogUtils.e(TAG, "unable start download " + str + "; implementation 'com.download.library:Downloader:x.x.x'");
        }
    }

    protected void onDownloadStartInternal(String str, String str2, String str3, String str4, long j) {
        if (this.mActivityWeakReference.get() == null || this.mActivityWeakReference.get().isFinishing()) {
            return;
        }
        PermissionInterceptor permissionInterceptor = this.mPermissionListener;
        if (permissionInterceptor == null || !permissionInterceptor.intercept(str, new String[0], "download")) {
            this.mDownloadTasks.put(str, createResourceRequest(str));
            preDownload(str);
        }
    }

    protected void performDownload(String str) {
        try {
            LogUtils.e(TAG, "performDownload:" + str + " exist:" + DownloadImpl.getInstance(this.mContext).exist(str));
            if (DownloadImpl.getInstance(this.mContext).exist(str)) {
                if (this.mAgentWebUIController.get() != null) {
                    this.mAgentWebUIController.get().onShowMessage(this.mActivityWeakReference.get().getString(R.string.agentweb_download_task_has_been_exist), "preDownload");
                }
            } else {
                ResourceRequest resourceRequest = this.mDownloadTasks.get(str);
                resourceRequest.addHeader(e.b, AgentWebConfig.getCookiesByUrl(str));
                taskEnqueue(resourceRequest);
            }
        } catch (Throwable th) {
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    protected void preDownload(String str) {
        if (isForceRequest(str) || AgentWebUtils.checkNetworkType(this.mContext) <= 1) {
            performDownload(str);
        } else {
            showDialog(str);
        }
    }

    protected void showDialog(String str) {
        AbsAgentWebUIController absAgentWebUIController;
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null || activity.isFinishing() || (absAgentWebUIController = this.mAgentWebUIController.get()) == null) {
            return;
        }
        absAgentWebUIController.onForceDownloadAlert(str, createCallback(str));
    }

    protected void taskEnqueue(ResourceRequest resourceRequest) {
        resourceRequest.enqueue(new DownloadListenerAdapter() { // from class: com.just.agentweb.DefaultDownloadImpl.3
            public boolean onResult(Throwable th, Uri uri, String str, Extra extra) {
                DefaultDownloadImpl.this.mDownloadTasks.remove(str);
                return super.onResult(th, uri, str, extra);
            }
        });
    }
}
