package com.bytedance.sdk.djx.interfaces.listener;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class IDJXDrawListener extends IDJXBaseListener {
    public View createCustomView(ViewGroup viewGroup, Map<String, Object> map) {
        return null;
    }

    public void onChannelTabChange(int i) {
    }

    public void onDJXClose() {
    }

    public void onDJXPageChange(int i, Map<String, Object> map) {
    }

    public void onDJXRefreshFinish() {
    }

    public void onDJXReportResult(boolean z, Map<String, Object> map) {
    }

    public void onDJXRequestFail(int i, String str, Map<String, Object> map) {
    }

    public void onDJXRequestStart(Map<String, Object> map) {
    }

    public void onDJXRequestSuccess(List<Map<String, Object>> list) {
    }

    public void onDJXSeekTo(int i, long j) {
    }

    public void onDJXVideoCompletion(Map<String, Object> map) {
    }

    public void onDJXVideoContinue(Map<String, Object> map) {
    }

    public void onDJXVideoOver(Map<String, Object> map) {
    }

    public void onDJXVideoPause(Map<String, Object> map) {
    }

    public void onDJXVideoPlay(Map<String, Object> map) {
    }

    public void onDurationChange(long j) {
    }
}
