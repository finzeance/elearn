package com.mccserverapp.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mccserverapp.project.Model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {

}
