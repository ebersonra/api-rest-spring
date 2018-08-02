package com.algamoney.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgamoneyApiApplicationTests {

	@Test
	public void contextLoads() {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String senha = "123456";
		String senhaBase ="7d/Kc/1jF9E=";
		String senhaBcrypt = passwordEncoder.encode(senha);
		String senhaBaseBcrypt = passwordEncoder.encode(senhaBase);
		
		System.out.println("Senha: "+senhaBcrypt);
		
		System.out.println("Compare1: "+passwordEncoder.matches("123456", "$2a$10$Tks.qOOyYNNGEICsjlXkPO2CuVldpKs9q9ZeNfcjwLxICdBp1CnZa"));
		System.out.println("Compare2: "+passwordEncoder.matches(senhaBcrypt,"$2a$10$Tks.qOOyYNNGEICsjlXkPO2CuVldpKs9q9ZeNfcjwLxICdBp1CnZa"));
		System.out.println("Compare3: "+passwordEncoder.matches(senhaBase, senhaBase));
		System.out.println("Compare4: "+passwordEncoder.matches(senhaBase, "$2a$10$Tks.qOOyYNNGEICsjlXkPO2CuVldpKs9q9ZeNfcjwLxICdBp1CnZa"));
		System.out.println("Compare5: "+passwordEncoder.matches(senhaBase, senhaBaseBcrypt));
	}

}
