package com.scm_backend.projections;

import com.scm_backend.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user-projection", types = {User.class})
public interface UserProjection {

    String getName();

    String getEmail();

    String getPassword();

    String getAbout();
}
