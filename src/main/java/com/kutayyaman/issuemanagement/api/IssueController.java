package com.kutayyaman.issuemanagement.api;

import javax.validation.Valid;

import com.kutayyaman.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.service.impl.IssueServiceImpl;



@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);

        return ResponseEntity.ok(issueDto);
    }

    @PostMapping()
    public ResponseEntity<IssueDto> createIssue(@Valid@RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    @PutMapping("/{id}")//su sekilde yazilabilirdi aslinda yukrdakilerde ayni sekilde @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id",required = true) Long id,@Valid@RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.deleteById(id));
    }


}
