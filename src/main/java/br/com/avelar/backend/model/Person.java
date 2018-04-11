package br.com.avelar.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "person_seq", sequenceName = "person_seq")
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	@NotNull @Size(min = 3, max = 100)
	private String name;
	
	@Column(name = "AGE")
	@NotNull @Min(0) @Max(120)
	private Long age;

	public Person() {
		
	}
	
	public Person(String name, Long age) {
		this.name = name;
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	
	public String toString() {
		return this.name;
	}
	
}
