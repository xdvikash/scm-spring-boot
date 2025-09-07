package com.scm_backend.entity.events;

import com.scm_backend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    private static final Logger log = LoggerFactory.getLogger(UserEventHandler.class);

    @HandleBeforeSave
    public void eventBeforeSave(User user) {
        user.setId(UUID.randomUUID().toString());
    }

    @HandleBeforeCreate
    public void handlerBeforeCreate(User user) {
        log.info("going to create info for user: {}", user.getEmail());

        // Example: set defaults before saving
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        user.setEnabled(true);
    }

}
