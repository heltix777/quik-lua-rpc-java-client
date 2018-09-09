package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyLimitPbSerdeTest {

    private static SerdeModule sut;

    private static MoneyLimit expectedObject;
    private static byte[] expectedPbInput;

    private static MoneyLimit expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = MoneyLimit.builder()
                .currCode("1")
                .tag("2")
                .firmId("3")
                .clientCode("4")
                .openBal("5")
                .openLimit("6")
                .currentBal("7")
                .currentLimit("8")
                .locked("9")
                .lockedValueCoef("10")
                .lockedMarginValue("11")
                .leverage("12")
                .limitKind(13)
                .build();
        expectedPbInput = QluaStructures.MoneyLimit.newBuilder()
                .setCurrcode("1")
                .setTag("2")
                .setFirmid("3")
                .setClientCode("4")
                .setOpenbal("5")
                .setOpenlimit("6")
                .setCurrentbal("7")
                .setCurrentlimit("8")
                .setLocked("9")
                .setLockedValueCoef("10")
                .setLockedMarginValue("11")
                .setLeverage("12")
                .setLimitKind(13)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = MoneyLimit.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.MoneyLimit.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(MoneyLimit.class, expectedPbInput));
    }

    @Test
    public void testSerialize_WithOnlyRequiredFields() {

        assertTrue(
                Arrays.equals(
                        expectedPbInputWithOnlyRequiredFields,
                        sut.serialize(expectedObjectWithOnlyRequiredFields)
                )
        );
    }

    @Test
    public void testDeserialize_WithOnlyRequiredFields() {

        assertEquals(
                expectedObjectWithOnlyRequiredFields,
                sut.deserialize(MoneyLimit.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
