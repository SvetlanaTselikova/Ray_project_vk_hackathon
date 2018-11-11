package com.vkteam.templates.service;

import com.vkteam.templates.domain.pet.Pet;
import com.vkteam.templates.domain.task.Task;
import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.repos.ITaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    @Autowired
    private ITaskRepo taskRepo;

    public void updateTask(Task task) {
        taskRepo.save(task);
    }

    public void addTask(Task task) {
        taskRepo.save(task);
    }

    public List<Task> getAll() {
        return taskRepo.findAll();
    }

    public List<Task> getUserTasks(User user) {
        return taskRepo.findByUser(user);
    }

    public List<Task> getPetTask(Pet pet) {
        return taskRepo.findByPet(pet);
    }


    public static List<Task> vlasovAlgo3000(List<Task> tasks) {
        final String height = "Height";
        final String medium = "Medium";
        final String low = "Low";

        List<Task> rebootTask = tasks;
        Map<String, ArrayList<Task>> map = new HashMap<>();


        for(Task task : tasks) {
            boolean checkUrgency = task.isUrgency();
            int checkComplex = task.getComplexity();

            String checkPrice;
            if(task.getPrice() > 30)
                checkPrice = height;
            else {
                if(task.getPrice() < 7)
                    checkPrice = low;
                else
                    checkPrice = medium;
            }

            if(checkComplex == 3 && checkUrgency == true) {
                /**
                 * First stage
                 */
                if(map.containsKey("1")) {
                    int length = map.get("1").size();
                    ArrayList<Task> temp = map.get("1");
                    temp.add(length, task);
                    map.put("1", temp);
                } else {
                    ArrayList<Task> temp = new ArrayList<>();
                    temp.add(0, task);
                    map.put("1", temp);
                }
            } else if((checkPrice.equals(height)) &&
                    ((checkComplex == 3 && checkUrgency == false)
                            || (checkComplex == 2&& checkUrgency == false)
                            || (checkComplex == 2 && checkUrgency == true))) {
                /**
                 * Stage 2
                 */
                if(map.containsKey("2")) {
                    int length = map.get("2").size();
                    ArrayList<Task> temp = map.get("2");
                    temp.add(length, task);
                    map.put("2", temp);
                } else {
                    ArrayList<Task> temp = new ArrayList<>();
                    temp.add(0, task);
                    map.put("2", temp);
                }
            } else if(checkComplex == 2 && checkUrgency == true && (checkPrice.equals(medium) || checkPrice.equals(height))
                    || (checkComplex == 3 && checkUrgency == true && checkPrice.equals(medium))) {
                /**
                 * Stage 3
                 */
                if(map.containsKey("3")) {
                    int length = map.get("3").size();
                    ArrayList<Task> temp = map.get("3");
                    temp.add(length, task);
                    map.put("3", temp);
                } else {
                    ArrayList<Task> temp = new ArrayList<>();
                    temp.add(0, task);
                    map.put("3", temp);
                }

            } else if(checkPrice.equals(medium) &&
                    ((checkComplex == 2 && checkUrgency == false) || (checkComplex == 1 && checkUrgency == true))) {
                /**
                 * Stage 4
                 */
                if(map.containsKey("4")) {
                    int length = map.get("4").size();
                    ArrayList<Task> temp = map.get("4");
                    temp.add(length, task);
                    map.put("4", temp);
                } else {
                    ArrayList<Task> temp = new ArrayList<>();
                    temp.add(0, task);
                    map.put("4", temp);
                }
            } else if(checkPrice.equals(low) && ((checkComplex == 3 && checkUrgency == false)
                    || (checkComplex == 1 && checkUrgency == true))) {
                /**
                 * Stage 5
                 */
                if(map.containsKey("5")) {
                    int length = map.get("5").size();
                    ArrayList<Task> temp = map.get("5");
                    temp.add(length, task);
                    map.put("5", temp);
                } else {
                    ArrayList<Task> temp = new ArrayList<>();
                    temp.add(0, task);
                    map.put("5", temp);
                }
            } else if(checkComplex == 1 && checkUrgency == false) {
                /**
                 * Stage 6
                 */
                if(map.containsKey("6")) {
                    int length = map.get("6").size();
                    ArrayList<Task> temp = map.get("6");
                    temp.add(length, task);
                    map.put("6", temp);
                } else {
                    ArrayList<Task> temp = new ArrayList<>();
                    temp.add(0, task);
                    map.put("6", temp);
                }
            }
        }


        int i = 0;
        for(int j = 0; j < tasks.size(); j++) {
            if(map.containsKey("1")) {
                if(map.get("1").size() < 2) {
                    ArrayList<Task> temp = map.get("1");
                    rebootTask.set(i, temp.get(0));
                    temp.remove(0);
                    map.remove("1");
                    i++;

                } else {
                    int index = new Random().nextInt(map.get("1").size());
                    ArrayList<Task> temp = map.get("1");
                    rebootTask.set(i, temp.get(index));
                    temp.remove(index);
                    map.put("1", temp);
                    i++;
                }
            }
            if(map.containsKey("2")) {
                if(map.get("2").size() < 2) {
                    ArrayList<Task> temp = map.get("2");
                    rebootTask.set(i, temp.get(0));
                    temp.remove(0);
                    map.remove("2");
                    i++;

                } else {
                    int index = new Random().nextInt(map.get("2").size());
                    ArrayList<Task> temp = map.get("2");
                    rebootTask.set(i, temp.get(index));
                    temp.remove(index);
                    map.put("2", temp);
                    i++;
                }
            }
            if(map.containsKey("3")) {
                if(map.get("3").size() < 2) {
                    ArrayList<Task> temp = map.get("3");
                    rebootTask.set(i, temp.get(0));
                    temp.remove(0);
                    map.remove("3");
                    i++;

                } else {
                    int index = new Random().nextInt(map.get("3").size());
                    ArrayList<Task> temp = map.get("3");
                    rebootTask.set(i, temp.get(index));
                    temp.remove(index);
                    map.put("3", temp);
                    i++;
                }
            }
            if(map.containsKey("4")) {
                if(map.get("4").size() < 2) {
                    ArrayList<Task> temp = map.get("4");
                    rebootTask.set(i, temp.get(0));
                    temp.remove(0);
                    map.remove("4");
                    i++;

                } else {
                    int index = new Random().nextInt(map.get("4").size());
                    ArrayList<Task> temp = map.get("4");
                    rebootTask.set(i, temp.get(index));
                    temp.remove(index);
                    map.put("4", temp);
                    i++;
                }
            }
            if(map.containsKey("5")) {
                if(map.get("5").size() < 2) {
                    ArrayList<Task> temp = map.get("5");
                    rebootTask.set(i, temp.get(0));
                    temp.remove(0);
                    map.remove("5");
                    i++;

                } else {
                    int index = new Random().nextInt(map.get("5").size());
                    ArrayList<Task> temp = map.get("5");
                    rebootTask.set(i, temp.get(index));
                    temp.remove(index);
                    map.put("5", temp);
                    i++;
                }
            }
            if(map.containsKey("6")) {
                if(map.get("6").size() < 2) {
                    ArrayList<Task> temp = map.get("6");
                    rebootTask.set(i, temp.get(0));
                    temp.remove(0);
                    map.remove("6");
                    i++;

                } else {
                    int index = new Random().nextInt(map.get("6").size());
                    ArrayList<Task> temp = map.get("6");
                    rebootTask.set(i, temp.get(index));
                    temp.remove(index);
                    map.put("6", temp);
                    i++;
                }
            }
        }

        return rebootTask;
    }
}
