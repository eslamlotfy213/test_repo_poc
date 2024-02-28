import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils as StringUtils
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.io.FileUtils as FileUtils
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import io.appium.java_client.MobileElement as MobileElement

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/LaunchApp'), [:], FailureHandling.STOP_ON_FAILURE)

//Credentials
WebUI.callTestCase(findTestCase('Test Cases/Mobile/GeneralMobile/Common Scripts/Profile - Sign in button'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Signin/Button_ContinueSignin'), GlobalVariable.WaitPeriod)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signin/Text_SigninUsername'), Email, 30)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signin/Text_SigninPassword'), Password, 30)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signin/Button_ContinueSignin'), 30)

GlobalVariable.ValidationMessage = Expected


//steps 
// get expwcte from excel sheet as variab expeted 
Mobile.verifyElementText(findTestObject('Object Repository/Mobile/General/Signin/Sign in validate message'), GlobalVariable.ValidationMessage , FailureHandling.STOP_ON_FAILURE)
//Close App
Mobile.closeApplication(FailureHandling.STOP_ON_FAILURE)