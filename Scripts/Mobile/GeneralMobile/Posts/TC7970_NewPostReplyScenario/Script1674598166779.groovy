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
import com.sun.org.apache.bcel.internal.classfile.LocalVariable as LocalVariable
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
 * TC ID: 7970
 * TC Description: As a Guest User, I need to be able to Reply a new post after Sign In
 * Scenario
	* Login
	* Go to your profile & Create a new post
	* Sign out
	* Go to Home
	* Search for the created new post and open it
	* Reply on the post as Guest
	* Sign in
	* Assert the same post is opened after sign in
	* Reply to the post
	* Assert reply is displayed
 */
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/LaunchApp'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/GoToProfileAndPressSignIn'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/SignIn'), [:], FailureHandling.STOP_ON_FAILURE)

String postTitle = 'Testing Automation ' + GlobalVariable.TodayDate

//Add new Post
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_ProfileMenuIcon'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Profile/Button_NewProfilePost'), GlobalVariable.WaitPeriod)

Mobile.setText(findTestObject('Object Repository/Mobile/General/NewPost/Text_PostTitle'), postTitle, 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/NewPost/Text_FirstPostDetails'), postTitle, 0)

Mobile.scrollToText('Review Post')

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewPost/Button_SavingPost'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'), GlobalVariable.WaitPeriod)

//Sign out
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/Signout'), [:], FailureHandling.STOP_ON_FAILURE)

//Home & Search for the post
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'), GlobalVariable.WaitPeriod)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Home/Label_HomeForMe'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'), GlobalVariable.WaitPeriod)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Home/Label_HomeForMe'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'), GlobalVariable.WaitPeriod)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Home/Label_HomeForMe'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Home/Button_HomeSearch'), 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Home/Text_HomeSearch'), 'Testing Automation ' + GlobalVariable.TodayDate, 0)

Mobile.delay(20)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Home/Image_SearchIcon'), GlobalVariable.WaitPeriod)

Mobile.waitForElementPresent(findTestObject('Mobile/General/Home/Label_FirstPostSearchResult'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Mobile/General/Home/Label_FirstPostSearchResult'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/ReplyPost/Button_CreateAnAccount'), GlobalVariable.WaitPeriod)

Mobile.scrollToText('Create an account')

Mobile.tap(findTestObject('Mobile/General/ReplyPost/Label_REPLYPostGuest'), 0)

WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/SignIn'), [:], FailureHandling.STOP_ON_FAILURE)

//Replying on the post
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/ReplyPost/Text_ReplyMessageContainer'), GlobalVariable.WaitPeriod)

Mobile.scrollToText('Testing new features')

String displayedPostTitle = Mobile.getText(findTestObject('Object Repository/Mobile/General/ReplyPost/Label_DisplayedPostTitle'), 
    GlobalVariable.WaitPeriod)

Mobile.verifyEqual(displayedPostTitle, postTitle)

Mobile.tap(findTestObject('Object Repository/Mobile/General/ReplyPost/Button_ReplyOnPost'), GlobalVariable.WaitPeriod)

Mobile.setText(findTestObject('Object Repository/Mobile/General/ReplyPost/Text_ReplyPostText'), 'Testing Automation Reply', 0)

Mobile.scrollToText('Reply')

Mobile.tap(findTestObject('Object Repository/Mobile/General/ReplyPost/Button_SaveReply'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/ReplyPost/Label_PostReplyValue'), GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/ReplyPost/Label_PostReplyValue'), GlobalVariable.WaitPeriod)

//Sign out
WebUI.callTestCase(findTestCase('Mobile/GeneralMobile/Common Scripts/Signout'), [MoveToY:1800], FailureHandling.STOP_ON_FAILURE)

//Close App
Mobile.closeApplication()

