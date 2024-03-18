package com.actuator.helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyDBhealthService implements HealthIndicator {
	public static final String DB_SERVICE="Database Service";

	public boolean ishealthGood() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Health health() {
		if(ishealthGood()) {
		return Health.up().withDetail(DB_SERVICE, "Database Service is running").build();
	}
	return Health.down().withDetail(DB_SERVICE, "Database Service is not running").build();

}
}
