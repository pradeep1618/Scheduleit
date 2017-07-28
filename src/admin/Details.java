package admin;



import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Details {

	public WebElement findx(String xpath) {
		return SharedData.getInstance().getDriver()
				.findElement(By.xpath(xpath));
	}
	public static String uuid = RandomStringUtils.randomAlphabetic(8); 
	public static  String uint = RandomStringUtils.randomNumeric(3);
	public static String uid= RandomStringUtils.randomNumeric(8);
	public static String upin = RandomStringUtils.randomNumeric(5);
	
	
	// path for login section
	String basicURl = "https://app.pankaj.test.scheduleit.io";// https://app2.test.scheduleit.io/login
	String email_id = ".//input[@id='UserEmail']";
	String email_id_data = "rebecca.wheeling@scheduleit.io";//testadjuster4@gmail.com  redmimobile@amail.club test_admin_pradeep@amail.club
	String password = ".//input[@id='UserPassword']";
	String password_data = "Scheduleit123#";//sitest2016  123456
	String click_Sign_in_button = ".//button[contains(text(),'Sign in')]";

	// path for admin login

	String admin_email_id_data = "rebecca.wheeling@scheduleit.io";
	String admin_password_data = "Scheduleit123#";
	String click_manage_user = "//span[contains(.,'Manage Users')]";
	String click_admin_user = "//a[text()='Admin Users']";
	String add_new_admin = "//a[text()='Add admin user']";
	// new admin

	String first_name = "//input[@id='UserFname']";
	String first_name_value = "TEST "+uuid+"";//
	String update_last_name_value = "test Kumar";
	String last_name = "//input[@id='UserLname']";
	String last_name_value = "test"+uuid+"";
	String enter_email_id = "//input[@id='UserEmail']";
	String enter_email_value = "pradeep."+uuid+"@amail.club";
	String enter_password = "//input[@id='UserPassword']";
	String enter_password_value = "1234567";
	String enter_confirm_passoword = "//input[@id='UserRepassword']";
	String enter_confirm_password_value = "1234567";
	String enter_address = "//input[@id='UserAddress']";
	String enter_address_value = "617 E Main Street";
	String city = "//input[@id='UserCity']";
	String city_value = "Calfornia";
	String state = "//select[@id='UserStateName']";
	String state_value = "Kentucky";
	String zip_code = "//input[@id='UserZip']";
	String zip_code_value = "40175";
	String enter_phone_no = "//input[@id='UserPhone']";
	String enter_phone_no_value = "99"+uid+"0";
	String update_enter_phone_no_value = "998"+uid+"7";
	String click_submit_button = "//button[@id='sendEmail']";
	String check_for_invalid_email_id = "//div[text()='* This email address already exist']";

	// path for dashboard .//a[contains(text(), 'My Schedule')]/@href
	String click_my_schedule_button = "html/body/div[1]/aside/div[1]/div/ul/li[1]/a";
	String click_profile_schedule_button = ".//span[text()='Rebecca Testingwheeling']";
	String click_on_new_claim = ".//a[text()='Enter New Claim']";

	// Path for adding new claims
	public static String schedule_type = "SchedulingType";
	public static String schedule_type_value = "Residential";
	public static String Schedule_claim_id = "SchedulingClaimId";
	public static String Schedule_claim_id_value = "Flood Program";
	public static String Schedule_insured_country = "SchedulingInsuredCountry";
	public static String Schedule_insured_country_value = "United States";
	public static String Scheduling_Firm_Id = "SchedulingFirmId";
	public static String Scheduling_Firm_Id_value = "2B Claims Service";
	public static String IA_Firm_Number = ".//input[@id='SchedulingFirmNo']";
	public static String IA_Firm_Number_value = ""+uid+"";
	public static String IA_Firm_Number_value2 = "@demo";
	public static String Insured_first_name = ".//input[@id='SchedulingInsuredFname']";
	public static String Insured_first_name_value = "TEST"+uuid+"";
	public static String Insured_first_name_value1 = "+uuid+";
	public static String Insured_last_name = ".//input[@id='SchedulingInsuredLname']";
	public static String Insured_last_name_value = ""+uuid+"Name";
	public static String Insured_last_name_value1 = "Smart";
	public static String Business_name = ".//input[@id='SchedulingBuisnessName']";
	public static String Scheduling_Insured_Address = ".//input[@id='SchedulingInsuredAddress']";
	public static String Scheduling_Insured_Address_value = "E 37 smartdata inc";
	public static String Scheduling_Insured_City = ".//input[@id='SchedulingInsuredCity']";
	public static String Scheduling_Insured_City_value = "Miami";
	public static String Scheduling_Insured_StateName = "SchedulingInsuredStateName";
	public static String Scheduling_Insured_StateName_value = "NY";
	public static String postal_code = ".//input[@id='SchedulingInsuredZip']";
	public static String postal_code_value = "1"+upin+"";
	public static String Scheduling_Insured_Phone1 = ".//input[@id='SchedulingInsuredPhone1']";
	
	public static String Scheduling_Insured_Phone2 = ".//input[@id='SchedulingInsuredPhone2']";
	public static String Scheduling_Insured_Phone2_value = "9"+uid+"0";
	public static String Scheduling_Additional_phone1 = ".//input[@id='SchedulingInsuredPhone3']";
	public static String Scheduling_Additional_phone1_value = "9"+uid+"1";
	public static String Scheduling_Additional_phone2 = ".//input[@id='SchedulingInsuredPhone4']";
	public static String Scheduling_Additional_phone2_value="9"+uid+"2";
	public static String Scheduling_Date_Received = ".//input[@id='SchedulingDateReceived']";
	
	
	public static String Scheduling_date_select = "//a[text()='17']";
	public static String Scheduling_Time_Received = ".//input[@id='SchedulingTimeReceived']";
	public static String Scheduling_Time_Received_value = "1:30 PM";
	public static String Scheduling_Loss_Notice_Instruction = ".//textarea[@id='SchedulingLossNoticeInstruction']";
	public static String Scheduling_Loss_Notice_Instruction_value = "Dummy text for testing purpose";
	public static String Scheduling_Insurance_Company_id = "SchedulingInsuranceCompanyId";
	public static String Scheduling_Insurance_Company_id_value = "Acuity";
	public static String Scheduling_Claim_No = ".//input[@id='SchedulingClaimNo']";
	public static String Scheduling_Claim_No_value = ""+uid+"";
	public static String Scheduling_Claim_No_value1 = ""+uid+"";
	public static String Scheduling_insured_email_Id=".//input[@id='SchedulingInsuredEmailAddress']";
	public static String Scheduling_insured_email_Id_value="sarvjeets@smartdatainc.net";
	public static String Scheduling_Insured_mortgage =".//input[@id='SchedulingInsuredMortgageCompany']";
	public static String Scheduling_Insured_mortgage_value="Demo";
	// path for adding new schedulers
	public static String add_new_scheduler = ".//a[text()='Add Scheduler']";
	public static String click_scheduler = ".//a[text()='Schedulers']";
	public static String s_first_name = ".//input[@id='UserFname']";
	public static String s_first_name_value = "TEST "+uuid+"";
	public static String s_last_name = ".//input[@id='UserLname']";
	public static String s_last_name_value = ""+ uuid +"TEST";
	public static String s_address = ".//input[@id='UserAddress']";
	public static String s_address_value = "smartdatainc";
	public static String s_city = ".//input[@id='UserCity']";
	public static String s_city_value = "New York";
	public static String s_state = ".//select[@id='UserStateName']";
	public static String s_state_value = "";
	public static String s_zipcode = ".//input[@id='UserZip']";
	public static String s_zipcode_value = "416001";
	public static String s_phoneno = ".//input[@id='UserPhone']";
	public static String s_phoneno_value = "98"+uid+"6";
	public static String s_personal_emailid = ".//input[@id='UserEmail']";
	public static String s_personal_emailid_value = "testiing"+uuid+"@amaiil.club";
	public static String s_schedule_emailid = ".//input[@id='UserScheduleEmail']";
	public static String s_schedule_emailid_value = "testingadjuste@amaiil.club";
	public static String s_personal1_emailid = ".//input[@id='UserEmail']";
	public static String s_personal1_emailid_value = "zero@mail.com";
	public static String s_schedule1_emailid = ".//input[@id='UserScheduleEmail']";
	public static String s_schedule1_emailid_value = "zero11@mail.com";
	public static String s_password = ".//input[@id='UserPassword']";
	public static String s_password_value = "122";
	public static String s_confirm_password = ".//input[@id='UserRepassword']";
	public static String s_confirm_password_value = "122";
	public static String s_password_value1 = "124563";
	public static String s_confirm_password1_value = "124563";
	public static String s_submit_button = ".//button[@id='sendEmail']";
	public static String s_cama = ",";
	

	// Adding adjusters
	String a_click_adjuster = ".//a[text()='Adjusters']";
	String a_add_adjuster = ".//a[text()='Add Adjuster']";
	String a_first_name = ".//input[@id='first_name']";
	public static String a_first_name_value = "TEST "+uuid+ " ";
	String ra_first_name_value = "USA";
	String a_last_name = ".//input[@id='last_name']";
	String a_e_last_name = ".//input[@id='UserLname']";
	public static String a_last_name_value = "Pradeep "+uuid+"";
	String ra_last_name_value = ""+uuid+ "TEST";
	String a_email = ".//input[@id='email']";
	public static String a_email_value = "testeroftest"+uint+"@gmail.com";
	String a_email_value1 = "nu"+uuid+"@nada.email";
	String ra_email_value = "nu"+uuid+"@nada.email";
	String a_mobile = ".//input[@id='phone']";
	String a_e_mobile = ".//input[@id='UserPhone']";
	String a_mobile_value = "9"+uid+"5"; 
	String ra_mobile_value = "8"+uid+"5";
	String a_address = ".//input[@id='address']";
	String a_address_value = "smartdatainc cop"; 
	String ra_address_value = "429 Liberty Street ";
	String a_city = ".//input[@id='city']";
	String a_city_value = "Kentakey"; 
	String ra_city_value = "Elizabethtown";
	String a_state_value = "Florida";
	String ra_state_value = "Kentucky";
	String a_state = ".//select[@id='state']";
	String a_us_state = ".//select[@id='us_state']";
	String a_state_can = ".//select[@id='us_canada']";
	String a_postal_code = ".//input[@id='postal_code']";
	String a_postal_code_value = "16004"; 
	String ra_postal_code_value = "42701";
	String a_choose_schedule = ".//select[@id='scheduler_id']";
	String a_choose_schedule_value = "Rebecca Wheeling";
	String a_deploy_info = ".//a[text()='Deployment Information']";
	String a_team_info = ".//a[text()='Team Information']";
	String a_account_activation="//a[contains(.,'Account Activation')]";
	String a_input_send_sms="//select[@id='input-send_sms']";
	String a_input_sms="Send an email to the adjuster";
	String a_submit_button = ".//button[@id='sign_up']";
	String a_alert = ".//div[text()='Something went wrong. ERROR: A user already exists with this email address.']";
	String a_account_button = ".//a[text()='Account Information']";
	String a_alert2 = ".//div[text()='Something went wrong.']";
	String a_e_submit_button = ".//button[@id='sendEmail']";
	String a_adjuster_email = "//td[contains(.,'"+a_email_value+"')]//preceding::a[@title='Choose adjuster']";
	String a_deploy_address = "Main Street New Jersey, 1st Cross";
	public static String a_deploy_city = "New Jersey";
	String a_deploy_address1 = "Main Street Peace City, 1st Cross";
	public static String a_deploy_city1 = "Peace City";
	

	// Set password
	String a_set_password = ".//input[@id='UserNewpassword']";
	String a_set_password_value = "123456";
	String a_confirm_password = ".//input[@id='UserConfirmpassword']";
	String a_confirm_password_value = "123456";

	// Adjuster google sync
	String active_status = "";
	String deactive_status = ".//a[@title='Deactive']";
	String deactive_status_go = "";
	String terms = ".//h3[text()='Terms of Service']";
	String i_agree_checkbox = ".//input[@id='TermCheck']";
	String sign = ".//input[@id='TermSignature']";
	String sign_value = "Sarvjeet";
	String agree_button = ".//input[@id='acceptTerm']";
	String change_role = ".//a[@title='Change Role']";
	String change_role2 = ".//a[@title='Change Role']";
	// Adjuster section
	String click_show_schedule = ".//a[text()='Show Schedule']";
	String click_sync_button = ".//a[text()='Sync']";
	String login_google = ".//input[@id='Email']";
	String login_google_value = "sarvjeets.sdei@gmail.com";
	String click_next_google = ".//input[@id='next']";
	String password_google = ".//input[@id='Passwd']";
	String password_google_data = "S9876744636";
	String login_button = ".//input[@id='signIn']";
	String click_allow_button=".//button[@id='submit_approve_access']";
	String click_menu_button=".//a[@class='gb_b gb_Vb']";
	String click_at_calendar =".//a[@id='gb24']";

	// search scheduler
	// This feature is updated
	//String switche_role = ".//span[text()='Switch Role']";
	//String click_scheduler_for_role_change = ".//a[text()='Scheduler']";
	String switch_scheduler=".//span[text()='Switch to Scheduler']";
	String search_adjuster = ".//input[@id='l_name']";
	String search_adjuster_value = "TEST";
	String click_search_button = ".//button[@class='btn btn-primary']";
	String choose_seach_adjuster = ".//a[@class='btn btn-primary']";

	// add new firms and Carriers
	String schedular_name = ".//span[text()='sarvjeet singh']";
	String click_manage_adjuster = ".//a[text()='Manage Adjuster']";
	String click_firms = ".//a[@id='tab-content-firms_and_carriers']";
	String select_firm = ".//select[@id='suggest_firm']";
	String select_firm_value = "89";
	String submit_firm_value = ".//input[@id='formsub']";
	String select_firm2 = "//select[@id='suggest_firm']";
	String select_firm2_value = "104";
	String add_new_carrier = ".//h2[@class='glyphicon glyphicon-th-list edit_firm']";
	String select_insurance_companines = ".//select[@id='insurance_companies']";
	String select_insurance_companines_value = "146";
	String add_carrier = ".//button[@id='addCarrier']";
	String close_button = ".//button[@id='cboxClose']";
	String click_at_new_claim = ".//a[@id='navigation-link_enter_new_claim']";

	// Scheduler will search adjuster, if adjuster is not found, then system
	// will created adjuster
	String click_myaccount = "//span[text()='My Account']";
	String click_return_to_admin_role = ".//a[text()='Return to Admin Role']";
	String click_at_logout=".//a[text()='Logout']";

	// checking claim is present or not
	String click_at_show_claims = ".//a[text()='Show Schedule']";
	String No_claim_available = ".//p[text()='No claims']";

	// Set date for a claim
	String click_claim = ".//a[text()='Demo2, Demo']";
	String click_claim1 = ".//a[text()='singh, Sarvjeet']";
	String selet_date_for_appointment = ".//input[@id='AppointmentAppointmentDate']";
	String select_date_for_appointment_value = "2016-09-29";
	String select_date_for_appoitment_value1 = "2016-09-30";
	String select_time = ".//input[@id='AppointmentStartTime']";
	String select_time_value = "9:30 AM";
	String select_endtime = ".//input[@id='AppointmentEndTime']";
	String select_endtime_value = "10:30 PM";
	String select_appointment_status = ".//select[@id='AppointmentStatus']";
	String select_appoitment_value = "4";
	String select_appoitment_value1 = "9";
	String submit_appointment = ".//input[@id='submit_btn']";
	String register_text = ".//div[text()='Claim Details']";
	String insured_tab = ".//a[@id='tab-insured_info']";
	String Question_tab = ".//a[@id='tab-claim_questions']";
	String note_tab = ".//a[@id='tab-notes']";
	String upload_tab = "";
	String billing_tab = "";
	String edit_i_spoke_to = ".//input[@id='JobFieldClaimNo']";
	String edit_i_spoke_to_value = "rahul";
	String edit_i_age_of_house = ".//input[@id='JobFieldAgeOfHouse']";
	String edit_i_age_of_house_value = "10";
	String edit_basement = ".//select[@id='JobFieldBasement']";
	String edit_basement_value = "Yes";
	String edit_i_ishouselivable = ".//select[@id='JobFieldHomeLiveable']";
	String edit_i_ishouselivable_value = "Yes";
	String edit_i_damage = ".//input[@id='JobFieldNoOfRooms']";
	String edit_i_damage_value = "10";
	String edit_i_content = ".//select[@id='JobFieldContentsDamage']";
	String edit_i_content_value = "Yes";
	String edit_i_will_ho_home = ".//select[@id='JobFieldAtHome']";
	String edit_i_will_ho_home_value = "Yes";
	String edit_mortage = ".//input[@id='JobFieldMortageCo']";
	String edit_mortge_value = "10";
	String edit_email = ".//input[@id='JobFieldEmailAddress']";
	String edit_email_value = "sarvj@mail.com";
	String edit_i_onway = ".//input[@id='lname']";
	String edit_contact_name = ".//input[@id='JobFieldContactName']";
	String edit_contact_name_value = "sarvjeet";
	String edit_contact_number = ".//input[@id='JobFieldContactNo']";
	String edit_contact_number_vale = "9876744636";
	String edit_comm = ".//textarea[@id='JobFieldComments']";
	String edit_comm_value = "Dummy text";
	String click_update_button = ".//input[@class='btn submi']";
	String edit_i_basement = "";

	// Add firms from admin
	String click_manage_IA_firm = ".//span[text()='Manage IA Firms']";
	String click_firm_name = "//input[@id='FirmName']";
	String click_firm_name_value = "Test"+ uuid +"";
	String click_submit_firm_button = "//button[@id='createFirm']";
	String search_IA_firm = ".//input[@aria-controls='firm-listing']";
	String search_IA_firm_value = "Text";
	String click_on_edit_button = ".//a[@title='Edit Firm']";
	String edit_carrier_id = "//input[@id='DatasetsXactwareFirmsDatasetId']";
	String edit_submit_button = ".//button[@id='sendEmail']";

	
	// Reports
	String click_at_report=".//span[text()='Reports']";
	String click_at_active_adjuster_report=".//a[text()='Active Adjuster Report']";
	String a_select_to_date=".//input[@id='AppointmentFromDate']";
	String a_select_to_date_value="04-01-2017";
	String a_select_from_date=".//input[@id='AppointmentToDate']";
	String a_select_from_date_value="05-15-2017";
	String click_preview_button=".//input[@class='btn abc']";
	String Click_at_print_report="";
	// Deployment report
	String click_at_deployment_location="//a[text()='Deployment Location']";
	String click_at_report_start_date=".//input[@id='ReportStartDate']";
	String click_at_report_end_date=".//input[@id='ReportEndDate']";
	
	//Notes tab
	String add_a_note=".//select[@id='NotesTemplateId']";
	String add_a_note_value="8";
	String click_at_add_button=".//button[@id='add-note']";
	
//	Mange Questions
	public static String q_Manage_Questions = "//span[contains(.,'Manage Claim Questions')]";
	public static String q_createQuestion = "//a[@href='/ClaimQuestions/createQuestion']";
	public static String q_Radio_Buttons = "//label[contains(.,'Radio Buttons')]";
	public static String q_next_button = "//a[contains(.,'Next')]";
	public static String q_schedulers_question = "Test " + uuid + " Scheduler";
	public static String q_adjuster_question= "Test " + uuid + " Adjuster";
	public static String q_insured_question= "Test " + uuid + " Insured";
	public static String q_google_question="Test " +uuid + " Google";
	public static String q_schedulers_question2 = "Test 2 " + uuid + " Scheduler";
	public static String q_adjuster_question2= "Test " + uuid + " Adjuster";
	public static String q_insured_question2= "Test " + uuid + " Insured";
	public static String q_google_question2="Test " +uuid + " Google";
	

	
	
		
	

}
