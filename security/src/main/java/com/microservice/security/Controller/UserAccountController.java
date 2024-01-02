package com.microservice.security.Controller;

import com.microservice.security.Entity.UserAccount;
import com.microservice.security.Service.UserAccountImpl;
import com.microservice.security.Dto.AuthRequest;
import com.microservice.security.Dto.PersistUserRequest;
import com.microservice.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/micro")
@Api(value="User Account API endpoints which are used to interact with user microservices ")
public class UserAccountController {

    @Autowired
    private UserAccountImpl userAccountImpl;

    @Autowired
    private AuthenticationManager authenticationManager;
    private AuthRequest authRequest;

    @Autowired
    private JwtUtil jwtUtil;

    /*@GetMapping("/welcome")
    public String welcome(){
        return "welcome to user account";
    }*/


    @PostMapping("/user/login")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userAccountImpl.generateToken(authRequest.getUserName());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    /*@PostMapping("/login")
    @ApiOperation(value = "this service help to generate jwt token")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the JWT Token"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Requested Resource Not Found")
    })
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("user is not found");
        }
        String username = null;
        return jwtUtil.generateToken(authRequest.getUserName());
    }*/

    /*@ApiOperation(value = "this service help to create new user in to the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully able to save the user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Requested Resource Not Found")
    })*/
    @PostMapping("/user/new")
    @PreAuthorize("hasAuthority('Admin')")
    public UserAccount addNewUser(@RequestBody PersistUserRequest persistUserRequest) {
        return userAccountImpl.addUser(persistUserRequest);
    }

    /*@ApiOperation(value = "this service help to get all users available in to the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved users from system"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Requested Resource Not Found")
    })*/
    @GetMapping("/user/allUsers")
 //   @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    public List<UserAccount> getAllUsers() {
        return userAccountImpl.getAllUsers();
    }


}
