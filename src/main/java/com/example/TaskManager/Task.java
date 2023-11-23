package com.example.TaskManager;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    @Id
    private String id;

    private String creator;
    private String name;
    private String description;
    private String teammate1;
    private String teammate2;
    private String teammate3;
    



    public Task() {

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator(){
        return this.creator;
    }

    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeammate1() {
        return teammate1;
    }

    public void setTeammate1(String teammate1) {
        this.teammate1 = teammate1;
    }

    public String getTeammate2() {
        return teammate2;
    }

    public void setTeammate2(String teammate2) {
        this.teammate2 = teammate2;
    }

    public String getTeammate3() {
        return teammate3;
    }

    public void setTeammate3(String teammate3) {
        this.teammate3 = teammate3;
    }

}
