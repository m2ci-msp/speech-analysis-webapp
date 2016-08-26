package com.speechanalysis.security.loader;

import com.speechanalysis.model.Role;
import com.speechanalysis.repository.RoleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by plam on 10/08/16.
 */

@Component
public class RoleLoader implements ApplicationListener<ContextRefreshedEvent> {
    private RoleRepository roleRepository;

    private Logger log=Logger.getLogger(RoleLoader.class);

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        Role role1 = new Role();
        role1.setName("role_admin");
        roleRepository.save(role1);
        log.info("Saved role1 " + role1.getId() + " "+role1.getName());

        Role role2=new Role();
        role2.setName("role_user");
        roleRepository.save(role2);
        log.info("Saved role2 " + role2.getId() + " "+role2.getName());
    }
}
