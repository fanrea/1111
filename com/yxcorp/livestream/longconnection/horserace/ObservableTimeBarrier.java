package com.yxcorp.livestream.longconnection.horserace;

import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ObservableTimeBarrier<T> implements ObservableOnSubscribe<List<T>>, Observer<T> {
    static final String TAG = "ObservableTimeBarrier";
    final long[] barriers;
    Consumer<Long> consumer;
    ObservableEmitter<List<T>> observableEmitter;
    private final Observable<Observable<T>> source;
    int sourceCount;
    final List<T> resultList = Collections.synchronizedList(new ArrayList());
    AtomicBoolean isComplete = new AtomicBoolean();
    AtomicBoolean isOutOfAllBarriers = new AtomicBoolean();
    int currentBarrierIndex = 0;
    final List<Throwable> exceptions = Collections.synchronizedList(new ArrayList());

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
    }

    private ObservableTimeBarrier(Observable<Observable<T>> observable, long[] jArr) {
        this.barriers = jArr;
        this.source = observable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<List<T>> from(Observable<Observable<T>> observable, long[] jArr) {
        return Observable.create(new ObservableTimeBarrier(observable, jArr));
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(final ObservableEmitter<List<T>> observableEmitter) {
        LiveStreamLogger.debugLog(TAG, "subscribeStart:" + this.barriers, new Object[0]);
        this.observableEmitter = observableEmitter;
        this.consumer = new Consumer<Long>() { // from class: com.yxcorp.livestream.longconnection.horserace.ObservableTimeBarrier.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Long l) {
                LiveStreamLogger.debugLog(ObservableTimeBarrier.TAG, "timer:" + l, new Object[0]);
                if (ObservableTimeBarrier.this.isComplete.get()) {
                    return;
                }
                synchronized (ObservableTimeBarrier.this.resultList) {
                    if (ObservableTimeBarrier.this.resultList.isEmpty()) {
                        if (ObservableTimeBarrier.this.currentBarrierIndex + 1 < ObservableTimeBarrier.this.barriers.length) {
                            LiveStreamLogger.debugLog(ObservableTimeBarrier.TAG, "nextTimer", new Object[0]);
                            long j = ObservableTimeBarrier.this.barriers[ObservableTimeBarrier.this.currentBarrierIndex];
                            ObservableTimeBarrier.this.currentBarrierIndex++;
                            Observable.timer(ObservableTimeBarrier.this.barriers[ObservableTimeBarrier.this.currentBarrierIndex] - j, TimeUnit.MILLISECONDS).doOnNext(ObservableTimeBarrier.this.consumer).subscribe();
                        } else {
                            LiveStreamLogger.debugLog(ObservableTimeBarrier.TAG, "outOfAllBarriers", new Object[0]);
                            ObservableTimeBarrier.this.isOutOfAllBarriers.set(true);
                        }
                    } else {
                        observableEmitter.onNext(ObservableTimeBarrier.this.resultList);
                        ObservableTimeBarrier.this.isComplete.set(true);
                        observableEmitter.onComplete();
                    }
                }
            }
        };
        long[] jArr = this.barriers;
        if (jArr.length > 0) {
            Observable.timer(jArr[this.currentBarrierIndex], TimeUnit.MILLISECONDS).doOnNext(this.consumer).subscribe();
        }
        this.source.forEach(new Consumer<Observable<T>>() { // from class: com.yxcorp.livestream.longconnection.horserace.ObservableTimeBarrier.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Observable<T> observable) {
                LiveStreamLogger.debugLog(ObservableTimeBarrier.TAG, "subscribeItem", new Object[0]);
                ObservableTimeBarrier.this.sourceCount++;
                observable.subscribe(ObservableTimeBarrier.this);
            }
        });
        LiveStreamLogger.debugLog(TAG, "subscribeEnd", new Object[0]);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (this.isComplete.get()) {
            return;
        }
        if (this.isOutOfAllBarriers.get()) {
            LiveStreamLogger.debugLog(TAG, "returnWhenOutOfAllBarriers", new Object[0]);
            synchronized (this.resultList) {
                if (!this.isComplete.get()) {
                    this.resultList.add(t);
                    this.observableEmitter.onNext(this.resultList);
                    this.isComplete.set(true);
                    this.observableEmitter.onComplete();
                }
            }
            return;
        }
        LiveStreamLogger.debugLog(TAG, "receiveResult", new Object[0]);
        this.resultList.add(t);
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (!this.isComplete.get()) {
            this.exceptions.add(th);
        }
        errorOrCompleteIfNeed();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.isComplete.get()) {
            return;
        }
        errorOrCompleteIfNeed();
    }

    final void errorOrCompleteIfNeed() {
        if (this.observableEmitter.isDisposed()) {
            return;
        }
        synchronized (this.resultList) {
            if (this.resultList.size() + this.exceptions.size() == this.sourceCount) {
                if (this.resultList.isEmpty()) {
                    this.observableEmitter.onError(new AllNodeFailedException(this.exceptions));
                } else {
                    this.observableEmitter.onNext(this.resultList);
                    this.isComplete.set(true);
                    this.observableEmitter.onComplete();
                }
            }
        }
    }
}
