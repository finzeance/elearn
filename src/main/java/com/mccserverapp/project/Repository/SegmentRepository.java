package com.mccserverapp.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mccserverapp.project.Model.Segment;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Integer> {
}
