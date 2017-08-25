package com.rockers.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockers.api.model.Team;

public interface TeamRepository extends JpaRepository<Team,Long>{

}
