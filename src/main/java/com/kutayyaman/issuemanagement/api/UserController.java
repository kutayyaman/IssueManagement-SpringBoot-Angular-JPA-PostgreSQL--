package com.kutayyaman.issuemanagement.api;
import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.dto.UserDto;
import com.kutayyaman.issuemanagement.entity.User;
import com.kutayyaman.issuemanagement.service.impl.UserServiceImpl;
import com.kutayyaman.issuemanagement.util.ApiPaths;
import com.kutayyaman.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value = ApiPaths.UserCtrl.CTRL, description = "User APIs")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = UserDto.class)
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id",required = true) Long id) {
        UserDto userDto = userService.getById(id);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping()
    @ApiOperation(value = "Create Operation", response = User.class)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/{id}")//su sekilde yazilabilirdi aslinda yukrdakilerde ayni sekilde @RequestMapping(path = "/update",method = RequestMethod.PUT)
    @ApiOperation(value = "Update Operation", response = UserDto.class)
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id",required = true) Long id,@Valid@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.update(id,userDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @GetMapping()
    @ApiOperation(value = "Get All Users", response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> data = userService.getAll();
        return ResponseEntity.ok(data);
    }

}

