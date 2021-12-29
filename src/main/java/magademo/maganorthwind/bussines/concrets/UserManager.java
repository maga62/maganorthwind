package magademo.maganorthwind.bussines.concrets;

import magademo.maganorthwind.bussines.abstracts.UserService;
import magademo.maganorthwind.core.dataAccess.UserDao;
import magademo.maganorthwind.core.entities.User;
import magademo.maganorthwind.core.utilities.results.DataResult;
import magademo.maganorthwind.core.utilities.results.Result;
import magademo.maganorthwind.core.utilities.results.SuccessDataResult;
import magademo.maganorthwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {


    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }


    @Override
    public Result add(User user) {

        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanıcı bulundu");
    }
}
