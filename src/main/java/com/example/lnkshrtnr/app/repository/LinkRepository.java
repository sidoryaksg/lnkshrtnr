package com.example.lnkshrtnr.app.repository;

import com.example.lnkshrtnr.app.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Integer> {

}
