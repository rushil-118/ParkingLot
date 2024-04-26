package com.sst.repositories;

import com.sst.models.Gate;
import com.sst.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gates = new HashMap<>();
    public Optional<Gate> fingById(Long gateId){
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }


}
