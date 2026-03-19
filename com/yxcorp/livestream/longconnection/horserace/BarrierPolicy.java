package com.yxcorp.livestream.longconnection.horserace;

import android.util.Log;
import com.kuaishou.android.live.model.Horse;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class BarrierPolicy implements RacePolicy {
    private static final String TAG = "BarrierPolicy";
    public final long[] mBarriers;
    private List<HorseRunner> mHorseRunners;
    private boolean mNeedStopRunnerOnConsumer;
    public final long mTimeout;

    public BarrierPolicy(long[] jArr, long j, boolean z) {
        this.mBarriers = jArr;
        this.mTimeout = j;
        this.mNeedStopRunnerOnConsumer = z;
        for (long j2 : this.mBarriers) {
            if (j2 > this.mTimeout) {
                throw new IllegalArgumentException("barrier can not be larger than timeout");
            }
        }
    }

    @Override // com.yxcorp.livestream.longconnection.horserace.RacePolicy
    public Single<HorseRunner> selectWinner(final List<Horse> list, final LongConnectionParams longConnectionParams) {
        this.mHorseRunners = new ArrayList();
        return ObservableTimeBarrier.from(Observable.fromIterable(list).map(new Function<Horse, Observable<HorseRunner>>() { // from class: com.yxcorp.livestream.longconnection.horserace.BarrierPolicy.3
            @Override // io.reactivex.functions.Function
            public Observable<HorseRunner> apply(Horse horse) {
                HorseRunner horseRunner = new HorseRunner(horse, longConnectionParams);
                BarrierPolicy.this.mHorseRunners.add(horseRunner);
                return horseRunner.race();
            }
        }), this.mBarriers).observeOn(AndroidSchedulers.mainThread()).flatMapSingle(new Function<Collection<HorseRunner>, SingleSource<HorseRunner>>() { // from class: com.yxcorp.livestream.longconnection.horserace.BarrierPolicy.2
            @Override // io.reactivex.functions.Function
            public SingleSource<HorseRunner> apply(Collection<HorseRunner> collection) {
                if (LiveStreamLogger.isDebug()) {
                    LiveStreamLogger.debugLog(BarrierPolicy.TAG, "onBarrierReturn", "data", collection);
                }
                for (Horse horse : list) {
                    for (HorseRunner horseRunner : collection) {
                        horseRunner.mHorse.mSuccess = true;
                        if (horseRunner.mHorse.equals(horse)) {
                            horseRunner.mHorse.mChosen = true;
                            BarrierPolicy.this.mHorseRunners.remove(horseRunner);
                            if (BarrierPolicy.this.mNeedStopRunnerOnConsumer) {
                                Iterator it = BarrierPolicy.this.mHorseRunners.iterator();
                                while (it.hasNext()) {
                                    ((HorseRunner) it.next()).stop();
                                }
                                BarrierPolicy.this.mHorseRunners.clear();
                                BarrierPolicy.this.mHorseRunners.add(horseRunner);
                            }
                            return Single.just(horseRunner);
                        }
                    }
                }
                throw new IllegalStateException("horse not in round");
            }
        }).timeout(this.mTimeout, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).doOnError(new Consumer<Throwable>() { // from class: com.yxcorp.livestream.longconnection.horserace.BarrierPolicy.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                if (BarrierPolicy.this.mNeedStopRunnerOnConsumer) {
                    Iterator it = BarrierPolicy.this.mHorseRunners.iterator();
                    while (it.hasNext()) {
                        ((HorseRunner) it.next()).stop();
                    }
                    BarrierPolicy.this.mHorseRunners.clear();
                }
                LiveStreamLogger.debugLog(BarrierPolicy.TAG, "closeAllRunner", "error", Log.getStackTraceString(th));
            }
        }).firstOrError();
    }

    @Override // com.yxcorp.livestream.longconnection.horserace.RacePolicy
    public void cancelRace() {
        List<HorseRunner> list = this.mHorseRunners;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.mHorseRunners.size() > i) {
                    this.mHorseRunners.get(i).stop();
                }
            }
            this.mHorseRunners.clear();
        }
    }

    @Override // com.yxcorp.livestream.longconnection.horserace.RacePolicy
    public void selectWinnerCompleted() {
        this.mHorseRunners.clear();
    }
}
