package com.yxcorp.livestream.longconnection.horserace;

import com.kuaishou.android.live.model.Horse;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import io.reactivex.Single;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface RacePolicy {
    void cancelRace();

    Single<HorseRunner> selectWinner(List<Horse> list, LongConnectionParams longConnectionParams);

    void selectWinnerCompleted();
}
