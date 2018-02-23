package com.code.rider.api;

import ch.qos.logback.core.joran.action.IADataForComplexProperty;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Prageeth on 15/2/2018.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
