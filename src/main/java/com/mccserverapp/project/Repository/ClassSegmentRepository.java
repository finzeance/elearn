package com.mccserverapp.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mccserverapp.project.Model.ClassSegment;

@Repository
public interface ClassSegmentRepository extends JpaRepository<ClassSegment, Integer> {

}
