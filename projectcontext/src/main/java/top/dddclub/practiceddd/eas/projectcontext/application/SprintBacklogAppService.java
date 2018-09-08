package top.dddclub.practiceddd.eas.projectcontext.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dddclub.practiceddd.dddcore.exception.ApplicationException;
import top.dddclub.practiceddd.eas.projectcontext.domain.exception.InvalidAssignmentException;
import top.dddclub.practiceddd.eas.projectcontext.domain.role.TeamMember;
import top.dddclub.practiceddd.eas.projectcontext.domain.scrumprocess.AssignSprintBacklogService;
import top.dddclub.practiceddd.eas.projectcontext.domain.scrumprocess.SprintBacklog;

@Service
public class SprintBacklogAppService {
    @Autowired
    private AssignSprintBacklogService assignService;

    public void assignBacklog(SprintBacklog backlog, TeamMember assignee) throws ApplicationException {
        try {
            assignService.assign(backlog, assignee);
        } catch (InvalidAssignmentException ex) {
            throw new ApplicationException("failed to assign sprint backlog", ex);
        }
    }
}
