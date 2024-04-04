package com.remotehiring.Repositories;

import com.remotehiring.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

}