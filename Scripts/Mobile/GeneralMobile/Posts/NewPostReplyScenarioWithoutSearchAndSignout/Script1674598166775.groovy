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
import com.sun.org.apache.bcel.internal.classfile.LocalVariable

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


Date today = new Date()

GlobalVariable.TodayDate =  today.format('dd/MM/yyyy HH:mm:ss')

Mobile.startExistingApplication(GlobalVariable.ApplicationID)

//Sign in
Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_ProfileMenuIcon'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Profile/Button_ProfileSign In'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/Signin/Button_ContinueSignin'), GlobalVariable.WaitPeriod)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signin/Text_SigninUsername'), GlobalVariable.Username, 0)

Mobile.setText(findTestObject('Object Repository/Mobile/General/Signin/Text_SigninPassword'), GlobalVariable.Password, 0)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Signin/Button_ContinueSignin'), 0)

//Add new Post
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_HomeMenuIcon'), GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/MenuIcons/Button_ProfileMenuIcon'),  GlobalVariable.WaitPeriod)

Mobile.tap(findTestObject('Object Repository/Mobile/General/Profile/Button_NewProfilePost'),  GlobalVariable.WaitPeriod)

Mobile.sendKeys(findTestObject('Object Repository/Mobile/General/NewPost/Text_PostTitle'), 'Testing Automation ' + GlobalVariable.TodayDate)

Mobile.sendKeys(findTestObject('Object Repository/Mobile/General/NewPost/Text_FirstPostDetails'), 'Testing Automation ' + GlobalVariable.TodayDate)

Mobile.scrollToText('Review Post')

Mobile.tap(findTestObject('Object Repository/Mobile/General/NewPost/Button_SavingPost'), 0)

//Replying on the post
Mobile.scrollToText('Testing Automation ' + GlobalVariable.TodayDate)

Mobile.tap(findTestObject('Object Repository/Mobile/General/ReplyPost/Button_ReplyOnPost'), GlobalVariable.WaitPeriod)

Mobile.sendKeys(findTestObject('Object Repository/Mobile/General/ReplyPost/Text_ReplyPostText'), 'Testing Automation Reply')

Mobile.scrollToText('Reply')

Mobile.delay(10)

Mobile.tap(findTestObject('Object Repository/Mobile/General/ReplyPost/Button_SaveReply'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/General/ReplyPost/Label_PostReplyValue'), GlobalVariable.WaitPeriod)

Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/General/ReplyPost/Label_PostReplyValue'), GlobalVariable.WaitPeriod)

Mobile.closeApplication()
