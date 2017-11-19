package com.sample.run;

final class SampleFinalClass {

	private static SampleFinalClass INSTANCE;

	private SampleFinalClass() {

	}

	public synchronized static SampleFinalClass getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new SampleFinalClass();
		}
		return  INSTANCE;
	}
}
