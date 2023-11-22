package com.example.TaskManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class TaskController {
    
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/all")
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/myTasks")
    public List<Task> getMyTasks(){
        String teammate = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof OAuth2AuthenticationToken) {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

        // Access the user's email
        teammate = oauthToken.getPrincipal().getAttribute("email");
    
        // Use the email as needed
        }
        List<Task> list1 = taskRepository.findByTeammate1(teammate);
        List<Task> list2 = taskRepository.findByTeammate2(teammate);
        List<Task> list3 = taskRepository.findByTeammate3(teammate);
        List<Task> list4 = taskRepository.findByCreator(teammate);
        List<Task> allTasks = new ArrayList<>();
        allTasks.addAll(list1);
        allTasks.addAll(list2);
        allTasks.addAll(list3);
        allTasks.addAll(list4);
        return allTasks;

    }

    @PostMapping("/save")
    public Task saveTask(@RequestBody Task task){
        String creator = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof OAuth2AuthenticationToken) {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

        creator = oauthToken.getPrincipal().getAttribute("email");
    
        task.setCreator(creator);
        }
        return taskRepository.save(task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam(name = "id") String id){
        //TODO make sure they can only delete tasks they are the creator of.
        /*String creator = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof OAuth2AuthenticationToken) {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

        creator = oauthToken.getPrincipal().getAttribute("email");
        }
        System.out.println(creator);
        Optional<Task> optionalTaskToDelete = taskRepository.findById(id);
        Task taskToDelete = optionalTaskToDelete.get();*/
        taskRepository.deleteById(id);
        
        
    }


}
