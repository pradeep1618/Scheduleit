package admin;

import org.openqa.selenium.By;

public class Repositories {

//	Manage Questions Repositories 
	public static By q_Manage_Claim_Questions = By.xpath(".//li[contains(.,'Manage Claim Questions')]");
	public static By q_Manage_questions = By.xpath(".//a[contains(.,'Manage questions')]");
	public static By q_Add_a_question = By.xpath(".//a[contains(.,'Add a question')]");
	public static By q_drop_down = By.xpath(".//input[@id='ClaimQuestionClaimQuestionTypeId3']");
	public static By q_radio_question=By.xpath(".//input[@id='ClaimQuestionClaimQuestionTypeId6']");
	public static By q_Next_Button=By.xpath(".//a[contains(.,'Next ')]");
	public static By q_schedulers_question = By.xpath(".//input[@id='ClaimQuestionClaimQuestionAssistantText']");
	public static By q_adjuster_question = By.xpath(".//input[@id='ClaimQuestionClaimQuestionAdjusterText']");
	public static By q_insured_question = By.xpath(".//input[@id='ClaimQuestionClaimQuestionInsuredText']");
	public static By q_google_question= By.xpath(".//input[@id='ClaimQuestionClaimQuestionReportGoogleText']");
	public static By q_radio_option_type =By.xpath("//div[@id='question-option-box-0']//following::input[@name='data[ClaimQuestionOption][0][value]']");
	public static By q_radio_option_type1=By.xpath("//div[@id='question-option-box-0']//following::input[@name='data[ClaimQuestionOption][1][value]']");
	public static By q_Add_Another_Option=By.xpath(".//a[contains(.,'add another')]");
//	public static By q_radio_extra = By.xpath("//div[@id='question-option-box-0']//following::input[@name='data[ClaimQuestionOption]["+i+"][value]']");
	public static By q_Submit_Button=By.xpath(".//button[contains(.,'Submit')]");
	public static By q_type_of_question_text =By.xpath(".//input[@id='ClaimQuestionClaimQuestionTypeId1']//following::label[@for='ClaimQuestionClaimQuestionTypeId1']");	
	public static By  q_type_of_question_option = By.xpath(".//input[@id='ClaimQuestionClaimQuestionTypeId1']");
	public static By q_Manage_Set_Questions = By.xpath(".//a[contains(.,'Manage question sets')]");
	public static By q_Add_set_question_button = By.xpath(".//a[contains(.,'Add questions to set')]");
	public static By q_Set_Question_dropDown = By.xpath(".//select[@id='ClaimTypesToClaimQuestionClaimQuestionId']");
	public static By q_Has_Child_Question = By.xpath(".//label[contains(.,'has child question? ')]");
	public static By q_question_order = By.xpath(".//input[@id='ClaimTypesToClaimQuestionOrder']");
	public static By q_parent_question_check = By.xpath(".//label[contains(.,'Is parent question? ')]");
	public static By q_noOf_questions_per_Page =By.xpath(".//select[@aria-controls='manageSetQuestionsTable']");
	public static By q_Add_Dependency_button = By.xpath(".//a[contains(.,'Add dependency')]");
	public static By q_dependency_Ans_Type =By.xpath(".//input[@id='ClaimQuestionDependencyValue']");
	public static By q_dependency_to_which_ques = By.xpath(".//select[@id='ClaimQuestionDependencyDependsOnQuestionId']");
	public static By q_Go_back_to_manage_set_questions =By.xpath(".//a[contains(.,'Go back to manage set questions')]");
	public static By q_Manage_question_img = By.xpath(".//td[contains(.,'"+Details.q_schedulers_question+"')]//following::a[@title='Manage Dependencies'][1]");
	
	
	
//Fresh Claim Repositories 	
	public static By f_Switch_to_Scheduler = By.xpath("//li[contains(.,'Switch to Scheduler')]");
	public static By f_Adjuster_Search = By.id("l_name");
	public static By f_Adjuster_Ser_Btn = By.xpath("//button[@class='btn btn-primary']");
	public static By f_Adjuster_Choose_Btn = By.xpath("//td[contains(.,'"+Details.a_email_value+"')]//preceding::a[@title='Choose adjuster'][1]");
	public static By f_Manage_adjuster_Btn =By.xpath("//div/a[contains(.,'Manage Adjuster')]");
	public static By f_Firm_Adjuster_linl = By.xpath("//li/a[@id='tab-content-firms_and_carriers']");
	public static By f_Firm_drop = By.xpath("//select[@id='suggest_firm']");
	public static By f_Associate_btn = By.xpath("//input[@id='formsub']");
	public static By f_Insurance_Comp_Asso = By.xpath("//tbody[@class='add_here_firm']//following::h2[@data-tabname='carrier_tab']");
	public static By f_Insurance_comp_drop = By.xpath("//select[@id='insurance_companies']");
	public static By f_Add_Insurance_Comp =By.xpath("//button[@id='addCarrier']");
	public static By f_Adjuster_lnk = By.xpath("//span[contains(.,'"+Details.a_first_name_value+" "+Details.a_last_name_value +"')]");
	public static By f_Enter_new_Claim_btn = By.xpath("//a[@id='navigation-link_enter_new_claim']");
	public static By f_insurance_type = By.id("SchedulingType");
	public static By f_scheduler_type = By.id(Details.Schedule_claim_id);
	public static By f_Insured_Couontry =By.id(Details.Schedule_insured_country);
	public static By f_Schedule_firm = By.id(Details.Scheduling_Firm_Id);
	public static By f_IA_firm_number = By.xpath(Details.IA_Firm_Number);
	public static By f_Insured_Fir_Name =By.xpath(Details.Insured_first_name);
	public static By f_Insured_las_Name = By.xpath(Details.Insured_last_name);
	public static By f_business_name =  By.xpath(Details.Business_name);
	public static By f_Insured_address = By.xpath(Details.Scheduling_Insured_Address);
	public static By f_insured_city = By.xpath(Details.Scheduling_Insured_City);
	public static By f_Insured_state = By.id(Details.Scheduling_Insured_StateName);
	public static By f_Post_Code = By.xpath(Details.postal_code);
	public static By f_Insured_Phone1 = By.xpath(Details.Scheduling_Insured_Phone1);
	public static By f_Insured_phone2 = By.xpath(Details.Scheduling_Insured_Phone2);
	public static By f_Insured_Email = By.xpath(Details.Scheduling_insured_email_Id);
	public static By f_Mortgage = By.xpath(Details.Scheduling_Insured_mortgage);
	public static By f_Loss_Address = By.xpath(Details.Scheduling_Loss_Notice_Instruction);
	public static By f_Insurance_Company_drop = By.id(Details.Scheduling_Insurance_Company_id);
	public static By f_Claim_no = By.xpath(Details.Scheduling_Claim_No);
	public static By f_Submit_route_btn = By.xpath(".//span[text()='Submit and Route']");
	public static By f_Schedule_type_drop = By.xpath("//select[@id='SchedulingClaimId']");
	public static By f_Tab_Questions_lnk = By.xpath("//a[@id='tab-claim_questions']");
	public static By f_Tab_update_Btn = By.xpath("//input[@class='btn btn-primary']");
	
