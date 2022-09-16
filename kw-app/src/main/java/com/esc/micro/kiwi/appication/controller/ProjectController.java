package com.esc.micro.kiwi.appication.controller;

import com.esc.micro.kiwi.app.model.common.Project.ProjectData;
import com.esc.micro.kiwi.core.services.common.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
  @Resource
  private ProjectService projectService;

  @GetMapping
  public ResponseEntity<List<ProjectData>> getAllProjects() {
    return new ResponseEntity<>(projectService.findAllProjects(), HttpStatus.ACCEPTED);
  }

  @PostMapping
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<ProjectData> createNewProject(@RequestBody ProjectData project) {
    return new ResponseEntity<>(projectService.createNewProject(project), HttpStatus.CREATED);
  }

  @PatchMapping("/{project_id}")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<ProjectData> updateProjectById(@PathVariable(value = "project_id")
                                                       Long project_id,
                                                       @RequestBody ProjectData newProject) {
    return new ResponseEntity<>(projectService.
        updateProjectByProject_id(project_id, newProject), HttpStatus.ACCEPTED);
  }
}
