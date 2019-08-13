package com.aurelmarishta.restblog.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Profile("hateoas")
@RequestMapping("api/users")
@ExposesResourceFor(User.class)
@Api(value = "User Controller")
public class UserController {

    private final UserService userService;

//    private final EntityLinks entityLinks;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @ApiOperation(value = "Show all users")
    @GetMapping("")
    Page<User> showAllUsers(Pageable pageable) {
        return userService.findAllUserSPageable(pageable);
    }


//    @ApiOperation(value = "Show all users")
//    @GetMapping("")
//    HttpEntity<Resources<User>> showAllUsers() {
//
//        Resources<User> resources = new Resources<>(userService.findAllUsers());
////        resources.add(entityLinks.linkToCollectionResource(User.class));
//
//        return new ResponseEntity<>(resources, HttpStatus.OK);
//    }
//    @ApiOperation(value = "Get user with id")
//    @GetMapping("/{username}")
//    HttpEntity<Resource<User>> getUserById(
//            @ApiParam(value = "User id from which user object will retrieve") @PathVariable("username") String username) {
//
//        User user = userService.getOneByUsername(username);
//
//        Resource<User> resource = new Resource<>(user);
//        resource.add(entityLinks.linkToSingleResource(User.class, user.getId()));
//
//        return new ResponseEntity<>(resource, HttpStatus.OK);
//    }


}
