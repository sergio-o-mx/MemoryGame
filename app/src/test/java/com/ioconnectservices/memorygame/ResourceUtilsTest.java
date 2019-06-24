package com.ioconnectservices.memorygame;

import com.ioconnectservices.memorygame.utils.CardsUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ResourceUtilsTest {

    @Test
    public void testGetCardResource_success() {
        assertEquals(CardsUtils.getCardResource(0), R.mipmap.spade_01);
        assertEquals(CardsUtils.getCardResource(8), R.mipmap.spade_09);
    }

    @Test
    public void testGetCardResource_fail() {
        assertNotEquals(CardsUtils.getCardResource(0), R.mipmap.spade_02);
        assertNotEquals(CardsUtils.getCardResource(9), R.mipmap.spade_03);
    }
}
