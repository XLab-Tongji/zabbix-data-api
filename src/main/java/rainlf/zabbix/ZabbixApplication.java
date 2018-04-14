package rainlf.zabbix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZabbixApplication {

	private static final Logger logger = LoggerFactory.getLogger(ZabbixApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ZabbixApplication.class, args);
	}
}
