package com.duoyou.task.sdk.entity;

import android.net.Uri;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class GameInfo implements Serializable {
    private static final long serialVersionUID = -1415847662747418981L;
    public int bottomHeight;
    public String downloadUrl;
    public String gameIcon;
    public String gameId;
    public String gameName;
    public String jsonString;
    public String playUrl;
    public String taskParams;

    public static GameInfo builder(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("playUrl");
            String strOptString2 = jSONObject.optString("gameName");
            String strOptString3 = jSONObject.optString("gameIcon");
            String strOptString4 = jSONObject.optString("downloadUrl");
            String strOptString5 = jSONObject.optString("taskParams");
            int iOptInt = jSONObject.optInt("bottomHeight");
            Uri uri = Uri.parse(strOptString);
            GameInfo gameInfo = new GameInfo();
            gameInfo.gameId = uri.getQueryParameter("game_id");
            gameInfo.gameName = strOptString2;
            gameInfo.gameIcon = strOptString3;
            gameInfo.downloadUrl = strOptString4;
            gameInfo.playUrl = strOptString;
            gameInfo.taskParams = strOptString5;
            gameInfo.bottomHeight = iOptInt;
            gameInfo.jsonString = str;
            return gameInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
