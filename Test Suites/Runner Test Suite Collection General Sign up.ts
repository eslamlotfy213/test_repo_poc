<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteCollectionEntity>
   <description></description>
   <name>Runner Test Suite Collection General Sign up</name>
   <tag></tag>
   <delayBetweenInstances>0</delayBetweenInstances>
   <executionMode>SEQUENTIAL</executionMode>
   <maxConcurrentInstances>8</maxConcurrentInstances>
   <testSuiteRunConfigurations>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Custom</groupName>
            <profileName>Android Profile</profileName>
            <requireConfigurationData>false</requireConfigurationData>
            <runConfigurationId>android_s2!_remote</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/Validation Test Suite Sign up</testSuiteEntity>
      </TestSuiteRunConfiguration>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Web Desktop</groupName>
            <profileName>IOS Profile</profileName>
            <requireConfigurationData>false</requireConfigurationData>
            <runConfigurationId>Remote</runConfigurationId>
         </configuration>
         <runEnabled>false</runEnabled>
         <testSuiteEntity>Test Suites/Validation Test Suite Sign up</testSuiteEntity>
      </TestSuiteRunConfiguration>
   </testSuiteRunConfigurations>
</TestSuiteCollectionEntity>
