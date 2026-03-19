package com.ss.android.socialbase.appdownloader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.downloader.rf;
import com.ss.android.socialbase.downloader.impls.yo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.b.d(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.ss.android.socialbase.downloader.an.d.b("RetrySchedulerService", "onStartJob, id = ".concat(String.valueOf(jobId)));
        yo.d().d(jobId);
        return false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.downloader.b.tt()) {
            return 2;
        }
        return iOnStartCommand;
    }

    static void d(com.ss.android.socialbase.downloader.h.b bVar, long j, boolean z, int i) {
        Context contextTr;
        long j2;
        rf rfVarHc;
        rf rfVarHc2;
        if (bVar == null || j <= 0 || (contextTr = com.ss.android.socialbase.downloader.downloader.b.tr()) == null) {
            return;
        }
        int i2 = 2;
        if (bVar.xp() && (rfVarHc2 = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc()) != null) {
            rfVarHc2.d(bVar, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextTr.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(bVar.h());
            } catch (Throwable th) {
                mq.d(th);
            }
            if (i == 0 || (z && i != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(bVar.h(), new ComponentName(contextTr.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (!z) {
                i2 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && bVar.xp() && (rfVarHc = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc()) != null) {
                rfVarHc.d(bVar, 3, 3);
            }
            if (iSchedule <= 0) {
                com.ss.android.socialbase.downloader.an.d.c("RetrySchedulerService", "schedule err errCode = ".concat(String.valueOf(iSchedule)));
            }
        } catch (Throwable th2) {
            mq.d(th2);
        }
    }
}
