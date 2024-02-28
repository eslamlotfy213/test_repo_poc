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

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_First Name'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_First Name'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('web/Page_Features - Lore Health/input_First Name'), 'MyFirstname')

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_lastName'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_lastName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('web/Page_Features - Lore Health/input_lastName'), 'mylastname')

WebUI.setText(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), '0019800101')

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_cellphone'), '09876543210')

not_run: WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Phone Number_streetAddress'), 'Street 1')

not_run: WebUI.setText(findTestObject('web/Page_Features - Lore Health/input_Street Addres_city'), 'Cebu')

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_zipCode'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_zipCode'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('web/Page_Features - Lore Health/input_zipCode'), '10000')

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/select_SexAssignedAtBirth'), 'Decline to answer')

WebUI.click(findTestObject('web/Page_Features - Lore Health/button_Save Changes'))

WebUI.waitForElementPresent(findTestObject('web/Page_Features - Lore Health/div_Your info has been updated'), 3)

WebUI.refresh()

WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_First Name'), 'value', 'MyFirstname', 
    10)

WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), 'value', '1980-01-01', 
    10)

WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_cellphone'), 'value', '(098) 765-4321', 
    10)

not_run: WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_Phone Number_streetAddress'), 
    'value', 'Street 1', 10)

not_run: WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_Street Addres_city'), 'value', 
    'Cebu', 10)

WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_zipCode'), 'value', '10000', 10)

WebUI.verifyTextPresent('Decline to answer', false)

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_First Name'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_First Name'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_lastName'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_lastName'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_lastName'), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_cellphone'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_cellphone'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_City_state'), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/input_State_zipCode'), Keys.chord(Keys.BACK_SPACE))

not_run: WebUI.clearText(findTestObject('web/Page_Features - Lore Health/input_First Name'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.clearText(findTestObject('web/Page_Features - Lore Health/input_Zipcode_cellphone_old'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.clearText(findTestObject('web/Page_Features - Lore Health/input_Phone Number_streetAddress'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.clearText(findTestObject('web/Page_Features - Lore Health/input_Street Addres_city'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.clearText(findTestObject('web/Page_Features - Lore Health/input_zipCode'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('web/Page_Features - Lore Health/select_SexAssignedAtBirth'), 'Select an answer')

WebUI.delay(1)

WebUI.click(findTestObject('web/Page_Features - Lore Health/button_Save Changes'))

WebUI.waitForElementPresent(findTestObject('web/Page_Features - Lore Health/div_Your info has been updated'), 3)

WebUI.refresh()

WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_First Name'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_cellphone'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('web/Page_Features - Lore Health/input_Birthdate'), 'value', '', 1)

WebUI.click(findTestObject('web/Page_Lore Health/div_Home'))

WebUI.delay(2)

WebUI.callTestCase(findTestCase('web/utils/close_browser'), [:], FailureHandling.STOP_ON_FAILURE)

