package webdemo.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by exastax-03 on 7/7/2017.
 */
@Service
public class UserService implements UserDetailsService{
    private Map<String,MyUser> users;

    public UserService() {
        MyUser user1=new MyUser("talhaklc","686868");
        MyUser user2=new MyUser("admin","134679");

        users=new HashMap<String, MyUser>();
        users.put("talhaklc",user1);
        users.put("admin",user2);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
