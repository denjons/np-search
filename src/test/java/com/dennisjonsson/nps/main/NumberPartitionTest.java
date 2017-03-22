package com.dennisjonsson.nps.main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class NumberPartitionTest {

	@Test
	public void shortTest() {

		String str = "a";
		ArrayList<Long> values = new ArrayList<Long>();

		NumberPartition.encode(str.toCharArray(), values, 0);

		String result = NumberPartition.decodeArray(values);

		assertEquals(str, result);
	}

	@Test
	public void exactTest() {

		String str = "123456789";
		ArrayList<Long> values = new ArrayList<Long>();

		NumberPartition.encode(str.toCharArray(), values, 0);

		String result = NumberPartition.decodeArray(values);

		assertEquals(str, result);
	}

	@Test
	public void longStringTest() {

		String str = "hello you fool, you die!";
		ArrayList<Long> values = new ArrayList<Long>();

		NumberPartition.encode(str.toCharArray(), values, 0);

		String result = NumberPartition.decodeArray(values);

		assertEquals(str, result);
	}

	@Test
	public void longerStringTest() {

		String str = "hello you fool, you die!";
		ArrayList<Long> values = new ArrayList<Long>();

		NumberPartition.encode(str.toCharArray(), values, 0);

		String result = NumberPartition.decodeArray(values);

		assertEquals(str, result);
	}

}
