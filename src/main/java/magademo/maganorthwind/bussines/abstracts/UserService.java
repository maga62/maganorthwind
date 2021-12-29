package magademo.maganorthwind.bussines.abstracts;

import magademo.maganorthwind.core.entities.User;
import magademo.maganorthwind.core.utilities.results.DataResult;
import magademo.maganorthwind.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);


}
