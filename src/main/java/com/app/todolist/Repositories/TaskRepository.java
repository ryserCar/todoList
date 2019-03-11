package com.app.todolist.Repositories;

import com.app.todolist.Domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query(value = "SELECT * FROM tasks t WHERE t.user_name= ?1",
            nativeQuery = true)
    List<Task> findAllByUserName(String name);
}
