package main.java.com.test;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="users",path="user")
public interface UserRepository extends MongoRepository<User, String> {

	public User findByuserid(@Param("userid")String userid);
    public List<User> findBylname(@Param("lname")String lname);
    public List<User> findByFname(@Param("fname")String fname);
}
