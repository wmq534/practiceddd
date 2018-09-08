package top.dddclub.practiceddd.eas.projectcontext.domain.scrumprocess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dddclub.practiceddd.eas.projectcontext.domain.role.TeamMember;
import top.dddclub.practiceddd.eas.projectcontext.interfaces.notification.NotificationService;
import top.dddclub.practiceddd.eas.projectcontext.repositories.SprintBacklogAssignmentRepository;
import top.dddclub.practiceddd.eas.projectcontext.repositories.SprintBacklogRepository;

@Service
public class AssignSprintBacklogService {
    @Autowired
    private SprintBacklogRepository backlogRepository;
    @Autowired
    private SprintBacklogAssignmentRepository assignmentRepository;
    @Autowired
    private NotificationService notificationService;

    public void assign(SprintBacklog backlog, TeamMember assignee) {
        SprintBacklogAssignment assignment = backlog.assignTo(assignee);
        backlogRepository.update(backlog);
        assignmentRepository.add(assignment);

        AssignmentNotification notification = new AssignmentNotification(assignment);
        notificationService.send(assignee.email().address(), notification.content());
    }
}
