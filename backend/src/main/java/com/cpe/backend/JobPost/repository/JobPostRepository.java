package com.cpe.backend.JobPost.repository;

import com.cpe.backend.JobPost.entity.JobPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface JobPostRepository extends JpaRepository<JobPost, Long> {
    JobPost findById(long id);
}
