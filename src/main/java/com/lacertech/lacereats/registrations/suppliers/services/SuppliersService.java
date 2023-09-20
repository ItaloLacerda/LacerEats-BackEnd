package com.lacertech.lacereats.registrations.suppliers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.SuppliersModel;
import com.lacertech.lacereats.database.repository.AdressesRepository;
import com.lacertech.lacereats.database.repository.SuppliersRepository;
import com.lacertech.lacereats.dto.suppliersDTO.SuppliersDTO;

@Service
public class SuppliersService {
    
    @Autowired
    private SuppliersRepository suppliersRepository;

    @Autowired
    private AdressesRepository adressesRepository;

    public void create(SuppliersDTO suppliers) {

        if(adressesRepository.existsById(suppliers.adresses().getId())) {
            SuppliersModel productData = new SuppliersModel(
                suppliers.supplierName(),
                suppliers.fantasyName(),
                suppliers.email(),
                suppliers.cellPhone(),
                suppliers.stateRegistration(),
                suppliers.cpnj(),
                suppliers.site(),
                suppliers.status(),
                suppliers.adresses()
            );
            suppliersRepository.save(productData);
        } else {
            System.out.println("Aprenda a fazer exeção");
        }
        return;
    }

    public List<SuppliersDTO> searchAll() {
        List<SuppliersModel> listProducts = suppliersRepository.findAll();
        return listProducts.stream()
                            .map(SuppliersDTO::new)
                            .collect(Collectors.toList());
    }

    public SuppliersDTO searchById(Integer id) {
        
        return new SuppliersDTO(suppliersRepository.findById(id).get());
    }

    public void update(SuppliersDTO suppliers) {
        SuppliersModel productData = new SuppliersModel(
            suppliers.id(),
            suppliers.supplierName(),
            suppliers.fantasyName(),
            suppliers.email(),
            suppliers.cellPhone(),
            suppliers.stateRegistration(),
            suppliers.cpnj(),
            suppliers.site(),
            suppliers.status(),
            suppliers.adresses()
        );
        suppliersRepository.save(productData);
        return;
    }

    public void delete(Integer id) {
        suppliersRepository.deleteById(id);
        return;
    }
}
