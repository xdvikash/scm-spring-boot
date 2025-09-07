package com.scm_backend.entity.events;

import com.scm_backend.entity.Contact;
import com.scm_backend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RepositoryEventHandler(Contact.class)
public class ContactEventHandler {

    private static final Logger log = LoggerFactory.getLogger(ContactEventHandler.class);

    @HandleBeforeSave
    public void eventBeforeSave(Contact contact) {
        contact.setId(UUID.randomUUID().toString());
    }

//    @HandleBeforeCreate
//    public void handleBeforeCreate(Contact contact) {
//        log.info("Going to create contact for: {}", contact.getEmail());
//
//        // Set UUID only when creating new contact
//        if (contact.getId() == null || contact.getId().isEmpty()) {
//            contact.setId(UUID.randomUUID().toString());
//        }
//
//        // Example: set default values only on create
//        if (contact.getAddress() == null) {
//            contact.setAddress(String.valueOf(false)); // or true, depending on business rule
//        }
//    }

}
