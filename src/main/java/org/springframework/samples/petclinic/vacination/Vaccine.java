package org.springframework.samples.petclinic.vacination;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vaccines")
public class Vaccine extends BaseEntity{
	
	
	@NotNull
	@Length(min = 3, max = 50)
	@JoinColumn(name = "name", unique = true)
    private String name;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "pet_type_id")
    PetType petType;
	
	@NotNull
	@Min(0)
	@JoinColumn(name = "price")
    private Double price;
	

}
