package com.cpe.backend;
import com.cpe.backend.Addjob.entity.Addjob;
import com.cpe.backend.JobPost.entity.Benefit;
import com.cpe.backend.RegisterCompany.entity.Company;
import com.cpe.backend.RegisterCompany.entity.CompanySize;
import com.cpe.backend.RegisterCompany.entity.CompanyType;
import com.cpe.backend.RegisterUser.entity.Gender;
import com.cpe.backend.Addjob.entity.Information;
import com.cpe.backend.JobPost.entity.JobPost;
import com.cpe.backend.RegisterUser.entity.NameType;
import com.cpe.backend.RegisterUser.entity.PhoneType;
import com.cpe.backend.JobPost.entity.Position;
import com.cpe.backend.RegisterCompany.entity.Province;
import com.cpe.backend.RegisterUser.entity.User;

import com.cpe.backend.Addjob.repository.AddjobRepository;
import com.cpe.backend.JobPost.repository.BenefitRepository;
import com.cpe.backend.RegisterCompany.repository.CompanyRepository;
import com.cpe.backend.RegisterCompany.repository.CompanySizeRepository;
import com.cpe.backend.RegisterCompany.repository.CompanyTypeRepository;
import com.cpe.backend.RegisterUser.repository.GenderRepository;
import com.cpe.backend.Addjob.repository.InformationRepository;
import com.cpe.backend.JobPost.repository.JobPostRepository;
import com.cpe.backend.RegisterUser.repository.NameTypeRepository;
import com.cpe.backend.RegisterUser.repository.PhoneTypeRepository;
import com.cpe.backend.JobPost.repository.PositionRepository;
import com.cpe.backend.RegisterCompany.repository.ProvinceRepository;
import com.cpe.backend.RegisterUser.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AddjobRepository addjobRepository,BenefitRepository benefitRepository,CompanyRepository companyRepository,
	CompanySizeRepository companySizeRepository,CompanyTypeRepository companyTypeRepository,GenderRepository genderRepository,
	InformationRepository informationRepository,JobPostRepository jobPostRepository,NameTypeRepository nameTypeRepository, 
	PhoneTypeRepository phoneTypeRepository, PositionRepository positionRepository, ProvinceRepository provinceRepository,
	UserRepository userRepository) {
		return args -> {
			Stream.of("นาย", "นาง","นางสาว").forEach(name -> {
				NameType nameType = new NameType(); // สร้าง Object Customer
				nameType.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				nameTypeRepository.save(nameType); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ชาย", "หญิง").forEach(name -> {
				Gender gender = new Gender(); // สร้าง Object Employee
				gender.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				genderRepository.save(gender); // บันทึก Objcet ชื่อ Employee
			});

			Stream.of("บริษัท", "มือถือ", "โทรศัพท์บ้าน").forEach(name -> {
				PhoneType phoneType = new PhoneType(); // สร้าง Object Customer
				phoneType.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				phoneTypeRepository.save(phoneType); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("วิสาหกิจขนาดย่อม","วิสาหกิจขนาดกลาง", "วิสาหกิจขนาดใหญ่").forEach(name -> {
				CompanySize size = new CompanySize();
				size.setName(name);
				companySizeRepository.save(size);
			});
			
			Stream.of("กิจการเจ้าของคนเดียว", "ห้างหุ้นส่วนสามัญ", "ห้างหุ้นส่วนจำกัด","บริษัทจำกัด", "บริษัทมหาชนจำกัด", "องค์กรธุรกิจ").forEach(name -> {
				CompanyType type = new CompanyType();
				type.setName(name);
				companyTypeRepository.save(type);
			});

			Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชัยนาท","ชัยภูมิ","ชุมพร"
			,"ชลบุรี","เชียงใหม่","เชียงราย","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช"
			,"นครสวรรค์","นราธิวาส","น่าน","นนทบุรี","บึงกาฬ","บุรีรัมย์","ประจวบคีรีขันธ์","ปทุมธานี","ปราจีนบุรี","ปัตตานี","พะเยา"
			,"พระนครศรีอยุธยา","พังงา","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พัทลุง","ภูเก็ต","มหาสารคาม","มุกดาหาร"
			,"แม่ฮ่องสอน","ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร"
			,"สงขลา","สมุทรสาคร","สมุทรปราการ","สมุทรสงคราม","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี"
			,"สุรินทร์","สตูล","หนองคาย","หนองบัวลำภู","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี","อ่างทอง").forEach(name -> {
				Province province = new Province();
				province.setName(name);
				provinceRepository.save(province);
			});

			Stream.of("ผู้จัดการฝ่ายบัญชี","พนักงานบัญชี", "หัวหน้าฝ่ายบัญชี","เจ้าหน้าที่ฝ่ายธุรการ", "ผู้จัดการฝ่ายธุรการ","แอร์ โอสเตส",
			"สถาปนิก","ผู้กำกับฝ่ายศิลป์","วิศวกรทางด้านภาพและเสียง" ,"ผู้ตรวจสอบบัญชี","พนักงานรับจ่ายเงิน","พนักงานเก็บบิล/เงิน",
			"นายหน้าค้าหุ้นและพันธบัตร","ผู้จัดการฝ่ายงบประมาณ","นักวิเคราะห์ทางธุรกิจ","ที่ปรึกษาทางธุรกิจ","ผู้บริหารระดับสูง","วิศวกรโยธา",
			"ช่างเทคนิคทางด้านสี","เจ้าหน้าที่ฝ่ายสินเชื่อธุรกิจ","ผู้ออกแบบภาพเคลื่อนไหว","วิศวกรด้านการออกแบบ","วิศวกรไฟฟ้า","นักออกแบบเสื้อผ้า",
			"พนักงานทำความสะอาด","วิศวกรอุตสาหกรรม").forEach(name -> {
				Position position = new Position(); 
				position.setName(name); 
				positionRepository.save(position); 
			});

			Stream.of("ค่าน้ำมันรถ (ในพื้นที่, นอกพื้นที่)","ค่าโทรศัพท์","ประกันชีวิตพนักงานรายวัน,รายเดือน","โบนัส และ การปรับค่าจ้างประจำปี","กองทุนเงินทดแทน","รถส่วนตัว","ห้องพยาบาล","ตรวจสุขภาพประจำปี").forEach(name -> {
				Benefit benefit = new Benefit(); 
				benefit.setName(name); 
				benefitRepository.save(benefit); 
			});
			
			Stream.of("Website","Newspaper", "Email").forEach(name -> {
				Information information = new Information(); // สร้าง Object Employee
				information.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				informationRepository.save(information); // บันทึก Objcet ชื่อ Employee
			});
			
			nameTypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			genderRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			phoneTypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
			companySizeRepository.findAll().forEach(System.out::println); // 
			provinceRepository.findAll().forEach(System.out::println); // 
			companyTypeRepository.findAll().forEach(System.out::println); // 
			companyRepository.findAll().forEach(System.out::println); 
			positionRepository.findAll().forEach(System.out::println);
			benefitRepository.findAll().forEach(System.out::println); 
			informationRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal	
		};
	}

}