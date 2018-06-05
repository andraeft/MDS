package com.payit.app.controller;

import com.payit.app.model.User;
import com.payit.app.service.UserService;
import com.payit.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/search")
    public Collection<User> search(@RequestParam String search) {
        return userService.search(search);
    }

    @GetMapping(value = "/me")
    public MeDTO me(Authentication auth) {
        String uid = ((MyUserDetails)auth.getPrincipal()).getUid();
        User user = userService.findByUId(uid);
        MeDTO meDTO = new MeDTO();
        meDTO.setEmail(user.getEmail());
        meDTO.setId(user.getId());
        meDTO.setFirstName(user.getFirstName());
        meDTO.setLastName(user.getLastName());
        return meDTO;
    }

    @PostMapping(value = "/{id}")
    public void edit(@PathVariable Integer id, @RequestBody UserEditDto data) {
        userService.modifyUser(data.getEmail(), data.getFirstName(), data.getLastName(), id);
    }
}
