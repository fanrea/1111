package com.fendasz.moku.planet.utils.file;

import android.content.Context;
import com.fendasz.moku.planet.utils.ApkUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ApkExistFilter implements Callable<Integer> {
    private Context context;
    private ExecutorService executor;
    private String packageName;

    public ApkExistFilter(Context context, String str) {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.context = context;
        this.packageName = str;
        this.executor = Executors.newFixedThreadPool(iAvailableProcessors);
    }

    public void filter() {
        try {
            ((Integer) this.executor.submit(this).get()).intValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        boolean zIsQQPackageExists = ApkUtil.isQQPackageExists(this.packageName, this.context);
        boolean zIsWechatPackageExists = ApkUtil.isWechatPackageExists(this.packageName, this.context);
        return Integer.valueOf((zIsQQPackageExists && zIsWechatPackageExists) ? 3 : zIsQQPackageExists ? 1 : zIsWechatPackageExists ? 2 : 0);
    }
}
