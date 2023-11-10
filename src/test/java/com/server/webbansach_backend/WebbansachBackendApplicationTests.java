package com.server.webbansach_backend;

import com.server.webbansach_backend.entity.TheLoai;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebbansachBackendApplicationTests {

	@Test
	void contextLoads(){
		TheLoai theLoai =new TheLoai();
		theLoai.setMaTheLoai(1);
	}

}
