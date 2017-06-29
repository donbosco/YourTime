package com.your.time.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.your.time.bean.User;
import com.your.time.dao.UsersRepositoryDAO;

@Component
public class UserService implements UserDetailsService {

    @Resource
    private UsersRepositoryDAO usersRepositoryDAO;
    
    private static final Logger logger = Logger.getLogger(UserService.class);
    
private org.springframework.security.core.userdetails.User userdetails;

    @Override
	public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        User user = getUserDetail(username);
        System.out.println(username);
         System.out.println(user.getPassword());
          System.out.println(user.getUsername());
           System.out.println(user.getRole());
            
            /*userdetails = new User(user.getUsername(), 
            					   user.getPassword(),
    		        			   enabled,
    		        			   accountNonExpired,
    		        			   credentialsNonExpired,
    		        			   accountNonLocked,
    		        			   getAuthorities(user.getRole()));*/
            return userdetails;
    }

    public List<GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (role.intValue() == 1) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        } else if (role.intValue() == 2) {
            authList.add(new SimpleGrantedAuthority("ROLE_CAMPAIGN"));
        }
        System.out.println(authList);
        return authList;
    }

    public User getUserDetail(String username) {
    	User user = usersRepositoryDAO.findByUsername(username);
        //System.out.println(user.toString());
        return user;
    }

    public User save(User user) {
    	if(user != null){
    		usersRepositoryDAO.save(user);
    		//ServicePro
    	}
		return null;
	}

	public List<User> findAll() {
		return (List<User>) usersRepositoryDAO.findAll();
	}
}