	public static By f_Schedulded_lnk = By.xpath("//span[contains(.,'"+Details.a_first_name_value+" "+Details.a_last_name_value +"')]");
	public static By f_Show_Schedule_Lnk = By.xpath("//li//a[contains(.,'Show Schedule')]");
	public static By f_claim_Schedule_DIV = By.xpath(".//div[@id='planning-menu']/div[contains(.,'Claims to Schedule')]");
	public static By f_Insured_Person_lnk_schedule = By.xpath("//li[contains(.,'"+Details.Insured_last_name_value+", " +Details.Insured_first_name_value+"')]");
	public static By f_Appointment_date = By.xpath(".//input[@id='AppointmentAppointmentDate']");
	public static By f_Appointment_Start_Time = By.xpath(".//input[@id='AppointmentStartTime']");
	public static By f_Appointment_End_Time = By.xpath(".//input[@id='AppointmentEndTime']");
	public static By f_Appointment_Type = By.id("AppointmentStatus");
	public static By f_Add_btn_last = By.xpath("//input[@id='submit_btn']");
	
	
//	Adjusters Repositories
	
	public static By a_Edit_btn = By.xpath("//td[contains(.,'"+Details.a_email_value+"')]//following::a[contains(.,'Edit Submission')][1]");
	public static By a_deop_chck = By.xpath("//input[@id='input-deployment_is_same']");
	public static By a_deop_address = By.xpath("//input[@name='deployment_address']");
	public static By a_deop_city = By.xpath("//input[@name='deployment_city']");
	public static By a_deop_state = By.xpath("//select[@id='deployed_us_state']");
	public static By a_deop_state_cana = By.xpath("//select[@id='deployed_us_canada']");
	public static By a_deop_post_code = By.xpath("//input[@name='deployment_postal_code']");
	public static By a_deop_switch_sh_lk = By.xpath("//li//span[contains(.,'Switch to Scheduler')]");
	public static By a_search_adjuster = By.xpath(".//input[@id='l_name']");
	public static By a_Adjuster_Choose_Btn = By.xpath("//td[contains(.,'"+Details.a_email_value+"')]//preceding::a[@title='Choose adjuster'][1]");
	public static By a_Manage_adjuster_Btn =By.xpath("//div/a[contains(.,'Manage Adjuster')]");
	public static By a_Deploy_Address_linl = By.xpath("//li/a[@id='tab-content-deployment_info']");
	public static By a_deop_add_bloc = By.xpath("//input[@id='UserdetailAddress']");
	public static By a_deop_city_bloc=By.xpath("//input[@id='UserdetailCity']");
	public static By a_deop_zip_bloc=By.xpath("//input[@id='zip_us']");
	public static By a_user_account = By.xpath("//li//span[contains(.,'My Account')]");
	public static By a_admin_role_bk = By.xpath("//li//a[contains(.,'Return to Admin Role')]");
	
	
//	TEst
	public static By element =By.xpath("//td[contains(.,'sarvjeets@smartdatainc.net')]//following::a[contains(.,'Edit Submission')][1]");
	
	
	
	
}
