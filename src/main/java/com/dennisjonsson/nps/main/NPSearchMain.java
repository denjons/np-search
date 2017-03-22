package com.dennisjonsson.nps.main;

import java.util.ArrayList;

public class NPSearchMain {

	public static void main(String[] args) {

		// long div = (long) Math.pow(93.0, 9.0);

		ArrayList<Long> values = new ArrayList<Long>();

		NumberPartition.encode(new String("hello you fool, you die!").toCharArray(), values, 0);

		System.out.println(NumberPartition.decodeArray(values));

	}

}
