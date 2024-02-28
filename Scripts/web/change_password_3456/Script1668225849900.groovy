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

WebUI.callTestCase(findTestCase('web/utils/open_browser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('web/utils/signin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('web/utils/go_to_profile'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('web/Page_Features - Lore Health/button_Change_password'))

WebUI.switchToWindowTitle('Lore Health')

WebUI.setText(findTestObject('web/Page_Lore Health/input_Old Password_oldPassword'), findTestData('null').getValue(
        2, 1))

WebUI.setText(findTestObject('web/Page_Lore Health/input_New Password_newPassword'), findTestData('null').getValue(
        2, 1))

WebUI.setText(findTestObject('web/Page_Lore Health/input_Confirm New Password_reenterPassword'), findTestData('null').getValue(
        2, 1))

WebUI.click(findTestObject('web/Page_Lore Health/button_Continue'))

WebUI.delay(3)

WebUI.switchToWindowTitle('Features - Lore Health')

WebUI.click(findTestObject('web/Page_Features - Lore Health/button_Sign out'))

WebUI.callTestCase(findTestCase('web/utils/signin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('web/Page_Lore Health/logged_in_username'), findTestData('null').getValue(
        3, 1))

