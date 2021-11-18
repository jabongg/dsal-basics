package com.example.demo.app.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<com.example.demo.app.ticket.entity.Station, Integer> {

}
