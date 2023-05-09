package com.mccserverapp.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mccserverapp.project.Model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
