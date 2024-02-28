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

/*
 * TC ID: 8010
 * TC Description: As a User, I need to be able to Reply a new message
 * Scenario
	* Login with Message Sender user
	* Go to Messages & Create a new message
	* Send Message to Message Receiver user
	* Assert Message is Displayed
	* Sign out & sign in with the Message Receiver user
	* Go to Messages
	* Assert Message is Displayed
	* Open Message & Reply 
	* Assert Reply is Displayed 
	* Sign out & sign in with the Message Sender user
	* Go to Messages & Open the Message
	* Assert Reply is displayed 
 */

//Reciever Account Data
Date today = new Date()
GlobalVariable.TodayDate = today.format('dd/MM/yyyy HH:mm:ss')
String recieverDisplayName = '3lotfy'
String recieverUser = 'elotfy@sequel.ae'
String recieverPassword ='user123#'

//Sign in
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/LaunchApp'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/GoToProfileAndPressSignIn'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/SignIn'), [:], FailureHandling.STOP_ON_FAILURE)

//Send Message & Assert its display 
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'),
	GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_MessagesMenuIcon'), GlobalVariable.WaitPeriod)
Mobile.swipe(600, 1900, 600, 1800)

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/Label_PlusNewMessage'), 0) //new message button

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/View_MessageReciever'), 0) //reciever container

Mobile.setText(findTestObject('Object Repository/Mobile/General/NewMessage/Text_MessageReciever'), recieverDisplayName, 0) //reciever text

GlobalVariable.MessageUser = recieverDisplayName

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/TextView_RecieverMessageDDL'), 0) //pick from ddl

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/Text_NewMessageTitle'), 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/NewMessage/Text_NewMessageTitle'), 'S '+ GlobalVariable.TodayDate, 0)

Mobile.swipe(600, 800, 600, 500)

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/Text_NewMessageSubject'), 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/NewMessage/Text_NewMessageSubject'), 'M '+ GlobalVariable.TodayDate, 0)

Mobile.swipe(600, 800, 600, 550)

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/Label_NewMessageSend'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/NewMessage/Label_PlusNewMessage'), GlobalVariable.WaitPeriod) 

GlobalVariable.MessageUser = recieverDisplayName

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/NewMessage/View_MessageUsername'),
	GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/NewMessage/Label_MessageSubject'),
	GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/NewMessage/Label_MessageDetails'),
	GlobalVariable.WaitPeriod)

//Sign out 
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/Signout'),[MoveToY:1800], FailureHandling.STOP_ON_FAILURE)

//Login with reciever data 
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_MessagesMenuIcon'),
	GlobalVariable.WaitPeriod)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/GoToProfileAndPressSignIn'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/SignIn'), [('Username') : recieverUser, ('Password') : recieverPassword], FailureHandling.STOP_ON_FAILURE)

//Navigate to messages & assert message exists
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'),
	GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_MessagesMenuIcon'), GlobalVariable.WaitPeriod)

GlobalVariable.MessageUser = GlobalVariable.DisplayName

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/NewMessage/View_MessageUsername'), GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/NewMessage/Label_MessageSubject'),
	GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/NewMessage/Label_MessageDetails'),
	GlobalVariable.WaitPeriod)

//Open Message & reply 
Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/View_MessageUsername'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/ReplyMessage/Text_ReplyMessageContainer'), GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/ReplyMessage/Label_OpenedMessageDetails'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/ReplyMessage/Text_ReplyMessageContainer'), 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/ReplyMessage/Text_ReplyMessageText'), 'Message Reply', 0)

Mobile.tap(findTestObject('Object Repository/Mobile/General/ReplyMessage/Label_ReplyMessageButton'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/ReplyMessage/Label_ReplyMessageDisplayed'), GlobalVariable.WaitPeriod)


//Sign out 
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/Signout'), [MoveToY:1800], FailureHandling.STOP_ON_FAILURE)

//Login in with Sender data
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_MessagesMenuIcon'),
	GlobalVariable.WaitPeriod)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/GoToProfileAndPressSignIn'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/SignIn'), [:], FailureHandling.STOP_ON_FAILURE)

//Open Message & Check Reply is displayed 
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'),
	GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_MessagesMenuIcon'), 0)

GlobalVariable.MessageUser = recieverDisplayName

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewMessage/View_MessageUsername'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/ReplyMessage/Label_OpenedMessageDetails'), GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/ReplyMessage/Label_ReplyMessageDisplayed'), GlobalVariable.WaitPeriod)

//Sign out
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/Signout'),[:], FailureHandling.STOP_ON_FAILURE)

//Close App
Mobile.closeApplication()

