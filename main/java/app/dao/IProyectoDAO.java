package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import app.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, Integer> {

}