package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import app.dto.Cientifico;

public interface ICientificoDAO extends JpaRepository<Cientifico, Integer>{

}