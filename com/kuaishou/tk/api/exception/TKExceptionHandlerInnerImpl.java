package com.kuaishou.tk.api.exception;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.tk.api.export.sdk.ITKExceptionListener;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.tk.core.a.m;
import com.tkruntime.v8.V8ScriptCompilationException;
import com.tkruntime.v8.V8ScriptExecutionException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKExceptionHandlerInnerImpl implements m {
    private static final List<ITKExceptionListener> sTKExceptionListeners = new CopyOnWriteArrayList();
    private ITKExceptionHandler mHandler;

    public TKExceptionHandlerInnerImpl(ITKExceptionHandler iTKExceptionHandler) {
        this.mHandler = iTKExceptionHandler;
    }

    @Override // com.tk.core.a.m
    public void handleException(int i, Throwable th, String str) {
        TkBundleInfo tkBundleInfo;
        String str2;
        ContainerInfo containerInfo = ContainerInfoMap.get(i);
        if (containerInfo != null) {
            tkBundleInfo = containerInfo.bundleInfo;
            str2 = containerInfo.containerSessionId;
        } else {
            tkBundleInfo = null;
            str2 = "";
        }
        handleExceptionInner(tkBundleInfo, str2, th, str, containerInfo);
    }

    @Override // com.tk.core.a.m
    public void handleException(String str, Throwable th, String str2) {
        if (str == null) {
            str = "";
        }
        TkBundleInfo tkBundleInfo = new TkBundleInfo("", str, "", -1, "", -1L, "", "");
        ContainerInfo containerInfo = new ContainerInfo();
        containerInfo.bundleInfo = tkBundleInfo;
        containerInfo.containerSessionId = "";
        handleExceptionInner(tkBundleInfo, "", th, str2, null);
    }

    private void handleExceptionInner(TkBundleInfo tkBundleInfo, String str, Throwable th, String str2, ContainerInfo containerInfo) {
        for (ITKExceptionListener iTKExceptionListener : sTKExceptionListeners) {
            if (iTKExceptionListener != null) {
                iTKExceptionListener.onTKException(th, tkBundleInfo);
            }
        }
        if (this.mHandler != null) {
            if (th instanceof V8ScriptExecutionException) {
                V8ScriptExecutionException v8ScriptExecutionException = (V8ScriptExecutionException) th;
                TKJSExecutionException tKJSExecutionException = new TKJSExecutionException(v8ScriptExecutionException.getFileName(), v8ScriptExecutionException.getLineNumber(), TextUtils.isEmpty(str2) ? v8ScriptExecutionException.getJSMessage() : str2 + Config.replace + v8ScriptExecutionException.getJSMessage(), v8ScriptExecutionException.getSourceLine(), v8ScriptExecutionException.getStartColumn(), v8ScriptExecutionException.getEndColumn(), v8ScriptExecutionException.getJSStackTrace(), v8ScriptExecutionException.getCause());
                this.mHandler.handleException(tKJSExecutionException, tkBundleInfo, str);
                this.mHandler.handleReportException(tKJSExecutionException, containerInfo);
                return;
            }
            if (th instanceof V8ScriptCompilationException) {
                V8ScriptCompilationException v8ScriptCompilationException = (V8ScriptCompilationException) th;
                TKJSCompilationException tKJSCompilationException = new TKJSCompilationException(v8ScriptCompilationException.getFileName(), v8ScriptCompilationException.getLineNumber(), TextUtils.isEmpty(str2) ? v8ScriptCompilationException.getJSMessage() : str2 + Config.replace + v8ScriptCompilationException.getJSMessage(), v8ScriptCompilationException.getSourceLine(), v8ScriptCompilationException.getStartColumn(), v8ScriptCompilationException.getEndColumn(), v8ScriptCompilationException.getJSStackTrace(), v8ScriptCompilationException.getCause());
                this.mHandler.handleException(tKJSCompilationException, tkBundleInfo, str);
                this.mHandler.handleReportException(tKJSCompilationException, containerInfo);
                return;
            }
            TKException tKException = TextUtils.isEmpty(str2) ? new TKException(th) : new TKException(str2, th);
            this.mHandler.handleException(tKException, tkBundleInfo, str);
            this.mHandler.handleReportException(tKException, containerInfo);
        }
    }

    public static void addHandleExceptionListener(ITKExceptionListener iTKExceptionListener) {
        if (iTKExceptionListener == null || sTKExceptionListeners.contains(iTKExceptionListener)) {
            return;
        }
        sTKExceptionListeners.add(iTKExceptionListener);
    }

    public static void removeHandleExceptionListener(ITKExceptionListener iTKExceptionListener) {
        if (iTKExceptionListener == null) {
            return;
        }
        sTKExceptionListeners.remove(iTKExceptionListener);
    }
}
