package com.kuaishou.tk.api.export.sdk;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import com.kuaishou.tk.api.export.ITKViewContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKViewContainerWrapView extends FrameLayout implements ITKViewContainer {
    private ICreateViewListener mICreateViewListener;
    private boolean mIsCreateViewFinish;
    private List<Runnable> mRunnableList;
    private ITKViewContainer mTKViewContainer;
    private Throwable mThrowable;
    private TkBundleInfo mTkBundleInfo;

    public interface ICreateViewCallback {
        void onFailed(TKViewContainerWrapView tKViewContainerWrapView, int i, Throwable th, TkBundleInfo tkBundleInfo);

        void onSuccess(TKViewContainerWrapView tKViewContainerWrapView, TkBundleInfo tkBundleInfo);
    }

    public interface ICreateViewListener {
        void onFailed(Throwable th, TkBundleInfo tkBundleInfo);

        void onListenerCancel();

        void onSuccess();
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public FrameLayout getView() {
        return this;
    }

    public TKViewContainerWrapView(Context context) {
        super(context);
        this.mTKViewContainer = null;
        this.mIsCreateViewFinish = false;
    }

    public void notifyCreateViewSuccess(ITKViewContainer iTKViewContainer) {
        if (this.mIsCreateViewFinish) {
            return;
        }
        this.mIsCreateViewFinish = true;
        this.mTKViewContainer = iTKViewContainer;
        addView(this.mTKViewContainer.getView());
        List<Runnable> list = this.mRunnableList;
        if (list != null && !list.isEmpty()) {
            Iterator<Runnable> it = this.mRunnableList.iterator();
            while (it.hasNext()) {
                try {
                    it.next().run();
                } catch (Throwable th) {
                    Log.e("TKViewContainerWrapView", Log.getStackTraceString(th));
                }
            }
            this.mRunnableList.clear();
        }
        ICreateViewListener iCreateViewListener = this.mICreateViewListener;
        if (iCreateViewListener != null) {
            iCreateViewListener.onSuccess();
        }
    }

    public void hotReloadUpdate() {
        this.mIsCreateViewFinish = false;
        this.mTKViewContainer = null;
    }

    public void notifyCreateViewFailed(Throwable th, TkBundleInfo tkBundleInfo) {
        if (this.mIsCreateViewFinish) {
            return;
        }
        this.mIsCreateViewFinish = true;
        this.mThrowable = th;
        this.mTkBundleInfo = tkBundleInfo;
        ICreateViewListener iCreateViewListener = this.mICreateViewListener;
        if (iCreateViewListener != null) {
            iCreateViewListener.onFailed(th, tkBundleInfo);
        }
    }

    public boolean isCreateViewFinish() {
        return this.mIsCreateViewFinish;
    }

    public boolean isCreateViewSuccess() {
        return this.mTKViewContainer != null;
    }

    public void registerCreateViewListener(ICreateViewListener iCreateViewListener) {
        ICreateViewListener iCreateViewListener2;
        if (!isCreateViewFinish() && (iCreateViewListener2 = this.mICreateViewListener) != null) {
            iCreateViewListener2.onListenerCancel();
        }
        this.mICreateViewListener = iCreateViewListener;
        if (iCreateViewListener != null) {
            if (isCreateViewSuccess()) {
                iCreateViewListener.onSuccess();
            } else if (isCreateViewFinish()) {
                iCreateViewListener.onFailed(this.mThrowable, this.mTkBundleInfo);
            }
        }
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public ITKViewContainer getContainer() {
        return this.mTKViewContainer;
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public void setData(final Object... objArr) {
        if (isCreateViewSuccess()) {
            this.mTKViewContainer.setData(objArr);
            return;
        }
        if (isCreateViewFinish()) {
            return;
        }
        List<Runnable> list = this.mRunnableList;
        if (list != null) {
            list.clear();
        } else {
            this.mRunnableList = Collections.synchronizedList(new ArrayList());
        }
        this.mRunnableList.add(new Runnable() { // from class: com.kuaishou.tk.api.export.sdk.TKViewContainerWrapView.1
            @Override // java.lang.Runnable
            public void run() {
                if (TKViewContainerWrapView.this.isCreateViewSuccess()) {
                    TKViewContainerWrapView.this.mTKViewContainer.setData(objArr);
                }
            }
        });
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public void setIJS2NativeInvoker(ITKViewContainer.IJS2NativeInvoker iJS2NativeInvoker) {
        ITKViewContainer iTKViewContainer = this.mTKViewContainer;
        if (iTKViewContainer != null) {
            iTKViewContainer.setIJS2NativeInvoker(iJS2NativeInvoker);
        }
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public Object invokeJSFunctionWithJSONString(final String str, final String str2, final IFunction iFunction) {
        if (isCreateViewSuccess() && getChildCount() > 0) {
            return this.mTKViewContainer.invokeJSFunctionWithJSONString(str, str2, iFunction);
        }
        if (isCreateViewFinish()) {
            return null;
        }
        if (this.mRunnableList == null) {
            this.mRunnableList = Collections.synchronizedList(new ArrayList());
        }
        this.mRunnableList.add(new Runnable() { // from class: com.kuaishou.tk.api.export.sdk.TKViewContainerWrapView.2
            @Override // java.lang.Runnable
            public void run() {
                if (TKViewContainerWrapView.this.mTKViewContainer != null) {
                    TKViewContainerWrapView.this.mTKViewContainer.invokeJSFunctionWithJSONString(str, str2, iFunction);
                }
            }
        });
        return null;
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public void close() {
        ITKViewContainer iTKViewContainer = this.mTKViewContainer;
        if (iTKViewContainer != null) {
            iTKViewContainer.close();
        }
    }
}
