package com.yan.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.yan.projeto1.entity.User;
import com.yan.projeto1.repository.UserRepository;

@Component
public class DataInitiaizr implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			createUser("Yan", "yanflorencio@hotmail.com");
			createUser("Iago", "iago@hotmail.com");
			createUser("Otario", "otario@hotmail.com");
		}
		User user = userRepository.findByNome("Iago");
		System.out.println(user.getNome() + " " + user.getEmail());
	}
	
	void createUser(String nome, String email) {
		User user = new User(nome, email);
		userRepository.save(user);
	}

}
