package com.shadab.spring.cache.ehcache.services;

import com.shadab.spring.cache.ehcache.model.Student;

public interface StudentService {

	void evictStudents();

	Student getByRoll(String string);

}
