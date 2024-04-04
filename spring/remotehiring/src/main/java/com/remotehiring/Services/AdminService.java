package com.remotehiring.Services;

import com.remotehiring.entities.Admin;
import com.remotehiring.exceptions.AdminAuthenticationException;
import com.remotehiring.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repo;

	public boolean checkadmin(Admin admin) {
		if (admin == null || admin.getAdminid() == null || admin.getPassword() == null) {
			throw new IllegalArgumentException("Admin and/or its credentials cannot be null");
		}

		if (repo.existsById(admin.getAdminid())) {
			Admin currentadmin = repo.findById(admin.getAdminid()).orElseThrow(() -> new AdminAuthenticationException("Admin not found"));
			if (currentadmin.getPassword().equals(admin.getPassword())) {
				return true;
			} else {
				throw new AdminAuthenticationException("Incorrect password");
			}
		} else {
			throw new AdminAuthenticationException("Admin not found");
		}
	}
}