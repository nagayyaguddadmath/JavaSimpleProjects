package com.sample.run;

import java.util.Map;

public class SampleMemoryLeak {
    public final String key;
    
    public SampleMemoryLeak(String key) {
        this.key =key;
    }
    
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {
        try {
            Map map = System.getProperties();
            
            for(;;) {
                map.put(new SampleMemoryLeak("key"), "value");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}