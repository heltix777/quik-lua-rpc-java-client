package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalcBuySellRequestPbSerdeTest {

    private static SerdeModule sut;

    private static CalcBuySell.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = CalcBuySell.Request.builder()
                .classCode("1")
                .secCode("2")
                .clientCode("3")
                .account("4")
                .price("5")
                .isBuy(true)
                .isMarket(true)
                .build();
        final ByteString pbArgs = qlua.rpc.CalcBuySell.Request.newBuilder()
                .setClassCode("1")
                .setSecCode("2")
                .setClientCode("3")
                .setAccount("4")
                .setPrice("5")
                .setIsBuy(true)
                .setIsMarket(true)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.CALC_BUY_SELL)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final CalcBuySell.Request actualObject = sut.deserialize(CalcBuySell.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
