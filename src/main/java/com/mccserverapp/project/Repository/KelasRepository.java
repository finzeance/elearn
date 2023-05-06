package com.mccserverapp.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mccserverapp.project.Model.Kelas;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Integer> {
}
