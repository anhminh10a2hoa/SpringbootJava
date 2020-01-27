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
public class ProfileController{
    @Autowired
    private ProfileReporsitory repository;

    @RequestMapping(value = "/profile" , method = RequestMethod.POST)
    public @ResponseBody Profile create(@RequestBody Profile item) {
    	return repository.save(item);
    }  
    //methods return all users from database
    @RequestMapping("/profiles")
    public Iterable<Profile> profile(){
        return repository.findAll();
    }

    @RequestMapping("/profiles/{id}")
    public Optional<Profile> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    

    @RequestMapping(value = "/profiles" , method = RequestMethod.PUT)
    public @ResponseBody Profile update(@RequestBody Profile item) {
    	return repository.save(item);
    } 
    
    @RequestMapping(value = "/profiles" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Profile item) {
    	repository.delete(item);
        //do business logic
    } 
}