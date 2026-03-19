package com.sigmob.sdk.downloader;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h extends com.sigmob.sdk.downloader.core.listener.c {
    private Notification.Builder a;
    private NotificationManager b;
    private RemoteViews c;
    private Context e;

    public h(Context context) {
        this.e = context.getApplicationContext();
        this.c = new RemoteViews(context.getPackageName(), ResourceUtil.getLayoutId(context, "sig_download_notification_layout"));
    }

    public void a(PendingIntent intent) {
        this.c.setOnClickPendingIntent(ResourceUtil.getId(this.e, "sig_download_notification_button"), intent);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    protected void a(f task) {
        if (!task.m().renameTo(task.n())) {
            SigmobLog.e("download temp file renameTo failed");
        }
        SigmobLog.d("FileDownloaderNotificationListener completed ");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_speed"), "下载完成,立即安装");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 4);
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_status"), 8);
        this.a.setOngoing(false);
        this.a.setAutoCancel(true);
        this.b.notify(task.c(), this.a.build());
    }

    public void a(f task, int blockCount, long currentOffset, long totalLength) {
        RemoteViews remoteViews;
        int id;
        StringBuilder sbAppend;
        String str;
        if (currentOffset > 1048576) {
            remoteViews = this.c;
            id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
            sbAppend = new StringBuilder().append((currentOffset / 1024) / 1024);
            str = "M/";
        } else {
            remoteViews = this.c;
            id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
            sbAppend = new StringBuilder().append(currentOffset / 1024);
            str = "KB/";
        }
        remoteViews.setTextViewText(id, sbAppend.append(str).append((totalLength / 1024) / 1024).append("M").toString());
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "正在下载");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(task.c(), this.a.build());
    }

    public void a(f task, long currentOffset, long totalLength) {
        RemoteViews remoteViews;
        int id;
        StringBuilder sbAppend;
        String str;
        Log.d("NotificationActivity", "progress " + currentOffset);
        if (currentOffset > 1048576) {
            remoteViews = this.c;
            id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
            sbAppend = new StringBuilder().append((currentOffset / 1024) / 1024);
            str = "M/";
        } else {
            remoteViews = this.c;
            id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
            sbAppend = new StringBuilder().append(currentOffset / 1024);
            str = "KB/";
        }
        remoteViews.setTextViewText(id, sbAppend.append(str).append((totalLength / 1024) / 1024).append("M").toString());
        if (totalLength > 0) {
            this.c.setProgressBar(ResourceUtil.getId(this.e, "sig_download_notification_progressBar"), 100, (int) ((currentOffset * 100) / totalLength), false);
        }
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(task.c(), this.a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0736a
    public void a(f task, com.sigmob.sdk.downloader.core.cause.b cause) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    protected void a(f task, Exception e) {
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "下载失败");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "重试");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(task.c(), this.a.build());
    }

    public void a(String icon_url, String title, String description) {
        this.b = (NotificationManager) this.e.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.createNotificationChannel(new NotificationChannel("sig_filedownloader_notification", "sig_filedownloader", 1));
        }
        this.a = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.e, "sig_filedownloader_notification") : new Notification.Builder(this.e);
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_title"), title);
        if (!TextUtils.isEmpty(icon_url)) {
            try {
                com.sigmob.sdk.base.common.g.a().getBitmap(icon_url, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.downloader.h.1
                    public void onBitmapLoadFailed() {
                    }

                    public void onBitmapLoaded(Bitmap bitmap) {
                        h.this.c.setImageViewBitmap(ResourceUtil.getId(h.this.e, "sig_download_notification_icon"), bitmap);
                    }
                });
            } catch (Throwable unused) {
            }
        }
        this.c.setProgressBar(ResourceUtil.getId(this.e, "sig_download_notification_progress"), 100, 0, false);
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_speed"), "0M/0M");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "等待开始");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.a.setDefaults(4).setOngoing(true).setSmallIcon(this.e.getApplicationInfo().icon).setPriority(0);
        if (Build.VERSION.SDK_INT >= 24) {
            this.a.setCustomContentView(this.c);
        } else {
            this.a.setContent(this.c);
        }
    }

    public void b(PendingIntent intent) {
        this.a.setContentIntent(intent);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    protected void b(f task) {
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "准备下载");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "暂停");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(task.c(), this.a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    protected void c(f task) {
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "下载暂停");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "继续");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(task.c(), this.a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    protected void d(f task) {
    }
}
