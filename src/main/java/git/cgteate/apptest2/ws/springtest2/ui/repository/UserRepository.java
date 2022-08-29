package git.cgteate.apptest2.ws.springtest2.ui.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import git.cgteate.apptest2.ws.springtest2.ui.model.User;


/*similar to JPA repository, but this is for */
public interface UserRepository extends MongoRepository<User, String> {
    
}
