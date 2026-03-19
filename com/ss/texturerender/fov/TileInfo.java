package com.ss.texturerender.fov;

import android.util.Pair;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TileInfo {
    int backgroundTileHeightCount;
    int backgroundTileWidthCount;
    int dstTileHeightCount;
    int dstTileWidthCount;
    LinkedList<Pair<Integer, Integer>> mappedBackgroundIndexPairs;
    LinkedList<Pair<Integer, Integer>> mappedOverlayIndexPairs;
    float normalizedBackgroundTileHeight;
    float normalizedBackgroundTileWidth;
    float normalizedDstTileHeight;
    float normalizedDstTileWidth;
    float normalizedSrcTileHeight;
    float normalizedSrcTileWidth;
    public int paddingY;
    int srcTileHeightCount;
    int srcTileWidthCount;
    int streamIndex;
    int tileHeight;
    int tileWidth;
    JSONArray visibleArray;

    public static TileInfo create(String str) throws JSONException {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                TileInfo tileInfo = new TileInfo();
                tileInfo.streamIndex = jSONObject.getInt("stream_index");
                tileInfo.tileWidth = jSONObject.getInt("tile_width");
                tileInfo.tileHeight = jSONObject.getInt("tile_height");
                tileInfo.srcTileWidthCount = jSONObject.getInt("tile_width_count");
                int i = jSONObject.getInt("tile_height_count");
                tileInfo.srcTileHeightCount = i;
                tileInfo.normalizedSrcTileWidth = 1.0f / tileInfo.srcTileWidthCount;
                tileInfo.normalizedSrcTileHeight = 1.0f / i;
                tileInfo.dstTileWidthCount = jSONObject.getInt("source_tile_width_count");
                int i2 = jSONObject.getInt("source_tile_height_count");
                tileInfo.dstTileHeightCount = i2;
                tileInfo.normalizedDstTileWidth = 1.0f / tileInfo.dstTileWidthCount;
                tileInfo.normalizedDstTileHeight = 1.0f / i2;
                tileInfo.visibleArray = jSONObject.getJSONArray("tile_visible");
                tileInfo.backgroundTileWidthCount = jSONObject.getInt("bg_tile_width_count");
                int i3 = jSONObject.getInt("bg_tile_height_count");
                tileInfo.backgroundTileHeightCount = i3;
                tileInfo.normalizedBackgroundTileWidth = 1.0f / tileInfo.backgroundTileWidthCount;
                tileInfo.normalizedBackgroundTileHeight = 1.0f / i3;
                tileInfo.paddingY = tileInfo.tileHeight % tileInfo.tileWidth;
                LinkedList<Pair<Integer, Integer>> linkedList = new LinkedList<>();
                LinkedList<Pair<Integer, Integer>> linkedList2 = new LinkedList<>();
                int i4 = tileInfo.backgroundTileWidthCount * tileInfo.backgroundTileHeightCount;
                for (int i5 = 0; i5 < tileInfo.visibleArray.length(); i5++) {
                    int i6 = tileInfo.visibleArray.getInt(i5);
                    if (i6 >= 0) {
                        if (i5 < i4) {
                            linkedList.add(new Pair<>(Integer.valueOf(i5), Integer.valueOf(i6)));
                        } else {
                            linkedList2.add(new Pair<>(Integer.valueOf(i5), Integer.valueOf(i6 - i4)));
                        }
                    }
                }
                tileInfo.mappedBackgroundIndexPairs = linkedList;
                tileInfo.mappedOverlayIndexPairs = linkedList2;
                return tileInfo;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int getDecodedFrameWidth() {
        return this.tileWidth * this.srcTileWidthCount;
    }

    public int getDecodedFrameHeight() {
        return this.tileHeight * this.srcTileHeightCount;
    }

    public int getBackgroundTexWidth() {
        return this.tileWidth * this.backgroundTileWidthCount;
    }

    public int getBackgroundTexHeight() {
        return this.tileHeight * this.backgroundTileHeightCount;
    }

    public boolean is3DInput() {
        return this.tileHeight >= this.tileWidth * 2;
    }
}
