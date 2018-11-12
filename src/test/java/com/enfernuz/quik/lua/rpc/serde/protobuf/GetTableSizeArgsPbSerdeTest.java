package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetTableSizeArgsPbSerdeTest extends AbstractPbSerializationTest<GetTableSize.Args, qlua.rpc.GetTableSize.Request> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Serializer<GetTableSize.Args> getSerializerUnderTest() {
        return GetTableSizeArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetTableSize.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.GetTableSize.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @NotNull
    @Override
    public GetTableSize.Args getTargetObject() {
        return new GetTableSize.Args(T_ID);
    }
}
