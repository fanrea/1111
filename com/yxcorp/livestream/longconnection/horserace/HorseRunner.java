package com.yxcorp.livestream.longconnection.horserace;

import android.util.Log;
import com.kuaishou.android.live.model.Horse;
import com.kuaishou.common.async.KwaiSchedulers;
import com.yxcorp.livestream.longconnection.LiveFeedConnection;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class HorseRunner {
    private static final String TAG = "LiveSocket";
    public LiveFeedConnection mConnection;
    public final LongConnectionParams mConnectionParams;
    boolean mHasStop;
    public final Horse mHorse;

    public HorseRunner(Horse horse, LongConnectionParams longConnectionParams) {
        this.mHorse = horse;
        this.mConnectionParams = longConnectionParams.m1515clone();
    }

    public Observable<HorseRunner> race() {
        LiveStreamLogger.debugLog(TAG, "HorseRunner race", new Object[0]);
        this.mHorse.mStartTime = System.currentTimeMillis();
        this.mConnection = new LiveFeedConnection();
        return this.mConnection.horseRace(this.mConnectionParams, this.mHorse).doOnError(new Consumer<Throwable>() { // from class: com.yxcorp.livestream.longconnection.horserace.HorseRunner.3
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                LiveStreamLogger.debugLog(HorseRunner.TAG, "HorseRunner onError, hasStop" + HorseRunner.this.mHasStop, Log.getStackTraceString(th));
                if (HorseRunner.this.mHasStop) {
                    return;
                }
                HorseRunner.this.mHorse.mCost = System.currentTimeMillis() - HorseRunner.this.mHorse.mStartTime;
                HorseRunner.this.mHorse.mErrorDescription = Log.getStackTraceString(th);
            }
        }).map(new Function<LiveFeedConnection, HorseRunner>() { // from class: com.yxcorp.livestream.longconnection.horserace.HorseRunner.2
            @Override // io.reactivex.functions.Function
            public HorseRunner apply(LiveFeedConnection liveFeedConnection) {
                if (!HorseRunner.this.mHasStop) {
                    HorseRunner.this.mHorse.mCost = System.currentTimeMillis() - HorseRunner.this.mHorse.mStartTime;
                }
                return HorseRunner.this;
            }
        }).doOnNext(new Consumer<HorseRunner>() { // from class: com.yxcorp.livestream.longconnection.horserace.HorseRunner.1
            @Override // io.reactivex.functions.Consumer
            public void accept(HorseRunner horseRunner) {
                KwaiSchedulers.UPLOAD.scheduleDirect(new Runnable() { // from class: com.yxcorp.livestream.longconnection.horserace.HorseRunner.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveStreamLogger.debugLog(HorseRunner.TAG, "HorseRunner raceReturn", "mHasStop:" + HorseRunner.this.mHasStop, "mHorse: " + HorseRunner.this.mHorse, "ServerUriInfo: " + HorseRunner.this.mConnection.getCurrentServerUriInfo());
                    }
                });
            }
        });
    }

    public void stop() {
        this.mHasStop = true;
        if (this.mHorse.mCost == 0) {
            this.mHorse.mCost = System.currentTimeMillis() - this.mHorse.mStartTime;
        }
        LiveFeedConnection liveFeedConnection = this.mConnection;
        if (liveFeedConnection != null) {
            liveFeedConnection.horseRaceLoss();
            this.mConnection.exitQuietly();
        }
        LiveStreamLogger.debugLog(TAG, "HorseRunner stop, " + this.mHorse, new Object[0]);
    }
}
