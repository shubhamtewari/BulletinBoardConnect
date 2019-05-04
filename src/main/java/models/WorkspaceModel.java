package models;

import core.WorkspaceStructure;

import java.time.Instant;

public class WorkspaceModel {
    private WorkspaceStructure workspaceStructure;

    public void createWorkSpace(String name) {
        workspaceStructure = new WorkspaceStructure(name, Instant.now().toEpochMilli());
    }

    public WorkspaceStructure getWorkspaceStructure() {
        return this.workspaceStructure;
    }
}
