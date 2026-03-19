package com.fendasz.moku.liulishuo.okdownload.core.listener.assist;

import android.util.SparseArray;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Model;
import com.fendasz.moku.liulishuo.okdownload.core.listener.assist.ListenerModelHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class Listener4Assist<T extends Listener4Model> implements ListenerAssist {
    private AssistExtend assistExtend;
    Listener4Callback callback;
    private final ListenerModelHandler<T> modelHandler;

    public interface AssistExtend {
        boolean dispatchBlockEnd(DownloadTask downloadTask, int i, Listener4Model listener4Model);

        boolean dispatchFetchProgress(DownloadTask downloadTask, int i, long j, Listener4Model listener4Model);

        boolean dispatchInfoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4Model listener4Model);

        boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener4Model listener4Model);
    }

    public interface Listener4Callback {
        void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo);

        void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4Model listener4Model);

        void progress(DownloadTask downloadTask, long j);

        void progressBlock(DownloadTask downloadTask, int i, long j);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener4Model listener4Model);
    }

    Listener4Assist(ListenerModelHandler<T> listenerModelHandler) {
        this.modelHandler = listenerModelHandler;
    }

    public Listener4Assist(ListenerModelHandler.ModelCreator<T> modelCreator) {
        this.modelHandler = new ListenerModelHandler<>(modelCreator);
    }

    public void setCallback(Listener4Callback listener4Callback) {
        this.callback = listener4Callback;
    }

    public AssistExtend getAssistExtend() {
        return this.assistExtend;
    }

    public void setAssistExtend(AssistExtend assistExtend) {
        this.assistExtend = assistExtend;
    }

    public void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z) {
        Listener4Callback listener4Callback;
        Listener4Model listener4Model = (Listener4Model) this.modelHandler.addAndGetModel(downloadTask, breakpointInfo);
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchInfoReady(downloadTask, breakpointInfo, z, listener4Model)) && (listener4Callback = this.callback) != null) {
            listener4Callback.infoReady(downloadTask, breakpointInfo, z, listener4Model);
        }
    }

    public void fetchProgress(DownloadTask downloadTask, int i, long j) {
        Listener4Callback listener4Callback;
        Listener4Model listener4Model = (Listener4Model) this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (listener4Model == null) {
            return;
        }
        long jLongValue = listener4Model.blockCurrentOffsetMap.get(i).longValue() + j;
        listener4Model.blockCurrentOffsetMap.put(i, Long.valueOf(jLongValue));
        listener4Model.currentOffset += j;
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchFetchProgress(downloadTask, i, j, listener4Model)) && (listener4Callback = this.callback) != null) {
            listener4Callback.progressBlock(downloadTask, i, jLongValue);
            this.callback.progress(downloadTask, listener4Model.currentOffset);
        }
    }

    public void fetchEnd(DownloadTask downloadTask, int i) {
        Listener4Callback listener4Callback;
        Listener4Model listener4Model = (Listener4Model) this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (listener4Model == null) {
            return;
        }
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchBlockEnd(downloadTask, i, listener4Model)) && (listener4Callback = this.callback) != null) {
            listener4Callback.blockEnd(downloadTask, i, listener4Model.info.getBlock(i));
        }
    }

    public synchronized void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
        Listener4Model listener4Model = (Listener4Model) this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
        AssistExtend assistExtend = this.assistExtend;
        if (assistExtend == null || !assistExtend.dispatchTaskEnd(downloadTask, endCause, exc, listener4Model)) {
            Listener4Callback listener4Callback = this.callback;
            if (listener4Callback != null) {
                listener4Callback.taskEnd(downloadTask, endCause, exc, listener4Model);
            }
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        return this.modelHandler.isAlwaysRecoverAssistModel();
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.modelHandler.setAlwaysRecoverAssistModel(z);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        this.modelHandler.setAlwaysRecoverAssistModelIfNotSet(z);
    }

    public static class Listener4Model implements ListenerModelHandler.ListenerModel {
        SparseArray<Long> blockCurrentOffsetMap;
        long currentOffset;
        private final int id;
        BreakpointInfo info;

        public Listener4Model(int i) {
            this.id = i;
        }

        SparseArray<Long> getBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap;
        }

        public long getCurrentOffset() {
            return this.currentOffset;
        }

        public long getBlockCurrentOffset(int i) {
            return this.blockCurrentOffsetMap.get(i).longValue();
        }

        public SparseArray<Long> cloneBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap.clone();
        }

        public BreakpointInfo getInfo() {
            return this.info;
        }

        @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            return this.id;
        }

        @Override // com.fendasz.moku.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo breakpointInfo) {
            this.info = breakpointInfo;
            this.currentOffset = breakpointInfo.getTotalOffset();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int blockCount = breakpointInfo.getBlockCount();
            for (int i = 0; i < blockCount; i++) {
                sparseArray.put(i, Long.valueOf(breakpointInfo.getBlock(i).getCurrentOffset()));
            }
            this.blockCurrentOffsetMap = sparseArray;
        }
    }
}
