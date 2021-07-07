package ru.netology.netologyjdbctask.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/")
public class SecurityController {

    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String readMethod() {
        return "READ";
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public String writeMethod() {
        return "WRITE";
    }

    @GetMapping("/write-delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String writeDeleteMethod() {
        return "WRITE/DELETE";
    }

    @GetMapping("/name/{name}")
    @PreAuthorize("#name == authentication.principal.username")
    public String nameMethod(@PathVariable String name) {
        return "Hello, " + name;
    }
}
