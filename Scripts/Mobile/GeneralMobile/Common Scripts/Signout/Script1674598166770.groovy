import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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
import org.openqa.selenium.Keys as Keys

//Sign out
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/MenuIcons/Button_MessagesMenuIconAfterSignin'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/MenuIcons/Button_ProfileMenuIconAfterSignin'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/Profile/Image_ProfileSettingsIcon'),
	GlobalVariable.WaitPeriod)

Mobile.swipe(600, 1300, 600, 1900)

Mobile.tap(findTestObject('Object Repository/Mobile/Profile/Image_ProfileSettingsIcon'), GlobalVariable.WaitPeriod)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/Profile/View_SettingsText'),
	GlobalVariable.WaitPeriod)
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/Profile/Label_PersonalInformation'),
	GlobalVariable.WaitPeriod)


Mobile.scrollToText('Sign out')
if (! Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile/Profile/Label_RequestToDeleteAccount'), 5, FailureHandling.CONTINUE_ON_FAILURE)) {
	Mobile.swipe(600, 1900, 600, 1700)
}

Mobile.tap(findTestObject('Object Repository/Mobile/Profile/Button_ProfileSignout'), 0)