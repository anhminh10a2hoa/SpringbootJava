package vamk.edu.fi.spring3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class UserController{
    @Autowired
    private UserReporsitory repository;

    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    public @ResponseBody User create(@RequestBody User item) {
    	return repository.save(item);
    }  
    //methods return all users from database
    @RequestMapping("/users")
    public Iterable<User> users(){
        return repository.findAll();
    }

    @RequestMapping("/users/{id}")
    public Optional<User> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    

    @RequestMapping(value = "/users" , method = RequestMethod.PUT)
    public @ResponseBody User update(@RequestBody User item) {
    	return repository.save(item);
    } 
    
    @RequestMapping(value = "/users" , method = RequestMethod.DELETE)
    public void delete(@RequestBody User item) {
    	repository.delete(item);
        //do business logic
    } 
}