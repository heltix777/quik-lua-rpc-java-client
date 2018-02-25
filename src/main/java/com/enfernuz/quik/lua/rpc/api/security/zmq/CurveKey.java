package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.Strings;
import zmq.util.Z85;

import java.util.Arrays;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class CurveKey {

    private final String z85Form;
    private final byte[] binaryForm;

    public static CurveKey fromString(final String z85String) {

        checkArgument(
                !Strings.isNullOrEmpty(z85String),
                "The argument \"z85String\" must not be null or an empty string."
        );

        checkArgument(
                z85String.length() == 40,
                "The argument \"z85String\" must be a 40-character Z85-encoded string."
        );

        return new CurveKey(z85String, Z85.decode(z85String));
    }

    public static CurveKey fromBinary(final byte[] binaryForm) {

        final byte[] copyBinaryForm = binaryForm.clone();

        return new CurveKey(Z85.encode(copyBinaryForm, copyBinaryForm.length), copyBinaryForm);
    }

    private CurveKey(final String z85Form, final byte[] binaryForm) {

        this.z85Form = z85Form;
        this.binaryForm = binaryForm;
    }

    public String asZ85String() {
        return z85Form;
    }

    public byte[] asBinary() {
        return binaryForm.clone();
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof CurveKey) ) {
            return false;
        } else {
            final CurveKey other = (CurveKey) o;
            return Arrays.equals(binaryForm, other.binaryForm) && Objects.equals(z85Form, other.z85Form);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(z85Form, binaryForm);
    }

    @Override
    public String toString() {
        return z85Form;
    }
}