package com.payit.app.app;

import com.payit.app.service.UserService;
import com.payit.common.event.UserRegistered;
import com.payit.security.repository.CredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventReactor {
    private final UserService userService;
    private final CredentialsRepository credentialsRepository;

    @EventListener
    public void onUserRegistered(UserRegistered userRegistered) {
        credentialsRepository.findById(userRegistered.getCredentialId()).ifPresent(userService::createUser);
    }
}
