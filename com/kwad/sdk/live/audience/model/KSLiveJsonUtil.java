package com.kwad.sdk.live.audience.model;

import com.kuaishou.android.live.model.Horse;
import com.kuaishou.android.live.model.Race;
import com.kuaishou.android.live.model.Round;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveJsonUtil {
    public static List<String> parseStringListFromJson(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    public static long[] parseLongArrayFromJson(JSONArray jSONArray) {
        int length = jSONArray.length();
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = jSONArray.optLong(i);
        }
        return jArr;
    }

    public static Race parseRaceFromJson(JSONObject jSONObject) {
        Race race = new Race();
        race.mTag = jSONObject.optString("tag");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rounds");
        if (jSONArrayOptJSONArray != null) {
            race.mRounds = parseRounds(jSONArrayOptJSONArray);
        }
        return race;
    }

    private static List<Round> parseRounds(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                Round round = new Round();
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("horses");
                if (jSONArrayOptJSONArray != null) {
                    round.mHorses = parseHorses(jSONArrayOptJSONArray);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("barriers");
                if (jSONArrayOptJSONArray2 != null) {
                    round.mBarriers = parseLongArrayFromJson(jSONArrayOptJSONArray2);
                }
                round.mTimeout = jSONObjectOptJSONObject.optLong("timeout", round.mTimeout);
                round.mPolicy = jSONObjectOptJSONObject.optInt("policy", round.mPolicy);
                round.mTag = jSONObjectOptJSONObject.optString("tag");
                round.mSuccess = jSONObjectOptJSONObject.optBoolean("success");
                round.mStartTime = jSONObjectOptJSONObject.optLong("startTime");
                round.mCost = jSONObjectOptJSONObject.optLong("cost");
                arrayList.add(round);
            }
        }
        return arrayList;
    }

    private static List<Horse> parseHorses(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                Horse horse = new Horse();
                horse.mHostAndPort = jSONObjectOptJSONObject.optString("hostAndPort");
                horse.mTag = jSONObjectOptJSONObject.optString("tag");
                arrayList.add(horse);
            }
        }
        return arrayList;
    }
}
