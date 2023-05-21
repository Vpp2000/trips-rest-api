package com.vpp97.tripsrestapi.services.strategies;

public class CounterService {
    public static long count(CountStrategy countStrategy){
        return countStrategy.count();
    }
}
