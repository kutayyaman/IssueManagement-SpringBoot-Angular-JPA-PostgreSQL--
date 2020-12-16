package com.kutayyaman.issuemanagement.api;

import javax.validation.Valid;

import com.kutayyaman.issuemanagement.dto.ProjectDto;
import com.kutayyaman.issuemanagement.entity.IssueStatus;
import com.kutayyaman.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.service.impl.IssueServiceImpl;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")

public class IssueController {
    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);

        return ResponseEntity.ok(issueDto);
    }

    @PostMapping()
    @ApiOperation(value = "Create Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> createIssue(@Valid@RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    @PutMapping("/{id}")//su sekilde yazilabilirdi aslinda yukrdakilerde ayni sekilde @RequestMapping(path = "/update",method = RequestMethod.PUT)
    @ApiOperation(value = "Update Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id",required = true) Long id,@Valid@RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.deleteById(id));
    }

    @GetMapping("/statuses")
    @ApiOperation(value = "Get All Issue Statuses Operation", response = String.class, responseContainer = "List")
    public ResponseEntity<List<IssueStatus>> getAllIssueStatus() {
        return ResponseEntity.ok(Arrays.asList(IssueStatus.values()));
    }


}
