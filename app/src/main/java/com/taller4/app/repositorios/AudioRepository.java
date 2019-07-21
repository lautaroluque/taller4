package com.taller4.app.repositorios;

import com.taller4.app.dominio.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Integer>  {

}