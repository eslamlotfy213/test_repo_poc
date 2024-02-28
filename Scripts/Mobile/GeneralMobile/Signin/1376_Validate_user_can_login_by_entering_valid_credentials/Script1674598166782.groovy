import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.apache.commons.io.FileUtils
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.MobileElement

/*
 * TC ID: 1372
 * TC Title: [Community][Sign in]Validate user can't log in with a invalid email and password
 * Scenario:
	 * Navigate to GHP https://ghp-test.gatherhealth.io/home as Guest user
	 * click on sign in button 
	 * enter valid credentials and click continue 
	 * Verify user can login by entering valid credentials and clicking on the ‘continue’ button 
 */


//Credentials
String email = 'TestUser_'+GlobalVariable.DateWithoutCharacters+'@sequel.ae'
String password = 'user123#'

String wrongemail = 'TestUser_'+GlobalVariable.DateWithoutCharacters+'@sequel.ae'
String wrongpassword = 'user123##'
String wrongmessage = "We can't seem to find your account"

//Generate Unique Display Name
String path = System.getProperty("user.dir")+"\\External Test Data\\DisplayNameCounter.txt";
File file = new File(path)
String displayNameID = FileUtils.readFileToString(file)
FileUtils.write(file, ((displayNameID.toInteger())+1).toString(), false)
String displayName = 'DisplayName_'+displayNameID
GlobalVariable.DisplayName = displayName


WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/LaunchApp'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Mobile/GeneralMobile/Common Scripts/Profile - Sign in button'), [:], FailureHandling.STOP_ON_FAILURE)

//SignIn

WebUI.callTestCase(findTestCase('Test Cases/Mobile/GeneralMobile/Common Scripts/SignIn'), [('Username') : GlobalVariable.Username, ('Password') : GlobalVariable.Password], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(   findTestObject('Object Repository/Mobile/General/Signin/android.widget.TextView - elotfy')     , 0)


//Close Ap
Mobile.closeApplication()

