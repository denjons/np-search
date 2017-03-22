package com.dennisjonsson.nps.main;

import java.util.ArrayList;

public class NumberPartition {

	public static final long CHR = 93l;

	public static final long OFFSET = 31;

	public static final long LVL1 = Long.MAX_VALUE / CHR;
	public static final long LVL2 = Long.MAX_VALUE / (CHR * CHR);
	public static final long LVL3 = Long.MAX_VALUE / (CHR * CHR * CHR);
	public static final long LVL4 = Long.MAX_VALUE / (CHR * CHR * CHR * CHR);
	public static final long LVL5 = Long.MAX_VALUE / (CHR * CHR * CHR * CHR * CHR);
	public static final long LVL6 = Long.MAX_VALUE / (CHR * CHR * CHR * CHR * CHR * CHR);
	public static final long LVL7 = Long.MAX_VALUE / (CHR * CHR * CHR * CHR * CHR * CHR * CHR);
	public static final long LVL8 = Long.MAX_VALUE / (CHR * CHR * CHR * CHR * CHR * CHR * CHR * CHR);
	public static final long LVL9 = Long.MAX_VALUE / (CHR * CHR * CHR * CHR * CHR * CHR * CHR * CHR * CHR);

	public static final long[] levels = new long[] { LVL1, LVL2, LVL3, LVL4, LVL5, LVL6, LVL7, LVL8, LVL9 };

	public static void encode(char[] chars, ArrayList<Long> sums, int start) {

		// System.out.println("new call");

		if (start >= chars.length) {
			return;
		}

		long sum = 0;

		long ciel = Math.min(start + levels.length, chars.length);

		for (int i = start; i < ciel; i++) {
			long character = (long) chars[i] - OFFSET;
			sum += levels[i - start] * character;

			// System.out.println(sum + " += " + levels[i - start] + " * " +
			// (character) + ": ( "
			// + (levels[i - start] * character) + " )");
		}

		start += levels.length;

		sums.add(sum);

		encode(chars, sums, start);
	}

	public static String decodeArray(ArrayList<Long> values) {
		StringBuilder builder = new StringBuilder(values.size() * levels.length);
		values.stream().forEach((value) -> decode(value, builder));
		return builder.toString();

	}

	public static String decode(long value, StringBuilder builder) {
		long remainder = 0;
		long character = 0;

		for (int i = 0; i < levels.length; i++) {

			remainder = value % levels[i];
			character = (value - remainder) / levels[i] + OFFSET;
			builder.append((char) character);
			// System.out.println(i + ": " + (char) character);
			value = remainder;

			if (value == 0) {
				return builder.toString();
			}
		}

		return builder.toString();
	}
}
