package com.esc.micro.kiwi.core.services.common;

import com.esc.micro.kiwi.app.model.common.Project.ProjectData;

import java.util.List;

public interface ProjectService {
  List<ProjectData> getAllProjects();

  long getCountProjects();

  long getProjectsPerDay();

  ProjectData createNewProject(ProjectData project);

  ProjectData updateProjectByProject_id(Long project_id, ProjectData newProject);

  List<ProjectData> findAllProjects();
}
