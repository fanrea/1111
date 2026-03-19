package com.kwad.sdk.message;

import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveMessageCovert {
    public static List<LiveMessage> fromLiveMessage(LiveStreamMessages.SCFeedPush sCFeedPush) {
        ArrayList arrayList = new ArrayList();
        if (sCFeedPush.commentFeeds != null) {
            for (LiveStreamMessages.CommentFeed commentFeed : sCFeedPush.commentFeeds) {
                LiveMessage liveMessage = new LiveMessage();
                liveMessage.userName = commentFeed.user.userName;
                liveMessage.content = commentFeed.content;
                liveMessage.mSortRank = commentFeed.sortRank;
                arrayList.add(liveMessage);
            }
        }
        Collections.sort(arrayList, new Comparator<LiveMessage>() { // from class: com.kwad.sdk.message.LiveMessageCovert.1
            @Override // java.util.Comparator
            public int compare(LiveMessage liveMessage2, LiveMessage liveMessage3) {
                return (int) (liveMessage2.mSortRank - liveMessage3.mSortRank);
            }
        });
        return arrayList;
    }

    public static List<AdLiveMessageInfo> createSortedLiveMessage(LiveStreamMessages.SCFeedPush sCFeedPush) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (LiveMessage liveMessage : fromLiveMessage(sCFeedPush)) {
            AdLiveMessageInfo adLiveMessageInfo = new AdLiveMessageInfo();
            adLiveMessageInfo.userName = liveMessage.userName;
            adLiveMessageInfo.content = liveMessage.content;
            copyOnWriteArrayList.add(adLiveMessageInfo);
        }
        return copyOnWriteArrayList;
    }
}
