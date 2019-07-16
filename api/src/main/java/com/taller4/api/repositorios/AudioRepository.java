package com.taller4.api.repositorios;

import com.taller4.api.dominio.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Integer>  {

}