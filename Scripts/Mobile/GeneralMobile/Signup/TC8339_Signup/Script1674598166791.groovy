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
 * TC ID: 8339
 * TC Title: As Guest User, i need to be able to sign up
 * Scenario:
	 * Press Create an account
	 * Then Press Signup
	 * Enter Email, Password, and Confirm Password
	 * Check terms & understanding 
	 * Press Continue
	 * Enter Display Name & Interests & Continue
	 * Assert that the display name is displayed at Home
	 * Sign out then sign in with the new account
	 * Assert that the user is able to sign in by asserting that the display name is displayed at home 
 */

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/LaunchApp'), [:], FailureHandling.STOP_ON_FAILURE)

//Credentials
String email = 'elotfy_Automation_'+GlobalVariable.DateWithoutCharacters+'@sequel.com'
String password = 'user123#'

//Generate Unique Display Name
String path = System.getProperty("user.dir")+"\\External Test Data\\DisplayNameCounter.txt";
File file = new File(path)
String displayNameID = FileUtils.readFileToString(file)
FileUtils.write(file, ((displayNameID.toInteger())+1).toString(), false)
String displayName = 'DisplayName_'+displayNameID
GlobalVariable.DisplayName = displayName

//Signup
Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Button_CreateAnAccount'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Signup/Button_SignUp'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Button_SignUp'), 0)

//Enter Credentials, agree & Continue
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Signup/Text_Email'), GlobalVariable.WaitPeriod)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signup/Text_Email'), email, 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signup/Text_Password'), password, 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signup/Text_ConfirmPassword'), password, 0)

Mobile.checkElement(findTestObject('Object Repository/Mobile/General/Signup/Check_AgreeTerms'),0)

Mobile.checkElement(findTestObject('Object Repository/Mobile/General/Signup/Check_UnderstandContent'),0)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Button_Continue'), 0)

//Display Name & interests & Continue

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Signup/Text_DisplayName'), GlobalVariable.WaitPeriod)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signup/Text_DisplayName'), displayName, 0)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Button_ContinueSignup'), 0)

GlobalVariable.InterestName = 'Activity and Exercise'

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Signup/Label_InterestName'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Label_InterestName'), 0)

GlobalVariable.InterestName = 'Mental Health and Well-Being'

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Label_InterestName'),    0)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Button_ContinueSignup'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Signup/Label_ThanksForSigningup'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signup/Button_ContinueSignup'), 0)

//Assert on home username
Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/Signup/Label_HomeUsername'), 0)

//Signout
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/Signout'), [:], FailureHandling.STOP_ON_FAILURE)

//Signin & Assert on home username
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/GoToProfileAndPressSignIn'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/SignIn'), [('Username') : email, ('Password') : password], FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/Signup/Label_HomeUsername'), 0)

//Signout
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/Signout'), [:], FailureHandling.STOP_ON_FAILURE)

//Close App
Mobile.closeApplication()

