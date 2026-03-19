package com.kuaishou.common.async;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class BatchProcess {
    public static <T> void concurrentRunTasksWithPostProcess(T[] tArr, Consumer<T> consumer, Runnable runnable, Runnable runnable2) {
        if (tArr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            arrayList.add(Observable.just(t).observeOn(Schedulers.from(Async.getCacheThreadPoolExecutor())).doOnNext(consumer));
        }
        mergeDelayError(arrayList, new Consumer<T>() { // from class: com.kuaishou.common.async.BatchProcess.1
            @Override // io.reactivex.functions.Consumer
            public void accept(T t2) {
            }
        }, runnable, runnable2);
    }

    public static <T> void mergeDelayError(List<Observable<T>> list, Consumer<T> consumer, final Runnable runnable, Runnable runnable2) {
        if (list.size() > 0) {
            Observable.mergeDelayError(list, list.size()).subscribe(consumer, new Consumer<Throwable>() { // from class: com.kuaishou.common.async.BatchProcess.2
                @Override // io.reactivex.functions.Consumer
                public void accept(Throwable th) {
                    runnable.run();
                }
            }, new Action() { // from class: com.kuaishou.common.async.BatchProcess.3
                @Override // io.reactivex.functions.Action
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable2.run();
        }
    }
}
