package com.jeremyliao.liveeventbus.core;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ExternalLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;
import com.jeremyliao.liveeventbus.ipc.core.ProcessorManager;
import com.jeremyliao.liveeventbus.ipc.receiver.LebIpcReceiver;
import com.jeremyliao.liveeventbus.logger.DefaultLogger;
import com.jeremyliao.liveeventbus.logger.Logger;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import com.jeremyliao.liveeventbus.utils.AppUtils;
import com.jeremyliao.liveeventbus.utils.ThreadUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class LiveEventBusCore {
    private boolean autoClear;
    private final Map<String, LiveEvent<Object>> bus;
    private final Config config;
    final InnerConsole console;
    private boolean isRegisterReceiver;
    private boolean lifecycleObserverAlwaysActive;
    private LoggerManager logger;
    private final Map<String, ObservableConfig> observableConfigs;
    private LebIpcReceiver receiver;

    private static class SingletonHolder {
        private static final LiveEventBusCore DEFAULT_BUS = new LiveEventBusCore();

        private SingletonHolder() {
        }
    }

    public static LiveEventBusCore get() {
        return SingletonHolder.DEFAULT_BUS;
    }

    private LiveEventBusCore() {
        this.config = new Config();
        this.isRegisterReceiver = false;
        this.console = new InnerConsole();
        this.bus = new HashMap();
        this.observableConfigs = new HashMap();
        this.lifecycleObserverAlwaysActive = true;
        this.autoClear = false;
        this.logger = new LoggerManager(new DefaultLogger());
        this.receiver = new LebIpcReceiver();
        registerReceiver();
    }

    public synchronized <T> Observable<T> with(String str, Class<T> cls) {
        if (!this.bus.containsKey(str)) {
            this.bus.put(str, new LiveEvent<>(str));
        }
        return this.bus.get(str);
    }

    public Config config() {
        return this.config;
    }

    public ObservableConfig config(String str) {
        if (!this.observableConfigs.containsKey(str)) {
            this.observableConfigs.put(str, new ObservableConfig());
        }
        return this.observableConfigs.get(str);
    }

    void setLogger(Logger logger) {
        this.logger.setLogger(logger);
    }

    void enableLogger(boolean z) {
        this.logger.setEnable(z);
    }

    void registerReceiver() {
        Application app;
        if (this.isRegisterReceiver || (app = AppUtils.getApp()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IpcConst.ACTION);
        app.registerReceiver(this.receiver, intentFilter);
        this.isRegisterReceiver = true;
    }

    void setLifecycleObserverAlwaysActive(boolean z) {
        this.lifecycleObserverAlwaysActive = z;
    }

    void setAutoClear(boolean z) {
        this.autoClear = z;
    }

    private class LiveEvent<T> implements Observable<T> {
        private final String key;
        private final LiveEvent<T>.LifecycleLiveData<T> liveData;
        private final Map<Observer, ObserverWrapper<T>> observerMap = new HashMap();
        private final Handler mainHandler = new Handler(Looper.getMainLooper());

        LiveEvent(String str) {
            this.key = str;
            this.liveData = new LifecycleLiveData<>(str);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void post(T t) {
            if (ThreadUtils.isMainThread()) {
                postInternal(t);
            } else {
                this.mainHandler.post(new PostValueTask(t));
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postAcrossProcess(T t) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            broadcast(t, false, true);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postAcrossApp(T t) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            broadcast(t, false, false);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postDelay(T t, long j) {
            this.mainHandler.postDelayed(new PostValueTask(t), j);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postDelay(LifecycleOwner lifecycleOwner, T t, long j) {
            this.mainHandler.postDelayed(new PostLifeValueTask(t, lifecycleOwner), j);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postOrderly(T t) {
            this.mainHandler.post(new PostValueTask(t));
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        @Deprecated
        public void broadcast(T t) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            broadcast(t, false, false);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void broadcast(final T t, final boolean z, final boolean z2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (AppUtils.getApp() != null) {
                if (ThreadUtils.isMainThread()) {
                    broadcastInternal(t, z, z2);
                    return;
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.1
                        @Override // java.lang.Runnable
                        public void run() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                            LiveEvent.this.broadcastInternal(t, z, z2);
                        }
                    });
                    return;
                }
            }
            post(t);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observe(final LifecycleOwner lifecycleOwner, final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeSticky(final LifecycleOwner lifecycleOwner, final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeStickyInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeForever(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeForeverInternal(observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeStickyForever(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeStickyForeverInternal(observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void removeObserver(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                removeObserverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.6
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.removeObserverInternal(observer);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void postInternal(T t) {
            LiveEventBusCore.this.logger.log(Level.INFO, "post: " + t + " with key: " + this.key);
            this.liveData.setValue(t);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void broadcastInternal(T t, boolean z, boolean z2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            LiveEventBusCore.this.logger.log(Level.INFO, "broadcast: " + t + " foreground: " + z + " with key: " + this.key);
            Application app = AppUtils.getApp();
            if (app == null) {
                LiveEventBusCore.this.logger.log(Level.WARNING, "application is null, you can try setContext() when config");
                return;
            }
            Intent intent = new Intent(IpcConst.ACTION);
            if (z && Build.VERSION.SDK_INT >= 16) {
                intent.addFlags(268435456);
            }
            if (z2) {
                intent.setPackage(app.getPackageName());
            }
            intent.putExtra(IpcConst.KEY, this.key);
            if (ProcessorManager.getManager().writeTo(intent, t)) {
                try {
                    app.sendBroadcast(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeInternal(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            ObserverWrapper observerWrapper = LiveEventBusCore.this.new ObserverWrapper(observer);
            observerWrapper.preventNextEvent = this.liveData.getVersion() > -1;
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeStickyInternal(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            ObserverWrapper observerWrapper = LiveEventBusCore.this.new ObserverWrapper(observer);
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe sticky observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeForeverInternal(Observer<T> observer) {
            ObserverWrapper<T> observerWrapper = LiveEventBusCore.this.new ObserverWrapper<>(observer);
            ((ObserverWrapper) observerWrapper).preventNextEvent = this.liveData.getVersion() > -1;
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeStickyForeverInternal(Observer<T> observer) {
            ObserverWrapper<T> observerWrapper = LiveEventBusCore.this.new ObserverWrapper<>(observer);
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe sticky forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeObserverInternal(Observer<T> observer) {
            if (this.observerMap.containsKey(observer)) {
                observer = this.observerMap.remove(observer);
            }
            this.liveData.removeObserver(observer);
        }

        private class LifecycleLiveData<T> extends ExternalLiveData<T> {
            private final String key;

            public LifecycleLiveData(String str) {
                this.key = str;
            }

            @Override // androidx.lifecycle.ExternalLiveData
            protected Lifecycle.State observerActiveLevel() {
                return lifecycleObserverAlwaysActive() ? Lifecycle.State.CREATED : Lifecycle.State.STARTED;
            }

            @Override // androidx.lifecycle.LiveData
            public void removeObserver(Observer<? super T> observer) {
                super.removeObserver(observer);
                if (autoClear() && !LiveEvent.this.liveData.hasObservers()) {
                    LiveEventBusCore.get().bus.remove(this.key);
                }
                LiveEventBusCore.this.logger.log(Level.INFO, "observer removed: " + observer);
            }

            private boolean lifecycleObserverAlwaysActive() {
                if (LiveEventBusCore.this.observableConfigs.containsKey(this.key)) {
                    ObservableConfig observableConfig = (ObservableConfig) LiveEventBusCore.this.observableConfigs.get(this.key);
                    if (observableConfig.lifecycleObserverAlwaysActive != null) {
                        return observableConfig.lifecycleObserverAlwaysActive.booleanValue();
                    }
                }
                return LiveEventBusCore.this.lifecycleObserverAlwaysActive;
            }

            private boolean autoClear() {
                if (LiveEventBusCore.this.observableConfigs.containsKey(this.key)) {
                    ObservableConfig observableConfig = (ObservableConfig) LiveEventBusCore.this.observableConfigs.get(this.key);
                    if (observableConfig.autoClear != null) {
                        return observableConfig.autoClear.booleanValue();
                    }
                }
                return LiveEventBusCore.this.autoClear;
            }
        }

        private class PostValueTask implements Runnable {
            private Object newValue;

            public PostValueTask(Object obj) {
                this.newValue = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                LiveEvent.this.postInternal(this.newValue);
            }
        }

        private class PostLifeValueTask implements Runnable {
            private Object newValue;
            private LifecycleOwner owner;

            public PostLifeValueTask(Object obj, LifecycleOwner lifecycleOwner) {
                this.newValue = obj;
                this.owner = lifecycleOwner;
            }

            @Override // java.lang.Runnable
            public void run() {
                LifecycleOwner lifecycleOwner = this.owner;
                if (lifecycleOwner == null || !lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                    return;
                }
                LiveEvent.this.postInternal(this.newValue);
            }
        }
    }

    private class ObserverWrapper<T> implements Observer<T> {
        private final Observer<T> observer;
        private boolean preventNextEvent = false;

        ObserverWrapper(Observer<T> observer) {
            this.observer = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(T t) {
            if (!this.preventNextEvent) {
                LiveEventBusCore.this.logger.log(Level.INFO, "message received: " + t);
                try {
                    this.observer.onChanged(t);
                    return;
                } catch (ClassCastException e) {
                    LiveEventBusCore.this.logger.log(Level.WARNING, "class cast error on message received: " + t, e);
                    return;
                } catch (Exception e2) {
                    LiveEventBusCore.this.logger.log(Level.WARNING, "error on message received: " + t, e2);
                    return;
                }
            }
            this.preventNextEvent = false;
        }
    }

    class InnerConsole {
        InnerConsole() {
        }

        String getConsoleInfo() {
            StringBuilder sb = new StringBuilder();
            sb.append("*********Base info*********").append("\n");
            sb.append(getBaseInfo());
            sb.append("*********Event info*********").append("\n");
            sb.append(getBusInfo());
            return sb.toString();
        }

        String getBaseInfo() {
            StringBuilder sb = new StringBuilder();
            sb.append("lifecycleObserverAlwaysActive: ").append(LiveEventBusCore.this.lifecycleObserverAlwaysActive).append("\n").append("autoClear: ").append(LiveEventBusCore.this.autoClear).append("\n").append("logger enable: ").append(LiveEventBusCore.this.logger.isEnable()).append("\n").append("logger: ").append(LiveEventBusCore.this.logger.getLogger()).append("\n").append("Receiver register: ").append(LiveEventBusCore.this.isRegisterReceiver).append("\n").append("Application: ").append(AppUtils.getApp()).append("\n");
            return sb.toString();
        }

        String getBusInfo() {
            StringBuilder sb = new StringBuilder();
            for (String str : LiveEventBusCore.this.bus.keySet()) {
                sb.append("Event name: " + str).append("\n");
                LiveEvent.LifecycleLiveData lifecycleLiveData = ((LiveEvent) LiveEventBusCore.this.bus.get(str)).liveData;
                sb.append("\tversion: " + lifecycleLiveData.getVersion()).append("\n");
                sb.append("\thasActiveObservers: " + lifecycleLiveData.hasActiveObservers()).append("\n");
                sb.append("\thasObservers: " + lifecycleLiveData.hasObservers()).append("\n");
                sb.append("\tActiveCount: " + getActiveCount(lifecycleLiveData)).append("\n");
                sb.append("\tObserverCount: " + getObserverCount(lifecycleLiveData)).append("\n");
                sb.append("\tObservers: ").append("\n");
                sb.append("\t\t" + getObserverInfo(lifecycleLiveData)).append("\n");
            }
            return sb.toString();
        }

        private int getActiveCount(LiveData liveData) throws NoSuchFieldException {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mActiveCount");
                declaredField.setAccessible(true);
                return ((Integer) declaredField.get(liveData)).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }

        private int getObserverCount(LiveData liveData) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mObservers");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(liveData);
                Method declaredMethod = obj.getClass().getDeclaredMethod("size", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(obj, new Object[0])).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }

        private String getObserverInfo(LiveData liveData) throws NoSuchFieldException {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mObservers");
                declaredField.setAccessible(true);
                return declaredField.get(liveData).toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }
}
