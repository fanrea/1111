package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveGuide extends MessageNano {
    private static volatile InteractiveGuide[] _emptyArray;
    public UserInfos.PicUrl[] background;
    public String biz;
    public int bizGroup;
    public InteractiveGuide[] children;
    public String clickAction;
    public Map<String, InteractiveGuideInfo> customUserGuideInfo;
    public boolean displayImmediately;
    public InteractiveGuideDisplayInfo displayInfo;
    public long displayMs;
    public String extParam;
    public InteractiveGuideInfo guideInfo;
    public InteractiveGuideInfo guideInfoNext;
    public int guideOccurrences;
    public String id;
    public boolean infiniteShowTimes;
    public InteractiveGuideIntroductionInfo introductionInfo;
    public String logExtra;
    public int priority;

    public static InteractiveGuide[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveGuide[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveGuide() {
        clear();
    }

    public final InteractiveGuide clear() {
        this.id = "";
        this.biz = "";
        this.introductionInfo = null;
        this.displayInfo = null;
        this.guideInfo = null;
        this.displayMs = 0L;
        this.background = UserInfos.PicUrl.emptyArray();
        this.clickAction = "";
        this.priority = 0;
        this.extParam = "";
        this.guideOccurrences = 0;
        this.customUserGuideInfo = null;
        this.displayImmediately = false;
        this.infiniteShowTimes = false;
        this.children = emptyArray();
        this.guideInfoNext = null;
        this.bizGroup = 0;
        this.logExtra = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.id);
        }
        if (!this.biz.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.biz);
        }
        InteractiveGuideIntroductionInfo interactiveGuideIntroductionInfo = this.introductionInfo;
        if (interactiveGuideIntroductionInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, interactiveGuideIntroductionInfo);
        }
        InteractiveGuideDisplayInfo interactiveGuideDisplayInfo = this.displayInfo;
        if (interactiveGuideDisplayInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, interactiveGuideDisplayInfo);
        }
        InteractiveGuideInfo interactiveGuideInfo = this.guideInfo;
        if (interactiveGuideInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, interactiveGuideInfo);
        }
        long j = this.displayMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        UserInfos.PicUrl[] picUrlArr = this.background;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.background;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl);
                }
                i2++;
            }
        }
        if (!this.clickAction.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.clickAction);
        }
        int i3 = this.priority;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i3);
        }
        if (!this.extParam.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.extParam);
        }
        int i4 = this.guideOccurrences;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i4);
        }
        Map<String, InteractiveGuideInfo> map = this.customUserGuideInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 12, 9, 11);
        }
        boolean z = this.displayImmediately;
        if (z) {
            codedOutputByteBufferNano.writeBool(13, z);
        }
        boolean z2 = this.infiniteShowTimes;
        if (z2) {
            codedOutputByteBufferNano.writeBool(15, z2);
        }
        InteractiveGuide[] interactiveGuideArr = this.children;
        if (interactiveGuideArr != null && interactiveGuideArr.length > 0) {
            while (true) {
                InteractiveGuide[] interactiveGuideArr2 = this.children;
                if (i >= interactiveGuideArr2.length) {
                    break;
                }
                InteractiveGuide interactiveGuide = interactiveGuideArr2[i];
                if (interactiveGuide != null) {
                    codedOutputByteBufferNano.writeMessage(16, interactiveGuide);
                }
                i++;
            }
        }
        InteractiveGuideInfo interactiveGuideInfo2 = this.guideInfoNext;
        if (interactiveGuideInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(17, interactiveGuideInfo2);
        }
        int i5 = this.bizGroup;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i5);
        }
        if (!this.logExtra.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.logExtra);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
        }
        if (!this.biz.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.biz);
        }
        InteractiveGuideIntroductionInfo interactiveGuideIntroductionInfo = this.introductionInfo;
        if (interactiveGuideIntroductionInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, interactiveGuideIntroductionInfo);
        }
        InteractiveGuideDisplayInfo interactiveGuideDisplayInfo = this.displayInfo;
        if (interactiveGuideDisplayInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, interactiveGuideDisplayInfo);
        }
        InteractiveGuideInfo interactiveGuideInfo = this.guideInfo;
        if (interactiveGuideInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, interactiveGuideInfo);
        }
        long j = this.displayMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        UserInfos.PicUrl[] picUrlArr = this.background;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.background;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(7, picUrl);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.clickAction.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.clickAction);
        }
        int i3 = this.priority;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i3);
        }
        if (!this.extParam.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.extParam);
        }
        int i4 = this.guideOccurrences;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i4);
        }
        Map<String, InteractiveGuideInfo> map = this.customUserGuideInfo;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 12, 9, 11);
        }
        boolean z = this.displayImmediately;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z);
        }
        boolean z2 = this.infiniteShowTimes;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z2);
        }
        InteractiveGuide[] interactiveGuideArr = this.children;
        if (interactiveGuideArr != null && interactiveGuideArr.length > 0) {
            while (true) {
                InteractiveGuide[] interactiveGuideArr2 = this.children;
                if (i >= interactiveGuideArr2.length) {
                    break;
                }
                InteractiveGuide interactiveGuide = interactiveGuideArr2[i];
                if (interactiveGuide != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, interactiveGuide);
                }
                i++;
            }
        }
        InteractiveGuideInfo interactiveGuideInfo2 = this.guideInfoNext;
        if (interactiveGuideInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, interactiveGuideInfo2);
        }
        int i5 = this.bizGroup;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i5);
        }
        return !this.logExtra.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(19, this.logExtra) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveGuide mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.id = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.biz = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    if (this.introductionInfo == null) {
                        this.introductionInfo = new InteractiveGuideIntroductionInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.introductionInfo);
                    break;
                case 34:
                    if (this.displayInfo == null) {
                        this.displayInfo = new InteractiveGuideDisplayInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.displayInfo);
                    break;
                case 42:
                    if (this.guideInfo == null) {
                        this.guideInfo = new InteractiveGuideInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.guideInfo);
                    break;
                case 48:
                    this.displayMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    UserInfos.PicUrl[] picUrlArr = this.background;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.background, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.background = picUrlArr2;
                    break;
                case 66:
                    this.clickAction = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.priority = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.extParam = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.guideOccurrences = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.customUserGuideInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.customUserGuideInfo, mapFactory, 9, 11, new InteractiveGuideInfo(), 10, 18);
                    break;
                case 104:
                    this.displayImmediately = codedInputByteBufferNano.readBool();
                    break;
                case 120:
                    this.infiniteShowTimes = codedInputByteBufferNano.readBool();
                    break;
                case 130:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                    InteractiveGuide[] interactiveGuideArr = this.children;
                    int length2 = interactiveGuideArr == null ? 0 : interactiveGuideArr.length;
                    InteractiveGuide[] interactiveGuideArr2 = new InteractiveGuide[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.children, 0, interactiveGuideArr2, 0, length2);
                    }
                    while (length2 < interactiveGuideArr2.length - 1) {
                        interactiveGuideArr2[length2] = new InteractiveGuide();
                        codedInputByteBufferNano.readMessage(interactiveGuideArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    interactiveGuideArr2[length2] = new InteractiveGuide();
                    codedInputByteBufferNano.readMessage(interactiveGuideArr2[length2]);
                    this.children = interactiveGuideArr2;
                    break;
                case 138:
                    if (this.guideInfoNext == null) {
                        this.guideInfoNext = new InteractiveGuideInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.guideInfoNext);
                    break;
                case 144:
                    this.bizGroup = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.logExtra = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static InteractiveGuide parseFrom(byte[] bArr) {
        return (InteractiveGuide) MessageNano.mergeFrom(new InteractiveGuide(), bArr);
    }

    public static InteractiveGuide parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveGuide().mergeFrom(codedInputByteBufferNano);
    }
}
