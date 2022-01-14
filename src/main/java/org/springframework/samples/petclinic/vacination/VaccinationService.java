package org.springframework.samples.petclinic.vacination;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class VaccinationService {
	
	@Autowired
	private VaccinationRepository vr;

	
    public List<Vaccination> getAll(){
        return vr.findAll();
    }

    public List<Vaccine> getAllVaccines(){
        return null;
    }

    public Vaccine getVaccine(String typeName) {
        return vr.findByName(typeName);
    }

    @Transactional(rollbackOn = UnfeasibleVaccinationException.class)
    public Vaccination save(Vaccination p) throws DataAccessException, UnfeasibleVaccinationException {
    	
    	Pet pet = new Pet() ;
    	PetType pt = pet.getType();
        if (pt != p.getVaccine().getPetType()) {            	
        	throw new UnfeasibleVaccinationException();
        }else
           vr.save(p);
		return p;        
    }

    
}
