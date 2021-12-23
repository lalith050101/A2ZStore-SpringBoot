package com;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.model.ProductModel;
import com.model.UserModel;
import com.opencsv.CSVReader;
import com.repository.CartItemModelRepository;
import com.repository.OrderItemModelRepository;
import com.repository.OrderModelRepository;
import com.repository.ProductRepository;
import com.repository.UserModelRepository;

@SpringBootApplication
public class SpringA2ZStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringA2ZStoreApplication.class, args);
	}
}

@Component
class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserModelRepository userModelRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemModelRepository orderItemModelRepository;

	@Autowired
	private OrderModelRepository orderModelRepository;

	@Autowired
	private CartItemModelRepository cartModelRepository;
	
	@Autowired
	   BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
		
		  createUser("admin@a2z.app", bCryptPasswordEncoder.encode("admin@a2z"), "admin", "Admin", true);
		  createUser("testuser@a2z.app", bCryptPasswordEncoder.encode("testuser@a2z"), "customer", "Test User",
		  true);
		   
		  
		  orderItemModelRepository.deleteAllInBatch();
		  orderItemModelRepository.flush(); orderModelRepository.deleteAllInBatch();
		  orderModelRepository.flush(); cartModelRepository.deleteAllInBatch();
		  cartModelRepository.flush(); productRepository.deleteAllInBatch(); CSVReader
		  reader = null; try { //parsing a CSV file into CSVReader class constructor
		  reader = new CSVReader(new
		  FileReader(ResourceUtils.getFile("classpath:products.csv"))); String []
		  product; while ((product = reader.readNext()) != null) { ProductModel
		  productModel = new ProductModel(); productModel.setCategory(product[6]);
		  productModel.setDescription(product[1]);
		  productModel.setImageUrl(product[2]); productModel.setPrice(product[3]);
		  productModel.setProductName(product[4]);
		  productModel.setQuantity(product[5]); productRepository.save(productModel); }
		  } catch (Exception e) { e.printStackTrace(); }
		 

	}

	public void createUser(String email, String password, String role, String username, boolean active) {

		UserModel userModel = new UserModel();
		userModel.setActive(active);
		userModel.setEmail(email);
		userModel.setPassword(password);
		userModel.setRole(role);
		userModel.setUsername(username);

		userModelRepository.save(userModel);
	}

}
