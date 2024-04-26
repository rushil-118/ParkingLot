package com.sst.services;

import com.sst.exceptions.InvalidGateException;
import com.sst.models.Gate;
import com.sst.models.Ticket;
import com.sst.models.Vehicle;
import com.sst.models.VehicleType;
import com.sst.repositories.GateRepository;
import com.sst.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public Ticket issueTicket(Long gateId, String vehicleNumber, VehicleType vehicleType, String ownerName) throws InvalidGateException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gateRepository.fingById(gateId);

        if(optionalGate.isEmpty()){
            throw new InvalidGateException("Invalid Gate ID");
        }
        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleNumber);

        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, ownerName);
            vehicleRepository.save(vehicleNumber,vehicle);
            optionalVehicle = vehicleRepository.findById(vehicleNumber);
        }
        Vehicle vehicle = optionalVehicle.get();
        ticket.setVehicle(vehicle);

        return ticket;
    }
}
