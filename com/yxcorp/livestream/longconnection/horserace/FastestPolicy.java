package com.yxcorp.livestream.longconnection.horserace;

import android.util.Log;
import com.kuaishou.android.live.model.Horse;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class FastestPolicy implements RacePolicy {
    private static final String TAG = "FastestPolicy";
    private List<HorseRunner> mHorseRunners;
    private boolean mNeedStopRunnerOnConsumer;
    public final long mTimeout;

    public FastestPolicy(long j, boolean z) {
        this.mTimeout = j;
        this.mNeedStopRunnerOnConsumer = z;
    }

    @Override // com.yxcorp.livestream.longconnection.horserace.RacePolicy
    public Single<HorseRunner> selectWinner(List<Horse> list, final LongConnectionParams longConnectionParams) {
        this.mHorseRunners = new ArrayList();
        return ObservableTimeBarrier.from(Observable.fromIterable(list).observeOn(AndroidSchedulers.mainThread()).map(new Function<Horse, Observable<HorseRunner>>() { // from class: com.yxcorp.livestream.longconnection.horserace.FastestPolicy.4
            @Override // io.reactivex.functions.Function
            public Observable<HorseRunner> apply(Horse horse) {
                HorseRunner horseRunner = new HorseRunner(horse, longConnectionParams);
                FastestPolicy.this.mHorseRunners.add(horseRunner);
                return horseRunner.race();
            }
        }), new long[]{0}).flatMap(new Function<List<HorseRunner>, ObservableSource<HorseRunner>>() { // from class: com.yxcorp.livestream.longconnection.horserace.FastestPolicy.3
            @Override // io.reactivex.functions.Function
            public ObservableSource<HorseRunner> apply(List<HorseRunner> list2) {
                return Observable.just(list2.get(0));
            }
        }).firstOrError().observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new Consumer<HorseRunner>() { // from class: com.yxcorp.livestream.longconnection.horserace.FastestPolicy.2
            @Override // io.reactivex.functions.Consumer
            public void accept(HorseRunner horseRunner) {
                LiveStreamLogger.debugLog(FastestPolicy.TAG, "raceSuccess, " + horseRunner.mHorse, new Object[0]);
                horseRunner.mHorse.mSuccess = true;
                horseRunner.mHorse.mChosen = true;
                if (FastestPolicy.this.mNeedStopRunnerOnConsumer) {
                    FastestPolicy.this.mHorseRunners.remove(horseRunner);
                    Iterator it = FastestPolicy.this.mHorseRunners.iterator();
                    while (it.hasNext()) {
                        ((HorseRunner) it.next()).stop();
                    }
                    FastestPolicy.this.mHorseRunners.clear();
                    FastestPolicy.this.mHorseRunners.add(horseRunner);
                }
            }
        }).timeout(this.mTimeout, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).doOnError(new Consumer<Throwable>() { // from class: com.yxcorp.livestream.longconnection.horserace.FastestPolicy.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                if (FastestPolicy.this.mNeedStopRunnerOnConsumer) {
                    Iterator it = FastestPolicy.this.mHorseRunners.iterator();
                    while (it.hasNext()) {
                        ((HorseRunner) it.next()).stop();
                    }
                    FastestPolicy.this.mHorseRunners.clear();
                }
                LiveStreamLogger.debugLog(FastestPolicy.TAG, "closeAllRunner", "error", Log.getStackTraceString(th));
            }
        });
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
