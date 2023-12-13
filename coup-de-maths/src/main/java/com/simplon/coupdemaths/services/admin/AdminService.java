package com.simplon.coupdemaths.services.admin;

import com.simplon.coupdemaths.repositories.securiry.OwnerRepository;
import com.simplon.coupdemaths.repositories.securiry.OwnerRepositoryModel;
import com.simplon.coupdemaths.repositories.securiry.RoleRepository;
import com.simplon.coupdemaths.repositories.securiry.RoleRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    RoleRepository roleRepository;

    public boolean validateRoleStudent(Long id) throws RoleNotFoundException {

        OwnerRepositoryModel ownerRepositoryModel = ownerRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Le rôle avec l'ID spécifié n'a pas été trouvé."));
       // Retrieve the roles of the user
        List<RoleRepositoryModel> roles = ownerRepositoryModel.getRoles();
        //student.getRoles().add(role);
        for(RoleRepositoryModel role : roles) {
            if (role.getId() == 4) { // STUDENT-TP
                RoleRepositoryModel roleRepositoryModel = roleRepository.findById(1L).orElseThrow();
                // Clear existing roles and add the new STUDENT role
                ownerRepositoryModel.getRoles().clear();
                ownerRepositoryModel.getRoles().add(roleRepositoryModel);

            } else if (role.getId() == 5) { // "PROFESSOR-TP":
                RoleRepositoryModel roleRepositoryModel1 = roleRepository.findById(2L).orElseThrow();
               ownerRepositoryModel.getRoles().clear();
                ownerRepositoryModel.getRoles().add(roleRepositoryModel1);
            }
        }
        // Save the updated user with new roles
    OwnerRepositoryModel owner = ownerRepository.save(ownerRepositoryModel);
        // Return true if the update was successful
    return owner != null;
    }
}
