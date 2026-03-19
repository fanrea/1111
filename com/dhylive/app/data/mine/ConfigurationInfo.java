package com.dhylive.app.data.mine;

import com.alipay.sdk.m.k.b;
import com.baidu.mobads.container.config.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigurationInfo.kt */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0003\b\u0086\u0001\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bõ\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0005\u0012\u0006\u00102\u001a\u000203\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\b\u00109\u001a\u0004\u0018\u000103\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010<\u0012\u0006\u0010=\u001a\u00020\u0005\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010A\u001a\u00020\u0005¢\u0006\u0002\u0010BJ\n\u0010\u0085\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0001\u001a\u00020'HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u000203HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u000103HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0014\u0010¶\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010<HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u0003HÆ\u0003Jö\u0004\u0010À\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u0001032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010<2\b\b\u0002\u0010=\u001a\u00020\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010A\u001a\u00020\u0005HÆ\u0001¢\u0006\u0003\u0010Á\u0001J\u0017\u0010Â\u0001\u001a\u00030Ã\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001HÖ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010Ç\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001a\u00109\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u0018\u0010:\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010DR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010DR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010DR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010DR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010DR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010DR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010DR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010DR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010DR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010DR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010DR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010DR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010DR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010DR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010DR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010DR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010DR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010DR\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010DR\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010DR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010DR\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010DR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010DR\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010DR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010DR\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010DR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010DR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010DR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bd\u0010DR\u0016\u0010-\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010DR\u0011\u00106\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010DR\u0018\u0010>\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010DR\u0018\u0010?\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010DR\u0016\u0010=\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010DR\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010DR\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010DR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0011\u00104\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\br\u0010DR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010DR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010DR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010jR\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bv\u0010jR\u0011\u0010)\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bw\u0010jR\u0016\u0010,\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010jR \u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0016\u0010A\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010jR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b|\u0010DR\u0011\u00105\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010DR\u0016\u00107\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010DR\u0018\u00108\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010DR\u0017\u0010.\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010DR\u0017\u0010/\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010DR\u0017\u00100\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010DR\u0019\u0010@\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010DR\u0017\u00101\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010j¨\u0006È\u0001"}, d2 = {"Lcom/dhylive/app/data/mine/ConfigurationInfo;", "Ljava/io/Serializable;", "account_status", "", "ksVideoStatus", "", "ksAppId", "ksContentId", "adc_advertising_ad_id", "adc_advertising_ad_status", "adc_banner_ad_id", "adc_banner_ad_status", "adc_center_ad_id", "adc_center_ad_status", "adc_inters_ad_id", "adc_inters_ad_status", "adc_redraw_ad_id", "adc_redraw_ad_status", "adc_splash_ad_id", "adc_splash_ad_status", "adc_sign_ad_id", "priority", "adc_sigmob_app_id", "adc_sigmob_security_key_second", "adc_sigmob_banner_ad_id", "adc_sigmob_banner_ad_status", "adc_sigmob_center_ad_id", "adc_sigmob_center_ad_status", "adc_sigmob_inters_ad_status", "adc_sigmob_interstitial_ad_id", "adc_sigmob_redraw_ad_status", "adc_sigmob_reward_ad_id", "adc_sigmob_reward_ad_id_second", "adc_sigmob_splash_ad_id", "adc_sigmob_splash_ad_status", "adc_sigmob_native_ad_id", "adc_sigmob_sign_ad_id", "game_qq_group", "interstitial_ad_show", "Lcom/dhylive/app/data/mine/InterstitialAdShow;", "movie_free_num", "movie_num", "duomi_appid", "duomi_secret", "mustUpdate", "apkUrl", "updateTips", "versionName", "vipStatus", "yidunStatus", "jump_time", "", "jump_tips", "productId", "businessId", "shareChannel", "smsStatus", "adLoadTimeoutDuration", "adTimeoutHint", "payType", "", "csjShortDramaAdStatus", "csjAppId", "csjSecretKey", a.w, "previewMode", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/dhylive/app/data/mine/InterstitialAdShow;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAccount_status", "()Ljava/lang/String;", "getAdLoadTimeoutDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAdTimeoutHint", "getAdc_advertising_ad_id", "getAdc_advertising_ad_status", "getAdc_banner_ad_id", "getAdc_banner_ad_status", "getAdc_center_ad_id", "getAdc_center_ad_status", "getAdc_inters_ad_id", "getAdc_inters_ad_status", "getAdc_redraw_ad_id", "getAdc_redraw_ad_status", "getAdc_sigmob_app_id", "getAdc_sigmob_banner_ad_id", "getAdc_sigmob_banner_ad_status", "getAdc_sigmob_center_ad_id", "getAdc_sigmob_center_ad_status", "getAdc_sigmob_inters_ad_status", "getAdc_sigmob_interstitial_ad_id", "getAdc_sigmob_native_ad_id", "getAdc_sigmob_redraw_ad_status", "getAdc_sigmob_reward_ad_id", "getAdc_sigmob_reward_ad_id_second", "getAdc_sigmob_security_key_second", "getAdc_sigmob_sign_ad_id", "getAdc_sigmob_splash_ad_id", "getAdc_sigmob_splash_ad_status", "getAdc_sign_ad_id", "getAdc_splash_ad_id", "getAdc_splash_ad_status", "getApkUrl", "getBusinessId", "getCsjAppId", "getCsjSecretKey", "getCsjShortDramaAdStatus", "()I", "getDuomi_appid", "getDuomi_secret", "getGame_qq_group", "getInterstitial_ad_show", "()Lcom/dhylive/app/data/mine/InterstitialAdShow;", "getJump_time", "()J", "getJump_tips", "getKsAppId", "getKsContentId", "getKsVideoStatus", "getMovie_free_num", "getMovie_num", "getMustUpdate", "getPayType", "()Ljava/util/List;", "getPreviewMode", "getPriority", "getProductId", "getShareChannel", "getSmsStatus", "getUpdateTips", "getVersionName", "getVipStatus", "getWxAppid", "getYidunStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/dhylive/app/data/mine/InterstitialAdShow;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/dhylive/app/data/mine/ConfigurationInfo;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class ConfigurationInfo implements Serializable {
    private final String account_status;

    @SerializedName("ad_time_long")
    private final Long adLoadTimeoutDuration;

    @SerializedName("ad_lost_text")
    private final String adTimeoutHint;
    private final String adc_advertising_ad_id;
    private final String adc_advertising_ad_status;
    private final String adc_banner_ad_id;
    private final String adc_banner_ad_status;
    private final String adc_center_ad_id;
    private final String adc_center_ad_status;
    private final String adc_inters_ad_id;
    private final String adc_inters_ad_status;
    private final String adc_redraw_ad_id;
    private final String adc_redraw_ad_status;
    private final String adc_sigmob_app_id;
    private final String adc_sigmob_banner_ad_id;
    private final String adc_sigmob_banner_ad_status;
    private final String adc_sigmob_center_ad_id;
    private final String adc_sigmob_center_ad_status;
    private final String adc_sigmob_inters_ad_status;
    private final String adc_sigmob_interstitial_ad_id;
    private final String adc_sigmob_native_ad_id;
    private final String adc_sigmob_redraw_ad_status;
    private final String adc_sigmob_reward_ad_id;
    private final String adc_sigmob_reward_ad_id_second;
    private final String adc_sigmob_security_key_second;
    private final String adc_sigmob_sign_ad_id;
    private final String adc_sigmob_splash_ad_id;
    private final String adc_sigmob_splash_ad_status;
    private final String adc_sign_ad_id;
    private final String adc_splash_ad_id;
    private final String adc_splash_ad_status;

    @SerializedName("upload_apk")
    private final String apkUrl;
    private final String businessId;

    @SerializedName("adc_csj_app_id")
    private final String csjAppId;

    @SerializedName("csj_key")
    private final String csjSecretKey;

    @SerializedName("adc_csj_status")
    private final int csjShortDramaAdStatus;
    private final String duomi_appid;
    private final String duomi_secret;
    private final String game_qq_group;
    private final InterstitialAdShow interstitial_ad_show;
    private final long jump_time;
    private final String jump_tips;

    @SerializedName("adc_ks_app_id")
    private final String ksAppId;

    @SerializedName("adc_ks_content_id")
    private final String ksContentId;

    @SerializedName("adc_ks_status")
    private final int ksVideoStatus;
    private final int movie_free_num;
    private final int movie_num;

    @SerializedName("is_must_update")
    private final int mustUpdate;

    @SerializedName("pay_type")
    private final List<String> payType;

    @SerializedName("version_status")
    private final int previewMode;
    private final String priority;
    private final String productId;

    @SerializedName("index_share")
    private final String shareChannel;

    @SerializedName("sms_status")
    private final String smsStatus;

    @SerializedName("version_tips")
    private final String updateTips;

    @SerializedName("app_version")
    private final String versionName;

    @SerializedName("vip_status")
    private final String vipStatus;

    @SerializedName(b.D0)
    private final String wxAppid;

    @SerializedName("yidun_status")
    private final int yidunStatus;

    /* renamed from: component1, reason: from getter */
    public final String getAccount_status() {
        return this.account_status;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAdc_center_ad_status() {
        return this.adc_center_ad_status;
    }

    /* renamed from: component11, reason: from getter */
    public final String getAdc_inters_ad_id() {
        return this.adc_inters_ad_id;
    }

    /* renamed from: component12, reason: from getter */
    public final String getAdc_inters_ad_status() {
        return this.adc_inters_ad_status;
    }

    /* renamed from: component13, reason: from getter */
    public final String getAdc_redraw_ad_id() {
        return this.adc_redraw_ad_id;
    }

    /* renamed from: component14, reason: from getter */
    public final String getAdc_redraw_ad_status() {
        return this.adc_redraw_ad_status;
    }

    /* renamed from: component15, reason: from getter */
    public final String getAdc_splash_ad_id() {
        return this.adc_splash_ad_id;
    }

    /* renamed from: component16, reason: from getter */
    public final String getAdc_splash_ad_status() {
        return this.adc_splash_ad_status;
    }

    /* renamed from: component17, reason: from getter */
    public final String getAdc_sign_ad_id() {
        return this.adc_sign_ad_id;
    }

    /* renamed from: component18, reason: from getter */
    public final String getPriority() {
        return this.priority;
    }

    /* renamed from: component19, reason: from getter */
    public final String getAdc_sigmob_app_id() {
        return this.adc_sigmob_app_id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getKsVideoStatus() {
        return this.ksVideoStatus;
    }

    /* renamed from: component20, reason: from getter */
    public final String getAdc_sigmob_security_key_second() {
        return this.adc_sigmob_security_key_second;
    }

    /* renamed from: component21, reason: from getter */
    public final String getAdc_sigmob_banner_ad_id() {
        return this.adc_sigmob_banner_ad_id;
    }

    /* renamed from: component22, reason: from getter */
    public final String getAdc_sigmob_banner_ad_status() {
        return this.adc_sigmob_banner_ad_status;
    }

    /* renamed from: component23, reason: from getter */
    public final String getAdc_sigmob_center_ad_id() {
        return this.adc_sigmob_center_ad_id;
    }

    /* renamed from: component24, reason: from getter */
    public final String getAdc_sigmob_center_ad_status() {
        return this.adc_sigmob_center_ad_status;
    }

    /* renamed from: component25, reason: from getter */
    public final String getAdc_sigmob_inters_ad_status() {
        return this.adc_sigmob_inters_ad_status;
    }

    /* renamed from: component26, reason: from getter */
    public final String getAdc_sigmob_interstitial_ad_id() {
        return this.adc_sigmob_interstitial_ad_id;
    }

    /* renamed from: component27, reason: from getter */
    public final String getAdc_sigmob_redraw_ad_status() {
        return this.adc_sigmob_redraw_ad_status;
    }

    /* renamed from: component28, reason: from getter */
    public final String getAdc_sigmob_reward_ad_id() {
        return this.adc_sigmob_reward_ad_id;
    }

    /* renamed from: component29, reason: from getter */
    public final String getAdc_sigmob_reward_ad_id_second() {
        return this.adc_sigmob_reward_ad_id_second;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKsAppId() {
        return this.ksAppId;
    }

    /* renamed from: component30, reason: from getter */
    public final String getAdc_sigmob_splash_ad_id() {
        return this.adc_sigmob_splash_ad_id;
    }

    /* renamed from: component31, reason: from getter */
    public final String getAdc_sigmob_splash_ad_status() {
        return this.adc_sigmob_splash_ad_status;
    }

    /* renamed from: component32, reason: from getter */
    public final String getAdc_sigmob_native_ad_id() {
        return this.adc_sigmob_native_ad_id;
    }

    /* renamed from: component33, reason: from getter */
    public final String getAdc_sigmob_sign_ad_id() {
        return this.adc_sigmob_sign_ad_id;
    }

    /* renamed from: component34, reason: from getter */
    public final String getGame_qq_group() {
        return this.game_qq_group;
    }

    /* renamed from: component35, reason: from getter */
    public final InterstitialAdShow getInterstitial_ad_show() {
        return this.interstitial_ad_show;
    }

    /* renamed from: component36, reason: from getter */
    public final int getMovie_free_num() {
        return this.movie_free_num;
    }

    /* renamed from: component37, reason: from getter */
    public final int getMovie_num() {
        return this.movie_num;
    }

    /* renamed from: component38, reason: from getter */
    public final String getDuomi_appid() {
        return this.duomi_appid;
    }

    /* renamed from: component39, reason: from getter */
    public final String getDuomi_secret() {
        return this.duomi_secret;
    }

    /* renamed from: component4, reason: from getter */
    public final String getKsContentId() {
        return this.ksContentId;
    }

    /* renamed from: component40, reason: from getter */
    public final int getMustUpdate() {
        return this.mustUpdate;
    }

    /* renamed from: component41, reason: from getter */
    public final String getApkUrl() {
        return this.apkUrl;
    }

    /* renamed from: component42, reason: from getter */
    public final String getUpdateTips() {
        return this.updateTips;
    }

    /* renamed from: component43, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component44, reason: from getter */
    public final String getVipStatus() {
        return this.vipStatus;
    }

    /* renamed from: component45, reason: from getter */
    public final int getYidunStatus() {
        return this.yidunStatus;
    }

    /* renamed from: component46, reason: from getter */
    public final long getJump_time() {
        return this.jump_time;
    }

    /* renamed from: component47, reason: from getter */
    public final String getJump_tips() {
        return this.jump_tips;
    }

    /* renamed from: component48, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: component49, reason: from getter */
    public final String getBusinessId() {
        return this.businessId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAdc_advertising_ad_id() {
        return this.adc_advertising_ad_id;
    }

    /* renamed from: component50, reason: from getter */
    public final String getShareChannel() {
        return this.shareChannel;
    }

    /* renamed from: component51, reason: from getter */
    public final String getSmsStatus() {
        return this.smsStatus;
    }

    /* renamed from: component52, reason: from getter */
    public final Long getAdLoadTimeoutDuration() {
        return this.adLoadTimeoutDuration;
    }

    /* renamed from: component53, reason: from getter */
    public final String getAdTimeoutHint() {
        return this.adTimeoutHint;
    }

    public final List<String> component54() {
        return this.payType;
    }

    /* renamed from: component55, reason: from getter */
    public final int getCsjShortDramaAdStatus() {
        return this.csjShortDramaAdStatus;
    }

    /* renamed from: component56, reason: from getter */
    public final String getCsjAppId() {
        return this.csjAppId;
    }

    /* renamed from: component57, reason: from getter */
    public final String getCsjSecretKey() {
        return this.csjSecretKey;
    }

    /* renamed from: component58, reason: from getter */
    public final String getWxAppid() {
        return this.wxAppid;
    }

    /* renamed from: component59, reason: from getter */
    public final int getPreviewMode() {
        return this.previewMode;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAdc_advertising_ad_status() {
        return this.adc_advertising_ad_status;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAdc_banner_ad_id() {
        return this.adc_banner_ad_id;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAdc_banner_ad_status() {
        return this.adc_banner_ad_status;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAdc_center_ad_id() {
        return this.adc_center_ad_id;
    }

    public final ConfigurationInfo copy(String account_status, int ksVideoStatus, String ksAppId, String ksContentId, String adc_advertising_ad_id, String adc_advertising_ad_status, String adc_banner_ad_id, String adc_banner_ad_status, String adc_center_ad_id, String adc_center_ad_status, String adc_inters_ad_id, String adc_inters_ad_status, String adc_redraw_ad_id, String adc_redraw_ad_status, String adc_splash_ad_id, String adc_splash_ad_status, String adc_sign_ad_id, String priority, String adc_sigmob_app_id, String adc_sigmob_security_key_second, String adc_sigmob_banner_ad_id, String adc_sigmob_banner_ad_status, String adc_sigmob_center_ad_id, String adc_sigmob_center_ad_status, String adc_sigmob_inters_ad_status, String adc_sigmob_interstitial_ad_id, String adc_sigmob_redraw_ad_status, String adc_sigmob_reward_ad_id, String adc_sigmob_reward_ad_id_second, String adc_sigmob_splash_ad_id, String adc_sigmob_splash_ad_status, String adc_sigmob_native_ad_id, String adc_sigmob_sign_ad_id, String game_qq_group, InterstitialAdShow interstitial_ad_show, int movie_free_num, int movie_num, String duomi_appid, String duomi_secret, int mustUpdate, String apkUrl, String updateTips, String versionName, String vipStatus, int yidunStatus, long jump_time, String jump_tips, String productId, String businessId, String shareChannel, String smsStatus, Long adLoadTimeoutDuration, String adTimeoutHint, List<String> payType, int csjShortDramaAdStatus, String csjAppId, String csjSecretKey, String wxAppid, int previewMode) {
        Intrinsics.checkNotNullParameter(account_status, "account_status");
        Intrinsics.checkNotNullParameter(ksAppId, "ksAppId");
        Intrinsics.checkNotNullParameter(ksContentId, "ksContentId");
        Intrinsics.checkNotNullParameter(adc_advertising_ad_id, "adc_advertising_ad_id");
        Intrinsics.checkNotNullParameter(adc_advertising_ad_status, "adc_advertising_ad_status");
        Intrinsics.checkNotNullParameter(adc_banner_ad_id, "adc_banner_ad_id");
        Intrinsics.checkNotNullParameter(adc_banner_ad_status, "adc_banner_ad_status");
        Intrinsics.checkNotNullParameter(adc_center_ad_id, "adc_center_ad_id");
        Intrinsics.checkNotNullParameter(adc_center_ad_status, "adc_center_ad_status");
        Intrinsics.checkNotNullParameter(adc_inters_ad_id, "adc_inters_ad_id");
        Intrinsics.checkNotNullParameter(adc_inters_ad_status, "adc_inters_ad_status");
        Intrinsics.checkNotNullParameter(adc_redraw_ad_id, "adc_redraw_ad_id");
        Intrinsics.checkNotNullParameter(adc_redraw_ad_status, "adc_redraw_ad_status");
        Intrinsics.checkNotNullParameter(adc_splash_ad_id, "adc_splash_ad_id");
        Intrinsics.checkNotNullParameter(adc_splash_ad_status, "adc_splash_ad_status");
        Intrinsics.checkNotNullParameter(adc_sign_ad_id, "adc_sign_ad_id");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(adc_sigmob_app_id, "adc_sigmob_app_id");
        Intrinsics.checkNotNullParameter(adc_sigmob_security_key_second, "adc_sigmob_security_key_second");
        Intrinsics.checkNotNullParameter(adc_sigmob_banner_ad_id, "adc_sigmob_banner_ad_id");
        Intrinsics.checkNotNullParameter(adc_sigmob_banner_ad_status, "adc_sigmob_banner_ad_status");
        Intrinsics.checkNotNullParameter(adc_sigmob_center_ad_id, "adc_sigmob_center_ad_id");
        Intrinsics.checkNotNullParameter(adc_sigmob_center_ad_status, "adc_sigmob_center_ad_status");
        Intrinsics.checkNotNullParameter(adc_sigmob_inters_ad_status, "adc_sigmob_inters_ad_status");
        Intrinsics.checkNotNullParameter(adc_sigmob_interstitial_ad_id, "adc_sigmob_interstitial_ad_id");
        Intrinsics.checkNotNullParameter(adc_sigmob_redraw_ad_status, "adc_sigmob_redraw_ad_status");
        Intrinsics.checkNotNullParameter(adc_sigmob_reward_ad_id, "adc_sigmob_reward_ad_id");
        Intrinsics.checkNotNullParameter(adc_sigmob_reward_ad_id_second, "adc_sigmob_reward_ad_id_second");
        Intrinsics.checkNotNullParameter(adc_sigmob_splash_ad_id, "adc_sigmob_splash_ad_id");
        Intrinsics.checkNotNullParameter(adc_sigmob_splash_ad_status, "adc_sigmob_splash_ad_status");
        Intrinsics.checkNotNullParameter(adc_sigmob_sign_ad_id, "adc_sigmob_sign_ad_id");
        Intrinsics.checkNotNullParameter(game_qq_group, "game_qq_group");
        Intrinsics.checkNotNullParameter(interstitial_ad_show, "interstitial_ad_show");
        Intrinsics.checkNotNullParameter(duomi_appid, "duomi_appid");
        Intrinsics.checkNotNullParameter(duomi_secret, "duomi_secret");
        Intrinsics.checkNotNullParameter(apkUrl, "apkUrl");
        Intrinsics.checkNotNullParameter(updateTips, "updateTips");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(vipStatus, "vipStatus");
        Intrinsics.checkNotNullParameter(jump_tips, "jump_tips");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(shareChannel, "shareChannel");
        return new ConfigurationInfo(account_status, ksVideoStatus, ksAppId, ksContentId, adc_advertising_ad_id, adc_advertising_ad_status, adc_banner_ad_id, adc_banner_ad_status, adc_center_ad_id, adc_center_ad_status, adc_inters_ad_id, adc_inters_ad_status, adc_redraw_ad_id, adc_redraw_ad_status, adc_splash_ad_id, adc_splash_ad_status, adc_sign_ad_id, priority, adc_sigmob_app_id, adc_sigmob_security_key_second, adc_sigmob_banner_ad_id, adc_sigmob_banner_ad_status, adc_sigmob_center_ad_id, adc_sigmob_center_ad_status, adc_sigmob_inters_ad_status, adc_sigmob_interstitial_ad_id, adc_sigmob_redraw_ad_status, adc_sigmob_reward_ad_id, adc_sigmob_reward_ad_id_second, adc_sigmob_splash_ad_id, adc_sigmob_splash_ad_status, adc_sigmob_native_ad_id, adc_sigmob_sign_ad_id, game_qq_group, interstitial_ad_show, movie_free_num, movie_num, duomi_appid, duomi_secret, mustUpdate, apkUrl, updateTips, versionName, vipStatus, yidunStatus, jump_time, jump_tips, productId, businessId, shareChannel, smsStatus, adLoadTimeoutDuration, adTimeoutHint, payType, csjShortDramaAdStatus, csjAppId, csjSecretKey, wxAppid, previewMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigurationInfo)) {
            return false;
        }
        ConfigurationInfo configurationInfo = (ConfigurationInfo) other;
        return Intrinsics.areEqual(this.account_status, configurationInfo.account_status) && this.ksVideoStatus == configurationInfo.ksVideoStatus && Intrinsics.areEqual(this.ksAppId, configurationInfo.ksAppId) && Intrinsics.areEqual(this.ksContentId, configurationInfo.ksContentId) && Intrinsics.areEqual(this.adc_advertising_ad_id, configurationInfo.adc_advertising_ad_id) && Intrinsics.areEqual(this.adc_advertising_ad_status, configurationInfo.adc_advertising_ad_status) && Intrinsics.areEqual(this.adc_banner_ad_id, configurationInfo.adc_banner_ad_id) && Intrinsics.areEqual(this.adc_banner_ad_status, configurationInfo.adc_banner_ad_status) && Intrinsics.areEqual(this.adc_center_ad_id, configurationInfo.adc_center_ad_id) && Intrinsics.areEqual(this.adc_center_ad_status, configurationInfo.adc_center_ad_status) && Intrinsics.areEqual(this.adc_inters_ad_id, configurationInfo.adc_inters_ad_id) && Intrinsics.areEqual(this.adc_inters_ad_status, configurationInfo.adc_inters_ad_status) && Intrinsics.areEqual(this.adc_redraw_ad_id, configurationInfo.adc_redraw_ad_id) && Intrinsics.areEqual(this.adc_redraw_ad_status, configurationInfo.adc_redraw_ad_status) && Intrinsics.areEqual(this.adc_splash_ad_id, configurationInfo.adc_splash_ad_id) && Intrinsics.areEqual(this.adc_splash_ad_status, configurationInfo.adc_splash_ad_status) && Intrinsics.areEqual(this.adc_sign_ad_id, configurationInfo.adc_sign_ad_id) && Intrinsics.areEqual(this.priority, configurationInfo.priority) && Intrinsics.areEqual(this.adc_sigmob_app_id, configurationInfo.adc_sigmob_app_id) && Intrinsics.areEqual(this.adc_sigmob_security_key_second, configurationInfo.adc_sigmob_security_key_second) && Intrinsics.areEqual(this.adc_sigmob_banner_ad_id, configurationInfo.adc_sigmob_banner_ad_id) && Intrinsics.areEqual(this.adc_sigmob_banner_ad_status, configurationInfo.adc_sigmob_banner_ad_status) && Intrinsics.areEqual(this.adc_sigmob_center_ad_id, configurationInfo.adc_sigmob_center_ad_id) && Intrinsics.areEqual(this.adc_sigmob_center_ad_status, configurationInfo.adc_sigmob_center_ad_status) && Intrinsics.areEqual(this.adc_sigmob_inters_ad_status, configurationInfo.adc_sigmob_inters_ad_status) && Intrinsics.areEqual(this.adc_sigmob_interstitial_ad_id, configurationInfo.adc_sigmob_interstitial_ad_id) && Intrinsics.areEqual(this.adc_sigmob_redraw_ad_status, configurationInfo.adc_sigmob_redraw_ad_status) && Intrinsics.areEqual(this.adc_sigmob_reward_ad_id, configurationInfo.adc_sigmob_reward_ad_id) && Intrinsics.areEqual(this.adc_sigmob_reward_ad_id_second, configurationInfo.adc_sigmob_reward_ad_id_second) && Intrinsics.areEqual(this.adc_sigmob_splash_ad_id, configurationInfo.adc_sigmob_splash_ad_id) && Intrinsics.areEqual(this.adc_sigmob_splash_ad_status, configurationInfo.adc_sigmob_splash_ad_status) && Intrinsics.areEqual(this.adc_sigmob_native_ad_id, configurationInfo.adc_sigmob_native_ad_id) && Intrinsics.areEqual(this.adc_sigmob_sign_ad_id, configurationInfo.adc_sigmob_sign_ad_id) && Intrinsics.areEqual(this.game_qq_group, configurationInfo.game_qq_group) && Intrinsics.areEqual(this.interstitial_ad_show, configurationInfo.interstitial_ad_show) && this.movie_free_num == configurationInfo.movie_free_num && this.movie_num == configurationInfo.movie_num && Intrinsics.areEqual(this.duomi_appid, configurationInfo.duomi_appid) && Intrinsics.areEqual(this.duomi_secret, configurationInfo.duomi_secret) && this.mustUpdate == configurationInfo.mustUpdate && Intrinsics.areEqual(this.apkUrl, configurationInfo.apkUrl) && Intrinsics.areEqual(this.updateTips, configurationInfo.updateTips) && Intrinsics.areEqual(this.versionName, configurationInfo.versionName) && Intrinsics.areEqual(this.vipStatus, configurationInfo.vipStatus) && this.yidunStatus == configurationInfo.yidunStatus && this.jump_time == configurationInfo.jump_time && Intrinsics.areEqual(this.jump_tips, configurationInfo.jump_tips) && Intrinsics.areEqual(this.productId, configurationInfo.productId) && Intrinsics.areEqual(this.businessId, configurationInfo.businessId) && Intrinsics.areEqual(this.shareChannel, configurationInfo.shareChannel) && Intrinsics.areEqual(this.smsStatus, configurationInfo.smsStatus) && Intrinsics.areEqual(this.adLoadTimeoutDuration, configurationInfo.adLoadTimeoutDuration) && Intrinsics.areEqual(this.adTimeoutHint, configurationInfo.adTimeoutHint) && Intrinsics.areEqual(this.payType, configurationInfo.payType) && this.csjShortDramaAdStatus == configurationInfo.csjShortDramaAdStatus && Intrinsics.areEqual(this.csjAppId, configurationInfo.csjAppId) && Intrinsics.areEqual(this.csjSecretKey, configurationInfo.csjSecretKey) && Intrinsics.areEqual(this.wxAppid, configurationInfo.wxAppid) && this.previewMode == configurationInfo.previewMode;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.account_status.hashCode() * 31) + Integer.hashCode(this.ksVideoStatus)) * 31) + this.ksAppId.hashCode()) * 31) + this.ksContentId.hashCode()) * 31) + this.adc_advertising_ad_id.hashCode()) * 31) + this.adc_advertising_ad_status.hashCode()) * 31) + this.adc_banner_ad_id.hashCode()) * 31) + this.adc_banner_ad_status.hashCode()) * 31) + this.adc_center_ad_id.hashCode()) * 31) + this.adc_center_ad_status.hashCode()) * 31) + this.adc_inters_ad_id.hashCode()) * 31) + this.adc_inters_ad_status.hashCode()) * 31) + this.adc_redraw_ad_id.hashCode()) * 31) + this.adc_redraw_ad_status.hashCode()) * 31) + this.adc_splash_ad_id.hashCode()) * 31) + this.adc_splash_ad_status.hashCode()) * 31) + this.adc_sign_ad_id.hashCode()) * 31) + this.priority.hashCode()) * 31) + this.adc_sigmob_app_id.hashCode()) * 31) + this.adc_sigmob_security_key_second.hashCode()) * 31) + this.adc_sigmob_banner_ad_id.hashCode()) * 31) + this.adc_sigmob_banner_ad_status.hashCode()) * 31) + this.adc_sigmob_center_ad_id.hashCode()) * 31) + this.adc_sigmob_center_ad_status.hashCode()) * 31) + this.adc_sigmob_inters_ad_status.hashCode()) * 31) + this.adc_sigmob_interstitial_ad_id.hashCode()) * 31) + this.adc_sigmob_redraw_ad_status.hashCode()) * 31) + this.adc_sigmob_reward_ad_id.hashCode()) * 31) + this.adc_sigmob_reward_ad_id_second.hashCode()) * 31) + this.adc_sigmob_splash_ad_id.hashCode()) * 31) + this.adc_sigmob_splash_ad_status.hashCode()) * 31;
        String str = this.adc_sigmob_native_ad_id;
        int iHashCode2 = (((((((((((((((((((((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.adc_sigmob_sign_ad_id.hashCode()) * 31) + this.game_qq_group.hashCode()) * 31) + this.interstitial_ad_show.hashCode()) * 31) + Integer.hashCode(this.movie_free_num)) * 31) + Integer.hashCode(this.movie_num)) * 31) + this.duomi_appid.hashCode()) * 31) + this.duomi_secret.hashCode()) * 31) + Integer.hashCode(this.mustUpdate)) * 31) + this.apkUrl.hashCode()) * 31) + this.updateTips.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.vipStatus.hashCode()) * 31) + Integer.hashCode(this.yidunStatus)) * 31) + Long.hashCode(this.jump_time)) * 31) + this.jump_tips.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.businessId.hashCode()) * 31) + this.shareChannel.hashCode()) * 31;
        String str2 = this.smsStatus;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.adLoadTimeoutDuration;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.adTimeoutHint;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.payType;
        int iHashCode6 = (((iHashCode5 + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.csjShortDramaAdStatus)) * 31;
        String str4 = this.csjAppId;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.csjSecretKey;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.wxAppid;
        return ((iHashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31) + Integer.hashCode(this.previewMode);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigurationInfo(account_status=").append(this.account_status).append(", ksVideoStatus=").append(this.ksVideoStatus).append(", ksAppId=").append(this.ksAppId).append(", ksContentId=").append(this.ksContentId).append(", adc_advertising_ad_id=").append(this.adc_advertising_ad_id).append(", adc_advertising_ad_status=").append(this.adc_advertising_ad_status).append(", adc_banner_ad_id=").append(this.adc_banner_ad_id).append(", adc_banner_ad_status=").append(this.adc_banner_ad_status).append(", adc_center_ad_id=").append(this.adc_center_ad_id).append(", adc_center_ad_status=").append(this.adc_center_ad_status).append(", adc_inters_ad_id=").append(this.adc_inters_ad_id).append(", adc_inters_ad_status=");
        sb.append(this.adc_inters_ad_status).append(", adc_redraw_ad_id=").append(this.adc_redraw_ad_id).append(", adc_redraw_ad_status=").append(this.adc_redraw_ad_status).append(", adc_splash_ad_id=").append(this.adc_splash_ad_id).append(", adc_splash_ad_status=").append(this.adc_splash_ad_status).append(", adc_sign_ad_id=").append(this.adc_sign_ad_id).append(", priority=").append(this.priority).append(", adc_sigmob_app_id=").append(this.adc_sigmob_app_id).append(", adc_sigmob_security_key_second=").append(this.adc_sigmob_security_key_second).append(", adc_sigmob_banner_ad_id=").append(this.adc_sigmob_banner_ad_id).append(", adc_sigmob_banner_ad_status=").append(this.adc_sigmob_banner_ad_status).append(", adc_sigmob_center_ad_id=").append(this.adc_sigmob_center_ad_id);
        sb.append(", adc_sigmob_center_ad_status=").append(this.adc_sigmob_center_ad_status).append(", adc_sigmob_inters_ad_status=").append(this.adc_sigmob_inters_ad_status).append(", adc_sigmob_interstitial_ad_id=").append(this.adc_sigmob_interstitial_ad_id).append(", adc_sigmob_redraw_ad_status=").append(this.adc_sigmob_redraw_ad_status).append(", adc_sigmob_reward_ad_id=").append(this.adc_sigmob_reward_ad_id).append(", adc_sigmob_reward_ad_id_second=").append(this.adc_sigmob_reward_ad_id_second).append(", adc_sigmob_splash_ad_id=").append(this.adc_sigmob_splash_ad_id).append(", adc_sigmob_splash_ad_status=").append(this.adc_sigmob_splash_ad_status).append(", adc_sigmob_native_ad_id=").append(this.adc_sigmob_native_ad_id).append(", adc_sigmob_sign_ad_id=").append(this.adc_sigmob_sign_ad_id).append(", game_qq_group=").append(this.game_qq_group).append(", interstitial_ad_show=");
        sb.append(this.interstitial_ad_show).append(", movie_free_num=").append(this.movie_free_num).append(", movie_num=").append(this.movie_num).append(", duomi_appid=").append(this.duomi_appid).append(", duomi_secret=").append(this.duomi_secret).append(", mustUpdate=").append(this.mustUpdate).append(", apkUrl=").append(this.apkUrl).append(", updateTips=").append(this.updateTips).append(", versionName=").append(this.versionName).append(", vipStatus=").append(this.vipStatus).append(", yidunStatus=").append(this.yidunStatus).append(", jump_time=").append(this.jump_time);
        sb.append(", jump_tips=").append(this.jump_tips).append(", productId=").append(this.productId).append(", businessId=").append(this.businessId).append(", shareChannel=").append(this.shareChannel).append(", smsStatus=").append(this.smsStatus).append(", adLoadTimeoutDuration=").append(this.adLoadTimeoutDuration).append(", adTimeoutHint=").append(this.adTimeoutHint).append(", payType=").append(this.payType).append(", csjShortDramaAdStatus=").append(this.csjShortDramaAdStatus).append(", csjAppId=").append(this.csjAppId).append(", csjSecretKey=").append(this.csjSecretKey).append(", wxAppid=");
        sb.append(this.wxAppid).append(", previewMode=").append(this.previewMode).append(')');
        return sb.toString();
    }

    public ConfigurationInfo(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, InterstitialAdShow interstitialAdShow, int i2, int i3, String str34, String str35, int i4, String str36, String str37, String str38, String str39, int i5, long j, String str40, String str41, String str42, String str43, String str44, Long l, String str45, List<String> list, int i6, String str46, String str47, String str48, int i7) {
        Intrinsics.checkNotNullParameter(str, "account_status");
        Intrinsics.checkNotNullParameter(str2, "ksAppId");
        Intrinsics.checkNotNullParameter(str3, "ksContentId");
        Intrinsics.checkNotNullParameter(str4, "adc_advertising_ad_id");
        Intrinsics.checkNotNullParameter(str5, "adc_advertising_ad_status");
        Intrinsics.checkNotNullParameter(str6, "adc_banner_ad_id");
        Intrinsics.checkNotNullParameter(str7, "adc_banner_ad_status");
        Intrinsics.checkNotNullParameter(str8, "adc_center_ad_id");
        Intrinsics.checkNotNullParameter(str9, "adc_center_ad_status");
        Intrinsics.checkNotNullParameter(str10, "adc_inters_ad_id");
        Intrinsics.checkNotNullParameter(str11, "adc_inters_ad_status");
        Intrinsics.checkNotNullParameter(str12, "adc_redraw_ad_id");
        Intrinsics.checkNotNullParameter(str13, "adc_redraw_ad_status");
        Intrinsics.checkNotNullParameter(str14, "adc_splash_ad_id");
        Intrinsics.checkNotNullParameter(str15, "adc_splash_ad_status");
        Intrinsics.checkNotNullParameter(str16, "adc_sign_ad_id");
        Intrinsics.checkNotNullParameter(str17, "priority");
        Intrinsics.checkNotNullParameter(str18, "adc_sigmob_app_id");
        Intrinsics.checkNotNullParameter(str19, "adc_sigmob_security_key_second");
        Intrinsics.checkNotNullParameter(str20, "adc_sigmob_banner_ad_id");
        Intrinsics.checkNotNullParameter(str21, "adc_sigmob_banner_ad_status");
        Intrinsics.checkNotNullParameter(str22, "adc_sigmob_center_ad_id");
        Intrinsics.checkNotNullParameter(str23, "adc_sigmob_center_ad_status");
        Intrinsics.checkNotNullParameter(str24, "adc_sigmob_inters_ad_status");
        Intrinsics.checkNotNullParameter(str25, "adc_sigmob_interstitial_ad_id");
        Intrinsics.checkNotNullParameter(str26, "adc_sigmob_redraw_ad_status");
        Intrinsics.checkNotNullParameter(str27, "adc_sigmob_reward_ad_id");
        Intrinsics.checkNotNullParameter(str28, "adc_sigmob_reward_ad_id_second");
        Intrinsics.checkNotNullParameter(str29, "adc_sigmob_splash_ad_id");
        Intrinsics.checkNotNullParameter(str30, "adc_sigmob_splash_ad_status");
        Intrinsics.checkNotNullParameter(str32, "adc_sigmob_sign_ad_id");
        Intrinsics.checkNotNullParameter(str33, "game_qq_group");
        Intrinsics.checkNotNullParameter(interstitialAdShow, "interstitial_ad_show");
        Intrinsics.checkNotNullParameter(str34, "duomi_appid");
        Intrinsics.checkNotNullParameter(str35, "duomi_secret");
        Intrinsics.checkNotNullParameter(str36, "apkUrl");
        Intrinsics.checkNotNullParameter(str37, "updateTips");
        Intrinsics.checkNotNullParameter(str38, "versionName");
        Intrinsics.checkNotNullParameter(str39, "vipStatus");
        Intrinsics.checkNotNullParameter(str40, "jump_tips");
        Intrinsics.checkNotNullParameter(str41, "productId");
        Intrinsics.checkNotNullParameter(str42, "businessId");
        Intrinsics.checkNotNullParameter(str43, "shareChannel");
        this.account_status = str;
        this.ksVideoStatus = i;
        this.ksAppId = str2;
        this.ksContentId = str3;
        this.adc_advertising_ad_id = str4;
        this.adc_advertising_ad_status = str5;
        this.adc_banner_ad_id = str6;
        this.adc_banner_ad_status = str7;
        this.adc_center_ad_id = str8;
        this.adc_center_ad_status = str9;
        this.adc_inters_ad_id = str10;
        this.adc_inters_ad_status = str11;
        this.adc_redraw_ad_id = str12;
        this.adc_redraw_ad_status = str13;
        this.adc_splash_ad_id = str14;
        this.adc_splash_ad_status = str15;
        this.adc_sign_ad_id = str16;
        this.priority = str17;
        this.adc_sigmob_app_id = str18;
        this.adc_sigmob_security_key_second = str19;
        this.adc_sigmob_banner_ad_id = str20;
        this.adc_sigmob_banner_ad_status = str21;
        this.adc_sigmob_center_ad_id = str22;
        this.adc_sigmob_center_ad_status = str23;
        this.adc_sigmob_inters_ad_status = str24;
        this.adc_sigmob_interstitial_ad_id = str25;
        this.adc_sigmob_redraw_ad_status = str26;
        this.adc_sigmob_reward_ad_id = str27;
        this.adc_sigmob_reward_ad_id_second = str28;
        this.adc_sigmob_splash_ad_id = str29;
        this.adc_sigmob_splash_ad_status = str30;
        this.adc_sigmob_native_ad_id = str31;
        this.adc_sigmob_sign_ad_id = str32;
        this.game_qq_group = str33;
        this.interstitial_ad_show = interstitialAdShow;
        this.movie_free_num = i2;
        this.movie_num = i3;
        this.duomi_appid = str34;
        this.duomi_secret = str35;
        this.mustUpdate = i4;
        this.apkUrl = str36;
        this.updateTips = str37;
        this.versionName = str38;
        this.vipStatus = str39;
        this.yidunStatus = i5;
        this.jump_time = j;
        this.jump_tips = str40;
        this.productId = str41;
        this.businessId = str42;
        this.shareChannel = str43;
        this.smsStatus = str44;
        this.adLoadTimeoutDuration = l;
        this.adTimeoutHint = str45;
        this.payType = list;
        this.csjShortDramaAdStatus = i6;
        this.csjAppId = str46;
        this.csjSecretKey = str47;
        this.wxAppid = str48;
        this.previewMode = i7;
    }

    public final String getAccount_status() {
        return this.account_status;
    }

    public final int getKsVideoStatus() {
        return this.ksVideoStatus;
    }

    public final String getKsAppId() {
        return this.ksAppId;
    }

    public final String getKsContentId() {
        return this.ksContentId;
    }

    public final String getAdc_advertising_ad_id() {
        return this.adc_advertising_ad_id;
    }

    public final String getAdc_advertising_ad_status() {
        return this.adc_advertising_ad_status;
    }

    public final String getAdc_banner_ad_id() {
        return this.adc_banner_ad_id;
    }

    public final String getAdc_banner_ad_status() {
        return this.adc_banner_ad_status;
    }

    public final String getAdc_center_ad_id() {
        return this.adc_center_ad_id;
    }

    public final String getAdc_center_ad_status() {
        return this.adc_center_ad_status;
    }

    public final String getAdc_inters_ad_id() {
        return this.adc_inters_ad_id;
    }

    public final String getAdc_inters_ad_status() {
        return this.adc_inters_ad_status;
    }

    public final String getAdc_redraw_ad_id() {
        return this.adc_redraw_ad_id;
    }

    public final String getAdc_redraw_ad_status() {
        return this.adc_redraw_ad_status;
    }

    public final String getAdc_splash_ad_id() {
        return this.adc_splash_ad_id;
    }

    public final String getAdc_splash_ad_status() {
        return this.adc_splash_ad_status;
    }

    public final String getAdc_sign_ad_id() {
        return this.adc_sign_ad_id;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final String getAdc_sigmob_app_id() {
        return this.adc_sigmob_app_id;
    }

    public final String getAdc_sigmob_security_key_second() {
        return this.adc_sigmob_security_key_second;
    }

    public final String getAdc_sigmob_banner_ad_id() {
        return this.adc_sigmob_banner_ad_id;
    }

    public final String getAdc_sigmob_banner_ad_status() {
        return this.adc_sigmob_banner_ad_status;
    }

    public final String getAdc_sigmob_center_ad_id() {
        return this.adc_sigmob_center_ad_id;
    }

    public final String getAdc_sigmob_center_ad_status() {
        return this.adc_sigmob_center_ad_status;
    }

    public final String getAdc_sigmob_inters_ad_status() {
        return this.adc_sigmob_inters_ad_status;
    }

    public final String getAdc_sigmob_interstitial_ad_id() {
        return this.adc_sigmob_interstitial_ad_id;
    }

    public final String getAdc_sigmob_redraw_ad_status() {
        return this.adc_sigmob_redraw_ad_status;
    }

    public final String getAdc_sigmob_reward_ad_id() {
        return this.adc_sigmob_reward_ad_id;
    }

    public final String getAdc_sigmob_reward_ad_id_second() {
        return this.adc_sigmob_reward_ad_id_second;
    }

    public final String getAdc_sigmob_splash_ad_id() {
        return this.adc_sigmob_splash_ad_id;
    }

    public final String getAdc_sigmob_splash_ad_status() {
        return this.adc_sigmob_splash_ad_status;
    }

    public final String getAdc_sigmob_native_ad_id() {
        return this.adc_sigmob_native_ad_id;
    }

    public final String getAdc_sigmob_sign_ad_id() {
        return this.adc_sigmob_sign_ad_id;
    }

    public final String getGame_qq_group() {
        return this.game_qq_group;
    }

    public final InterstitialAdShow getInterstitial_ad_show() {
        return this.interstitial_ad_show;
    }

    public final int getMovie_free_num() {
        return this.movie_free_num;
    }

    public final int getMovie_num() {
        return this.movie_num;
    }

    public final String getDuomi_appid() {
        return this.duomi_appid;
    }

    public final String getDuomi_secret() {
        return this.duomi_secret;
    }

    public final int getMustUpdate() {
        return this.mustUpdate;
    }

    public final String getApkUrl() {
        return this.apkUrl;
    }

    public final String getUpdateTips() {
        return this.updateTips;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getVipStatus() {
        return this.vipStatus;
    }

    public final int getYidunStatus() {
        return this.yidunStatus;
    }

    public final long getJump_time() {
        return this.jump_time;
    }

    public final String getJump_tips() {
        return this.jump_tips;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getShareChannel() {
        return this.shareChannel;
    }

    public final String getSmsStatus() {
        return this.smsStatus;
    }

    public final Long getAdLoadTimeoutDuration() {
        return this.adLoadTimeoutDuration;
    }

    public final String getAdTimeoutHint() {
        return this.adTimeoutHint;
    }

    public final List<String> getPayType() {
        return this.payType;
    }

    public final int getCsjShortDramaAdStatus() {
        return this.csjShortDramaAdStatus;
    }

    public final String getCsjAppId() {
        return this.csjAppId;
    }

    public final String getCsjSecretKey() {
        return this.csjSecretKey;
    }

    public final String getWxAppid() {
        return this.wxAppid;
    }

    public final int getPreviewMode() {
        return this.previewMode;
    }
}
