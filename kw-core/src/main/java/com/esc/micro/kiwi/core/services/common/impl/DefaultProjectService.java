package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.app.model.common.Project.ProjectData;
import com.esc.micro.kiwi.core.services.common.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {
  @Override
  public List<ProjectData> getAllProjects() {
    return null;
  }

  @Override
  public long getCountProjects() {
    return 0;
  }

  @Override
  public long getProjectsPerDay() {
    return 0;
  }

  @Override
  public ProjectData createNewProject(ProjectData project) {
    return null;
  }

  @Override
  public ProjectData updateProjectByProject_id(Long project_id, ProjectData newProject) {
    return null;
  }

  @Override
  public List<ProjectData> findAllProjects() {
    return null;
  }
}
