package com.example.CrudProject.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String>  {
	
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Ouhsa");
		// Use below commented code when will use Spring Security.
	}

}
