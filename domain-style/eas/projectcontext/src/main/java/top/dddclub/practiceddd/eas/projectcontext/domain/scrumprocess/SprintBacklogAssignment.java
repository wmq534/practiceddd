package xyz.zhangyipracticeddd.eas.projectcontext.domain.scrumprocess;

import xyz.zhangyipracticeddd.dddcore.Entity;
import xyz.zhangyipracticeddd.dddcore.identity.UUIDIdentity;
import xyz.zhangyipracticeddd.eas.projectcontext.domain.role.MemberId;

import java.time.LocalDateTime;

public class SprintBacklogAssignment extends Entity<UUIDIdentity> {
    private BacklogId sprintBacklogId;
    private MemberId assigneeId;
    private LocalDateTime assignedTime;

    public SprintBacklogAssignment(BacklogId sprintBacklogId, MemberId assignee) {
        this.id = new UUIDIdentity();
        this.sprintBacklogId = sprintBacklogId;
        this.assigneeId = assignee;
        assignedTime = LocalDateTime.now();
    }

    public BacklogId getSprintBacklogId() {
        return sprintBacklogId;
    }

    public MemberId getAssigneeId() {
        return assigneeId;
    }

    public LocalDateTime getAssignedTime() {
        return assignedTime;
    }
}
