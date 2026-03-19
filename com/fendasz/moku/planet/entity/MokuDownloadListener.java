package com.fendasz.moku.planet.entity;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.fendasz.moku.liulishuo.okdownload.DownloadListener;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.SpeedCalculator;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import com.fendasz.moku.liulishuo.okdownload.core.listener.DownloadListener4WithSpeed;
import com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuDownloadListener extends DownloadListener4WithSpeed implements DownloadListener {
    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void taskStart(DownloadTask downloadTask) {
        Log.e("MokuDownloadListener", "taskStart: ");
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void connectStart(DownloadTask downloadTask, int i, Map<String, List<String>> map) {
        Log.e("MokuDownloadListener", "connectStart: " + JSONObject.toJSONString(map));
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void connectEnd(DownloadTask downloadTask, int i, int i2, Map<String, List<String>> map) {
        Log.e("MokuDownloadListener", "connectEnd: " + JSONObject.toJSONString(map));
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
    public void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4SpeedAssistExtend.Listener4SpeedModel listener4SpeedModel) {
        Log.e("MokuDownloadListener", "infoReady: ");
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
    public void progressBlock(DownloadTask downloadTask, int i, long j, SpeedCalculator speedCalculator) {
        Log.e("MokuDownloadListener", "progressBlock: ");
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
    public void progress(DownloadTask downloadTask, long j, SpeedCalculator speedCalculator) {
        Log.e("MokuDownloadListener", "progress: ");
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
    public void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo, SpeedCalculator speedCalculator) {
        Log.e("MokuDownloadListener", "blockEnd: ");
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
    public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, SpeedCalculator speedCalculator) {
        Log.e("MokuDownloadListener", "taskEnd: " + endCause.name());
        if (exc != null) {
            Log.e("MokuDownloadListener", "taskEnd: " + exc);
        }
    }
}
